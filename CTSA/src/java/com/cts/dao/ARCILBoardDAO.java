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

public class ARCILBoardDAO {
    private Connection connection;
    
    public ARCILBoardDAO() {
        connection = Database.getConnection();
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
    
    public CaseDetail getMonthlyBoardCountByARC(String ClientName) {
        CaseDetail casemonthlycount = new CaseDetail();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT Count(*) AS ccd_MonthlyCaseCount FROM (SELECT cts_casediarydetails.cad_RegNo,cts_casediarydetails.cad_CaseNo,cts_casediarydetails.cad_FileName,cts_casediarydetails.ccd_CurrentDate,ccd_Stage,ccd_Judge,ccd_Court FROM cts_casediarydetails INNER JOIN cts_casediarymaster ON cts_casediarymaster.cad_ID = cts_casediarydetails.cad_ID Where month(ccd_CurrentDate) = month(curdate()) AND year(ccd_CurrentDate) = year(curdate()) AND ccd_DeleteFlag = 0 AND ccd_Stage NOT IN ( \"Closed\", \"disposed\") AND cad_ClientName = ?  Order By ccd_CurrentDate) AS cts_casediarydetails");
            preparedStatement.setString(1, ClientName);
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
                
                casemonthlycount.setCcd_MonthlyCaseCount(rs.getInt("ccd_MonthlyCaseCount"));
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casemonthlycount;
    }
    
    public List<CaseDetail> getMonthlyBoard(String ClientName) {
        List<CaseDetail> casemonthly = new ArrayList<CaseDetail>();
        try {
            
             PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT cts_casediarydetails.cad_ID AS cad_ID,cts_casediarydetails.cad_RegNo AS cad_RegNo,cts_casediarydetails.cad_CaseNo AS cad_CaseNo,cts_casediarydetails.cad_FileName AS cad_FileName,ccd_CurrentDate,ccd_Stage,ccd_Judge,ccd_Court FROM cts_casediarydetails INNER JOIN cts_casediarymaster ON cts_casediarymaster.cad_ID = cts_casediarydetails.cad_ID Where month(ccd_CurrentDate) = month(curdate()) AND year(ccd_CurrentDate) = year(curdate()) AND ccd_DeleteFlag = 0 AND ccd_Stage NOT IN ( \"Closed\", \"disposed\") AND cad_ClientName = ?  Order By ccd_CurrentDate");
            preparedStatement.setString(1, ClientName);
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

                casemonthly.add(casemdetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casemonthly;
    }
    
    public List<CaseDetail> getDailyBoardByDay(String tDay, String ClientName) {
        List<CaseDetail> casedetails = new ArrayList<CaseDetail>();
        try {
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT cts_casediarydetails.cad_ID AS cad_ID,cts_casediarydetails.cad_RegNo AS cad_RegNo,cts_casediarydetails.cad_CaseNo AS cad_CaseNo,cts_casediarydetails.cad_FileName AS cad_FileName,ccd_CurrentDate,ccd_Stage,ccd_Judge,ccd_Court FROM cts_casediarydetails INNER JOIN cts_casediarymaster ON cts_casediarymaster.cad_ID = cts_casediarydetails.cad_ID Where ccd_CurrentDate = date_format(?, '%Y-%m-%d') AND ccd_DeleteFlag = 0 AND ccd_Stage NOT IN ( \"Closed\", \"disposed\") AND cad_ClientName = ? ");
            preparedStatement.setString(1, tDay);
            preparedStatement.setString(2, ClientName);
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

                casedetails.add(casedetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casedetails;
    }
    
    public List<CaseDetail> getDailyBoard(String ClientName) {
        List<CaseDetail> casedetails = new ArrayList<CaseDetail>();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT cts_casediarydetails.cad_ID AS cad_ID,cts_casediarydetails.cad_RegNo AS cad_RegNo,cts_casediarydetails.cad_CaseNo AS cad_CaseNo,cts_casediarydetails.cad_FileName AS cad_FileName,ccd_CurrentDate,ccd_Stage,ccd_Judge,ccd_Court FROM cts_casediarydetails INNER JOIN cts_casediarymaster ON cts_casediarymaster.cad_ID = cts_casediarydetails.cad_ID Where ccd_CurrentDate = date_format(curdate(), '%Y-%m-%d') AND ccd_DeleteFlag = 0 AND ccd_Stage NOT IN ( \"Closed\", \"disposed\") AND cad_ClientName = ?");
            preparedStatement.setString(1, ClientName);
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

                casedetails.add(casedetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casedetails;
    }
    
    public List<CaseDetail> getWeeklyBoard(String ClientName) {
        List<CaseDetail> caseweekly = new ArrayList<CaseDetail>();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT cts_casediarydetails.cad_ID AS cad_ID,cts_casediarydetails.cad_RegNo AS cad_RegNo,cts_casediarydetails.cad_CaseNo AS cad_CaseNo,cts_casediarydetails.cad_FileName AS cad_FileName,ccd_CurrentDate,ccd_Stage,ccd_Judge,ccd_Court FROM cts_casediarydetails INNER JOIN cts_casediarymaster ON cts_casediarymaster.cad_ID = cts_casediarydetails.cad_ID  Where yearweek(date_format(ccd_CurrentDate,'%Y-%m-%d')) = yearweek(curdate()) AND ccd_DeleteFlag = 0 AND ccd_Stage NOT IN ( \"Closed\", \"disposed\") AND cad_ClientName = ? Order By ccd_CurrentDate, cad_FileName");
            preparedStatement.setString(1, ClientName);
            ResultSet rs = preparedStatement.executeQuery();
            
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

                caseweekly.add(casewdetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return caseweekly;
    }
}
