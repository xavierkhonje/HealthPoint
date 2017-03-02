/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardController;

import com.afritrend.Ward.Factory.WardFactory;
import com.afritrend.WardDataAccess.RequisitionDataAccess;
import com.afritrend.WardModel.ItemsModel;
import com.afritrend.common.Model.SessionManagement;
import com.afritrend.common.Model.UsersModel;
import com.afritrend.common.Model.requisitionModel;
import com.afritrend.common.Model.voucherModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class WardMainController implements Initializable {
    @FXML
    BorderPane MainBorderPane;   
    
    @FXML
    Label lblLogedUserStatus;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try
        {

            
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/Home.fxml"));
            MainBorderPane.setCenter(root);        
            
            lblLogedUserStatus.setText("Welcome Back :" + SessionManagement._firstname +"  "+SessionManagement._lastname+"  "+SessionManagement._wardName);            
        }
        catch(Exception e)
        {
            
        } 
    }
    
    public void ItemEntry(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/ItemEntry.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
    
    public void ShowDrugSettings(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/WardDrugSettings.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
    
    public void ShowDrugSummary(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/WardDrugSummaryReport.fxml"));
            MainBorderPane.setCenter(root);
            
            //code here
            System.out.println("Report Feature coming through");
            
            TestReports();
        }
        catch(Exception e)            
        {
            
        }
    }

   public void ShowDrugStockCard(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/WardDrugStockCard.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   
   @FXML
   private void ShowOutPatientDepartment(ActionEvent event)
   {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/OutPatientDepartment.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }       
   }
       
   public void GoHome(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/Home.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   
   public void ShowDrugsEntry(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/WardItemEntry.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   
   public void ShowSundriesEntry(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/WardSundriesEntry.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   
   public void ShowDrugsLostReport(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/WardDrugsLostReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   
   public void ShowSundriesLostReport(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/WardSundriesLostReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   public void ShowDrugsExpiryReport(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/WardDrugsExpiryReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   
   public void ShowSundriesExpiryReport(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/WardDrugsSundryReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }  
   
   public void NewRequisition(ActionEvent event)
   {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/NewRequisition.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }            
   }   
   
   public void ViewRequisition(ActionEvent event)
   {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/RequisitionHome.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }         
   }
   
   public void ReceiveOrder(ActionEvent event)
   {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/ReceiveOrder.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }         
   }
   
   public void FinalizeOrder(ActionEvent event)
   {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Ward/FinalizeOrder.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }         
   }
   
    public void LogOutHealthPoint(ActionEvent event)
    {
        try
        {
            Stage LoginStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/healthpointinventory/HealthPoint.fxml"));
            Scene scene = new Scene(root);
            LoginStage.setMaximized(true);
            LoginStage.centerOnScreen();        
            LoginStage.initStyle(StageStyle.UNDECORATED);            
            LoginStage.setScene(scene);
            
            Stage stage = (Stage)MainBorderPane.getScene().getWindow();
            stage.close();
            
            LoginStage.show();
        }
        catch(Exception e)            
        {
            System.out.println(e.getMessage());
        }        
    }
    
    public void TestReports()
    {
        try
        {                  
            String Path = "F:\\Products\\DesktopApps\\HealthPointInventory\\src\\com\\afritrend\\Ward\\Reports\\Test.jrxml";
            JasperReport Jasp_Rep = JasperCompileManager.compileReport(Path);            
            JasperPrint Jasperprint = JasperFillManager.fillReport(Jasp_Rep,null, new JRBeanCollectionDataSource(ItemsModel.GetItemsCollection()));
            JasperViewer.viewReport(Jasperprint, false);  
        }
        catch(Exception e)
        {
        }
    }
    
}
