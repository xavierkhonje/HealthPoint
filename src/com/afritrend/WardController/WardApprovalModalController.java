/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardController;

import com.afritrend.WardDataAccess.RequisitionDataAccess;
import com.afritrend.common.Model.WardNormalRequisitionsApproved;
import com.afritrend.common.Model.requisitionModel;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class WardApprovalModalController implements Initializable {

    @FXML
    TableView ApproveTV;
    
    @FXML
    TextField txtUpdateApproved;
    
    public int selectindex;
    
    public String NewFileName;
    
    public String voucherNumber;
    
    public static String Voucher;
    
    public final String SerialFile = "WardAdminApprovalRequisition.ser";    
      
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }    
    
    public void initData(String voucherNumber)
    {
        populateModal(voucherNumber);        
    }
    
    public void populateModal(String Vnumber)
    {
        try
        {
                RequisitionDataAccess reqdao = new RequisitionDataAccess();
                        
//                ApproveRequisitionController approve = new ApproveRequisitionController();
//                String voucherNum = RequisitionHomeController.VoucherNumberSelected;
//                voucherNumber = voucherNum;
                //get Requisition Requested
                List<requisitionModel> approvlist = new ArrayList();
                List<WardNormalRequisitionsApproved> NormalWardApp = new ArrayList();
                
                approvlist = reqdao.GETRequestedRequisition(Vnumber);
                Iterator<requisitionModel> reqit = approvlist.iterator();
                while(reqit.hasNext())
                {
                    WardNormalRequisitionsApproved approvalWard = new WardNormalRequisitionsApproved();                      
                    requisitionModel req = new requisitionModel();
                    req = reqit.next();
                    
                    approvalWard.setQuantityRequested(req.getAmount());
                    approvalWard.setCmscode(req.getCmscode());
                    approvalWard.setItemtype(req.getItemType());
                    approvalWard.setScaleunit(req.getScaleUnit());
                    approvalWard.setRequisitionid(req.getRequisitionid());
                    
                    NormalWardApp.add(approvalWard);
                }
                
                NewFileName = SerialFile;
                File serialFile = new File(NewFileName);
                
                if(serialFile.exists())
                {
                    Serialize(NewFileName, NormalWardApp);                    
                }
                else
                {
                    serialFile.createNewFile();
                    Serialize(NewFileName, NormalWardApp);     
                }
                              
                ShowOrderApproval(NormalWardApp);                
        }
        catch(Exception e)
        {
            
        }        
    }
    
    public void ShowUpdateRow(MouseEvent event)
    {
        try
        {
            WardNormalRequisitionsApproved approvalWard = new WardNormalRequisitionsApproved();   
            approvalWard = (WardNormalRequisitionsApproved)ApproveTV.getSelectionModel().getSelectedItem();
            int item = ApproveTV.getSelectionModel().getSelectedIndex();
            selectindex = item;
            if (approvalWard == null) return;

            txtUpdateApproved.setText(String.valueOf(approvalWard.getQuantityRequested()));
            String AmountApproved = txtUpdateApproved.getText();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void UpdateRow(ActionEvent event)
    {               
        try
        {
            WardNormalRequisitionsApproved approvalWard = new WardNormalRequisitionsApproved();   
            //approvalWard = (WardNormalRequisitionsApproved)ApproveTV.getSelectionModel().getSelectedItem();
            
//            int item = ApproveTV.getSelectionModel().getSelectedIndex();
            int item = selectindex;
            
            List<WardNormalRequisitionsApproved> reglist = new ArrayList();
            reglist = Deserialized(NewFileName);
            
            approvalWard = reglist.get(item);
                        
            //txtUpdateApproved.setText(String.valueOf(approvalWard.getQuantityRequested()));
            
            int AmountApproved = Integer.valueOf(txtUpdateApproved.getText());
            
            approvalWard.setQuantityApproved(AmountApproved); 
            
            reglist.remove(item);
            reglist.add(item, approvalWard);
            
            Serialize(NewFileName, reglist);             
            
            ShowOrderApproval(reglist);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void SubmitOrder_Pharmacy(ActionEvent event)
    {

        try 
        {
            List<WardNormalRequisitionsApproved> reglist = new ArrayList();            
            reglist = Deserialized(NewFileName);
            //Save the Requisition Details
            RequisitionDataAccess reqdao = new RequisitionDataAccess();
            reqdao.SaveWardNormalRequisitionsApproved(reglist);
            reglist.clear();
            Serialize(NewFileName, reglist); 
            
            ShowOrderApproval(reglist);
            
        } catch (Exception ex) 
        {
            Logger.getLogger(WardApprovalModalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            Stage stage = (Stage)ApproveTV.getScene().getWindow();
            stage.close();
        }
    }
    
    public void ShowSelected(ActionEvent event)
    {
        System.out.println("You Clicked Me");
    }
    
    public static List<WardNormalRequisitionsApproved> Deserialized(String Filename) throws Exception
    {
        List<WardNormalRequisitionsApproved> reqlist = new ArrayList();
        requisitionModel req = new requisitionModel();        
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(Filename));
        reqlist = (List<WardNormalRequisitionsApproved>)in.readObject();
        return reqlist;
    }      
    
    public static String Serialize(String FileName, List serializelist)throws Exception
    {
        FileOutputStream fout = null;
        ObjectOutputStream out = null;
        try
        {
            fout = new FileOutputStream(FileName);
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
    
    public void ShowOrderApproval(List<WardNormalRequisitionsApproved> list)
    {
        ObservableList<WardNormalRequisitionsApproved> itemsobs = FXCollections.observableArrayList();  

        TableColumn<WardNormalRequisitionsApproved, String> QRequestedColumn = new TableColumn<>("Quantity Requested");
        QRequestedColumn.setSortable(false);
        QRequestedColumn.setMinWidth (200);    
        QRequestedColumn.setCellValueFactory(new PropertyValueFactory<>("quantityRequested"));  

        TableColumn<WardNormalRequisitionsApproved, String> QApprovedColumn = new TableColumn<>("Quantity Approved");
        QApprovedColumn.setMinWidth (200);    
        QApprovedColumn.setSortable(false);   
        QApprovedColumn.setCellValueFactory(new PropertyValueFactory<>("quantityApproved"));      

        TableColumn<WardNormalRequisitionsApproved, String> ReservedColumn = new TableColumn<>("Quantity Reserved");
        ReservedColumn.setMinWidth (200);    
        ReservedColumn.setSortable(false);  
        ReservedColumn.setCellValueFactory(new PropertyValueFactory<>("quantityReserved")); 
        ////
        TableColumn<WardNormalRequisitionsApproved, String> CMSCODEColumn = new TableColumn<>("CMSCODE");
        CMSCODEColumn.setMinWidth (200);    
        CMSCODEColumn.setSortable(false); 
        CMSCODEColumn.setCellValueFactory(new PropertyValueFactory<>("cmscode"));                 

        TableColumn<WardNormalRequisitionsApproved, String> DrugColumn = new TableColumn<>("Drug Name");
        DrugColumn.setMinWidth (200);    
        DrugColumn.setSortable(false);  
        DrugColumn.setCellValueFactory(new PropertyValueFactory<>("drugName"));                 

        TableColumn<WardNormalRequisitionsApproved, String> ItemTypeColumn = new TableColumn<>("Item Type");
        ItemTypeColumn.setMinWidth (200);    
        ItemTypeColumn.setSortable(false);   
        ItemTypeColumn.setCellValueFactory(new PropertyValueFactory<>("itemtype"));                 

        TableColumn<WardNormalRequisitionsApproved, String> ScaleUnitColumn = new TableColumn<>("Scale Unit");
        ScaleUnitColumn.setMinWidth (200);    
        ScaleUnitColumn.setSortable(false);  
        ScaleUnitColumn.setCellValueFactory(new PropertyValueFactory<>("scaleunit"));                 

        ///

        TableColumn<WardNormalRequisitionsApproved, String> RequesterColumn = new TableColumn<>("Requester");        
        RequesterColumn.setMinWidth (200);    
        RequesterColumn.setSortable(false);   
        RequesterColumn.setCellValueFactory(new PropertyValueFactory<>("requester"));         

        TableColumn<WardNormalRequisitionsApproved, String> ApproverColumn = new TableColumn<>("Approver");        
        ApproverColumn.setMinWidth (200);    
        ApproverColumn.setSortable(false);   
        ApproverColumn.setCellValueFactory(new PropertyValueFactory<>("approver"));   

        Iterator<WardNormalRequisitionsApproved> reqit = list.iterator();
        while(reqit.hasNext())
        {
            WardNormalRequisitionsApproved requistion = new WardNormalRequisitionsApproved();
            requistion = reqit.next();

            itemsobs.add(new WardNormalRequisitionsApproved(
                    requistion.getQuantityRequested(),
                    requistion.getQuantityApproved(),
                    requistion.getQuantityReserved(),
                    requistion.getCmscode(),
                    requistion.getCmscode(),
                    requistion.getItemtype(),
                    requistion.getScaleunit(),
                    requistion.getRequester(),
                    requistion.getApprover(),                  
                    requistion.getRequisitionid()));                    
        }

        ApproveTV.getColumns().clear();
        ApproveTV.setItems(itemsobs);
        ApproveTV.getColumns().addAll(
                QRequestedColumn,QApprovedColumn,ReservedColumn,
                CMSCODEColumn,DrugColumn,ItemTypeColumn,ScaleUnitColumn,
                RequesterColumn,ApproverColumn);        
    }
    
}
