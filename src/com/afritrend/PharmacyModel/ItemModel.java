/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyModel;

import java.io.Serializable;

/**
 *
 * @author Xavier Khonje
 */
public class ItemModel implements Serializable, Cloneable{
    private String itemCode;
    public String itemcodeError;
    
    private String itemClass;
    public String itemClassError;
    
    private String itemName;
    public String itemNameError;
    
    private String issueUnit;
    public String issueUnitError;
    
    private double price;
    public String priceError;
    
    private String description;
    public String descriptionError;
    
    private String dosageForm;
    public String dosageFormError;
    
    private String strength;
    public String strengthError;
    
    private String drugclass;
    public String drugclassError;
    
    private String status;
    
    private String message;

    public ItemModel() {
    }

    public ItemModel(String itemCode, String itemClass, String itemName, String issueUnit, double price, String description, String dosageForm, String strength, String drugclass, String status) {
        this.itemCode = itemCode;
        this.itemClass = itemClass;
        this.itemName = itemName;
        this.issueUnit = issueUnit;
        this.price = price;
        this.description = description;
        this.dosageForm = dosageForm;
        this.strength = strength;
        this.drugclass = drugclass;
        this.status = status;
    }


    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getIssueUnit() {
        return issueUnit;
    }

    public void setIssueUnit(String issueUnit) {
        this.issueUnit = issueUnit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getDrugclass() {
        return drugclass;
    }

    public void setDrugclass(String drugclass) {
        this.drugclass = drugclass;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Boolean ValidateItem()
    {
        String flag = "";
        if(this.getPrice() <= 0)
        {
            priceError = "Price Should be Greater than 0";
            flag = "error";
        }
        if(this.getItemName().equals("") || this.getItemName() == null)
        {
            itemNameError = "Enter Item Name";
            flag = "error";
        } 
        if(this.getDosageForm().equals("") || this.getDosageForm() == null)
        {
            dosageFormError = "Enter Dosage Form";
            flag = "error";            
        }        
        if(this.getItemCode().equals("") || this.getItemCode() == null)
        {
            itemcodeError = "Enter Item Code";
            flag = "error";            
        }        
        if(this.getItemClass().equals("") || this.getItemClass() == null)
        {
            itemClassError = "Enter Item Class";
            flag = "error";            
        }        
        if(this.getIssueUnit().equals("") || this.getIssueUnit() == null)
        {
            issueUnitError = "Enter Issue Unit";
            flag = "error";            
        }         
        if(this.getDescription().equals("") || this.getDescription() == null)
        {
            descriptionError = "Enter Description";
            flag = "error";            
        }         
        if(this.getStrength().equals("") || this.getStrength() == null)
        {
            strengthError = "Enter Strength";
            flag = "error";            
        }         
        if(this.getDrugclass().equals("") || this.getDrugclass() == null)
        {
            drugclassError = "Enter Drug Class";
            flag = "error";            
        }         
        
                
        if(flag == "error")
        {
            return false;
        }        
        return true;
    }
    
}
