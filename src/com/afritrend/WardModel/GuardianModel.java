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
public class GuardianModel implements Serializable{
    private String firstname;
    public String firstnameError;
    private String othernames;
    public String othernamesError;
    private String lastname;
    public String lastnameError;
    private String relationshiptype;
    public String relationshipTypeError;
    private String message;

    public GuardianModel() {
    }

    public GuardianModel(String firstname, String othernames, String lastname, String relationshiptype) {
        this.firstname = firstname;
        this.othernames = othernames;
        this.lastname = lastname;
        this.relationshiptype = relationshiptype;
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

    public String getRelationshiptype() {
        return relationshiptype;
    }

    public void setRelationshiptype(String relationshiptype) {
        this.relationshiptype = relationshiptype;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "GuardianModel{" + "firstname=" + firstname + ", othernames=" + othernames + ", lastname=" + lastname + ", relationshiptype=" + relationshiptype + '}';
    }
    
    public boolean validateGuardian()
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
        
        if(this.relationshiptype.equals("") || this.relationshiptype == null)
        {
            this.relationshipTypeError = "Empty Field";
            Flag = "RED";
        }
        
        if(Flag.equals("RED"))
        {
            return false;
        }
        
        return true;
    }

}
