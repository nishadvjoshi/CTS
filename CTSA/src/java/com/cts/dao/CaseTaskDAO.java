/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.dao;

/**
 *
 * @author Admin
 */
import com.cts.model.Advocate;
import com.cts.model.Client;
import java.sql.*;
import java.util.*;
import com.cts.model.TaskMaster;
import com.cts.util.Database;

public class CaseTaskDAO {
    private Connection connection;

    public CaseTaskDAO() {
        connection = Database.getConnection();
    }
    
     public List<Advocate> getAllAdvocate() {
        List<Advocate> advocates = new ArrayList<Advocate>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_madvocates Order by cam_ID");
            while (rs.next()) {
                Advocate advocate = new Advocate();

                advocate.setCam_ID(rs.getInt("cam_ID"));
                advocate.setCam_FirstName(rs.getString("cam_FirstName"));
                advocate.setCam_EmailID1(rs.getString("cam_EmailID1"));
                advocates.add(advocate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return advocates;
    }
     
     public void addCaseTaskMaster(TaskMaster taskmaster) {                  
        
         try {
             
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO cts_taskmaster (ctm_TaskName,ctm_TaskDescription,ctm_TaskAssignedTo,ctm_TaskAssignToID,ctm_TaskAssignedBy,ctm_TaskAssignByID,ctm_TaskAssignDate,ctm_ActiveFlag,ctm_DeleteFlag,ctm_CreateDate,ctm_CreateUser,ctm_ModifyDate,ctm_ModifyUser,ctm_TaskLocation,ctm_TaskPriority, ctm_TaskCompletionDate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, taskmaster.getCtm_TaskName());
            preparedStatement.setString(2, taskmaster.getCtm_TaskDescription());
            preparedStatement.setString(3, taskmaster.getCtm_TaskAssignedTo());
            preparedStatement.setInt(4, taskmaster.getCtm_TaskAssignToID());
            preparedStatement.setString(5, taskmaster.getCtm_TaskAssignedBy());
            preparedStatement.setInt(6, taskmaster.getCtm_TaskAssignByID());
            preparedStatement.setDate(7, new java.sql.Date(taskmaster.getCtm_TaskAssignDate().getTime()));
            preparedStatement.setBoolean(8, taskmaster.isCtm_ActiveFlag());
            preparedStatement.setBoolean(9, taskmaster.isCtm_DeleteFlag());
            
            
            preparedStatement.setDate(10, new java.sql.Date(taskmaster.getCtm_CreateDate().getTime()));
            preparedStatement.setInt(11, taskmaster.getCtm_CreateUser());
            preparedStatement.setDate(12, new java.sql.Date(taskmaster.getCtm_ModifyDate().getTime()));
            preparedStatement.setInt(13, taskmaster.getCtm_ModifyUser());
            preparedStatement.setString(14, taskmaster.getCtm_TaskLocation());
            preparedStatement.setString(15, taskmaster.getCtm_TaskPriority());
            preparedStatement.setDate(16, new java.sql.Date(taskmaster.getCtm_TaskCompletionDate().getTime()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
     public List<TaskMaster> getAllTasks() {
        List<TaskMaster> taskmasters = new ArrayList<TaskMaster>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT ctm_ID,ctm_TaskName,ctm_TaskDescription,ctm_TaskAssignedTo,ctm_TaskCompletionDate, ctm_TaskAssignToID,ctm_TaskAssignedBy,ctm_TaskAssignByID,ctm_TaskAssignDate,ctm_ActiveFlag,ctm_DeleteFlag,ctm_CreateDate,ctm_CreateUser,ctm_ModifyDate,ctm_ModifyUser, ctm_TaskLocation,ctm_TaskPriority FROM cts_taskmaster where ctm_DeleteFlag = 0 ORDER BY ctm_TaskAssignDate DESC");
            while (rs.next()) {
                TaskMaster taskmaster = new TaskMaster();

                taskmaster.setCtm_ID(rs.getInt("ctm_ID"));
                taskmaster.setCtm_TaskName(rs.getString("ctm_TaskName"));
                taskmaster.setCtm_TaskDescription(rs.getString("ctm_TaskDescription"));
                taskmaster.setCtm_TaskAssignedTo(rs.getString("ctm_TaskAssignedTo"));
                taskmaster.setCtm_TaskAssignToID(rs.getInt("ctm_TaskAssignToID"));
                taskmaster.setCtm_TaskAssignedBy(rs.getString("ctm_TaskAssignedBy"));
                taskmaster.setCtm_TaskAssignByID(rs.getInt("ctm_TaskAssignByID"));
                taskmaster.setCtm_TaskAssignDate(rs.getDate("ctm_TaskAssignDate")); 
                taskmaster.setCtm_TaskLocation(rs.getString("ctm_TaskLocation"));
                taskmaster.setCtm_TaskLocation(rs.getString("ctm_TaskPriority"));
                taskmaster.setCtm_TaskCompletionDate(rs.getDate("ctm_TaskCompletionDate"));

                taskmasters.add(taskmaster);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return taskmasters;
    }
     
     public List<TaskMaster> getUserWeeklyTasks(int TaskAssignToID) {
        List<TaskMaster> mytasklist = new ArrayList<TaskMaster>();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT ctm_ID,ctm_TaskName,ctm_TaskDescription,ctm_TaskAssignedTo,ctm_TaskCompletionDate, ctm_TaskAssignToID,ctm_TaskAssignedBy,ctm_TaskAssignByID,ctm_TaskAssignDate,ctm_ActiveFlag,ctm_DeleteFlag,ctm_CreateDate,ctm_CreateUser,ctm_ModifyDate,ctm_ModifyUser, ctm_TaskLocation,ctm_TaskPriority FROM cts_taskmaster where ctm_DeleteFlag = 0 AND ctm_TaskAssignToID = ? and yearweek(date_format(ctm_TaskAssignDate, '%Y-%m-%d')) = yearweek(date_format(curdate(), '%Y-%m-%d') )");
            // Parameters start with 1
            preparedStatement.setInt(1, TaskAssignToID);
            ResultSet rs = preparedStatement.executeQuery();
     
            while (rs.next()) {
                TaskMaster mytask = new TaskMaster();

                mytask.setCtm_ID(rs.getInt("ctm_ID"));
                mytask.setCtm_TaskName(rs.getString("ctm_TaskName"));
                mytask.setCtm_TaskDescription(rs.getString("ctm_TaskDescription"));
                mytask.setCtm_TaskAssignedTo(rs.getString("ctm_TaskAssignedTo"));
                mytask.setCtm_TaskAssignToID(rs.getInt("ctm_TaskAssignToID"));
                mytask.setCtm_TaskAssignedBy(rs.getString("ctm_TaskAssignedBy"));
                mytask.setCtm_TaskAssignByID(rs.getInt("ctm_TaskAssignByID"));
                mytask.setCtm_TaskAssignDate(rs.getDate("ctm_TaskAssignDate")); 
                mytask.setCtm_TaskLocation(rs.getString("ctm_TaskLocation"));
                mytask.setCtm_TaskLocation(rs.getString("ctm_TaskPriority"));
                mytask.setCtm_TaskCompletionDate(rs.getDate("ctm_TaskCompletionDate"));
                    

                mytasklist.add(mytask);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mytasklist;
    }
     
     public TaskMaster getDetailsByTaskID(int TaskID) {
        TaskMaster taskmaster = new TaskMaster();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT ctm_ID,ctm_TaskName,ctm_TaskDescription,ctm_TaskAssignedTo,ctm_TaskCompletionDate,ctm_TaskAssignToID,ctm_TaskAssignedBy,ctm_TaskAssignByID,ctm_TaskAssignDate,ctm_ActiveFlag,ctm_DeleteFlag,ctm_CreateDate,ctm_CreateUser,ctm_ModifyDate,ctm_ModifyUser, ctm_TaskLocation,ctm_TaskPriority FROM cts_taskmaster where ctm_DeleteFlag = 0 AND ctm_ID = ? ");
            // Parameters start with 1
            preparedStatement.setInt(1, TaskID);
            ResultSet rs = preparedStatement.executeQuery();
     
            while (rs.next()) {
                

                taskmaster.setCtm_ID(rs.getInt("ctm_ID"));
                taskmaster.setCtm_TaskName(rs.getString("ctm_TaskName"));
                taskmaster.setCtm_TaskDescription(rs.getString("ctm_TaskDescription"));
                taskmaster.setCtm_TaskAssignedTo(rs.getString("ctm_TaskAssignedTo"));
                taskmaster.setCtm_TaskAssignToID(rs.getInt("ctm_TaskAssignToID"));
                taskmaster.setCtm_TaskAssignedBy(rs.getString("ctm_TaskAssignedBy"));
                taskmaster.setCtm_TaskAssignByID(rs.getInt("ctm_TaskAssignByID"));
                taskmaster.setCtm_TaskAssignDate(rs.getDate("ctm_TaskAssignDate")); 
                taskmaster.setCtm_TaskLocation(rs.getString("ctm_TaskLocation"));
                taskmaster.setCtm_TaskLocation(rs.getString("ctm_TaskPriority"));
                taskmaster.setCtm_TaskCompletionDate(rs.getDate("ctm_TaskCompletionDate"));
                    

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return taskmaster;
    }
     
      public List<TaskMaster> getUserAllTasks(int TaskAssignToID) {
        List<TaskMaster> mycompletetasklist = new ArrayList<TaskMaster>();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT ctm_ID,ctm_TaskName,ctm_TaskDescription,ctm_TaskCompletionDate,ctm_TaskAssignedTo,ctm_TaskAssignToID,ctm_TaskAssignedBy,ctm_TaskAssignByID,ctm_TaskAssignDate,ctm_ActiveFlag,ctm_DeleteFlag,ctm_CreateDate,ctm_CreateUser,ctm_ModifyDate,ctm_ModifyUser, ctm_TaskLocation,ctm_TaskPriority FROM cts_taskmaster where ctm_DeleteFlag = 0 AND ctm_TaskAssignToID = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, TaskAssignToID);
            ResultSet rs = preparedStatement.executeQuery();
     
            while (rs.next()) {
                TaskMaster mytask = new TaskMaster();

                mytask.setCtm_ID(rs.getInt("ctm_ID"));
                mytask.setCtm_TaskName(rs.getString("ctm_TaskName"));
                mytask.setCtm_TaskDescription(rs.getString("ctm_TaskDescription"));
                mytask.setCtm_TaskAssignedTo(rs.getString("ctm_TaskAssignedTo"));
                mytask.setCtm_TaskAssignToID(rs.getInt("ctm_TaskAssignToID"));
                mytask.setCtm_TaskAssignedBy(rs.getString("ctm_TaskAssignedBy"));
                mytask.setCtm_TaskAssignByID(rs.getInt("ctm_TaskAssignByID"));
                mytask.setCtm_TaskAssignDate(rs.getDate("ctm_TaskAssignDate")); 
                mytask.setCtm_TaskLocation(rs.getString("ctm_TaskLocation"));
                mytask.setCtm_TaskLocation(rs.getString("ctm_TaskPriority"));
                mytask.setCtm_TaskCompletionDate(rs.getDate("ctm_TaskCompletionDate"));

                mycompletetasklist.add(mytask);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mycompletetasklist;
    }
     
     
     public void deleteCaseTask(int TaskID) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE cts_taskmaster SET ctm_DeleteFlag = 1 Where ctm_ID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, TaskID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
     public TaskMaster WeeklyTaskCountByID(int TaskAssignToID) {
        TaskMaster weeklytaskcount = new TaskMaster();
        try {
            
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT count(*) AS ctm_WeeklyTaskCount FROM cts_taskmaster where ctm_TaskAssignToID = ? and yearweek(date_format(ctm_TaskAssignDate, '%Y-%m-%d')) = yearweek(date_format(curdate(), '%Y-%m-%d') )");
            // Parameters start with 1
            preparedStatement.setInt(1, TaskAssignToID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                
                weeklytaskcount.setCtm_WeeklyTaskCount(rs.getInt("ctm_WeeklyTaskCount"));
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return weeklytaskcount;
    }
     
      public Advocate getAdvocateById(int AdvocateID) {
        Advocate advocate = new Advocate();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from cts_madvocates where cam_ID=?");
            preparedStatement.setInt(1, AdvocateID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                advocate.setCam_ID(rs.getInt("cam_ID"));               
                advocate.setCam_FirstName(rs.getString("cam_FirstName"));                               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return advocate;
    }

    public void addCaseTaskUpdate(TaskMaster taskmaster) {                  
        
         try {
             
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO cts_taskupdates (ctu_ID,ctm_ID,ctu_TaskUpdate,ctu_TaskUpdateDate,ctu_TaskStatus,ctu_CreateDate,ctu_CreateUser,ctu_ModifyDate,ctu_ModifyUser,ctu_ActiveFlag,ctu_DeleteFlag) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            // Parameters start with 1
            
            preparedStatement.setInt(1, taskmaster.getCtu_ID());
            preparedStatement.setInt(2, taskmaster.getCtm_ID());
            
            preparedStatement.setString(3, taskmaster.getCtu_TaskUpdate());
            preparedStatement.setDate(4, new java.sql.Date(taskmaster.getCtu_TaskUpdateDate().getTime()));
            preparedStatement.setString(5, taskmaster.getCtu_TaskStatus());
            
            preparedStatement.setDate(6, new java.sql.Date(taskmaster.getCtu_CreateDate().getTime()));
            preparedStatement.setInt(7, taskmaster.getCtu_CreateUser());
            preparedStatement.setDate(8, new java.sql.Date(taskmaster.getCtu_ModifyDate().getTime()));
            preparedStatement.setInt(9, taskmaster.getCtu_ModifyUser());
            preparedStatement.setBoolean(10, taskmaster.isCtm_ActiveFlag());
            preparedStatement.setBoolean(11, taskmaster.isCtm_DeleteFlag());
            
            
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<TaskMaster> getAllTaskUpdates(int TaskID) {
        List<TaskMaster> taskupdates = new ArrayList<TaskMaster>();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT ctu_ID,ctm_ID,ctu_TaskUpdate,ctu_TaskUpdateDate,ctu_TaskStatus,ctu_CreateDate,ctu_CreateUser,ctu_ModifyDate,ctu_ModifyUser,ctu_ActiveFlag,ctu_DeleteFlag FROM cts_taskupdates where ctm_ID = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, TaskID);
            ResultSet rs = preparedStatement.executeQuery();
     
            while (rs.next()) {
                TaskMaster taskupdate = new TaskMaster();
                taskupdate.setCtu_ID(rs.getInt("ctu_ID"));
                taskupdate.setCtm_ID(rs.getInt("ctm_ID"));
                taskupdate.setCtu_TaskUpdate(rs.getString("ctu_TaskUpdate"));
                taskupdate.setCtu_TaskUpdateDate(rs.getDate("ctu_TaskUpdateDate"));
                taskupdate.setCtu_TaskStatus(rs.getString("ctu_TaskStatus"));
                
                taskupdates.add(taskupdate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return taskupdates;
    }
    
    
     public void updateTask(TaskMaster taskmaster) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE cts_taskmaster SET ctm_TaskName = ?, ctm_TaskDescription = ?, ctm_TaskAssignedTo = ?, ctm_TaskAssignToID = ?, ctm_TaskAssignedBy = ?, ctm_TaskAssignByID = ?, ctm_TaskAssignDate = ?, ctm_ActiveFlag = ?, ctm_DeleteFlag = ?, ctm_CreateDate = ?, ctm_CreateUser = ?, ctm_ModifyDate = ?, ctm_ModifyUser = ?, ctm_TaskLocation = ?, ctm_TaskPriority = ?, ctm_TaskCompletionDate = ? WHERE ctm_ID = ?");
            // Parameters start with 1
            preparedStatement.setString(1, taskmaster.getCtm_TaskName());
            preparedStatement.setString(2, taskmaster.getCtm_TaskDescription());
            preparedStatement.setString(3, taskmaster.getCtm_TaskAssignedTo());
            preparedStatement.setInt(4,taskmaster.getCtm_TaskAssignToID());
            preparedStatement.setString(5, taskmaster.getCtm_TaskAssignedBy());
            preparedStatement.setInt(6,taskmaster.getCtm_TaskAssignByID());
            preparedStatement.setDate(7, new java.sql.Date(taskmaster.getCtm_TaskAssignDate().getTime()));
            preparedStatement.setBoolean(8, taskmaster.isCtm_ActiveFlag());
            preparedStatement.setBoolean(9, taskmaster.isCtm_DeleteFlag());
            preparedStatement.setDate(10, new java.sql.Date(taskmaster.getCtm_CreateDate().getTime()));
            preparedStatement.setInt(11, taskmaster.getCtm_CreateUser());
            preparedStatement.setDate(12, new java.sql.Date(taskmaster.getCtm_ModifyDate().getTime()));
            preparedStatement.setInt(13, taskmaster.getCtm_ModifyUser());
            preparedStatement.setString(14, taskmaster.getCtm_TaskLocation());
            preparedStatement.setString(15, taskmaster.getCtm_TaskPriority());
            preparedStatement.setDate(16, new java.sql.Date(taskmaster.getCtm_TaskCompletionDate().getTime()));
            
            preparedStatement.setInt(17, taskmaster.getCtm_ID());
           
            
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
       
     }   
     
}
