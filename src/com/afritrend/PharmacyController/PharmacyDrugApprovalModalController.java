/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.WardDataAccess.RequisitionDataAccess;
import com.afritrend.common.Model.SessionManagement;
import com.afritrend.common.Model.WardNormalPharmacyApproval;
import com.afritrend.common.Model.WardNormalRequisitionReview;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class PharmacyDrugApprovalModalController implements Initializable {
    @FXML
    TableView ApproveTV;
    
    @FXML
    TextField txtUpdateApproved;
    
    public final String SerialFile = "PharmacyApprovalRequisition.ser";
    
    public String VCNumber = "";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    
    public void initData(String VoucherNumber)
    {
        VCNumber = VoucherNumber;
    }
    
    
    @FXML
    private void ShowApproveRequisitions(ActionEvent event)
    {        
        List<WardNormalPharmacyApproval> reqlist = new ArrayList();
        RequisitionDataAccess reqdao = new RequisitionDataAccess();
        reqlist = reqdao.GETAllPharmacyPackedRequisition(VCNumber); 
        
        //Serialize the items
        try
        {
            File serialFile = new File(SerialFile);

            if(serialFile.exists())
            {
                Serialize(SerialFile, reqlist);                    
            }
            else
            {
                serialFile.createNewFile();
                Serialize(SerialFile, reqlist);     
            }     
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }        
        
        ShowReviewRequisition(reqlist);
        
    }    
    
    @FXML
    public void testbtn(ActionEvent event)
    {
        System.out.println(VCNumber);
    }
    
    @FXML
    private void GetSelectedItem(MouseEvent event)
    {
        WardNormalPharmacyApproval wardapproval = new WardNormalPharmacyApproval();
        wardapproval = (WardNormalPharmacyApproval)ApproveTV.getSelectionModel().getSelectedItem();                
        
        txtUpdateApproved.setText(String.valueOf(wardapproval.getQuantityPacked()));        
    }
    
    @FXML
    private void UpdateRequisition(ActionEvent event)
    {
        WardNormalPharmacyApproval wardapproval = new WardNormalPharmacyApproval();
        
        try
        {
            wardapproval = (WardNormalPharmacyApproval)ApproveTV.getSelectionModel().getSelectedItem();
            
            if(wardapproval == null)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Unable to Update Item");
                alert.setContentText("Please Select a row");

                alert.showAndWait();                 
            }
            else
            {
                wardapproval.setQuantityApproved(Integer.valueOf(txtUpdateApproved.getText()));
                wardapproval.setApprovedBy(SessionManagement._email);
                //validate the Text Field for any errors that are not wanted
                
                RequisitionDataAccess reqdao = new RequisitionDataAccess();
                reqdao.UPDATEPharmacyNormalRequisitionsApproved(wardapproval); 
                
                WardNormalPharmacyApproval pharmapproveremoval = new WardNormalPharmacyApproval();
                List<WardNormalPharmacyApproval> reqlist = new ArrayList();
                
                try
                {
                    reqlist = Deserialized(SerialFile);

                    int num = ApproveTV.getSelectionModel().getSelectedIndex();
                    pharmapproveremoval = reqlist.get(num);        

                    reqlist.remove(pharmapproveremoval);
                    reqlist.add(num, wardapproval);

                    Serialize(SerialFile, reqlist);                
                    ShowReviewRequisition(reqlist);
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }                
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    @FXML
    private void ApproveVoucher(ActionEvent event)
    {
        RequisitionDataAccess reqdao = new RequisitionDataAccess();
        reqdao.UpdatevoucherStatus(VCNumber, "PharmacyApproved");  
        
        Stage stage = (Stage)txtUpdateApproved.getScene().getWindow();
        stage.close();
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
            ApproveTV.getColumns().clear();
            ApproveTV.setItems(itemsobs);
            ApproveTV.getColumns().addAll(
            QuantityPackedColumn,QuantityApprovedColumn,ApproverColumn,
            RequisitionColumn);        
    }    
    
    public static List<WardNormalPharmacyApproval> Deserialized(String Filename) throws Exception
    {
        List<WardNormalPharmacyApproval> reqlist = new ArrayList();
        WardNormalPharmacyApproval req = new WardNormalPharmacyApproval();        
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(Filename));
        reqlist = (List<WardNormalPharmacyApproval>)in.readObject();
        return reqlist;
    }        
    
    public static String Serialize(String SerialFile, List serializelist)throws Exception
    {
        FileOutputStream fout = null;
        ObjectOutputStream out = null;
        try
        {
            fout = new FileOutputStream(SerialFile);
            out = new ObjectOutputStream(fout);
            out.writeObject(serializelist);
            out.flush();              
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            fout.close();
            out.close();            
        }
        
        return "Order Added";
    }      
    
}
