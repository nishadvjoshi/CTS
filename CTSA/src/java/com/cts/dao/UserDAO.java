/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.dao;

/**
 *
 * @author nishad
 */

import com.cts.model.Advocate;
import com.cts.model.CaseStage;
import com.cts.model.Client;
import com.cts.model.User;
import java.sql.*;
import java.util.*;
import com.cts.model.User;

import com.cts.util.Database;

public class UserDAO {
    private Connection connection;
    
     public UserDAO() {
        connection = Database.getConnection();
    }
     
     public List<User> getAllUser() {
            List<User> users = new ArrayList<User>();
            try {
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery("select * from cts_musers");
                    while (rs.next()) {
                        User user = new User();
                                           
                        user.setCmu_ID(rs.getInt("cmu_ID"));
                        user.setCmu_CreateUser(rs.getInt("cmu_CreateUser"));
                        user.setCmu_ModifyUser(rs.getInt("cmu_ModifyUser"));
                        
                        user.setCmu_ActiveFlag(rs.getBoolean("cmu_ActiveFlag"));
                        user.setCmu_DeleteFlag(rs.getBoolean("cmu_DeleteFlag"));
                        
                        user.setCmu_CreateDate(rs.getDate("cmu_CreateDate"));
                        user.setCmu_ModifyDate(rs.getDate("cmu_ModifyDate"));
                        
                        user.setCmu_FirstName(rs.getString("cmu_FirstName"));
                        user.setCmu_LastName(rs.getString("cmu_LastName"));
                        user.setCmu_UserName(rs.getString("cmu_UserName"));
                        user.setCmu_Password(rs.getString("cmu_Role"));
                        user.setCmu_Password(rs.getString("cmu_Password"));
                        
                        users.add(user);
            }
        }
            catch (SQLException e) {
            e.printStackTrace();
            }
 
            return users;
        }
     
     // after adding user  record showing in descending order 
     
       public List<User> getAllUserDesc() {
            List<User> users = new ArrayList<User>();
            try {
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery("select * from cts_musers order by cmu_ModifyDate desc");
                    while (rs.next()) {
                        User user = new User();
                                           
                        user.setCmu_ID(rs.getInt("cmu_ID"));
                        user.setCmu_CreateUser(rs.getInt("cmu_CreateUser"));
                        user.setCmu_ModifyUser(rs.getInt("cmu_ModifyUser"));
                        
                        user.setCmu_ActiveFlag(rs.getBoolean("cmu_ActiveFlag"));
                        user.setCmu_DeleteFlag(rs.getBoolean("cmu_DeleteFlag"));
                        
                        user.setCmu_CreateDate(rs.getDate("cmu_CreateDate"));
                        user.setCmu_ModifyDate(rs.getDate("cmu_ModifyDate"));
                        
                        user.setCmu_FirstName(rs.getString("cmu_FirstName"));
                        user.setCmu_LastName(rs.getString("cmu_LastName"));
                        user.setCmu_UserName(rs.getString("cmu_UserName"));
                        user.setCmu_Password(rs.getString("cmu_Role"));
                        user.setCmu_Password(rs.getString("cmu_Password"));
                        
                        users.add(user);
            }
        }
            catch (SQLException e) {
            e.printStackTrace();
            }
 
            return users;
        }
     
