/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.PharmacyDataAccess.PharmacyReports;
import com.afritrend.PharmacyModel.stockitemLevelModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class LowLevelStockReportController implements Initializable {

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
    public void ShowStockcardReport()
    {
        String ReportType = String.valueOf(CbReportType.getValue());
        List<stockitemLevelModel> levelreport = new ArrayList();
        
        PharmacyReports reports = new PharmacyReports();
        levelreport = reports.GetStockLevelsReport(ReportType);
        
        ShowLevels(levelreport);
    }
    
    public void ShowLevels(List<stockitemLevelModel> levelreport)
    {
        
                ObservableList<stockitemLevelModel> itemsobs = FXCollections.observableArrayList();  
                
                TableColumn<stockitemLevelModel, String> ItemCodeColumn = new TableColumn<>("CMS CODE");
                ItemCodeColumn.setMinWidth (100);    
                ItemCodeColumn.setCellValueFactory(new PropertyValueFactory<>("itemCode"));  

                TableColumn<stockitemLevelModel, String> ItemNameColumn = new TableColumn<>("Item Name");
                ItemNameColumn.setMinWidth (140);    
                ItemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));      

                TableColumn<stockitemLevelModel, String> StrengthColumn = new TableColumn<>("Strength");
                ItemNameColumn.setMinWidth (100);    
                ItemNameColumn.setCellValueFactory(new PropertyValueFactory<>("strength")); 

                TableColumn<stockitemLevelModel, String> AmountColumn = new TableColumn<>("Amount");        
                AmountColumn.setMinWidth (100);    
                AmountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));         

                TableColumn<stockitemLevelModel, String> EWPColumn = new TableColumn<>("Expiry Warning Period");        
                EWPColumn.setMinWidth (70);    
                EWPColumn.setCellValueFactory(new PropertyValueFactory<>("ewp"));        

                TableColumn<stockitemLevelModel, String> MinColumn = new TableColumn<>("Minimum Level");        
                MinColumn.setMinWidth (200);    
                MinColumn.setCellValueFactory(new PropertyValueFactory<>("minlevel"));           

                TableColumn<stockitemLevelModel, String> MaxColumn = new TableColumn<>("Maximum Level");        
                MaxColumn.setMinWidth (100);    
                MaxColumn.setCellValueFactory(new PropertyValueFactory<>("maxlevel"));                                

                Iterator<stockitemLevelModel> itlist = levelreport.iterator();
                while(itlist.hasNext())
                {
                stockitemLevelModel item = new stockitemLevelModel();
                item = itlist.next();
                
                itemsobs.add(new stockitemLevelModel(
                        item.getItemCode(),item.getItemName(),
                        item.getStrength(),item.getAmount(),item.getEwp(),
                        item.getMinlevel(),item.getMinlevel()
                ));
                }
                
                TVStockLevelReport.getColumns().clear();
                TVStockLevelReport.setItems(itemsobs);
                TVStockLevelReport.getColumns().addAll(
                        ItemCodeColumn,ItemNameColumn,StrengthColumn,
                        AmountColumn,EWPColumn,MinColumn,MaxColumn);         
    }
    
}
