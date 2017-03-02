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
import com.afritrend.common.Model.WardNormalRequisitionsApproved;
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
import javafx.print.JobSettings;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class PharmacyReviewModalController implements Initializable {
    @FXML
    TableView ReviewModalTV;
    
    @FXML
    TextField txtUpdateApproved;
    
    public final String SerialFile = "PharmacyReviewRequisition.ser";
    
    public String voucherNumber;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
    
    public void initData(String VoucherNum)
    {        
        voucherNumber = VoucherNum;
        List<WardNormalRequisitionReview> reqlist = new ArrayList();
        RequisitionDataAccess reqdao = new RequisitionDataAccess();
        reqlist = reqdao.GETPharmacyReviewedRequisition(VoucherNum);
        
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
    public void PackItems(ActionEvent event)
    {
        // print the Pill Bag label
        //give a warning if the user did not select an item
        
        WardNormalRequisitionReview review = new WardNormalRequisitionReview();
        
        try
        {            
            review = (WardNormalRequisitionReview)ReviewModalTV.getSelectionModel().getSelectedItem(); 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        if(review == null)
        {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Unable to Pack Items");
            alert.setContentText("Please Select a row");

            alert.showAndWait();            
        }
        else
        {        
            HBox hbox = new HBox();        

            Label DrugName = new Label();
            DrugName.setText("Drug Name:"+" "+review.getDrugname());        

            Label Strength = new Label();
            Strength.setText("Strength:"+" "+review.getStrength());

            Label IssueUnit = new Label();
            IssueUnit.setText("Issue Unit:"+" "+review.getIssueUnit());

            Label DosageForm = new Label();
            DosageForm.setText("Dosage Form:"+" "+review.getDosageform());

            Label QtyPacked = new Label();
            QtyPacked.setText("Quantity Packed:"+" "+review.getQuantityPacked());

            VBox vbox1 = new VBox(5);

            vbox1.getChildren().addAll(DrugName,Strength,IssueUnit,DosageForm,QtyPacked);
            FlowPane pane = new FlowPane();
            pane.getChildren().add(vbox1);
    //        hbox.getChildren().addAll(vbox1, vbox2);

            // Get Printing Details
            RequisitionDataAccess reqdao = new RequisitionDataAccess();        

    //        TextArea box = new TextArea(String.valueOf(review.getQuantityPacked()));
            print(pane);        

            //update the serialization
            WardNormalRequisitionReview reviewreq = new WardNormalRequisitionReview();
            WardNormalRequisitionReview reviewitem = new WardNormalRequisitionReview();
            List<WardNormalRequisitionReview> reglist = new ArrayList();

            try
            {
                reglist = Deserialized(SerialFile);

                int num = ReviewModalTV.getSelectionModel().getSelectedIndex();
                reviewitem = reglist.get(num);        

                reglist.remove(reviewitem);
                reglist.add(num, review);

                Serialize(SerialFile, reglist);                
                ShowReviewRequisition(reglist);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    
    @FXML
    public void UpdateVoucher(ActionEvent event)
    {
        RequisitionDataAccess reqdao = new RequisitionDataAccess();
        reqdao.UpdatevoucherStatus(voucherNumber, "PharmacyReviewed");        
        
        Stage stage = (Stage)ReviewModalTV.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void UpdateRow(ActionEvent event)
    {
        WardNormalRequisitionReview review = new WardNormalRequisitionReview();
        
        try
        {
            review = (WardNormalRequisitionReview)ReviewModalTV.getSelectionModel().getSelectedItem();
            review.setQuantityPacked(Integer.valueOf(txtUpdateApproved.getText()));
            review.setPharmacistPacking(SessionManagement._email);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        if(review == null)
        {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Unable to Update Item");
            alert.setContentText("Please Select a row");

            alert.showAndWait();            
        }
        else
        {
            RequisitionDataAccess reqdao = new RequisitionDataAccess();        
            reqdao.UPDATEPharmacyNormalRequisitionsReviewed(review);

            List<WardNormalRequisitionReview> reqlist = new ArrayList();
//            reqlist = 
            reqdao.GETUpdatedPharmacyReviewedRequisition(voucherNumber);  

            try
            {
                reqlist = Deserialized(SerialFile);
                WardNormalRequisitionReview reviewremove = new WardNormalRequisitionReview();
                int num = ReviewModalTV.getSelectionModel().getSelectedIndex();
                reviewremove = reqlist.get(num);        

                reqlist.remove(reviewremove);
                reqlist.add(num, review);

                Serialize(SerialFile, reqlist);                
                ShowReviewRequisition(reqlist);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }                                     
        }
        
             
    }
    
    public void print(final Node node) {
        
        Printer printer = Printer.getDefaultPrinter();
        PageLayout pageLayout = printer.createPageLayout(Paper.A5, PageOrientation.LANDSCAPE, Printer.MarginType.DEFAULT);        
 
        PrinterJob job = PrinterJob.createPrinterJob();
        JobSettings jobsettings = job.getJobSettings();
        jobsettings.setPageLayout(pageLayout);
//        double pgw = pageLayout.getPrintableWidth();
//        double pgh = pageLayout.getPrintableHeight();
        
//        if (job != null && job.showPrintDialog(null)) {
        if (job != null) {
            boolean success = job.printPage(node);
            if (success) {
                job.endJob();
            }
        }
            
    }     
    
    @FXML
    public void GetSelectedrow()
    {
        WardNormalRequisitionReview review = new WardNormalRequisitionReview();
        review = (WardNormalRequisitionReview)ReviewModalTV.getSelectionModel().getSelectedItem();
        
        txtUpdateApproved.setText(String.valueOf(review.getQuantityRequestedByward()));               
    }
    
        
    
    public static List<WardNormalRequisitionReview> Deserialized(String Filename) throws Exception
    {
        List<WardNormalRequisitionReview> reqlist = new ArrayList();
        WardNormalRequisitionReview req = new WardNormalRequisitionReview();        
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(Filename));
        reqlist = (List<WardNormalRequisitionReview>)in.readObject();
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
    
    public void ShowReviewRequisition(List<WardNormalRequisitionReview> reqlist)
    {
            ObservableList<WardNormalRequisitionReview> itemsobs = FXCollections.observableArrayList();  

            TableColumn<WardNormalRequisitionReview, String> QuantityRequestedColumn = new TableColumn<>("Quantiy Requested");
            QuantityRequestedColumn.setMinWidth (200);    
            QuantityRequestedColumn.setSortable(false);   
            QuantityRequestedColumn.setCellValueFactory(new PropertyValueFactory<>("quantityRequestedByward"));  

            TableColumn<WardNormalRequisitionReview, String> AmountPackedColumn = new TableColumn<>("Quantity Packed");
            AmountPackedColumn.setMinWidth (200);    
            AmountPackedColumn.setSortable(false);   
            AmountPackedColumn.setCellValueFactory(new PropertyValueFactory<>("quantityPacked"));      

            TableColumn<WardNormalRequisitionReview, String> DrugNameColumn = new TableColumn<>("Drug Name");
            DrugNameColumn.setMinWidth (200);    
            DrugNameColumn.setSortable(false);  
            DrugNameColumn.setCellValueFactory(new PropertyValueFactory<>("drugname")); 

            TableColumn<WardNormalRequisitionReview, String> StrengthColumn = new TableColumn<>("Strength");
            StrengthColumn.setMinWidth (200);    
            StrengthColumn.setSortable(false);  
            StrengthColumn.setCellValueFactory(new PropertyValueFactory<>("strength"));                                 

            TableColumn<WardNormalRequisitionReview, String> DosageColumn = new TableColumn<>("Dosage Form");
            DosageColumn.setMinWidth (200);    
            DosageColumn.setSortable(false);  
            DosageColumn.setCellValueFactory(new PropertyValueFactory<>("dosageform"));                                 

            TableColumn<WardNormalRequisitionReview, String> IssueUnitColumn = new TableColumn<>("ISSUE UNIT");
            IssueUnitColumn.setMinWidth (200);    
            IssueUnitColumn.setSortable(false);  
            IssueUnitColumn.setCellValueFactory(new PropertyValueFactory<>("issueUnit"));                                 

            Iterator<WardNormalRequisitionReview> reqit = reqlist.iterator();
            while(reqit.hasNext())
            {
                WardNormalRequisitionReview requistion = new WardNormalRequisitionReview();
                requistion = reqit.next();

                itemsobs.add(new WardNormalRequisitionReview(
                        requistion.getQuantityRequestedByward(),
                        requistion.getQuantityPacked(),
                        requistion.getDrugname(),
                        requistion.getStrength(),   
                        requistion.getDosageform(),
                        requistion.getIssueUnit(),
                        requistion.getReqid()
                ));                    
            }
            ReviewModalTV.getColumns().clear();
            ReviewModalTV.setItems(itemsobs);
            ReviewModalTV.getColumns().addAll(
                    QuantityRequestedColumn,AmountPackedColumn,DrugNameColumn,
                    StrengthColumn,DosageColumn,IssueUnitColumn);        
    }    
}
