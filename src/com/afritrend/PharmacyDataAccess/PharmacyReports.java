/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyDataAccess;

import com.afritrend.Pharmacy.Reports.PharmacySundryStockCard;
import com.afritrend.PharmacyModel.PharmacyStockCardModel;
import com.afritrend.PharmacyModel.costSummaryModel;
import com.afritrend.PharmacyModel.stockitemLevelModel;
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
public class PharmacyReports {
    
    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;     
    public List<PharmacyStockCardModel> GetStockcardReport()
    {
        List<PharmacyStockCardModel> stockrdpharmacyreport = new ArrayList();   
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETStockcardReport}";    
            stmt = conn.prepareCall(sql);
            
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                PharmacyStockCardModel pharmstockcard = new PharmacyStockCardModel();
                
                pharmstockcard.setDrugName(rs.getString("drugName"));                
                pharmstockcard.setCmscode(rs.getString("cmscode"));                
                pharmstockcard.setStrength(rs.getString("Strength"));                
                pharmstockcard.setDosageForm(rs.getString("DosageForm")); 
                pharmstockcard.setIssueUnit(rs.getString("IssueUnit"));                
                pharmstockcard.setReceivedAmount(rs.getInt("ReceivedAmount"));                
                pharmstockcard.setIssuedAmount(rs.getInt("IssuedAmount"));                
                pharmstockcard.setLostAmount(rs.getInt("LostAmount")); 
                pharmstockcard.setExpiredAmount(rs.getInt("ExpiredAmount"));                
                pharmstockcard.setAdjustedPlusAmount(rs.getInt("AdjustedPlusAmount"));                
                pharmstockcard.setAdjustedMinusAmount(rs.getInt("AdjustedMinusAmount"));                
                
                stockrdpharmacyreport.add(pharmstockcard);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
              
        return stockrdpharmacyreport;
    }
    
    public List<stockitemLevelModel> GetStockLevelsReport(String ReportType)
    {
        List<stockitemLevelModel> stockLevelspharmacyreport = new ArrayList();   
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL LowLevelStockCheck(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, ReportType);
            
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                stockitemLevelModel pharmstocklevel = new stockitemLevelModel();
                
                pharmstocklevel.setItemCode(rs.getString("ItemCode"));                
                pharmstocklevel.setItemName(rs.getString("ItemName"));                
                pharmstocklevel.setStrength(rs.getString("Strength"));                
                pharmstocklevel.setAmount(rs.getInt("Amount")); 
                pharmstocklevel.setEwp(rs.getInt("EWP"));                
                pharmstocklevel.setMinlevel(rs.getInt("MinimumLevel"));                
                pharmstocklevel.setMaxlevel(rs.getInt("MaximumLevel"));                 
                
                stockLevelspharmacyreport.add(pharmstocklevel);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
              
        return stockLevelspharmacyreport;
    }    
    
    public List<costSummaryModel> GetStockLevelsSupplierReport(String ReportType)
    {
        List<costSummaryModel> costSummaryspharmacyreport = new ArrayList();   
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL InventoryBySupplier(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, ReportType);
            
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                costSummaryModel pharmsummarycost = new costSummaryModel();
                
                pharmsummarycost.setItemQuantity(rs.getInt("Quantity"));                
                pharmsummarycost.setItemPrice(rs.getInt("CostValue"));                
                pharmsummarycost.setItemLineTotal(rs.getInt("LineTotal"));                
                pharmsummarycost.setTotalValue(rs.getInt("TotalValue")); 
                pharmsummarycost.setDescription(rs.getString("Description"));                
                pharmsummarycost.setItemSupplier(rs.getString("Supplier"));                                
                
                costSummaryspharmacyreport.add(pharmsummarycost);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
              
        return costSummaryspharmacyreport;
    }    
    
    public List<PharmacyStockCardModel> GetPharmacyDrugsStockcardReport(
    String DrugClass, String DrugName, String StartDate, String StopDate
    )
    {
        List<PharmacyStockCardModel> stockrdpharmacyreport = new ArrayList();   
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_PharmacyDrugsStockcardReport(?,?,?,?)}";
            
            stmt = conn.prepareCall(sql);
            
            stmt.setString(1, DrugClass);
            stmt.setString(2, DrugName);
            stmt.setString(3, StartDate);
            stmt.setString(4, StopDate);
                        
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                PharmacyStockCardModel pharmstockcard = new PharmacyStockCardModel();
                
                pharmstockcard.setDrugName(rs.getString("drugName"));                
                pharmstockcard.setCmscode(rs.getString("cmscode"));                
                pharmstockcard.setStrength(rs.getString("Strength"));                
                pharmstockcard.setDosageForm(rs.getString("DosageForm")); 
                pharmstockcard.setIssueUnit(rs.getString("IssueUnit"));                
                pharmstockcard.setReceivedAmount(rs.getInt("ReceivedAmount"));                
                pharmstockcard.setIssuedAmount(rs.getInt("IssuedAmount"));                
                pharmstockcard.setLostAmount(rs.getInt("LostAmount")); 
                pharmstockcard.setExpiredAmount(rs.getInt("ExpiredAmount"));                
                pharmstockcard.setAdjustedPlusAmount(rs.getInt("AdjustedPlusAmount"));                
                pharmstockcard.setAdjustedMinusAmount(rs.getInt("AdjustedMinusAmount"));                
                
                stockrdpharmacyreport.add(pharmstockcard);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
              
        return stockrdpharmacyreport;
    }
    
    public List<PharmacySundryStockCard> GetPharmacySundryStockcardReport(
    String DrugClass, String DrugName, String StartDate, String StopDate
    )
    {
        List<PharmacySundryStockCard> stockrdpharmacyreport = new ArrayList();   
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_PharmacySundryStockcardReport(?,?,?,?)}";
            
            stmt = conn.prepareCall(sql);
            
            stmt.setString(1, DrugClass);
            stmt.setString(2, DrugName);
            stmt.setString(3, StartDate);
            stmt.setString(4, StopDate);
                        
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                PharmacySundryStockCard pharmstockcard = new PharmacySundryStockCard();
                
                pharmstockcard.setSundryName(rs.getString("SundryName"));                
                pharmstockcard.setCmsCode(rs.getString("cmscode"));                
                pharmstockcard.setIssueUnit(rs.getString("IssueUnit"));                
                pharmstockcard.setReceivedAmount(rs.getInt("ReceivedAmount"));                
                pharmstockcard.setIssueAmount(rs.getInt("IssuedAmount"));                
                pharmstockcard.setLostAmount(rs.getInt("LostAmount")); 
                pharmstockcard.setExpiredAmount(rs.getInt("ExpiredAmount"));                
                pharmstockcard.setAdjustedPlusAmount(rs.getInt("AdjustedPlusAmount"));                
                pharmstockcard.setAdjustedMinusAmount(rs.getInt("AdjustedMinusAmount"));                
                
                stockrdpharmacyreport.add(pharmstockcard);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
              
        return stockrdpharmacyreport;
    }    
}
