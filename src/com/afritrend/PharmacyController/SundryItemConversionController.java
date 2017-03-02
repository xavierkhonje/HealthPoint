/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.PharmacyDataAccess.ItemDataAccess;
import com.afritrend.PharmacyDataAccess.SundryDataAccess;
import com.afritrend.PharmacyModel.ItemModel;
import com.afritrend.PharmacyModel.SundryModel;
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
public class SundryItemConversionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    SundryDataAccess sundrydao = new SundryDataAccess();
    
    @FXML
    TableView TVSundryConversion;    
    
    //All the required fields to input
    @FXML
    ComboBox cbCmsClass;
    
    @FXML
    Label lblClasserror;    
    
    @FXML
    ComboBox cbCmsCode;    
    
    @FXML
    Label lblSundryNameError; 
    
    @FXML
    TextField txtSundryName;    
    
    @FXML
    Label lblCmscodeError;    
    
    @FXML
    TextField txtIssueUnit;  
    
    @FXML
    Label lblIssueUnitError;    
    
    @FXML
    TextField txtPrice;    
    
    @FXML
    Label lblPriceError;    
    
    @FXML
    TextArea txtDescription;    
    
    @FXML
    Label lblDescriptionError;    
    
    @FXML
    ComboBox cbSundrySource;  
    
    @FXML
    Label lblDSundrySource;        
    
    @FXML
    ComboBox cbSundryClass;
    
    @FXML
    Label lblSundryClassError;       
    
    @FXML
    Label lblGeneralMessage;       
    
    
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
            cbCmsClass.getItems().add(item);
        }     
        
//        cbDrugClass.getItems().clear();          

        //Get Drug Class
