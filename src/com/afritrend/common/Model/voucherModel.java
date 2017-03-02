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
public class voucherModel implements Serializable, Cloneable{
    private String vouchercode;
    private String requisitionService;
    private String requisitionDate;
    private String lastdateRequisitionApproved;
    private String lastreferenceapprovedrequisition;
    private String comments;
    private String wardName;
    private String requisitionTransactionType;
    private String voucherstatus;

    public voucherModel() {
    }

    public voucherModel(String vouchercode, String requisitionService, String requisitionDate, String lastdateRequisitionApproved, String lastreferenceapprovedrequisition, String comments, String wardName, String requisitionTransactionType, String voucherstatus) {
        this.vouchercode = vouchercode;
        this.requisitionService = requisitionService;
        this.requisitionDate = requisitionDate;
        this.lastdateRequisitionApproved = lastdateRequisitionApproved;
        this.lastreferenceapprovedrequisition = lastreferenceapprovedrequisition;
        this.comments = comments;
        this.wardName = wardName;
        this.requisitionTransactionType = requisitionTransactionType;
        this.voucherstatus = voucherstatus;
    }

    public String getVouchercode() {
        return vouchercode;
    }

    public void setVouchercode(String vouchercode) {
        this.vouchercode = vouchercode;
    }

    public String getRequisitionService() {
        return requisitionService;
    }

    public void setRequisitionService(String requisitionService) {
        this.requisitionService = requisitionService;
    }

    public String getRequisitionDate() {
        return requisitionDate;
    }

    public void setRequisitionDate(String requisitionDate) {
        this.requisitionDate = requisitionDate;
    }

    public String getLastdateRequisitionApproved() {
        return lastdateRequisitionApproved;
    }

    public void setLastdateRequisitionApproved(String lastdateRequisitionApproved) {
        this.lastdateRequisitionApproved = lastdateRequisitionApproved;
    }

    public String getLastreferenceapprovedrequisition() {
        return lastreferenceapprovedrequisition;
    }

    public void setLastreferenceapprovedrequisition(String lastreferenceapprovedrequisition) {
        this.lastreferenceapprovedrequisition = lastreferenceapprovedrequisition;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getRequisitionTransactionType() {
        return requisitionTransactionType;
    }

    public void setRequisitionTransactionType(String requisitionTransactionType) {
        this.requisitionTransactionType = requisitionTransactionType;
    }

    public String getVoucherstatus() {
        return voucherstatus;
    }

    public void setVoucherstatus(String voucherstatus) {
        this.voucherstatus = voucherstatus;
    }

    @Override
    public String toString() {
        return "voucherModel{" + "vouchercode=" + vouchercode + ", requisitionService=" + requisitionService + ", requisitionDate=" + requisitionDate + ", lastdateRequisitionApproved=" + lastdateRequisitionApproved + ", lastreferenceapprovedrequisition=" + lastreferenceapprovedrequisition + ", comments=" + comments + ", wardName=" + wardName + ", requisitionTransactionType=" + requisitionTransactionType + ", voucherstatus=" + voucherstatus + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
