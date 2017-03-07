/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardInterfaces;


import com.afritrend.WardModel.GuardianModel;
import com.afritrend.WardModel.patientModel;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public interface Ipatient {
    String PatientRegistration(patientModel patient, GuardianModel guardian);
    List<patientModel> GetPatients(String firstname, String Othernames, String Lastname, String PatientID);
}
