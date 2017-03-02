/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.DataAccess;

import com.afritrend.common.Interfaces.IitemEWP;
import com.afritrend.common.Model.ItemEWP;
import com.afritrend.common.config;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public class ItemWarningPeriodDataccess implements IitemEWP{
    
    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null; 
    
    @Override
    public List<ItemEWP> getItemWarningPeriod() {
        List<ItemEWP> Itemewplist = new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_CheckDrugExpiry}";    
            stmt = conn.prepareCall(sql);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {                
                ItemEWP item = new ItemEWP();
                
                item.setTodayDate(rs.getString("TodayDate"));
                item.setExpiryDate(rs.getString("ExpiryDate"));
                item.setExpiryWarningPeriod(rs.getInt("EWP"));
                item.setAgingPeriod(rs.getInt("AgingPeriod"));
                item.setStatus(rs.getString("STATUS"));    
                
                Itemewplist.add(item);
            }                        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }        
        finally
        {
            
        }        
        
        return Itemewplist;          
    }
    
}
