/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.sqlite.Model;

import java.io.Serializable;

/**
 *
 * @author Xavier Khonje
 */
public class user implements Serializable, Cloneable{
    private int userid;
    private String firstName;
    private String middlename;
    private String lastname;
    private String emailaddress;
    private String departmentName;
    private String usergroup;

    public user() {
    }

    public user(int userid, String firstName, String middlename, String lastname, String emailaddress, String departmentName, String usergroup) {
        this.userid = userid;
        this.firstName = firstName;
        this.middlename = middlename;
        this.lastname = lastname;
        this.emailaddress = emailaddress;
        this.departmentName = departmentName;
        this.usergroup = usergroup;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(String usergroup) {
        this.usergroup = usergroup;
    }

    @Override
    public String toString() {
        return "user{" + "userid=" + userid + ", firstName=" + firstName + ", middlename=" + middlename + ", lastname=" + lastname + ", emailaddress=" + emailaddress + ", departmentName=" + departmentName + ", usergroup=" + usergroup + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
