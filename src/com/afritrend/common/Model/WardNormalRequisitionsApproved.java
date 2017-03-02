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
public class WardNormalRequisitionsApproved implements Serializable, Cloneable{
    private int quantityRequested;
    private int quantityApproved;
    private int quantityReserved;
    private String cmscode;
    private String drugName;
    private String itemtype;
    private String scaleunit;
    private String requester;
    private String approver;
    private int requisitionid;

    public WardNormalRequisitionsApproved() {
    }

    public WardNormalRequisitionsApproved(int quantityRequested, int quantityApproved, int quantityReserved, String cmscode, String drugName, String itemtype, String scaleunit, String requester, String approver, int requisitionid) {
        this.quantityRequested = quantityRequested;
        this.quantityApproved = quantityApproved;
        this.quantityReserved = quantityReserved;
        this.cmscode = cmscode;
        this.drugName = drugName;
        this.itemtype = itemtype;
        this.scaleunit = scaleunit;
        this.requester = requester;
        this.approver = approver;
        this.requisitionid = requisitionid;
    }

    public int getQuantityRequested() {
        return quantityRequested;
    }

    public void setQuantityRequested(int quantityRequested) {
        this.quantityRequested = quantityRequested;
    }

    public int getQuantityApproved() {
        return quantityApproved;
    }

    public void setQuantityApproved(int quantityApproved) {
        this.quantityApproved = quantityApproved;
    }

    public int getQuantityReserved() {
        return quantityReserved;
    }

    public void setQuantityReserved(int quantityReserved) {
        this.quantityReserved = quantityReserved;
    }

    public String getCmscode() {
        return cmscode;
    }

    public void setCmscode(String cmscode) {
        this.cmscode = cmscode;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getItemtype() {
        return itemtype;
    }

    public void setItemtype(String itemtype) {
        this.itemtype = itemtype;
    }

    public String getScaleunit() {
        return scaleunit;
    }

    public void setScaleunit(String scaleunit) {
        this.scaleunit = scaleunit;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public int getRequisitionid() {
        return requisitionid;
    }

    public void setRequisitionid(int requisitionid) {
        this.requisitionid = requisitionid;
    }

    @Override
    public String toString() {
        return "WardNormalRequisitionsApproved{" + "quantityRequested=" + quantityRequested + ", quantityApproved=" + quantityApproved + ", quantityReserved=" + quantityReserved + ", cmscode=" + cmscode + ", drugName=" + drugName + ", itemtype=" + itemtype + ", scaleunit=" + scaleunit + ", requester=" + requester + ", approver=" + approver + ", requisitionid=" + requisitionid + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
