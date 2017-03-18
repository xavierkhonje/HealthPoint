/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.Ward.Inpatient.Controller;

import com.afritrend.WardModel.GuardianModel;
import com.afritrend.WardModel.patientModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class InPatientGuardianController implements Initializable {

    @FXML
    TextField txtGr_firstname,txtGr_Othernames,txtGr_Lastname,txtGr_RelationShipType;
    
    @FXML
    Label lblPatientID;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void initData(patientModel patient)
    {
        lblPatientID.setText(patient.getPatientID());
    }
    
    private void SaveGuardian(ActionEvent event)
    {
            GuardianModel guardian = new GuardianModel();
            
//            guardian.setFirstname(txtGr_firstname.getText());
//            guardian.setOthernames(txtGr_Othernames.getText());
//            guardian.setLastname(txtGr_Lastname.getText());
//            guardian.setRelationshiptype(txtGr_RelationShipType.getText());        
//        
//            String Flag = "WHITE";
//            
//            if(guardian.validateGuardian())
//            {
//                    txtGrFirstnameError.setText("");
//                    txtGrOtherNamesError.setText("");
//                    txtLastNameError.setText("");
//                    txtRelationShipType.setText("");  
//            }   
//            else
//            {
//                Flag = "RED";
//                
//                txtGrFirstnameError.setText(guardian.firstnameError);
//                txtGrOtherNamesError.setText(guardian.othernamesError);
//                txtLastNameError.setText(guardian.lastnameError);
//                txtRelationShipType.setText(guardian.relationshipTypeError);
//            }        
    }
}
