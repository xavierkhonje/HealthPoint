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
public class SpecialAntimicrobialsModel implements Serializable{
    private String cmscode;
    private String indication;
    private String startdate;
    private String duration;
    private String planonAdmission;
    private boolean chartered;
    private String dose;
    private String admission;
    private String doseprocedure;
    
    public String cmscodeError;
    public String indicationError;
    public String startdateError;
    public String durationError;
    public String planonAdmissionError;
    public String charteredError;
    public String doseError;
    public String admissionError;
    public String doseprocedureError;

    public SpecialAntimicrobialsModel() {
    }

    public SpecialAntimicrobialsModel(String cmscode, String indication, String startdate, String duration, String planonAdmission, boolean chartered, String dose, String admission, String doseprocedure) {
        this.cmscode = cmscode;
        this.indication = indication;
        this.startdate = startdate;
        this.duration = duration;
        this.planonAdmission = planonAdmission;
        this.chartered = chartered;
        this.dose = dose;
        this.admission = admission;
        this.doseprocedure = doseprocedure;
    }

    public String getCmscode() {
        return cmscode;
    }

    public void setCmscode(String cmscode) {
        this.cmscode = cmscode;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPlanonAdmission() {
        return planonAdmission;
    }

    public void setPlanonAdmission(String planonAdmission) {
        this.planonAdmission = planonAdmission;
    }

    public boolean isChartered() {
        return chartered;
    }

    public void setChartered(boolean chartered) {
        this.chartered = chartered;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getDoseprocedure() {
        return doseprocedure;
    }

    public void setDoseprocedure(String doseprocedure) {
        this.doseprocedure = doseprocedure;
    }
    
    public boolean validateSpecialAntimicrobials()
    {
        
        return true;
    }
    
}
