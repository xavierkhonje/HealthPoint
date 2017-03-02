/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.PharmacyDataAccess.PharmacyReports;
import com.afritrend.PharmacyModel.costSummaryModel;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class InventoryByLocationReportController implements Initializable {
    
    @FXML
    Label lblStockLevelReportTypeError;
    
    @FXML
    ComboBox CbReportType;
    
    @FXML
    TableView TVStockLevelReport;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CbReportType.getItems().addAll("Low Level","High Level","Expiring Drugs");
    }    
    
    @FXML
    public void ShowStockcardReport(ActionEvent event)
    {
        String ReportType = String.valueOf(CbReportType.getValue());
        List<costSummaryModel> levelreport = new ArrayList();
        
        PharmacyReports reports = new PharmacyReports();
        levelreport = reports.GetStockLevelsSupplierReport(ReportType);
        
        ShowLevels(levelreport);        
    }
    
    public void ShowLevels(List<costSummaryModel> levelreport)
    {
        
                ObservableList<costSummaryModel> itemsobs = FXCollections.observableArrayList();  
                
                TableColumn<costSummaryModel, String> ItemQTYColumn = new TableColumn<>("Quantity");
                ItemQTYColumn.setMinWidth (100);    
                ItemQTYColumn.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));  

                TableColumn<costSummaryModel, String> PriceColumn = new TableColumn<>("Price");
                PriceColumn.setMinWidth (140);    
                PriceColumn.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));      

                TableColumn<costSummaryModel, String> LineTotalColumn = new TableColumn<>("Line Total");
                LineTotalColumn.setMinWidth (100);    
                LineTotalColumn.setCellValueFactory(new PropertyValueFactory<>("itemLineTotal")); 

                TableColumn<costSummaryModel, String> TotalColumn = new TableColumn<>("Total Value");        
                TotalColumn.setMinWidth (100);    
                TotalColumn.setCellValueFactory(new PropertyValueFactory<>("totalValue"));         

                TableColumn<costSummaryModel, String> DescriptionColumn = new TableColumn<>("Description");        
                DescriptionColumn.setMinWidth (70);    
                DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));        

                TableColumn<costSummaryModel, String> SupplierColumn = new TableColumn<>("Supplier");        
                SupplierColumn.setMinWidth (200);    
                SupplierColumn.setCellValueFactory(new PropertyValueFactory<>("itemSupplier"));                                       

                Iterator<costSummaryModel> itlist = levelreport.iterator();
                while(itlist.hasNext())
                {
                costSummaryModel item = new costSummaryModel();
                item = itlist.next();
                
                itemsobs.add(new costSummaryModel(
                        item.getItemQuantity(),item.getItemPrice(),
                        item.getItemLineTotal(),item.getTotalValue(),item.getDescription(),
                        item.getItemSupplier()
                ));
                }
                
                TVStockLevelReport.getColumns().clear();
                TVStockLevelReport.setItems(itemsobs);
                TVStockLevelReport.getColumns().addAll(
                        ItemQTYColumn,PriceColumn,LineTotalColumn,
                        TotalColumn,DescriptionColumn,SupplierColumn);         
    }        
    
}
