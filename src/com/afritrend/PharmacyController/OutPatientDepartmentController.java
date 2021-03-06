/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.PharmacyDataAccess.OPDPrescriptionDataAccess;
import com.afritrend.PharmacyModel.OPDPrescriptionModel;
import com.sun.javafx.print.PrintHelper;
import com.sun.javafx.print.Units;
import static com.sun.javafx.print.Units.MM;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import javafx.fxml.LoadException;
import javafx.print.JobSettings;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterAttributes;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Scale;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class OutPatientDepartmentController implements Initializable {
    
    private static final String UPLOAD_FOLDER = "C:\\temp\\";

    @FXML
    TableView TVShowPatient;
    
    @FXML
    TextField txtPatientNumber;
    
    @FXML
    DatePicker dpFromDate;
    
    @FXML
    DatePicker dpToDate;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void ShowPatients(ActionEvent event)
    {
        try
        {
            String PatientNumber = txtPatientNumber.getText();
            String FromDate = String.valueOf(dpFromDate.getValue());
            String ToDate = String.valueOf(dpToDate.getValue());
            
            if(PatientNumber.equals("") || PatientNumber == null)
            {
                OPDPrescriptionDataAccess opdao = new OPDPrescriptionDataAccess();
                List<OPDPrescriptionModel> list = new ArrayList();
                list = opdao.GetPatientPrescription(PatientNumber,"");
                Showpatients(list);    
            }
            else
            {
                OPDPrescriptionDataAccess opdao = new OPDPrescriptionDataAccess();
                List<OPDPrescriptionModel> list = new ArrayList();
                list = opdao.GetPatientPrescription(PatientNumber,"");
                Showpatients(list);                       
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }        
    }
    
    @FXML
    private void ShowOPDPrescriptions(MouseEvent event)
    {
        System.out.println("Show Presriptions");
    }
    
    @FXML
    private void PrintBagLabel(ActionEvent event)
    {
        try
        {
            OPDPrescriptionModel OPD = (OPDPrescriptionModel)TVShowPatient.getSelectionModel().getSelectedItem();            
            //load the fxml for gridpane and retrieve this note for printing
        try
        {            
//            FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Pharmacy/PillBagLabel.fxml"));
            FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Pharmacy/TestBag.fxml"));
//            FXMLLoader fxloader = new FXMLLoader(getClass().getResource("/com/afritrend/Pharmacy/ItemEntry.fxml"));
            Parent root = fxloader.load();  

            TestBagController controller = (TestBagController)fxloader.getController();
            controller.initData(OPD);             
//            Label label = new Label();
//            Node node = new Circle(2,2,2);
//            label.setText("Health Point");
////            print(label);
            printNode(root);
        }
        catch(LoadException ex)
        {
            System.out.println("Unable to Load FXML");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Unable to Print");
        }                
            
            GridPane gridpane = new GridPane();

            Label PatientName = new Label("PATIENT'S NAME/DZINA LA ODWALA");
            Label Date = new Label("DATE/TSIKU");
            Label instruction = new Label("INSTRUCTION");
            Label malangizo = new Label("MALANGIZO");
            Label px = new Label("Px");
            Label expdate = new Label("EXP DATE/TSIKU LAKUTHA MPHAMVU");
            Label qty = new Label("QTY/KUCHULUKA KWA MANKHWALA");
            Label tab = new Label("TAB/CAP - MAPILITSI/KAPUSULU");
            Label time = new Label("TIMES A DAY / KAMWEDWE KA MANKHWALA PA TSIKU");
            Label drug = new Label("DRUG / DZINA LA MAKHWALA");
            Label tablet = new Label("TABLET BAG | THUMBA LA MANKHWALA");
            Label openning = new Label("TWIST TO OPEN/PRESS TO CLOSE | KANULANI POTSEKULA/KANIKIZANI POTSEKA");
            Label warning = new Label("\"KEEP OUT OF REACH OF CHILDREN\" | \"SUNGANI MANKHWALA POSAFIKIRA ANAS\"");

            PatientName.setStyle("-fx-font-size:6pt;-fx-text-fill: #006464;");
            Date.setStyle("-fx-font-size:6pt;");
            instruction.setStyle("-fx-font-size:6pt;");
            px.setStyle("-fx-font-size:6pt;");
            expdate.setStyle("-fx-font-size:6pt; bold italic 20pt \"Arial\"");
            qty.setStyle("-fx-font-size:6pt;");
            tab.setStyle("-fx-font-size:6pt;");
            malangizo.setStyle("-fx-font-size:6pt;");
            time.setStyle("-fx-font-size:6pt;");
            drug.setStyle("-fx-font-size:6pt;");
            tablet.setStyle("-fx-font-size:6pt;");
            openning.setStyle("-fx-font-size:6pt;");
            warning.setStyle("-fx-font-size:6pt;");
//            BufferedOutputStream bs = null;
//
            File file = new File("C:\\EDMSFOLDER\\new.png");
//            try 
//            {                
//                FileOutputStream fs = new FileOutputStream(file);
//                bs = new BufferedOutputStream(fs);
//                bs.write(OPD.getPrescrionbarcode());
//                bs.close();
//                bs = null;
//            } 
//                catch (Exception e) 
//            {
//                e.printStackTrace();
//            }
//
//            if (bs != null) try { bs.close(); } catch (Exception e) {}
           

            
            Image img = new Image(file.toURI().toURL().toExternalForm());                        
            ImageView imgView = new ImageView();
            ImageView imgView2 = new ImageView();
            imgView.setImage(img);  

            //Answers
            String patientNumber = OPD.getPatientNo();
            Label patientno = new Label(patientNumber);            
            //formating the text
            
            gridpane.add(PatientName, 0, 0,2,1);
            gridpane.add(Date, 0, 1,2,1);
            gridpane.add(instruction, 0, 2,1,1);
            gridpane.add(malangizo, 0, 3,1,1);
            gridpane.add(px, 0, 4,1,1);
            gridpane.add(expdate, 1, 4,1,1);
            gridpane.add(qty, 2, 4,1,1);
            gridpane.add(tab, 0, 5,1,1);
            gridpane.add(time, 0, 6,1,1);
            gridpane.add(drug, 0, 7,1,1);
            gridpane.add(tablet, 0, 8,1,1);
            gridpane.add(openning, 0, 9,1,1);
            gridpane.add(warning, 0, 10,1,1);
            gridpane.add(imgView, 0, 11,1,1);
            gridpane.add(patientno, 1, 2,2,1);
//            print(gridpane);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
        
    @FXML
    private void ScanBarcode(ActionEvent event)
    {
        System.out.println("Barcode Scanning");
    }
    
    public void Showpatients(List<OPDPrescriptionModel> list)
    {
        ObservableList<OPDPrescriptionModel> itemsobs = FXCollections.observableArrayList();  

        TableColumn<OPDPrescriptionModel, String> PatientNoPackedColumn = new TableColumn<>("Patient Number");
        PatientNoPackedColumn.setMinWidth (200);    
        PatientNoPackedColumn.setSortable(false);   
        PatientNoPackedColumn.setCellValueFactory(new PropertyValueFactory<>("patientNo"));  

        TableColumn<OPDPrescriptionModel, String> CMSCODEColumn = new TableColumn<>("CMSCODE");
        CMSCODEColumn.setMinWidth (200);    
        CMSCODEColumn.setSortable(false);   
        CMSCODEColumn.setCellValueFactory(new PropertyValueFactory<>("cmsCode"));      

        TableColumn<OPDPrescriptionModel, String> AdmissionColumn = new TableColumn<>("Admission Code");
        AdmissionColumn.setMinWidth (200);    
        AdmissionColumn.setSortable(false);  
        AdmissionColumn.setCellValueFactory(new PropertyValueFactory<>("admissionCode")); 

        TableColumn<OPDPrescriptionModel, String> FrequencyColumn = new TableColumn<>("Frequency");
        FrequencyColumn.setMinWidth (200);    
        FrequencyColumn.setSortable(false);  
        FrequencyColumn.setCellValueFactory(new PropertyValueFactory<>("frequency"));                                 

//        TableColumn<OPDPrescriptionModel, String> RequisitionColumn = new TableColumn<>("BarCode");
//        RequisitionColumn.setMinWidth (200);    
//        RequisitionColumn.setSortable(false);  
//        RequisitionColumn.setCellValueFactory(new PropertyValueFactory<>("prescrionbarcode"));                                 

        Iterator<OPDPrescriptionModel> reqit = list.iterator();
        while(reqit.hasNext())
        {
            OPDPrescriptionModel patient = new OPDPrescriptionModel();
            patient = reqit.next();

            itemsobs.add(new OPDPrescriptionModel(
                    patient.getPrescriptionid(),                    
                    patient.getPatientNo(),
                    patient.getFirstName(),
                    patient.getMiddleName(),
                    patient.getLastName(),                    
                    patient.getCmsCode(),
                    patient.getDrugName(),                    
                    patient.getAdmissionCode(),
                    patient.getDosageForm(),
                    patient.getInstruction(),
                    patient.getMalangizo(),
                    patient.getExpirydate(),
                    patient.getStrength(),
                    patient.getQuantity(),
                    patient.getPx(),                    
                    patient.getFrequency(),
                    patient.getPrescrionbarcode()));                  
        }
        TVShowPatient.getColumns().clear();
        TVShowPatient.setItems(itemsobs);
        TVShowPatient.getColumns().addAll(
                PatientNoPackedColumn,CMSCODEColumn,AdmissionColumn,
                FrequencyColumn);          
    }
    
    public void print(final Node node) {
//        Paper photo = PrintHelper.createPaper("2x3", 226.77165354, 302.36220472, Units.POINT);
        try
        {
//                Constructor<Paper> c = Paper.class.getDeclaredConstructor(String.class,double.class, double.class, Units.class);
//                c.setAccessible(true);
//                Paper photo = c.newInstance("29mm x 2", 23.0, 23.0, MM);  
                
                Paper photo = PrintHelper.createPaper("Visitor Name Badge Label", 62.0, 80.0, Units.MM);
                Printer printer = Printer.getDefaultPrinter();
                PageLayout pageLayout = printer.createPageLayout(photo, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);        
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
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

            
    }  
    
  public static void printNode(final Node node) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
    
    try
    {
        Printer printer = Printer.getDefaultPrinter();
        Paper photo = PrintHelper.createPaper("Visitor Name Badge Label", 62.0, 80.0, Units.MM);
        PageLayout pageLayout = printer.createPageLayout(photo, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
//        PageLayout pageLayout = printer.createPageLayout(photo, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
        PrinterAttributes attr = printer.getPrinterAttributes();
        PrinterJob job = PrinterJob.createPrinterJob();
//        double scaleX = pageLayout.getPrintableWidth() / node.getBoundsInParent().getWidth();
//        double scaleY = pageLayout.getPrintableHeight() / node.getBoundsInParent().getHeight();
//        Scale scale = new Scale(scaleX, scaleY);
//        node.getTransforms().add(scale);        
        
        JobSettings jobsettings = job.getJobSettings();
        jobsettings.setPageLayout(pageLayout);        
    //    if (job != null && job.showPrintDialog(node.getScene().getWindow())) {
    //      boolean success = job.printPage(pageLayout, node);
    //      if (success) {
    //        job.endJob();
    //
    //      }
    //    }
            if (job != null) {
                boolean success = job.printPage(node);
                if (success) {
                    job.endJob();
                }
            }    
//        node.getTransforms().remove(scale);
      }      
    catch(IllegalArgumentException iae)
    {
        System.out.println(iae.getMessage());
    }
      catch(Exception e)
      {
          System.out.println(e.getMessage());
          System.out.println(e.getStackTrace());
      }
    }
}
