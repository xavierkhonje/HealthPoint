/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardInterfaces;

import com.afritrend.PharmacyModel.WardModel;
import com.afritrend.WardModel.wardUser;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public interface Iward {
    String saveWard(WardModel ward);
    List<WardModel> getWardDetails();
    List<wardUser> getWardUsers(String WardName);
}
