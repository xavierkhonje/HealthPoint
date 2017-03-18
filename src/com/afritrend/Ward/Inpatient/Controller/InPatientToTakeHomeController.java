/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.Ward.Inpatient.Controller;

import com.afritrend.Ward.Inpatient.DataAccess.ToTakeHomeDataAccess;
import com.afritrend.Ward.Inpatient.Model.ToTakeHomeModel;
import com.afritrend.WardDataAccess.DosageCodesDataAccess;
import com.afritrend.WardDataAccess.TempTTODataAccess;
import com.afritrend.WardModel.patientModel;
import com.afritrend.common.AutoDrugSearchDataAccess;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class InPatientToTakeHomeController implements Initializable {

    @FXML
    Label lblPatientID;
    
    @FXML
    TableView ToTakeHomeTV;
    
    @FXML
    ComboBox cbDrugClass,cbDosageForm,cbDrugName,cbAdmission,cbDosageProcedure;
    
    @FXML
    TextField txtQuantity,txtInstruction,txtMalangizo,txtPx;
    
    @FXML
    TextField txtMidNightAmount, txtMorningAmount, txtNoonAmount, txtEveningAmount;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       AutoDrugSearchDataAccess autodrugdao = new AutoDrugSearchDataAccess();
       DosageCodesDataAccess dosecodesdao = new DosageCodesDataAccess();
       
       List<String> DrugClasslist = new ArrayList();
       List<String> Dosagelist = new ArrayList();
       List<String> Strengthlist = new ArrayList();
       List<String> drugNamelist = new ArrayList();       
//       List<String> CmsCodeslist = new ArrayList();
       List<String> Admissionlist = new ArrayList();
       List<String> doseprocelist = new ArrayList();
       
       
       DrugClasslist = autodrugdao.GetDrugClass();
       Dosagelist = autodrugdao.GetDosageForms();
       Strengthlist.add("100ML");
       drugNamelist = autodrugdao.GetDrugNamesByDosageForm("DosageForm");       
//       CmsCodeslist = autodrugdao.GetItemCode("Tablets and Capsules");       
       Admissionlist = autodrugdao.GetAdmissionCodes();       
       doseprocelist = dosecodesdao.GetCodes();
       

        Iterator<String> classlistit = DrugClasslist.iterator();        
        while(classlistit.hasNext())
        {
            String item = classlistit.next();
            cbDrugClass.getItems().add(item);
        }        

        Iterator<String> doselist = doseprocelist.iterator();        
        while(doselist.hasNext())
        {
            String item = doselist.next();
            cbDosageProcedure.getItems().add(item);
        }        

        Iterator<String> classit = Dosagelist.iterator();        
        while(classit.hasNext())
        {
            String item = classit.next();
            cbDosageForm.getItems().add(item);
        }     
        
        Iterator<String> druglistit = drugNamelist.iterator();        
        while(druglistit.hasNext())
        {
            String item = druglistit.next();
            cbDrugName.getItems().add(item);
        }     
        
//        Iterator<String> cmscodelistit = CmsCodeslist.iterator();        
//        while(cmscodelistit.hasNext())
//        {
//            String item = cmscodelistit.next();
//            cbcmscode.getItems().add(item);
//        } 
        
        Iterator<String> admissionlistit = Admissionlist.iterator();        
        while(admissionlistit.hasNext())
        {
            String item = admissionlistit.next();
            cbAdmission.getItems().add(item);
        } 
    }    
    
    public void initData(patientModel patient)
    {
        lblPatientID.setText(patient.getPatientID());
    }      
    
    @FXML
    private void AddNewToTakeHome(ActionEvent event)
    {
        ToTakeHomeModel TTO = new ToTakeHomeModel();
        TTO.setDrugClass(String.valueOf(cbDrugClass.getValue()));
        TTO.setDosageForm(String.valueOf(cbDosageForm.getValue()));
        TTO.setDrugName(String.valueOf(cbDrugName.getValue()));
        TTO.setQuantity(Integer.valueOf(txtQuantity.getText()));
        TTO.setInstruction(String.valueOf(txtInstruction.getText()));
        TTO.setMalangizo(String.valueOf(txtMalangizo.getText()));
        TTO.setPx(String.valueOf(txtPx.getText()));
        TTO.setMidnightAmount(Integer.valueOf(txtMidNightAmount.getText()));
        TTO.setMorningAmount(Integer.valueOf(txtMorningAmount.getText()));
        TTO.setNoonAmount(Integer.valueOf(txtNoonAmount.getText()));
        TTO.setEveningAmount(Integer.valueOf(txtEveningAmount.getText()));
        TTO.setAdmissionCode(String.valueOf(cbAdmission.getValue()));
        TTO.setDosageProcedure(String.valueOf(cbDosageProcedure.getValue()));
        TTO.setPatientNumber(String.valueOf(lblPatientID.getText()));
        
        TempTTODataAccess ttodao = new TempTTODataAccess();
        ttodao.SaveTempTTO(TTO);
                
        ToTakeHomeDataAccess HPttodao = new ToTakeHomeDataAccess();
        HPttodao.SavePatientTTO(TTO);
    }
    
    @FXML
    private void SaveTotakeHome(ActionEvent event)
    {
        
    }
    
    @FXML
    private void DeleteToTakeHome(ActionEvent event)
    {
        
    }
    
    @FXML
    private void UpdateToTakeHome(ActionEvent event)
    {
        
    }
    
    public void ShowToTakeHome(List<ToTakeHomeModel> totakehomelist)
    {
        
    }
    
}
