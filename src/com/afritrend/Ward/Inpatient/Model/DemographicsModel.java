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
public class DemographicsModel 
{
    private String dateofbirth;
    private int age;
    private String dateofadmission;
    private int weight;
    private String gender;
    private String cultureAssessment;
    private String cultureResults;    
    
    public String dateofbirthError;
    public String ageError;
    public String dateofAdmissionError;
    public String weightError;
    public String genderError;
    public String cultureAssessmentError;
    public String cultureResultError;
    
    public DemographicsModel() {
    }

    public DemographicsModel(String dateofbirth, int age, String dateofadmission, int weight, String gender, String cultureAssessment, String cultureResults) {
        this.dateofbirth = dateofbirth;
        this.age = age;
        this.dateofadmission = dateofadmission;
        this.weight = weight;
        this.gender = gender;
        this.cultureAssessment = cultureAssessment;
        this.cultureResults = cultureResults;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateofadmission() {
        return dateofadmission;
    }

    public void setDateofadmission(String dateofadmission) {
        this.dateofadmission = dateofadmission;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCultureAssessment() {
        return cultureAssessment;
    }

    public void setCultureAssessment(String cultureAssessment) {
        this.cultureAssessment = cultureAssessment;
    }

    public String getCultureResults() {
        return cultureResults;
    }

    public void setCultureResults(String cultureResults) {
        this.cultureResults = cultureResults;
    }
    
    public boolean validateDemographics()
    {
        String Flag = "WHITE";

        if(this.dateofbirth.equals("") || this.dateofbirth == null)
        {
            Flag = "RED";
            this.dateofbirthError = "Please Supply Date of Birth";
        }

        if(this.age == 0)
        {
            Flag = "RED";
        }

        if(this.dateofadmission.equals("") || this.dateofadmission == null)
        {
            Flag = "RED";
            this.dateofAdmissionError = "Please Supply Date of Admission";
        }

        if(this.weight == 0)
        {
            Flag = "RED";
            this.weightError = "Please Supply Weight";
        }

        if(this.gender.equals("") || this.gender == null)
        {
            Flag = "RED";
            this.genderError = "Please Supply Gender";
        }

        if(this.cultureAssessment.equals("") || this.cultureAssessment == null)
        {
            Flag = "RED";
            this.cultureAssessmentError = "Please Supply Culture Assessment";        
        }

        if(this.cultureResults.equals("") || this.cultureResults == null)
        {
            Flag = "RED";
            this.cultureResultError = "Please Provide Culture Results";
        }

        if(Flag.equals("RED"))
        {
            return false;
        }

        return true;
    }
}
