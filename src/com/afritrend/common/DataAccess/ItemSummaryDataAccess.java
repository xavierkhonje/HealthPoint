/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.DataAccess;

import com.afritrend.common.Model.itemAmount;
import com.afritrend.common.config;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Xavier
 */
public class ItemSummaryDataAccess {
    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;  

    public List<itemAmount> GetItems()
    {
        List<itemAmount> itemlist = new ArrayList<>();
        try
        {            
            ResultSet rs = null;
            conn = config.DBConnect();   
            String sql = "{CALL spHP_GETDrugSummaryLevels}";            
            stmt = conn.prepareCall(sql);
            stmt.execute();
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                itemAmount items = new itemAmount();
                items.setItemName(rs.getString("ItemName"));
                items.setAmount(Integer.valueOf(rs.getString("Amount")));
                items.setStrength(rs.getString("Strength"));
                items.setCmscode(rs.getString("ItemCode"));               
                
                itemlist.add(items);
            }
        }
        catch(Exception e)
        {
            
        }
        return itemlist;
    }   
}
