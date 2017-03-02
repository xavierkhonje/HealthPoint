/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.DataAccess;

import com.afritrend.WardModel.wardUser;
import com.afritrend.common.Interfaces.Iusers;
import com.afritrend.common.Model.UsersModel;
import com.afritrend.common.config;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Xavier
 */
public class UsersDataAccess implements Iusers{
    
    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;  
    
    Date date = new Date();    
    
    @Override
    public String Saveusers(UsersModel users) {
        try
        {
            ResultSet rs = null;
            conn = config.DBConnect(); 
            String sql = "{CALL spHP_SaveUser(?,?,?,?,?,?,?,?,?,?,?,?,?)}";    
            stmt = conn.prepareCall(sql);                        
            
            stmt.setString(1, users.getFirstname());
            stmt.setString(2, users.getMiddlename());
            stmt.setString(3, users.getLastname());
            stmt.setString(4, users.getOffice_tel());
            stmt.setString(5, users.getHome_tel());
            stmt.setString(6, users.getDesignation());
            stmt.setString(7, users.getEmail());
            stmt.setString(8, users.getPassword());
            stmt.setString(9, users.getStatus());
            stmt.setString(10, users.getTest_Question());
            stmt.setString(11, users.getAnswer());
            stmt.setString(12, users.getUsergroup());
            stmt.setString(13, users.getDepartment());
            
            stmt.execute();                       
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
        finally
        {
            return "Store Procedure Processed";
        }   
    }
    
    @Override
    public String SaveWardusers(wardUser users) {
        
        String msg = "";
        
        try
        {
            ResultSet rs = null;
            conn = config.DBConnect(); 
            String sql = "{CALL spHP_SaveWardUser(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";    
            stmt = conn.prepareCall(sql);                        
            
            stmt.setString(1, users.getFirstname());
            stmt.setString(2, users.getMiddlename());
            stmt.setString(3, users.getLastname());
            stmt.setString(4, users.getOffice_tel());
            stmt.setString(5, users.getHome_tel());
            stmt.setString(6, users.getDesignation());
            stmt.setString(7, users.getEmail());
            stmt.setString(8, users.getPassword());
            stmt.setString(9, users.getStatus());
            stmt.setString(10, users.getTest_Question());
            stmt.setString(11, users.getAnswer());
            stmt.setString(12, users.getUsergroup());
            stmt.setString(13, users.getWard());
            stmt.registerOutParameter(14, Types.NVARCHAR);
            
            stmt.execute();          
            
            msg = stmt.getString(14);
        }
        catch(Exception e)
        {
            msg = e.getMessage();
        }
        finally
        {
            return msg;
        }   
    }

    @Override
    public String Updateusers(UsersModel users) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsersModel> Viewusers() {
        config config = new config();
        Connection conn = null;
        CallableStatement stmt = null;         
        List<UsersModel> list = new ArrayList();
//        try
//        {
//            conn = config.DBConnect();       
//            stmt = conn.createStatement();
//            String sql = "SELECT * FROM `users`";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            //get all data rows and put them in a list
//                while(rs.next())
//                {               	
//                    UsersModel users = new UsersModel();
//                    
////                    users.setIdstudent(rs.getInt("idstudent"));
////                    users.setStudentName(rs.getString("studentName"));
////                    users.setDistrictofOrigin(rs.getString("DistrictofOrigin"));
////                    users.setDayofbirth(rs.getString("dayofbirth"));                    
////                    users.setMonthofbirth(rs.getString("monthofbirth"));
////                    users.setYearofbirth(rs.getString("yearofbirth")); 
////                    users.setFirstyear(rs.getString("firstyear"));
////                    users.setDistrictname(rs.getString("districtname"));
////                    users.setCentrename(rs.getString("centrename"));                  
////                    
//                    list.add(users);
//                }              
//            conn.close();
//        }
//        catch(Exception ex)
//        {
//            ex.getMessage();
//        }  
//        finally
//        { 
//            
//        }                  
        return list;          
    }

    @Override
    public String Deactivateusers(UsersModel users) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer SearchusersID(String criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsersModel Authenticateusers(String Email, String Password) {
        UsersModel usr = new UsersModel();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_AuthenticateUser(?,?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, Email);
            stmt.setString(2, Password);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                usr.setFirstname(rs.getString("firstname"));
                usr.setMiddlename(rs.getString("middlename"));
                usr.setLastname(rs.getString("lastname"));
                usr.setOffice_tel(rs.getString("office_tel"));
                usr.setHome_tel(rs.getString("home_tel"));
                usr.setLast_login(rs.getString("last_login"));
                usr.setEmail(rs.getString("email"));
                usr.setPassword(rs.getString("password"));
                usr.setDesignation(rs.getString("designation"));
                usr.setStatus(rs.getString("Status"));
                usr.setUsergroup(rs.getString("usergroupName"));                
                usr.setDepartment(rs.getString("DptName"));                  
            }                        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }        
        finally
        {
            
        }        
        
        return usr;         
    }
    
}
