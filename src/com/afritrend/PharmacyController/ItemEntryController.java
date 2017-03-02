/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.PharmacyDataAccess.ItemDataAccess;
import com.afritrend.PharmacyModel.ItemModel;
import com.afritrend.common.AutoDrugSearchDataAccess;
import com.afritrend.common.Model.Items;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class ItemEntryController implements Initializable {
    
    @FXML
    TableView TVitemEntry;    
    
    //All the required fields to input
    @FXML
    ComboBox cbClass;
    
    @FXML
    Label lblClasserror;    
    
    @FXML
    ComboBox cbCode;    
    
    @FXML
    Label lblCodeError;    
    
    @FXML
    TextField txtIssueUnit;  
    
    @FXML
    Label lblIssueUnit;    
    
    @FXML
    TextField txtPrice;    
    
    @FXML
    Label lblPriceError;    
    
    @FXML
    TextArea txtDescription;    
    
    @FXML
    Label lblDescriptionError;    
    
    @FXML
    ComboBox cbDrugClass;  
    
    @FXML
    Label lblDrugClassName;    
    
    @FXML
    ComboBox cbDosageForm;    
    
    @FXML
    Label lblDosageFormError;    
    
    @FXML
    TextField txtName;
    
    @FXML
    Label lblItemNameError;    
    
    @FXML
    TextField txtStrength;
    
    @FXML
    Label lblStrengthError;    
    
    @FXML
    Label lblGeneralMessage;    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        AutoDrugSearchDataAccess AutoDrug = new AutoDrugSearchDataAccess();
        
        List<Items> itemclasslist = AutoDrug.GetItemClass();
        List<String> item_classlist = AutoDrug.GetItem_Class();        
        List<String> itemDescriptionlist = AutoDrug.GetItemDescription();
        
        Iterator<String> itString = item_classlist.iterator();
        while(itString.hasNext())
        {
            String item = itString.next();
            cbClass.getItems().add(item);
        }     
        
        cbDrugClass.getItems().clear();
        cbDosageForm.getItems().clear();            

        //Get Drug Class
//        AutoDrugSearchDataAccess AutoDrug = new AutoDrugSearchDataAccess();        
        List<String> itemDrugclasslist = AutoDrug.GetDrug_Class();   
        Iterator<String> DrugitString = itemDrugclasslist.iterator();
        while(DrugitString.hasNext())
        {
            String item = DrugitString.next();
            cbDrugClass.getItems().add(item);
        }         

        //Get Dosage Class      
        List<String> itemDosagelist = AutoDrug.GetDosageForms();   
        Iterator<String> itDString = itemDosagelist.iterator();
        while(itDString.hasNext())
        {
            String Dosage = itDString.next();
            cbDosageForm.getItems().add(Dosage);
        }         
        
        lblClasserror.setText("*");
        lblCodeError.setText("*");
        lblIssueUnit.setText("*");
        lblPriceError.setText("*");
        lblDescriptionError.setText("*");
        lblDrugClassName.setText("*");
        lblDosageFormError.setText("*");
        lblItemNameError.setText("*");
        lblStrengthError.setText("*");
        lblGeneralMessage.setText("");
    }    
    
//    public void SaveItem(ActionEvent event)
//    {
//        try
//        {

//            
//
//            
//            try
//            {
//                lblExpiryDateError.setText("");
//                if(dpexpirydate.getValue().equals(""))
//                {
//                    lblExpiryDateError.setText("Please Enter Date");
//                }
//                else
//                {
//                    item.setExpirydate(String.valueOf(dpexpirydate.getValue()));
//                }                
//            }
//            catch(Exception e)
//            {
//                lblExpiryDateError.setText(e.getMessage());
//            }            
//
//            lblGeneralMessage.setText("");
//            boolean validate = item.ValidateItem();
//            if(validate)
//            {
//                ItemDataAccess itemdao = new ItemDataAccess();
//                itemdao.SaveItem(item);
//                lblGeneralMessage.setText("Item Saved");
//                               
//                
//            }
//            else
//            {
//                String Msg = item.getMessage();
//                lblGeneralMessage.setText(Msg);
//            }                       
//        
//        }
//        catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//    }    
    
