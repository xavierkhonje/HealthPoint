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
public class SundryModel implements Serializable, Cloneable {
    
    private String cmsclass;
    public String cmsclassError;
    private String cmscode;
    public String cmscodeError;
    private String sundryname;
    public String sundrynameError;
    private String issueUnit;
    public String issueUnitError;
    private Double price;
    public String priceError;
    private String description;
    public String descriptionError;
    private String sundrysource;
    public String sundrysourceError;
    private String sundryclass;
    public String sundryclassError;
    public String status;
    private String message;

    public SundryModel() {
    }

    public SundryModel(String cmsclass, String cmscode, String sundryname, String issueUnit, Double price, String description, String sundrysource, String sundryclass, String status) {
        this.cmsclass = cmsclass;
        this.cmscode = cmscode;
        this.sundryname = sundryname;
        this.issueUnit = issueUnit;
        this.price = price;
        this.description = description;
        this.sundrysource = sundrysource;
        this.sundryclass = sundryclass;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getCmsclass() {
        return cmsclass;
    }

    public void setCmsclass(String cmsclass) {
        this.cmsclass = cmsclass;
    }

    public String getCmscode() {
        return cmscode;
    }

    public void setCmscode(String cmscode) {
        this.cmscode = cmscode;
    }

    public String getSundryname() {
        return sundryname;
    }

    public void setSundryname(String sundryname) {
        this.sundryname = sundryname;
    }

    public String getIssueUnit() {
        return issueUnit;
    }

    public void setIssueUnit(String issueUnit) {
        this.issueUnit = issueUnit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSundrysource() {
        return sundrysource;
    }

    public void setSundrysource(String sundrysource) {
        this.sundrysource = sundrysource;
    }

    public String getSundryclass() {
        return sundryclass;
    }

    public void setSundryclass(String sundryclass) {
        this.sundryclass = sundryclass;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public boolean ValidateSundry()
    {
        return true;
    }
    
    
}
