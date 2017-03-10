/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardController;

import com.afritrend.PharmacyDataAccess.OPDPrescriptionDataAccess;
import com.afritrend.PharmacyModel.OPDPrescriptionModel;
import com.afritrend.WardDataAccess.DosageCodesDataAccess;
import com.afritrend.WardModel.patientModel;
import com.afritrend.common.AutoDrugSearchDataAccess;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import utility.Barcoder;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class OPDPrescriptionController implements Initializable {

    @FXML
    TextField txtPatientNumber;
    
    @FXML
    TextField txtDrugName;
    
    @FXML
    TextField txtStrength;
    
    @FXML
    TextField txtQuantity;
    
    @FXML
    TextField txtInstruction;
    
    @FXML
    TextField txtMalangizo;
    
    @FXML
    TextField txtPx;
    
    @FXML
    ComboBox cbAdmission;
    
    @FXML
    ComboBox cbDosageForm;
    
    @FXML
    ComboBox cbcmscode;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       AutoDrugSearchDataAccess autodrugdao = new AutoDrugSearchDataAccess();
       DosageCodesDataAccess dosecodesdao = new DosageCodesDataAccess();
       List<String> dosecodeslist = new ArrayList();
       
       dosecodeslist = dosecodesdao.GetCodes();
        Iterator<String> doselist = dosecodeslist.iterator();        
        while(doselist.hasNext())
        {
            String item = doselist.next();
            cbAdmission.getItems().add(item);
        }        
       
       List<String> list = new ArrayList();
       
       list = autodrugdao.GetDosageForms();

        Iterator<String> classit = list.iterator();        
        while(classit.hasNext())
        {
            String item = classit.next();
            cbDosageForm.getItems().add(item);
        }     
        
        list = autodrugdao.GetDosageForms();

        Iterator<String> cmscodelistit = list.iterator();        
        while(cmscodelistit.hasNext())
        {
            String item = cmscodelistit.next();
            cbcmscode.getItems().add(item);
        }     
    }    
    
    public void initData(patientModel patient)
    {
        System.out.println(patient.getFirstname());
    }
    
    @FXML
    private void Prescribe(ActionEvent event)
    {
        OPDPrescriptionModel prescribe = new OPDPrescriptionModel();
//        prescribe.setDrugName();
        
    }
    
    @FXML
    private void saveprescription(ActionEvent event)
    {
        String PatientID = txtPatientNumber.getText();
        String DrugName = txtDrugName.getText();
        String Strength = txtStrength.getText();
        int Quantity = Integer.valueOf(txtQuantity.getText());
        String Instructions = txtInstruction.getText();
        String Malangizo = txtMalangizo.getText();
        String px = txtPx.getText();
        String Admission = (String)cbAdmission.getValue();
        String DosageForm = (String)cbDosageForm.getValue();
        String cmscode = (String)cbcmscode.getValue();
        
        OPDPrescriptionModel OPDModel = new OPDPrescriptionModel();
        OPDModel.setPatientNo(PatientID);
        OPDModel.setDrugName(DrugName);
        OPDModel.setInstruction(Instructions);
        OPDModel.setMalangizo(Malangizo);
        OPDModel.setPx(px);
        OPDModel.setDosageForm(DosageForm);
        OPDModel.setStrength(Strength);
        OPDModel.setQuantity(Quantity);
        OPDModel.setCmsCode(cmscode);
        OPDModel.setAdmissionCode(Admission);
        OPDModel.setFrequency(0);
        
        Barcoder.BarcodeCreate(OPDModel.getPatientNo());
        
        File ff = new File("C:\\EDMSFOLDER\\QRCode.png");
        String img = ff.getAbsolutePath();

        OPDPrescriptionDataAccess opdao = new OPDPrescriptionDataAccess();
        String feedback = opdao.SavePrescription(OPDModel, img);
    }    
    
    
}