     public void deleteUser(int userID) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from cts_musers where cmu_ID=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userID);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}   
     
     public int addUser(User user) {
          int i=0;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO case_tracking_system.cts_musers (cmu_ActiveFlag, cmu_CreateDate, cmu_CreateUser, cmu_DeleteFlag, cmu_FirstName, cmu_Role, cmu_LastName, cmu_ModifyDate, cmu_ModifyUser, cmu_Password, cmu_UserName, cmu_ClientID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			// Parameters start with 1
			preparedStatement.setBoolean(1, user.isCmu_ActiveFlag());
                        preparedStatement.setDate(2, new java.sql.Date(user.getCmu_CreateDate().getTime()));
			preparedStatement.setInt(3, user.getCmu_CreateUser());
                        preparedStatement.setBoolean(4, user.isCmu_DeleteFlag());
                        	
                        preparedStatement.setString(5, user.getCmu_FirstName());
			preparedStatement.setString(6, user.getCmu_Role());
                        preparedStatement.setString(7, user.getCmu_LastName());
                        
                        preparedStatement.setDate(8, new java.sql.Date(user.getCmu_ModifyDate().getTime()));
			preparedStatement.setInt(9, user.getCmu_ModifyUser());
                        
                        preparedStatement.setString(10, user.getCmu_Password());
                        preparedStatement.setString(11, user.getCmu_UserName());
                        preparedStatement.setInt(12, user.getCmu_ClientID());
                        
			
			i=preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
       
        return i;
	}
     
     public int updateUser(User user) {
         int i=0;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE case_tracking_system.cts_musers SET cmu_ActiveFlag = ?, cmu_CreateDate = ?,cmu_CreateUser = ?, cmu_DeleteFlag = ?, cmu_FirstName = ?, cmu_Role = ?, cmu_LastName = ?, cmu_ModifyDate = ?, cmu_ModifyUser = ?, cmu_Password = ?, cmu_UserName = ?, cmu_ClientID = ? WHERE cmu_ID = ?");
			// Parameters start with 1
			preparedStatement.setBoolean(1, user.isCmu_ActiveFlag());
                        preparedStatement.setDate(2, new java.sql.Date(user.getCmu_CreateDate().getTime()));
			preparedStatement.setInt(3, user.getCmu_CreateUser());
                        preparedStatement.setBoolean(4, user.isCmu_DeleteFlag());
                        	
                        preparedStatement.setString(5, user.getCmu_FirstName());
			preparedStatement.setString(6, user.getCmu_Role());
                        preparedStatement.setString(7, user.getCmu_LastName());
                        
                        preparedStatement.setDate(8, new java.sql.Date(user.getCmu_ModifyDate().getTime()));
			preparedStatement.setInt(9, user.getCmu_ModifyUser());
                        
                        preparedStatement.setString(10, user.getCmu_Password());
                        preparedStatement.setString(11, user.getCmu_UserName());
                        preparedStatement.setInt(12, user.getCmu_ClientID());
                        
                        preparedStatement.setInt(13, user.getCmu_ID());
			
                           i = preparedStatement.executeUpdate();
        if (i > 0) {
            System.out.println("success");
           
        } else {
            System.out.println("stuck somewhere");
        }

		} catch (SQLException e) {
			e.printStackTrace();
		}
        return i;
	}
     
     public void updateUserPassword(User user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE case_tracking_system.cts_musers SET cmu_ActiveFlag = ?, cmu_CreateDate = ?,cmu_CreateUser = ?, cmu_DeleteFlag = ?, cmu_ModifyDate = ?, cmu_ModifyUser = ?, cmu_Password = ? WHERE cmu_ID = ?");
			// Parameters start with 1
			preparedStatement.setBoolean(1, user.isCmu_ActiveFlag());
                        preparedStatement.setDate(2, new java.sql.Date(user.getCmu_CreateDate().getTime()));
			preparedStatement.setInt(3, user.getCmu_CreateUser());
                        preparedStatement.setBoolean(4, user.isCmu_DeleteFlag());
                        	
                        preparedStatement.setDate(5, new java.sql.Date(user.getCmu_ModifyDate().getTime()));
			preparedStatement.setInt(6, user.getCmu_ModifyUser());
                        
                        preparedStatement.setString(7, user.getCmu_Password());
                        
                        
                        preparedStatement.setInt(8, user.getCmu_ID());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
     
      public User getUserById(int userID) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from cts_musers where cmu_ID=?");
			preparedStatement.setInt(1, userID);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
                            System.out.println("");
				 user.setCmu_ID(rs.getInt("cmu_ID"));
                        user.setCmu_CreateUser(rs.getInt("cmu_CreateUser"));
                        user.setCmu_ModifyUser(rs.getInt("cmu_ModifyUser"));
                        
                        user.setCmu_ActiveFlag(rs.getBoolean("cmu_ActiveFlag"));
                        user.setCmu_DeleteFlag(rs.getBoolean("cmu_DeleteFlag"));
                        
                        user.setCmu_CreateDate(rs.getDate("cmu_CreateDate"));
                        user.setCmu_ModifyDate(rs.getDate("cmu_ModifyDate"));
                        
                        user.setCmu_FirstName(rs.getString("cmu_FirstName"));
                        user.setCmu_LastName(rs.getString("cmu_LastName"));
                        user.setCmu_UserName(rs.getString("cmu_UserName"));
                        user.setCmu_Role(rs.getString("cmu_Role"));
                        user.setCmu_Password(rs.getString("cmu_Password"));
                        
                                
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
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
     public List<Client> getAllClient() {
        List<Client> clients = new ArrayList<Client>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_mclients");
            while (rs.next()) {
                Client client = new Client();

                client.setCmc_ID(rs.getInt("cmc_ID"));                
                client.setCmc_FirstName(rs.getString("cmc_FirstName"));                
                client.setCmc_ClientType(rs.getString("cmc_ClientType"));
                client.setCmc_OrgName(rs.getString("cmc_OrgName"));                               
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

    public int updateUserById(User user) {
      int i=0;
        
        try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE case_tracking_system.cts_musers SET  cmu_Password = ?, cmu_FirstName = ?,cmu_LastName = ? WHERE cmu_UserName = ? and cmu_ID = ?");
			// Parameters start with 1
			
                    
			preparedStatement.setString(1, user.getCmu_Password());
                        preparedStatement.setString(2, user.getCmu_FirstName());
                        	
                       System.out.println(user.getCmu_Password());
                       System.out.println(user.getCmu_FirstName());
                       System.out.println(user.getCmu_LastName());
                       System.out.println(user.getCmu_UserName());
                       
                        preparedStatement.setString(3, user.getCmu_LastName());
                        
                        preparedStatement.setString(4, user.getCmu_UserName());
                        preparedStatement.setInt(5, user.getCmu_ID());
			i=preparedStatement.executeUpdate();
                        if(i>0)
                        {
                            System.out.println("success");
                            i=1;
                        }
                        else
                        {
                                                        System.out.println("fail");
                                                        i=0;
                        }

		} catch (SQLException e) {
			e.printStackTrace();
                                                    System.out.println(e);

		}
        return i;
    }

}
