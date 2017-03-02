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
 * @author Xavier
 */
public class config {
    
    // --DESKTOP-16C8DT5\AFRITREND   --- Zomba
    // --DESKTOP-14GE491\AFRITREND   --- Thyolo
    //Development Machine: DESKTOP-MB29AK8
      public static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
      public static final String DB_URL = "jdbc:sqlserver://DESKTOP-MB29AK8\\AFRITREND;databaseName=HealthPoint;";    
//    public static final String DB_URL = "jdbc:sqlserver://192.168.0.3\\AFRITREND;databaseName=HealthPoint;";    
//    public static final String DB_URL = "jdbc:sqlserver://192.168.1.2\\AFRITREND;databaseName=HealthPoint;";
    
    public static final String USER = "sa";   
    public static final String PASS = "Kangoo**123";  //-- for production server --    
    
//    public static final String USER = "xkhonje";   
//    public static final String PASS = "Kangoo**1234";  //-- for production server --    
    
//    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    public static final String DB_URL = "jdbc:mysql://localhost/devenv_mkonnect";
//    
//    //public static final String USER = "root";   // -- Development User Login Credentials
//    public static final String USER = "sa"; //Production Server Credentials   
//    public static final String PASS = "Kangoo**123";
    
    Connection conn = null;
    
    public Connection DBConnect()
    {
	try
	{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);  		    
	}
	catch(Exception ex)
	{
	    System.out.println(ex.getMessage());
	}
	return conn;
    }    
}
