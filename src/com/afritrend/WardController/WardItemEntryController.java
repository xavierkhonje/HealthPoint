/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardController;

import com.afritrend.common.AutoDrugSearchDataAccess;
import com.afritrend.common.DataAccess.DrugsDataAccess;
import com.afritrend.common.Model.DrugsModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class WardItemEntryController implements Initializable {
    @FXML
    Label lblGeneralError;
    
    @FXML
    Label cmscodeError;
    
    @FXML
    Label DrugError;
    
    @FXML
    Label DosageError;
    
    @FXML
    Label DrugNameError;
    
    @FXML
    Label StrengthError;
    
    @FXML
    Label IssueUnitError;
    
    @FXML
    Label ExpiryDateError;
    
    @FXML
    Label QuantityError;
    
    @FXML
    ComboBox cbcmscodes;
    
    @FXML
    ComboBox cbdrugClass;
    
    @FXML
    ComboBox cbDosageForm;
    
    @FXML
    ComboBox cbDrugName;
    
    @FXML
    ComboBox cbTransactionType;
    
    @FXML
    ComboBox cbStrength;
    
    @FXML
    ComboBox cbIssueUnit;
    
    @FXML
    DatePicker DpExpiryDate;
    
    @FXML
    TextField txtQuantity;
    
    @FXML
    TableView TVDrugEntry;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> dosagelist = new ArrayList();
        List<String> classlist = new ArrayList();
        List<String> Drugcmscodeslist = new ArrayList();
        List<String> Transactionlist = new ArrayList();
        List<String> IssueUnitList = new ArrayList();
        
        AutoDrugSearchDataAccess drugautodao = new AutoDrugSearchDataAccess();
        
        
        classlist = drugautodao.GetDrugClass();
        Iterator<String> classit = classlist.iterator();
        
        while(classit.hasNext())
        {
            String classname = classit.next();
            cbdrugClass.getItems().add(classname);
        }        
        
        dosagelist = drugautodao.GetDosageForms();
        
        Drugcmscodeslist = drugautodao.GetHPItemCode();
        Transactionlist = drugautodao.GetTransactionTypes();
        
        Iterator<String> itDose = dosagelist.iterator();
        while(itDose.hasNext())
        {
            String Dosage = itDose.next();
            cbDosageForm.getItems().add(Dosage);
        }
        
        Iterator<String> itTransact = Transactionlist.iterator();
        while(itTransact.hasNext())
        {
            String Transact = itTransact.next();
            cbTransactionType.getItems().add(Transact);
        }
        
        Iterator<String> itCodes = Drugcmscodeslist.iterator();
        while(itCodes.hasNext())
        {
            String Code = itCodes.next();
            cbcmscodes.getItems().add(Code);
        }
    }    
    
    
    public void SaveDrug(ActionEvent event)
    {
        DrugsModel drug = new DrugsModel();
        
        drug.setDrugcode(String.valueOf(cbcmscodes.getValue()));
        drug.setDrugclass(String.valueOf(cbdrugClass.getValue()));
        drug.setDosageform(String.valueOf(cbDosageForm.getValue()));
        drug.setDrugname(String.valueOf(cbDrugName.getValue()));
        drug.setStrength(String.valueOf(cbStrength.getValue()));
        drug.setIssueunit(String.valueOf(cbIssueUnit.getValue()));
        drug.setExpirydate(String.valueOf(DpExpiryDate.getValue()));
        Integer Quantity = Integer.valueOf(txtQuantity.getText());
        String Transaction = String.valueOf(cbTransactionType.getValue());
        
        DrugsDataAccess drugsdao = new DrugsDataAccess();        
        String msg = drugsdao.SaveWardDrugs(drug, "administrator", "4AWard", Quantity, Transaction);
        
        Notifications notification = Notifications.create()
                .title("Requisition Saved")
                .text(msg)
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_LEFT)
                .onAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event)
                    {
                        System.out.println("Clicked on Notification");
                    }
                });
        
        notification.showConfirm();
        
        ObservableList<DrugsModel> drugsobs = FXCollections.observableArrayList();  
        
        TableColumn<DrugsModel, String> CMSCODEColumn = new TableColumn<>("CMS CODE");
        CMSCODEColumn.setMinWidth (200);    
        CMSCODEColumn.setCellValueFactory(new PropertyValueFactory<>("drugcode"));  
                
        TableColumn<DrugsModel, String> DrugClassColumn = new TableColumn<>("Drug Class");
        DrugClassColumn.setMinWidth (200);    
        DrugClassColumn.setCellValueFactory(new PropertyValueFactory<>("drugclass"));      
        
        TableColumn<DrugsModel, String> DoseColumn = new TableColumn<>("Dosage Form");
        DoseColumn.setMinWidth (200);    
        DoseColumn.setCellValueFactory(new PropertyValueFactory<>("dosageform")); 
        
        TableColumn<DrugsModel, String> DrugColumn = new TableColumn<>("Drug Name");        
        DrugColumn.setMinWidth (200);    
        DrugColumn.setCellValueFactory(new PropertyValueFactory<>("drugname"));         
        
        TableColumn<DrugsModel, String> StrengthColumn = new TableColumn<>("Strength");        
        StrengthColumn.setMinWidth (200);    
        StrengthColumn.setCellValueFactory(new PropertyValueFactory<>("strength"));        
        
        TableColumn<DrugsModel, String> IssueUnitColumn = new TableColumn<>("Issue Unit");        
        IssueUnitColumn.setMinWidth (200);    
        IssueUnitColumn.setCellValueFactory(new PropertyValueFactory<>("issueunit"));           
        
        TableColumn<DrugsModel, String> ExpiryColumn = new TableColumn<>("Exipry Date");        
        ExpiryColumn.setMinWidth (200);    
        ExpiryColumn.setCellValueFactory(new PropertyValueFactory<>("expirydate"));             
        

        drugsobs.add(new DrugsModel(drug.getDrugcode(),drug.getDrugclass(),drug.getDosageform(),drug.getDrugname(),drug.getStrength(),drug.getIssueunit(),drug.getExpirydate(),drug.getQuantity(),drug.getTransactionType()));
                
        TVDrugEntry.setItems(drugsobs);
        TVDrugEntry.getColumns().addAll(CMSCODEColumn,DrugClassColumn,DoseColumn,DrugColumn,StrengthColumn,IssueUnitColumn,ExpiryColumn);                 
    }
    
    public void GetDrugNames(ActionEvent event)
    {
        //GetHPDrugNamesByDosageForm
        List<String> Druglist = new ArrayList();
        String dosageForm = String.valueOf(cbDosageForm.getValue());
        AutoDrugSearchDataAccess drugautodao = new AutoDrugSearchDataAccess();
        Druglist = drugautodao.GetHPDrugNamesByDosageForm(dosageForm);
        
        cbDrugName.getItems().clear();
        Iterator<String> drugit = Druglist.iterator();
        while(drugit.hasNext())
        {
            String drugname = drugit.next();
            cbDrugName.getItems().add(drugname);
        }
    }
    
    public void GetStrength(ActionEvent event)
    {
        //GetHPDrugNamesByDosageForm
        List<String> Strengthlist = new ArrayList();
        String DrugName = String.valueOf(cbDrugName.getValue());
        AutoDrugSearchDataAccess drugautodao = new AutoDrugSearchDataAccess();
        Strengthlist = drugautodao.GetHPStrengthByDrugName(DrugName);
        
        cbStrength.getItems().clear();
        Iterator<String> strengthit = Strengthlist.iterator();
        while(strengthit.hasNext())
        {
            String strength = strengthit.next();
            cbStrength.getItems().add(strength);
        }
    }
    
    public void GetIssueUnit(ActionEvent event)
    {
        List<String> IssueUnitlist = new ArrayList();
        String DrugName = String.valueOf(cbDrugName.getValue());
        AutoDrugSearchDataAccess drugautodao = new AutoDrugSearchDataAccess();
        IssueUnitlist = drugautodao.GetIssueUnit(DrugName, String.valueOf(cbStrength.getValue()), String.valueOf(cbDosageForm.getValue()));
        
        cbIssueUnit.getItems().clear();
        Iterator<String> Issueit = IssueUnitlist.iterator();
        while(Issueit.hasNext())
        {
            String IssueUnit = Issueit.next();
            cbIssueUnit.getItems().add(IssueUnit);
        }
    }    
}
