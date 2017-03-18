/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.Ward.Inpatient.Model;

import java.io.Serializable;

/**
 *
 * @author Xavier Khonje
 */
public class AdmittionModel implements Serializable
{
    private String bedNumber;
    private String wardName;
    private String admissionDate;
    private String planOnreleaseDate;
    
    public String bedNumberError;
    public String wardNameError;
    public String admissionDateError;
    public String planOnreleaseDateError;

    public AdmittionModel() {
    }

    public AdmittionModel(String bedNumber, String wardName, String admissionDate, String planOnreleaseDate) {
        this.bedNumber = bedNumber;
        this.wardName = wardName;
        this.admissionDate = admissionDate;
        this.planOnreleaseDate = planOnreleaseDate;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getPlanOnreleaseDate() {
        return planOnreleaseDate;
    }

    public void setPlanOnreleaseDate(String planOnreleaseDate) {
        this.planOnreleaseDate = planOnreleaseDate;
    }
    
    public boolean validateAdmission()
    {
        String Flag = "WHITE";
        
        if(this.bedNumber.equals("") || this.bedNumber == null)
        {
            Flag = "RED";
            this.bedNumberError = "Please Supply Bed Number";
        }
        
        if(this.wardName.equals("")||this.wardName == null)
        {
            Flag = "RED";
            this.wardNameError = "Please Provide Ward Name";            
        }
        
        if(this.admissionDate.equals("")||this.admissionDate == null)
        {
            Flag = "RED";
            this.admissionDateError = "Please Provide Date";
        }
        
        if(this.planOnreleaseDate.equals("")||this.planOnreleaseDate == null)
        {
            Flag = "RED";
            this.planOnreleaseDateError = "Please Provide Date";
        }
        
        if(Flag.equals("RED"))
        {
            return false;
        }
        
        return true;
    }
    
}
