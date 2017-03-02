/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.WardModel;

import java.util.Collection;
import java.util.Vector;

/**
 *
 * @author Xavier Khonje
 */
public class ItemsModel {
    private int id;
    private String name;
    private int amount;

    public ItemsModel() {
    }

    public ItemsModel(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
    public static Collection GetItemsCollection()
    {
        Vector collect = new Vector();
        
        collect.add(new ItemsModel(1,"Panado", 200));
        collect.add(new ItemsModel(1,"Aspirin", 6454));
        collect.add(new ItemsModel(1,"Paracetamol", 32));
        collect.add(new ItemsModel(1,"Magnesium", 767));
        collect.add(new ItemsModel(1,"Panado", 23));
        collect.add(new ItemsModel(1,"Gentamicin", 454));        
        
        return collect;
    }    
    
}
