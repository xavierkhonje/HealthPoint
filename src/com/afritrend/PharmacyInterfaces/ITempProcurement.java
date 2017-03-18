/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyInterfaces;

import com.afritrend.PharmacyModel.ProcurementOrder;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public interface ITempProcurement {
    String SaveTempTTO(ProcurementOrder procurement);
    List<ProcurementOrder> GetAllTempTTO(String HospitalName);
    String RemoveTempTTO(String PatientName);
    List<ProcurementOrder> UpdateTempTTO(String HospitalName);      
}
