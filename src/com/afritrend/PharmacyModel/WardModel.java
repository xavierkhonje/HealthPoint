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
public class WardModel implements Serializable, Cloneable{
    private String wardName;
    public String wardNameError;
    private String location;
    public String locationError;
    private String message;

    public WardModel() {
    }

    public WardModel(String wardName, String location) {
        this.wardName = wardName;
        this.location = location;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "WardModel{" + "wardName=" + wardName + ", location=" + location + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    String Flag = "WHITE";
    
    public boolean validateWard()
    {
        if(this.wardName.equals("") || this.wardName == null)
        {
            Flag = "RED";
            this.wardNameError = "provide Ward Name";
        }
        
        if(this.location.equals("") || this.location == null)
        {
            Flag = "RED";
            this.locationError = "Provide Location";
        }
        
        if(Flag.equals("RED"))
        {
            this.message = "Please Correct the Fields";
            return false;
        }
        return true;
    }
    
}
