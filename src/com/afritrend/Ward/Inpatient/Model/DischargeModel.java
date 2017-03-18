/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.Ward.Inpatient.Model;

/**
 *
 * @author Xavier Khonje
 */
public class DischargeModel {
    private String bedNumber;
    private String wardName;
    private String admissionDate;
    private String releaseDate; 
    
    public String benumberError;
    public String wardnumberError;
    public String admissionDateError;
    public String releaseDateError;

    public DischargeModel() {
    }

    public DischargeModel(String bedNumber, String wardName, String admissionDate, String releaseDate) {
        this.bedNumber = bedNumber;
        this.wardName = wardName;
        this.admissionDate = admissionDate;
        this.releaseDate = releaseDate;
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public boolean validateDischarge()
    {
        
        return true;
    }
}
