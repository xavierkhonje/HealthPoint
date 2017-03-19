/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardController;

import com.afritrend.WardDataAccess.PatientDataAcess;
import com.afritrend.WardModel.GuardianModel;
import com.afritrend.WardModel.patientModel;
import com.afritrend.common.Model.SessionManagement;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class NewPatientController implements Initializable {
    @FXML
    Label fnameError;
    
    @FXML
    Label OtherNamesError;
    
    @FXML
    Label LastNameError;
    
    @FXML
    Label TelNumberError;
    
    @FXML
    Label CellNumberError;
    
    @FXML
    Label Address1Error;
    
    @FXML
    Label Address2Error;
    
    @FXML
    TextField txtFirstName;
    
    @FXML 
    TextField txtOtherNames;
    
    @FXML
    TextField txtLastName;
    
    @FXML
    TextField txtTelNumber;
    
    @FXML
    TextField txtCelNumber;
    
    @FXML
    TextArea txtAddress1;
    
    @FXML
    TextArea txtAddress2;
    
    @FXML
    ImageView imageimg;
    
    @FXML
    Label lblGeneralError;
    
    @FXML
    Label txtGrFirstnameError;
    
    @FXML
    Label txtGrOtherNamesError;
    
    @FXML
    Label txtLastNameError;
    
    @FXML
    Label txtRelationShipType;
    
    @FXML
    TextField txtGr_firstname,txtGr_Othernames,txtGr_Lastname,txtGr_RelationShipType,txtPatientNumber;
    
    @FXML
    ComboBox cbPaymentMethod;
    
    @FXML
    TableView TVPatient;
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbPaymentMethod.getItems().addAll("Cash","Company","Insurance");
    }    
    
    public void ImageCapture(ActionEvent event)
    {
        try
        {            
            FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/HealthPoint/FrontDesk/View/Webcam.fxml"));
            Parent root = fxloader.load();                      
            
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }
        catch(Exception e)            
        {
            System.out.println(e.getMessage());
        }          
    }
    
    @FXML
    public void SavePatient(ActionEvent event)
    {
        try
        {
            patientModel patient = new patientModel();
            
            patient.setFirstname(txtFirstName.getText());
            patient.setOthernames(txtOtherNames.getText());
            patient.setLastname(txtLastName.getText());
            patient.setTelNumber(txtTelNumber.getText());
            patient.setCelNumber(txtCelNumber.getText());
            patient.setAddress1(txtAddress1.getText());
            patient.setAddress2(txtAddress2.getText());
            patient.setImage("test");
            patient.setHospitalName("QECH");
            patient.setWardName(SessionManagement._wardName);
            patient.setWardDptName("MEDICAL");           
            
            String Flag = "WHITE";           
            
            if(patient.validatePatient())
            {               

                    File file = new File("C:\\Myimages\\capturedimage.jpg");
                    Image img = new Image(file.toURI().toURL().toExternalForm());                  
                    imageimg.setImage(img);

                    fnameError.setText("");
                    OtherNamesError.setText("");
                    LastNameError.setText("");
                    TelNumberError.setText("");
                    CellNumberError.setText("");
                    Address1Error.setText("");
                    Address2Error.setText("");                                                                    
            }
            else
            {

                
                Flag = "RED";
                //Show the errors
                fnameError.setText(patient.firstnameError);
                OtherNamesError.setText(patient.othernamesError);
                LastNameError.setText(patient.lastnameError);
                TelNumberError.setText(patient.telNumberError);
                CellNumberError.setText(patient.celNumberError);
                Address1Error.setText(patient.address1Error);
                Address2Error.setText(patient.address2Error);
                
                
            }

            if(Flag.equals("RED"))
            {
                lblGeneralError.setText("Fix Errors Above");
            }
            else
            {
                PatientDataAcess patientdao = new PatientDataAcess();
                String response = patientdao.PatientRegistration(patient);

                lblGeneralError.setText(response);                       
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }    
    
    @FXML
    private void ProcessPaymentDetails()
    {
        String PaymentMethod = String.valueOf(cbPaymentMethod.getValue());
        if(PaymentMethod.equals("Cash"))
        {
            try
            {
                patientModel patient = new patientModel();
                patient = (patientModel)TVPatient.getSelectionModel().getSelectedItem();              


                if(patient == null)
                {
                    showAlert();
                }
                else
                {              
                    FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/CashPayment.fxml"));
                    Parent root = fxloader.load();

                    CashPaymentController controller = fxloader.<CashPaymentController>getController();                      
                    controller.initData(patient);

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.initModality(Modality.APPLICATION_MODAL);            
                    stage.showAndWait();//4057
                }
            }
            catch(Exception e)            
            {
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                e.printStackTrace();
            } 
        }
        else if(PaymentMethod.equals("Company"))
        {
            try
            {
                patientModel patient = new patientModel();
                patient = (patientModel)TVPatient.getSelectionModel().getSelectedItem();              


                if(patient == null)
                {
                    showAlert();
                }
                else
                {              
                    FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/CompanyPayment.fxml"));
                    Parent root = fxloader.load();

                    CompanyPaymentController controller = fxloader.<CompanyPaymentController>getController();                      
                    controller.initData(patient);

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.initModality(Modality.APPLICATION_MODAL);            
                    stage.showAndWait();//4057
                }
            }
            catch(Exception e)            
            {
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                e.printStackTrace();
            }             
        }
        else if(PaymentMethod.equals("Insurance"))
        {
            try
            {
                patientModel patient = new patientModel();
                patient = (patientModel)TVPatient.getSelectionModel().getSelectedItem();              


                if(patient == null)
                {
                    showAlert();
                }
                else
                {              
                    FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/InsurancePayment.fxml"));
                    Parent root = fxloader.load();

                    InsurancePaymentController controller = fxloader.<InsurancePaymentController>getController();                      
                    controller.initData(patient);

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.initModality(Modality.APPLICATION_MODAL);            
                    stage.showAndWait();//4057
                }
            }
            catch(Exception e)            
            {
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                e.printStackTrace();
            }             
        }        
    }
    
    
    @FXML
    private void GetAllPatients(ActionEvent event)
    {
        try
        {
            patientModel patient = new patientModel();
            String PatientNum = txtPatientNumber.getText();
            patient.setPatientID(PatientNum);
            patient.setFirstname("");
            patient.setLastname("");
            patient.setOthernames("");            

            List<patientModel> list = new ArrayList();

            PatientDataAcess patientdao = new PatientDataAcess();
            list = patientdao.GetPatients(patient.getFirstname(), patient.getOthernames(), patient.getLastname(), patient.getPatientID());
            
            ShowPatients(list);    
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
        public void showAlert()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Patient not Selected");
        alert.setHeaderText("Alert");
        alert.setContentText("Select patient First");
        alert.showAndWait();        
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

        TVPatient.getColumns().clear();
        TVPatient.setItems(itemsobs);
        TVPatient.getColumns().addAll(
                PatientNumberColumn,FirstNameCLM);          
    }        
        
}
