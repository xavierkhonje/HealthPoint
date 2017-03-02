/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyDataAccess;

import com.afritrend.PharmacyInterfaces.Isundry;
import com.afritrend.PharmacyModel.SundryModel;
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
public class SundryDataAccess implements Isundry{
    
    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null; 
    String Msg = "";
    
    @Override
    public String SaveSundry(SundryModel sundry) {
            try
            {
                //send a full table
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_SaveSundry(?,?,?,?,?,?,?,?,?,?)}";    
                
                stmt = conn.prepareCall(sql);
                stmt.setString(1, sundry.getCmsclass());
                stmt.setString(2, sundry.getCmscode());
                stmt.setString(3, sundry.getSundryname());
                stmt.setString(4, sundry.getIssueUnit());
                stmt.setDouble(5, sundry.getPrice());
                stmt.setString(6, sundry.getDescription());
                stmt.setString(7, sundry.getSundrysource());
                stmt.setString(8, sundry.getSundryclass());
                stmt.setString(9, sundry.getStatus());
                stmt.setString(10, "received");
                stmt.registerOutParameter(11, java.sql.Types.NVARCHAR);
                
                stmt.execute();
                
                Msg = stmt.getString(11);
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
    public String ConvertSundry(SundryModel sundry) {
            try
            {
                //send a full table
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_ConvertSundry(?,?,?,?,?,?,?,?,?,?)}";    
                
                stmt = conn.prepareCall(sql);
                stmt.setString(1, sundry.getCmsclass());
                stmt.setString(2, sundry.getCmscode());
                stmt.setString(3, sundry.getSundryname());
                stmt.setString(4, sundry.getIssueUnit());
                stmt.setDouble(5, sundry.getPrice());
                stmt.setString(6, sundry.getDescription());
                stmt.setString(7, sundry.getSundrysource());
                stmt.setString(8, sundry.getSundryclass());
                stmt.setString(9, sundry.getStatus());
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

    @Override
    public List<SundryModel> SearchSundry() {
        List<SundryModel> sundrylist = new ArrayList();
            try
            {
                //send a full table
                
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_SearchSundryCMSCODES}";                    
                stmt = conn.prepareCall(sql);                
//                stmt.setString(1, item.getItemCode());
//                stmt.setString(2, item.getItemClass());
//                stmt.setString(3, item.getItemName());
//                stmt.setString(4, item.getIssueUnit());
//                stmt.setDouble(5, item.getPrice());
//                stmt.setString(6, item.getDescription());
//                stmt.setString(7, item.getDosageForm());
//                stmt.setString(8, item.getStrength());
//                stmt.setString(9, item.getDrugclass());
                
                stmt.execute();
                ResultSet rs = stmt.getResultSet();

                while(rs.next())
                {
                    SundryModel sundry = new SundryModel();

                    sundry.setCmsclass(rs.getString("CmsClass"));                
                    sundry.setCmscode(rs.getString("cmscode"));                
                    sundry.setSundryname(rs.getString("ItemName"));                
                    sundry.setIssueUnit(rs.getString("IssueUnit")); 
                    sundry.setPrice(rs.getDouble("price"));                
                    sundry.setDescription(rs.getString("Description"));                                   
                    sundry.setStatus(rs.getString("Status")); 
                    

                    sundrylist.add(sundry);
                } 
                
            }
            catch(Exception e)
            {

            }      
        
            return sundrylist;
    }

    @Override
    public String DeactivateSundry(SundryModel sundry) {
            
            try
            {
                //send a full table
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_DeactivateCmsSundry(?,?,?,?,?,?,?,?,?,?)}";    
                
                stmt = conn.prepareCall(sql);
                stmt.setString(1, sundry.getCmsclass());
                stmt.setString(2, sundry.getCmscode());
                stmt.setString(3, sundry.getSundryname());
                stmt.setString(4, sundry.getIssueUnit());
                stmt.setDouble(5, sundry.getPrice());
                stmt.setString(6, sundry.getDescription());
                stmt.setString(7, sundry.getSundrysource());
                stmt.setString(8, sundry.getSundryclass());
                stmt.setString(9, sundry.getStatus());
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

    @Override
    public String ActivateSundry(SundryModel sundry) {
            try
            {
                //send a full table
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_ActivateCmsSundry(?,?,?,?,?,?,?,?,?,?)}";    
                
                stmt = conn.prepareCall(sql);
                stmt.setString(1, sundry.getCmsclass());
                stmt.setString(2, sundry.getCmscode());
                stmt.setString(3, sundry.getSundryname());
                stmt.setString(4, sundry.getIssueUnit());
                stmt.setDouble(5, sundry.getPrice());
                stmt.setString(6, sundry.getDescription());
                stmt.setString(7, sundry.getSundrysource());
                stmt.setString(8, sundry.getSundryclass());
                stmt.setString(9, sundry.getStatus());
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

    @Override
    public String UpdateSundry(SundryModel sundry) {
            try
            {
                //send a full table
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_UpdateCmsSundry(?,?,?,?,?,?,?,?,?,?)}";    
                
                stmt = conn.prepareCall(sql);
                stmt.setString(1, sundry.getCmsclass());
                stmt.setString(2, sundry.getCmscode());
                stmt.setString(3, sundry.getSundryname());
                stmt.setString(4, sundry.getIssueUnit());
                stmt.setDouble(5, sundry.getPrice());
                stmt.setString(6, sundry.getDescription());
                stmt.setString(7, sundry.getSundrysource());
                stmt.setString(8, sundry.getSundryclass());
                stmt.setString(9, sundry.getStatus());
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

    @Override
    public String GetSundry(SundryModel sundry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public SundryModel GetSundryDetailsByCode(String sundrycmscode)
    {        
        SundryModel sundry = new SundryModel();
        
            try
            {
                
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_SearchSundryItemDetails(?)}";                    
                stmt = conn.prepareCall(sql);                
                stmt.setString(1, sundrycmscode);
                
                stmt.execute();
                ResultSet rs = stmt.getResultSet();

                while(rs.next())
                {
                    sundry.setCmsclass(rs.getString("CmsClass"));                
                    sundry.setCmscode(rs.getString("cmscode"));                
                    sundry.setSundryname(rs.getString("ItemName"));                
                    sundry.setIssueUnit(rs.getString("IssueUnit")); 
                    sundry.setPrice(rs.getDouble("price"));                
                    sundry.setDescription(rs.getString("Description"));                                   
                    sundry.setStatus(rs.getString("Status"));                
                } 
                
            }
            catch(Exception e)
            {

            }      
        
            return sundry;        
    }        
    
}
