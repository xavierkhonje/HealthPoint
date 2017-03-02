/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.Ward.Factory;

import com.afritrend.WardModel.ItemsModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Xavier Khonje
 */
public class WardFactory {
        
    public List<ItemsModel> GetItemsCollection()
    {
        List<ItemsModel> collect = new ArrayList();
        
        collect.add(new ItemsModel(1,"Panado", 200));
        collect.add(new ItemsModel(1,"Aspirin", 6454));
        collect.add(new ItemsModel(1,"Paracetamol", 32));
        collect.add(new ItemsModel(1,"Magnesium", 767));
        collect.add(new ItemsModel(1,"Panado", 23));
        collect.add(new ItemsModel(1,"Gentamicin", 454));        
        
        return collect;
    }
}
