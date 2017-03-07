/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardDataAccess;


import com.afritrend.WardInterfaces.IDrugAdministration;
import com.afritrend.WardModel.DrugAdministrationModel;
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
public class DrugAdministrationDataAccess implements IDrugAdministration{


    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;         
    
    @Override
    public String SaveDrugAdministration(DrugAdministrationModel drugAdministration) {
        String msg = "";
        try
        {
            conn = config.DBConnect();            
            String sql = "{CALL spHP_UpdateDrugAdministration(?,?,?,?,?,?)}";    
            stmt = conn.prepareCall(sql);            
            
            stmt.setString(1, drugAdministration.getAdministrationDate().toString());
            stmt.setString(2, drugAdministration.getAdministrationTime().toString());
            stmt.setString(3, drugAdministration.getIsdrugAdministered());
            stmt.setInt(4, drugAdministration.getPrescriptionid());
            stmt.setInt(5, drugAdministration.getAdministrationid());

            stmt.registerOutParameter(6, java.sql.Types.NVARCHAR);            
            stmt.execute();
            
            msg = stmt.getString(6);                   
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
    public List<DrugAdministrationModel> GetDrugAdministration(String patientID) {
        
        List<DrugAdministrationModel> Administrationlist = new ArrayList();
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GetDrugAdministration(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, patientID);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                DrugAdministrationModel administration = new DrugAdministrationModel();
                
                administration.setAdministrationid(rs.getInt("iddrugadministration"));
                administration.setPrescriptionid(rs.getInt("FK_iddrugprescription"));
                administration.setIsdrugAdministered(rs.getString("isdrugadministered"));
                administration.setDrugName(rs.getString("DrugName"));
                administration.setStrength(rs.getString("Strength"));
                administration.setDosageForm(rs.getString("DosageForm"));
                administration.setAdministrationDate(rs.getDate("administrationdate").toLocalDate());  
                administration.setAdministrationTime(rs.getDate("administrationtime").toLocalDate());                
                
                Administrationlist.add(administration);                        
            }                        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }        
        finally
        {
            
        }        
        
        return Administrationlist;        
    }

    @Override
    public String ReverseDrugAdministration(DrugAdministrationModel drugAdministration) {
        String msg = "";
        try
        {
            conn = config.DBConnect();            
            String sql = "{CALL spHP_ReverseDrugAdministration(?,?,?,?,?,?)}";    
            stmt = conn.prepareCall(sql);            
            
            stmt.setString(1, drugAdministration.getAdministrationDate().toString());
            stmt.setString(2, drugAdministration.getAdministrationTime().toString());
            stmt.setString(3, drugAdministration.getIsdrugAdministered());
            stmt.setInt(4, drugAdministration.getPrescriptionid());
            stmt.setInt(5, drugAdministration.getAdministrationid());

            stmt.registerOutParameter(6, java.sql.Types.NVARCHAR);            
            stmt.execute();
            
            msg = stmt.getString(6);                   
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
    
}
