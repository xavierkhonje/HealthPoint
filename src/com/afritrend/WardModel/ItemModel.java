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
public class ItemModel implements Serializable, Cloneable{
    private String itemCode;
    private String itemClass;
    private String itemName;
    private String issueUnit;
    private double price;
    private String description;
    private String dosageForm;
    private String strength;
    private String expirydate;
    private String drugclass;
    private int quantity;
    
    private String message;

    public ItemModel() {
    }

    public ItemModel(String itemCode, String itemClass, String itemName, String issueUnit, double price, String description, String dosageForm, String strength, String expirydate, String drugclass, int quantity) {
        this.itemCode = itemCode;
        this.itemClass = itemClass;
        this.itemName = itemName;
        this.issueUnit = issueUnit;
        this.price = price;
        this.description = description;
        this.dosageForm = dosageForm;
        this.strength = strength;
        this.expirydate = expirydate;
        this.drugclass = drugclass;
        this.quantity = quantity;
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

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }

    public String getDrugclass() {
        return drugclass;
    }

    public void setDrugclass(String drugclass) {
        this.drugclass = drugclass;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        if(this.getPrice() <= 0)
        {
            this.setMessage("Price Should be Greater than 0");
            return false;
        }
        if(this.getQuantity() <= 0)
        {
            this.setMessage("Quantity Should be Greater than 0");
            return false;            
        }
        return true;
    }
    
}
