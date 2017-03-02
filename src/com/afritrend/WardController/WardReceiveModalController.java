/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardController;

import com.afritrend.WardDataAccess.RequisitionDataAccess;
import com.afritrend.common.Model.SessionManagement;
import com.afritrend.common.Model.WardNormalRequisitionReceived;
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
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class WardReceiveModalController implements Initializable {

    @FXML
    TableView ApproveTV;
    
    public String VCNumber;
    
    @FXML
    TextField qtyCollected;
    
    @FXML
    TextField QtyReceived;
            
    @FXML        
    TextField QtyLost;
    
    @FXML
    TextField QtyDamaged;
    
    @FXML
    TextField QtyExpired;
        
    public final String SerialFile = "WardReceiveRequisition.ser";    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            qtyCollected.setTooltip(new Tooltip("Quantity Collected"));
            QtyReceived.setTooltip(new Tooltip("Quantity Received"));
            QtyLost.setTooltip(new Tooltip("Quantity Lost"));
            QtyDamaged.setTooltip(new Tooltip("Quantity Damaged"));
            QtyExpired.setTooltip(new Tooltip("Quantity Expired"));
    }    
    
    public void initData(String VoucherNumber)
    {
        VCNumber = VoucherNumber;
        System.out.println(VCNumber);
    }
    
    @FXML
    private void UpdateRequisition(ActionEvent event)
    {
        int Received = Integer.valueOf(QtyReceived.getText());
        int Lost = Integer.valueOf(QtyLost.getText());
        int Damaged = Integer.valueOf(QtyDamaged.getText());
        int Expired = Integer.valueOf(QtyExpired.getText());
        
        WardNormalRequisitionReceived received = new WardNormalRequisitionReceived();
        
        try
        {
            received = (WardNormalRequisitionReceived)ApproveTV.getSelectionModel().getSelectedItem();
            
            if(received == null)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Unable to Update Item");
                alert.setContentText("Please Select a row");

                alert.showAndWait();                 
            }
            else
            {        
                received.setQuantityReceived(Received);
                received.setQuantityLost(Lost);
                received.setQuantityDamaged(Damaged);
                received.setQuantityExpired(Expired);
                received.setReceiver(SessionManagement._email);

                //update record
                RequisitionDataAccess reqdao = new RequisitionDataAccess();
                reqdao.UpdateWardNormalRequisitionsReceived(received);   
                
                WardNormalRequisitionReceived removeitem = new WardNormalRequisitionReceived();
                List<WardNormalRequisitionReceived> reqlist = new ArrayList();
                
                try
                {
                    reqlist = Deserialized(SerialFile);

                    int num = ApproveTV.getSelectionModel().getSelectedIndex();
                    removeitem = reqlist.get(num);        

                    reqlist.remove(removeitem);
                    reqlist.add(num, received);

                    Serialize(SerialFile, reqlist);                
                    ShowRequisitionItems(reqlist);
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
    private void ShowRequisitions(ActionEvent event)
    {
        List<WardNormalRequisitionReceived> receivedlist = new ArrayList();
        RequisitionDataAccess reqdao = new RequisitionDataAccess();
        receivedlist = reqdao.GETIntiationAllPharmacyApprovedRequisition(VCNumber);
        
        //serialize the items
        try
        {
            File serialFile = new File(SerialFile);

            if(serialFile.exists())
            {
                Serialize(SerialFile, receivedlist);                    
            }
            else
            {
                serialFile.createNewFile();
                Serialize(SerialFile, receivedlist);     
            }     
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }        
        
        ShowRequisitionItems(receivedlist);        
    }
    
    @FXML
    private void UpdateVoucher(ActionEvent event)
    {
        //update the voucher
        RequisitionDataAccess reqdao = new RequisitionDataAccess();
        reqdao.UpdatevoucherStatus(VCNumber, "OrderReceived");  
        
        Stage stage = (Stage)ApproveTV.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void GetSelectedItem(MouseEvent event)
    {
        WardNormalRequisitionReceived received = (WardNormalRequisitionReceived)ApproveTV.getSelectionModel().getSelectedItem();
        qtyCollected.setText(String.valueOf(received.getQuantityCollected()));
        QtyReceived.setText(String.valueOf(0));
        QtyLost.setText(String.valueOf(0));
        QtyDamaged.setText(String.valueOf(0));
        QtyExpired.setText(String.valueOf(0));
    }
    
    public void ShowRequisitionItems(List<WardNormalRequisitionReceived> receivedlist)
    {
            ObservableList<WardNormalRequisitionReceived> itemsobs = FXCollections.observableArrayList();  

            TableColumn<WardNormalRequisitionReceived, String> QuantityCollectedColumn = new TableColumn<>("Quantity Collected");
            QuantityCollectedColumn.setMinWidth (200);    
            QuantityCollectedColumn.setSortable(false);   
            QuantityCollectedColumn.setCellValueFactory(new PropertyValueFactory<>("quantityCollected"));  

            TableColumn<WardNormalRequisitionReceived, String> QuantityReceivedColumn = new TableColumn<>("Quantity Received");
            QuantityReceivedColumn.setMinWidth (200);    
            QuantityReceivedColumn.setSortable(false);   
            QuantityReceivedColumn.setCellValueFactory(new PropertyValueFactory<>("quantityReceived"));      

            TableColumn<WardNormalRequisitionReceived, String> QuantityLostColumn = new TableColumn<>("Quantity Lost");
            QuantityLostColumn.setMinWidth (200);    
            QuantityLostColumn.setSortable(false);  
            QuantityLostColumn.setCellValueFactory(new PropertyValueFactory<>("quantityLost")); 

            TableColumn<WardNormalRequisitionReceived, String> QuantityExpiredColumn = new TableColumn<>("Quantity Expired");
            QuantityExpiredColumn.setMinWidth (200);    
            QuantityExpiredColumn.setSortable(false);  
            QuantityExpiredColumn.setCellValueFactory(new PropertyValueFactory<>("quantityExpired"));                                 

            TableColumn<WardNormalRequisitionReceived, String> QuantityDamagedColumn = new TableColumn<>("Quantity Damaged");
            QuantityDamagedColumn.setMinWidth (200);    
            QuantityDamagedColumn.setSortable(false);  
            QuantityDamagedColumn.setCellValueFactory(new PropertyValueFactory<>("quantityDamaged"));                                 

            TableColumn<WardNormalRequisitionReceived, String> ReceiverColumn = new TableColumn<>("Receiver");
            ReceiverColumn.setMinWidth (200);    
            ReceiverColumn.setSortable(false);  
            ReceiverColumn.setCellValueFactory(new PropertyValueFactory<>("receiver"));                                 

            TableColumn<WardNormalRequisitionReceived, String> RequisitionColumn = new TableColumn<>("Requistion id");
            RequisitionColumn.setMinWidth (200);    
            RequisitionColumn.setSortable(false);  
            RequisitionColumn.setCellValueFactory(new PropertyValueFactory<>("reqid"));                                 

            Iterator<WardNormalRequisitionReceived> reqit = receivedlist.iterator();
            while(reqit.hasNext())
            {
                WardNormalRequisitionReceived requistion = new WardNormalRequisitionReceived();
                requistion = reqit.next();

                itemsobs.add(new WardNormalRequisitionReceived(
                        requistion.getQuantityCollected(),
                        requistion.getQuantityReceived(),
                        requistion.getQuantityLost(),
                        requistion.getQuantityExpired(),
                        requistion.getQuantityDamaged(),
                        requistion.getReceiver(),                 
                        requistion.getReqid()));                    
            }
            ApproveTV.getColumns().clear();
            ApproveTV.setItems(itemsobs);
            ApproveTV.getColumns().addAll(
            QuantityCollectedColumn,QuantityReceivedColumn,QuantityLostColumn,
            QuantityExpiredColumn,QuantityDamagedColumn,ReceiverColumn,RequisitionColumn);           
    }
    
    
        
    public static List<WardNormalRequisitionReceived> Deserialized(String Filename) throws Exception
    {
        List<WardNormalRequisitionReceived> reqlist = new ArrayList();
        WardNormalRequisitionReceived req = new WardNormalRequisitionReceived();        
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(Filename));
        reqlist = (List<WardNormalRequisitionReceived>)in.readObject();
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
