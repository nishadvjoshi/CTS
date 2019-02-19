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
import java.util.Date;
import java.sql.*;
import java.util.*;

import com.cts.model.Category;
import com.cts.util.Database;

public class CategoryDAO {
    
        private Connection connection;
 
    public CategoryDAO() {
        connection = Database.getConnection();
    }
            public List<Category> getAllCategory() {
            List<Category> categories = new ArrayList<Category>();
            try {
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery("select * from cts_mcasecategory where ccg_ActiveFlag=true");
                    while (rs.next()) {
                        Category category = new Category();
                        category.setCcg_ID(rs.getInt("ccg_ID"));
                        category.setCcg_CategoryName(rs.getString("ccg_CategoryName"));
                        category.setCcg_Description(rs.getString("ccg_Description"));
                        
                        category.setCcg_DeleteFlag(rs.getBoolean("ccg_DeleteFlag"));
                        category.setCcg_ActiveFlag(rs.getBoolean("ccg_ActiveFlag"));
                           category.setCcg_CreateDate(rs.getDate("ccg_CreateDate"));
                      category.setCcg_ModifyDate(rs.getDate("ccg_ModifyDate"));
                       category.setCcg_CreateUser(rs.getInt("ccg_CreateUser"));
                       category.setCcg_ModifyUser(rs.getInt("ccg_ModifyUser"));
                
                        categories.add(category);
            }
        }
            catch (SQLException e) {
            e.printStackTrace();
            }
 
            return categories;
        }
            
            //order by desc
                        public List<Category> getAllCategoryDesc() {
            List<Category> categories = new ArrayList<Category>();
            try {
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery("select * from cts_mcasecategory where ccg_ActiveFlag=true order by ccg_ModifyDate desc ");
                    while (rs.next()) {
                        Category category = new Category();
                        category.setCcg_ID(rs.getInt("ccg_ID"));
                        category.setCcg_CategoryName(rs.getString("ccg_CategoryName"));
                        category.setCcg_Description(rs.getString("ccg_Description"));
                        
                        category.setCcg_DeleteFlag(rs.getBoolean("ccg_DeleteFlag"));
                        category.setCcg_ActiveFlag(rs.getBoolean("ccg_ActiveFlag"));
                           category.setCcg_CreateDate(rs.getDate("ccg_CreateDate"));
                      category.setCcg_ModifyDate(rs.getDate("ccg_ModifyDate"));
                       category.setCcg_CreateUser(rs.getInt("ccg_CreateUser"));
                       category.setCcg_ModifyUser(rs.getInt("ccg_ModifyUser"));
                   //System.out.println(rs.getDate("ccg_ModifyDate"));
                        categories.add(category);
            }           
                 
        }
            catch (SQLException e) {
            e.printStackTrace();
            }
 
            return categories;
        }
            
        public void deleteCaseCategory(int categoryID) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from cts_mcasecategory where ccg_ID=?");
			// Parameters start with 1
			preparedStatement.setInt(1, categoryID);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}   
        
        public int addCaseCategory(Category casecategory) {
            int i=0;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into cts_mcasecategory(ccg_CategoryName,ccg_Description,ccg_CreateDate,ccg_CreateUser,ccg_ModifyDate,ccg_ModifyUser,ccg_DeleteFlag,ccg_ActiveFlag) values (?, ?, ?, ?,?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, casecategory.getCcg_CategoryName());
			preparedStatement.setString(2, casecategory.getCcg_Description());
			
                   
                        preparedStatement.setDate(3, new java.sql.Date(casecategory.getCcg_CreateDate().getTime()));
			preparedStatement.setInt(4, casecategory.getCcg_CreateUser());
                        preparedStatement.setDate(5, new java.sql.Date(casecategory.getCcg_ModifyDate().getTime()));
			preparedStatement.setInt(6, casecategory.getCcg_ModifyUser());
                        preparedStatement.setBoolean(7,casecategory.getCcg_DeleteFlag());
                        preparedStatement.setBoolean(8,casecategory.getCcg_ActiveFlag());
                        
			i=preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
            return i;
	}
        
        public int  updateCaseCategory(Category casecategory) {
            int i=0;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update cts_mcasecategory set ccg_CategoryName=?, ccg_Description=?, ccg_ModifyUser=?, ccg_ModifyDate=? where ccg_ID=?");
			// Parameters start with 1
			preparedStatement.setString(1, casecategory.getCcg_CategoryName());
			preparedStatement.setString(2, casecategory.getCcg_Description());
        		preparedStatement.setInt(3, casecategory.getCcg_ModifyUser()); 
                        preparedStatement.setDate(4, new java.sql.Date(casecategory.getCcg_ModifyDate().getTime()));
                        
                        preparedStatement.setInt(5, casecategory.getCcg_ID());
                       
                        


                        
			i=preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
            return i;
	}
        
        public Category getCaseCategoryById(int categoryID) {
		Category caseCategory = new Category();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from cts_mcasecategory where ccg_ID=?");
			preparedStatement.setInt(1, categoryID);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				caseCategory.setCcg_ID(rs.getInt("ccg_ID"));
                                caseCategory.setCcg_CategoryName(rs.getString("ccg_CategoryName"));
                                caseCategory.setCcg_Description(rs.getString("ccg_Description"));
                                
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return caseCategory;
	}
    
        
        
}


