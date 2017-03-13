/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardController;

import com.afritrend.PharmacyDataAccess.OPDPrescriptionDataAccess;
import com.afritrend.PharmacyModel.OPDPrescriptionModel;
import com.afritrend.WardDataAccess.DosageCodesDataAccess;
import com.afritrend.WardDataAccess.TempPrescriptionDataAccess;
import com.afritrend.WardModel.patientModel;
import com.afritrend.common.AutoDrugSearchDataAccess;
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
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import utility.Barcoder;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class OPDPrescriptionController implements Initializable {

    @FXML
    Label lblPatientID;
    
    @FXML
    ComboBox cbDrugName;
    
    @FXML
    ComboBox cbStrength;
    
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
    ComboBox cbDosageForm,cbDrugClass;
    
    @FXML
    ComboBox cbcmscode,cbDosageProcedure;
    
    @FXML
    TableView PrescriptionTV;
    
    List<OPDPrescriptionModel> Displayedprescription;
    
    
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
       List<String> CmsCodeslist = new ArrayList();
       List<String> Admissionlist = new ArrayList();
       List<String> doseprocelist = new ArrayList();
       
       
       DrugClasslist = autodrugdao.GetDrugClass();
       Dosagelist = autodrugdao.GetDosageForms();
       Strengthlist.add("100ML");
       drugNamelist = autodrugdao.GetDrugNamesByDosageForm("DosageForm");       
       CmsCodeslist = autodrugdao.GetItemCode("Tablets and Capsules");       
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
        
        Iterator<String> cmscodelistit = CmsCodeslist.iterator();        
        while(cmscodelistit.hasNext())
        {
            String item = cmscodelistit.next();
            cbcmscode.getItems().add(item);
        } 
        
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
    private void Prescribe(ActionEvent event)
    {
        Iterator<OPDPrescriptionModel> prescribeit = Displayedprescription.iterator();
        OPDPrescriptionDataAccess opdao = new OPDPrescriptionDataAccess();
        
        while(prescribeit.hasNext())
        {
            OPDPrescriptionModel prescribe = new OPDPrescriptionModel();
            prescribe = prescribeit.next();
            
            Barcoder.BarcodeCreate(prescribe.getPatientNo());

            File ff = new File("C:\\EDMSFOLDER\\QRCode.png");
            String img = ff.getAbsolutePath();
            String feedback = opdao.SavePrescription(prescribe, img);
        }
        
    }
    
    @FXML
    private void saveprescription(ActionEvent event)
    {
        String PatientID = lblPatientID.getText();
        String DrugName = (String)cbDrugName.getValue();
        String Strength = (String)cbStrength.getValue();
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
        
        List<OPDPrescriptionModel> listprescriptions = new ArrayList();
        
        TempPrescriptionDataAccess tempPrescripDao = new TempPrescriptionDataAccess();
        tempPrescripDao.SaveTempPrescription(OPDModel);
        listprescriptions =  tempPrescripDao.GetAllTempPrescription(SessionManagement._wardName);
        ShowTempPrescription(listprescriptions);
    }    
    
    
    public void ShowTempPrescription(List<OPDPrescriptionModel> listprescriptions)
    {
        Displayedprescription = listprescriptions;
        
        ObservableList<OPDPrescriptionModel> itemsobs = FXCollections.observableArrayList();  

        TableColumn<OPDPrescriptionModel, String> PatientNameColumn = new TableColumn<>("PATIENT NUMBER");
        PatientNameColumn.setMinWidth (200);    
        PatientNameColumn.setCellValueFactory(new PropertyValueFactory<>("patientNo"));  

        TableColumn<OPDPrescriptionModel, String> FirstNameColumn = new TableColumn<>("FIRST NAME");
        FirstNameColumn.setMinWidth (200);    
        FirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));      

        TableColumn<OPDPrescriptionModel, String> MiddleNameColumn = new TableColumn<>("MIDDLE NAME");
        MiddleNameColumn.setMinWidth (200);    
        MiddleNameColumn.setCellValueFactory(new PropertyValueFactory<>("middleName")); 

        TableColumn<OPDPrescriptionModel, String> LastNameColumn = new TableColumn<>("LAST NAME");        
        LastNameColumn.setMinWidth (200);    
        LastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));                     

        TableColumn<OPDPrescriptionModel, String> cmscodeColumn = new TableColumn<>("CMSCODE");
        cmscodeColumn.setMinWidth (200);    
        cmscodeColumn.setCellValueFactory(new PropertyValueFactory<>("cmsCode"));  

        TableColumn<OPDPrescriptionModel, String> DrugNameColumn = new TableColumn<>("DRUGNAME");
        DrugNameColumn.setMinWidth (200);    
        DrugNameColumn.setCellValueFactory(new PropertyValueFactory<>("drugName"));      

        TableColumn<OPDPrescriptionModel, String> AdmissionCodeColumn = new TableColumn<>("ADMISSION CODE");
        AdmissionCodeColumn.setMinWidth (200);    
        AdmissionCodeColumn.setCellValueFactory(new PropertyValueFactory<>("admissionCode")); 

        TableColumn<OPDPrescriptionModel, String> DosageFormColumn = new TableColumn<>("DOSAGE FORM");        
        DosageFormColumn.setMinWidth (200);    
        DosageFormColumn.setCellValueFactory(new PropertyValueFactory<>("dosageForm"));       

        TableColumn<OPDPrescriptionModel, String> InstructionColumn = new TableColumn<>("INSTRUCTION");        
        InstructionColumn.setMinWidth (200);    
        InstructionColumn.setCellValueFactory(new PropertyValueFactory<>("instruction"));                               

        TableColumn<OPDPrescriptionModel, String> MalangizoColumn = new TableColumn<>("MALANGIZO");        
        MalangizoColumn.setMinWidth (200);    
        MalangizoColumn.setCellValueFactory(new PropertyValueFactory<>("malangizo"));                 

        TableColumn<OPDPrescriptionModel, String> ExpiryDateColumn = new TableColumn<>("EXPIRY DATE");        
        ExpiryDateColumn.setMinWidth (200);    
        ExpiryDateColumn.setCellValueFactory(new PropertyValueFactory<>("expirydate"));                 

        TableColumn<OPDPrescriptionModel, String> StrengthColumn = new TableColumn<>("STRENGTH");        
        StrengthColumn.setMinWidth (200);    
        StrengthColumn.setCellValueFactory(new PropertyValueFactory<>("strength"));                 

        TableColumn<OPDPrescriptionModel, String> QuantityColumn = new TableColumn<>("QUANTITY");        
        QuantityColumn.setMinWidth (200);    
        QuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));                 

        TableColumn<OPDPrescriptionModel, String> PxColumn = new TableColumn<>("PX");        
        PxColumn.setMinWidth (200);    
        PxColumn.setCellValueFactory(new PropertyValueFactory<>("px"));                 

        TableColumn<OPDPrescriptionModel, String> FrequencyColumn = new TableColumn<>("FREQUENCY");        
        FrequencyColumn.setMinWidth (200);    
        FrequencyColumn.setCellValueFactory(new PropertyValueFactory<>("frequency"));                            

        Iterator<OPDPrescriptionModel> vit = listprescriptions.iterator();
        while(vit.hasNext())
        {
            OPDPrescriptionModel prescription = new OPDPrescriptionModel();
            prescription = vit.next();

            itemsobs.add(new OPDPrescriptionModel(
                    prescription.getPrescriptionid(),
                    prescription.getPatientNo(),
                    prescription.getFirstName(),
                    prescription.getMiddleName(),
                    prescription.getLastName(),
                    prescription.getCmsCode(),
                    prescription.getDrugName(),
                    prescription.getAdmissionCode(),
                    prescription.getDosageForm(),
                    prescription.getInstruction(),
                    prescription.getMalangizo(),
                    prescription.getExpirydate(),
                    prescription.getStrength(),
                    prescription.getQuantity(),
                    prescription.getPx(),                    
                    prescription.getFrequency(),                    
                    prescription.getPrescrionbarcode()));                
        }

        PrescriptionTV.getColumns().clear();
        PrescriptionTV.setItems(itemsobs);
        PrescriptionTV.getColumns().addAll(
                PatientNameColumn,FirstNameColumn,MiddleNameColumn,
                LastNameColumn,cmscodeColumn,DrugNameColumn,
                AdmissionCodeColumn,DosageFormColumn,InstructionColumn,MalangizoColumn,ExpiryDateColumn,StrengthColumn,QuantityColumn,PxColumn,FrequencyColumn);          
    }
    
}
