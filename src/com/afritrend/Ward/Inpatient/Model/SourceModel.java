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
public class SourceModel implements Serializable{
    private String code;
    private String description;
    public String codeError;
    public String descriptionError;

    public SourceModel() {
    }

    public SourceModel(String code, String description) {
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
    
    public boolean validatesource()
    {
        
        
        return true;
    }
}
