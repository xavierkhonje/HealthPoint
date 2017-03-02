/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyInterfaces;

import com.afritrend.PharmacyModel.OPDPrescriptionModel;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public interface IOPDPrescription {
    
    String SavePrescription(OPDPrescriptionModel OPDPrescription, String img);
    List<OPDPrescriptionModel> GetPatientPrescription(String PatientID, String PrescriptionNumber);
    String UpdatePrescription(OPDPrescriptionModel prescription);
    String CancelPrescription(OPDPrescriptionModel prescription);
}
