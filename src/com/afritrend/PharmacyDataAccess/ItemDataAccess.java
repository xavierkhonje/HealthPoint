/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyDataAccess;

import com.afritrend.PharmacyInterfaces.Iitem;
import com.afritrend.PharmacyModel.ItemModel;
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
                String sql = "{CALL spHP_SaveItem(?,?,?,?,?,?,?,?,?,?,?,?)}";    
                
                stmt = conn.prepareCall(sql);
                stmt.setString(1, item.getItemCode());
                stmt.setString(2, item.getItemClass());
                stmt.setString(3, item.getItemName());
                stmt.setString(4, item.getIssueUnit());
                stmt.setDouble(5, item.getPrice());
                stmt.setString(6, item.getDescription());
                stmt.setString(7, item.getDosageForm());
                stmt.setString(8, item.getStrength());
                stmt.setInt(9, 30);
                stmt.setString(10, item.getDrugclass());
                stmt.setString(11, "");
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
    public String ConvertDrug(ItemModel item) {
            try
            {
                //send a full table
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_ConvertDrug(?,?,?,?,?,?,?,?,?)}";    
                
                stmt = conn.prepareCall(sql);
                stmt.setString(1, item.getItemCode());
                stmt.setString(2, item.getItemClass());
                stmt.setString(3, item.getItemName());
                stmt.setString(4, item.getIssueUnit());
                stmt.setDouble(5, item.getPrice());
                stmt.setString(6, item.getDescription());
                stmt.setString(7, item.getDosageForm());
                stmt.setString(8, item.getStrength());
                stmt.setString(9, item.getDrugclass());
                
                stmt.execute();
            }
            catch(Exception e)
            {
                return e.getMessage();
            }
            finally
            {
                return "Item Converted";
            }        
    }

    @Override
    public String ConvertSundry(ItemModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<ItemModel> SearchDrugs()
    {
        List<ItemModel> druglist = new ArrayList();
            try
            {
                //send a full table
                
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_SearchCMSCODES}";                    
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
                    ItemModel item = new ItemModel();

                    item.setItemClass(rs.getString("CmsClass"));                
                    item.setItemCode(rs.getString("Cmscode"));                
                    item.setItemName(rs.getString("DrugName"));                
                    item.setIssueUnit(rs.getString("IssueUnit")); 
                    item.setPrice(rs.getDouble("price"));                
                    item.setDescription(rs.getString("description"));                
                    item.setDosageForm(rs.getString("DosageForm"));                
                    item.setStrength(rs.getString("Strength"));                     
                    item.setDrugclass(rs.getString("ClassName")); 
                    item.setStatus(rs.getString("Status"));                    

                    druglist.add(item);
                } 
                
            }
            catch(Exception e)
            {

            }      
        
            return druglist;
    }
    
    @Override
    public String DeactivateItem(ItemModel item)
    {
            String Msg = "";
            try
            {
                //send a full table
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_DeactivateCmsItem(?,?,?,?,?,?,?,?,?,?)}";    
                
                stmt = conn.prepareCall(sql);
                stmt.setString(1, item.getItemCode());
                stmt.setString(2, item.getItemClass());
                stmt.setString(3, item.getItemName());
                stmt.setString(4, item.getIssueUnit());
                stmt.setDouble(5, item.getPrice());
                stmt.setString(6, item.getDescription());
                stmt.setString(7, item.getDosageForm());
                stmt.setString(8, item.getStrength());
                stmt.setString(9, item.getDrugclass());
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
    public String ActivateItem(ItemModel item)
    {
            String Msg = "";
            try
            {
                //send a full table
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_ActivateCmsItem(?,?,?,?,?,?,?,?,?,?)}";    
                
                stmt = conn.prepareCall(sql);
                stmt.setString(1, item.getItemCode());
                stmt.setString(2, item.getItemClass());
                stmt.setString(3, item.getItemName());
                stmt.setString(4, item.getIssueUnit());
                stmt.setDouble(5, item.getPrice());
                stmt.setString(6, item.getDescription());
                stmt.setString(7, item.getDosageForm());
                stmt.setString(8, item.getStrength());
                stmt.setString(9, item.getDrugclass());
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
    public String UpdateItem(ItemModel item)
    {
            String Msg = "";
            try
            {
                //send a full table
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_UpdateCmsItem(?,?,?,?,?,?,?,?,?,?)}";    
                
                stmt = conn.prepareCall(sql);
                stmt.setString(1, item.getItemCode());
                stmt.setString(2, item.getItemClass());
                stmt.setString(3, item.getItemName());
                stmt.setString(4, item.getIssueUnit());
                stmt.setDouble(5, item.getPrice());
                stmt.setString(6, item.getDescription());
                stmt.setString(7, item.getDosageForm());
                stmt.setString(8, item.getStrength());
                stmt.setString(9, item.getDrugclass());
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
    public String GetItem(ItemModel item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
