/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.Ward.Inpatient.DataAccess;

import com.afritrend.Ward.Inpatient.Interface.IToTakeHome;
import com.afritrend.Ward.Inpatient.Model.ToTakeHomeModel;
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
public class ToTakeHomeDataAccess implements IToTakeHome {
    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;     

    @Override
    public String SavePatientTTO(ToTakeHomeModel TTO) {
        try
        {
            //send a full table
            ResultSet rs = null;
            conn = config.DBConnect(); 
            String sql = "{CALL spHP_SaveTTO(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";    

            stmt = conn.prepareCall(sql);
            stmt.setString(1, TTO.getDrugClass());
            stmt.setString(2, TTO.getDosageForm());
            stmt.setString(3, TTO.getDrugName());
            stmt.setInt(4, TTO.getQuantity());
            stmt.setString(5, TTO.getInstruction());
            stmt.setString(6, TTO.getMalangizo());
            stmt.setString(7, TTO.getPx());
            stmt.setInt(8, TTO.getMidnightAmount());
            stmt.setInt(9, TTO.getMorningAmount());
            stmt.setInt(10, TTO.getNoonAmount());
            stmt.setInt(11, TTO.getEveningAmount());
            stmt.setString(12, TTO.getAdmissionCode());
            stmt.setString(13, TTO.getDosageProcedure());
            stmt.setString(14, TTO.getPatientNumber());

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
    public List<ToTakeHomeModel> GetPatientTTO(String PatientNumber) 
    {
        List<ToTakeHomeModel> list = new ArrayList();
        
        
        return list;
    }        

    
}
