/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.WardDataAccess.RequisitionDataAccess;
import com.afritrend.common.Model.WardNormalPharmacyApproval;
import com.afritrend.common.Model.WardNormalRequisitionReview;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class PharmacyApproveModalController implements Initializable {

    @FXML
    TableView ReviewModalTV;
    
    public String voucherNumber;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Populate the table view with Data to Review  
        List<WardNormalPharmacyApproval> reqlist = new ArrayList();
        RequisitionDataAccess reqdao = new RequisitionDataAccess();
        reqdao.GETWardApprovedRequisition(voucherNumber);
        
        ShowReviewRequisition(reqlist);
    }    
    
    public void initData(String VoucherNum)
    {
        voucherNumber = VoucherNum;
    }
    
    @FXML
    private void ShowApproveRequisitions(ActionEvent event)
    {
        
    }
    
    
    
    public void ShowReviewRequisition(List<WardNormalPharmacyApproval> reqlist)
    {
            ObservableList<WardNormalPharmacyApproval> itemsobs = FXCollections.observableArrayList();  

            TableColumn<WardNormalPharmacyApproval, String> QuantityPackedColumn = new TableColumn<>("Quantity Packed");
            QuantityPackedColumn.setMinWidth (200);    
            QuantityPackedColumn.setSortable(false);   
            QuantityPackedColumn.setCellValueFactory(new PropertyValueFactory<>("quantityPacked"));  

            TableColumn<WardNormalPharmacyApproval, String> QuantityApprovedColumn = new TableColumn<>("Quantity Approved");
            QuantityApprovedColumn.setMinWidth (200);    
            QuantityApprovedColumn.setSortable(false);   
            QuantityApprovedColumn.setCellValueFactory(new PropertyValueFactory<>("quantityApproved"));      

            TableColumn<WardNormalPharmacyApproval, String> ApproverColumn = new TableColumn<>("Approver");
            ApproverColumn.setMinWidth (200);    
            ApproverColumn.setSortable(false);  
            ApproverColumn.setCellValueFactory(new PropertyValueFactory<>("approvedBy")); 

            TableColumn<WardNormalPharmacyApproval, String> RequisitionColumn = new TableColumn<>("Requistion id");
            RequisitionColumn.setMinWidth (200);    
            RequisitionColumn.setSortable(false);  
            RequisitionColumn.setCellValueFactory(new PropertyValueFactory<>("reqid"));                                 

            Iterator<WardNormalPharmacyApproval> reqit = reqlist.iterator();
            while(reqit.hasNext())
            {
                WardNormalPharmacyApproval requistion = new WardNormalPharmacyApproval();
                requistion = reqit.next();

                itemsobs.add(new WardNormalPharmacyApproval(
                        requistion.getQuantityPacked(),
                        requistion.getQuantityApproved(),
                        requistion.getDrugName(),
                        requistion.getStrength(),
                        requistion.getDosageForm(),
                        requistion.getIssueUnit(),
                        requistion.getApprovedBy(),                  
                        requistion.getReqid()));                  
            }
            ReviewModalTV.getColumns().clear();
            ReviewModalTV.setItems(itemsobs);
            ReviewModalTV.getColumns().addAll(
                    QuantityPackedColumn,QuantityApprovedColumn,ApproverColumn,
                    RequisitionColumn);        
    }
    
}
