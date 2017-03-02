/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardDataAccess;

import com.afritrend.WardInterfaces.Iitem;
import com.afritrend.WardModel.ItemModel;
import com.afritrend.common.config;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Xavier Khonje
 */
public class ItemDataAccess implements Iitem{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;      
    
    @Override
    public String SaveItem(ItemModel item) {
            try
            {
                //send a full table
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_SaveWardItem(?,?,?,?,?,?,?,?,?,?,?,?)}";    
                
                stmt = conn.prepareCall(sql);
                stmt.setString(1, item.getItemCode());
                stmt.setString(2, item.getItemClass());
                stmt.setString(3, item.getItemName());
                stmt.setString(4, item.getIssueUnit());
                stmt.setDouble(5, item.getPrice());
                stmt.setString(6, item.getDescription());
                stmt.setString(7, item.getDosageForm());
                stmt.setString(8, item.getStrength());
                stmt.setInt(9, item.getQuantity());
                stmt.setString(10, item.getDrugclass());
                stmt.setString(11, item.getExpirydate());
                stmt.setString(12, "received");
                
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
    public String GetItem(ItemModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
