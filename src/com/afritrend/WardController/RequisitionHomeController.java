/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardController;

import com.afritrend.WardDataAccess.RequisitionDataAccess;
import com.afritrend.common.Model.voucherModel;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class RequisitionHomeController implements Initializable {

    @FXML
    TableView TVVouchers;
    
    @FXML
    TextField txtvoucherNumber;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void ViewVouchers(ActionEvent event)
    {
       GetVouchers();
    }
    
    public void ApproveVoucher(ActionEvent event)
    {
        voucherModel voucher = new voucherModel(); 
        RequisitionDataAccess reqdao = new RequisitionDataAccess();
        try
        {
            
            voucher = (voucherModel)TVVouchers.getSelectionModel().getSelectedItem();
                        
            if(voucher == null)
            {
                System.out.println("Please select Voucher");
            }
        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        
        ApprovalModal(voucher.getVouchercode());
        
        reqdao.UpdatevoucherStatus(voucher.getVouchercode(), "PreparationApproved");
        
        GetVouchers();
    }
    
    public void GetVouchers()
    {
        ObservableList<voucherModel> itemsobs = FXCollections.observableArrayList();  

        List<voucherModel> vlist = new ArrayList();
        RequisitionDataAccess reqdao = new RequisitionDataAccess();
        vlist = reqdao.GETvoucherlist("4AWard","Preparation");

        TableColumn<voucherModel, String> VOUCHERCODEColumn = new TableColumn<>("VOUCHER NUMBER");
        VOUCHERCODEColumn.setMinWidth (200);    
        VOUCHERCODEColumn.setSortable(false);
        VOUCHERCODEColumn.setCellValueFactory(new PropertyValueFactory<>("vouchercode"));  

        TableColumn<voucherModel, String> ReqServiceColumn = new TableColumn<>("Requisition Service");
        ReqServiceColumn.setMinWidth (200);    
        ReqServiceColumn.setSortable(false);
        ReqServiceColumn.setCellValueFactory(new PropertyValueFactory<>("requisitionService"));      

        TableColumn<voucherModel, String> ReqDateColumn = new TableColumn<>("Requisition Date");
        ReqDateColumn.setMinWidth (200);    
        ReqDateColumn.setSortable(false);
        ReqDateColumn.setCellValueFactory(new PropertyValueFactory<>("requisitionDate")); 

        TableColumn<voucherModel, String> LastReferenceDateColumn = new TableColumn<>("Last Date Requisition Approved");        
        LastReferenceDateColumn.setMinWidth (200);    
        LastReferenceDateColumn.setSortable(false);  
        LastReferenceDateColumn.setCellValueFactory(new PropertyValueFactory<>("lastdateRequisitionApproved"));                     

        TableColumn<voucherModel, String> LastRefApprovedColumn = new TableColumn<>("Last Reference Approved");
        LastRefApprovedColumn.setMinWidth (200);    
        LastRefApprovedColumn.setSortable(false);    
        LastRefApprovedColumn.setCellValueFactory(new PropertyValueFactory<>("lastreferenceapprovedrequisition"));  

        TableColumn<voucherModel, String> CommentsColumn = new TableColumn<>("comments");
        CommentsColumn.setMinWidth (200);    
        CommentsColumn.setSortable(false);  
        CommentsColumn.setCellValueFactory(new PropertyValueFactory<>("comments"));      

        TableColumn<voucherModel, String> WardNameColumn = new TableColumn<>("Ward Number");
        WardNameColumn.setMinWidth (200);    
        WardNameColumn.setSortable(false); 
        WardNameColumn.setCellValueFactory(new PropertyValueFactory<>("wardName")); 

        TableColumn<voucherModel, String> TransactionTypeColumn = new TableColumn<>("Transaction Type");        
        TransactionTypeColumn.setMinWidth (200);    
        TransactionTypeColumn.setCellValueFactory(new PropertyValueFactory<>("requisitionTransactionType"));       

        TableColumn<voucherModel, String> VoucherStatusColumn = new TableColumn<>("Voucher Status");        
        VoucherStatusColumn.setMinWidth (200);    
        VoucherStatusColumn.setSortable(false);   
        VoucherStatusColumn.setCellValueFactory(new PropertyValueFactory<>("voucherstatus"));                 

        Iterator<voucherModel> vit = vlist.iterator();
        while(vit.hasNext())
        {
            voucherModel voucher = new voucherModel();
            voucher = vit.next();

            itemsobs.add(new voucherModel(
                    voucher.getVouchercode(),
                    voucher.getRequisitionService(),
                    voucher.getRequisitionDate(),
                    voucher.getLastdateRequisitionApproved(),
                    voucher.getLastreferenceapprovedrequisition(),
                    voucher.getComments(),
                    voucher.getWardName(),
                    voucher.getRequisitionTransactionType(),
                    voucher.getVoucherstatus()));                
        }

        TVVouchers.getColumns().clear();
        TVVouchers.setItems(itemsobs);
        TVVouchers.getColumns().addAll(
                VOUCHERCODEColumn,ReqServiceColumn,ReqDateColumn,
                LastReferenceDateColumn,LastRefApprovedColumn,CommentsColumn,
                WardNameColumn,TransactionTypeColumn,VoucherStatusColumn);          
    }
    
    public void ApprovalModal(String VoucherNumber)
    {
        try
        {
            FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Ward/WardApprovalModal.fxml"));
            Parent root = fxloader.load();
            
            WardApprovalModalController controller = fxloader.<WardApprovalModalController>getController();            
            controller.initData(VoucherNumber);                        

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UTILITY);
            stage.showAndWait();
        }
        catch(Exception e)            
        {
            System.out.println(e.getMessage());
        }
    }    
}
