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
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class TestBagController implements Initializable {

    @FXML
    Label lblDrugName, lblQTY,lblTABCAP,lblTimesADay,lblPatientName,lblDate,lblPrescriptionNumber,lblInstructions,lblMalangizo,lblPx,lblExpDate;
    
    @FXML
    Label lblMorningAmount, lblNoonAmount, lblSunsetAmount, lblMidnightAmount;
    
    @FXML
    ImageView imgTimesofDay;
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
        lblQTY.setText(String.valueOf(40));
        lblTABCAP.setText(String.valueOf(40));
        lblTimesADay.setText(String.valueOf(OPDPrescription.getFrequency()));
        lblDate.setText(today);
        lblPrescriptionNumber.setText(String.valueOf(OPDPrescription.getPrescriptionid()));
        lblInstructions.setText(OPDPrescription.getInstruction());
        lblMalangizo.setText(OPDPrescription.getMalangizo());
        lblPx.setText(OPDPrescription.getPx());
        lblExpDate.setText(OPDPrescription.getExpirydate());  
//        Image prescribeimg = new Image("");
        imgTimesofDay.setImage(new Image("/Resources/PrescriptionTimes.png"));
        
        lblMidnightAmount.setText(String.valueOf(2));
        lblSunsetAmount.setText(String.valueOf(2));
        lblNoonAmount.setText(String.valueOf(2));
        lblMorningAmount.setText(String.valueOf(2));        
    }
    
}
