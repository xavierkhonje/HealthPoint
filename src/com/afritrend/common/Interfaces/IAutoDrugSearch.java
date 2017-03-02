/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.Interfaces;

import com.afritrend.common.Model.Items;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public interface IAutoDrugSearch {
    List<String> GetDrugClass();
    List<String> GetDosageForms();    
    List<Items> GetItemClass();    
    List<String> GetDrugNamesByDosageForm(String DosageForm);
    List<String> GetStrengthByDrugNames(String DrugName);
    List<String> GetItemCode(String ItemClass);
    List<String> GetItem_Class();
    List<String> GetDrug_Class();
    List<Items> GetItemName(String ItemCode);
    List<String> GetItemDescription();
}
