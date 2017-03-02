/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.WardDataAccess.RequisitionDataAccess;
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
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.afritrend.common.Model.itemAmount;
import com.afritrend.common.DataAccess.ItemSummaryDataAccess;
import com.afritrend.common.Model.SessionManagement;
import com.afritrend.common.Model.UsersModel;
import com.afritrend.common.Model.requisitionModel;
import com.afritrend.common.Model.voucherModel;
import com.afritrend.common.sqlite.DataAccess.usersDataAccess;
import com.afritrend.common.sqlite.Model.user;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class PharmacyMainController implements Initializable {

    @FXML
    BorderPane MainBorderPane;    
    
    @FXML
    Label lblWelcomeText;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try
        {               
//            usersDataAccess usrdao = new usersDataAccess();
//            user usr = new user();
//            usr = usrdao.GetUsers();            
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/Home.fxml"));
            MainBorderPane.setCenter(root);         
            
            lblWelcomeText.setText("Welcome Back :" + SessionManagement._firstname +"  "+SessionManagement._lastname+"  "+SessionManagement._wardName);            
            
        }
        catch(Exception e)
        {
            
        }         
    }    
    
    private void Transition(Node e)
    {
        FadeTransition x = new FadeTransition(new Duration(2000),e);
        x.setFromValue(0);
        x.setToValue(100);
        x.setCycleCount(1);
        x.setInterpolator(Interpolator.LINEAR);
        x.play();
        
    }
    
    public void ItemEntry(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/ItemEntry.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
        
    
    @FXML
    public void SundryConversion(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/SundryItemConversion.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }        
    }
    
    @FXML
    public void ProcurementOrder(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/ProcurementOrder.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }        
    }
    
    @FXML
    private void OutPatientDepartment(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/OutPatientDepartment.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }          
    }
    
    @FXML
    public void LogOutHealthPoint(ActionEvent event)
    {
        try
        {
            Stage LoginStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/healthpointinventory/HealthPoint.fxml"));
            Scene scene = new Scene(root);
            LoginStage.setMaximized(true);
            LoginStage.centerOnScreen(); 
            LoginStage.getIcons().add(new Image("/Resources/HP_Logo.png"));
            LoginStage.setScene(scene);
            
            Stage stage = (Stage)MainBorderPane.getScene().getWindow();
            stage.close();            
            
            usersDataAccess usrdao = new usersDataAccess();
            usrdao.DeleteUser();              
            
            LoginStage.show();
        }
        catch(Exception e)            
        {
            System.out.println(e.getMessage());
        }        
    }
    
    public void ShowDrugSettings(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/DrugSettings.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
    
    public void ShowDrugSummary(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/DrugSummaryReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
    
    public void ShowSundrySummaryReport(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/SundrySummaryReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }        
    }
    
    public void OrderFrequencySummaryReport(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/OrderFrequencyReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }        
    }
    
    

       public void ShowDrugStockCard(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/DrugStockCard.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
       
    public void ShowSundryStockCard(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/SundryStockCard.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
       
   public void GoHome(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/Home.fxml"));
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
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/HospitalItemEntry.fxml"));
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
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/HospitalSundriesEntry.fxml"));
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
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/DrugsLostReport.fxml"));
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
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/SundriesLostReport.fxml"));
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
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/DrugsExpiryReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   
   public void ShowSundriesExpiryReport(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/DrugsSundryReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   public void ReviewRequisition(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/ReviewRequisition.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   
   public void ApproveRequisition(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/ApproveRequisition.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   
   public void NewWard(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/NewWard.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }
   
   public void InventoryReport(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/InventoryReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }   
   
   public void InventoryByLocationReport(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/InventoryByLocationReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }   
   
   public void InventoryBySupplierReport(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/InventoryBySupplierReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }   
   
   public void LevelStockReport(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/LowLevelStockReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }   
   
   public void BackOrderReport(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/BackOrderReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }   
   
   public void ConsumedReport(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/ConsumedReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }   
   
   public void IssuedHistoryReport(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/IssuedHistoryReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }   
   
   public void ReceivedHistoryReport(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/ReceivedHistoryReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }   
   
   public void LostHistoryReport(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/LostHistoryReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }   
   
   public void DamageHistoryReport(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/Pharmacy/DamagedHistoryReport.fxml"));
            MainBorderPane.setCenter(root);
        }
        catch(Exception e)            
        {
            
        }
    }   
   
   public void NewRequisition(ActionEvent event)
   {
       RequisitionDataAccess requidao = new RequisitionDataAccess();
       requisitionModel req = new requisitionModel();
       List<requisitionModel> requilist = new ArrayList();
       voucherModel voucher = new voucherModel();
       
       voucher.setRequisitionService("QuantityBeingRequested");
       voucher.setWardName("4AWard");
       voucher.setComments("Testing from App");
       voucher.setRequisitionTransactionType("QuantityBeingRequested");
       
       req.setScaleUnit("6656");
       req.setAmount(23344);
       req.setItemType("Drug");
       req.setCmscode("AA007500");

       requilist.add(req);
       
       String MSG = requidao.SaveRequisition(requilist, voucher);       
       
        Notifications notification = Notifications.create()
                .title("Drug Saved")
                .text(MSG)
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT)
                .onAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event)
                    {
                        System.out.println("Clicked on Notification");
                    }
                });
        
        notification.showConfirm();              
   }
    
}
