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
public class AntimicrobialModel {
    private String code;
    private String description;
    public String codeError;
    public String descriptionError;

    public AntimicrobialModel() {
    }

    public AntimicrobialModel(String code, String description) {
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
    
    public boolean ValidateAntimicrobial()
    {
        String Flag = "WHITE";
        
        if(this.code.equals("") || this.code == null)
        {
            Flag = "RED";
            this.codeError = "Please Supply code";
        }
        
        if(this.description.equals("") || this.description == null)
        {
            Flag = "RED";
            this.descriptionError = "Please Supply Description";
        }
        
        if(Flag.equals("RED"))
        {
            return false;
        }
        
        return true;
    }
    
    
}
