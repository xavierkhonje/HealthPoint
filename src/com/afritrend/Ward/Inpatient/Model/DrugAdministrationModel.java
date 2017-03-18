/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.Ward.Inpatient.Model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Xavier Khonje
 */
public class DrugAdministrationModel implements Serializable{
    private LocalDate administrationDate;
    private LocalDate administrationTime;
    private String isdrugAdministered;
    private String drugName;
    private String strength;    
    private String dosageForm;    
    private int prescriptionid;
    private int administrationid;
    
    public String administrationDateError;
    public String administrationTimeError;
    public String isDrugAdministeredError;
    public String drugError;
    public String strengthError;
    public String dosageFormError;
    public String prescriptionidError;
    public String administrationidError;

    public DrugAdministrationModel() {
    }

    public DrugAdministrationModel(LocalDate administrationDate, LocalDate administrationTime, String isdrugAdministered, String drugName, String strength, String dosageForm, int prescriptionid, int administrationid) {
        this.administrationDate = administrationDate;
        this.administrationTime = administrationTime;
        this.isdrugAdministered = isdrugAdministered;
        this.drugName = drugName;
        this.strength = strength;
        this.dosageForm = dosageForm;
        this.prescriptionid = prescriptionid;
        this.administrationid = administrationid;
    }

    public LocalDate getAdministrationDate() {
        return administrationDate;
    }

    public void setAdministrationDate(LocalDate administrationDate) {
        this.administrationDate = administrationDate;
    }

    public LocalDate getAdministrationTime() {
        return administrationTime;
    }

    public void setAdministrationTime(LocalDate administrationTime) {
        this.administrationTime = administrationTime;
    }

    public String getIsdrugAdministered() {
        return isdrugAdministered;
    }

    public void setIsdrugAdministered(String isdrugAdministered) {
        this.isdrugAdministered = isdrugAdministered;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
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

    public int getPrescriptionid() {
        return prescriptionid;
    }

    public void setPrescriptionid(int prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public int getAdministrationid() {
        return administrationid;
    }

    public void setAdministrationid(int administrationid) {
        this.administrationid = administrationid;
    }
    
    

    
}
