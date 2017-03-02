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
public class costSummaryModel implements Serializable, Cloneable{
    private int itemQuantity;
    private int itemPrice;
    private int itemLineTotal;
    private int totalValue;
    private String description;
    private String itemSupplier;

    public costSummaryModel() {
    }

    public costSummaryModel(int itemQuantity, int itemPrice, int itemLineTotal, int totalValue, String description, String itemSupplier) {
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.itemLineTotal = itemLineTotal;
        this.totalValue = totalValue;
        this.description = description;
        this.itemSupplier = itemSupplier;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemLineTotal() {
        return itemLineTotal;
    }

    public void setItemLineTotal(int itemLineTotal) {
        this.itemLineTotal = itemLineTotal;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemSupplier() {
        return itemSupplier;
    }

    public void setItemSupplier(String itemSupplier) {
        this.itemSupplier = itemSupplier;
    }

    @Override
    public String toString() {
        return "costSummaryModel{" + "itemQuantity=" + itemQuantity + ", itemPrice=" + itemPrice + ", itemLineTotal=" + itemLineTotal + ", totalValue=" + totalValue + ", description=" + description + ", itemSupplier=" + itemSupplier + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
