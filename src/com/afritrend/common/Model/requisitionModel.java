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
public class requisitionModel implements Serializable, Cloneable{
    private String scaleUnit;
    private int amount;
    private String itemType;
    private String cmscode;
    private int requisitionid;

    public requisitionModel() {
    }

    public requisitionModel(String scaleUnit, int amount, String itemType, String cmscode, int requisitionid) {
        this.scaleUnit = scaleUnit;
        this.amount = amount;
        this.itemType = itemType;
        this.cmscode = cmscode;
        this.requisitionid = requisitionid;
    }

    public String getScaleUnit() {
        return scaleUnit;
    }

    public void setScaleUnit(String scaleUnit) {
        this.scaleUnit = scaleUnit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getCmscode() {
        return cmscode;
    }

    public void setCmscode(String cmscode) {
        this.cmscode = cmscode;
    }

    public int getRequisitionid() {
        return requisitionid;
    }

    public void setRequisitionid(int requisitionid) {
        this.requisitionid = requisitionid;
    }

    @Override
    public String toString() {
        return "requisitionModel{" + "scaleUnit=" + scaleUnit + ", amount=" + amount + ", itemType=" + itemType + ", cmscode=" + cmscode + ", requisitionid=" + requisitionid + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
