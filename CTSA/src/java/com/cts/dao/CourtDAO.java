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

import com.cts.model.Court;
import java.sql.*;
import java.util.*;
import com.cts.model.Court;
import com.cts.util.Database;

public class CourtDAO {
    private Connection connection;
    
     public CourtDAO() {
        connection = Database.getConnection();
    }
     public List<Court> getAllCourt() {
            List<Court> courts = new ArrayList<Court>();
            try {
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery("select * from cts_mCourt");
                    while (rs.next()) {
                        Court court = new Court();
                   
                        court.setCcm_ID(rs.getInt("ccm_ID"));
                        court.setCcm_CreateUser(rs.getInt("ccm_CreateUser"));
                        court.setCcm_ModifyUser(rs.getInt("ccm_ModifyUser"));
                        
                        court.setCcm_CreateDate(rs.getDate("ccm_CreateDate"));
                        court.setCcm_ModifyDate(rs.getDate("ccm_ModifyDate"));
                        
                        court.setCcm_CourtName(rs.getString("ccm_CourtName"));
                        court.setCcm_Description(rs.getString("ccm_Description"));
                        court.setCcm_CourtType(rs.getString("ccm_CourtType"));
                        court.setCcm_CourtCity(rs.getString("ccm_CourtCity"));
                        court.setCcm_CourtState(rs.getString("ccm_CourtState"));
                        
                        court.setCcm_DeleteFlag(rs.getBoolean("ccm_DeleteFlag"));
                        court.setCcm_ActiveFlag(rs.getBoolean("ccm_ActiveFlag"));
                        
                        
                        
                        courts.add(court);
            }
        }
            catch (SQLException e) {
            e.printStackTrace();
            }
 
            return courts;
        }
     
     //order by desc
          public List<Court> getAllCourtDesc() {
            List<Court> courts = new ArrayList<Court>();
            try {
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery("select * from cts_mCourt order by ccm_ModifyDate desc");
                    while (rs.next()) {
                        Court court = new Court();
                   
                        court.setCcm_ID(rs.getInt("ccm_ID"));
                        court.setCcm_CreateUser(rs.getInt("ccm_CreateUser"));
                        court.setCcm_ModifyUser(rs.getInt("ccm_ModifyUser"));
                        
                        court.setCcm_CreateDate(rs.getDate("ccm_CreateDate"));
                        court.setCcm_ModifyDate(rs.getDate("ccm_ModifyDate"));
                        
                        court.setCcm_CourtName(rs.getString("ccm_CourtName"));
                        court.setCcm_Description(rs.getString("ccm_Description"));
                        court.setCcm_CourtType(rs.getString("ccm_CourtType"));
                        court.setCcm_CourtCity(rs.getString("ccm_CourtCity"));
                        court.setCcm_CourtState(rs.getString("ccm_CourtState"));
                        
                        court.setCcm_DeleteFlag(rs.getBoolean("ccm_DeleteFlag"));
                        court.setCcm_ActiveFlag(rs.getBoolean("ccm_ActiveFlag"));
                        
                        
                        
                        courts.add(court);
            }
        }
            catch (SQLException e) {
            e.printStackTrace();
            }
 
            return courts;
        }
     
      public void deleteCourt(int courtID) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from cts_mCourt where ccm_ID=?");
			// Parameters start with 1
			preparedStatement.setInt(1, courtID);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}   
      
       public int addCourt(Court court) {
           int i=0;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO cts_mCourt(`ccm_CourtName`,`ccm_Description`,`ccm_CourtType`,`ccm_CourtCity`,`ccm_CourtState`,`ccm_CreateDate`,`ccm_CreateUser`,`ccm_ModifyDate`,`ccm_ModifyUser`,`ccm_DeleteFlag`,`ccm_ActiveFlag`) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			// Parameters start with 1
			preparedStatement.setString(1, court.getCcm_CourtName());
			preparedStatement.setString(2, court.getCcm_Description());
                        preparedStatement.setString(3, court.getCcm_CourtType());
			preparedStatement.setString(4, court.getCcm_CourtCity());
                        preparedStatement.setString(5, court.getCcm_CourtState());
                        
                        preparedStatement.setDate(6, new java.sql.Date(court.getCcm_CreateDate().getTime()));
			preparedStatement.setInt(7, court.getCcm_CreateUser());
                        preparedStatement.setDate(8, new java.sql.Date(court.getCcm_ModifyDate().getTime()));
			preparedStatement.setInt(9, court.getCcm_ModifyUser());
                        preparedStatement.setBoolean(10,court.isCcm_DeleteFlag());
                        preparedStatement.setBoolean(11,court.isCcm_ActiveFlag());
                        
			
			i=preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
        return i;
	}
       
       public int updateCourt(Court court) {
           int i=0;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE cts_mCourt SET ccm_CourtName = ?, ccm_Description = ?, ccm_CourtType = ?, ccm_CourtCity = ?, ccm_CourtState = ?, ccm_CreateDate = ?, ccm_CreateUser = ?, ccm_ModifyDate = ?, ccm_ModifyUser = ?, ccm_DeleteFlag = ?, ccm_ActiveFlag = ? WHERE ccm_ID = ?");
			// Parameters start with 1
			preparedStatement.setString(1, court.getCcm_CourtName());
			preparedStatement.setString(2, court.getCcm_Description());
                        preparedStatement.setString(3, court.getCcm_CourtType());
			preparedStatement.setString(4, court.getCcm_CourtCity());
                        preparedStatement.setString(5, court.getCcm_CourtState());
                        
                        preparedStatement.setDate(6, new java.sql.Date(court.getCcm_CreateDate().getTime()));
			preparedStatement.setInt(7, court.getCcm_CreateUser());
                        preparedStatement.setDate(8, new java.sql.Date(court.getCcm_ModifyDate().getTime()));
			preparedStatement.setInt(9, court.getCcm_ModifyUser());
                        preparedStatement.setBoolean(10,court.isCcm_DeleteFlag());
                        preparedStatement.setBoolean(11,court.isCcm_ActiveFlag());
                        preparedStatement.setInt(12, court.getCcm_ID());	
                        
			i=preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
        return i;
	}
       public Court getCourtById(int courtID) {
		Court court = new Court();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from cts_mCourt where ccm_ID=?");
			preparedStatement.setInt(1, courtID);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				court.setCcm_ID(rs.getInt("ccm_ID"));
                        court.setCcm_CreateUser(rs.getInt("ccm_CreateUser"));
                        court.setCcm_ModifyUser(rs.getInt("ccm_ModifyUser"));
                        
                        court.setCcm_CreateDate(rs.getDate("ccm_CreateDate"));
                        court.setCcm_ModifyDate(rs.getDate("ccm_ModifyDate"));
                        
                        court.setCcm_CourtName(rs.getString("ccm_CourtName"));
                        court.setCcm_Description(rs.getString("ccm_Description"));
                        court.setCcm_CourtType(rs.getString("ccm_CourtType"));
                        court.setCcm_CourtCity(rs.getString("ccm_CourtCity"));
                        court.setCcm_CourtState(rs.getString("ccm_CourtState"));
                        
                        court.setCcm_DeleteFlag(rs.getBoolean("ccm_DeleteFlag"));
                        court.setCcm_ActiveFlag(rs.getBoolean("ccm_ActiveFlag"));
                                
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return court;
	}
    
}
