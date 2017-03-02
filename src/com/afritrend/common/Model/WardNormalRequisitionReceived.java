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
public class WardNormalRequisitionReceived implements Serializable, Cloneable{
    private int quantityCollected;
    private int quantityReceived;
    private int quantityLost;
    private int quantityExpired;
    private int quantityDamaged;
    private String receiver;
    private int reqid;

    public WardNormalRequisitionReceived() {
    }

    public WardNormalRequisitionReceived(int quantityCollected, int quantityReceived, int quantityLost, int quantityExpired, int quantityDamaged, String receiver, int reqid) {
        this.quantityCollected = quantityCollected;
        this.quantityReceived = quantityReceived;
        this.quantityLost = quantityLost;
        this.quantityExpired = quantityExpired;
        this.quantityDamaged = quantityDamaged;
        this.receiver = receiver;
        this.reqid = reqid;
    }

    public int getQuantityCollected() {
        return quantityCollected;
    }

    public void setQuantityCollected(int quantityCollected) {
        this.quantityCollected = quantityCollected;
    }

    public int getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(int quantityReceived) {
        this.quantityReceived = quantityReceived;
    }

    public int getQuantityLost() {
        return quantityLost;
    }

    public void setQuantityLost(int quantityLost) {
        this.quantityLost = quantityLost;
    }

    public int getQuantityExpired() {
        return quantityExpired;
    }

    public void setQuantityExpired(int quantityExpired) {
        this.quantityExpired = quantityExpired;
    }

    public int getQuantityDamaged() {
        return quantityDamaged;
    }

    public void setQuantityDamaged(int quantityDamaged) {
        this.quantityDamaged = quantityDamaged;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getReqid() {
        return reqid;
    }

    public void setReqid(int reqid) {
        this.reqid = reqid;
    }

    @Override
    public String toString() {
        return "WardNormalRequisitionReceived{" + "quantityCollected=" + quantityCollected + ", quantityReceived=" + quantityReceived + ", quantityLost=" + quantityLost + ", quantityExpired=" + quantityExpired + ", quantityDamaged=" + quantityDamaged + ", receiver=" + receiver + ", reqid=" + reqid + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
