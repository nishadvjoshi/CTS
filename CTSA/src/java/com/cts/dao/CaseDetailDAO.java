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
import com.cts.model.Client;
import java.sql.*;
import java.util.*;
//import java.util.Date.*;
import com.cts.model.CaseDetail;
import com.cts.model.CaseMaster;
import com.cts.model.TaskMaster;
import com.cts.model.Client;
import com.cts.model.Court;
import com.cts.model.CaseStage;
import com.cts.util.Database;

import javax.servlet.http.HttpSession;

public class CaseDetailDAO {
    private Connection connection;
    HttpSession session = null;

    public CaseDetailDAO() {
       connection = Database.getConnection();
    }
    
    public List<CaseDetail> getAllCaseDetail() {
        List<CaseDetail> casedetails = new ArrayList<CaseDetail>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT D.ccd_id,M.cad_ID,M.cad_RegNo,M.cad_CaseNo,M.cad_FileNo,M.cad_FileName,D.ccd_CurrentDate,D.ccd_Stage,D.ccd_AAdvocate,D.ccd_Judge,D.ccd_Rojnama,D.ccd_Judgment,D.ccd_Remarks,D.ccd_Court,D.ccd_CreateDate,D.ccd_CreateUser,D.ccd_ModifyDate,D.ccd_ModifyUser,D.ccd_ActiveFlag,D.ccd_DeleteFlag FROM cts_casediarydetails AS D RIGHT JOIN cts_casediarymaster AS M ON M.cad_ID = D.cad_ID WHERE ccd_DeleteFlag = 0 ORDER BY D.cad_ID, D.ccd_CurrentDate DESC");
            while (rs.next()) {
                CaseDetail casedetail = new CaseDetail();
                 
               
                casedetail.setCcd_ID(rs.getInt("ccd_id"));
                
                casedetail.setCad_ID(rs.getInt("cad_id"));
                casedetail.setCad_RegNo(rs.getInt("cad_RegNo"));               
                casedetail.setCcd_CreateUser(rs.getInt("ccd_CreateUser"));
                casedetail.setCcd_ModifyUser(rs.getInt("ccd_ModifyUser"));                
               
                casedetail.setCad_CaseNo(rs.getString("cad_CaseNo"));
                casedetail.setCad_FileNo(rs.getString("cad_FileNo"));
                casedetail.setCad_FileName(rs.getString("cad_FileName"));
                casedetail.setCcd_Stage(rs.getString("ccd_Stage"));
                casedetail.setCcd_Court(rs.getString("ccd_Court"));
                casedetail.setCcd_Judge(rs.getString("ccd_Judge"));
                casedetail.setCcd_Rojnama(rs.getString("ccd_Rojnama"));
                casedetail.setCcd_Judgment(rs.getString("ccd_Judgment"));
                casedetail.setCcd_AAdvocate(rs.getString("ccd_AAdvocate"));
                casedetail.setCcd_Remarks(rs.getString("ccd_Remarks"));                                                
                casedetail.setCcd_CurrentDate(rs.getDate("ccd_CurrentDate"));                
                
                casedetail.setCcd_CreateDate(rs.getDate("ccd_CreateDate"));
                casedetail.setCcd_ModifyDate(rs.getDate("ccd_ModifyDate"));

                casedetail.setCcd_ActiveFlag(rs.getBoolean("ccd_ActiveFlag"));
                casedetail.setCcd_DeleteFlag(rs.getBoolean("ccd_DeleteFlag"));

                casedetails.add(casedetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casedetails;
    }
    
     public List<CaseDetail> getAllCaseDetailByID(int CaseMasterID) {
        List<CaseDetail> casedetails = new ArrayList<CaseDetail>();
        try {
            
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT ccd_id,cts_casediarymaster.cad_id,cts_casediarymaster.cad_RegNo,cts_casediarymaster.cad_CaseNo,cts_casediarymaster.cad_FileNo,cts_casediarymaster.cad_FileName,ccd_CurrentDate,ccd_Stage,ccd_AAdvocate,ccd_CaseLocation,ccd_Judge,ccd_Rojnama,ccd_Judgment,ccd_Remarks,ccd_Court,ccd_CreateDate,ccd_CreateUser,ccd_CreateUserName,ccd_ModifyDate,ccd_ModifyUser,ccd_ModifyUserName,ccd_ActiveFlag,ccd_DeleteFlag FROM cts_casediarymaster LEFT JOIN cts_casediarydetails ON cts_casediarymaster.cad_ID = cts_casediarydetails.cad_ID where cts_casediarymaster.cad_id = ? AND ccd_DeleteFlag = 0  Order By ccd_CurrentDate DESC");
            preparedStatement.setInt(1, CaseMasterID);
            
         System.out.println("im from getAllCaseDetailByID  " + CaseMasterID);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                CaseDetail casedetail = new CaseDetail();

                casedetail.setCcd_ID(rs.getInt("ccd_id"));
                casedetail.setCad_ID(rs.getInt("cad_id"));
                casedetail.setCad_RegNo(rs.getInt("cad_RegNo"));               
                casedetail.setCcd_CreateUser(rs.getInt("ccd_CreateUser"));
                casedetail.setCcd_ModifyUser(rs.getInt("ccd_ModifyUser"));                
               
                casedetail.setCad_CaseNo(rs.getString("cad_CaseNo"));
                casedetail.setCad_FileNo(rs.getString("cad_FileNo"));
                casedetail.setCad_FileName(rs.getString("cad_FileName"));
                casedetail.setCcd_Stage(rs.getString("ccd_Stage"));
                casedetail.setCcd_Court(rs.getString("ccd_Court"));
                casedetail.setCcd_CaseLocation(rs.getString("ccd_CaseLocation"));                
                casedetail.setCcd_Judge(rs.getString("ccd_Judge"));
                casedetail.setCcd_Rojnama(rs.getString("ccd_Rojnama"));
                casedetail.setCcd_Judgment(rs.getString("ccd_Judgment"));
                casedetail.setCcd_AAdvocate(rs.getString("ccd_AAdvocate"));
                casedetail.setCcd_Remarks(rs.getString("ccd_Remarks"));                                                
                casedetail.setCcd_CurrentDate(rs.getDate("ccd_CurrentDate"));                
                
                casedetail.setCcd_CreateUserName(rs.getString("ccd_CreateUserName"));
                casedetail.setCcd_ModifyUserName(rs.getString("ccd_ModifyUserName"));
                
                
                casedetail.setCcd_CreateDate(rs.getDate("ccd_CreateDate"));
                casedetail.setCcd_ModifyDate(rs.getDate("ccd_ModifyDate"));

                casedetail.setCcd_ActiveFlag(rs.getBoolean("ccd_ActiveFlag"));
                casedetail.setCcd_DeleteFlag(rs.getBoolean("ccd_DeleteFlag"));

                casedetails.add(casedetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
           // System.out.println("here is the exception on getAllCaseDetailByID in getAllCaseDetailDAO page"+e);
        }

        return casedetails;
    }
     
     public List<CaseDetail> getAllCaseDetailByClientID(int CaseMasterID, int ClientID) {
        List<CaseDetail> casedetails = new ArrayList<CaseDetail>();
        try {
            
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT ccd_id,cts_casediarymaster.cad_id,cts_casediarymaster.cad_RegNo,cts_casediarymaster.cad_CaseNo,cts_casediarymaster.cad_FileNo,cts_casediarymaster.cad_FileName,ccd_CurrentDate,ccd_Stage,ccd_AAdvocate,ccd_CaseLocation,ccd_Judge,ccd_Rojnama,ccd_Judgment,ccd_Remarks,ccd_Court,ccd_CreateDate,ccd_CreateUser,ccd_CreateUserName,ccd_ModifyDate,ccd_ModifyUser,ccd_ModifyUserName,ccd_ActiveFlag,ccd_DeleteFlag FROM cts_casediarymaster LEFT JOIN cts_casediarydetails ON cts_casediarymaster.cad_ID = cts_casediarydetails.cad_ID where cts_casediarymaster.cad_id = ? AND ccd_DeleteFlag = 0 AND cts_casediarymaster.cmc_ID = ?  Order By ccd_CurrentDate DESC");
            preparedStatement.setInt(1, CaseMasterID);
            preparedStatement.setInt(2, ClientID);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                CaseDetail casedetail = new CaseDetail();

                casedetail.setCcd_ID(rs.getInt("ccd_id"));
                casedetail.setCad_ID(rs.getInt("cad_id"));
                casedetail.setCad_RegNo(rs.getInt("cad_RegNo"));               
                casedetail.setCcd_CreateUser(rs.getInt("ccd_CreateUser"));
                casedetail.setCcd_ModifyUser(rs.getInt("ccd_ModifyUser"));                
               
                casedetail.setCad_CaseNo(rs.getString("cad_CaseNo"));
                casedetail.setCad_FileNo(rs.getString("cad_FileNo"));
                casedetail.setCad_FileName(rs.getString("cad_FileName"));
                casedetail.setCcd_Stage(rs.getString("ccd_Stage"));
                casedetail.setCcd_Court(rs.getString("ccd_Court"));
                casedetail.setCcd_CaseLocation(rs.getString("ccd_CaseLocation"));                
                casedetail.setCcd_Judge(rs.getString("ccd_Judge"));
                casedetail.setCcd_Rojnama(rs.getString("ccd_Rojnama"));
                casedetail.setCcd_Judgment(rs.getString("ccd_Judgment"));
                casedetail.setCcd_AAdvocate(rs.getString("ccd_AAdvocate"));
                casedetail.setCcd_Remarks(rs.getString("ccd_Remarks"));                                                
                casedetail.setCcd_CurrentDate(rs.getDate("ccd_CurrentDate"));                
                
                casedetail.setCcd_CreateUserName(rs.getString("ccd_CreateUserName"));
                casedetail.setCcd_ModifyUserName(rs.getString("ccd_ModifyUserName"));
                
                
                casedetail.setCcd_CreateDate(rs.getDate("ccd_CreateDate"));
                casedetail.setCcd_ModifyDate(rs.getDate("ccd_ModifyDate"));

                casedetail.setCcd_ActiveFlag(rs.getBoolean("ccd_ActiveFlag"));
                casedetail.setCcd_DeleteFlag(rs.getBoolean("ccd_DeleteFlag"));

                casedetails.add(casedetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casedetails;
    }
     
     public List<CaseDetail> getAllCaseDetailByDetailID(int CaseDetailID) {
        List<CaseDetail> casedetails = new ArrayList<CaseDetail>();
        try {
            
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT ccd_id,cts_casediarymaster.cad_id,cts_casediarymaster.cad_RegNo,cts_casediarymaster.cad_CaseNo,cts_casediarymaster.cad_FileNo,cts_casediarymaster.cad_FileName,ccd_CurrentDate,ccd_Stage,ccd_AAdvocate, ccd_Judge,ccd_Rojnama,ccd_Judgment,ccd_Remarks,ccd_Court,ccd_CaseLocation, ccd_CreateDate,ccd_CreateUser,ccd_CreateUserName,ccd_ModifyDate,ccd_ModifyUser,ccd_ModifyUserName,ccd_ActiveFlag,ccd_DeleteFlag FROM cts_casediarymaster LEFT JOIN cts_casediarydetails ON cts_casediarymaster.cad_ID = cts_casediarydetails.cad_ID where cts_casediarymaster.cad_id = (Select cts_casediarydetails.cad_id from cts_casediarydetails where cts_casediarydetails.ccd_id = ? ) AND ccd_DeleteFlag = 0  Order By ccd_CurrentDate DESC");
            preparedStatement.setInt(1, CaseDetailID);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                CaseDetail casedetail = new CaseDetail();

                casedetail.setCcd_ID(rs.getInt("ccd_id"));
                casedetail.setCad_ID(rs.getInt("cad_id"));
                casedetail.setCad_RegNo(rs.getInt("cad_RegNo"));               
                casedetail.setCcd_CreateUser(rs.getInt("ccd_CreateUser"));
                casedetail.setCcd_ModifyUser(rs.getInt("ccd_ModifyUser"));                
               
                casedetail.setCad_CaseNo(rs.getString("cad_CaseNo"));
                casedetail.setCad_FileNo(rs.getString("cad_FileNo"));
                casedetail.setCad_FileName(rs.getString("cad_FileName"));
                casedetail.setCcd_Stage(rs.getString("ccd_Stage"));
                casedetail.setCcd_AAdvocate(rs.getString("ccd_AAdvocate"));
                casedetail.setCcd_Court(rs.getString("ccd_Court"));
                casedetail.setCcd_CaseLocation(rs.getString("ccd_CaseLocation"));
                casedetail.setCcd_Judge(rs.getString("ccd_Judge"));
                casedetail.setCcd_Rojnama(rs.getString("ccd_Rojnama"));
                casedetail.setCcd_Judgment(rs.getString("ccd_Judgment"));
                casedetail.setCcd_Remarks(rs.getString("ccd_Remarks"));                                                
                casedetail.setCcd_CurrentDate(rs.getDate("ccd_CurrentDate"));
                
                 casedetail.setCcd_CreateUserName(rs.getString("ccd_CreateUserName"));
                casedetail.setCcd_ModifyUserName(rs.getString("ccd_ModifyUserName"));
                
                casedetail.setCcd_CreateDate(rs.getDate("ccd_CreateDate"));
                casedetail.setCcd_ModifyDate(rs.getDate("ccd_ModifyDate"));

                casedetail.setCcd_ActiveFlag(rs.getBoolean("ccd_ActiveFlag"));
                casedetail.setCcd_DeleteFlag(rs.getBoolean("ccd_DeleteFlag"));

                casedetails.add(casedetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casedetails;
    }
    
     public void deleteCaseDetail(int CaseDetailID) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE cts_casediarydetails SET ccd_DeleteFlag = 1 Where ccd_ID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, CaseDetailID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public CaseDetail getCaseDetailById(int CaseMasterID) {
        CaseDetail casedetail = new CaseDetail();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT ccd_id,cts_casediarymaster.cad_id,cts_casediarymaster.cad_RegNo,cts_casediarymaster.cad_CaseNo,cts_casediarymaster.cad_FileNo,cts_casediarymaster.cad_FileName,cts_casediarymaster.cad_AssetCode, cts_casediarymaster.cad_ClientName, cts_casediarymaster.cad_Location, cts_casediarymaster.cad_Court, cts_casediarymaster.cad_AppearingFor, cts_casediarymaster.cad_Advocate, cts_casediarymaster.cad_ACT, cts_casediarymaster.cad_Stage, cts_casediarymaster.cad_VakilPatraFiledBy, cts_casediarymaster.cad_VakilPatraFiledOn, cts_casediarymaster.cad_CaseCategory, cts_casediarymaster.cad_OpponentName, cts_casediarymaster.cad_OpponentAdvocate, cts_casediarymaster.cad_Remarks, cts_casediarymaster.cad_OtherInfo, MAX(ccd_CurrentDate) AS ccd_CurrentDate,ccd_Stage,ccd_AAdvocate, ccd_Judge,ccd_Rojnama,ccd_Judgment,ccd_Remarks,ccd_Court,ccd_CaseLocation,ccd_CreateDate,ccd_CreateUser,ccd_ModifyDate,ccd_ModifyUser,ccd_ActiveFlag,ccd_DeleteFlag FROM cts_casediarymaster LEFT JOIN cts_casediarydetails ON cts_casediarymaster.cad_ID = cts_casediarydetails.cad_ID where cts_casediarymaster.cad_id = ? AND ccd_DeleteFlag = 0");
            preparedStatement.setInt(1, CaseMasterID);
            System.out.println(CaseMasterID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                //casedetail.setCcd_ID(rs.getInt("ccd_id"));
                //int ccdid1=rs.getInt("ccd_id");
                System.out.println("im from getCaseDetailById " +CaseMasterID);
                casedetail.setCad_ID(rs.getInt("cad_id"));
                casedetail.setCad_RegNo(rs.getInt("cad_RegNo"));               
                casedetail.setCcd_CreateUser(rs.getInt("ccd_CreateUser"));
                casedetail.setCcd_ModifyUser(rs.getInt("ccd_ModifyUser"));                
               
                casedetail.setCad_CaseNo(rs.getString("cad_CaseNo"));                
                casedetail.setCad_FileName(rs.getString("cad_FileName"));
                casedetail.setCcd_Stage(rs.getString("ccd_Stage"));
                casedetail.setCcd_AAdvocate(rs.getString("ccd_AAdvocate"));
                casedetail.setCcd_Court(rs.getString("ccd_Court"));
                casedetail.setCcd_CaseLocation(rs.getString("ccd_CaseLocation"));
                casedetail.setCcd_Judge(rs.getString("ccd_Judge"));
                casedetail.setCcd_Rojnama(rs.getString("ccd_Rojnama"));
                casedetail.setCcd_Judgment(rs.getString("ccd_Judgment"));
                casedetail.setCcd_Remarks(rs.getString("ccd_Remarks"));
             
                
                
                casedetail.setCcd_CurrentDate(rs.getDate("ccd_CurrentDate"));                
               
                casedetail.setCcd_CreateDate(rs.getDate("ccd_CreateDate"));
                casedetail.setCcd_ModifyDate(rs.getDate("ccd_ModifyDate"));

                casedetail.setCcd_ActiveFlag(rs.getBoolean("ccd_ActiveFlag"));
                casedetail.setCcd_DeleteFlag(rs.getBoolean("ccd_DeleteFlag"));
               

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casedetail;
    }
     
     
     public CaseDetail getCaseDetailByDId(int CaseDetailID) {
        CaseDetail casemdetail = new CaseDetail();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT ccd_id,cad_id,cad_RegNo,cad_CaseNo,cad_FileNo,cad_FileName,MAX(ccd_CurrentDate) AS ccd_CurrentDate ,ccd_Stage,ccd_AAdvocate,ccd_Judge,ccd_Rojnama,ccd_Judgment,ccd_Remarks,ccd_Court,ccd_CaseLocation,ccd_CreateDate,ccd_CreateUser,ccd_ModifyDate,ccd_ModifyUser,ccd_ActiveFlag,ccd_DeleteFlag FROM case_tracking_system.cts_casediarydetails where ccd_id = ?");
            preparedStatement.setInt(1, CaseDetailID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                casemdetail.setCcd_ID(rs.getInt("ccd_id"));
                casemdetail.setCad_ID(rs.getInt("cad_id"));
                casemdetail.setCad_RegNo(rs.getInt("cad_RegNo"));               
                casemdetail.setCcd_CreateUser(rs.getInt("ccd_CreateUser"));
                casemdetail.setCcd_ModifyUser(rs.getInt("ccd_ModifyUser"));                
               
                casemdetail.setCad_CaseNo(rs.getString("cad_CaseNo")); 
                casemdetail.setCad_FileNo(rs.getString("cad_FileNo"));
                casemdetail.setCad_FileName(rs.getString("cad_FileName"));
                casemdetail.setCcd_Stage(rs.getString("ccd_Stage"));
                casemdetail.setCcd_AAdvocate(rs.getString("ccd_AAdvocate"));
                casemdetail.setCcd_Court(rs.getString("ccd_Court"));
                casemdetail.setCcd_CaseLocation(rs.getString("ccd_CaseLocation"));
                casemdetail.setCcd_Judge(rs.getString("ccd_Judge"));
                casemdetail.setCcd_Rojnama(rs.getString("ccd_Rojnama"));
                casemdetail.setCcd_Judgment(rs.getString("ccd_Judgment"));
                casemdetail.setCcd_Remarks(rs.getString("ccd_Remarks"));
                
                
                
                casemdetail.setCcd_CurrentDate(rs.getDate("ccd_CurrentDate"));                
               
                casemdetail.setCcd_CreateDate(rs.getDate("ccd_CreateDate"));
                casemdetail.setCcd_ModifyDate(rs.getDate("ccd_ModifyDate"));

                casemdetail.setCcd_ActiveFlag(rs.getBoolean("ccd_ActiveFlag"));
                casemdetail.setCcd_DeleteFlag(rs.getBoolean("ccd_DeleteFlag"));
               

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casemdetail;
    }
      public CaseMaster getCaseMasterById(int CaseMasterID) {
        CaseMaster casemaster = new CaseMaster();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select cad_ID,cad_RegNo,cad_ClientName,cad_CaseNo,cad_FileNo,cad_FileName,cad_Location,cad_Court,cmc_ID  from cts_casediarymaster where cad_ID=?");
            preparedStatement.setInt(1, CaseMasterID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                System.out.println("im from getcasemasterbyid " +CaseMasterID);
               casemaster.setCad_ID(rs.getInt("cad_ID"));
                casemaster.setCad_RegNo(rs.getInt("cad_RegNo"));               
               

                casemaster.setCad_ClientName(rs.getString("cad_ClientName"));
               
                casemaster.setCad_CaseNo(rs.getString("cad_CaseNo"));
                casemaster.setCad_FileNo(rs.getString("cad_FileNo"));
                casemaster.setCad_FileName(rs.getString("cad_FileName"));
                casemaster.setCad_Location(rs.getString("cad_Location"));
                casemaster.setCad_Court(rs.getString("cad_Court"));
                casemaster.setCmc_ID(rs.getInt("cmc_ID"));
                

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casemaster;
    }
    
      public CaseMaster getCaseMasterByDetailId(int CaseDetailID) {
        CaseMaster casemaster = new CaseMaster();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select cad_ID,cad_RegNo,cad_ClientName,cad_CaseNo,cad_FileNo,cad_FileName,cad_Location,cad_Court,cmc_ID  from cts_casediarymaster where cad_ID = (Select cad_id from cts_casediarydetails where ccd_id = ? )");
            preparedStatement.setInt(1, CaseDetailID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
               casemaster.setCad_ID(rs.getInt("cad_ID"));
                casemaster.setCad_RegNo(rs.getInt("cad_RegNo"));               
               

                casemaster.setCad_ClientName(rs.getString("cad_ClientName"));
               
                casemaster.setCad_CaseNo(rs.getString("cad_CaseNo"));
                casemaster.setCad_FileNo(rs.getString("cad_FileNo"));
                casemaster.setCad_FileName(rs.getString("cad_FileName"));
                casemaster.setCad_Location(rs.getString("cad_Location"));
                casemaster.setCad_Court(rs.getString("cad_Court"));
                casemaster.setCmc_ID(Integer.parseInt(rs.getString("cmc_ID")));
                

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casemaster;
    }
    
      
     public void addCaseDetail(CaseDetail casedetail) {                  
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE cts_casediarydetails SET ccd_ActiveFlag = FALSE WHERE cad_id = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, casedetail.getCad_ID());
               preparedStatement.executeUpdate();
               System.out.println("IM FROM ADD CASEDETAILS AFTER UPDATE AND BEFORE INSERT");
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
         try {
             
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO cts_casediarydetails"
                            + "(cad_id,cad_RegNo,cad_CaseNo,cad_FileName,ccd_CurrentDate,ccd_Stage,ccd_Rojnama,ccd_Judgment,ccd_Remarks,ccd_Court,ccd_CreateDate,ccd_CreateUser,ccd_ModifyDate,ccd_ModifyUser,ccd_ActiveFlag,ccd_DeleteFlag,cad_FileNo,ccd_Judge, ccd_AAdvocate, ccd_CreateUserName,ccd_ModifyUserName,ccd_CaseLocation) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setInt(1, casedetail.getCad_ID());
            preparedStatement.setInt(2, casedetail.getCad_RegNo());
            preparedStatement.setString(3, casedetail.getCad_CaseNo());
            preparedStatement.setString(4, casedetail.getCad_FileName());
            preparedStatement.setDate(5, new java.sql.Date(casedetail.getCcd_CurrentDate().getTime()));
            
            preparedStatement.setString(6, casedetail.getCcd_Stage());
            preparedStatement.setString(7, null);
            preparedStatement.setString(8, casedetail.getCcd_Judgment());
            preparedStatement.setString(9, casedetail.getCcd_Remarks());
            preparedStatement.setString(10, casedetail.getCcd_Court());
            
            
            preparedStatement.setDate(11, new java.sql.Date(casedetail.getCcd_CreateDate().getTime()));
            preparedStatement.setInt(12, casedetail.getCcd_CreateUser());
            preparedStatement.setDate(13, new java.sql.Date(casedetail.getCcd_ModifyDate().getTime()));
            preparedStatement.setInt(14, casedetail.getCcd_ModifyUser());
            preparedStatement.setBoolean(15, casedetail.isCcd_ActiveFlag());
            preparedStatement.setBoolean(16, casedetail.isCcd_DeleteFlag());
            preparedStatement.setString(17, casedetail.getCad_FileNo());
            preparedStatement.setString(18, casedetail.getCcd_Judge());
            preparedStatement.setString(19, null);
            preparedStatement.setString(20, casedetail.getCcd_CreateUserName());
            preparedStatement.setString(21, casedetail.getCcd_ModifyUserName());
            preparedStatement.setString(22, casedetail.getCcd_CaseLocation());
            preparedStatement.executeUpdate();
               System.out.println("IM FROM ADD CASEDETAILS AFTER Insert AND BEFORE UPDATE");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
      public void updateCaseDetail(CaseDetail casedetail) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE case_tracking_system.cts_casediarydetails SET cad_id = ?, cad_RegNo = ?, cad_CaseNo = ?, cad_FileName = ?, ccd_CurrentDate = ?, ccd_Stage = ?, ccd_Rojnama = ?, ccd_Judgment = ?, ccd_Remarks = ?, ccd_Court = ?, ccd_ModifyDate = ?, ccd_ModifyUser = ?, ccd_ActiveFlag = ?, ccd_DeleteFlag = ?, ccd_AAdvocate = ?, ccd_ModifyUserName = ?, ccd_CaseLocation = ?, ccd_Judge = ? WHERE ccd_id = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, casedetail.getCad_ID());
            preparedStatement.setInt(2, casedetail.getCad_RegNo());
            preparedStatement.setString(3, casedetail.getCad_CaseNo());
            preparedStatement.setString(4, casedetail.getCad_FileName());
            preparedStatement.setDate(5, new java.sql.Date(casedetail.getCcd_CurrentDate().getTime()));
            
            preparedStatement.setString(6, casedetail.getCcd_Stage());
            preparedStatement.setString(7, casedetail.getCcd_Rojnama());
            preparedStatement.setString(8, casedetail.getCcd_Judgment());
            preparedStatement.setString(9, casedetail.getCcd_Remarks());
            preparedStatement.setString(10, casedetail.getCcd_Court());
            
            
            //preparedStatement.setDate(11, new java.sql.Date(casedetail.getCcd_CreateDate().getTime()));
            //preparedStatement.setInt(12, casedetail.getCcd_CreateUser());
            preparedStatement.setDate(11, new java.sql.Date(casedetail.getCcd_ModifyDate().getTime()));
            preparedStatement.setInt(12, casedetail.getCcd_ModifyUser());
            preparedStatement.setBoolean(13, casedetail.isCcd_ActiveFlag());
            preparedStatement.setBoolean(14, casedetail.isCcd_DeleteFlag());
            
            preparedStatement.setString(15, casedetail.getCcd_AAdvocate());
            preparedStatement.setString(16, casedetail.getCcd_ModifyUserName());
            preparedStatement.setString(17, casedetail.getCcd_CaseLocation());
            preparedStatement.setString(18, casedetail.getCcd_Judge());
            preparedStatement.setInt(19, casedetail.getCcd_ID());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      
      public void UpdateRojnama(Integer CaseDetailID, String Rojnama, String Advocate) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE case_tracking_system.cts_casediarydetails SET ccd_Rojnama = ?, ccd_AAdvocate = ?  WHERE ccd_id = ?");
            // Parameters start with 1
            preparedStatement.setString(1, Rojnama);
            preparedStatement.setString(2, Advocate);
            preparedStatement.setInt(3, CaseDetailID);
            
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      
      public List<CaseMaster> getAllCaseMaster() {
          
     
          
        List<CaseMaster> casemasters = new ArrayList<CaseMaster>();
        try {
             System.out.println("\n im from getAllCaseMaster");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_casediarymaster ");
            while (rs.next()) {
                CaseMaster casemaster = new CaseMaster();
                
                
     
                casemaster.setCad_ID(rs.getInt("cad_ID"));
                
                casemaster.setCad_RegNo(rs.getInt("cad_RegNo"));
                
                 casemaster.setCad_CaseNo(rs.getString("cad_CaseNo"));
               casemaster.setCad_FileName(rs.getString("cad_FileName"));
                 casemaster.setCad_FileNo(rs.getString("cad_FileNo")); 
                
                   casemaster.setCad_CreateUser(rs.getInt("cad_CreateUser"));
                casemaster.setCad_ModifyUser(rs.getInt("cad_ModifyUser"));
                casemaster.setCad_ClientName(rs.getString("cad_ClientName"));
                
             
                casemaster.setCad_Location(rs.getString("cad_Location"));
                casemaster.setCad_Court(rs.getString("cad_Court"));
                casemaster.setCad_AppearingFor(rs.getString("cad_AppearingFor"));
                casemaster.setCad_Advocate(rs.getString("cad_Advocate"));
                casemaster.setCad_ACT(rs.getString("cad_ACT"));
                casemaster.setCad_Stage(rs.getString("cad_Stage"));
                casemaster.setCad_VakilPatraFiledBy(rs.getString("cad_VakilPatraFiledBy"));
                //System.out.println(" here is the date"+rs.getDate("cad_VakilPatraFiledOn"));
                
                
                casemaster.setCad_VakilPatraFiledOn(rs.getDate("cad_VakilPatraFiledOn"));
                casemaster.setCad_CaseCategory(rs.getString("cad_CaseCategory"));
                casemaster.setCad_OpponentName(rs.getString("cad_OpponentName"));
                casemaster.setCad_OpponentAdvocate(rs.getString("cad_OpponentAdvocate"));
                casemaster.setCad_CaseType(rs.getString("cad_CaseType"));
                casemaster.setCad_AssetCode(rs.getString("cad_AssetCode"));
                casemaster.setCad_Remarks(rs.getString("cad_Remarks"));
                casemaster.setCad_OtherInfo(rs.getString("cad_OtherInfo"));
                
                
                
                
           
                
               casemaster.setCad_CreateDate(rs.getDate("cad_CreateDate"));
                 casemaster.setCad_ModifyDate(rs.getDate("cad_ModifyDate"));

                casemaster.setCad_ActiveFlag(rs.getBoolean("cad_ActiveFlag"));
                casemaster.setCad_DeleteFlag(rs.getBoolean("cad_DeleteFlag"));

                casemasters.add(casemaster);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
           
        }

        return casemasters;
    }
      
      
      
      public List<CaseMaster> getAllClientCaseMaster(int ClientID) {
        List<CaseMaster> casemasters = new ArrayList<CaseMaster>();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from cts_casediarymaster where cmc_ID = ?");
            preparedStatement.setInt(1, ClientID);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                CaseMaster casemaster = new CaseMaster();

                casemaster.setCad_ID(rs.getInt("cad_ID"));
                casemaster.setCad_RegNo(rs.getInt("cad_RegNo"));               
                casemaster.setCad_CreateUser(rs.getInt("cad_CreateUser"));
                casemaster.setCad_ModifyUser(rs.getInt("cad_ModifyUser"));

                casemaster.setCad_ClientName(rs.getString("cad_ClientName"));
               
                casemaster.setCad_CaseNo(rs.getString("cad_CaseNo"));
                casemaster.setCad_FileNo(rs.getString("cad_FileNo"));
                casemaster.setCad_FileName(rs.getString("cad_FileName"));
                casemaster.setCad_Location(rs.getString("cad_Location"));
                casemaster.setCad_Court(rs.getString("cad_Court"));
                casemaster.setCad_AppearingFor(rs.getString("cad_AppearingFor"));
                casemaster.setCad_Advocate(rs.getString("cad_Advocate"));
                casemaster.setCad_ACT(rs.getString("cad_ACT"));
                casemaster.setCad_Stage(rs.getString("cad_Stage"));
                casemaster.setCad_VakilPatraFiledBy(rs.getString("cad_VakilPatraFiledBy"));
                casemaster.setCad_CaseCategory(rs.getString("cad_CaseCategory"));
                casemaster.setCad_OpponentName(rs.getString("cad_OpponentName"));
                casemaster.setCad_OpponentAdvocate(rs.getString("cad_OpponentAdvocate"));
                casemaster.setCad_CaseType(rs.getString("cad_CaseType"));
                casemaster.setCad_AssetCode(rs.getString("cad_AssetCode"));
                casemaster.setCad_Remarks(rs.getString("cad_Remarks"));
                casemaster.setCad_OtherInfo(rs.getString("cad_OtherInfo"));
                
                
                casemaster.setCad_VakilPatraFiledOn(rs.getDate("cad_VakilPatraFiledOn"));
                casemaster.setCad_CreateDate(rs.getDate("cad_CreateDate"));
                casemaster.setCad_ModifyDate(rs.getDate("cad_ModifyDate"));

                casemaster.setCad_ActiveFlag(rs.getBoolean("cad_ActiveFlag"));
                casemaster.setCad_DeleteFlag(rs.getBoolean("cad_DeleteFlag"));

                casemasters.add(casemaster);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casemasters;
    }
      
      public List<CaseMaster> getAllCaseMasterByMasterID(Integer CaseMasterID) {
        List<CaseMaster> casemasters = new ArrayList<CaseMaster>();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from cts_casediarymaster where cad_ID = ?");
            preparedStatement.setInt(1, CaseMasterID);
            ResultSet rs = preparedStatement.executeQuery();
                        
            while (rs.next()) {
                CaseMaster casemaster = new CaseMaster();

                casemaster.setCad_ID(rs.getInt("cad_ID"));
                casemaster.setCad_RegNo(rs.getInt("cad_RegNo"));               
                casemaster.setCad_CreateUser(rs.getInt("cad_CreateUser"));
                casemaster.setCad_ModifyUser(rs.getInt("cad_ModifyUser"));

                casemaster.setCad_ClientName(rs.getString("cad_ClientName"));
               
                casemaster.setCad_CaseNo(rs.getString("cad_CaseNo"));
                casemaster.setCad_FileNo(rs.getString("cad_FileNo"));
                casemaster.setCad_FileName(rs.getString("cad_FileName"));
                casemaster.setCad_Location(rs.getString("cad_Location"));
                casemaster.setCad_Court(rs.getString("cad_Court"));
                casemaster.setCad_AppearingFor(rs.getString("cad_AppearingFor"));
                casemaster.setCad_Advocate(rs.getString("cad_Advocate"));
                casemaster.setCad_ACT(rs.getString("cad_ACT"));
                casemaster.setCad_Stage(rs.getString("cad_Stage"));
                casemaster.setCad_VakilPatraFiledBy(rs.getString("cad_VakilPatraFiledBy"));
                casemaster.setCad_CaseCategory(rs.getString("cad_CaseCategory"));
                casemaster.setCad_OpponentName(rs.getString("cad_OpponentName"));
                casemaster.setCad_OpponentAdvocate(rs.getString("cad_OpponentAdvocate"));
                casemaster.setCad_CaseType(rs.getString("cad_CaseType"));
                casemaster.setCad_AssetCode(rs.getString("cad_AssetCode"));
                casemaster.setCad_Remarks(rs.getString("cad_Remarks"));
                casemaster.setCad_OtherInfo(rs.getString("cad_OtherInfo"));
                
                
                casemaster.setCad_VakilPatraFiledOn(rs.getDate("cad_VakilPatraFiledOn"));
                casemaster.setCad_CreateDate(rs.getDate("cad_CreateDate"));
                casemaster.setCad_ModifyDate(rs.getDate("cad_ModifyDate"));

                casemaster.setCad_ActiveFlag(rs.getBoolean("cad_ActiveFlag"));
                casemaster.setCad_DeleteFlag(rs.getBoolean("cad_DeleteFlag"));

                casemasters.add(casemaster);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casemasters;
    }
      
      public List<CaseMaster> getAllCaseMasterByDetailID(Integer CaseDetailID) {
        List<CaseMaster> casemasters = new ArrayList<CaseMaster>();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from cts_casediarymaster where cad_id = (Select cad_ID from cts_casediarydetails where ccd_id = ? )");
            preparedStatement.setInt(1, CaseDetailID);
            ResultSet rs = preparedStatement.executeQuery();
                        
            while (rs.next()) {
                CaseMaster casemaster = new CaseMaster();

                casemaster.setCad_ID(rs.getInt("cad_ID"));
                casemaster.setCad_RegNo(rs.getInt("cad_RegNo"));               
                casemaster.setCad_CreateUser(rs.getInt("cad_CreateUser"));
                casemaster.setCad_ModifyUser(rs.getInt("cad_ModifyUser"));

                casemaster.setCad_ClientName(rs.getString("cad_ClientName"));
               
                casemaster.setCad_CaseNo(rs.getString("cad_CaseNo"));
                casemaster.setCad_FileNo(rs.getString("cad_FileNo"));
                casemaster.setCad_FileName(rs.getString("cad_FileName"));
                casemaster.setCad_Location(rs.getString("cad_Location"));
                casemaster.setCad_Court(rs.getString("cad_Court"));
                casemaster.setCad_AppearingFor(rs.getString("cad_AppearingFor"));
                casemaster.setCad_Advocate(rs.getString("cad_Advocate"));
                casemaster.setCad_ACT(rs.getString("cad_ACT"));
                casemaster.setCad_Stage(rs.getString("cad_Stage"));
                casemaster.setCad_VakilPatraFiledBy(rs.getString("cad_VakilPatraFiledBy"));
                casemaster.setCad_CaseCategory(rs.getString("cad_CaseCategory"));
                casemaster.setCad_OpponentName(rs.getString("cad_OpponentName"));
                casemaster.setCad_OpponentAdvocate(rs.getString("cad_OpponentAdvocate"));
                casemaster.setCad_CaseType(rs.getString("cad_CaseType"));
                casemaster.setCad_AssetCode(rs.getString("cad_AssetCode"));
                casemaster.setCad_Remarks(rs.getString("cad_Remarks"));
                casemaster.setCad_OtherInfo(rs.getString("cad_OtherInfo"));
                
                
                casemaster.setCad_VakilPatraFiledOn(rs.getDate("cad_VakilPatraFiledOn"));
                casemaster.setCad_CreateDate(rs.getDate("cad_CreateDate"));
                casemaster.setCad_ModifyDate(rs.getDate("cad_ModifyDate"));

                casemaster.setCad_ActiveFlag(rs.getBoolean("cad_ActiveFlag"));
                casemaster.setCad_DeleteFlag(rs.getBoolean("cad_DeleteFlag"));

                casemasters.add(casemaster);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casemasters;
    }
      
      public List<Advocate> getAllAdvocate() {
        List<Advocate> advocates = new ArrayList<Advocate>();
        try {
             System.out.println("\n im from getAllAdvocate");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_madvocates Order by cam_ID");
            while (rs.next()) {
                Advocate advocate = new Advocate();

                advocate.setCam_ID(rs.getInt("cam_ID"));
                advocate.setCam_FirstName(rs.getString("cam_FirstName"));

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
                client.setCmc_ZipCode(rs.getInt("cmc_ZipCode"));
                client.setCmc_PZipCode(rs.getInt("cmc_PZipCode"));
                client.setCmc_CreateUser(rs.getInt("cmc_CreateUser"));
                client.setCmc_ModifyUser(rs.getInt("cmc_ModifyUser"));

                client.setCmc_FirstName(rs.getString("cmc_FirstName"));                
                client.setCmc_ClientType(rs.getString("cmc_ClientType"));
                client.setCmc_OrgName(rs.getString("cmc_OrgName"));
               
                client.setCmc_EmailID1(rs.getString("cmc_EmailID1"));
                client.setCmc_EmailID2(rs.getString("cmc_EmailID2"));
                client.setCmc_CellNo1(rs.getString("cmc_CellNo1"));
                client.setCmc_CellNo2(rs.getString("cmc_CellNo2"));
                client.setCmc_LandlineNo(rs.getString("cmc_LandlineNo"));
                client.setCmc_Addr1(rs.getString("cmc_Addr1"));
                client.setCmc_Addr2(rs.getString("cmc_Addr2"));
                client.setCmc_NearLocation(rs.getString("cmc_NearLocation"));
                client.setCmc_District(rs.getString("cmc_District"));
                client.setCmc_City(rs.getString("cmc_City"));
                client.setCmc_State(rs.getString("cmc_State"));
                client.setCmc_Country(rs.getString("cmc_Country"));

                client.setCmc_PAddr1(rs.getString("cmc_PAddr1"));
                client.setCmc_PAddr2(rs.getString("cmc_PAddr2"));
                client.setCmc_PNearLocation(rs.getString("cmc_PNearLocation"));
                client.setCmc_PDistrict(rs.getString("cmc_PDistrict"));
                client.setCmc_PCity(rs.getString("cmc_PCity"));
                client.setCmc_PState(rs.getString("cmc_State"));
                client.setCmc_PCountry(rs.getString("cmc_Country"));

                

               
                client.setCmc_CreateDate(rs.getDate("cmc_CreateDate"));
                client.setCmc_ModifyDate(rs.getDate("cmc_ModifyDate"));

                client.setCmc_ActiveFlag(rs.getBoolean("cmc_ActiveFlag"));
                client.setCmc_DeleteFlag(rs.getBoolean("cmc_DeleteFlag"));

                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
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
      
      public List<Court> getAllCourt() {
            List<Court> courts = new ArrayList<Court>();
            try {
                System.out.println("im from court");
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
      
      public CaseDetail getLastCaseDetailByID(int CaseMasterID) {
        CaseDetail casemdetail = new CaseDetail();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT ccd_id,cad_id,cad_RegNo,cad_CaseNo,cad_FileNo,cad_FileName,ccd_CurrentDate ,ccd_Stage,ccd_AAdvocate,ccd_Judge,ccd_Rojnama,ccd_Judgment,ccd_Remarks,ccd_Court,ccd_CaseLocation, ccd_CreateDate,ccd_CreateUser,ccd_ModifyDate,ccd_ModifyUser,ccd_ActiveFlag,ccd_DeleteFlag FROM case_tracking_system.cts_casediarydetails WHERE ccd_DeleteFlag = 0 AND cad_id = ? ORDER BY ccd_CurrentDate DESC LIMIT 1");
            preparedStatement.setInt(1, CaseMasterID);
            ResultSet rs = preparedStatement.executeQuery();
 System.out.println("im from getLastCaseDetailByID  " + CaseMasterID);
            if (rs.next()) {
                casemdetail.setCcd_ID(rs.getInt("ccd_id"));
                casemdetail.setCad_ID(rs.getInt("cad_id"));
                casemdetail.setCad_RegNo(rs.getInt("cad_RegNo"));               
                casemdetail.setCcd_CreateUser(rs.getInt("ccd_CreateUser"));
                casemdetail.setCcd_ModifyUser(rs.getInt("ccd_ModifyUser"));                
               
                casemdetail.setCad_CaseNo(rs.getString("cad_CaseNo")); 
                casemdetail.setCad_FileNo(rs.getString("cad_FileNo"));
                casemdetail.setCad_FileName(rs.getString("cad_FileName"));
                casemdetail.setCcd_Stage(rs.getString("ccd_Stage"));
                casemdetail.setCcd_AAdvocate(rs.getString("ccd_AAdvocate"));
                casemdetail.setCcd_Court(rs.getString("ccd_Court"));
                casemdetail.setCcd_CaseLocation(rs.getString("ccd_CaseLocation"));
                casemdetail.setCcd_Judge(rs.getString("ccd_Judge"));
                casemdetail.setCcd_Rojnama(rs.getString("ccd_Rojnama"));
                casemdetail.setCcd_Judgment(rs.getString("ccd_Judgment"));
                casemdetail.setCcd_Remarks(rs.getString("ccd_Remarks"));
                
                
                
                casemdetail.setCcd_CurrentDate(rs.getDate("ccd_CurrentDate"));                
               
                casemdetail.setCcd_CreateDate(rs.getDate("ccd_CreateDate"));
                casemdetail.setCcd_ModifyDate(rs.getDate("ccd_ModifyDate"));

                casemdetail.setCcd_ActiveFlag(rs.getBoolean("ccd_ActiveFlag"));
                casemdetail.setCcd_DeleteFlag(rs.getBoolean("ccd_DeleteFlag"));
               

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casemdetail;
    }
      
      public CaseMaster getMaxRegNo() {
        CaseMaster casemaster = new CaseMaster();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select MAX(cad_RegNo) + 1 AS cad_RegNo from cts_casediarymaster;");
            
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
              
                casemaster.setCad_RegNo(rs.getInt("cad_RegNo"));               

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casemaster;
    }
      
      
      public Client getClientEmailByID(int ClientID) {
        Client client = new Client();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select cmc_EmailID1  from cts_mclients where cmc_ID=?");
            preparedStatement.setInt(1, ClientID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
               client.setCmc_EmailID1(rs.getString("cmc_EmailID1"));
  

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return client;
    }
      
      
       public Client getClientDetails(int CaseID) {
        Client client = new Client();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select cts_mclients.cmc_EmailID1 from cts_mclients,cts_casediarymaster where cts_mclients.cmc_ID=cts_casediarymaster.cmc_ID and cad_ID=?");
            preparedStatement.setInt(1, CaseID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
               client.setCmc_EmailID1(rs.getString("cmc_EmailID1"));
  

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return client;
    }

   
   
      
}
