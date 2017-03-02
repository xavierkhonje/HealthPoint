/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.WardDataAccess.WardDataAccess;
import com.afritrend.WardModel.wardUser;
import com.afritrend.common.DataAccess.UsersDataAccess;
import com.afritrend.common.Model.SessionManagement;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class WardDetailsModalController implements Initializable {

    @FXML
    TableView WardUsersTV;
    
    @FXML
    TextField txtFirstName;
    
    @FXML
    TextField txtMiddleName;
    
    @FXML
    TextField txtLastName;
    
    @FXML
    TextField txtHomeTelNumber;
    
    @FXML
    TextField txtOfficeTel;
    
    @FXML
    TextField txtDesignation;
    
    @FXML
    TextField txtAnswer;
    
    @FXML
    JFXTextField txt_email;
    
    @FXML
    ComboBox Question;
    
    @FXML
    ComboBox cbUsergroup;
    
    @FXML
    TextField txtEmail;
    
    @FXML
    PasswordField pwd_ConfirmPassword;
    
    @FXML
    PasswordField pwd_Password;
    
    @FXML
    JFXPasswordField txt_passwordfield;
    
    @FXML
    JFXPasswordField txt_Confirm_passwordfield;         
    
    @FXML
    Label lblFirstNameError;
    
    @FXML
    Label lblMiddleNameError;
    
    @FXML
    Label lblLastNameError;
    
    @FXML
    Label lblOfficeTelError;
    
    @FXML
    Label lblHomeTelError;
    
    @FXML
    Label lblEmailAddressError;
    
    @FXML
    Label pwdPasswordError;
    
    @FXML
    Label pwdConfirmPasswordError;    
    
    List<wardUser> warduserlist = new ArrayList();
    WardDataAccess warddao = new WardDataAccess();    
    
    public String wardname;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbUsergroup.getItems().addAll("WardUser", "Administrator");
    }    
    
    public void initData(String WardName)
    {
        wardname = WardName;
        
        warduserlist = warddao.getWardUsers(WardName);
        
        ShowWardUsers(warduserlist);        
    }
    
    @FXML
    private void GetSelectedItem(MouseEvent event)
    {
        wardUser user = (wardUser)WardUsersTV.getSelectionModel().getSelectedItem();        
        txtFirstName.setText(user.getFirstname());
        txtMiddleName.setText(user.getMiddlename());
        txtLastName.setText(user.getLastname());
        txtHomeTelNumber.setText(user.getHome_tel());
        txtOfficeTel.setText(user.getOffice_tel());
        txtDesignation.setText(user.getDesignation());
        txtAnswer.setText(user.getAnswer());
        txtEmail.setText(user.getEmail());        
    }
        
    @FXML
    private void AddNewUser(ActionEvent event)
    {            
        wardUser user = new wardUser();
        user.setFirstname(txtFirstName.getText());
        user.setMiddlename(txtMiddleName.getText());
        user.setLastname(txtLastName.getText());
        user.setHome_tel(txtHomeTelNumber.getText());
        user.setOffice_tel(txtOfficeTel.getText());
        user.setDesignation("Ward");
        user.setAnswer(txtAnswer.getText());
        user.setTest_Question(txtAnswer.getText());
        user.setEmail(txtEmail.getText());
        user.setWard(wardname);
        user.setPassword(pwd_Password.getText());
        user.setConfirmPassword(pwd_ConfirmPassword.getText());
        user.setStatus("Active");
        user.setUsergroup("Ward");
        //String.valueOf(cbUsergroup.getValue())

        String UFlag = "WHITE";
        
        if(user.ValidateUser())
        {
            pwdConfirmPasswordError.setText("Confirm Password");
            pwdPasswordError.setText("Password");
            lblEmailAddressError.setText("Email");
            lblHomeTelError.setText("Home Tel");
            lblOfficeTelError.setText("Office Tel");
            lblLastNameError.setText("Last Name");
            lblMiddleNameError.setText("Middle Name");
            lblFirstNameError.setText("First Name");                
        }
        else
        {
            UFlag = "RED";   
            
            pwdConfirmPasswordError.setText(user.confirmPasswordError);
            pwdPasswordError.setText(user.passwordError);
            lblEmailAddressError.setText(user.emailError);
            lblHomeTelError.setText(user.home_telError);
            lblOfficeTelError.setText(user.office_telError);
            lblLastNameError.setText(user.lastnameError);
            lblMiddleNameError.setText(user.middlenameError);
            lblFirstNameError.setText(user.firstnameError);            
        }
                
        if(UFlag.equals("WHITE"))
        {            
            UsersDataAccess usrdao = new UsersDataAccess();
            usrdao.SaveWardusers(user);        

            warduserlist = warddao.getWardUsers(wardname);
            ShowWardUsers(warduserlist);                     
        }
        

        
          
    }
    
    @FXML
    private void UpdateUser(ActionEvent event)
    {
        
    }
    
    @FXML
    private void SaveCredentials(ActionEvent event)
    {
        
    }
    
    @FXML
    private void UpdateCredentials(ActionEvent event)
    {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Password Confirmation");
        dialog.setHeaderText("Please provide Old Password");
        dialog.setContentText("Please enter your old Password:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent())
        {
            //verify the old Password
            System.out.println("The Password is: " + result.get());
        }        
    }
    
    @FXML
    private void CheckPasswordMatch(ActionEvent event)
    {
        
    }
    
    public void ShowWardUsers(List<wardUser> warduserlist)
    {
            ObservableList<wardUser> itemsobs = FXCollections.observableArrayList();  

            TableColumn<wardUser, String> FirstNameColumn = new TableColumn<>("FirstName");
            FirstNameColumn.setMinWidth (200);    
            FirstNameColumn.setSortable(false);   
            FirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstname"));  

            TableColumn<wardUser, String> MiddleNameColumn = new TableColumn<>("Middle Name");
            MiddleNameColumn.setMinWidth (200);    
            MiddleNameColumn.setSortable(false);   
            MiddleNameColumn.setCellValueFactory(new PropertyValueFactory<>("middlename"));      

            TableColumn<wardUser, String> LastNameColumn = new TableColumn<>("Last Name");
            LastNameColumn.setMinWidth (200);    
            LastNameColumn.setSortable(false);  
            LastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastname")); 

            TableColumn<wardUser, String> EmailColumn = new TableColumn<>("Email");
            EmailColumn.setMinWidth (200);    
            EmailColumn.setSortable(false);  
            EmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));                                 

            Iterator<wardUser> reqit = warduserlist.iterator();
            while(reqit.hasNext())
            {
                wardUser user = new wardUser();
                user = reqit.next();

                itemsobs.add(new wardUser(
                        user.getFirstname(),
                        user.getMiddlename(),
                        user.getLastname(),
                        user.getOffice_tel(),
                        user.getHome_tel(),
                        user.getLast_login(),
                        user.getPassword_retries(),                  
                        user.getDesignation(),                  
                        user.getEmail(),
                        user.getPassword(),
                        user.getStatus(),
                        user.getReset_password_Key(),
                        user.getTest_Question(),
                        user.getTest_Question(),
                        user.getTest_Question(),
                        user.getAnswer(),
                        user.getWard(),                  
                        user.getUsergroup(),                        
                        user.getUsergroup(),                        
                        "Message"                        
                
                ));                  
            }
            WardUsersTV.getColumns().clear();
            WardUsersTV.setItems(itemsobs);
            WardUsersTV.getColumns().addAll(
                    FirstNameColumn,MiddleNameColumn,LastNameColumn,
                    EmailColumn);        
    }
}
