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
import java.sql.*;
import java.util.*;
import com.cts.model.CaseDetail;
import com.cts.model.CaseMaster;
import com.cts.model.TaskMaster;
import com.cts.model.Client;
import com.cts.util.Database;

public class CaseDairyDAO {
    private Connection connection;

    public CaseDairyDAO() {
        connection = Database.getConnection();
    }
    
    public List<CaseDetail> getDailyBoard() {
        List<CaseDetail> casedetails = new ArrayList<CaseDetail>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT cad_ID,cad_RegNo,cad_CaseNo,cad_FileName,ccd_CurrentDate,ccd_Stage,ccd_Judge,ccd_Court,ccd_id FROM cts_casediarydetails Where ccd_CurrentDate = date_format(curdate(), '%Y-%m-%d') AND ccd_DeleteFlag = 0 AND ccd_Stage NOT IN ( \"Closed\", \"disposed\")");
            while (rs.next()) {
                CaseDetail casedetail = new CaseDetail();

                casedetail.setCad_ID(rs.getInt("cad_ID"));
                casedetail.setCad_RegNo(rs.getInt("cad_RegNo"));                                                             
                casedetail.setCad_CaseNo(rs.getString("cad_CaseNo"));                
                casedetail.setCad_FileName(rs.getString("cad_FileName"));
                casedetail.setCcd_CurrentDate(rs.getDate("ccd_CurrentDate"));                
               
                casedetail.setCcd_Stage(rs.getString("ccd_Stage"));
                casedetail.setCcd_Judge(rs.getString("ccd_Judge"));
                casedetail.setCcd_Court(rs.getString("ccd_Court"));
                 casedetail.setCcd_ID(rs.getInt("ccd_id"));

                casedetails.add(casedetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casedetails;
    }
    
    public List<CaseDetail> getDailyBoardByDay(String tDay) {
        List<CaseDetail> casedetails = new ArrayList<CaseDetail>();
        try {
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT cad_ID,cad_RegNo,cad_CaseNo,cad_FileName,ccd_CurrentDate,ccd_Stage,ccd_Judge,ccd_Court,ccd_id FROM cts_casediarydetails Where ccd_CurrentDate = date_format(?, '%Y-%m-%d') AND ccd_DeleteFlag = 0 AND ccd_Stage NOT IN ( \"Closed\", \"disposed\")");
            preparedStatement.setString(1, tDay);
           
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                CaseDetail casedetail = new CaseDetail();

                casedetail.setCad_ID(rs.getInt("cad_ID"));
                casedetail.setCad_RegNo(rs.getInt("cad_RegNo"));                                                             
                casedetail.setCad_CaseNo(rs.getString("cad_CaseNo"));                
                casedetail.setCad_FileName(rs.getString("cad_FileName"));
                casedetail.setCcd_CurrentDate(rs.getDate("ccd_CurrentDate"));                
               
                casedetail.setCcd_Stage(rs.getString("ccd_Stage"));
                casedetail.setCcd_Judge(rs.getString("ccd_Judge"));
                casedetail.setCcd_Court(rs.getString("ccd_Court"));
                casedetail.setCcd_ID(rs.getInt("ccd_id"));
                casedetails.add(casedetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casedetails;
    }
    
    
    public List<CaseDetail> getWeeklyBoard() {
        List<CaseDetail> caseweekly = new ArrayList<CaseDetail>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT cad_ID,cad_RegNo,cad_CaseNo,cad_FileName,ccd_CurrentDate,ccd_Stage,ccd_Judge,ccd_Court,ccd_id FROM cts_casediarydetails  Where yearweek(date_format(ccd_CurrentDate,'%Y-%m-%d')) = yearweek(curdate()) AND ccd_DeleteFlag = 0 AND ccd_Stage NOT IN ( \"Closed\", \"disposed\") Order By ccd_CurrentDate, cad_FileName");
            while (rs.next()) {
                CaseDetail casewdetail = new CaseDetail();
                casewdetail.setCad_ID(rs.getInt("cad_ID"));
                casewdetail.setCad_RegNo(rs.getInt("cad_RegNo"));                                                             
                casewdetail.setCad_CaseNo(rs.getString("cad_CaseNo"));                
                casewdetail.setCad_FileName(rs.getString("cad_FileName"));
                casewdetail.setCcd_CurrentDate(rs.getDate("ccd_CurrentDate"));                
              
                casewdetail.setCcd_Stage(rs.getString("ccd_Stage"));
                casewdetail.setCcd_Judge(rs.getString("ccd_Judge"));
                casewdetail.setCcd_Court(rs.getString("ccd_Court"));
                casewdetail.setCcd_ID(rs.getInt("ccd_id"));

                caseweekly.add(casewdetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return caseweekly;
    }
    
    public List<CaseDetail> getMonthlyBoard() {
        List<CaseDetail> casemonthly = new ArrayList<CaseDetail>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT cad_ID,cad_RegNo,cad_CaseNo,cad_FileName,ccd_CurrentDate,ccd_Stage,ccd_Judge,ccd_Court,ccd_id FROM cts_casediarydetails Where month(ccd_CurrentDate) = month(curdate()) AND year(ccd_CurrentDate) = year(curdate()) AND ccd_DeleteFlag = 0 AND ccd_Stage NOT IN ( \"Closed\", \"disposed\")  Order By ccd_CurrentDate");
            while (rs.next()) {
                CaseDetail casemdetail = new CaseDetail();
                casemdetail.setCad_ID(rs.getInt("cad_ID"));
                casemdetail.setCad_RegNo(rs.getInt("cad_RegNo"));                                                             
                casemdetail.setCad_CaseNo(rs.getString("cad_CaseNo"));                
                casemdetail.setCad_FileName(rs.getString("cad_FileName"));
                casemdetail.setCcd_CurrentDate(rs.getDate("ccd_CurrentDate"));                
              
                casemdetail.setCcd_Stage(rs.getString("ccd_Stage"));
                casemdetail.setCcd_Judge(rs.getString("ccd_Judge"));
                casemdetail.setCcd_Court(rs.getString("ccd_Court"));
                casemdetail.setCcd_ID(rs.getInt("ccd_id"));
                casemonthly.add(casemdetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casemonthly;
    }
    
    public List<CaseDetail> getMonthlyBoardByMonth(Integer mnt, Integer yr) {
        List<CaseDetail> casemonthly = new ArrayList<CaseDetail>();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT cad_ID,cad_RegNo,cad_CaseNo,cad_FileName,ccd_CurrentDate,ccd_Stage,ccd_Judge,ccd_Court,ccd_id FROM cts_casediarydetails Where month(ccd_CurrentDate) = ? AND year(ccd_CurrentDate) = ? AND ccd_DeleteFlag = 0 AND ccd_Stage NOT IN ( \"Closed\", \"disposed\")  Order By ccd_CurrentDate");
            preparedStatement.setInt(1, mnt);
            preparedStatement.setInt(2, yr);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                CaseDetail casemdetail = new CaseDetail();
                casemdetail.setCad_ID(rs.getInt("cad_ID"));
                casemdetail.setCad_RegNo(rs.getInt("cad_RegNo"));                                                             
                casemdetail.setCad_CaseNo(rs.getString("cad_CaseNo"));                
                casemdetail.setCad_FileName(rs.getString("cad_FileName"));
                casemdetail.setCcd_CurrentDate(rs.getDate("ccd_CurrentDate"));                
              
                casemdetail.setCcd_Stage(rs.getString("ccd_Stage"));
                casemdetail.setCcd_Judge(rs.getString("ccd_Judge"));
                casemdetail.setCcd_Court(rs.getString("ccd_Court"));
                casemdetail.setCcd_ID(rs.getInt("ccd_id"));

                casemonthly.add(casemdetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casemonthly;
    }
    
    public CaseDetail getMonthlyBoardCount() {
        CaseDetail casemonthlycount = new CaseDetail();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT Count(*) AS ccd_MonthlyCaseCount FROM (SELECT cad_RegNo,cad_CaseNo,cad_FileName,ccd_CurrentDate,ccd_Stage,ccd_Judge,ccd_Court FROM cts_casediarydetails Where month(ccd_CurrentDate) = month(curdate()) AND year(ccd_CurrentDate) = year(curdate()) AND ccd_DeleteFlag = 0 AND ccd_Stage NOT IN ( \"Closed\", \"disposed\")  Order By ccd_CurrentDate) AS cts_casediarydetails ");
            if (rs.next()) {
                
                casemonthlycount.setCcd_MonthlyCaseCount(rs.getInt("ccd_MonthlyCaseCount"));
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casemonthlycount;
    }
    
    
     
     public List<CaseDetail> getUnDatedBoard() {                  
        List<CaseDetail> caseundated = new ArrayList<CaseDetail>();
        
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("Drop Table if exists temp_ctsMaxCaseDate");
            // Parameters start with 1
            
               preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
         try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("Create Table temp_ctsMaxCaseDate (SELECT cad_id, MAX(ccd_CurrentDate) AS ccd_CurrentDate FROM cts_casediarydetails GROUP BY cad_id HAVING MAX(ccd_CurrentDate) < date_format(curdate(), '%Y-%m-%d'))");
            // Parameters start with 1
            
               preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("Select cts_casediarydetails.cad_id,cad_RegNo,cad_CaseNo,cad_FileName, cts_casediarydetails.ccd_CurrentDate,ccd_Stage,ccd_Judge,ccd_Court, ccd_AAdvocate,ccd_id FROM cts_casediarydetails INNER JOIN temp_ctsMaxCaseDate ON cts_casediarydetails.cad_id = temp_ctsMaxCaseDate.cad_id Where cts_casediarydetails.ccd_CurrentDate = temp_ctsMaxCaseDate.ccd_CurrentDate AND ccd_DeleteFlag = 0 AND ccd_Stage NOT IN ( \"Closed\", \"Disposed\", \"NOT LOOKED AFTER BY US\", \"Returned\",\"DISCHARGED\",\"Dismissed for default\") Order By ccd_CurrentDate DESC");
            while (rs.next()) {
                CaseDetail casemdetail = new CaseDetail();
                casemdetail.setCad_ID(rs.getInt("cad_ID"));
                casemdetail.setCad_RegNo(rs.getInt("cad_RegNo"));                                                             
                casemdetail.setCad_CaseNo(rs.getString("cad_CaseNo"));                
                casemdetail.setCad_FileName(rs.getString("cad_FileName"));
                casemdetail.setCcd_CurrentDate(rs.getDate("ccd_CurrentDate"));                
              
                casemdetail.setCcd_Stage(rs.getString("ccd_Stage"));
                casemdetail.setCcd_Judge(rs.getString("ccd_Judge"));
                casemdetail.setCcd_Court(rs.getString("ccd_Court"));
                casemdetail.setCcd_AAdvocate(rs.getString("ccd_AAdvocate"));
                 casemdetail.setCcd_ID(rs.getInt("ccd_id"));
                caseundated.add(casemdetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return caseundated;
    }
     
     public CaseDetail getUnDatedBoardCount() {
        
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("Drop Table if exists temp_ctsMaxCaseDate");
            // Parameters start with 1
            
               preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
         try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("Create Table temp_ctsMaxCaseDate (SELECT cad_id, MAX(ccd_CurrentDate) AS ccd_CurrentDate FROM cts_casediarydetails GROUP BY cad_id HAVING MAX(ccd_CurrentDate) < date_format(curdate(), '%Y-%m-%d'))");
            // Parameters start with 1
            
               preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
         
         
        CaseDetail caseundatedcount = new CaseDetail();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT count(*) AS ccd_UnDatedCaseCount from (Select cts_casediarydetails.cad_id,cad_RegNo,cad_CaseNo,cad_FileName, cts_casediarydetails.ccd_CurrentDate,ccd_Stage,ccd_Judge,ccd_Court FROM cts_casediarydetails INNER JOIN temp_ctsMaxCaseDate ON cts_casediarydetails.cad_id = temp_ctsMaxCaseDate.cad_id Where cts_casediarydetails.ccd_CurrentDate = temp_ctsMaxCaseDate.ccd_CurrentDate AND ccd_DeleteFlag = 0 AND ccd_Stage NOT IN ( \"Closed\", \"Disposed\", \"NOT LOOKED AFTER BY US\", \"Returned\",\"DISCHARGED\",\"Dismissed for default\") Order By ccd_CurrentDate DESC) AS cts_casediarydetails");
            if (rs.next()) {
                
                caseundatedcount.setCcd_UnDatedCaseCount(rs.getInt("ccd_UnDatedCaseCount"));
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return caseundatedcount;
    }
     
     
     public CaseMaster getCaseMasterCount() {
        CaseMaster casemastercount = new CaseMaster();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT Count(*) AS cad_CaseMasterCount FROM (SELECT cad_RegNo,cad_CaseNo,cad_FileName FROM cts_casediarymaster ) AS cts_casediarymaster ");
            if (rs.next()) {
                
                casemastercount.setCad_CaseMasterCount(rs.getInt("cad_CaseMasterCount"));
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casemastercount;
    }
    
}
