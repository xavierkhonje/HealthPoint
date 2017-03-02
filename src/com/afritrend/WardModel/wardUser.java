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
public class wardUser implements Serializable, Cloneable{
    
    private String firstname;
    public String firstnameError;
    private String middlename;
    public String middlenameError;
    private String lastname;
    public String lastnameError;
    private String office_tel;
    public String office_telError;
    private String home_tel;
    public String home_telError;
    private String last_login;
    public String last_loginError;
    private int password_retries;
    public String password_retriesError;
    private String designation;
    public String designationError;
    private String email;
    public String emailError;
    private String password;
    public String passwordError;
    private String confirmPassword;
    public String confirmPasswordError;
    private String status;
    public String statusError;
    private String reset_password_Key;
    public String reset_password_KeyError;
    private String test_Question;
    public String test_QuestionError;
    private String answer;
    public String answerError;
    private String dateCreated;
    private String dateModified;
    private String usergroup;
    public String usergroupError;
    private String ward;
    public String wardError;
    private String message;

    public wardUser() {
    }

    public wardUser(String firstname, String middlename, String lastname, String office_tel, String home_tel, String last_login, int password_retries, String designation, String email, String password, String confirmPassword, String status, String reset_password_Key, String test_Question, String answer, String dateCreated, String dateModified, String usergroup, String ward, String message) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.office_tel = office_tel;
        this.home_tel = home_tel;
        this.last_login = last_login;
        this.password_retries = password_retries;
        this.designation = designation;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.status = status;
        this.reset_password_Key = reset_password_Key;
        this.test_Question = test_Question;
        this.answer = answer;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.usergroup = usergroup;
        this.ward = ward;
        this.message = message;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public String getOffice_tel() {
        return office_tel;
    }

    public void setOffice_tel(String office_tel) {
        this.office_tel = office_tel;
    }

    public String getHome_tel() {
        return home_tel;
    }

    public void setHome_tel(String home_tel) {
        this.home_tel = home_tel;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public int getPassword_retries() {
        return password_retries;
    }

    public void setPassword_retries(int password_retries) {
        this.password_retries = password_retries;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReset_password_Key() {
        return reset_password_Key;
    }

    public void setReset_password_Key(String reset_password_Key) {
        this.reset_password_Key = reset_password_Key;
    }

    public String getTest_Question() {
        return test_Question;
    }

    public void setTest_Question(String test_Question) {
        this.test_Question = test_Question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(String usergroup) {
        this.usergroup = usergroup;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UsersModel{" + "firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname + ", office_tel=" + office_tel + ", home_tel=" + home_tel + ", last_login=" + last_login + ", password_retries=" + password_retries + ", designation=" + designation + ", email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword + ", status=" + status + ", reset_password_Key=" + reset_password_Key + ", test_Question=" + test_Question + ", answer=" + answer + ", dateCreated=" + dateCreated + ", dateModified=" + dateModified + ", usergroup=" + usergroup + ", ward=" + ward + ", message=" + message + '}';
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
   
    public boolean ValidateUser()
    {
        String Flag = "WHITE";
        if(this.firstname.equals("") || this.firstname == null)
        {
            Flag = "RED";
            this.firstnameError = "Provide Firstname";
        }
        
        if(this.middlename.equals("") || this.middlename == null)
        {
            Flag = "RED";
            this.middlenameError = "Provide Middle Name";
        }        
        
        if(this.lastname.equals("") || this.lastname == null)
        {
            Flag = "RED";
            this.lastnameError = "Provide Last Name";
        }        
        
        if(this.office_tel.equals("") || this.office_tel == null)
        {
            Flag = "RED";
            this.office_telError = "Provide Office Tel";
        }        
        
        if(this.home_tel.equals("") || this.home_tel == null)
        {
            Flag = "RED";
            this.home_telError = "Provide Home Tel";
        }        
        
        if(this.password_retries == 3)
        {
            Flag = "RED";
            this.password_retriesError = "System locked";
        }        
        
        if(this.designation.equals("") || this.designation == null)
        {
            Flag = "RED";
            this.designationError = "Provide Location";
        }        
        
        if(this.email.equals("") || this.email == null)
        {
            Flag = "RED";
            this.emailError = "Provide Email";
        }        
        
        if(this.password.equals("") || this.password == null)
        {
            Flag = "RED";
            this.passwordError = "Provide Password";
        }    
        
        if(!this.password.equals(this.confirmPassword))
        {
            Flag = "RED";
            this.passwordError = "Password Do not Match";
            this.confirmPasswordError = "Password Do not Match";                
        }
        else
        {
            this.confirmPasswordError = "Confirm Password"; 
        }
        
        if(this.confirmPassword.equals("") || this.confirmPassword == null)
        {
            Flag = "RED";
            this.confirmPasswordError = "Provide Password";
        } 
        
        if(this.test_Question.equals("") || this.test_Question == null)
        {
            Flag = "RED";
            this.test_QuestionError = "Provide Question";
        }        
        
        if(this.answer.equals("") || this.answer == null)
        {
            Flag = "RED";
            this.answerError = "Provide Answer";
        }        
        
        if(this.usergroup.equals("") || this.usergroup == null)
        {
            Flag = "RED";
            this.usergroupError = "Provide User Group";
        }        
        
        if(this.ward.equals("") || this.ward == null)
        {
            Flag = "RED";
            this.wardError = "Provide Ward";
        }        

        if(Flag.equals("RED"))
        {
            this.message = "Correct the errors";
            return false;
        }
    
        return true;
    }    
}
