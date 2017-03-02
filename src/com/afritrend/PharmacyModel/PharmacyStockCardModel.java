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
public class PharmacyStockCardModel implements Serializable, Cloneable{
    private String drugName;
    private String cmscode;
    private String strength;
    private String dosageForm;
    private String issueUnit;
    private int receivedAmount;
    private int issuedAmount;
    private int lostAmount;
    private int expiredAmount;
    private int adjustedPlusAmount;
    private int adjustedMinusAmount;

    public PharmacyStockCardModel() {
    }

    public PharmacyStockCardModel(String drugName, String cmscode, String strength, String dosageForm, String issueUnit, int receivedAmount, int issuedAmount, int lostAmount, int expiredAmount, int adjustedPlusAmount, int adjustedMinusAmount) {
        this.drugName = drugName;
        this.cmscode = cmscode;
        this.strength = strength;
        this.dosageForm = dosageForm;
        this.issueUnit = issueUnit;
        this.receivedAmount = receivedAmount;
        this.issuedAmount = issuedAmount;
        this.lostAmount = lostAmount;
        this.expiredAmount = expiredAmount;
        this.adjustedPlusAmount = adjustedPlusAmount;
        this.adjustedMinusAmount = adjustedMinusAmount;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getCmscode() {
        return cmscode;
    }

    public void setCmscode(String cmscode) {
        this.cmscode = cmscode;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getIssueUnit() {
        return issueUnit;
    }

    public void setIssueUnit(String issueUnit) {
        this.issueUnit = issueUnit;
    }

    public int getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(int receivedAmount) {
        this.receivedAmount = receivedAmount;
    }

    public int getIssuedAmount() {
        return issuedAmount;
    }

    public void setIssuedAmount(int issuedAmount) {
        this.issuedAmount = issuedAmount;
    }

    public int getLostAmount() {
        return lostAmount;
    }

    public void setLostAmount(int lostAmount) {
        this.lostAmount = lostAmount;
    }

    public int getExpiredAmount() {
        return expiredAmount;
    }

    public void setExpiredAmount(int expiredAmount) {
        this.expiredAmount = expiredAmount;
    }

    public int getAdjustedPlusAmount() {
        return adjustedPlusAmount;
    }

    public void setAdjustedPlusAmount(int adjustedPlusAmount) {
        this.adjustedPlusAmount = adjustedPlusAmount;
    }

    public int getAdjustedMinusAmount() {
        return adjustedMinusAmount;
    }

    public void setAdjustedMinusAmount(int adjustedMinusAmount) {
        this.adjustedMinusAmount = adjustedMinusAmount;
    }


    
    
    
}
