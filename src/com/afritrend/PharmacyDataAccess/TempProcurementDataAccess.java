/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyDataAccess;

import com.afritrend.PharmacyInterfaces.ITempProcurement;
import com.afritrend.PharmacyModel.ProcurementOrder;
import com.afritrend.common.config_sqlite;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public class TempProcurementDataAccess implements ITempProcurement {
    Connection c = null;
    Statement stmt = null;
    
    @Override
    public String SaveTempTTO(ProcurementOrder procurement) {

        try 
        {
         config_sqlite config = new config_sqlite();
         c = config.ConnectSQLite();
         c.setAutoCommit(false);
          stmt = c.createStatement();
          String sql = "INSERT INTO TempProcurement (ItemClass,CmsCode,Description,Quantity,ScaleUnit) " +
                        "VALUES ('"+procurement.getItemclass()+"','"+procurement.getItemcode()+"','"
                  +procurement.getDescription()+"','"+procurement.getQuantity()+"','"+procurement.getScaleUnit()+"');";           
          
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
    public List<ProcurementOrder> GetAllTempTTO(String HospitalName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String RemoveTempTTO(String PatientName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProcurementOrder> UpdateTempTTO(String HospitalName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
