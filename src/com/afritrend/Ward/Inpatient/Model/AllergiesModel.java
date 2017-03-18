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
public class AllergiesModel {
    private String code;
    private String description; 
    public String codeError;
    public String descriptionError;

    public AllergiesModel() {
    }

    public AllergiesModel(String code, String description) {
        this.code = code;
        this.description = description;
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
    
    public boolean ValidateAllergies()
    {
        String Flag = "WHITE";
        
        if(this.code.equals("") || this.code == null)
        {
            Flag = "RED";
            this.codeError = "Supply Code";
        }
        
        if(this.description.equals("") || this.description == null)
        {
            Flag = "RED";
            this.descriptionError = "Supply Description";
        }
        
        
        if(Flag == "RED")
        {
            return false;
        }
        return true;
    }
}
