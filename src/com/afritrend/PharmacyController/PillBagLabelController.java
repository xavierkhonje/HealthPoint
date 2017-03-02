/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.PharmacyModel.OPDPrescriptionModel;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class PillBagLabelController implements Initializable {

    @FXML
    Label lblPatientName;
    
    @FXML
    Label lblDrugName;
    
    @FXML
    Label lblQty;
    
    @FXML
    Label lblTabCap;
        
    @FXML
    Label lblTimeADay;
    
    @FXML
    Label lblDate;
    
    @FXML
    Label lblPrescriptionNo;
    
    @FXML
    Label lblInstruction;
    
    @FXML
    Label lblMalangizo;
    
    @FXML
    Label lblPx;
    
    @FXML
    Label lblExpiryDate;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void initData(OPDPrescriptionModel OPDPrescription)
    { 
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Calendar todaysDate = Calendar.getInstance();
        String today = dateFormat.format(todaysDate.getTime());

        String patientName = OPDPrescription.getFirstName()+" "+OPDPrescription.getMiddleName()+" "+OPDPrescription.getLastName();
        lblPatientName.setText(patientName);
        lblDrugName.setText(OPDPrescription.getDrugName());
        lblQty.setText(String.valueOf(1234));
        lblTabCap.setText(String.valueOf(5453));
        lblTimeADay.setText(String.valueOf(OPDPrescription.getFrequency()));
        lblDate.setText(today);
        lblPrescriptionNo.setText(String.valueOf(OPDPrescription.getPrescriptionid()));
        lblInstruction.setText(OPDPrescription.getInstruction());
        lblMalangizo.setText(OPDPrescription.getMalangizo());
        lblPx.setText(OPDPrescription.getPx());
        lblExpiryDate.setText(OPDPrescription.getExpirydate());
        
        //now call all the variables from fxml and set the values to print - Use Final as static variables
    }
    
}
