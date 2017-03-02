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
public class SundryItemModel implements Serializable, Cloneable{
    private String sundryclass;
    public String sundryclassError;
    private String sundrycode;
    public String sundrycodeError;
    private String sundryname;
    public String sundrynameError;
    private String issueunit;
    public String issueUnitError;
    private String expiryDate;
    public String expiryDateError;
    private int quantity;
    public String quantityError;
    private String transactionType;
    public String transactionTypeError;
    private String sundrydescription;
    public String sundrydescriptionError;
    private String message;

    public SundryItemModel() {
    }

    public SundryItemModel(String sundryclass, String sundrycode, String sundryname, String issueunit, String expiryDate, int quantity, String transactionType, String sundrydescription) {
        this.sundryclass = sundryclass;
        this.sundrycode = sundrycode;
        this.sundryname = sundryname;
        this.issueunit = issueunit;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
        this.transactionType = transactionType;
        this.sundrydescription = sundrydescription;
    }

    public String getSundrydescription() {
        return sundrydescription;
    }

    public void setSundrydescription(String sundrydescription) {
        this.sundrydescription = sundrydescription;
    }        

    public String getSundryclass() {
        return sundryclass;
    }

    public void setSundryclass(String sundryclass) {
        this.sundryclass = sundryclass;
    }

    public String getSundrycode() {
        return sundrycode;
    }

    public void setSundrycode(String sundrycode) {
        this.sundrycode = sundrycode;
    }

    public String getSundryname() {
        return sundryname;
    }

    public void setSundryname(String sundryname) {
        this.sundryname = sundryname;
    }

    public String getIssueunit() {
        return issueunit;
    }

    public void setIssueunit(String issueunit) {
        this.issueunit = issueunit;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SundryItemModel{" + "sundryclass=" + sundryclass + ", sundrycode=" + sundrycode + ", sundryname=" + sundryname + ", issueunit=" + issueunit + ", expiryDate=" + expiryDate + ", quantity=" + quantity + ", transactionType=" + transactionType + ", sundrydescription=" + sundrydescription + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
        
    public boolean validateSundry()
    {
        String Flag = "WHITE";      
        
        if(this.quantity <= 0)
        {
            this.quantityError = "Quantity Must be greater than 0";
            Flag = "RED";            
        }
        
        if(this.sundrycode.equals("null") || this.sundrycode == null)
        {
            this.sundrycodeError = "Optional";
            Flag = "WHITE";
        }
        
        if(this.sundryclass.equals("null") || this.sundryclass == null)
        {
            this.sundryclassError = "Select Sundry Class";
            Flag = "RED";
        }                        
        
        if(this.sundryname.equals("null") || this.sundryname == null)
        {
            this.sundrynameError = "Select Sundry Name";
            Flag = "RED";
        }                   
        
        if(this.issueunit.equals("null") || this.issueunit == null)
        {
            this.issueUnitError = "Select Sundry Unit";
            Flag = "RED";
        }          
        
        if(this.expiryDate.equals("null") || this.expiryDate == null)
        {
            this.expiryDateError = "Select Expiry Date";
            Flag = "RED";
        }          
        
        if(this.transactionType.equals("null") || this.transactionType == null)
        {
            this.transactionTypeError = "Select Transaction Type";
            Flag = "RED";
        }          
        
        if(Flag.equals("RED"))
        {
            this.message = "Please correct Errors";
            return false;
        }
        return true;
    }
}
