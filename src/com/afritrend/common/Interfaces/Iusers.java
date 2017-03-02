/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.Interfaces;

import com.afritrend.WardModel.wardUser;
import com.afritrend.common.Model.UsersModel;
import java.util.List;

/**
 *
 * @author Xavier
 */
public interface Iusers {
    String Saveusers (UsersModel users);
    String SaveWardusers(wardUser users);
    String Updateusers(UsersModel users);   
    List<UsersModel> Viewusers();
    UsersModel Authenticateusers(String Email, String Password);
    String Deactivateusers(UsersModel users);  
    Integer SearchusersID (String criteria);      
}
