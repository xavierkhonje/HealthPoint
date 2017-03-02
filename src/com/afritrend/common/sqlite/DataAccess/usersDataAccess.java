/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.sqlite.DataAccess;

import com.afritrend.common.config_sqlite;
import com.afritrend.common.sqlite.Model.user;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Xavier Khonje
 */
public class usersDataAccess {
    
    public String SaveUser(user usr)
    {
        Connection c = null;
        Statement stmt = null;
        try 
        {
         config_sqlite config = new config_sqlite();
         c = config.ConnectSQLite();
         c.setAutoCommit(false);
          stmt = c.createStatement();
          String sql = "INSERT INTO users (FirstName,LastName,EmailAddress,DepartmentName,LastTimeActive,DateCreated,DateModified,CreatedBy,MiddleName) " +
                        "VALUES ('"+usr.getFirstName()+"','"+usr.getLastname()+"','"+usr.getEmailaddress()+"','"+usr.getDepartmentName()+"','not sure','12-12-12','12-12-12','Administrator','"+usr.getMiddlename()+"');";           
          
          stmt.executeUpdate(sql);

          stmt.close();
          c.commit();
          c.close();
        } 
        catch ( Exception e ) 
        {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    
        return "Records created successfully";        
    
    }
    
    public user GetUsers()
    {
        Connection c = null;
        Statement stmt = null;
        user usr = new user();
        try 
        {
          config_sqlite config = new config_sqlite();
          c = config.ConnectSQLite();
          c.setAutoCommit(false);
          stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM Users;" );
          while ( rs.next() ) 
          {
             usr.setUserid(rs.getInt("userid"));
             usr.setFirstName(rs.getString("FirstName"));
             usr.setLastname(rs.getString("LastName"));
             usr.setEmailaddress(rs.getString("EmailAddress"));
          }
          rs.close();
          stmt.close();
          c.close();
        } 
        catch ( Exception e ) 
        {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    
        return usr;          
    }
    
    public String updateUsers()
    {
        Connection c = null;
        Statement stmt = null;
        try 
        {
         config_sqlite config = new config_sqlite();
         c = config.ConnectSQLite();
         c.setAutoCommit(false);
          stmt = c.createStatement();
          String sql = "UPDATE users set SALARY = 25000.00 where ID=1;";
          stmt.executeUpdate(sql);
          c.commit();         

          stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM users;" );
          while ( rs.next() ) {
             int id = rs.getInt("id");
             String  name = rs.getString("name");
             int age  = rs.getInt("age");
             String  address = rs.getString("address");
             float salary = rs.getFloat("salary");
          }
          rs.close();
          stmt.close();
          c.close();
        } 
        catch ( Exception e ) 
        {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    
        return "Records created successfully";           
    }
    
    
    public String DeleteUser()
    {
        Connection c = null;
        Statement stmt = null;
        try 
        {
         config_sqlite config = new config_sqlite();
         c = config.ConnectSQLite();
         c.setAutoCommit(false);
          stmt = c.createStatement();
          String sql = "DELETE FROM Users;";
          stmt.executeUpdate(sql);
          c.commit();        

//          stmt = c.createStatement();
//          ResultSet rs = stmt.executeQuery( "SELECT * FROM users;" );
//          while ( rs.next() ) {
//             int id = rs.getInt("id");
//             String  name = rs.getString("name");
//             int age  = rs.getInt("age");
//             String  address = rs.getString("address");
//             float salary = rs.getFloat("salary");
//          }
//          rs.close();
          stmt.close();
          c.close();
        } 
        catch ( Exception e ) 
        {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    
        return "Records created successfully";          
    }
}
