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
public class WardNormalRequisitionReview implements Serializable, Cloneable{
    private int quantityRequestedByward;
    private int quantityPacked;
    private String drugname;
    private String strength;
    private String dosageform;
    private String issueUnit;
    private String pharmacistPacking;
    private int reqid;

    public WardNormalRequisitionReview() {
    }

    public WardNormalRequisitionReview(int quantityRequestedByward, int quantityPacked, String drugname, String strength, String dosageform, String issueUnit, int reqid) {
        this.quantityRequestedByward = quantityRequestedByward;
        this.quantityPacked = quantityPacked;
        this.drugname = drugname;
        this.strength = strength;
        this.dosageform = dosageform;
        this.issueUnit = issueUnit;
        this.reqid = reqid;
    }

    public int getQuantityRequestedByward() {
        return quantityRequestedByward;
    }

    public void setQuantityRequestedByward(int quantityRequestedByward) {
        this.quantityRequestedByward = quantityRequestedByward;
    }

    public int getQuantityPacked() {
        return quantityPacked;
    }

    public void setQuantityPacked(int quantityPacked) {
        this.quantityPacked = quantityPacked;
    }

    public String getPharmacistPacking() {
        return pharmacistPacking;
    }

    public void setPharmacistPacking(String pharmacistPacking) {
        this.pharmacistPacking = pharmacistPacking;
    }

    public int getReqid() {
        return reqid;
    }

    public void setReqid(int reqid) {
        this.reqid = reqid;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getDosageform() {
        return dosageform;
    }

    public void setDosageform(String dosageform) {
        this.dosageform = dosageform;
    }

    public String getIssueUnit() {
        return issueUnit;
    }

    public void setIssueUnit(String issueUnit) {
        this.issueUnit = issueUnit;
    }

    @Override
    public String toString() {
        return "WardNormalRequisitionReview{" + "quantityRequestedByward=" + quantityRequestedByward + ", quantityPacked=" + quantityPacked + ", drugname=" + drugname + ", strength=" + strength + ", dosageform=" + dosageform + ", issueUnit=" + issueUnit + ", pharmacistPacking=" + pharmacistPacking + ", reqid=" + reqid + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
