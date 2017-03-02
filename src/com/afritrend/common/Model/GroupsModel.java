/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.Model;

import java.io.Serializable;

/**
 *
 * @author Xavier
 */
public class GroupsModel implements Serializable, Cloneable{
    
    private int idGroups;
    private String groupname;
    private String role;
    private String status;
    private String description;
    private int accesslevel;
    private String datecreated;
    private String datemodified;
    private String createdby;

    public GroupsModel() {
    }

    public GroupsModel(int idGroups, String groupname, String role, String status, String description, int accesslevel, String datecreated, String datemodified, String createdby) {
        this.idGroups = idGroups;
        this.groupname = groupname;
        this.role = role;
        this.status = status;
        this.description = description;
        this.accesslevel = accesslevel;
        this.datecreated = datecreated;
        this.datemodified = datemodified;
        this.createdby = createdby;
    }

    public int getIdGroups() {
        return idGroups;
    }

    public void setIdGroups(int idGroups) {
        this.idGroups = idGroups;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(int accesslevel) {
        this.accesslevel = accesslevel;
    }

    public String getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(String datecreated) {
        this.datecreated = datecreated;
    }

    public String getDatemodified() {
        return datemodified;
    }

    public void setDatemodified(String datemodified) {
        this.datemodified = datemodified;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    @Override
    public String toString() {
        return "GroupsModel{" + "idGroups=" + idGroups + ", groupname=" + groupname + ", role=" + role + ", status=" + status + ", description=" + description + ", accesslevel=" + accesslevel + ", datecreated=" + datecreated + ", datemodified=" + datemodified + ", createdby=" + createdby + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
