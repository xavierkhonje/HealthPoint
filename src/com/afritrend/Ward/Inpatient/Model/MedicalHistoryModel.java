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
public class MedicalHistoryModel implements Serializable
{
    private String indication;
    private String startdate;
    private String enddate;
    private String duration;
    private String drugname;
    private String chattered;
    private String frequency;
    private String dosage;
    private String route;
    private String prescribedPhysician;
    private String administrativeNurse;
    private String hospitalName;
    private String WardName;

    public MedicalHistoryModel() {
    }

    public MedicalHistoryModel(String indication, String startdate, String enddate, String duration, String drugname, String chattered, String frequency, String dosage, String route, String prescribedPhysician, String administrativeNurse, String hospitalName, String WardName) {
        this.indication = indication;
        this.startdate = startdate;
        this.enddate = enddate;
        this.duration = duration;
        this.drugname = drugname;
        this.chattered = chattered;
        this.frequency = frequency;
        this.dosage = dosage;
        this.route = route;
        this.prescribedPhysician = prescribedPhysician;
        this.administrativeNurse = administrativeNurse;
        this.hospitalName = hospitalName;
        this.WardName = WardName;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getChattered() {
        return chattered;
    }

    public void setChattered(String chattered) {
        this.chattered = chattered;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getPrescribedPhysician() {
        return prescribedPhysician;
    }

    public void setPrescribedPhysician(String prescribedPhysician) {
        this.prescribedPhysician = prescribedPhysician;
    }

    public String getAdministrativeNurse() {
        return administrativeNurse;
    }

    public void setAdministrativeNurse(String administrativeNurse) {
        this.administrativeNurse = administrativeNurse;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getWardName() {
        return WardName;
    }

    public void setWardName(String WardName) {
        this.WardName = WardName;
    }
        
}
