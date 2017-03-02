/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.Pharmacy.Reports.PharmacyDrugStockCard;
import com.afritrend.PharmacyDataAccess.PharmacyReports;
import com.afritrend.PharmacyModel.PharmacyStockCardModel;
import com.afritrend.Ward.Factory.WardFactory;
import com.afritrend.WardModel.ItemsModel;
import com.afritrend.common.Model.DrugConfiguration;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class DrugStockCardController implements Initializable {

    @FXML
    TableView TVStockcardReport;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
//    public void ShowReport(ActionEvent event)
//    { 
//        try
//        {                    
//            String Path = "C:\\reports\\PharmacyDrugsStockCardReport.jrxml";
//            JasperReport Jasp_Rep = JasperCompileManager.compileReport(Path);            
//            JasperPrint Jasperprint = JasperFillManager.fillReport(Jasp_Rep,null, new JRBeanCollectionDataSource(PharmacyDrugStockCard.PharmacyDrugStockCardFactory()));
//            JasperViewer.viewReport(Jasperprint, false);  
//        }
//        catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//    }
        
    public void ShowStockcardReport(ActionEvent event)
    {
        PharmacyReports reportdao = new PharmacyReports();
        List<PharmacyStockCardModel> stockrptlist = new ArrayList();        
        stockrptlist = reportdao.GetPharmacyDrugsStockcardReport("Antibiotic","Panado","12-12-12","12-12-12");
                
        ObservableList<PharmacyStockCardModel> report = FXCollections.observableArrayList();  
        
        TableColumn<PharmacyStockCardModel, String> DRUGNAMEColumn = new TableColumn<>("Drug Name");
        DRUGNAMEColumn.setMinWidth (200);    
        DRUGNAMEColumn.setCellValueFactory(new PropertyValueFactory<>("drugName"));  
                
        TableColumn<PharmacyStockCardModel, String> CMSCODEColumn = new TableColumn<>("CMSCODE");
        CMSCODEColumn.setMinWidth (200);    
        CMSCODEColumn.setCellValueFactory(new PropertyValueFactory<>("cmscode"));  
                
        TableColumn<PharmacyStockCardModel, String> STRENGTHColumn = new TableColumn<>("Strength");
        STRENGTHColumn.setMinWidth (200);    
        STRENGTHColumn.setCellValueFactory(new PropertyValueFactory<>("strength"));  
                
        TableColumn<PharmacyStockCardModel, String> DOSAGEColumn = new TableColumn<>("Dosage Form");
        DOSAGEColumn.setMinWidth (200);    
        DOSAGEColumn.setCellValueFactory(new PropertyValueFactory<>("dosageForm"));  
                
        TableColumn<PharmacyStockCardModel, String> ISSUEUNITColumn = new TableColumn<>("Issue Unit");
        ISSUEUNITColumn.setMinWidth (200);    
        ISSUEUNITColumn.setCellValueFactory(new PropertyValueFactory<>("issueUnit"));  
                
        TableColumn<PharmacyStockCardModel, String> RECEIVEDColumn = new TableColumn<>("Received Amount");
        RECEIVEDColumn.setMinWidth (200);    
        RECEIVEDColumn.setCellValueFactory(new PropertyValueFactory<>("receivedAmount"));  
                
        TableColumn<PharmacyStockCardModel, String> ISSUEColumn = new TableColumn<>("Issued Amount");
        ISSUEColumn.setMinWidth (200);    
        ISSUEColumn.setCellValueFactory(new PropertyValueFactory<>("issuedAmount"));  
                
        TableColumn<PharmacyStockCardModel, String> LOSTColumn = new TableColumn<>("Lost Amount");
        LOSTColumn.setMinWidth (200);    
        LOSTColumn.setCellValueFactory(new PropertyValueFactory<>("lostAmount"));  
                
        TableColumn<PharmacyStockCardModel, String> EXPIREDColumn = new TableColumn<>("Expired Amount");
        EXPIREDColumn.setMinWidth (200);    
        EXPIREDColumn.setCellValueFactory(new PropertyValueFactory<>("expiredAmount"));  
                
        TableColumn<PharmacyStockCardModel, String> ADJUSTPLUSColumn = new TableColumn<>("Adjusted Minus");
        ADJUSTPLUSColumn.setMinWidth (200);    
        ADJUSTPLUSColumn.setCellValueFactory(new PropertyValueFactory<>("adjustedPlusAmount"));  
                
        TableColumn<PharmacyStockCardModel, Integer> ADJUSTMINUSColumn = new TableColumn<>("Adjust Minus");
        ADJUSTMINUSColumn.setMinWidth (200);    
        ADJUSTMINUSColumn.setCellValueFactory(new PropertyValueFactory<>("adjustedMinusAmount"));   
                
        Iterator<PharmacyStockCardModel> stockit = stockrptlist.iterator();
        while(stockit.hasNext())
        {
            PharmacyStockCardModel stockcardrpt = new PharmacyStockCardModel();
            stockcardrpt = stockit.next();
            report.add(
                    new PharmacyStockCardModel(
                            stockcardrpt.getDrugName(),
                            stockcardrpt.getCmscode(),
                            stockcardrpt.getStrength(),
                            stockcardrpt.getDosageForm(),
                            stockcardrpt.getIssueUnit(),
                            stockcardrpt.getReceivedAmount(),
                            stockcardrpt.getIssuedAmount(),
                            stockcardrpt.getLostAmount(),
                            stockcardrpt.getExpiredAmount(),
                            stockcardrpt.getAdjustedPlusAmount(),
                            stockcardrpt.getAdjustedMinusAmount()
                    ));
        }
                
        TVStockcardReport.getColumns().clear();        
        TVStockcardReport.setItems(report);
        TVStockcardReport.getColumns().addAll(
                DRUGNAMEColumn,
                CMSCODEColumn,
                STRENGTHColumn,
                DOSAGEColumn,
                ISSUEUNITColumn,
                RECEIVEDColumn,
                ISSUEColumn,
                LOSTColumn,
                EXPIREDColumn,
                ADJUSTPLUSColumn,
                ADJUSTMINUSColumn                
        );

    }        
    
    @FXML
    public void ViewReport()
    {
        try
        {                    
            String Path = "C:\\reports\\PharmacyDrugsStockCardReport.jrxml";
            JasperReport Jasp_Rep = JasperCompileManager.compileReport(Path);            
            JasperPrint Jasperprint = JasperFillManager.fillReport(Jasp_Rep,null, new JRBeanCollectionDataSource(PharmacyDrugStockCard.PharmacyDrugStockCardFactory()));
            JasperViewer.viewReport(Jasperprint, false);  
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }        
    }
    
}
