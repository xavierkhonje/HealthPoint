/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardInterfaces;


import com.afritrend.WardModel.DosageCodes;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public interface IDosageCodes {
    String SaveDosageCodes(DosageCodes dosecodes);
    List<DosageCodes> GetAllDoseCodes();
    List<String> GetCodes();
}
