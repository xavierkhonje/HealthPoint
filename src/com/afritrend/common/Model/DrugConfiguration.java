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
public class DrugConfiguration implements Serializable, Cloneable{
    private String cmscode;
    public String cmscodeError;
    private int minmumLevel;
    private String minimumLevelIn;
    public String minimumLevelError;
    private int maximumLevel;
    private String maximumLevelIn;
    public String maximumLevelError;
    private int ewd;    
    private String ewdIn;
    public String ewdError;
    private String message;

    public DrugConfiguration() {
    }

    public DrugConfiguration(String cmscode, int minmumLevel, int maximumLevel, int ewd) {
        this.cmscode = cmscode;
        this.minmumLevel = minmumLevel;
        this.maximumLevel = maximumLevel;
        this.ewd = ewd;
    }

    public String getCmscode() {
        return cmscode;
    }

    public void setCmscode(String cmscode) {
        this.cmscode = cmscode;
    }

    public String getMinimumLevelIn() {
        return minimumLevelIn;
    }

    public void setMinimumLevelIn(String minimumLevelIn) {
        this.minimumLevelIn = minimumLevelIn;
    }

    public String getMaximumLevelIn() {
        return maximumLevelIn;
    }

    public void setMaximumLevelIn(String maximumLevelIn) {
        this.maximumLevelIn = maximumLevelIn;
    }

    public String getEwdIn() {
        return ewdIn;
    }

    public void setEwdIn(String ewdIn) {
        this.ewdIn = ewdIn;
    }  
    
    public int getMinmumLevel() {
        return minmumLevel;
    }

    public void setMinmumLevel(int minmumLevel) {
        this.minmumLevel = minmumLevel;
    }

    public int getMaximumLevel() {
        return maximumLevel;
    }

    public void setMaximumLevel(int maximumLevel) {
        this.maximumLevel = maximumLevel;
    }

    public int getEwd() {
        return ewd;
    }

    public void setEwd(int ewd) {
        this.ewd = ewd;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DrugConfiguration{" + "cmscode=" + cmscode + ", minmumLevel=" + minmumLevel + ", maximumLevel=" + maximumLevel + ", ewd=" + ewd + ", message=" + message + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

   public boolean ValidateDrugSettings()
   {
       String Flag = "WHITE";
       if(this.cmscode.equals("") || this.cmscode == null || this.cmscode.equals("null"))
       {
           this.cmscodeError = "Choose cmsCode";
           Flag = "RED";
       }
       
       if(this.minimumLevelIn.equals("") || this.minimumLevelIn == null)
       {
           this.minimumLevelError = "Please Provide Min";
           Flag = "RED";
       }
       else
       {
           this.setMinmumLevel(Integer.valueOf(minimumLevelIn));           
           if(this.minmumLevel <= 0)
           {
               this.minimumLevelError = "Can not be less than 1";
               Flag = "RED";
           }           
       }
       
       if(this.maximumLevelIn.equals("") || this.maximumLevelIn == null)
       {
           this.maximumLevelError = "Please Provide Max";
           Flag = "RED";           
       }
       else
       {
           this.setMaximumLevel(Integer.valueOf(maximumLevelIn));
           if(this.maximumLevel <= 0)
           {
               this.maximumLevelError = "Can not be less than 1";
               Flag = "RED";
           }           
       }
       
       if(this.ewdIn.equals("") || this.ewdIn == null)
       {
           this.ewdError = "Please Provide EWD";
           Flag = "RED";
       }
       else
       {
           this.setEwd(Integer.valueOf(this.ewdIn));
           if(this.ewd <= 0)
           {
               this.ewdError = "Can not be less than 1";
               Flag = "RED";
           }
       }
       
       if(Flag == "RED")
       {
           this.message = "Fix Errors Above";
           return false;
       }
       
       return true;
   }

    
    
}
