/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardController;

import com.afritrend.Ward.Inpatient.Controller.InPatientAdmittanceController;
import com.afritrend.Ward.Inpatient.Controller.InPatientChartController;
import com.afritrend.Ward.Inpatient.Controller.InPatientCormobiditiesController;
import com.afritrend.Ward.Inpatient.Controller.InPatientDemographicsController;
import com.afritrend.Ward.Inpatient.Controller.InPatientDischargeController;
import com.afritrend.Ward.Inpatient.Controller.InPatientDrugAdministrationController;
import com.afritrend.Ward.Inpatient.Controller.InPatientDrugPrescriptionController;
import com.afritrend.Ward.Inpatient.Controller.InPatientGuardianController;
import com.afritrend.Ward.Inpatient.Controller.InPatientHistoryArchiveController;
import com.afritrend.Ward.Inpatient.Controller.InPatientHomeMedicationController;
import com.afritrend.Ward.Inpatient.Controller.InPatientLaboratoryController;
import com.afritrend.Ward.Inpatient.Controller.InPatientMedicalHistoryController;
import com.afritrend.Ward.Inpatient.Controller.InPatientPhysiologyController;
import com.afritrend.Ward.Inpatient.Controller.InPatientSpecialAntimicrobialsController;
import com.afritrend.Ward.Inpatient.Controller.InPatientToTakeHomeController;
import com.afritrend.Ward.Inpatient.Controller.WorkWithPatientController;
import com.afritrend.WardDataAccess.PatientDataAcess;
import com.afritrend.WardModel.patientModel;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class InPatientDashboardController implements Initializable {

    @FXML
    TableView PatientTV;
    
    @FXML
    TextField txtPatientNumber;
    /**
     * Initializes the controller class.
     * All Functionalities under the patient will come here, such as
     * 1. Patient Prescription
     * 2. Patient Administration
     * 3. Patient Medical History
     * 4. Patient Home Medications
     * 5. Patient Chart 
     * 6. Patient Demographics
     * 7. Special Antimicrobials
     * 8. To Take Home
     * 9. Patient Admittance - Including bed scheduling
     * 10. Patient Discharge
     * 11. Cormobidities
     * 12. Patient Physiology
     * 13. Patient Lab Test
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void showAlert()
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Patient not Selected");
        alert.setHeaderText("Alert");
        alert.setContentText("Select patient First");
        alert.showAndWait();        
    }
    
    @FXML
    private void Prescription(ActionEvent event)
    {
        //on administration we will use drug class to choose which medication to administer
        try
        {
            patientModel patient = new patientModel();
            patient = (patientModel)PatientTV.getSelectionModel().getSelectedItem();
            if(patient == null)
            {
                showAlert();
            }
            else
            {
                FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/Inpatient/View/InPatientDrugPrescription.fxml"));
                Parent root = fxloader.load();

                InPatientDrugPrescriptionController controller = fxloader.<InPatientDrugPrescriptionController>getController();                      
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
    
    @FXML
    private void DrugAdministration(ActionEvent event)
    {
        try
        {
            patientModel patient = new patientModel();
            patient = (patientModel)PatientTV.getSelectionModel().getSelectedItem();
            
            if(patient == null)
            {
                showAlert();
            }
            else
            {                        
                FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/Inpatient/View/InPatientDrugAdministration.fxml"));
                Parent root = fxloader.load();

                InPatientDrugAdministrationController controller = fxloader.<InPatientDrugAdministrationController>getController();                      
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
    
    @FXML
    private void PatientMedicalHistory(ActionEvent event)
    {
        try
        {
            patientModel patient = new patientModel();
            patient = (patientModel)PatientTV.getSelectionModel().getSelectedItem();                
            
            if(patient == null)
            {
                showAlert();
            }
            else
            {                               
                FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/Inpatient/View/InPatientMedicalHistory.fxml"));
                Parent root = fxloader.load();

                InPatientMedicalHistoryController controller = fxloader.<InPatientMedicalHistoryController>getController();                      
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
    
    @FXML
    private void HomeMedication(ActionEvent event)
    {
        try
        {
            patientModel patient = new patientModel();
            patient = (patientModel)PatientTV.getSelectionModel().getSelectedItem();              
            
            if(patient == null)
            {
                showAlert();
            }
            else
            {              
                FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/Inpatient/View/InPatientHomeMedication.fxml"));
                Parent root = fxloader.load();

                InPatientHomeMedicationController controller = fxloader.<InPatientHomeMedicationController>getController();                      
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
    
    @FXML
    private void PatientChart(ActionEvent event)
    {
        try
        {
            patientModel patient = new patientModel();
            patient = (patientModel)PatientTV.getSelectionModel().getSelectedItem();  
            
            if(patient == null)
            {
                showAlert();
            }
            else
            {                                     
                FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/Inpatient/View/InPatientChart.fxml"));
                Parent root = fxloader.load();

                InPatientChartController controller = fxloader.<InPatientChartController>getController();                      
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
    
    @FXML
    private void PatientDemographics(ActionEvent event)
    {
        try
        {
            patientModel patient = new patientModel();
            patient = (patientModel)PatientTV.getSelectionModel().getSelectedItem();              
            
            
            if(patient == null)
            {
                showAlert();
            }
            else
            {              
                FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/Inpatient/View/InPatientDemographics.fxml"));
                Parent root = fxloader.load();

                InPatientDemographicsController controller = fxloader.<InPatientDemographicsController>getController();                      
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
    
    @FXML
    private void SpecialAntimicrobials(ActionEvent event)
    {
        try
        {
            patientModel patient = new patientModel();
            patient = (patientModel)PatientTV.getSelectionModel().getSelectedItem();              
            
            if(patient == null)
            {
                showAlert();
            }
            else
            {             
                FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/Inpatient/View/InPatientSpecialAntimicrobials.fxml"));
                Parent root = fxloader.load();

                InPatientSpecialAntimicrobialsController controller = fxloader.<InPatientSpecialAntimicrobialsController>getController();                      
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
    
    @FXML
    private void ToTakeHome(ActionEvent event)
    {
        try
        {
            patientModel patient = new patientModel();
            patient = (patientModel)PatientTV.getSelectionModel().getSelectedItem();            
            
            if(patient == null)
            {
                showAlert();
            }
            else
            {                
                FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/Inpatient/View/InPatientToTakeHome.fxml"));
                Parent root = fxloader.load();

                InPatientToTakeHomeController controller = fxloader.<InPatientToTakeHomeController>getController();                      
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
    
    @FXML
    private void PatientAdmit(ActionEvent event)
    {
        try
        {
            patientModel patient = new patientModel();
            patient = (patientModel)PatientTV.getSelectionModel().getSelectedItem();              
            
            if(patient == null)
            {
                showAlert();
            }
            else
            {                
                FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/Inpatient/View/InPatientAdmittance.fxml"));
                Parent root = fxloader.load();

                InPatientAdmittanceController controller = fxloader.<InPatientAdmittanceController>getController();                      
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
    
    @FXML
    private void PatientDischarge(ActionEvent event)
    {
        //when you discharge a patient provide options such as, follow up on patient. transfer patient to another hospital
        //so that there transfer data is sent to the other hospital or clinic.
        //provide information on bill payments outstanding if available.
        //in case of criminal involvement, produce a report to sent out
        try
        {
            patientModel patient = new patientModel();
            patient = (patientModel)PatientTV.getSelectionModel().getSelectedItem();              
            
            if(patient == null)
            {
                showAlert();
            }
            else
            {                
                FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/Inpatient/View/InPatientDischarge.fxml"));
                Parent root = fxloader.load();

                InPatientDischargeController controller = fxloader.<InPatientDischargeController>getController();                      
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
    
    @FXML
    private void HomeMedications(ActionEvent event)
    {
        try
        {
            patientModel patient = new patientModel();
            patient = (patientModel)PatientTV.getSelectionModel().getSelectedItem();              
            if(patient == null)
            {
                showAlert();
            }
            else
            {                
                FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/Inpatient/View/InPatientHomeMedication.fxml"));
                Parent root = fxloader.load();

                InPatientHomeMedicationController controller = fxloader.<InPatientHomeMedicationController>getController();                      
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
    
    @FXML
    private void Cormobidities(ActionEvent event)
    {
        try
        {
            patientModel patient = new patientModel();
            patient = (patientModel)PatientTV.getSelectionModel().getSelectedItem();            
            if(patient == null)
            {
                showAlert();
            }
            else
            {                
                FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/Inpatient/View/InPatientCormobidities.fxml"));
                Parent root = fxloader.load();

                InPatientCormobiditiesController controller = fxloader.<InPatientCormobiditiesController>getController();                      
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
    
    @FXML
    private void PatientHistoryArchive(ActionEvent event)
    {
        try
        {
            patientModel patient = new patientModel();
            patient = (patientModel)PatientTV.getSelectionModel().getSelectedItem();             
            if(patient == null)
            {
                showAlert();
            }
            else
            {                
                FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/Inpatient/View/InPatientHistoryArchive.fxml"));
                Parent root = fxloader.load();

                InPatientHistoryArchiveController controller = fxloader.<InPatientHistoryArchiveController>getController();                      
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
    
    @FXML
    private void PatientPhysiology(ActionEvent event)
    {
        try
        {
            patientModel patient = new patientModel();
            patient = (patientModel)PatientTV.getSelectionModel().getSelectedItem();             
            if(patient == null)
            {
                showAlert();
            }
            else
            {                
                FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/Inpatient/View/InPatientPhysiology.fxml"));
                Parent root = fxloader.load();

                InPatientPhysiologyController controller = fxloader.<InPatientPhysiologyController>getController();                      
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
    
    @FXML
    private void PatientLaboratory(ActionEvent event)
    {
        try
        {
            patientModel patient = new patientModel();
            patient = (patientModel)PatientTV.getSelectionModel().getSelectedItem();             
            if(patient == null)
            {
                showAlert();
            }
            else
            {                
                FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/Inpatient/View/InPatientLaboratory.fxml"));
                Parent root = fxloader.load();

                InPatientLaboratoryController controller = fxloader.<InPatientLaboratoryController>getController();                      
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
    
    @FXML
    private void ShowGuardian(ActionEvent event)
    {
        try
        {
            patientModel patient = new patientModel();
            patient = (patientModel)PatientTV.getSelectionModel().getSelectedItem();  
            
            if(patient == null)
            {
                showAlert();
            }
            else
            {                
                FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/Inpatient/View/InPatientGuardian.fxml"));
                Parent root = fxloader.load();

                InPatientGuardianController controller = fxloader.<InPatientGuardianController>getController();                      
                controller.initData(patient);

                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);            
                stage.showAndWait();
            }
        }
        catch(NullPointerException npe)
        {
            System.out.println("User not selected");
        }
        catch(Exception e)            
        {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            e.printStackTrace();
        }        
    }
    
    @FXML
    private void SearchPatient(ActionEvent event)
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
    
    @FXML
    private void WorkWithPatient(ActionEvent event)
    {
        try
        {
            patientModel patient = new patientModel();
            patient = (patientModel)PatientTV.getSelectionModel().getSelectedItem();              
            if(patient == null)
            {
                showAlert();
            }
            else
            {                
                FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/Inpatient/View/WorkWithPatient.fxml"));
                Parent root = fxloader.load();

                WorkWithPatientController controller = fxloader.<WorkWithPatientController>getController();                      
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
                PatientNumberColumn,FirstNameCLM);          
    }
    
}
