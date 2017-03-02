/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.Model;

import java.io.Serializable;

/**
 *
 * @author Xavier Khonje
 */
public abstract class SessionManagement implements Serializable{
    private  final int userid;
    public static int _userid;
    private final String firstname;
    public static String _firstname;
    private final String middlename;
    public static String _middlename;
    private final String lastname;
    public static String _lastname;
    private final String office_Tel;
    public static String _office_Tel;
    private final String home_Tel;
    public static String _home_Tel;
    private final String last_login;
    public static String _last_login;
    private final int password_retries;
    public static int _password_retries;
    private final String designation;
    public static String _designation;
    private final String email;
    public static String _email;
    private final String password;
    public static String _password;
    private final String status;
    public static String _status;
    private final String reset_password_key;
    public static String _reset_password_key;
    private final String test_Question;
    public static String _test_Question;
    private final String answer;
    public static String _answer;
    private final String usergroup;
    public static String _usergroup;
    private final String wardName;
    public static String _wardName;
    private final String timeloggedin;
    public static String _timeloggedin;
    
    public SessionManagement(
            int userid, String firstname, String middlename, String lastname, 
            String office_Tel, String home_Tel, String last_login, int password_retries, 
            String designation, String email, String password, String status, 
            String reset_password_key, String test_Question, String answer, String usergroup, 
            String wardName, String timeloggedin
    ) 
    {
        this.userid = userid;
        this.firstname = firstname;
        _firstname = this.firstname;
        this.middlename = middlename;
        _middlename = this.middlename;
        this.lastname = lastname;
        _lastname = this.lastname;
        this.office_Tel = office_Tel;
        _office_Tel = this.office_Tel;
        this.home_Tel = home_Tel;
        _home_Tel = this.home_Tel;
        this.last_login = last_login;
        _last_login = this.last_login;
        this.password_retries = password_retries;
        _password_retries = this.password_retries;
        this.designation = designation;
        _designation = this.designation;
        this.email = email;
        _email = this.email;
        this.password = password;
        _password = this.password;
        this.status = status;
        _status = this.status ;
        this.reset_password_key = reset_password_key;
        _reset_password_key = this.reset_password_key;
        this.test_Question = test_Question;
        _test_Question = this.test_Question;
        this.answer = answer;
        _answer = this.answer;
        this.usergroup = usergroup;
        _usergroup = this.usergroup;
        this.wardName = wardName;
        _wardName = this.wardName;
        this.timeloggedin = timeloggedin;
        _timeloggedin = this.timeloggedin;
    }
    

    public int getUserid() {
        return userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getOffice_Tel() {
        return office_Tel;
    }

    public String getHome_Tel() {
        return home_Tel;
    }

    public String getLast_login() {
        return last_login;
    }

    public int getPassword_retries() {
        return password_retries;
    }

    public String getDesignation() {
        return designation;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public String getReset_password_key() {
        return reset_password_key;
    }

    public String getTest_Question() {
        return test_Question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getUsergroup() {
        return usergroup;
    }

    public String getWardName() {
        return wardName;
    }

    public String getTimeloggedin() {
        return timeloggedin;
    }       

    @Override
    public String toString() {
        return "SessionManagement{" + "userid=" + userid + ", firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname + ", office_Tel=" + office_Tel + ", home_Tel=" + home_Tel + ", last_login=" + last_login + ", password_retries=" + password_retries + ", designation=" + designation + ", email=" + email + ", password=" + password + ", status=" + status + ", reset_password_key=" + reset_password_key + ", test_Question=" + test_Question + ", answer=" + answer + ", usergroup=" + usergroup + ", wardName=" + wardName + '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
