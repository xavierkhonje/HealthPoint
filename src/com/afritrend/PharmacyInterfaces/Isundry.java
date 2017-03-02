/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyInterfaces;

import com.afritrend.PharmacyModel.SundryModel;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public interface Isundry {
    String SaveSundry(SundryModel sundry);
    String ConvertSundry(SundryModel sundry);
    List<SundryModel> SearchSundry();
    String DeactivateSundry(SundryModel sundry);
    String ActivateSundry(SundryModel sundry);
    String UpdateSundry(SundryModel sundry);
    String GetSundry(SundryModel sundry); 
    SundryModel GetSundryDetailsByCode(String sundrycmscode);
}
