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
public class WardNormalRequisitionFinalized implements Serializable, Cloneable{
    private int quantityReceived;
    private int quantityFinalized;
    private String finalizer;
    private int reqid;

    public WardNormalRequisitionFinalized() {
    }

    public WardNormalRequisitionFinalized(int quantityReceived, int quantityFinalized, String finalizer, int reqid) {
        this.quantityReceived = quantityReceived;
        this.quantityFinalized = quantityFinalized;
        this.finalizer = finalizer;
        this.reqid = reqid;
    }

    public int getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(int quantityReceived) {
        this.quantityReceived = quantityReceived;
    }

    public int getQuantityFinalized() {
        return quantityFinalized;
    }

    public void setQuantityFinalized(int quantityFinalized) {
        this.quantityFinalized = quantityFinalized;
    }

    public String getFinalizer() {
        return finalizer;
    }

    public void setFinalizer(String finalizer) {
        this.finalizer = finalizer;
    }

    public int getReqid() {
        return reqid;
    }

    public void setReqid(int reqid) {
        this.reqid = reqid;
    }

    @Override
    public String toString() {
        return "WardNormalRequisitionFinalized{" + "quantityReceived=" + quantityReceived + ", quantityFinalized=" + quantityFinalized + ", finalizer=" + finalizer + ", reqid=" + reqid + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
