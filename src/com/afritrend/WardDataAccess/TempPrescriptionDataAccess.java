/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardDataAccess;

import com.afritrend.PharmacyModel.OPDPrescriptionModel;
import com.afritrend.WardInterfaces.ITempPrescription;
import com.afritrend.common.config_sqlite;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public class TempPrescriptionDataAccess implements ITempPrescription{

    @Override
    public String SaveTempPrescription(OPDPrescriptionModel Prescription) {
        Connection c = null;
        Statement stmt = null;
        try 
        {
         config_sqlite config = new config_sqlite();
         c = config.ConnectSQLite();
         c.setAutoCommit(false);
          stmt = c.createStatement();
          String sql = "INSERT INTO WardTempOPDPrescription (patientNo,firstName,MiddleName,LastName,cmscode,DrugName,AdmissionCode,DosageForm,Instruction,Malangizo,ExpiryDate,Quantity,px,Frequency,PrescriptionBarcode,DateCreated,DateModified,CreatedBy) " +
                        "VALUES ('"+Prescription.getPatientNo()+"','"+Prescription.getFirstName()+"','"
                  +Prescription.getMiddleName()+"','"+Prescription.getLastName()+"','"+Prescription.getCmsCode()+"','"+Prescription.getDrugName()+"','"+Prescription.getAdmissionCode()+"','"
                  +Prescription.getDosageForm()+"','"+Prescription.getInstruction()+"','"+Prescription.getMalangizo()+"','"+Prescription.getExpirydate()+"','"+Prescription.getQuantity()+"','"
                  +Prescription.getPx()+"','"+Prescription.getFrequency()+"','"+Prescription.getPrescrionbarcode()+"','"+Prescription.getMiddleName()+"','"+Prescription.getMiddleName()+"','"+Prescription.getFirstName()+"');";           
          
          stmt.executeUpdate(sql);

          stmt.close();
          c.commit();
          c.close();
        } 
        catch ( Exception e ) 
        {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    
        return "Records created successfully";         
    }

    @Override
    public List<OPDPrescriptionModel> GetAllTempPrescription(String WardName) {
        Connection c = null;
        Statement stmt = null;
        List<OPDPrescriptionModel> prescriptionlist = new ArrayList();

        try 
        {
          config_sqlite config = new config_sqlite();
          c = config.ConnectSQLite();
          c.setAutoCommit(false);
          stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM WardTempOPDPrescription;" );
          while (rs.next() ) 
          {
            OPDPrescriptionModel prescriptions = new OPDPrescriptionModel();
                      
             prescriptions.setPatientNo(rs.getString("patientNo"));
             prescriptions.setFirstName(rs.getString("firstName"));
             prescriptions.setMiddleName(rs.getString("MiddleName"));
             prescriptions.setLastName(rs.getString("LastName"));
             prescriptions.setCmsCode(rs.getString("cmscode"));
             prescriptions.setDrugName(rs.getString("DrugName"));
             prescriptions.setAdmissionCode(rs.getString("AdmissionCode"));
             prescriptions.setDosageForm(rs.getString("DosageForm"));
             prescriptions.setInstruction(rs.getString("Instruction"));
             prescriptions.setMalangizo(rs.getString("Malangizo"));
             prescriptions.setExpirydate(rs.getString("ExpiryDate"));
             prescriptions.setStrength(rs.getString("patientNo"));
             prescriptions.setQuantity(rs.getInt("Quantity"));
             prescriptions.setPx(rs.getString("px"));
             prescriptions.setFrequency(rs.getInt("Frequency"));
             
             prescriptionlist.add(prescriptions);
          }
          rs.close();
          stmt.close();
          c.close();
        } 
        catch ( Exception e ) 
        {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }        
        
        return prescriptionlist;
    }

    @Override
    public String RemoveTempPrescriptions(String WardName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OPDPrescriptionModel> UpdateTempPrescription(String WardName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
