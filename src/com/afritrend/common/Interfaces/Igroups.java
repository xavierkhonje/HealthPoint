/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.Interfaces;

import com.afritrend.common.Model.GroupsModel;
import java.util.List;

/**
 *
 * @author Xavier
 */
public interface Igroups {
    String SaveGroups (GroupsModel groups);
    String UpdateGroups(GroupsModel groups);   
    List<GroupsModel> ViewGroups();
    String DeactivateGroups(GroupsModel groups);  
    Integer SearchGroupsID (String criteria);      
}
