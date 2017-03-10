/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common;

import com.afritrend.common.Interfaces.IAutoDrugSearch;
import com.afritrend.common.Model.Items;
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
public class AutoDrugSearchDataAccess implements IAutoDrugSearch{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;         
    
    @Override
    public List<String> GetDosageForms() {
        List<String> dosagelist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETDosageForms}";    
            stmt = conn.prepareCall(sql);
            
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String Dose = "";
                Dose = rs.getString("code");                
                dosagelist.add(Dose);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return dosagelist;         
    }

    @Override
    public List<String> GetDrugNamesByDosageForm(String DosageForm) {
        List<String> druglist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GetDrugNamesByDosageForm(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, DosageForm);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String Drug = "";
                Drug = rs.getString("Drug");
                
                druglist.add(Drug);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return druglist;         
    }
    
    public List<String> GetIssueUnit(String DrugName,String Strength, String DosageForm) {
        List<String> IssueUnitlist =  new ArrayList();        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GetIssueUnit(?,?,?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, DrugName);
            stmt.setString(2, Strength);
            stmt.setString(3, DosageForm);
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
        
    public List<String> GetHPDrugNamesByDosageForm(String DosageForm) {
        List<String> druglist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETDrugsByDosageForms(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, DosageForm);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String Drug = "";
                Drug = rs.getString("DrugName");
                
                druglist.add(Drug);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return druglist;         
    }
    
    public String FindcmsCodebyDrugDetails(String Drugclass, String DosageForm, String DrugName,String Strength,String IssueUnit) {
        String cmscode =  "";
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETcmsCodesByDrugDetails(?,?,?,?,?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, Drugclass);
            stmt.setString(2, DosageForm);
            stmt.setString(3, DrugName);
            stmt.setString(4, Strength);
            stmt.setString(5, IssueUnit);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                cmscode = rs.getString("cmscode");
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return cmscode;         
    }
    
    public List<String> GetHPStrengthByDrugName(String DrugName) {
        List<String> strengthlist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETStrengthsByDrugNames(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, DrugName);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String Strength = "";
                Strength = rs.getString("Strength");
                
                strengthlist.add(Strength);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return strengthlist;         
    }

    @Override
    public List<String> GetStrengthByDrugNames(String DrugName) {
        List<String> strengthlist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GetStrengthByDrugNames(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, DrugName);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String Strength = "";
                Strength = rs.getString("Strength");
                
                strengthlist.add(Strength);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return strengthlist;        
    }

    @Override
    public List<String> GetDrugClass() {
        List<String> drugclasslist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETDrugClasses}";    
            stmt = conn.prepareCall(sql);            
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String DrugClass = "";
                DrugClass = rs.getString("ClassName");                
                drugclasslist.add(DrugClass);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return drugclasslist;         
    }

    @Override
    public List<Items> GetItemClass() {
        List<Items> Itemslist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL sp_HP_GETItemClass}";    
            stmt = conn.prepareCall(sql);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                Items item = new Items();
                item.setClassName(rs.getString("ClassName"));
                item.setDescription(rs.getString("ClassDescription"));
                Itemslist.add(item);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return Itemslist;         
    }
    
    @Override
    public List<String> GetItemCode(String ItemClass) {
        List<String> ItemsNamelist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL sp_HP_GETItemCode(?)}";    
            stmt = conn.prepareCall(sql);
            
            stmt.setString(1, ItemClass);
            stmt.execute();            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String ItemName = new String();
                ItemName = rs.getString("Code");
                ItemsNamelist.add(ItemName);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return ItemsNamelist;          
    }    
    
    public List<String> GetHPItemCode() {
        List<String> ItemsNamelist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETPharmacyDrugCodes}";    
            stmt = conn.prepareCall(sql);

            stmt.execute();            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String ItemName = new String();
                ItemName = rs.getString("Cmscode");
                ItemsNamelist.add(ItemName);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return ItemsNamelist;          
    }    
    
    @Override
    public List<Items> GetItemName(String ItemCode) {
        List<Items> ItemsNamelist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL sp_HP_GETItemName(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, ItemCode);
            stmt.execute();            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                Items Item = new Items();
                Item.setClassName(rs.getString("Code"));
                Item.setDescription(rs.getString("Description"));
                Item.setIssueUnit(rs.getString("UnitOfIssue"));
                
                ItemsNamelist.add(Item);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return ItemsNamelist;         
    }    
    
    @Override
    public List<String> GetItemDescription() {
        List<String> ItemsDescriptionlist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL sp_HP_GETItemDescription}";    
            stmt = conn.prepareCall(sql);
            stmt.execute();            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String ItemDescription = new String();
                ItemDescription = rs.getString("Description");
                ItemsDescriptionlist.add(ItemDescription);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return ItemsDescriptionlist;        
    }    

    @Override
    public List<String> GetItem_Class() {
        List<String> Itemslist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL sp_HP_GETItemClass}";    
            stmt = conn.prepareCall(sql);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String item = rs.getString("ClassDescription");
                Itemslist.add(item);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return Itemslist;           
    }

    @Override
    public List<String> GetDrug_Class() {
        List<String> Itemslist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL sp_HP_GETDrugClass}";    
            stmt = conn.prepareCall(sql);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String item = rs.getString("ClassName");
                Itemslist.add(item);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return Itemslist;          
    }
        
    public List<String> GetTransactionTypes() {
        List<String> Transactionlist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETTransactionTypes}";    
            stmt = conn.prepareCall(sql);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String Transaction = rs.getString("TransactionType");
                Transactionlist.add(Transaction);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return Transactionlist;          
    }
    
}
