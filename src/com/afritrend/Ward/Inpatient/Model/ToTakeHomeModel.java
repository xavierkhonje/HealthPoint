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
public class ToTakeHomeModel implements Serializable {
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
    
    public String drugclassError;
    public String dosageFormError;
    public String drugNameError;
    public String quantityError;
    public String instructionError;
    public String malangizoError;
    public String pxError;
    public String admissionCodeError;
    public String dosageProcedureError;
    public String patientNumberError;

    public ToTakeHomeModel() {
    }

    public ToTakeHomeModel(String drugClass, String dosageForm, String drugName, int quantity, String instruction, String malangizo, String px, int MidnightAmount, int MorningAmount, int NoonAmount, int EveningAmount, int Processed, String admissionCode, String dosageProcedure, String patientNumber) {
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

    public String getDrugclassError() {
        return drugclassError;
    }

    public void setDrugclassError(String drugclassError) {
        this.drugclassError = drugclassError;
    }

    public String getDosageFormError() {
        return dosageFormError;
    }

    public void setDosageFormError(String dosageFormError) {
        this.dosageFormError = dosageFormError;
    }

    public String getDrugNameError() {
        return drugNameError;
    }

    public void setDrugNameError(String drugNameError) {
        this.drugNameError = drugNameError;
    }

    public String getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }

    public String getInstructionError() {
        return instructionError;
    }

    public void setInstructionError(String instructionError) {
        this.instructionError = instructionError;
    }

    public String getMalangizoError() {
        return malangizoError;
    }

    public void setMalangizoError(String malangizoError) {
        this.malangizoError = malangizoError;
    }

    public String getPxError() {
        return pxError;
    }

    public void setPxError(String pxError) {
        this.pxError = pxError;
    }

    public String getAdmissionCodeError() {
        return admissionCodeError;
    }

    public void setAdmissionCodeError(String admissionCodeError) {
        this.admissionCodeError = admissionCodeError;
    }

    public String getDosageProcedureError() {
        return dosageProcedureError;
    }

    public void setDosageProcedureError(String dosageProcedureError) {
        this.dosageProcedureError = dosageProcedureError;
    }

    public String getPatientNumberError() {
        return patientNumberError;
    }

    public void setPatientNumberError(String patientNumberError) {
        this.patientNumberError = patientNumberError;
    }
    
    
    public boolean validateTTO()
    {
        String Flag = "WHITE";
        
        if(this.drugClass.equals("")||this.drugClass == null)
        {
            Flag = "RED";
            this.setDrugclassError("Please Supply Drug Class");
        }
        
        if(this.dosageForm.equals("")||this.dosageForm == null)
        {
            Flag = "RED";
            this.setDosageFormError("Please Supply DosageForm");
        }
        
        if(this.drugName.equals("")||this.drugName == null)
        {
            Flag = "RED";
            this.setDrugNameError("Please Supply Drug Name");            
        }
        
        if(this.quantity == 0)
        {
            Flag = "RED";
            this.setQuantityError("Please Supply Quantity");
        }
        
        if(this.instruction.equals("")||this.instruction == null)
        {
            Flag = "RED";
            this.setInstructionError("Please Supply Instruction");
        }
        
        if(this.malangizo.equals("")||this.malangizo == null)
        {
            Flag = "RED";
            this.setMalangizoError("Please Supply Malangizo");
        }
        
        if(this.px.equals("")||this.px == null)
        {
            Flag = "RED";
            this.setPxError("");
        }
        
        if(this.admissionCode.equals("") || this.admissionCode == null)
        {
            Flag = "RED";
            this.setAdmissionCodeError("Please Supply Code");
        }
        
        if(this.dosageProcedure.equals("")||this.dosageProcedure == null)
        {
            Flag = "RED";
            this.setDosageProcedureError("Please Supply Procedure");
        }
        
        if(this.patientNumber.equals("")||this.patientNumber == null)
        {
            Flag = "RED";
            this.setPatientNumberError("Please Select Patient");
        }
        
        if(Flag.equals("RED"))
        {
            return false;
        }
        
        return true;
    }    
}