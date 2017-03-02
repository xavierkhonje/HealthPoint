/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardInterfaces;

import com.afritrend.WardModel.ItemModel;
/**
 *
 * @author Xavier Khonje
 */
public interface Iitem {
    
    String SaveItem(ItemModel item);
    String GetItem(ItemModel item);
}
