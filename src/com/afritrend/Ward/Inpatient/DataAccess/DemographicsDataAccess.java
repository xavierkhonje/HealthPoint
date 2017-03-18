/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.Ward.Inpatient.DataAccess;

import com.afritrend.Ward.Inpatient.Interface.IDemographics;
import com.afritrend.Ward.Inpatient.Model.DemographicsModel;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public class DemographicsDataAccess implements IDemographics{

    @Override
    public String SavePatientDemographics(DemographicsModel demographics) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DemographicsModel> GetPatientDemographics(String PatientNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