//    public void IsDrug(ActionEvent event)
//    {
//        if(chkIsDrug.isSelected())
//        {
//            cbDrugClass.setDisable(false);
//            cbDosageForm.setDisable(false);
//
        
//        
//        }
//        else
//        {
//            cbDrugClass.setDisable(true);
//            cbDosageForm.setDisable(true);            
//        }        
//        
//    }
    
    public void ConvertCMSCode(ActionEvent event)
    {     
            
            ItemModel item = new ItemModel();            
            
            double price = 0;
            
            if(txtPrice.getText().equals(""))
            {
                lblPriceError.setText("Please Enter Price");
            }
            else
            {
                 price = Double.valueOf(txtPrice.getText());
            }
            
            item.setItemCode(String.valueOf(cbCode.getValue()));
            item.setItemClass(String.valueOf(cbClass.getValue()));
            item.setItemName(String.valueOf(txtName.getText()));
            item.setIssueUnit(txtIssueUnit.getText());
            item.setPrice(price);
            item.setDescription(txtDescription.getText());
            item.setDosageForm(String.valueOf(cbDosageForm.getValue()));
            item.setStrength(String.valueOf(txtStrength.getText()));
            item.setDrugclass(String.valueOf(cbDrugClass.getValue()));
            
            if(item.ValidateItem() == false)
            {
                lblCodeError.setText(item.getMessage());
                //Put the other errors
                lblItemNameError.setText(item.itemNameError);
                lblDosageFormError.setText(item.dosageFormError);
                
                lblClasserror.setText(item.itemClassError);
                lblCodeError.setText(item.itemcodeError);
                lblIssueUnit.setText(item.issueUnitError);
                lblPriceError.setText(item.priceError);
                lblDescriptionError.setText(item.descriptionError);
                lblDrugClassName.setText(item.drugclassError);
                lblDosageFormError.setText(item.dosageFormError);
                lblItemNameError.setText(item.itemNameError);
                lblStrengthError.setText(item.strengthError);
                lblCodeError.setText(item.getMessage());                
                
            }
            else
            {
                //Convert the item and show results
                
                ItemDataAccess itemdao = new ItemDataAccess();
                String Msg = itemdao.ConvertDrug(item);                
                
                lblClasserror.setText("*");
                lblCodeError.setText("*");
                lblIssueUnit.setText("*");
                lblPriceError.setText("*");
                lblDescriptionError.setText("*");
                lblDrugClassName.setText("*");
                lblDosageFormError.setText("*");
                lblItemNameError.setText("*");
                lblStrengthError.setText("*");
                lblCodeError.setText(Msg);     
                
                List<ItemModel> list = new ArrayList();
                list.add(item);
                
                ShowItems(list);
            }                    
    }
    
    public void Deactivate(ActionEvent event)
    {
        ItemDataAccess itemdao = new ItemDataAccess();
        ItemModel item = new ItemModel(); 
        
        String code = String.valueOf(cbCode.getValue());
        String CLass = String.valueOf(cbClass.getValue());        
        String itemName = txtName.getText();
        String IssueUnit = txtIssueUnit.getText();
        Double Price = Double.valueOf(txtPrice.getText());
        String description = txtDescription.getText();
        String DoseForm = String.valueOf(cbDosageForm.getValue());
        String Strength = txtStrength.getText();
        String DrugClass = String.valueOf(cbDrugClass.getValue());
        
        item.setItemCode(code);
        item.setItemClass(CLass);
        item.setItemName(itemName);
        item.setIssueUnit(IssueUnit);
        item.setPrice(Price);
        item.setDescription(description);
        item.setDosageForm(DoseForm);
        item.setStrength(Strength);
        item.setDrugclass(DrugClass);        
        
        //Update the Record
        String msg = itemdao.DeactivateItem(item);
        ShowItems(itemdao.SearchDrugs());
        lblCodeError.setText(msg);        
    }
    
    public void Activate(ActionEvent event)
    {
        ItemDataAccess itemdao = new ItemDataAccess();
        ItemModel item = new ItemModel(); 
        
        String code = String.valueOf(cbCode.getValue());
        String CLass = String.valueOf(cbClass.getValue());        
        String itemName = txtName.getText();
        String IssueUnit = txtIssueUnit.getText();
        Double Price = Double.valueOf(txtPrice.getText());
        String description = txtDescription.getText();
        String DoseForm = String.valueOf(cbDosageForm.getValue());
        String Strength = txtStrength.getText();
        String DrugClass = String.valueOf(cbDrugClass.getValue());
        
        item.setItemCode(code);
        item.setItemClass(CLass);
        item.setItemName(itemName);
        item.setIssueUnit(IssueUnit);
        item.setPrice(Price);
        item.setDescription(description);
        item.setDosageForm(DoseForm);
        item.setStrength(Strength);
        item.setDrugclass(DrugClass);        
        
        //Update the Record
        String msg = itemdao.ActivateItem(item);
        ShowItems(itemdao.SearchDrugs());
        lblCodeError.setText(msg);        
    }
    
    public void Edit_Drug(ActionEvent event)
    {
        ItemDataAccess itemdao = new ItemDataAccess();
        ItemModel item = new ItemModel(); 
        
        String code = String.valueOf(cbCode.getValue());
        String CLass = String.valueOf(cbClass.getValue());        
        String itemName = txtName.getText();
        String IssueUnit = txtIssueUnit.getText();
        Double Price = Double.valueOf(txtPrice.getText());
        String description = txtDescription.getText();
        String DoseForm = String.valueOf(cbDosageForm.getValue());
        String Strength = txtStrength.getText();
        String DrugClass = String.valueOf(cbDrugClass.getValue());
        
        item.setItemCode(code);
        item.setItemClass(CLass);
        item.setItemName(itemName);
        item.setIssueUnit(IssueUnit);
        item.setPrice(Price);
        item.setDescription(description);
        item.setDosageForm(DoseForm);
        item.setStrength(Strength);
        item.setDrugclass(DrugClass);        
        
        //Update the Record
        String msg = itemdao.UpdateItem(item);
        ShowItems(itemdao.SearchDrugs());
        lblCodeError.setText(msg);
    }
    
    public void ShowDetails(MouseEvent event)
    {
        ItemModel item = new ItemModel();
        item = (ItemModel)TVitemEntry.getSelectionModel().getSelectedItem();
        
        cbCode.setValue(item.getItemCode());
        cbClass.setValue(item.getItemClass());
        txtName.setText(item.getItemName());
        txtIssueUnit.setText(item.getIssueUnit());
        txtPrice.setText(String.valueOf(item.getPrice()));
        txtDescription.setText(item.getDescription());
        cbDosageForm.setValue(item.getDosageForm());
        txtStrength.setText(item.getStrength());
        cbDrugClass.setValue(item.getDrugclass());
    }
    
    public void SearchDrug(ActionEvent event)
    {
        ItemDataAccess itemdao = new ItemDataAccess();
        ShowItems(itemdao.SearchDrugs());
    }
    
    public void GetItemCode(ActionEvent event)
    {
        AutoDrugSearchDataAccess AutoDrug = new AutoDrugSearchDataAccess();
        List<String> itemCodelist = AutoDrug.GetItemCode(String.valueOf(cbClass.getValue()));
        Iterator<String> itCodeString = itemCodelist.iterator();
        cbCode.getItems().clear();
        while(itCodeString.hasNext())
        {
            String item = itCodeString.next();
            cbCode.getItems().add(item);
        }       
    }
    
    public void GetItemName(ActionEvent event)
    {
        AutoDrugSearchDataAccess AutoDrug = new AutoDrugSearchDataAccess();
        List<Items> itemCodelist = AutoDrug.GetItemName(String.valueOf(cbCode.getValue()));
        Iterator<Items> itCodeString = itemCodelist.iterator();
        
//        cbName.getItems().clear();
        txtDescription.clear();
        txtIssueUnit.clear();
        
        while(itCodeString.hasNext())
        {
            Items it = new Items();
            it = itCodeString.next();
//            cbName.getItems().add(it.getClassName());
            txtDescription.setText(it.getDescription());
            txtIssueUnit.setText(it.getIssueUnit());
        }    
        
        //Set the Description as a hint
    } 
    
    public void AttachFiles(ActionEvent event)
    {
        try
        {
            Stage EDMS = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/HP_EDMS.fxml"));
            Scene scene = new Scene(root);
            EDMS.initModality(Modality.APPLICATION_MODAL);
            EDMS.centerOnScreen();                
            EDMS.setScene(scene);           
            
            EDMS.showAndWait();
        }
        catch(Exception e)            
        {
            System.out.println(e.getMessage());
        }        
        
    }
    
    public void ShowItems(List<ItemModel> list)
    {
        
                ObservableList<ItemModel> itemsobs = FXCollections.observableArrayList();  
                
                TableColumn<ItemModel, String> ItemCodeColumn = new TableColumn<>("CMS CODE");
                ItemCodeColumn.setMinWidth (100);    
                ItemCodeColumn.setCellValueFactory(new PropertyValueFactory<>("itemCode"));  

                TableColumn<ItemModel, String> ItemClassColumn = new TableColumn<>("Item Class");
                ItemClassColumn.setMinWidth (140);    
                ItemClassColumn.setCellValueFactory(new PropertyValueFactory<>("itemClass"));      

                TableColumn<ItemModel, String> ItemNameColumn = new TableColumn<>("Item Name");
                ItemNameColumn.setMinWidth (100);    
                ItemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName")); 

                TableColumn<ItemModel, String> IssueUnitColumn = new TableColumn<>("Issue Unit");        
                IssueUnitColumn.setMinWidth (100);    
                IssueUnitColumn.setCellValueFactory(new PropertyValueFactory<>("issueUnit"));         

                TableColumn<ItemModel, String> PriceColumn = new TableColumn<>("Price");        
                PriceColumn.setMinWidth (70);    
                PriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));        

                TableColumn<ItemModel, String> DescriptionColumn = new TableColumn<>("Description");        
                DescriptionColumn.setMinWidth (200);    
                DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));           

                TableColumn<ItemModel, String> DosageColumn = new TableColumn<>("Dosage Form");        
                DosageColumn.setMinWidth (100);    
                DosageColumn.setCellValueFactory(new PropertyValueFactory<>("dosageForm"));     

                TableColumn<ItemModel, String> StrengthColumn = new TableColumn<>("strength");        
                StrengthColumn.setMinWidth (100);    
                StrengthColumn.setCellValueFactory(new PropertyValueFactory<>("strength"));        

                TableColumn<ItemModel, String> DrugClassColumn = new TableColumn<>("Drug Class");        
                DrugClassColumn.setMinWidth (100);    
                DrugClassColumn.setCellValueFactory(new PropertyValueFactory<>("drugclass"));               

                TableColumn<ItemModel, String> StatusColumn = new TableColumn<>("Status");        
                StatusColumn.setMinWidth (70);    
                StatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));               

                Iterator<ItemModel> itlist = list.iterator();
                while(itlist.hasNext())
                {
                ItemModel item = new ItemModel();
                item = itlist.next();
                
                itemsobs.add(new ItemModel(
                        item.getItemCode(),item.getItemClass(),
                        item.getItemName(),item.getIssueUnit(),
                        item.getPrice(),item.getDescription(),
                        item.getDosageForm(),item.getStrength(),
                        item.getDrugclass(),
                        item.getStatus()
                ));
                }
                
                TVitemEntry.getColumns().clear();
                TVitemEntry.setItems(itemsobs);
                TVitemEntry.getColumns().addAll(
                        ItemCodeColumn,ItemClassColumn,ItemNameColumn,
                        IssueUnitColumn,PriceColumn,DescriptionColumn,DosageColumn,
                        StrengthColumn,DrugClassColumn,StatusColumn);  
        
        
    }
}
