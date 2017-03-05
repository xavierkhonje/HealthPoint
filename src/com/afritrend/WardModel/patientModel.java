/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardModel;

import java.io.Serializable;

/**
 *
 * @author Xavier Khonje
 */
public class patientModel implements Serializable{
    private String patientID;
    private String firstname;
    public String firstnameError;
    private String othernames;
    public String othernamesError;
    private String lastname;
    public String lastnameError;
    private String telNumber;
    public String telNumberError;
    private String celNumber;
    public String celNumberError;
    private String address1;
    public String address1Error;
    private String address2;
    public String address2Error;
    private String image;
    public String imageError;
    private String hospitalName;
    private String wardName;
    private String wardDptName;
    private String message;

    public patientModel() {
    }

    public patientModel(String patientID, String firstname, String othernames, String lastname, String telNumber, String celNumber, String address1, String address2, String image, String hospitalName, String wardName, String wardDptName) {
        this.patientID = patientID;
        this.firstname = firstname;
        this.othernames = othernames;
        this.lastname = lastname;
        this.telNumber = telNumber;
        this.celNumber = celNumber;
        this.address1 = address1;
        this.address2 = address2;
        this.image = image;
        this.hospitalName = hospitalName;
        this.wardName = wardName;
        this.wardDptName = wardDptName;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }  
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getOthernames() {
        return othernames;
    }

    public void setOthernames(String othernames) {
        this.othernames = othernames;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getCelNumber() {
        return celNumber;
    }

    public void setCelNumber(String celNumber) {
        this.celNumber = celNumber;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getWardDptName() {
        return wardDptName;
    }

    public void setWardDptName(String wardDptName) {
        this.wardDptName = wardDptName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "patientModel{" + "firstname=" + firstname + ", othernames=" + othernames + ", lastname=" + lastname + ", telNumber=" + telNumber + ", celNumber=" + celNumber + ", address1=" + address1 + ", address2=" + address2 + ", message=" + message + '}';
    }
    
    public boolean validatePatient()
    {
        String Flag = "WHITE";
        
        if(this.firstname.equals("") || this.firstname == null)
        {
            this.firstnameError = "Empty Field";
            Flag = "RED";
        }
        
        if(this.othernames.equals("") || this.othernames == null)
        {
            this.othernamesError = "Empty Field";
            Flag = "RED";
        }
        
        if(this.lastname.equals("") || this.lastname == null)
        {
            this.lastnameError = "Empty Field";
            Flag = "RED";
        }
        
        if(this.telNumber.equals("") || this.telNumber == null)
        {
            this.telNumberError = "Empty Field";
            Flag = "RED";
        }
        
        if(this.celNumber.equals("") || this.celNumber == null)
        {
            this.celNumberError = "Empty Field";
            Flag = "RED";
        }
        
        if(this.address1.equals("") || this.address1 == null)
        {
            this.address1Error = "Empty Field";
            Flag = "RED";
        }
        
        if(this.address2.equals("") || this.address2 == null)
        {
            this.address2Error = "Empty Field";
            Flag = "RED";
        }
        
        if(this.image.equals("") || this.image == null)
        {
            this.imageError = "Empty Field";
            Flag = "RED";
        }
        
        
        if(Flag.equals("RED"))
        {
            return false;
        }
        
        return true;
    }
    
    
}
