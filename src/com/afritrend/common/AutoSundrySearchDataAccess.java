/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common;

import com.afritrend.common.Interfaces.IAutoSundrySearch;
import com.afritrend.common.Model.SundryItemModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public class AutoSundrySearchDataAccess implements IAutoSundrySearch{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;       
    
    //spHP_GetSundryClass
    @Override
    public List<String> GetSundryClass() {
        List<String> classlist =  new ArrayList();        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GetSundryClass}";    
            stmt = conn.prepareCall(sql);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String sundryclass = "";
                sundryclass = rs.getString("SundryClass");
                
                classlist.add(sundryclass);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return classlist;          
    }

    @Override
    public List<String> GetSundryCode(String SundryClass) {
        List<String> cmscodelist =  new ArrayList();        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GetSundryCodes(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, SundryClass);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String code = "";
                code = rs.getString("cmscode");
                
                cmscodelist.add(code);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return cmscodelist;         
    }

    @Override
    public List<String> GetSundryName(String ItemCode) {
        List<String> SundryNamelist =  new ArrayList();        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GetSundryNames(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, ItemCode);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String SundryName = "";
                SundryName = rs.getString("SundryName");
                
                SundryNamelist.add(SundryName);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return SundryNamelist;         
    }

    @Override
    public List<String> GetSundryIssueUnit(String SundryName) {
        List<String> IssueUnitlist =  new ArrayList();        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GetSundryIssueUnit(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, SundryName);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String IssueUnit = "";
                IssueUnit = rs.getString("IssueUnit");
                
                IssueUnitlist.add(IssueUnit);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return IssueUnitlist;             
    }

    @Override
    public List<String> GetSundryDescription() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
