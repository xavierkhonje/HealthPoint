/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.PharmacyDataAccess.TempProcurementDataAccess;
import com.afritrend.PharmacyModel.ProcurementOrder;
import com.afritrend.PharmacyModel.Sockets;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class ProcurementOrderController implements Initializable {
    
    @FXML
    TableView ProcurementTV;
    
    @FXML
    ComboBox cbItemClass,cbcmscode;
    
    @FXML
    TextArea tfDescription;
    
    @FXML
    TextField txtitemQuantity,idIssueUnit;
    
    
    private WebSocketContainer container;
    private Sockets endpoint;    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        container  = ContainerProvider.getWebSocketContainer();
        this.endpoint = new Sockets();  
        
        try 
        {        
            this.container.connectToServer(this.endpoint, new URI("ws://localhost:8080/HealthPointServices/CMSProcumentService"));
        } 
        catch (Exception ex) 
        {
            System.out.println(ex.getMessage());
        }
    }    
    
    @FXML
    private void MakeOrder(ActionEvent event)
    {
        try 
        {
            String cmscode = String.valueOf(cbcmscode.getValue());
            int Quantity = Integer.valueOf(txtitemQuantity.getText());
            String Description = tfDescription.getText();
            
            ProcurementOrder procurement = new ProcurementOrder();
            List<ProcurementOrder> procurelist = new ArrayList();
            
            procurement.setItemcode(cmscode);
            procurement.setQuantity(Quantity);
            procurement.setDescription(Description);

            //send to cms
            ArrayList listobj = new ArrayList();
            listobj.add(procurement);      
            
            this.endpoint.SendMessage(listobj);
        } 
        catch (IOException ex) 
        {
            
            System.out.println(ex.getMessage());
        }
    }
    
    @FXML
    private void UploadProcurementExcel(ActionEvent event)
    {
        try
        {
            Stage stage = (Stage)ProcurementTV.getScene().getWindow();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Procurement File");
            File file = fileChooser.showOpenDialog(stage);
            //Excelimporter.getStudentsListFromExcel();            
            //multiple files
//                    List<File> list =
//                        fileChooser.showOpenMultipleDialog(stage);
//                    if (list != null) {
//                        for (File file : list) {
//                            openFile(file);
//                        }
//                    }            
//            String excelfilepath = file.getPath().replace("\\", "\\\\");
            String excelfilepath = file.getPath();
            
            //convert this file to byte array - which becomes a binary data information
            byte[] imgDataBa = new byte[(int)file.length()];
            DataInputStream dataIs = new DataInputStream(new FileInputStream(file));
            dataIs.readFully(imgDataBa);
            
//            socket.getConnection().sendMessage(imgDataBa, 0, imgDataBa.length);
            //the u can send this across the network to the server
            
            if(file != null)
            {
                    FileInputStream fileIn = new FileInputStream(excelfilepath);               
                    XSSFWorkbook wb = new XSSFWorkbook(fileIn);
                  
                    XSSFSheet sheet = wb.getSheetAt(0);
                    Row row; 
                        for(int i=1; i<=sheet.getLastRowNum(); i++)
                        {

                            row = sheet.getRow(i);

//                            String row1 = row.getCell(0).getNumericCellValue();
                            String row1 = row.getCell(0).getStringCellValue();
                            String row2 = row.getCell(1).getStringCellValue();
                            String row3 = row.getCell(2).getStringCellValue();
                            String row4 = row.getCell(3).getStringCellValue();
                            
                            //you can save the file to a database or send to sqllite then display for editting before sending to database
                            System.out.println(row1+" _ "+row2+" _ "+row3+" _ "+row4);
                        }    
                        wb.close();
                        fileIn.close(); 
            }
            else
            {
                System.out.println("Please Provide File");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }        
    }
    
    @FXML
    private void AddNewProc(ActionEvent event)
    {
        String cmscode = String.valueOf(cbcmscode.getValue());
        int Quantity = Integer.valueOf(txtitemQuantity.getText());
        String Description = tfDescription.getText(); 
        String itemClass = String.valueOf(cbItemClass.getValue());
        String ScaleUnit = idIssueUnit.getText();
        
        ProcurementOrder procurement = new ProcurementOrder(); 
        
        procurement.setItemcode(cmscode);
        procurement.setQuantity(Quantity);
        procurement.setDescription(Description);        
        procurement.setItemclass(itemClass);        
        procurement.setScaleUnit(ScaleUnit);        
        
        TempProcurementDataAccess tempprocdao = new TempProcurementDataAccess();
        tempprocdao.SaveTempTTO(procurement);
    }
    
}
