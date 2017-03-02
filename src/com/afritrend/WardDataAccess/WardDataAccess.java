/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardDataAccess;

import com.afritrend.PharmacyModel.WardModel;
import com.afritrend.WardInterfaces.Iward;
import com.afritrend.WardModel.wardUser;
import com.afritrend.common.config;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public class WardDataAccess implements Iward{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;  
    
    Date date = new Date();        
    
    @Override
    public String saveWard(WardModel ward) {
        
        String msg = "";
        try
        {
            ResultSet rs = null;
            conn = config.DBConnect(); 
            String sql = "{CALL spHP_SaveWard(?,?,?)}";    
            stmt = conn.prepareCall(sql);                        
            
            stmt.setString(1, ward.getWardName());
            stmt.setString(2, ward.getLocation());
            stmt.registerOutParameter(3, Types.NVARCHAR);

            
            stmt.execute();                   
            
            msg = stmt.getString(3);
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
    public List<WardModel> getWardDetails() {
            List<WardModel> wardlist = new ArrayList();
            try
            {
                conn = config.DBConnect(); 
                ResultSet rs = null;
                String sql = "{CALL spHP_GETWard}";    
                stmt = conn.prepareCall(sql);
                stmt.execute();
                rs = stmt.getResultSet();

                while(rs.next())
                {
                    WardModel ward = new WardModel();

                    ward.setWardName(rs.getString("WardName"));                
                    ward.setLocation(rs.getString("Location"));                
                  
                    wardlist.add(ward);
                }                        
            }
            catch(Exception e)
            {

            }        
            finally
            {

            }             
            return wardlist;        
    }

    @Override
    public List<wardUser> getWardUsers(String WardName) {
            List<wardUser> wardlist = new ArrayList();
            try
            {
                conn = config.DBConnect(); 
                ResultSet rs = null;
                String sql = "{CALL spHP_GetWardusers(?)}";    
                stmt = conn.prepareCall(sql);
                stmt.setString(1, WardName);
                stmt.execute();
                rs = stmt.getResultSet();

                while(rs.next())
                {
                    wardUser user = new wardUser();

                    user.setFirstname(rs.getString("firstname"));                
                    user.setMiddlename(rs.getString("middlename"));                
                    user.setLastname(rs.getString("lastname"));                
                    user.setOffice_tel(rs.getString("office_tel"));                
                    user.setHome_tel(rs.getString("home_tel"));                
                    user.setLast_login(rs.getString("last_login"));                
                    user.setPassword_retries(rs.getInt("password_retries"));                
                    user.setDesignation(rs.getString("designation"));                
                    user.setEmail(rs.getString("email"));                
                    user.setPassword(rs.getString("password"));                
                    user.setStatus(rs.getString("Status"));                
                    user.setReset_password_Key(rs.getString("reset_password_Key"));                
                    user.setTest_Question(rs.getString("test_Question"));                
                    user.setAnswer(rs.getString("answer"));                
                    user.setUsergroup(rs.getString("WardName"));                
                    user.setWard(rs.getString("groupname"));                
                   
                    wardlist.add(user);
                }                        
            }
            catch(Exception e)
            {

            }        
            finally
            {

            }             
            return wardlist;        
    }
    
}
