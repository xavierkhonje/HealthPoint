/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.Ward.Inpatient.Controller;

import com.afritrend.WardModel.patientModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class InPatientChartController implements Initializable {

    @FXML
    Label lblPatientID;
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
    
}
