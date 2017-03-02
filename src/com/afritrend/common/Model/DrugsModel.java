/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.Model;

import java.io.Serializable;

/**
 *
 * @author Xavier Khonje
 */
public class DrugsModel implements Serializable, Cloneable{
    private String drugcode;
    public String drugcodeerror;
    private String drugclass;
    public String drugclasserror;
    private String dosageform;
    public String dosageformerror;
    private String drugname;
    public String drugnameerror;
    private String strength;
    public String strengtherror;
    private String issueunit;
    public String issueuniterror;
    private String expirydate;
    public String expirydateerror;
    private String message;
    private int quantity;
    public String quantityerror;
    private String transactionType;
    public String transactionTypeerror;

    public DrugsModel() {
    }

    public DrugsModel(String drugcode, String drugclass, String dosageform, String drugname, String strength, String issueunit, String expirydate, int quantity, String transactionType) {
        this.drugcode = drugcode;
        this.drugclass = drugclass;
        this.dosageform = dosageform;
        this.drugname = drugname;
        this.strength = strength;
        this.issueunit = issueunit;
        this.expirydate = expirydate;
        this.quantity = quantity;
        this.transactionType = transactionType;
    }

    public String getMessage() {
        return message;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDrugcode() {
        return drugcode;
    }

    public void setDrugcode(String drugcode) {
        this.drugcode = drugcode;
    }

    public String getDrugclass() {
        return drugclass;
    }

    public void setDrugclass(String drugclass) {
        this.drugclass = drugclass;
    }

    public String getDosageform() {
        return dosageform;
    }

    public void setDosageform(String dosageform) {
        this.dosageform = dosageform;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getIssueunit() {
        return issueunit;
    }

    public void setIssueunit(String issueunit) {
        this.issueunit = issueunit;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }
    
    public boolean validateDrugs()
    {
        String Flag = "WHITE";      
        
        if(this.quantity <= 0)
        {
            this.quantityerror = "Quantity Must be greater than 0";
            Flag = "RED";            
        }
        
        if(this.drugcode.equals("null") || this.drugcode == null)
        {
            this.drugcodeerror = "Optional";
            Flag = "WHITE";
        }
        
        if(this.drugclass.equals("null") || this.drugclass == null)
        {
            this.drugclasserror = "Select Drug Class";
            Flag = "RED";
        }        
        
        if(this.dosageform.equals("null") || this.dosageform == null)
        {
            this.dosageformerror = "Select Doaage Form";
            Flag = "RED";
        }          
        
        if(this.drugname.equals("null") || this.drugname == null)
        {
            this.drugnameerror = "Select Drug Name";
            Flag = "RED";
        }          
        
        if(this.strength.equals("null") || this.strength == null)
        {
            this.strengtherror = "Select Drug Strength";
            Flag = "RED";
        }          
        
        if(this.issueunit.equals("null") || this.issueunit == null)
        {
            this.issueuniterror = "Select Drug Unit";
            Flag = "RED";
        }          
        
        if(this.expirydate.equals("null") || this.expirydate == null)
        {
            this.expirydateerror = "Select Expiry Date";
            Flag = "RED";
        }          
        
        if(this.transactionType.equals("null") || this.transactionType == null)
        {
            this.transactionTypeerror = "Select Transaction Type";
            Flag = "RED";
        }          
        
        if(Flag.equals("RED"))
        {
            this.message = "Please Fix Errors";
            return false;
        }
        return true;
    }
    
    
}
