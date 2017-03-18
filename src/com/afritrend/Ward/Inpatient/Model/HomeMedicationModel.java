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
public class HomeMedicationModel {
    private String indication;
    private String startDate;
    private String duration;
    private String cmscode;
    private String planOnSubmission;
    private String chattered;
    private int frequency;
    private String dose;
    private String route;
    
    public String indicationError;
    public String startdateError;
    public String durationError;
    public String cmscodeError;
    public String planOnSubmissionError;
    public String chatteredError;
    public String frequencyError;
    public String doseError;
    public String routeError;

    public HomeMedicationModel() {
    }

    public HomeMedicationModel(String indication, String startDate, String duration, String cmscode, String planOnSubmission, String chattered, int frequency, String dose, String route) {
        this.indication = indication;
        this.startDate = startDate;
        this.duration = duration;
        this.cmscode = cmscode;
        this.planOnSubmission = planOnSubmission;
        this.chattered = chattered;
        this.frequency = frequency;
        this.dose = dose;
        this.route = route;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCmscode() {
        return cmscode;
    }

    public void setCmscode(String cmscode) {
        this.cmscode = cmscode;
    }

    public String getPlanOnSubmission() {
        return planOnSubmission;
    }

    public void setPlanOnSubmission(String planOnSubmission) {
        this.planOnSubmission = planOnSubmission;
    }

    public String getChattered() {
        return chattered;
    }

    public void setChattered(String chattered) {
        this.chattered = chattered;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
    
    public boolean validateHomeMedication()
    {
        String Flag = "WHITE";
        
        if(this.indication.equals("") || this.indication == null)
        {
            Flag = "RED";
            this.indicationError = "Please Supply Indication";
        }
        
        if(this.startDate.equals("") || this.startDate == null)
        {
            Flag = "RED";
            this.startdateError = "Please Supply Date";
        }
        
        if(this.duration.equals("") || this.duration == null)
        {
            Flag = "RED";
            this.durationError = "Please Supply Duration";
        }
        
        if(this.cmscode.equals("") || this.cmscode == null)
        {
            Flag = "RED";
            this.cmscodeError = "Please Supply cmscode";
        }
        
        if(this.planOnSubmission.equals("") || this.planOnSubmission == null)
        {
            Flag = "RED";
            this.planOnSubmissionError = "Please Supply Plan on Submission";
        }
        
        if(this.chattered.equals("")||this.chattered == null)
        {
            Flag = "RED";
            this.chatteredError = "Please specify";
        }
        
        if(this.frequency == 0)
        {
            Flag = "RED";
            this.frequencyError = "Please Supply Frequency";
        }
        
        if(this.dose.equals("")||this.dose == null)
        {
            Flag = "RED";
            this.doseError = "Please Supply Dosage";
        }
        
        if(this.route.equals("") || this.route == null)
        {
            Flag = "RED";
            this.routeError = "Please Supply Route";
        }
        
        if(Flag.equals("RED"))
        {
            return false;
        }
        return true;
    }
}
