/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Xavier Khonje
 */
public class config_sqlite {
    
      Connection conn = null;
      public Connection ConnectSQLite()
      {
        try 
        {
          Class.forName("org.sqlite.JDBC");
          conn = DriverManager.getConnection("jdbc:sqlite:HealthPoint.db");
        } 
            catch (Exception e) 
        {
          System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }        
        return conn;
    }    
}
