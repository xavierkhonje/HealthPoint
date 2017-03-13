/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyDataAccess;

import com.afritrend.PharmacyInterfaces.IOPDPrescription;
import com.afritrend.PharmacyModel.OPDPrescriptionModel;
import com.afritrend.common.config;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public class OPDPrescriptionDataAccess implements IOPDPrescription{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;        
    
    @Override
    public String SavePrescription(OPDPrescriptionModel OPDPrescription, String img) {
            try
            {
                //send a full table
                ResultSet rs = null;
                conn = config.DBConnect(); 
                
                File file = new File(img);
                FileInputStream fis = new FileInputStream(file);
                int len = (int)file.length();                
                
                String sql = "{CALL spHP_OPDPrescriptionItem(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";    
                
                stmt = conn.prepareCall(sql);
                stmt.setString(1, OPDPrescription.getPatientNo());
                stmt.setString(2, OPDPrescription.getCmsCode());
                stmt.setString(3, OPDPrescription.getAdmissionCode());
                stmt.setInt(4, OPDPrescription.getFrequency());
                stmt.setString(5,file.getName());
                stmt.setInt(6, len);
                stmt.setBinaryStream(7, fis, len);
                stmt.setString(8, OPDPrescription.getDrugName());
                stmt.setString(9, OPDPrescription.getInstruction());
                stmt.setString(10, OPDPrescription.getMalangizo());
                stmt.setString(11, OPDPrescription.getPx());
                stmt.setString(12,OPDPrescription.getDosageForm());
                stmt.setString(13, OPDPrescription.getStrength());
                stmt.setInt(14, OPDPrescription.getQuantity());                
                
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
    public List<OPDPrescriptionModel> GetPatientPrescription(String PatientID, String PrescriptionNumber) {
        
        List<OPDPrescriptionModel> opdlist = new ArrayList();
            try
            {               
                //send a full table
                
                conn = config.DBConnect(); 
                String sql = "{CALL GETOPDPrescriptions(?,?)}";                    
                stmt = conn.prepareCall(sql);    
                stmt.setString(1, PatientID);
                stmt.setString(2, PrescriptionNumber);
                
                stmt.execute();
                ResultSet rs = stmt.getResultSet();
                while(rs.next())
                {
                    OPDPrescriptionModel item = new OPDPrescriptionModel();

//                    fileBytes = rs.getBytes(1);
                    item.setPatientNo(rs.getString("patientNo"));                
                    item.setFirstName(rs.getString("FirstName")); 
                    item.setMiddleName(rs.getString("OtherNames")); 
                    item.setLastName(rs.getString("LastName")); 
                    item.setCmsCode(rs.getString("Cmscode"));                
                    item.setDrugName(rs.getString("DrugName")); 
                    item.setDosageForm(rs.getString("DosageForm")); 
                    item.setPrescriptionid(rs.getInt("opdPrescriptionid")); 
                    item.setAdmissionCode(rs.getString("AdmissionCode"));                
                    item.setFrequency(rs.getInt("frequency")); 
                    item.setPrescrionbarcode(rs.getBytes("PrescriptionBarCode"));                     

                    opdlist.add(item);
                    
//                    OutputStream targetFile =  new FileOutputStream("C:\\EDMSFOLDER\\new.png");
//
//                    targetFile.write(item.getPrescrionbarcode());
//                    targetFile.close();                    
//                    targetFile.flush();
                } 
                
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }      
        
            return opdlist;               
    }

    @Override
    public String UpdatePrescription(OPDPrescriptionModel prescription) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String CancelPrescription(OPDPrescriptionModel prescription) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
