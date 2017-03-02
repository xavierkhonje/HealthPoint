/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardController;

import com.afritrend.common.AutoDrugSearchDataAccess;
import com.afritrend.common.AutoSundrySearchDataAccess;
import com.afritrend.common.DataAccess.SundryItemDataAccess;
import com.afritrend.common.Model.SundryItemModel;
import com.afritrend.common.config_sqlite;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class WardSundriesEntryController implements Initializable {
    @FXML
    Label lblGeneralError;
    
    @FXML
    Label cmscodeError;
    
    @FXML
    Label SundryClassError;
    
    @FXML
    Label SundryNameError;
    
    @FXML
    Label TransactionTypeError;
    
    @FXML
    Label IssueUnitError;
    
    @FXML
    Label ExpiryDateError;
    
    @FXML
    Label QuantityError;
    
    @FXML
    ComboBox cbcmscodes;
    
    @FXML
    ComboBox cbSundryClass;
    
    @FXML
    ComboBox cbSundryName;
    
    @FXML
    ComboBox cbTransactionType;
    
    @FXML
    ComboBox cbIssueUnit;
    
    @FXML
    DatePicker DpExpiryDate;
    
    @FXML
    TextField txtQuantity;
    
    @FXML
    TextField txtSundrayName;
    
    @FXML
    TextField txtIssueUnit;
    
    @FXML
    TextArea txtSundryDescription;
    
    @FXML
    Label txtDescriptionError; 
    
    @FXML
    TableView TVSundryEntry;   
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
        
        SundryClassError.setText("*");
        cmscodeError.setText("*");
        SundryNameError.setText("*");
        TransactionTypeError.setText("*");
        IssueUnitError.setText("*");
        QuantityError.setText("*");
        ExpiryDateError.setText("*");
        txtDescriptionError.setText("*");
        
        AutoSundrySearchDataAccess sundryautodao = new AutoSundrySearchDataAccess();
        
        AutoDrugSearchDataAccess drugautodao = new AutoDrugSearchDataAccess();
        
        
        classlist = sundryautodao.GetSundryClass();
        Iterator<String> classit = classlist.iterator();
        
        while(classit.hasNext())
        {
            String classname = classit.next();
            cbSundryClass.getItems().add(classname);
        }        
        
        Drugcmscodeslist = sundryautodao.GetSundryCode("SundryClass");
        
        Transactionlist = drugautodao.GetTransactionTypes();        
        
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
    
    public void SaveSundry(ActionEvent event)
    {
        SundryItemModel sundry = new SundryItemModel();
        
        sundry.setSundrycode(String.valueOf(cbcmscodes.getValue()));
        sundry.setSundryclass(String.valueOf(cbSundryClass.getValue()));        
        sundry.setSundryname(String.valueOf(txtSundrayName.getText()));        
        sundry.setIssueunit(String.valueOf(txtIssueUnit.getText()));
        sundry.setExpiryDate(String.valueOf(DpExpiryDate.getValue()));        
        sundry.setSundrydescription(txtSundryDescription.getText());
        sundry.setTransactionType(String.valueOf(cbTransactionType.getValue()));
        int Quantity = 0;
        
        if(txtQuantity.getText() == null || txtQuantity.getText() .equals(""))
        {
            Quantity = 0;
        }
        else
        {
            Quantity = Integer.valueOf(txtQuantity.getText());            
        }         
        
        sundry.setQuantity(Quantity);
        
        if(sundry.validateSundry())
        {
            SundryItemDataAccess sundrydao = new SundryItemDataAccess();        
            String msg = sundrydao.SaveSundries(sundry, "dministrator", "QECH");

            lblGeneralError.setText(msg);
            List<SundryItemModel> sundrylist = new ArrayList();
            sundrylist.add(sundry);

            ShowSundrydetails(sundrylist);    
            
            SundryClassError.setText("");
            cmscodeError.setText("");
            SundryNameError.setText("");
            TransactionTypeError.setText("");
            IssueUnitError.setText("");
            QuantityError.setText("");
            ExpiryDateError.setText("");
            txtDescriptionError.setText("");             
        }
        else
        {
            SundryClassError.setText(sundry.sundryclassError);
            cmscodeError.setText(sundry.sundrycodeError);
            SundryNameError.setText(sundry.sundrynameError);
            TransactionTypeError.setText(sundry.transactionTypeError);
            IssueUnitError.setText(sundry.issueUnitError);
            QuantityError.setText(sundry.quantityError);
            ExpiryDateError.setText(sundry.expiryDateError);
            txtDescriptionError.setText(sundry.sundrydescriptionError);            
        }
        

    }
    
    public void GetSundryNames(ActionEvent event)
    {
        //GetHPDrugNamesByDosageForm
//        List<String> Druglist = new ArrayList();
//        String dosageForm = String.valueOf(cbDosageForm.getValue());
//        AutoDrugSearchDataAccess drugautodao = new AutoDrugSearchDataAccess();
//        Druglist = drugautodao.GetHPDrugNamesByDosageForm(dosageForm);
//        
//        cbDrugName.getItems().clear();
//        Iterator<String> drugit = Druglist.iterator();
//        while(drugit.hasNext())
//        {
//            String drugname = drugit.next();
//            cbDrugName.getItems().add(drugname);
//        }
    }
    
    public void GetStrength(ActionEvent event)
    {
        //GetHPDrugNamesByDosageForm
//        List<String> Strengthlist = new ArrayList();
//        String DrugName = String.valueOf(cbDrugName.getValue());
//        AutoDrugSearchDataAccess drugautodao = new AutoDrugSearchDataAccess();
//        Strengthlist = drugautodao.GetHPStrengthByDrugName(DrugName);
//        
//        cbStrength.getItems().clear();
//        Iterator<String> strengthit = Strengthlist.iterator();
//        while(strengthit.hasNext())
//        {
//            String strength = strengthit.next();
//            cbStrength.getItems().add(strength);
//        }
    }
    
    public void GetIssueUnit(ActionEvent event)
    {
//        List<String> IssueUnitlist = new ArrayList();
//        String DrugName = String.valueOf(cbDrugName.getValue());
//        AutoDrugSearchDataAccess drugautodao = new AutoDrugSearchDataAccess();
//        IssueUnitlist = drugautodao.GetIssueUnit(DrugName, String.valueOf(cbStrength.getValue()), String.valueOf(cbDosageForm.getValue()));
//        
//        cbIssueUnit.getItems().clear();
//        Iterator<String> Issueit = IssueUnitlist.iterator();
//        while(Issueit.hasNext())
//        {
//            String IssueUnit = Issueit.next();
//            cbIssueUnit.getItems().add(IssueUnit);
//        }
    }    
    
    @FXML
    public void GetCodeDetails(ActionEvent event)
    {
        SundryItemModel item = new SundryItemModel();
        SundryItemDataAccess sundrydao = new SundryItemDataAccess();        
        String cmscode = String.valueOf(cbcmscodes.getValue());
        item = sundrydao.GetSundryDetailsByCode(cmscode);
        
        cbcmscodes.setValue(item.getSundrycode());
        cbSundryClass.setValue(item.getSundryclass());
        txtSundrayName.setText(item.getSundryname());
        txtIssueUnit.setText(item.getIssueunit()); 
        txtSundryDescription.setText(item.getSundrydescription());
        
        config_sqlite con = new config_sqlite();
        con.ConnectSQLite();
        
    }    
    
    
    public void ShowSundrydetails(List<SundryItemModel> list)
    {
        ObservableList<SundryItemModel> sundsobs = FXCollections.observableArrayList();  
        
        TableColumn<SundryItemModel, String> SundryClassColumn = new TableColumn<>("CLASS");
        SundryClassColumn.setMinWidth (200);    
        SundryClassColumn.setCellValueFactory(new PropertyValueFactory<>("sundryclass"));  
                
        TableColumn<SundryItemModel, String> CodeColumn = new TableColumn<>("CODE");
        CodeColumn.setMinWidth (200);    
        CodeColumn.setCellValueFactory(new PropertyValueFactory<>("sundrycode"));      
        
        TableColumn<SundryItemModel, String> SundryNameColumn = new TableColumn<>("Sundry Name");
        SundryNameColumn.setMinWidth (200);    
        SundryNameColumn.setCellValueFactory(new PropertyValueFactory<>("sundryname")); 
        
        TableColumn<SundryItemModel, String> IssueUnitColumn = new TableColumn<>("Issue Unit");        
        IssueUnitColumn.setMinWidth (200);    
        IssueUnitColumn.setCellValueFactory(new PropertyValueFactory<>("issueunit"));         
        
        TableColumn<SundryItemModel, String> ExpiryDateColumn = new TableColumn<>("Expiry Date");        
        ExpiryDateColumn.setMinWidth (200);    
        ExpiryDateColumn.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));                   
        
        TableColumn<SundryItemModel, String> QuantityColumn = new TableColumn<>("Quantity");        
        QuantityColumn.setMinWidth (200);    
        QuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));             
        
        TableColumn<SundryItemModel, String> DescriptionColumn = new TableColumn<>("Description");        
        DescriptionColumn.setMinWidth (200);    
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("sundrydescription"));             
        
        TableColumn<SundryItemModel, String> TransactionTypeColumn = new TableColumn<>("Transaction Type");        
        TransactionTypeColumn.setMinWidth (200);    
        TransactionTypeColumn.setCellValueFactory(new PropertyValueFactory<>("transactionType"));             

        Iterator<SundryItemModel> itsundry = list.iterator();
        while(itsundry.hasNext())
        {
            SundryItemModel sundry = new SundryItemModel();
            sundry = itsundry.next();
            
            sundsobs.add(new SundryItemModel(sundry.getSundryclass(),sundry.getSundrycode(),sundry.getSundryname(), sundry.getIssueunit(),sundry.getExpiryDate(),sundry.getQuantity(), sundry.getTransactionType(),sundry.getSundrydescription()));
        }
        
                
        TVSundryEntry.getColumns().clear();
        TVSundryEntry.setItems(sundsobs);
        TVSundryEntry.getColumns().addAll(SundryClassColumn,CodeColumn,
                SundryNameColumn,IssueUnitColumn,ExpiryDateColumn,QuantityColumn,DescriptionColumn,TransactionTypeColumn);         
    }    
}
