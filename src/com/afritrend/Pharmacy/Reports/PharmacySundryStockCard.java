/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.Pharmacy.Reports;

import com.afritrend.PharmacyDataAccess.PharmacyReports;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Xavier Khonje
 */
public class PharmacySundryStockCard {
    private String sundryName;
    private String cmsCode;
    private String issueUnit;
    private int receivedAmount;
    private int issueAmount;
    private int lostAmount;
    private int expiredAmount;
    private int adjustedPlusAmount;
    private int adjustedMinusAmount;  

    public PharmacySundryStockCard() {
    }

    public PharmacySundryStockCard(String sundryName, String cmsCode, String issueUnit, int receivedAmount, int issueAmount, int lostAmount, int expiredAmount, int adjustedPlusAmount, int adjustedMinusAmount) {
        this.sundryName = sundryName;
        this.cmsCode = cmsCode;
        this.issueUnit = issueUnit;
        this.receivedAmount = receivedAmount;
        this.issueAmount = issueAmount;
        this.lostAmount = lostAmount;
        this.expiredAmount = expiredAmount;
        this.adjustedPlusAmount = adjustedPlusAmount;
        this.adjustedMinusAmount = adjustedMinusAmount;
    }

    public String getSundryName() {
        return sundryName;
    }

    public void setSundryName(String sundryName) {
        this.sundryName = sundryName;
    }

    public String getCmsCode() {
        return cmsCode;
    }

    public void setCmsCode(String cmsCode) {
        this.cmsCode = cmsCode;
    }

    public String getIssueUnit() {
        return issueUnit;
    }

    public void setIssueUnit(String issueUnit) {
        this.issueUnit = issueUnit;
    }

    public int getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(int receivedAmount) {
        this.receivedAmount = receivedAmount;
    }

    public int getIssueAmount() {
        return issueAmount;
    }

    public void setIssueAmount(int issueAmount) {
        this.issueAmount = issueAmount;
    }

    public int getLostAmount() {
        return lostAmount;
    }

    public void setLostAmount(int lostAmount) {
        this.lostAmount = lostAmount;
    }

    public int getExpiredAmount() {
        return expiredAmount;
    }

    public void setExpiredAmount(int expiredAmount) {
        this.expiredAmount = expiredAmount;
    }

    public int getAdjustedPlusAmount() {
        return adjustedPlusAmount;
    }

    public void setAdjustedPlusAmount(int adjustedPlusAmount) {
        this.adjustedPlusAmount = adjustedPlusAmount;
    }

    public int getAdjustedMinusAmount() {
        return adjustedMinusAmount;
    }

    public void setAdjustedMinusAmount(int adjustedMinusAmount) {
        this.adjustedMinusAmount = adjustedMinusAmount;
    }
    
    public static Collection PharmacySundryStockCardFactory()
    {
        
        Vector collection = new Vector();       
        try
        {
            //Get From Database store procedure and show
            PharmacyReports pharmacyrptdao = new PharmacyReports();
            List<PharmacySundryStockCard> stockcardlist = new ArrayList();
            stockcardlist = pharmacyrptdao.GetPharmacySundryStockcardReport("Antibiotic","Panado","12-12-12","12-12-12");

            Iterator<PharmacySundryStockCard> stockcardit = stockcardlist.iterator();
            while(stockcardit.hasNext())
            {
                PharmacySundryStockCard stockcard = new PharmacySundryStockCard();
                stockcard = stockcardit.next();

                collection.add(new PharmacySundryStockCard(
                stockcard.getSundryName(),
                stockcard.getCmsCode(),
                stockcard.getIssueUnit(),
                stockcard.getReceivedAmount(),
                stockcard.getIssueAmount(),
                stockcard.getLostAmount(),
                stockcard.getExpiredAmount(),
                stockcard.getAdjustedPlusAmount(),
                stockcard.getAdjustedMinusAmount()                
                ));                
            }
                
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return collection;

    }    
}
