/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.DataAccess;

import com.afritrend.common.Interfaces.Igroups;
import com.afritrend.common.Model.GroupsModel;
import com.afritrend.common.config;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Xavier
 */
public class GroupsDataAccess implements Igroups{

    config config = new config();
    Connection conn = null;
    Statement stmt = null;  
    
    Date date = new Date();   
    
    @Override
    public String SaveGroups(GroupsModel groups) {
        return "";
    }

    @Override
    public String UpdateGroups(GroupsModel groups) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GroupsModel> ViewGroups() {
        config config = new config();
        Connection conn = null;
        Statement stmt = null;         
        List<GroupsModel> list = new ArrayList();
        try
        {
            conn = config.DBConnect();       
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `groups`";
            ResultSet rs = stmt.executeQuery(sql);

            //get all data rows and put them in a list
                while(rs.next())
                {               	
                    GroupsModel group = new GroupsModel();
                    
//                    group.setIdstudent(rs.getInt("idstudent"));
//                    group.setStudentName(rs.getString("studentName"));
//                    group.setDistrictofOrigin(rs.getString("DistrictofOrigin"));
//                    group.setDayofbirth(rs.getString("dayofbirth"));                    
//                    group.setMonthofbirth(rs.getString("monthofbirth"));
//                    group.setYearofbirth(rs.getString("yearofbirth")); 
//                    group.setFirstyear(rs.getString("firstyear"));
//                    group.setDistrictname(rs.getString("districtname"));
//                    group.setCentrename(rs.getString("centrename"));                  
//                    
                    list.add(group);
                }              
            conn.close();
        }
        catch(Exception ex)
        {
            ex.getMessage();
        }  
        finally
        { 
            
        }                  
        return list;         
    }

    @Override
    public String DeactivateGroups(GroupsModel groups) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer SearchGroupsID(String criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
