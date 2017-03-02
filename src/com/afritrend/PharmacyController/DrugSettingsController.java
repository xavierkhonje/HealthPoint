/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.common.AutoDrugSearchDataAccess;
import com.afritrend.common.DataAccess.DrugSettingsDataAccess;
import com.afritrend.common.Model.DrugConfiguration;
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

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class DrugSettingsController implements Initializable {

    @FXML
    ComboBox cbItemCode;   
    
    @FXML
    TextField txtMinmumLevel;
    
    @FXML
    TextField txtMaxLevel;
    
    @FXML
    TextField txtEWP;
    
    @FXML
    TableView TVItemConfig;
    
    @FXML
    Label lblcmscodeError;
    
    @FXML
    Label lblminimumlevelError;
    
    @FXML
    Label lblMaximumLevelError;
    
    @FXML
    Label lblEWarningError;
    
    @FXML
    Label lblGeneralMessage;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Getting the Dosage Forms
        List<String> Drugcmscodeslist = new ArrayList();        
        AutoDrugSearchDataAccess drugautodao = new AutoDrugSearchDataAccess();             
        
        Drugcmscodeslist = drugautodao.GetHPItemCode();
        
        Iterator<String> itCodes = Drugcmscodeslist.iterator();
        while(itCodes.hasNext())
        {
            String Code = itCodes.next();
            cbItemCode.getItems().add(Code);
        }
        
        DrugSettingsDataAccess drugSettingdao = new DrugSettingsDataAccess();
        DrugConfiguration drugconfig = new DrugConfiguration();
        List<DrugConfiguration> druglist = new ArrayList();
        druglist = drugSettingdao.GetDrugConfigurations();
        
        ShowList(druglist);
        
        lblcmscodeError.setText("*");    
        lblminimumlevelError.setText("*");    
        lblMaximumLevelError.setText("*");    
        lblEWarningError.setText("*");       
      
    }    
    
    @FXML
    public void SearchConf(ActionEvent event)
    {
        
    }
    
    @FXML
    public void RemoveDrugConf(ActionEvent event)
    {
        
    }
    
    @FXML
    public void UpdateDrugConf(ActionEvent event)
    {
        
    }
    
    @FXML
    public void SaveConfiguration(ActionEvent event)
    {
        DrugSettingsDataAccess drugSettingdao = new DrugSettingsDataAccess();
        DrugConfiguration drugconfig = new DrugConfiguration();
        try
        {
            String cmscode = String.valueOf(cbItemCode.getValue());
            drugconfig.setMinimumLevelIn(txtMinmumLevel.getText());
            drugconfig.setMaximumLevelIn(txtMaxLevel.getText());
            drugconfig.setEwdIn(txtEWP.getText());            
            drugconfig.setCmscode(cmscode);        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        
        if(drugconfig.ValidateDrugSettings())
        {
            String MSG = drugSettingdao.SaveDrugSettings(drugconfig);
            
            lblcmscodeError.setText("*");    
            lblminimumlevelError.setText("*");    
            lblMaximumLevelError.setText("*");    
            lblEWarningError.setText("*");  
            lblGeneralMessage.setText(MSG);
            
            List<DrugConfiguration> druglist = new ArrayList();
            druglist.add(drugconfig);      

            ShowList(druglist);               
        }
        else
        {
            lblcmscodeError.setText(drugconfig.cmscodeError);    
            lblminimumlevelError.setText(drugconfig.minimumLevelError);    
            lblMaximumLevelError.setText(drugconfig.maximumLevelError);    
            lblEWarningError.setText(drugconfig.ewdError);            
        }
        
                       
    }
    
    public void ShowList(List<DrugConfiguration> druglist)
    {
        ObservableList<DrugConfiguration> configs = FXCollections.observableArrayList();  
        
        TableColumn<DrugConfiguration, String> CMSCODEColumn = new TableColumn<>("CMS CODE");
        CMSCODEColumn.setMinWidth (200);    
        CMSCODEColumn.setCellValueFactory(new PropertyValueFactory<>("cmscode"));  
                
        TableColumn<DrugConfiguration, String> MaxColumn = new TableColumn<>("Maximum Level");
        MaxColumn.setMinWidth (200);    
        MaxColumn.setCellValueFactory(new PropertyValueFactory<>("maximumLevel"));      
        
        TableColumn<DrugConfiguration, String> MinColumn = new TableColumn<>("MiniMum Level");
        MinColumn.setMinWidth (200);    
        MinColumn.setCellValueFactory(new PropertyValueFactory<>("minmumLevel")); 
        
        TableColumn<DrugConfiguration, String> EWPColumn = new TableColumn<>("Exipry Waiting Period");        
        EWPColumn.setMinWidth (200);    
        EWPColumn.setCellValueFactory(new PropertyValueFactory<>("ewd"));             
        
        Iterator<DrugConfiguration> configit = druglist.iterator();
        while(configit.hasNext())
        {
            DrugConfiguration conf = new DrugConfiguration();
            conf = configit.next();
            configs.add(new DrugConfiguration(conf.getCmscode(),conf.getMinmumLevel(),conf.getMaximumLevel(),conf.getEwd()));
        }
              
        TVItemConfig.getColumns().clear();
        TVItemConfig.setItems(configs);
        TVItemConfig.getColumns().addAll(CMSCODEColumn,MaxColumn,MinColumn,EWPColumn);          
    }
    
}
