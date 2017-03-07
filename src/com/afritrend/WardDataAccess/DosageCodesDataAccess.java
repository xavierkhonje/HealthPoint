/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardDataAccess;


import com.afritrend.WardInterfaces.IDosageCodes;
import com.afritrend.WardModel.DosageCodes;
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
public class DosageCodesDataAccess implements IDosageCodes {


    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;     
    
    @Override
    public String SaveDosageCodes(DosageCodes dosecodes) {
        String msg = "";
        try
        {
            conn = config.DBConnect();            
            String sql = "{CALL sp_HP_SaveDoseCode(?,?,?,?,?,?,?,?)}";    
            stmt = conn.prepareCall(sql);          
            
            stmt.setString(1, dosecodes.getCode());
            stmt.setString(2, dosecodes.getDescription());
            stmt.setInt(3, dosecodes.getHourFrequency());
            stmt.setInt(4, dosecodes.getDayFrequency());
            stmt.setInt(5, dosecodes.getWeekFrequency());
            stmt.setInt(6, dosecodes.getMonthFrequency());
            stmt.setInt(7, dosecodes.getYearFrequency());
            stmt.registerOutParameter(8, java.sql.Types.NVARCHAR);
            
            stmt.execute();
            
            msg = stmt.getString(8);                   
        }
        catch(Exception e)
        {
            return e.getMessage();
        }        
        finally
        {
            
        }        
        
        return msg;          
    }

    @Override
    public List<DosageCodes> GetAllDoseCodes() {
        DosageCodes dosage = new DosageCodes();
        List<DosageCodes> dosagelist = new ArrayList();
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL GetAllDosageCodes}";    
            stmt = conn.prepareCall(sql);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                dosage.setCode(rs.getString("code"));
                dosage.setDescription(rs.getString("Description"));
                dosage.setHourFrequency(rs.getInt("HourFrequency"));
                dosage.setDayFrequency(rs.getInt("DayFrequency"));  
                dosage.setWeekFrequency(rs.getInt("WeekFrequency"));
                dosage.setMonthFrequency(rs.getInt("MonthFrequency"));
                dosage.setYearFrequency(rs.getInt("YearFrequency"));                
                
                dosagelist.add(dosage);                        
            }                        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }        
        finally
        {
            
        }        
        
        return dosagelist;         
    }

    @Override
    public List<String> GetCodes() {
        List<String> doselist = new ArrayList();
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GetCodes}";    
            stmt = conn.prepareCall(sql);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String code = rs.getString("code");
                doselist.add(code);                        
            }                        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }        
        finally
        {
            
        }        
        
        return doselist;         
    }
    
}
