/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardController;

import com.afritrend.PharmacyDataAccess.OPDPrescriptionDataAccess;
import com.afritrend.PharmacyModel.OPDPrescriptionModel;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utility.Barcoder;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class OutPatientDepartmentController implements Initializable {

    @FXML
    TableView PatientTV;
    
    @FXML
    BorderPane MainBorderPane;     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void saveprescription(ActionEvent event)
    {
        OPDPrescriptionModel OPDModel = new OPDPrescriptionModel();
        OPDModel.setPatientNo("ID0000001");
        OPDModel.setCmsCode("AA000300");
        OPDModel.setAdmissionCode("PO");
        OPDModel.setFrequency(3);
        
        Barcoder.BarcodeCreate(OPDModel.getPatientNo());
        
        File ff = new File("C:\\EDMSFOLDER\\QRCode.png");
        String img = ff.getAbsolutePath();

        OPDPrescriptionDataAccess opdao = new OPDPrescriptionDataAccess();
       String feedback = opdao.SavePrescription(OPDModel, img);
       System.out.println(feedback);
    }
    
    @FXML
    private void GetOPDPrescriptions(ActionEvent event)
    {
        OPDPrescriptionDataAccess opdao = new OPDPrescriptionDataAccess();        
        opdao.GetPatientPrescription("ID0000001","00001");
        
        testchangescene();
    }
    
    @FXML
    private void PatientSelect_DrugPrescribe(MouseEvent event)
    {
        try 
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/OPDPrescription.fxml"));            
            MainBorderPane.setCenter(root);        
            
//            Scene Prescription = new Scene(root);
//            Stage stage = (Stage)PatientTV.getScene().getWindow();
//            stage.setScene(Prescription);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(OutPatientDepartmentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ShowPatients()
    {
        
    }
    
    private void testchangescene()
    {
        try 
        {
            Stage stage = (Stage)PatientTV.getScene().getWindow();
            
            
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/OPDPrescription.fxml"));            
            MainBorderPane.setCenter(root);             
            
//            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/OPDPrescription.fxml"));
//            Scene Prescription = new Scene(root);
//            Stage stage = (Stage)PatientTV.getScene().getWindow();
//            stage.setScene(Prescription);
        } 
        catch (Exception ex) 
        {
            System.out.println(ex.getMessage());
        }        
    }
    
}
