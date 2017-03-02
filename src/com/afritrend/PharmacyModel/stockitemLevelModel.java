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
public class stockitemLevelModel implements Serializable, Cloneable{
    
    private String itemCode;
    private String itemName;
    private String strength;
    private int amount;
    private int ewp;
    private int minlevel;
    private int maxlevel;

    public stockitemLevelModel() {
    }

    public stockitemLevelModel(String itemCode, String itemName, String strength, int amount, int ewp, int minlevel, int maxlevel) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.strength = strength;
        this.amount = amount;
        this.ewp = ewp;
        this.minlevel = minlevel;
        this.maxlevel = maxlevel;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getEwp() {
        return ewp;
    }

    public void setEwp(int ewp) {
        this.ewp = ewp;
    }

    public int getMinlevel() {
        return minlevel;
    }

    public void setMinlevel(int minlevel) {
        this.minlevel = minlevel;
    }

    public int getMaxlevel() {
        return maxlevel;
    }

    public void setMaxlevel(int maxlevel) {
        this.maxlevel = maxlevel;
    }

    @Override
    public String toString() {
        return "stockitemLevelModel{" + "itemCode=" + itemCode + ", itemName=" + itemName + ", strength=" + strength + ", amount=" + amount + ", ewp=" + ewp + ", minlevel=" + minlevel + ", maxlevel=" + maxlevel + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
