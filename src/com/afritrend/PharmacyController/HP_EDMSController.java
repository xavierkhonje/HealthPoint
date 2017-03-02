/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyController;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class HP_EDMSController implements Initializable {

    private File file;
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void AttachFile()
    {
        FileChooser filechooser = new FileChooser();
        filechooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files","*.txt"),
                new FileChooser.ExtensionFilter("Image Files", "*.png","*.jpg","*.pdf"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        Stage stage = new Stage();
        file = filechooser.showOpenDialog(stage);
        if(file != null)
        {
            //Move the Files to the Server for file storage
            
            //the EDMS to be used should provide all indexing capabilities as previously used, with searching
            //capabilities as well. access rights provided as well depending
        }        
    }
    
}
