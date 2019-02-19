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
import java.sql.*;
import java.util.*;
import com.cts.model.CaseStage;
import com.cts.model.Category;
import com.cts.util.Database;


public class CaseStageDAO {
    
    private Connection connection;
    
     public CaseStageDAO() {
        connection = Database.getConnection();
    }
     
     public List<CaseStage> getAllCaseStage() {
            List<CaseStage> casestages = new ArrayList<CaseStage>();
            try {
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery("select * from cts_mcasestage");
                    while (rs.next()) {
                        CaseStage casestage = new CaseStage();
                   
                        casestage.setCcs_ID(rs.getInt("ccs_ID"));
                        casestage.setCcs_CreateUser(rs.getInt("ccs_CreateUser"));
                        casestage.setCcs_ModifyUser(rs.getInt("ccs_ModifyUser"));
                        
                        casestage.setCcs_CreateDate(rs.getDate("ccs_CreateDate"));
                        casestage.setCcs_ModifyDate(rs.getDate("ccs_ModifyDate"));
                        
                        casestage.setCcs_StageName(rs.getString("ccs_StageName"));
                        casestage.setCcs_Description(rs.getString("ccs_Description"));
                        
                        casestage.setCcs_DeleteFlag(rs.getBoolean("ccs_DeleteFlag"));
                        casestage.setCcs_ActiveFlag(rs.getBoolean("ccs_ActiveFlag"));
                        
                        
                        
                        casestages.add(casestage);
            }
        }
            catch (SQLException e) {
            e.printStackTrace();
            }
 
            return casestages;
        }
     
     
     //order by desc
          public List<CaseStage> getAllCaseStageDesc() {
            List<CaseStage> casestages = new ArrayList<CaseStage>();
            try {
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery("select * from cts_mcasestage order by ccs_ID desc ");
                    while (rs.next()) {
                        CaseStage casestage = new CaseStage();
                   
                        casestage.setCcs_ID(rs.getInt("ccs_ID"));
                        casestage.setCcs_CreateUser(rs.getInt("ccs_CreateUser"));
                        casestage.setCcs_ModifyUser(rs.getInt("ccs_ModifyUser"));
                        
                        casestage.setCcs_CreateDate(rs.getDate("ccs_CreateDate"));
                        casestage.setCcs_ModifyDate(rs.getDate("ccs_ModifyDate"));
                        
                        casestage.setCcs_StageName(rs.getString("ccs_StageName"));
                        casestage.setCcs_Description(rs.getString("ccs_Description"));
                        
                        casestage.setCcs_DeleteFlag(rs.getBoolean("ccs_DeleteFlag"));
                        casestage.setCcs_ActiveFlag(rs.getBoolean("ccs_ActiveFlag"));
                        
                        
                        
                        casestages.add(casestage);
            }
        }
            catch (SQLException e) {
            e.printStackTrace();
            }
 
            return casestages;
        }
     
      public void deleteCaseStage(int casestageID) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from cts_mcasestage where ccs_ID=?");
			// Parameters start with 1
			preparedStatement.setInt(1, casestageID);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}   
      
      
       public int addCaseStage(CaseStage casestage) {
           int i=0;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO cts_mcasestage(`ccs_StageName`,`ccs_Description`,`ccs_CreateDate`,`ccs_CreateUser`,`ccs_ModifyDate`,`ccs_ModifyUser`,`ccs_DeleteFlag`,`ccs_ActiveFlag`) VALUES(?,?,?,?,?,?,?,?)");
			// Parameters start with 1
			preparedStatement.setString(1, casestage.getCcs_StageName());
			preparedStatement.setString(2, casestage.getCcs_Description());
                        preparedStatement.setDate(3, new java.sql.Date(casestage.getCcs_CreateDate().getTime()));
			preparedStatement.setInt(4, casestage.getCcs_CreateUser());
                        preparedStatement.setDate(5, new java.sql.Date(casestage.getCcs_ModifyDate().getTime()));
			preparedStatement.setInt(6, casestage.getCcs_ModifyUser());
                        preparedStatement.setBoolean(7,casestage.isCcs_DeleteFlag());
                        preparedStatement.setBoolean(8,casestage.isCcs_ActiveFlag());
                        
			
			i=preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
        return i;
	}
       
        public int updateCaseStage(CaseStage casestage) {
            int i=0;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE cts_mcasestage SET ccs_StageName = ?, ccs_Description = ? WHERE ccs_ID = ?");
			// Parameters start with 1
			preparedStatement.setString(1, casestage.getCcs_StageName());
			preparedStatement.setString(2, casestage.getCcs_Description());			
                        preparedStatement.setInt(3, casestage.getCcs_ID());	
                        
			i=preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
        return i;
	}
        
        public CaseStage getCaseCaseStageById(int casestageID) {
		CaseStage caseStage = new CaseStage();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from cts_mcasestage where ccs_ID=?");
			preparedStatement.setInt(1, casestageID);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				caseStage.setCcs_ID(rs.getInt("ccs_ID"));
                                caseStage.setCcs_StageName(rs.getString("ccs_StageName"));
                                caseStage.setCcs_Description(rs.getString("ccs_Description"));
                                
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return caseStage;
	}
    
}
