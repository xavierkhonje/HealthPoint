/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardDataAccess;

import com.afritrend.Ward.Inpatient.Model.ToTakeHomeModel;
import com.afritrend.WardInterfaces.ITempTTO;
import com.afritrend.common.config_sqlite;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public class TempTTODataAccess implements ITempTTO{

    Connection c = null;
    Statement stmt = null;    
    
    @Override
    public String SaveTempTTO(ToTakeHomeModel tto) {

        try 
        {
         config_sqlite config = new config_sqlite();
         c = config.ConnectSQLite();
         c.setAutoCommit(false);
          stmt = c.createStatement();
          String sql = "INSERT INTO ToTakeHomeTemp (DrugClass,DosageForm,DrugName,Quantity,Instruction,Malangizo,px,AdmissionCode,DosageProcedure,PatientNumber) " +
                        "VALUES ('"+tto.getDrugClass()+"','"+tto.getDosageForm()+"','"
                  +tto.getDrugName()+"','"+tto.getQuantity()+"','"+tto.getInstruction()+"','"+tto.getMalangizo()+"','"+tto.getPx()+"','"
                  +tto.getAdmissionCode()+"','"+tto.getDosageProcedure()+"','"+tto.getPatientNumber()+"');";           
          
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
    public List<ToTakeHomeModel> GetAllTempTTO(String PatientName) {
        List<ToTakeHomeModel> list = new ArrayList();
//
//        try 
//        {
//          config_sqlite config = new config_sqlite();
//          c = config.ConnectSQLite();
//          c.setAutoCommit(false);
//          stmt = c.createStatement();
//          ResultSet rs = stmt.executeQuery( "SELECT * FROM WardTempOPDPrescription;" );
//          while (rs.next() ) 
//          {
//            OPDPrescriptionModel prescriptions = new OPDPrescriptionModel();
//                      
//             prescriptions.setPatientNo(rs.getString("patientNo"));
//             prescriptions.setFirstName(rs.getString("firstName"));
//             prescriptions.setMiddleName(rs.getString("MiddleName"));
//             prescriptions.setLastName(rs.getString("LastName"));
//             prescriptions.setCmsCode(rs.getString("cmscode"));
//             prescriptions.setDrugName(rs.getString("DrugName"));
//             prescriptions.setAdmissionCode(rs.getString("AdmissionCode"));
//             prescriptions.setDosageForm(rs.getString("DosageForm"));
//             prescriptions.setInstruction(rs.getString("Instruction"));
//             prescriptions.setMalangizo(rs.getString("Malangizo"));
//             prescriptions.setExpirydate(rs.getString("ExpiryDate"));
//             prescriptions.setStrength(rs.getString("patientNo"));
//             prescriptions.setQuantity(rs.getInt("Quantity"));
//             prescriptions.setPx(rs.getString("px"));
//             prescriptions.setFrequency(rs.getInt("Frequency"));
//             
//             prescriptionlist.add(prescriptions);
//          }
//          rs.close();
//          stmt.close();
//          c.close();
//        } 
//        catch ( Exception e ) 
//        {
//          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//        }        
//        
        return list;        
    }

    @Override
    public String RemoveTempTTO(String PatientName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ToTakeHomeModel> UpdateTempTTO(String PatientName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
