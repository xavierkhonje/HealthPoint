/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardModel;

import java.io.Serializable;

/**
 *
 * @author Xavier Khonje
 */
public class DosageCodes implements Serializable{
    private String code;
    public String codeError;
    private String description;
    public String descriptionError;
    private int hourFrequency;
    private String hourFrequencyError;
    private int dayFrequency;
    public String dayFrequencyError;
    private int weekFrequency;
    public String weekFrequencyError;
    private int monthFrequency;
    public String monthFrequencyError;
    private int yearFrequency;
    public String yearFrequecyError;
    private String message;

    public DosageCodes() {
    }

    public DosageCodes(String code, String description, int hourFrequency, int dayFrequency, int weekFrequency, int monthFrequency, int yearFrequency) {
        this.code = code;
        this.description = description;
        this.hourFrequency = hourFrequency;
        this.dayFrequency = dayFrequency;
        this.weekFrequency = weekFrequency;
        this.monthFrequency = monthFrequency;
        this.yearFrequency = yearFrequency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHourFrequency() {
        return hourFrequency;
    }

    public void setHourFrequency(int hourFrequency) {
        this.hourFrequency = hourFrequency;
    }

    public int getDayFrequency() {
        return dayFrequency;
    }

    public void setDayFrequency(int dayFrequency) {
        this.dayFrequency = dayFrequency;
    }

    public int getWeekFrequency() {
        return weekFrequency;
    }

    public void setWeekFrequency(int weekFrequency) {
        this.weekFrequency = weekFrequency;
    }

    public int getMonthFrequency() {
        return monthFrequency;
    }

    public void setMonthFrequency(int monthFrequency) {
        this.monthFrequency = monthFrequency;
    }

    public int getYearFrequency() {
        return yearFrequency;
    }

    public void setYearFrequency(int yearFrequency) {
        this.yearFrequency = yearFrequency;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public boolean validateDosecode()
    {
        
        String Flag = "WHITE";
        
        if(this.code.equals("") || this.code == null)
        {
            this.codeError = "Empty Field";
            Flag = "RED";
        }
        
        if(this.description.equals("") || this.description == null)
        {
            this.descriptionError = "Empty Field";
            Flag = "RED";
        }
        
        if(
            this.hourFrequency == 0 && this.dayFrequency == 0 &&
            this.weekFrequency == 0 && this.monthFrequency == 0 &&
            this.yearFrequency == 0
        )
        {
            this.dayFrequencyError = "*";
            this.hourFrequencyError = "*";
            this.weekFrequencyError = "*";
            this.monthFrequencyError = "*";
            this.yearFrequecyError = "*";
        }
        
        if(Flag.equals("RED"))
        {
            this.setMessage("Fix Above Errors");
            return false;
        }
        return true;
    }
}
