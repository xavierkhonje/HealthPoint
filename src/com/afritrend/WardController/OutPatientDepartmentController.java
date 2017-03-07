/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardController;

import com.afritrend.PharmacyDataAccess.OPDPrescriptionDataAccess;
import com.afritrend.PharmacyModel.OPDPrescriptionModel;
import com.afritrend.WardDataAccess.PatientDataAcess;
import com.afritrend.WardModel.patientModel;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utility.Barcoder;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class OutPatientDepartmentController implements Initializable {

    @FXML
    TableView PatientTV;
    
    @FXML
    BorderPane MainBorderPane;     
    
    @FXML
    TextField txtPatientNumber;
    
    @FXML
    TextField txtFirstName;
    
    @FXML
    TextField txtLastName;
    
    @FXML
    TextField txtOtherName;
    
    @FXML
    MenuItem mnuPrescribe;    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
   
    }    
    
    @FXML
    private void saveprescription(ActionEvent event)
    {
        OPDPrescriptionModel OPDModel = new OPDPrescriptionModel();
        OPDModel.setPatientNo("ID0000001");
        OPDModel.setCmsCode("AA000300");
        OPDModel.setAdmissionCode("PO");
        OPDModel.setFrequency(3);
        
        Barcoder.BarcodeCreate(OPDModel.getPatientNo());
        
        File ff = new File("C:\\EDMSFOLDER\\QRCode.png");
        String img = ff.getAbsolutePath();

        OPDPrescriptionDataAccess opdao = new OPDPrescriptionDataAccess();
       String feedback = opdao.SavePrescription(OPDModel, img);
       System.out.println(feedback);
    }
    
    @FXML
    private void GetOPDPrescriptions(ActionEvent event)
    {
        OPDPrescriptionDataAccess opdao = new OPDPrescriptionDataAccess();        
        opdao.GetPatientPrescription("ID0000001","00001");
        
        testchangescene();
    }
    
    @FXML
    private void PatientSelect_DrugPrescribe(MouseEvent event)
    {
        try 
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/OPDPrescription.fxml"));            
            MainBorderPane.setCenter(root);        
            
//            Scene Prescription = new Scene(root);
//            Stage stage = (Stage)PatientTV.getScene().getWindow();
//            stage.setScene(Prescription);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(OutPatientDepartmentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void SearchPatients(ActionEvent event)
    {
        String patientNumber = txtPatientNumber.getText();
        String FirstName = txtFirstName.getText();
        String LastName = txtLastName.getText();
        String OtherName = txtOtherName.getText();
        
        patientModel patient = new patientModel();
        
        patient.setPatientID(patientNumber);
        patient.setFirstname(FirstName);
        patient.setLastname(LastName);
        patient.setOthernames(OtherName);
        
        List<patientModel> list = new ArrayList();
        
        PatientDataAcess patientdao = new PatientDataAcess();
        list = patientdao.GetPatients(patient.getFirstname(), patient.getOthernames(), patient.getLastname(), patient.getPatientID());
                
        ShowPatients(list);
    }
    
    @FXML
    private void SelectPatient(MouseEvent event)
    {
        try 
        {
            patientModel patient = (patientModel)PatientTV.getSelectionModel().getSelectedItem();
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/OPDPrescription.fxml")); 
            MainBorderPane.setCenter(root);
        } 
        catch (Exception ex) 
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public void ShowWardDetailsModal(patientModel patient)
    {        
        try
        {
            FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/OPDPrescription.fxml"));
            Parent root = fxloader.load();
            
            
            
            OPDPrescriptionController controller = fxloader.<OPDPrescriptionController>getController();                      
            controller.initData(patient);

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);            
            stage.showAndWait();
        }
        catch(Exception e)            
        {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            e.printStackTrace();
        }         
    }    
    
    public void ShowPatients(List<patientModel> list)
    {
        
        ObservableList<patientModel> itemsobs = FXCollections.observableArrayList();  

        TableColumn<patientModel, String> PatientNumberColumn = new TableColumn<>("Patient Number");
        PatientNumberColumn.setMinWidth (200);    
        PatientNumberColumn.setCellValueFactory(new PropertyValueFactory<>("patientID"));  

        TableColumn<patientModel, String> FirstNameCLM = new TableColumn<>("First Name");
        FirstNameCLM.setMinWidth (200);    
        FirstNameCLM.setCellValueFactory(new PropertyValueFactory<>("firstname"));      

        TableColumn<patientModel, String> OtheNameCLM = new TableColumn<>("Other Name");
        OtheNameCLM.setMinWidth (200);    
        OtheNameCLM.setCellValueFactory(new PropertyValueFactory<>("othernames")); 

        TableColumn<patientModel, String> LastNameCLM = new TableColumn<>("Last Name");        
        LastNameCLM.setMinWidth (200);    
        LastNameCLM.setCellValueFactory(new PropertyValueFactory<>("lastname"));                     

        TableColumn<patientModel, String> TelNumberCLM = new TableColumn<>("Tel Number");
        TelNumberCLM.setMinWidth (200);    
        TelNumberCLM.setCellValueFactory(new PropertyValueFactory<>("telNumber"));  

        TableColumn<patientModel, String> CellNumberCLM = new TableColumn<>("Cell Number");
        CellNumberCLM.setMinWidth (200);    
        CellNumberCLM.setCellValueFactory(new PropertyValueFactory<>("celNumber"));  

        TableColumn<patientModel, String> Address1CLM = new TableColumn<>("Address 1");
        Address1CLM.setMinWidth (200);    
        Address1CLM.setCellValueFactory(new PropertyValueFactory<>("address1"));      

        TableColumn<patientModel, String> Address2CLM = new TableColumn<>("Address 2");
        Address2CLM.setMinWidth (200);    
        Address2CLM.setCellValueFactory(new PropertyValueFactory<>("address2")); 

        TableColumn<patientModel, String> HospitalNameCLM = new TableColumn<>("Hospital Name");        
        HospitalNameCLM.setMinWidth (200);    
        HospitalNameCLM.setCellValueFactory(new PropertyValueFactory<>("hospitalName"));                     

        TableColumn<patientModel, String> WardNameCLM = new TableColumn<>("Ward Name");
        WardNameCLM.setMinWidth (200);    
        WardNameCLM.setCellValueFactory(new PropertyValueFactory<>("wardName"));  

        TableColumn<patientModel, String> WardDPTCLM = new TableColumn<>("WardDPT");
        WardDPTCLM.setMinWidth (200);    
        WardDPTCLM.setCellValueFactory(new PropertyValueFactory<>("wardDptName"));                     

        Iterator<patientModel> pit = list.iterator();
        while(pit.hasNext())
        {
            patientModel patient = new patientModel();
            patient = pit.next();

            itemsobs.add(new patientModel(
                    patient.getPatientID(),
                    patient.getFirstname(),
                    patient.getOthernames(),
                    patient.getLastname(),
                    patient.getTelNumber(),
                    patient.getCelNumber(),
                    patient.getAddress1(),
                    patient.getAddress2(),
                    patient.getImage(),
                    patient.getHospitalName(),
                    patient.getWardName(),
                    patient.getWardDptName()));                
        }

        PatientTV.getColumns().clear();
        PatientTV.setItems(itemsobs);
        PatientTV.getColumns().addAll(
                PatientNumberColumn,FirstNameCLM,OtheNameCLM,
                LastNameCLM,TelNumberCLM,CellNumberCLM,
                Address1CLM,Address2CLM,HospitalNameCLM,WardNameCLM,WardDPTCLM);          
    }
    
    private void testchangescene()
    {
        try 
        {
            Stage stage = (Stage)PatientTV.getScene().getWindow();
            
            
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/OPDPrescription.fxml"));            
            MainBorderPane.setCenter(root);             
            
//            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/OPDPrescription.fxml"));
//            Scene Prescription = new Scene(root);
//            Stage stage = (Stage)PatientTV.getScene().getWindow();
//            stage.setScene(Prescription);
        } 
        catch (Exception ex) 
        {
            System.out.println(ex.getMessage());
        }        
    }
    
}
