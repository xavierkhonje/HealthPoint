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
public class DiagnosisModel {
    private String code;
    private String description;
    
    public String codeError;
    public String descriptionError;

    public DiagnosisModel() {
    }
    
    public DiagnosisModel(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeError() {
        return codeError;
    }

    public void setCodeError(String codeError) {
        this.codeError = codeError;
    }
    
    public boolean validateDiagnosis()
    {
        String Flag = "WHITE";
        
        if(this.code.equals("") || this.code == null)
        {
            Flag = "RED";
            this.codeError = "Please Provide Code";
        }
        
        return true;
    }
    
}
