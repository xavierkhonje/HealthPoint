/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardInterfaces;


import com.afritrend.WardModel.DrugAdministrationModel;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public interface IDrugAdministration {
    String SaveDrugAdministration(DrugAdministrationModel drugAdministration);
    String ReverseDrugAdministration(DrugAdministrationModel drugAdministration);
    List<DrugAdministrationModel> GetDrugAdministration(String patientID);
}
