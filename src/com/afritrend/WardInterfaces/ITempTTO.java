/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardInterfaces;

import com.afritrend.Ward.Inpatient.Model.ToTakeHomeModel;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public interface ITempTTO 
{
    String SaveTempTTO(ToTakeHomeModel tto);
    List<ToTakeHomeModel> GetAllTempTTO(String PatientName);
    String RemoveTempTTO(String PatientName);
    List<ToTakeHomeModel> UpdateTempTTO(String PatientName);    
}
