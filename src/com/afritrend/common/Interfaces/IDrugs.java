/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.Interfaces;

import com.afritrend.common.Model.DrugsModel;

/**
 *
 * @author Xavier Khonje
 */
public interface IDrugs {
    String SaveDrugs(DrugsModel drug, String user, String Pharmact, int Quantity, String Transaction);
    DrugsModel GetDrugDetailsByCode(String drugcmscode);    
}
