/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import com.afritrend.PharmacyModel.ProcurementOrder;
import com.afritrend.PharmacyModel.Sockets;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class ProcurementOrderController implements Initializable {

    @FXML
    TextField iditemcode;
    
    @FXML
    TextField idQuantity;
    
    @FXML
    TextArea ItemDescription;
    
    private WebSocketContainer container;
    private Sockets endpoint;    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        container  = ContainerProvider.getWebSocketContainer();
        this.endpoint = new Sockets();  
        
        try {        
            this.container.connectToServer(this.endpoint, new URI("ws://localhost:8080/HealthPointServices/CMSProcumentService"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }    
    
    @FXML
    private void MakeOrder(ActionEvent event)
    {
        try 
        {
            String cmscode = iditemcode.getText();
            int Quantity = Integer.valueOf(idQuantity.getText());
            String Description = ItemDescription.getText();
            
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
    
}
