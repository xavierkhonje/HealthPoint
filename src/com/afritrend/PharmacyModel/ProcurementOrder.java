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
    private String itemcode;
    private String description;
    private int Quantity;

    public ProcurementOrder() {
    }

    public ProcurementOrder(String itemcode, String description, int Quantity) {
        this.itemcode = itemcode;
        this.description = description;
        this.Quantity = Quantity;
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
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    @Override
    public String toString() {
        return "ProcurementOrder{" + "itemcode=" + itemcode + ", description=" + description + ", Quantity=" + Quantity + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