//        AutoDrugSearchDataAccess AutoDrug = new AutoDrugSearchDataAccess();        
        List<String> itemDrugclasslist = AutoDrug.GetDrug_Class();   
        Iterator<String> DrugitString = itemDrugclasslist.iterator();
        while(DrugitString.hasNext())
        {
            String item = DrugitString.next();
//            cbDrugClass.getItems().add(item);
        }         

        //Get Dosage Class      
        List<String> itemDosagelist = AutoDrug.GetDosageForms();   
        Iterator<String> itDString = itemDosagelist.iterator();
        while(itDString.hasNext())
        {
            String Dosage = itDString.next();
        }         
        
        lblClasserror.setText("*");
        lblCmscodeError.setText("*");
        lblIssueUnitError.setText("*");
        lblPriceError.setText("*");
        lblDescriptionError.setText("*");
        lblSundryNameError.setText("*");
        lblGeneralMessage.setText("");
    }    
    
    
    public void ConvertCMSCode(ActionEvent event)
    {     
            
            SundryModel item = new SundryModel();            
            
            double price = 0;
            
            if(txtPrice.getText().equals(""))
            {
                lblPriceError.setText("Please Enter Price");
            }
            else
            {
                 price = Double.valueOf(txtPrice.getText());
            }
            
            String code = String.valueOf(cbCmsCode.getValue());
            String CLass = String.valueOf(cbCmsClass.getValue());        
            String itemName = txtSundryName.getText();
            String IssueUnit = txtIssueUnit.getText();
            Double Price = Double.valueOf(txtPrice.getText());
            String description = txtDescription.getText();

            item.setCmscode(code);
            item.setCmsclass(CLass);
            item.setSundryname(itemName);
            item.setIssueUnit(IssueUnit);
            item.setPrice(Price);
            item.setDescription(description);    
            item.setSundryclass("");
            item.setSundrysource("");
            item.setStatus("Active");
            
            if(item.ValidateSundry() == false)
            {
                lblGeneralMessage.setText(item.getMessage());
                //Put the other errors
                lblSundryNameError.setText(item.sundrynameError);

                lblClasserror.setText("*");
                lblCmscodeError.setText("*");
                lblIssueUnitError.setText("*");
                lblPriceError.setText("*");
                lblDescriptionError.setText("*");
                lblSundryNameError.setText("*");
                lblGeneralMessage.setText("");              
                
            }
            else
            {
                //Convert the item and show results
                                
                String Msg = sundrydao.ConvertSundry(item);    
                
                lblClasserror.setText("*");
                lblCmscodeError.setText("*");
                lblIssueUnitError.setText("*");
                lblPriceError.setText("*");
                lblDescriptionError.setText("*");
                lblSundryNameError.setText("*");
                lblGeneralMessage.setText(Msg);      
                
                List<SundryModel> list = new ArrayList();
                list.add(item);
                
                ShowItems(list);
            }                    
    }
    
    public void Deactivate(ActionEvent event)
    {
        SundryModel item = new SundryModel(); 
        
        String code = String.valueOf(cbCmsCode.getValue());
        String CLass = String.valueOf(cbCmsClass.getValue());        
        String itemName = txtSundryName.getText();
        String IssueUnit = txtIssueUnit.getText();
        Double Price = Double.valueOf(txtPrice.getText());
        String description = txtDescription.getText();
        
        item.setCmscode(code);
        item.setCmsclass(CLass);
        item.setSundryname(itemName);
        item.setIssueUnit(IssueUnit);
        item.setPrice(Price);
        item.setDescription(description);  
        item.setSundrysource("");
        item.setSundryclass("");
        item.setStatus("InActive");
        
        //Update the Record
        String msg = sundrydao.DeactivateSundry(item);
        ShowItems(sundrydao.SearchSundry());
        lblGeneralMessage.setText(msg);        
    }
    
    public void Activate(ActionEvent event)
    {       
        SundryModel item = new SundryModel(); 
        
        
        String code = String.valueOf(cbCmsCode.getValue());
        String CLass = String.valueOf(cbCmsClass.getValue());        
        String itemName = txtSundryName.getText();
        String IssueUnit = txtIssueUnit.getText();
        Double Price = Double.valueOf(txtPrice.getText());
        String description = txtDescription.getText();
        
        item.setCmscode(code);
        item.setCmsclass(CLass);
        item.setSundryname(itemName);
        item.setIssueUnit(IssueUnit);
        item.setPrice(Price);
        item.setDescription(description);    
        item.setSundrysource("");
        item.setSundryclass("");        
        item.setStatus("Active");
        
        //Update the Record
        String msg = sundrydao.ActivateSundry(item);
        ShowItems(sundrydao.SearchSundry());
        lblGeneralMessage.setText(msg);        
    }
    
    public void Edit_Drug(ActionEvent event)
    {
        ItemDataAccess itemdao = new ItemDataAccess();
        SundryModel item = new SundryModel(); 
        
        String code = String.valueOf(cbCmsCode.getValue());
        String CLass = String.valueOf(cbCmsClass.getValue());        
        String itemName = txtSundryName.getText();
        String IssueUnit = txtIssueUnit.getText();
        Double Price = Double.valueOf(txtPrice.getText());
        String description = txtDescription.getText();
        
        item.setCmscode(code);
        item.setCmsclass(CLass);
        item.setSundryname(itemName);
        item.setIssueUnit(IssueUnit);
        item.setPrice(Price);
        item.setDescription(description);        
        
        //Update the Record
        String msg = sundrydao.UpdateSundry(item);
        ShowItems(sundrydao.SearchSundry());
        lblGeneralMessage.setText(msg);
    }
    
    public void ShowDetails(MouseEvent event)
    {
        SundryModel item = new SundryModel();
        item = (SundryModel)TVSundryConversion.getSelectionModel().getSelectedItem();
        
        cbCmsCode.setValue(item.getCmscode());
        cbCmsClass.setValue(item.getCmsclass());
        txtSundryName.setText(item.getSundryname());
        txtIssueUnit.setText(item.getIssueUnit());
        txtPrice.setText(String.valueOf(item.getPrice()));
        txtDescription.setText(item.getDescription());
    }
    
    public void SearchDrug(ActionEvent event)
    {        
        List<SundryModel> list = sundrydao.SearchSundry();
        ShowItems(list);
    }
    
    public void GetItemCode(ActionEvent event)
    {
        AutoDrugSearchDataAccess AutoDrug = new AutoDrugSearchDataAccess();
        List<String> itemCodelist = AutoDrug.GetItemCode(String.valueOf(cbCmsClass.getValue()));
        Iterator<String> itCodeString = itemCodelist.iterator();
        cbCmsCode.getItems().clear();
        while(itCodeString.hasNext())
        {
            String item = itCodeString.next();
            cbCmsCode.getItems().add(item);
        }       
    }
    
    public void GetItemName(ActionEvent event)
    {
        AutoDrugSearchDataAccess AutoDrug = new AutoDrugSearchDataAccess();
        List<Items> itemCodelist = AutoDrug.GetItemName(String.valueOf(cbCmsCode.getValue()));
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
    
    public void ShowItems(List<SundryModel> list)
    {
        
                ObservableList<SundryModel> itemsobs = FXCollections.observableArrayList();  
                
                TableColumn<SundryModel, String> CmsClassColumn = new TableColumn<>("CMS CLASS");
                CmsClassColumn.setMinWidth (100);    
                CmsClassColumn.setCellValueFactory(new PropertyValueFactory<>("cmsclass"));  

                TableColumn<SundryModel, String> CmsCodeColumn = new TableColumn<>("CMS CODE");
                CmsCodeColumn.setMinWidth (140);    
                CmsCodeColumn.setCellValueFactory(new PropertyValueFactory<>("cmscode"));      

                TableColumn<SundryModel, String> SundryNameColumn = new TableColumn<>("Sundry Name");
                SundryNameColumn.setMinWidth (100);    
                SundryNameColumn.setCellValueFactory(new PropertyValueFactory<>("sundryname")); 

                TableColumn<SundryModel, String> IssueUnitColumn = new TableColumn<>("Issue Unit");        
                IssueUnitColumn.setMinWidth (100);    
                IssueUnitColumn.setCellValueFactory(new PropertyValueFactory<>("issueUnit"));         

                TableColumn<SundryModel, String> PriceColumn = new TableColumn<>("Price");        
                PriceColumn.setMinWidth (70);    
                PriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));        

                TableColumn<SundryModel, String> DescriptionColumn = new TableColumn<>("Description");        
                DescriptionColumn.setMinWidth (200);    
                DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));                  

                TableColumn<SundryModel, String> StatusClassColumn = new TableColumn<>("Status");        
                StatusClassColumn.setMinWidth (100);    
                StatusClassColumn.setCellValueFactory(new PropertyValueFactory<>("status"));        

                Iterator<SundryModel> itlist = list.iterator();
                while(itlist.hasNext())
                {
                SundryModel item = new SundryModel();
                item = itlist.next();
                
                itemsobs.add(new SundryModel(
                        item.getCmsclass(),item.getCmscode(),
                        item.getSundryname(),item.getIssueUnit(),
                        item.getPrice(),item.getDescription(),
                        item.getSundrysource(),item.getSundryclass(),
                        item.getStatus()
                ));
                }
                
                TVSundryConversion.getColumns().clear();
                TVSundryConversion.setItems(itemsobs);
                TVSundryConversion.getColumns().addAll(
                        CmsClassColumn,CmsCodeColumn,SundryNameColumn,
                        IssueUnitColumn,PriceColumn,DescriptionColumn,
                        StatusClassColumn
                        );  
        
        
    }    
    
}
