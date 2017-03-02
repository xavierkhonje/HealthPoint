/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.Interfaces;

import com.afritrend.common.Model.DrugConfiguration;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public interface IDrugSettings {
    String SaveDrugSettings(DrugConfiguration conf);
    List<DrugConfiguration> GetDrugConfigurations();
}
