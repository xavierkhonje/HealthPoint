/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardInterfaces;

import com.afritrend.PharmacyModel.OPDPrescriptionModel;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public interface ITempPrescription {
    
    String SaveTempPrescription(OPDPrescriptionModel Prescription);
    List<OPDPrescriptionModel> GetAllTempPrescription(String WardName);
    String RemoveTempPrescriptions(String WardName);
    List<OPDPrescriptionModel> UpdateTempPrescription(String WardName);
}
