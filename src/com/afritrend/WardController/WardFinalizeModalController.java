/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardController;

import com.afritrend.WardDataAccess.RequisitionDataAccess;
import com.afritrend.common.Model.SessionManagement;
import com.afritrend.common.Model.WardNormalRequisitionFinalized;
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
public class WardFinalizeModalController implements Initializable {
    public String VoucherNumber;
    
    @FXML
    TableView FinalizeTV;
    
    @FXML
    TextField txtUpdateApproved;
    
    public final String SerialFile = "WardFinalizeRequisition.ser";
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    }    
    
    public void initData(String VCNumber)
    {
        VoucherNumber = VCNumber;        
    }    
    
    @FXML
    private void ShowVoucherRequisition(ActionEvent event)
    {
        List<WardNormalRequisitionFinalized> finalizelist = new ArrayList();
        RequisitionDataAccess reqdao = new RequisitionDataAccess();
        finalizelist = reqdao.GETIntiationAllWardReceivedRequisition(VoucherNumber); 
        
        //serialize the items
        try
        {
            File serialFile = new File(SerialFile);

            if(serialFile.exists())
            {
                Serialize(SerialFile, finalizelist);                    
            }
            else
            {
                serialFile.createNewFile();
                Serialize(SerialFile, finalizelist);     
            }     
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }         
        
        ShowRequisitions(finalizelist);        
    }
    
    @FXML
    private void UpdateRequisition(ActionEvent event)
    {
        try
        {
            WardNormalRequisitionFinalized finalize = (WardNormalRequisitionFinalized)FinalizeTV.getSelectionModel().getSelectedItem();
            WardNormalRequisitionFinalized itemtoremove = new WardNormalRequisitionFinalized();
            List<WardNormalRequisitionFinalized> finalizelist = new ArrayList();
            
            int FinalizeAmount = Integer.valueOf(txtUpdateApproved.getText());
            finalize.setQuantityFinalized(FinalizeAmount);
            finalize.setFinalizer(SessionManagement._email);
            
            //save the finalize
            RequisitionDataAccess reqdao = new RequisitionDataAccess();
            reqdao.SaveFinalizeRequisition(finalize); 
                                    
            try
            {
                finalizelist = Deserialized(SerialFile);

                int num = FinalizeTV.getSelectionModel().getSelectedIndex();
                itemtoremove = finalizelist.get(num);        

                finalizelist.remove(itemtoremove);
                finalizelist.add(num, finalize);

                Serialize(SerialFile, finalizelist);                
                ShowRequisitions(finalizelist);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }                   
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }          
    }
    
    @FXML
    private void GetSelectedItem(MouseEvent event)
    {
        WardNormalRequisitionFinalized finalize = (WardNormalRequisitionFinalized)FinalizeTV.getSelectionModel().getSelectedItem();
        txtUpdateApproved.setText(String.valueOf(finalize.getQuantityReceived()));
    }
    
    @FXML
    private void CloseVoucher(ActionEvent event)
    {
        RequisitionDataAccess reqdao = new RequisitionDataAccess();
        reqdao.UpdatevoucherStatus(VoucherNumber, "OrderFinalized");   
        
        Stage stage = (Stage)txtUpdateApproved.getScene().getWindow();
        stage.close();
    }
    
    public void ShowRequisitions(List<WardNormalRequisitionFinalized> finalizelist)
    {
        ObservableList<WardNormalRequisitionFinalized> itemsobs = FXCollections.observableArrayList();  

        TableColumn<WardNormalRequisitionFinalized, String> QtyReceivedColumn = new TableColumn<>("Quantity Received");
        QtyReceivedColumn.setMinWidth (200);    
        QtyReceivedColumn.setCellValueFactory(new PropertyValueFactory<>("quantityReceived"));  

        TableColumn<WardNormalRequisitionFinalized, String> QtyFinalizedColumn = new TableColumn<>("Quantity Finalized");
        QtyFinalizedColumn.setMinWidth (200);    
        QtyFinalizedColumn.setCellValueFactory(new PropertyValueFactory<>("quantityFinalized"));      

        TableColumn<WardNormalRequisitionFinalized, String> FinalizerColumn = new TableColumn<>("Finalizer");
        FinalizerColumn.setMinWidth (200);    
        FinalizerColumn.setCellValueFactory(new PropertyValueFactory<>("finalizer"));                  

        TableColumn<WardNormalRequisitionFinalized, String> ReqIDColumn = new TableColumn<>("Requisition ID");
        ReqIDColumn.setMinWidth (200);    
        ReqIDColumn.setCellValueFactory(new PropertyValueFactory<>("reqid"));                  

        Iterator<WardNormalRequisitionFinalized> vit = finalizelist.iterator();
        while(vit.hasNext())
        {
            WardNormalRequisitionFinalized finalized = new WardNormalRequisitionFinalized();
            finalized = vit.next();

            itemsobs.add(new WardNormalRequisitionFinalized(
                    finalized.getQuantityReceived(),
                    finalized.getQuantityFinalized(),
                    finalized.getFinalizer(),
                    finalized.getReqid()));                
        }

        FinalizeTV.getColumns().clear();
        FinalizeTV.setItems(itemsobs);
        FinalizeTV.getColumns().addAll(
                QtyReceivedColumn,QtyFinalizedColumn,FinalizerColumn,
                ReqIDColumn);         
    }
    
    public static List<WardNormalRequisitionFinalized> Deserialized(String Filename) throws Exception
    {
        List<WardNormalRequisitionFinalized> reqlist = new ArrayList();
        WardNormalRequisitionFinalized req = new WardNormalRequisitionFinalized();        
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(Filename));
        reqlist = (List<WardNormalRequisitionFinalized>)in.readObject();
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
