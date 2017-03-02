/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common;

import com.afritrend.common.Interfaces.ICheckConnection;
import com.afritrend.common.config;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Xavier Khonje
 */
public class CheckConnection implements ICheckConnection{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;  
    
    Date date = new Date();      
    
    @Override
    public String CheckServerConnection() {
        try {
            conn = config.DBConnect();            
            if(!conn.isClosed() || conn!=null){
                return "Connection Available";
            }
        } catch (Exception e) {
            return "System Error";
        }
        return "Connection Not Available";
    }
    
}
