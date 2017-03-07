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
public class OPDPrescriptionModel implements Serializable{
    private int prescriptionid;
    private String patientNo;
    private String firstName;
    private String middleName;
    private String lastName;
    private String cmsCode;
    private String drugName;
    private String admissionCode;
    private String dosageForm;
    private String instruction;
    private String malangizo;
    private String expirydate;
    private String strength;
    private int quantity;
    private String px;
    private int frequency;    
    private byte[] prescrionbarcode;

    public OPDPrescriptionModel() {
    }

    public OPDPrescriptionModel(int prescriptionid, String patientNo, String firstName, String middleName, String lastName, String cmsCode, String drugName, String admissionCode, String dosageForm, String instruction, String malangizo, String expirydate, String strength, int quantity, String px, int frequency, byte[] prescrionbarcode) {
        this.prescriptionid = prescriptionid;
        this.patientNo = patientNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cmsCode = cmsCode;
        this.drugName = drugName;
        this.admissionCode = admissionCode;
        this.dosageForm = dosageForm;
        this.instruction = instruction;
        this.malangizo = malangizo;
        this.expirydate = expirydate;
        this.strength = strength;
        this.quantity = quantity;
        this.px = px;
        this.frequency = frequency;
        this.prescrionbarcode = prescrionbarcode;
    }

    public int getPrescriptionid() {
        return prescriptionid;
    }

    public void setPrescriptionid(int prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }        

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCmsCode() {
        return cmsCode;
    }

    public void setCmsCode(String cmsCode) {
        this.cmsCode = cmsCode;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getAdmissionCode() {
        return admissionCode;
    }

    public void setAdmissionCode(String admissionCode) {
        this.admissionCode = admissionCode;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getMalangizo() {
        return malangizo;
    }

    public void setMalangizo(String malangizo) {
        this.malangizo = malangizo;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }

    public String getPx() {
        return px;
    }

    public void setPx(String px) {
        this.px = px;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public byte[] getPrescrionbarcode() {
        return prescrionbarcode;
    }

    public void setPrescrionbarcode(byte[] prescrionbarcode) {
        this.prescrionbarcode = prescrionbarcode;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
