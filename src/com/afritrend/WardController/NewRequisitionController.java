/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardController;

import com.afritrend.WardDataAccess.RequisitionDataAccess;
import com.afritrend.common.AutoDrugSearchDataAccess;
import com.afritrend.common.Model.SessionManagement;
import com.afritrend.common.Model.requisitionModel;
import com.afritrend.common.Model.voucherModel;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class NewRequisitionController implements Initializable {
    
    @FXML
    Label lblGeneralError;
    
    @FXML
    Label cmscodeError;
    
    @FXML
    Label DrugError;
    
    @FXML
    Label DosageError;
    
    @FXML
    Label DrugNameError;
    
    @FXML
    Label StrengthError;
    
    @FXML
    Label IssueUnitError;
    
    @FXML
    Label ExpiryDateError;
    
    @FXML
    Label QuantityError;
    
    @FXML
    ComboBox cbdrugClass;
    
    @FXML
    ComboBox cbDosageForm;
    
    @FXML
    ComboBox cbDrugName;    
    
    @FXML
    ComboBox cbStrength;
    
    @FXML
    ComboBox cbIssueUnit;
    
    @FXML
    TextField txtQuantity;
    
    @FXML
    TextArea txtComment;
    
    @FXML
    ComboBox cbCode;    
    
    @FXML
    TableView TVDrugEntry;
    
    public String cmscodeFOUND;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> dosagelist = new ArrayList();
        List<String> classlist = new ArrayList();
        List<String> Transactionlist = new ArrayList();
        
        AutoDrugSearchDataAccess drugautodao = new AutoDrugSearchDataAccess();
        
        
        classlist = drugautodao.GetDrugClass();
        Iterator<String> classit = classlist.iterator();
        
        while(classit.hasNext())
        {
            String classname = classit.next();
            cbdrugClass.getItems().add(classname);
        }        
        
        dosagelist = drugautodao.GetDosageForms();
        
        Transactionlist = drugautodao.GetTransactionTypes();
        
        Iterator<String> itDose = dosagelist.iterator();
        while(itDose.hasNext())
        {
            String Dosage = itDose.next();
            cbDosageForm.getItems().add(Dosage);
        }
        
    }    
    
   public void AddToOrder(ActionEvent event)
   {
            String Name = "Ward";
            String File = Name.concat("PrepareRequisition");
            String NewFileName = File.concat(".ser");
            
           String Drugclass = String.valueOf(cbdrugClass.getValue());
           String DosageForm = String.valueOf(cbDosageForm.getValue());
           String DrugName = String.valueOf(cbDrugName.getValue());
           String Strength = String.valueOf(cbStrength.getValue());
           //String ItemCode = String.valueOf(cbCode.getValue());
           String IssueUnit = String.valueOf(cbIssueUnit.getValue());
           int Quantity = Integer.valueOf(txtQuantity.getText());
           String Comment = String.valueOf(txtComment.getText());  
           
           requisitionModel req = new requisitionModel();
           List<requisitionModel> requilist = new ArrayList();                   
      
            try
            {
                    List<requisitionModel> Newrequisitionlist = null; 
                    File file = new File(NewFileName);
                    
                    if(file.exists())
                    {               
                        //if it Exists we shall Get the File as a List, Add required needed data then Save it For later
                        List<requisitionModel> requisitionlist = new ArrayList<requisitionModel>();
                        Newrequisitionlist = new ArrayList<requisitionModel>();
                        requisitionModel requisition = new requisitionModel();                 

                        requisitionlist = Deserialized(NewFileName);
                        
                        Iterator<requisitionModel> lsit = requisitionlist.iterator();
                        while(lsit.hasNext())
                        {
                            requisition = lsit.next();
                            Newrequisitionlist.add(requisition);           
                        }        
                        
                            requisitionModel requisition2 = new requisitionModel(); 

                           requisition2.setScaleUnit(IssueUnit);
                           requisition2.setAmount(Quantity);
                           requisition2.setItemType("Drug");
                           requisition2.setCmscode(cmscodeFOUND);                        

                            Newrequisitionlist.add(requisition2);

                            Serialize(NewFileName,Newrequisitionlist); 

                            Notifications notification = Notifications.create()
                                    .title("Drug Added")
                                    .text("Order Saved")
                                    .graphic(null)
                                    .hideAfter(Duration.seconds(5))
                                    .position(Pos.BOTTOM_RIGHT)
                                    .onAction(new EventHandler<ActionEvent>(){
                                        @Override
                                        public void handle(ActionEvent event)
                                        {
//                                            System.out.println("Clicked on Notification");
                                        }
                                    });

                            notification.showConfirm();  
                            
                            //Now Show in Table View
                        PopulateDrugTable(Newrequisitionlist);
                    }
                    else
                    {               
                        List<requisitionModel> serializelist1 = new ArrayList<>();
                        requisitionModel req2 = new requisitionModel();                       
                        
                        req2.setScaleUnit(IssueUnit);
                        req2.setAmount(Quantity);
                        req2.setItemType("Drug");
                        req2.setCmscode(cmscodeFOUND);                          
                        
                        serializelist1.add(req2);                
                        String MSG = Serialize(NewFileName, serializelist1); 
                        
                        Notifications notification = Notifications.create()
                                .title("Drug Added")
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
                        PopulateDrugTable(serializelist1);                          
                    }
            }
            catch(Exception e)
            {
                        Notifications notification = Notifications.create()
                                .title("Drug Added")
                                .text(e.getMessage())
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
                    
    public void UpdateOrder(ActionEvent event)
    {
        String Name = "Ward";
        String File = Name.concat("PrepareRequisition");
        String NewFileName = File.concat(".ser");        
        
        requisitionModel requisition = new requisitionModel();
        List<requisitionModel> requilist = new ArrayList(); 
        requisition = (requisitionModel)TVDrugEntry.getSelectionModel().getSelectedItem();
        // set in the controls available
           cbdrugClass.setValue("Testing");           
           cbDosageForm.setValue("Testing");
           cbDrugName.setValue("Testing");
           cbStrength.setValue("Testing");
           cbIssueUnit.setValue(requisition.getScaleUnit());
           txtQuantity.setText(String.valueOf(requisition.getAmount()));     
           txtComment.setText(requisition.getCmscode()); 
           lblGeneralError.setText(requisition.getCmscode());
        
        PopulateDrugTable(requilist);        
    }

    public void DeleteOrder(ActionEvent event)
    {
        try
        {
            String Name = "Ward";
            String File = Name.concat("PrepareRequisition");
            String NewFileName = File.concat(".ser");        

            requisitionModel requisition = new requisitionModel();
            List<requisitionModel> requilist = new ArrayList();
            
            requilist = Deserialized(NewFileName);

//            requisition = (requisitionModel)TVDrugEntry.getSelectionModel().getSelectedItem();
            int item = TVDrugEntry.getSelectionModel().getSelectedIndex();

            requilist.remove(item);
            Serialize(NewFileName,requilist); 
            
            PopulateDrugTable(requilist);
        }
        catch(Exception e)
        {
            
        }
    }
                    
   public void SaveRequisition(ActionEvent event)
   {
        String Drugclass = String.valueOf(cbdrugClass.getValue());
        String DosageForm = String.valueOf(cbDosageForm.getValue());
        String DrugName = String.valueOf(cbDrugName.getValue());
        String Strength = String.valueOf(cbStrength.getValue());
        //String ItemCode = String.valueOf(cbCode.getValue());
        String IssueUnit = String.valueOf(cbIssueUnit.getValue());
        int Quantity = Integer.valueOf(txtQuantity.getText());
        String Comment = String.valueOf(txtComment.getText());
       
        String MSG = "";
        RequisitionDataAccess requidao = new RequisitionDataAccess();
        requisitionModel req = new requisitionModel();
        List<requisitionModel> requilist = new ArrayList();
        voucherModel voucher = new voucherModel();
       
        voucher.setRequisitionService("QuantityBeingRequested");
        voucher.setWardName(SessionManagement._wardName);
        voucher.setComments(Comment);
        voucher.setRequisitionTransactionType("QuantityBeingRequested");
        voucher.setVoucherstatus("");            
       
        String Name = "Ward";
        String File = Name.concat("PrepareRequisition");
        String NewFileName = File.concat(".ser");

        //Now Create Requisition and Attache Voucher Number
        File serialFile = new File(NewFileName);
        if(serialFile.exists())
        {
            //check the stock balance on particular medication thus itemtype
            //Here if the File is being Submitted Lets Deserialize the File and Send to Database, 
            List<requisitionModel> deserializedreqlist = new ArrayList();
            deserializedreqlist = requilist;

            try
            {
                deserializedreqlist = Deserialized(NewFileName);   

                if(deserializedreqlist.isEmpty())
                {
                    Label label = new Label();
                    label.setText("Please Add Your Order");
                    TVDrugEntry.setPlaceholder(label);
                    PopulateDrugTable(deserializedreqlist);
                }
                else
                {                                                               
                    Iterator<requisitionModel> lsit = deserializedreqlist.iterator();
                    while(lsit.hasNext())
                    {
                        requisitionModel req2 = new requisitionModel();
                        req2 = lsit.next();

                        req2.setScaleUnit(IssueUnit);
                        req2.setAmount(Quantity);
                        req2.setItemType("Drug");
                        req2.setCmscode(cmscodeFOUND);

                        requilist.add(req2); 
                    }              
                    
                    requidao.SaveRequisition(requilist, voucher); 

                    Notifications notification = Notifications.create()
                            .title("Drug Saved")
                            .text("Requisition Order")
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
                    
                    PopulateDrugTable(deserializedreqlist);
                    deserializedreqlist.clear();                            
                    Serialize(NewFileName,deserializedreqlist);
                }
            }
            catch(Exception e)
            {

            }
            finally
            {
                //We are going to Delete that Serial File Now
            }  
        }                    
   }       
   
    public void GetDrugNames(ActionEvent event)
    {
        //GetHPDrugNamesByDosageForm
        List<String> Druglist = new ArrayList();
        String dosageForm = String.valueOf(cbDosageForm.getValue());
        AutoDrugSearchDataAccess drugautodao = new AutoDrugSearchDataAccess();
        Druglist = drugautodao.GetHPDrugNamesByDosageForm(dosageForm);
        
        cbDrugName.getItems().clear();
        Iterator<String> drugit = Druglist.iterator();
        while(drugit.hasNext())
        {
            String drugname = drugit.next();
            cbDrugName.getItems().add(drugname);
        }
    }
    
    public void FindcmsCode(ActionEvent event)
    {
       String Drugclass = String.valueOf(cbdrugClass.getValue());
       String DosageForm = String.valueOf(cbDosageForm.getValue());
       String DrugName = String.valueOf(cbDrugName.getValue());
       String Strength = String.valueOf(cbStrength.getValue());
       //String ItemCode = String.valueOf(cbCode.getValue());
       String IssueUnit = String.valueOf(cbIssueUnit.getValue());      
       
        AutoDrugSearchDataAccess drugautodao = new AutoDrugSearchDataAccess();
        cmscodeFOUND = drugautodao.FindcmsCodebyDrugDetails(Drugclass,DosageForm,DrugName,Strength,IssueUnit);  
        lblGeneralError.setText(cmscodeFOUND);
    }
    
    public void GetStrength(ActionEvent event)
    {
        //GetHPDrugNamesByDosageForm
        List<String> Strengthlist = new ArrayList();
        String DrugName = String.valueOf(cbDrugName.getValue());
        AutoDrugSearchDataAccess drugautodao = new AutoDrugSearchDataAccess();
        Strengthlist = drugautodao.GetHPStrengthByDrugName(DrugName);
        
        cbStrength.getItems().clear();
        Iterator<String> strengthit = Strengthlist.iterator();
        while(strengthit.hasNext())
        {
            String strength = strengthit.next();
            cbStrength.getItems().add(strength);
        }
    }
    
    public void GetIssueUnit(ActionEvent event)
    {
        List<String> IssueUnitlist = new ArrayList();
        String DrugName = String.valueOf(cbDrugName.getValue());
        AutoDrugSearchDataAccess drugautodao = new AutoDrugSearchDataAccess();
        IssueUnitlist = drugautodao.GetIssueUnit(DrugName, String.valueOf(cbStrength.getValue()), String.valueOf(cbDosageForm.getValue()));
        
        cbIssueUnit.getItems().clear();
        Iterator<String> Issueit = IssueUnitlist.iterator();
        while(Issueit.hasNext())
        {
            String IssueUnit = Issueit.next();
            cbIssueUnit.getItems().add(IssueUnit);
        }
    }
    
    public static List<requisitionModel> Deserialized(String Filename) throws Exception
    {
        List<requisitionModel> reqlist = new ArrayList();
        requisitionModel req = new requisitionModel();        
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(Filename));
        reqlist = (List<requisitionModel>)in.readObject();
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
    
    public void PopulateDrugTable(List<requisitionModel> reqlist)
    {
            ObservableList<requisitionModel> itemsobs = FXCollections.observableArrayList();  

            TableColumn<requisitionModel, String> ScaleUnitColumn = new TableColumn<>("Scale Unit");
            ScaleUnitColumn.setMinWidth (200);    
            ScaleUnitColumn.setSortable(false);   
            ScaleUnitColumn.setCellValueFactory(new PropertyValueFactory<>("scaleUnit"));  

            TableColumn<requisitionModel, String> AmountColumn = new TableColumn<>("Amount");
            AmountColumn.setMinWidth (200);    
            AmountColumn.setSortable(false);   
            AmountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));      

            TableColumn<requisitionModel, String> ItemTypeColumn = new TableColumn<>("Item Type");
            ItemTypeColumn.setMinWidth (200);    
            ItemTypeColumn.setSortable(false);  
            ItemTypeColumn.setCellValueFactory(new PropertyValueFactory<>("itemType")); 

            TableColumn<requisitionModel, String> CMSCODEColumn = new TableColumn<>("CMS CODE");
            CMSCODEColumn.setMinWidth (200);    
            CMSCODEColumn.setSortable(false);  
            CMSCODEColumn.setCellValueFactory(new PropertyValueFactory<>("cmscode"));                                 

            Iterator<requisitionModel> reqit = reqlist.iterator();
            while(reqit.hasNext())
            {
                requisitionModel requistion = new requisitionModel();
                requistion = reqit.next();

                itemsobs.add(new requisitionModel(
                        requistion.getScaleUnit(),
                        requistion.getAmount(),
                        requistion.getItemType(),
                        requistion.getCmscode(),                   
                        requistion.getRequisitionid()));                    
            }
            TVDrugEntry.getColumns().clear();
            TVDrugEntry.setItems(itemsobs);
            TVDrugEntry.getColumns().addAll(
                    ScaleUnitColumn,AmountColumn,ItemTypeColumn,
                    CMSCODEColumn);       
    }
    
}
