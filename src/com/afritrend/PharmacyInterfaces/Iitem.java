/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PharmacyInterfaces;

import com.afritrend.PharmacyModel.ItemModel;
import java.util.List;
/**
 *
 * @author Xavier Khonje
 */
public interface Iitem {
    
    String SaveItem(ItemModel item);
    String ConvertDrug(ItemModel item);
    String ConvertSundry(ItemModel item);
    List<ItemModel> SearchDrugs();
    String DeactivateItem(ItemModel item);
    String ActivateItem(ItemModel item);
    String UpdateItem(ItemModel item);
    String GetItem(ItemModel item);    
}
