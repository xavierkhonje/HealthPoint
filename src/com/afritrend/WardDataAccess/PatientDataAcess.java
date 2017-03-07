/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardDataAccess;


import com.afritrend.WardInterfaces.Ipatient;
import com.afritrend.WardModel.GuardianModel;
import com.afritrend.WardModel.patientModel;
import com.afritrend.common.config;
import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public class PatientDataAcess implements Ipatient{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;      
    
    @Override
    public String PatientRegistration(patientModel patient, GuardianModel guardian) {
        String msg = "";
        try
        {
            conn = config.DBConnect();            
            String sql = "{CALL spHP_SavePatientDetails(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";    
            stmt = conn.prepareCall(sql);
            
            //preparing the image
//            File file = new File(patient.getImage());
//            FileInputStream fis = new FileInputStream(file);
//            int len = (int)file.length();            
            
            stmt.setString(1, "");
            stmt.setString(2, patient.getFirstname());
            stmt.setString(3, patient.getOthernames());
            stmt.setString(4, patient.getLastname());
            stmt.setString(5, patient.getTelNumber());
            stmt.setString(6, patient.getCelNumber());
            stmt.setString(7, patient.getAddress1());
            stmt.setString(8, patient.getAddress2());
//            stmt.setBinaryStream(9, fis);
            stmt.setString(9, "");
            stmt.setString(10, patient.getHospitalName());
            stmt.setString(11, patient.getWardName());
            stmt.setString(12, patient.getWardDptName());
            stmt.setString(13, guardian.getFirstname());
            stmt.setString(14, guardian.getOthernames());
            stmt.setString(15, guardian.getLastname());
            stmt.setString(16, guardian.getRelationshiptype());
            stmt.registerOutParameter(17, java.sql.Types.NVARCHAR);
            
            stmt.execute();
            
            msg = stmt.getString(17);                   
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
    public List<patientModel> GetPatients(String firstname, String Othernames, String Lastname, String PatientID) 
    {        
        List<patientModel> patientlist = new ArrayList();
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_SearchPatient(?,?,?,?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, firstname);
            stmt.setString(2, Othernames);
            stmt.setString(3, Lastname);
            stmt.setString(4, PatientID);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                patientModel patient = new patientModel();
                
                patient.setPatientID(rs.getString("patientID"));
                patient.setFirstname(rs.getString("Firstname"));
                patient.setOthernames(rs.getString("OtherNames"));
                patient.setLastname(rs.getString("LastName"));  
                patient.setTelNumber(rs.getString("Firstname"));
                patient.setCelNumber(rs.getString("Firstname"));
                patient.setAddress1(rs.getString("Firstname"));
                patient.setAddress2(rs.getString("Firstname"));
                patient.setImage(rs.getString("Firstname"));
                patient.setHospitalName(rs.getString("Firstname"));
                patient.setWardName(rs.getString("Firstname"));
                patient.setWardDptName(rs.getString("Firstname"));
                
                
                patientlist.add(patient);                        
            }                        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }        
        finally
        {
            
        }        
        
        return patientlist;        
    }
}
