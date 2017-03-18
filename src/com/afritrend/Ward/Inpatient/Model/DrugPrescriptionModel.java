/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.Ward.Inpatient.Model;

import java.io.Serializable;

/**
 *
 * @author Xavier Khonje
 */
public class DrugPrescriptionModel implements Serializable{
    private String drugClass;
    private String dosageForm;
    private String drugName;
    private int quantity;
    private String instruction;
    private String malangizo;
    private String px;
    private int MidnightAmount;
    private int MorningAmount;
    private int NoonAmount;
    private int EveningAmount;
    private int Processed;
    private String admissionCode;
    private String dosageProcedure;
    private String patientNumber;

    public DrugPrescriptionModel() {
    }

    public DrugPrescriptionModel(String drugClass, String dosageForm, String drugName, int quantity, String instruction, String malangizo, String px, int MidnightAmount, int MorningAmount, int NoonAmount, int EveningAmount, int Processed, String admissionCode, String dosageProcedure, String patientNumber) {
        this.drugClass = drugClass;
        this.dosageForm = dosageForm;
        this.drugName = drugName;
        this.quantity = quantity;
        this.instruction = instruction;
        this.malangizo = malangizo;
        this.px = px;
        this.MidnightAmount = MidnightAmount;
        this.MorningAmount = MorningAmount;
        this.NoonAmount = NoonAmount;
        this.EveningAmount = EveningAmount;
        this.Processed = Processed;
        this.admissionCode = admissionCode;
        this.dosageProcedure = dosageProcedure;
        this.patientNumber = patientNumber;
    }

    public String getDrugClass() {
        return drugClass;
    }

    public void setDrugClass(String drugClass) {
        this.drugClass = drugClass;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public String getPx() {
        return px;
    }

    public void setPx(String px) {
        this.px = px;
    }

    public int getMidnightAmount() {
        return MidnightAmount;
    }

    public void setMidnightAmount(int MidnightAmount) {
        this.MidnightAmount = MidnightAmount;
    }

    public int getMorningAmount() {
        return MorningAmount;
    }

    public void setMorningAmount(int MorningAmount) {
        this.MorningAmount = MorningAmount;
    }

    public int getNoonAmount() {
        return NoonAmount;
    }

    public void setNoonAmount(int NoonAmount) {
        this.NoonAmount = NoonAmount;
    }

    public int getEveningAmount() {
        return EveningAmount;
    }

    public void setEveningAmount(int EveningAmount) {
        this.EveningAmount = EveningAmount;
    }

    public int getProcessed() {
        return Processed;
    }

    public void setProcessed(int Processed) {
        this.Processed = Processed;
    }

    public String getAdmissionCode() {
        return admissionCode;
    }

    public void setAdmissionCode(String admissionCode) {
        this.admissionCode = admissionCode;
    }

    public String getDosageProcedure() {
        return dosageProcedure;
    }

    public void setDosageProcedure(String dosageProcedure) {
        this.dosageProcedure = dosageProcedure;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public boolean valaidateDrugPrescription()
    {
        
        return true;
    }
}
