/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.Ward.Inpatient.Interface;

import com.afritrend.Ward.Inpatient.Model.ToTakeHomeModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public interface IToTakeHome {
    
    String SavePatientTTO(ToTakeHomeModel TTO);
    List<ToTakeHomeModel> GetPatientTTO(String PatientNumber);
}
