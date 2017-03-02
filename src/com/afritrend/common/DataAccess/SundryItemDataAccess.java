/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.DataAccess;

import com.afritrend.common.Interfaces.ISundry;
import com.afritrend.common.Model.SundryItemModel;
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
public class SundryItemDataAccess implements ISundry{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;      
    String Msg = "";
    
    @Override
    public String SaveSundries(SundryItemModel sunds, String user, String Pharmact) {
        try
        {
            //send a full table
            ResultSet rs = null;
            conn = config.DBConnect(); 
            String sql = "{CALL spHP_SaveSundryInventory(?,?,?,?,?,?,?,?,?,?)}";    

            stmt = conn.prepareCall(sql);
            stmt.setString(1, sunds.getSundryclass());
            stmt.setString(2, sunds.getSundrycode());
            stmt.setString(3, sunds.getSundryname());
            stmt.setString(4, sunds.getIssueunit());
            stmt.setString(5, sunds.getExpiryDate());
            stmt.setInt(6, sunds.getQuantity());
            stmt.setString(7, sunds.getTransactionType());
            stmt.setString(8, Pharmact);
            stmt.setString(9, user);
            stmt.registerOutParameter(10, java.sql.Types.NVARCHAR);

            stmt.execute();
            
            Msg = stmt.getString(10);
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
        finally
        {
            return Msg;
        }         
    }

    public String SaveWardSundry(SundryItemModel sunds, String user, String Ward, int Quantity, String Transaction) {
            try
            {
                //send a full table
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_SaveWardDrug(?,?,?,?,?,?,?,?,?,?,?)}";    
                
                stmt = conn.prepareCall(sql);
//                stmt.setString(1, sunds.getDrugcode());
//                stmt.setString(2, sunds.getDrugclass());
//                stmt.setString(3, sunds.getDosageform());
//                stmt.setString(4, sunds.getDrugname());
//                stmt.setString(5, sunds.getStrength());
//                stmt.setString(6, sunds.getIssueunit());
//                stmt.setString(7, sunds.getExpirydate());
                stmt.setString(8, Ward);
                stmt.setInt(9, Quantity);
                stmt.setString(10, user);
                stmt.setString(11, Transaction);
                
                stmt.execute();
            }
            catch(Exception e)
            {
                return e.getMessage();
            }
            finally
            {
                return "Drug Saved Successfully";
            }           
    }    
    
    @Override
    public SundryItemModel GetSundryDetailsByCode(String drugcmscode) {
        SundryItemModel sundry =  new SundryItemModel();        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GetSundryDetails}";    
            stmt = conn.prepareCall(sql);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                sundry.setSundryclass(rs.getString("ClassName"));
                sundry.setSundrycode(rs.getString("cmscode"));
                sundry.setSundryname(rs.getString("ItemName"));
                sundry.setIssueunit(rs.getString("IssueUnit"));
                sundry.setSundrydescription(rs.getString("Description"));                
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return sundry;   
    }
    
}
