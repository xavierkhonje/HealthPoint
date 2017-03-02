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
public class ItemEWP implements Serializable, Cloneable{
    private String todayDate;
    private String expiryDate;
    private int expiryWarningPeriod;
    private int agingPeriod;
    private String status;

    public ItemEWP() {
    }

    public ItemEWP(String todayDate, String expiryDate, int expiryWarningPeriod, int agingPeriod, String status) {
        this.todayDate = todayDate;
        this.expiryDate = expiryDate;
        this.expiryWarningPeriod = expiryWarningPeriod;
        this.agingPeriod = agingPeriod;
        this.status = status;
    }

    public String getTodayDate() {
        return todayDate;
    }

    public void setTodayDate(String todayDate) {
        this.todayDate = todayDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getExpiryWarningPeriod() {
        return expiryWarningPeriod;
    }

    public void setExpiryWarningPeriod(int expiryWarningPeriod) {
        this.expiryWarningPeriod = expiryWarningPeriod;
    }

    public int getAgingPeriod() {
        return agingPeriod;
    }

    public void setAgingPeriod(int agingPeriod) {
        this.agingPeriod = agingPeriod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ItemEWP{" + "todayDate=" + todayDate + ", expiryDate=" + expiryDate + ", expiryWarningPeriod=" + expiryWarningPeriod + ", agingPeriod=" + agingPeriod + ", status=" + status + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
