/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.DataAccess;

import com.afritrend.common.Interfaces.IDrugSettings;
import com.afritrend.common.Model.DrugConfiguration;
import com.afritrend.common.config;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public class DrugSettingsDataAccess implements IDrugSettings{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;      
    
    @Override
    public String SaveDrugSettings(DrugConfiguration configuration) {
        
            String msg = "";
            try
            {
                //send a full table  -- 
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_DrugConfiguration(?,?,?,?,?)}";    
                
                stmt = conn.prepareCall(sql);
                stmt.setString(1, configuration.getCmscode());
                stmt.setInt(2, configuration.getMinmumLevel());
                stmt.setInt(3, configuration.getMaximumLevel());
                stmt.setInt(4, configuration.getEwd());
                stmt.registerOutParameter(5, Types.NVARCHAR);
                
                stmt.execute();
                
                msg = stmt.getString(5);
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
    public List<DrugConfiguration> GetDrugConfigurations() {  
        
        List<DrugConfiguration> configlist =  new ArrayList();        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETItemsSettings}";    
            stmt = conn.prepareCall(sql);
            
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                DrugConfiguration itemconfig = new DrugConfiguration();
                itemconfig.setCmscode(rs.getString("Cmscode"));                
                itemconfig.setMaximumLevel(rs.getInt("MinimumLevel"));                
                itemconfig.setMinmumLevel(rs.getInt("MaximumLevel"));                
                itemconfig.setEwd(rs.getInt("EWP"));                
                configlist.add(itemconfig);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return configlist;         
    }
    
}
