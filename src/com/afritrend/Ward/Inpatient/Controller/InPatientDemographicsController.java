/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.Ward.Inpatient.Controller;

import com.afritrend.Ward.Inpatient.Model.DemographicsModel;
import com.afritrend.WardModel.patientModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class InPatientDemographicsController implements Initializable {

    @FXML
    Label lblPatientID;
    
    @FXML
    DatePicker idDOB,dpDateofAdmission;
    
    @FXML
    TextField txtAge,txtCultureAssessment,txtCultureResult;
    
    @FXML
    ComboBox cbGender;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        
    public void initData(patientModel patient)
    {
        lblPatientID.setText(patient.getPatientID());
    }       
    
    @FXML
    private void SaveDemographics(ActionEvent event)
    {
        String DateofBirth = String.valueOf(idDOB.getValue());
        int Age = Integer.valueOf(txtAge.getText());
        String DateOfAdmission = String.valueOf(dpDateofAdmission.getValue());
        String Gender = String.valueOf(cbGender.getValue());
        String CultureAssessment = txtCultureAssessment.getText();
        String CultureResults = txtCultureResult.getText();
        
        DemographicsModel demographics = new DemographicsModel();
        demographics.setDateofbirth(DateofBirth);
        demographics.setAge(Age);
        demographics.setDateofadmission(DateOfAdmission);
        demographics.setGender(Gender);
        demographics.setCultureAssessment(CultureAssessment);
        demographics.setCultureResults(CultureResults);
        
        
        
    }
    
}
