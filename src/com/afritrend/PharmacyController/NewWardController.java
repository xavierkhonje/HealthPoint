/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.PharmacyModel.WardModel;
import com.afritrend.WardDataAccess.WardDataAccess;
import com.afritrend.WardModel.wardUser;
import com.afritrend.common.DataAccess.UsersDataAccess;
import com.afritrend.common.Model.UsersModel;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
public class NewWardController implements Initializable {

    @FXML
    TextField txtWardName;
    
    @FXML
    TextArea txtWardLocation;
    
    @FXML
    Label WardNameError;
    
    @FXML
    Label WardLocationError;
    
    @FXML
    TableView TVWards;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               
        List<WardModel> wardslist = new ArrayList();
        
        WardDataAccess warddao = new WardDataAccess();
        wardslist = warddao.getWardDetails();         
        
        ShowWards(wardslist);
    }    
    
    @FXML
    private void GetSelectedWard(MouseEvent event)
    {
        WardModel ward = (WardModel)TVWards.getSelectionModel().getSelectedItem();
        ShowWardDetailsModal(ward);
    }
    
    @FXML
    public void SaveWard(ActionEvent event)
    {
        String WardName = txtWardName.getText();
        String WardLocation = txtWardLocation.getText();
        
        //User
//        String Fname = txtFirstName.getText();
//        String MName = txtMiddleName.getText();
//        String Lname = txtLastName.getText();
//        String HTel = txtHomeTel.getText();
//        String OTel = txtOfficeTel.getText();
//        String Email = txtEmail.getText();
//        String Password = txtPassword.getText();
//        String ConfirmPassword = txtConfirmPassword.getText();
        

        
        WardModel ward = new WardModel();
        ward.setWardName(WardName);
        ward.setLocation(WardLocation);
        
        String WFlag = "WHITE";
        String UFlag = "WHITE";
        
        if(ward.validateWard())
        {            
            WardNameError.setText("*");
            WardLocationError.setText("*");                        
        }
        else            
        {
            WFlag = "RED";
            
            WardNameError.setText(ward.wardNameError);
            WardLocationError.setText(ward.locationError);            
        }
        
        
        if(UFlag.equals("WHITE") && WFlag.equals("WHITE"))
        {
            WardDataAccess warddao = new WardDataAccess();            
            warddao.saveWard(ward);
            
            List<WardModel> wardslist = new ArrayList();
            wardslist = warddao.getWardDetails();         

            ShowWards(wardslist);                       
        }
        

        
    }
    
    public void ShowWards(List<WardModel> wardslist)
    {        
            ObservableList<WardModel> itemsobs = FXCollections.observableArrayList();  

            TableColumn<WardModel, String> WardNameColumn = new TableColumn<>("Ward Name");
            WardNameColumn.setMinWidth (200);    
            WardNameColumn.setSortable(false);   
            WardNameColumn.setCellValueFactory(new PropertyValueFactory<>("wardName"));  

            TableColumn<WardModel, String> LocationColumn = new TableColumn<>("Location");
            LocationColumn.setMinWidth (200);    
            LocationColumn.setSortable(false);   
            LocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));                                    

            Iterator<WardModel> wardit = wardslist.iterator();
            while(wardit.hasNext())
            {
                WardModel ward = new WardModel();
                ward = wardit.next();

                itemsobs.add(new WardModel(
                        ward.getWardName(),
                        ward.getLocation()));                  
            }
            
            TVWards.getColumns().clear();
            TVWards.setItems(itemsobs);
            TVWards.getColumns().addAll(WardNameColumn,LocationColumn);         
    }
    
    public void ShowWardDetailsModal(WardModel ward)
    {        
        try
        {
            FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Pharmacy/WardDetailsModal.fxml"));
            Parent root = fxloader.load();
            
            WardDetailsModalController controller = fxloader.<WardDetailsModalController>getController();                      
            controller.initData(ward.getWardName());            

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);            
            stage.showAndWait();
        }
        catch(Exception e)            
        {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            e.printStackTrace();
        }         
    }
    
}
