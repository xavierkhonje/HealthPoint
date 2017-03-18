/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.Ward.Inpatient.Model;

/**
 *
 * @author Xavier Khonje
 */
public class GuardianModel {
    private String firstName;
    private String otherName;
    private String lastName;
    private String relationShipType;
    
    public String firstnameError;
    public String otherNameError;
    public String lastNameError;
    public String relationshipTypeError;

    public GuardianModel() {
    }

    public GuardianModel(String firstName, String otherName, String lastName, String relationShipType) {
        this.firstName = firstName;
        this.otherName = otherName;
        this.lastName = lastName;
        this.relationShipType = relationShipType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRelationShipType() {
        return relationShipType;
    }

    public void setRelationShipType(String relationShipType) {
        this.relationShipType = relationShipType;
    }
    
    public boolean validateGuardian()
    {
        String Flag = "WHITE";
        if(this.firstName.equals("") || this.firstName == null)
        {
            Flag = "RED";
            this.firstnameError = "Please Supply Firstname";
        }
        
        if(this.otherName.equals("") || this.otherName == null)
        {
            Flag = "RED";
            this.otherNameError = "Please Supply Other Name";
        }
        
        if(this.lastName.equals("") || this.lastName == null)
        {
            Flag = "RED";
            this.lastNameError = "Please Supply LastName";
        }
        
        if(this.relationShipType.equals("") || this.relationShipType == null)
        {
            Flag = "RED";
            this.relationshipTypeError = "Please Supply RelationShip Type";
        }
        
        if(Flag.equals("RED"))
        {
            return false;
        }
        return true;
    }
}
