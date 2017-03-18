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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    TextField txtGr_firstname,txtGr_Othernames,txtGr_Lastname,txtGr_RelationShipType;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
}
