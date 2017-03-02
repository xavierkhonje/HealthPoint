/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.Interfaces;

import com.afritrend.common.Model.SundryItemModel;

/**
 *
 * @author Xavier Khonje
 */
public interface ISundry {
    String SaveSundries(SundryItemModel sunds, String user, String Pharmact);
    String SaveWardSundry(SundryItemModel sunds, String user, String Ward, int Quantity, String Transaction);
    SundryItemModel GetSundryDetailsByCode(String drugcmscode);       
}
