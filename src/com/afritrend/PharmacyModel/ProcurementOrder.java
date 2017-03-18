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
public class ProcurementOrder implements Serializable{
    private String itemclass;
    private String itemcode;
    private String description;
    private int quantity;
    private String scaleUnit;

    public String itemclassError;
    public String itemcodeError;
    public String descriptionError;
    public String quantityError;
    public String scaleUnitError;
    
    public ProcurementOrder() {
    }

    public ProcurementOrder(String itemclass, String itemcode, String description, int quantity, String scaleUnit) {
        this.itemclass = itemclass;
        this.itemcode = itemcode;
        this.description = description;
        this.quantity = quantity;
        this.scaleUnit = scaleUnit;
    }

    public String getItemclass() {
        return itemclass;
    }

    public void setItemclass(String itemclass) {
        this.itemclass = itemclass;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getScaleUnit() {
        return scaleUnit;
    }

    public void setScaleUnit(String scaleUnit) {
        this.scaleUnit = scaleUnit;
    }

    public boolean validateProcurement()
    {
        String Flag = "WHITE";
        
        if(this.itemclass.equals("")||this.itemclass == null)
        {
            Flag = "RED";
            this.itemclassError = "Please Select Class";
        }
        
        if(this.itemcode.equals("")||this.itemcode == null)
        {
            Flag = "RED";
            this.itemcodeError = "Please Select Code";
        }
        
        if(this.description.equals("")||this.description == null)
        {
            Flag = "RED";
            this.descriptionError = "Please Supply Description";
        }
        
        if(this.quantity == 0)
        {
            Flag = "RED";
            this.quantityError = "Please Supply Quantity";
        }
        
        if(this.scaleUnit.equals("")||this.scaleUnit == null)
        {
            Flag = "RED";
            this.scaleUnitError = "Please Supply Scale Unit";
        }
        
        if(Flag.equals("RED"))
        {
            return false;
        }
        return true;
    }



}
