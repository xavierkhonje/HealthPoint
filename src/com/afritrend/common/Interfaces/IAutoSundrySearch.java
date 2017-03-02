/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.Interfaces;

import com.afritrend.common.Model.SundryItemModel;
import java.util.List;

/**
 * 
 * @author Xavier Khonje
 */
public interface IAutoSundrySearch {
    List<String> GetSundryClass();   
    List<String> GetSundryCode(String ItemClass);
    List<String> GetSundryName(String ItemCode);
    List<String> GetSundryIssueUnit(String SundryName);    
    List<String> GetSundryDescription();    
}
