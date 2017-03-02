/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.Pharmacy.Reports.PharmacyDrugStockCard;
import com.afritrend.Pharmacy.Reports.PharmacySundryStockCard;
import com.afritrend.PharmacyDataAccess.PharmacyReports;
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
public class SundryStockCardController implements Initializable {
    @FXML
    TableView TVStockcardReport;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void ShowStockcardReport(ActionEvent event)
    {
        PharmacyReports reportdao = new PharmacyReports();
        List<PharmacySundryStockCard> stockrptlist = new ArrayList();        
        stockrptlist = reportdao.GetPharmacySundryStockcardReport("Antibiotic","Panado","12-12-12","12-12-12");
                
        ObservableList<PharmacySundryStockCard> report = FXCollections.observableArrayList();  
        
        TableColumn<PharmacySundryStockCard, String> SUNDRYNAMEColumn = new TableColumn<>("Sundry Name");
        SUNDRYNAMEColumn.setMinWidth (200);    
        SUNDRYNAMEColumn.setCellValueFactory(new PropertyValueFactory<>("sundryName"));  
                
        TableColumn<PharmacySundryStockCard, String> CMSCODEColumn = new TableColumn<>("CMSCODE");
        CMSCODEColumn.setMinWidth (200);    
        CMSCODEColumn.setCellValueFactory(new PropertyValueFactory<>("cmsCode"));  
                
        TableColumn<PharmacySundryStockCard, String> ISSUEUNITColumn = new TableColumn<>("Issue Unit");
        ISSUEUNITColumn.setMinWidth (200);    
        ISSUEUNITColumn.setCellValueFactory(new PropertyValueFactory<>("issueUnit"));   
                
        TableColumn<PharmacySundryStockCard, String> RECEIVEDColumn = new TableColumn<>("Received Amount");
        RECEIVEDColumn.setMinWidth (200);    
        RECEIVEDColumn.setCellValueFactory(new PropertyValueFactory<>("receivedAmount"));  
                
        TableColumn<PharmacySundryStockCard, String> ISSUEColumn = new TableColumn<>("Issued Amount");
        ISSUEColumn.setMinWidth (200);    
        ISSUEColumn.setCellValueFactory(new PropertyValueFactory<>("issueAmount"));  
                
        TableColumn<PharmacySundryStockCard, String> LOSTColumn = new TableColumn<>("Lost Amount");
        LOSTColumn.setMinWidth (200);    
        LOSTColumn.setCellValueFactory(new PropertyValueFactory<>("lostAmount"));  
                
        TableColumn<PharmacySundryStockCard, String> EXPIREDColumn = new TableColumn<>("Expired Amount");
        EXPIREDColumn.setMinWidth (200);    
        EXPIREDColumn.setCellValueFactory(new PropertyValueFactory<>("expiredAmount"));  
                
        TableColumn<PharmacySundryStockCard, String> ADJUSTPLUSColumn = new TableColumn<>("Adjusted Minus");
        ADJUSTPLUSColumn.setMinWidth (200);    
        ADJUSTPLUSColumn.setCellValueFactory(new PropertyValueFactory<>("adjustedPlusAmount"));  
                
        TableColumn<PharmacySundryStockCard, Integer> ADJUSTMINUSColumn = new TableColumn<>("Adjust Minus");
        ADJUSTMINUSColumn.setMinWidth (200);    
        ADJUSTMINUSColumn.setCellValueFactory(new PropertyValueFactory<>("adjustedMinusAmount"));   
                
        Iterator<PharmacySundryStockCard> stockit = stockrptlist.iterator();
        while(stockit.hasNext())
        {
            PharmacySundryStockCard stockcardrpt = new PharmacySundryStockCard();
            stockcardrpt = stockit.next();
            report.add(
                    new PharmacySundryStockCard(
                            stockcardrpt.getSundryName(),
                            stockcardrpt.getCmsCode(),
                            stockcardrpt.getIssueUnit(),
                            stockcardrpt.getReceivedAmount(),
                            stockcardrpt.getIssueAmount(),
                            stockcardrpt.getLostAmount(),
                            stockcardrpt.getExpiredAmount(),
                            stockcardrpt.getAdjustedPlusAmount(),
                            stockcardrpt.getAdjustedMinusAmount()
                    ));
        }
                
        TVStockcardReport.getColumns().clear();        
        TVStockcardReport.setItems(report);
        TVStockcardReport.getColumns().addAll(
                SUNDRYNAMEColumn,
                CMSCODEColumn,
                ISSUEUNITColumn,
                RECEIVEDColumn,
                ISSUEColumn,
                LOSTColumn,
                EXPIREDColumn,
                ADJUSTPLUSColumn,
                ADJUSTMINUSColumn                
        );
    }    
    
    public void ShowReport(ActionEvent event)
    {             
        try
        {                    
            String Path = "C:\\reports\\PharmacySundryStockCard.jrxml";
            JasperReport Jasp_Rep = JasperCompileManager.compileReport(Path);            
            JasperPrint Jasperprint = JasperFillManager.fillReport(Jasp_Rep,null, new JRBeanCollectionDataSource(PharmacySundryStockCard.PharmacySundryStockCardFactory()));
            JasperViewer.viewReport(Jasperprint, false);  
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }    
    
}
