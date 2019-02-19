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
import com.cts.model.CaseDetail;
import com.cts.model.CasePayments;
import com.cts.model.CaseMaster;
import com.cts.model.TaskMaster;
import com.cts.model.Client;
import com.cts.model.Court;
import com.cts.model.CaseStage;
import com.cts.util.Database;

public class CasePaymentsDAO {
    private Connection connection;

    public CasePaymentsDAO() {
        connection = Database.getConnection();
    }
    
   
    
     public List<CasePayments> getAllCasePaymentByID(int CaseMasterID) {
        List<CasePayments> casepaymentstable = new ArrayList<CasePayments>();
        try {
            
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT ccp_ID,cad_ID,cad_RegNo,cad_CaseNo,cad_FileNo,cad_FileName,cad_ClientName,ccp_PaymentDate,ccp_PaymentType,ccp_PaymentAmount, ccp_PaymentChequeDate,ccp_PaymentChequeNo,ccp_PaymentChequeName,ccp_NEFTTransactionNo,ccp_TDSAmount,ccp_DepositBank, ccp_CreateDate,ccp_CreateUser,ccp_ModifyDate,ccp_ModifyUser,ccp_ActiveFlag,ccp_DeleteFlag,ccp_PaymentChequeBank FROM cts_casepayments where cad_ID = ? AND ccp_DeleteFlag = 0 ORDER BY ccp_PaymentDate DESC");
            preparedStatement.setInt(1, CaseMasterID);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                CasePayments casepaymenttable = new CasePayments();

                casepaymenttable.setCcp_ID(rs.getInt("ccp_ID"));
                casepaymenttable.setCad_ID(rs.getInt("cad_ID"));
                casepaymenttable.setCad_RegNo(rs.getInt("cad_RegNo"));
                casepaymenttable.setCad_CaseNo(rs.getString("cad_CaseNo"));
                casepaymenttable.setCad_FileNo(rs.getString("cad_FileNo"));
                casepaymenttable.setCad_FileName(rs.getString("cad_FileName"));
                casepaymenttable.setCad_ClientName(rs.getString("cad_ClientName"));
                casepaymenttable.setCcp_PaymentDate(rs.getDate("ccp_PaymentDate"));
                casepaymenttable.setCcp_PaymentType(rs.getString("ccp_PaymentType"));
                casepaymenttable.setCcp_PaymentAmount(rs.getString("ccp_PaymentAmount"));
                casepaymenttable.setCcp_PaymentChequeDate(rs.getDate("ccp_PaymentChequeDate"));
                casepaymenttable.setCcp_PaymentChequeNo(rs.getString("ccp_PaymentChequeNo"));
                casepaymenttable.setCcp_PaymentChequeName(rs.getString("ccp_PaymentChequeName"));
                casepaymenttable.setCcp_NEFTTransactionNo(rs.getString("ccp_NEFTTransactionNo"));
                casepaymenttable.setCcp_TDSAmount(rs.getString("ccp_TDSAmount"));
                casepaymenttable.setCcp_DepositBank(rs.getString("ccp_DepositBank"));
                casepaymenttable.setCcp_CreateUser(rs.getInt("ccp_CreateUser"));
                casepaymenttable.setCcp_ModifyUser(rs.getInt("ccp_ModifyUser"));   
                casepaymenttable.setCcp_PaymentChequeBank(rs.getString("ccp_PaymentChequeBank"));
               
                                                             
                
            
                
                casepaymenttable.setCcp_CreateDate(rs.getDate("ccp_CreateDate"));
                casepaymenttable.setCcp_ModifyDate(rs.getDate("ccp_ModifyDate"));

                casepaymenttable.setCcp_ActiveFlag(rs.getBoolean("ccp_ActiveFlag"));
                casepaymenttable.setCcp_DeleteFlag(rs.getBoolean("ccp_DeleteFlag"));

                casepaymentstable.add(casepaymenttable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casepaymentstable;
    }
     public List<CasePayments> getAllCasePaymentByPaymentID(int CasePaymentID) {
        List<CasePayments> casepaymentstable = new ArrayList<CasePayments>();
        try {
            
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT ccp_ID,cad_ID,cad_RegNo,cad_CaseNo,cad_FileNo,cad_FileName,cad_ClientName,ccp_PaymentDate,ccp_PaymentType,ccp_PaymentAmount, ccp_PaymentChequeDate,ccp_PaymentChequeNo,ccp_PaymentChequeName,ccp_PaymentChequeBank,ccp_NEFTTransactionNo,ccp_TDSAmount,ccp_DepositBank,ccp_CreateDate,ccp_CreateUser,ccp_ModifyDate,ccp_ModifyUser,ccp_ActiveFlag,ccp_DeleteFlag FROM cts_casepayments where cad_ID = (Select cad_ID  from cts_casepayments where ccp_ID = ?) AND ccp_DeleteFlag = 0");
            preparedStatement.setInt(1, CasePaymentID);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                CasePayments casepaymenttable = new CasePayments();

                casepaymenttable.setCcp_ID(rs.getInt("ccp_ID"));
                casepaymenttable.setCad_ID(rs.getInt("cad_ID"));
                casepaymenttable.setCad_RegNo(rs.getInt("cad_RegNo"));
                casepaymenttable.setCad_CaseNo(rs.getString("cad_CaseNo"));
                casepaymenttable.setCad_FileNo(rs.getString("cad_FileNo"));
                casepaymenttable.setCad_FileName(rs.getString("cad_FileName"));
                casepaymenttable.setCad_ClientName(rs.getString("cad_ClientName"));
                casepaymenttable.setCcp_PaymentDate(rs.getDate("ccp_PaymentDate"));
                casepaymenttable.setCcp_PaymentType(rs.getString("ccp_PaymentType"));
                casepaymenttable.setCcp_PaymentAmount(rs.getString("ccp_PaymentAmount"));
                casepaymenttable.setCcp_PaymentChequeDate(rs.getDate("ccp_PaymentChequeDate"));
                casepaymenttable.setCcp_PaymentChequeNo(rs.getString("ccp_PaymentChequeNo"));
                casepaymenttable.setCcp_PaymentChequeName(rs.getString("ccp_PaymentChequeName"));
                casepaymenttable.setCcp_NEFTTransactionNo(rs.getString("ccp_NEFTTransactionNo"));
                casepaymenttable.setCcp_TDSAmount(rs.getString("ccp_TDSAmount"));
                casepaymenttable.setCcp_DepositBank(rs.getString("ccp_DepositBank"));
                casepaymenttable.setCcp_PaymentChequeBank(rs.getString("ccp_PaymentChequeBank"));
                casepaymenttable.setCcp_CreateUser(rs.getInt("ccp_CreateUser"));
                casepaymenttable.setCcp_ModifyUser(rs.getInt("ccp_ModifyUser"));                
               
                                                             
                
                
                casepaymenttable.setCcp_CreateDate(rs.getDate("ccp_CreateDate"));
                casepaymenttable.setCcp_ModifyDate(rs.getDate("ccp_ModifyDate"));

                casepaymenttable.setCcp_ActiveFlag(rs.getBoolean("ccp_ActiveFlag"));
                casepaymenttable.setCcp_DeleteFlag(rs.getBoolean("ccp_DeleteFlag"));
                
                
                casepaymentstable.add(casepaymenttable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casepaymentstable;
    }
     
     public List<CaseDetail> getAllCaseDetailByDetailID(int CaseDetailID) {
        List<CaseDetail> casedetails = new ArrayList<CaseDetail>();
        try {
            
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT ccd_id,cts_casediarymaster.cad_id,cts_casediarymaster.cad_RegNo,cts_casediarymaster.cad_CaseNo,cts_casediarymaster.cad_FileNo,cts_casediarymaster.cad_FileName,ccd_CurrentDate,ccd_Stage,ccd_AAdvocate, ccd_Judge,ccd_Rojnama,ccd_Judgment,ccd_Remarks,ccd_Court,ccd_CreateDate,ccd_CreateUser,ccd_ModifyDate,ccd_ModifyUser,ccd_ActiveFlag,ccd_DeleteFlag FROM cts_casediarymaster LEFT JOIN cts_casediarydetails ON cts_casediarymaster.cad_ID = cts_casediarydetails.cad_ID where cts_casediarymaster.cad_id = (Select cts_casediarydetails.cad_id from cts_casediarydetails where cts_casediarydetails.ccd_id = ? ) AND ccd_DeleteFlag = 0  Order By ccd_CurrentDate DESC");
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
                casedetail.setCcd_Judge(rs.getString("ccd_Judge"));
                casedetail.setCcd_Rojnama(rs.getString("ccd_Rojnama"));
                casedetail.setCcd_Judgment(rs.getString("ccd_Judgment"));
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
    
     public void deleteCasePayment(int CasePaymentID) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE cts_casepayments SET ccp_DeleteFlag = 1 Where ccp_ID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, CasePaymentID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public CasePayments getCasePaymentByID(int CasePaymentID) {
        CasePayments casepayment = new CasePayments();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT ccp_ID,cad_ID,cad_RegNo,cad_CaseNo,cad_FileNo,cad_FileName,cad_ClientName,ccp_PaymentDate,ccp_PaymentType,ccp_PaymentAmount, ccp_PaymentChequeDate,ccp_PaymentChequeNo,ccp_PaymentChequeName,ccp_NEFTTransactionNo,ccp_TDSAmount,ccp_DepositBank,ccp_CreateDate,ccp_CreateUser,ccp_ModifyDate,ccp_ModifyUser,ccp_ActiveFlag,ccp_DeleteFlag,ccp_PaymentChequeBank FROM cts_casepayments where ccp_ID = ? AND ccp_DeleteFlag = 0");
            preparedStatement.setInt(1, CasePaymentID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                //casedetail.setCcd_ID(rs.getInt("ccd_id"));
                casepayment.setCcp_ID(rs.getInt("ccp_ID"));
                casepayment.setCad_ID(rs.getInt("cad_ID"));
                casepayment.setCad_RegNo(rs.getInt("cad_RegNo"));
                casepayment.setCad_CaseNo(rs.getString("cad_CaseNo"));
                casepayment.setCad_FileNo(rs.getString("cad_FileNo"));
                casepayment.setCad_FileName(rs.getString("cad_FileName"));
                casepayment.setCad_ClientName(rs.getString("cad_ClientName"));
                casepayment.setCcp_PaymentDate(rs.getDate("ccp_PaymentDate"));
                casepayment.setCcp_PaymentType(rs.getString("ccp_PaymentType"));
                casepayment.setCcp_PaymentAmount(rs.getString("ccp_PaymentAmount"));
                casepayment.setCcp_PaymentChequeDate(rs.getDate("ccp_PaymentChequeDate"));
                casepayment.setCcp_PaymentChequeNo(rs.getString("ccp_PaymentChequeNo"));
                casepayment.setCcp_PaymentChequeName(rs.getString("ccp_PaymentChequeName"));
                casepayment.setCcp_NEFTTransactionNo(rs.getString("ccp_NEFTTransactionNo"));
                casepayment.setCcp_TDSAmount(rs.getString("ccp_TDSAmount"));                
                casepayment.setCcp_DepositBank(rs.getString("ccp_DepositBank"));
                casepayment.setCcp_CreateUser(rs.getInt("ccp_CreateUser"));
                casepayment.setCcp_ModifyUser(rs.getInt("ccp_ModifyUser"));                
               
                                                             
                
                
                casepayment.setCcp_CreateDate(rs.getDate("ccp_CreateDate"));
                casepayment.setCcp_ModifyDate(rs.getDate("ccp_ModifyDate"));

                casepayment.setCcp_ActiveFlag(rs.getBoolean("ccp_ActiveFlag"));
                casepayment.setCcp_DeleteFlag(rs.getBoolean("ccp_DeleteFlag"));
                casepayment.setCcp_PaymentChequeBank(rs.getString("ccp_PaymentChequeBank"));
               

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casepayment;
    }
     
     public CaseDetail getCaseDetailById(int CaseMasterID) {
        CaseDetail casedetail = new CaseDetail();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT ccd_id,cts_casediarymaster.cad_id,cts_casediarymaster.cad_RegNo,cts_casediarymaster.cad_CaseNo,cts_casediarymaster.cad_FileNo,cts_casediarymaster.cad_FileName,cts_casediarymaster.cad_AssetCode, cts_casediarymaster.cad_ClientName, cts_casediarymaster.cad_Location, cts_casediarymaster.cad_Court, cts_casediarymaster.cad_AppearingFor, cts_casediarymaster.cad_Advocate, cts_casediarymaster.cad_ACT, cts_casediarymaster.cad_Stage, cts_casediarymaster.cad_VakilPatraFiledBy, cts_casediarymaster.cad_VakilPatraFiledOn, cts_casediarymaster.cad_CaseCategory, cts_casediarymaster.cad_OpponentName, cts_casediarymaster.cad_OpponentAdvocate, cts_casediarymaster.cad_Remarks, cts_casediarymaster.cad_OtherInfo, MAX(ccd_CurrentDate) AS ccd_CurrentDate,ccd_Stage,ccd_AAdvocate, ccd_Judge,ccd_Rojnama,ccd_Judgment,ccd_Remarks,ccd_Court,ccd_CreateDate,ccd_CreateUser,ccd_ModifyDate,ccd_ModifyUser,ccd_ActiveFlag,ccd_DeleteFlag FROM cts_casediarymaster LEFT JOIN cts_casediarydetails ON cts_casediarymaster.cad_ID = cts_casediarydetails.cad_ID where cts_casediarymaster.cad_id = ? AND ccd_DeleteFlag = 0");
            preparedStatement.setInt(1, CaseMasterID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                //casedetail.setCcd_ID(rs.getInt("ccd_id"));
                casedetail.setCad_ID(rs.getInt("cad_id"));
                casedetail.setCad_RegNo(rs.getInt("cad_RegNo"));               
                casedetail.setCcd_CreateUser(rs.getInt("ccd_CreateUser"));
                casedetail.setCcd_ModifyUser(rs.getInt("ccd_ModifyUser"));                
               
                casedetail.setCad_CaseNo(rs.getString("cad_CaseNo"));                
                casedetail.setCad_FileName(rs.getString("cad_FileName"));
                casedetail.setCcd_Stage(rs.getString("ccd_Stage"));
                casedetail.setCcd_AAdvocate(rs.getString("ccd_AAdvocate"));
                casedetail.setCcd_Court(rs.getString("ccd_Court"));
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
     
     public CasePayments getCaseDetailByPaymentId(int CasePaymentID) {
        CasePayments casedetail = new CasePayments();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT cad_ID,cad_RegNo,cad_CaseNo,cad_FileNo,cad_FileName,cad_ClientName from cts_casepayments where cad_ID = (Select cad_ID  from cts_casepayments where ccp_ID = ?)  AND ccp_DeleteFlag = 0");
            preparedStatement.setInt(1, CasePaymentID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                //casedetail.setCcd_ID(rs.getInt("ccd_id"));
                casedetail.setCad_ID(rs.getInt("cad_ID"));
                casedetail.setCad_RegNo(rs.getInt("cad_RegNo"));               
                              
               
                casedetail.setCad_CaseNo(rs.getString("cad_CaseNo"));                
                casedetail.setCad_FileName(rs.getString("cad_FileName"));
                casedetail.setCad_FileNo(rs.getString("cad_FileNo"));
                casedetail.setCad_ClientName(rs.getString("cad_ClientName"));
                
               

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casedetail;
    }
     
     public CasePayments getCaseDetailByCaseID(int CaseMasterID) {
        CasePayments casedetail = new CasePayments();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT cad_ID,cad_RegNo,cad_CaseNo,cad_FileNo,cad_FileName,cad_ClientName from cts_casepayments where cad_ID = ?  AND ccp_DeleteFlag = 0");
            preparedStatement.setInt(1, CaseMasterID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                //casedetail.setCcd_ID(rs.getInt("ccd_id"));
                casedetail.setCad_ID(rs.getInt("cad_ID"));
                casedetail.setCad_RegNo(rs.getInt("cad_RegNo"));               
                              
               
                casedetail.setCad_CaseNo(rs.getString("cad_CaseNo"));                
                casedetail.setCad_FileName(rs.getString("cad_FileName"));
                casedetail.setCad_FileNo(rs.getString("cad_FileNo"));
                casedetail.setCad_ClientName(rs.getString("cad_ClientName"));
                
               

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casedetail;
    }
     
     
     public CaseDetail getCaseDetailByDId(int CaseDetailID) {
        CaseDetail casedetail = new CaseDetail();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT ccd_id,cad_id,cad_RegNo,cad_CaseNo,cad_FileNo,cad_FileName,MAX(ccd_CurrentDate) AS ccd_CurrentDate ,ccd_Stage,ccd_AAdvocate,ccd_Judge,ccd_Rojnama,ccd_Judgment,ccd_Remarks,ccd_Court,ccd_CreateDate,ccd_CreateUser,ccd_ModifyDate,ccd_ModifyUser,ccd_ActiveFlag,ccd_DeleteFlag FROM case_tracking_system.cts_casediarydetails where ccd_id = ?");
            preparedStatement.setInt(1, CaseDetailID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
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
     
     public void addCaseDetail(CaseDetail casedetail) {                  
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE cts_casediarydetails SET ccd_ActiveFlag = FALSE WHERE cad_id = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, casedetail.getCad_ID());
               preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
         
         try {
             
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO cts_casediarydetails"
                            + "(cad_id,cad_RegNo,cad_CaseNo,cad_FileName,ccd_CurrentDate,ccd_Stage,ccd_Rojnama,ccd_Judgment,ccd_Remarks,ccd_Court,ccd_CreateDate,ccd_CreateUser,ccd_ModifyDate,ccd_ModifyUser,ccd_ActiveFlag,ccd_DeleteFlag,cad_FileNo,ccd_Judge, ccd_AAdvocate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
            
            
            preparedStatement.setDate(11, new java.sql.Date(casedetail.getCcd_CreateDate().getTime()));
            preparedStatement.setInt(12, casedetail.getCcd_CreateUser());
            preparedStatement.setDate(13, new java.sql.Date(casedetail.getCcd_ModifyDate().getTime()));
            preparedStatement.setInt(14, casedetail.getCcd_ModifyUser());
            preparedStatement.setBoolean(15, casedetail.isCcd_ActiveFlag());
            preparedStatement.setBoolean(16, casedetail.isCcd_DeleteFlag());
            preparedStatement.setString(17, casedetail.getCad_FileNo());
            preparedStatement.setString(18, casedetail.getCcd_Judge());
            preparedStatement.setString(19, casedetail.getCcd_AAdvocate());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public int addCasePayment(CasePayments casepayment) {    
         int i=0;
      
         try {
             
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO cts_casepayments (cad_ID,cad_RegNo,cad_CaseNo,cad_FileNo,cad_FileName,cad_ClientName,ccp_PaymentDate,ccp_PaymentType,ccp_PaymentAmount,ccp_PaymentChequeDate,ccp_PaymentChequeNo,ccp_PaymentChequeName,ccp_NEFTTransactionNo,ccp_TDSAmount,ccp_CreateDate,ccp_CreateUser,ccp_ModifyDate,ccp_ModifyUser,ccp_ActiveFlag,ccp_DeleteFlag,ccp_DepositBank,ccp_PaymentChequeBank)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                           
            // Parameters start with 1
             preparedStatement.setInt(1, casepayment.getCad_ID());

            preparedStatement.setInt(2, casepayment.getCad_RegNo());
            preparedStatement.setString(3, casepayment.getCad_CaseNo());
            preparedStatement.setString(4, casepayment.getCad_FileNo());
            preparedStatement.setString(5, casepayment.getCad_FileName());
            preparedStatement.setString(6, casepayment.getCad_ClientName());
            preparedStatement.setDate(7, new java.sql.Date(casepayment.getCcp_PaymentDate().getTime()));
            preparedStatement.setString(8, casepayment.getCcp_PaymentType());
            preparedStatement.setString(9, casepayment.getCcp_PaymentAmount());
            if (casepayment.getCcp_PaymentChequeDate() == null)
            {
                preparedStatement.setDate(10, null);
            }
            else {
            preparedStatement.setDate(10, new java.sql.Date(casepayment.getCcp_PaymentChequeDate().getTime()));
            }
            preparedStatement.setString(11, casepayment.getCcp_PaymentChequeNo());
            preparedStatement.setString(12, casepayment.getCcp_PaymentChequeName());
            preparedStatement.setString(13, casepayment.getCcp_NEFTTransactionNo());
            preparedStatement.setString(14, casepayment.getCcp_TDSAmount());
  
            preparedStatement.setDate(15, new java.sql.Date(casepayment.getCcp_CreateDate().getTime()));
            preparedStatement.setInt(16, casepayment.getCcp_CreateUser());
            preparedStatement.setDate(17, new java.sql.Date(casepayment.getCcp_ModifyDate().getTime()));
            preparedStatement.setInt(18, casepayment.getCcp_ModifyUser());
            preparedStatement.setBoolean(19, casepayment.isCcp_ActiveFlag());
            preparedStatement.setBoolean(20, casepayment.isCcp_DeleteFlag());
            preparedStatement.setString(21, casepayment.getCcp_DepositBank());
            preparedStatement.setString(22, casepayment.getCcp_PaymentChequeBank());
            
            i=preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
     
      public int updateCasePayment(CasePayments casepayment) {
          int i=0;
          
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE cts_casepayments SET ccp_PaymentDate = ?, ccp_PaymentType = ?, ccp_PaymentAmount = ?, ccp_PaymentChequeDate = ?, ccp_PaymentChequeNo = ?, ccp_PaymentChequeName = ?, ccp_NEFTTransactionNo = ?, ccp_TDSAmount = ?, ccp_DepositBank = ?, ccp_ModifyDate = ?, ccp_ModifyUser = ?, ccp_PaymentChequeBank = ? WHERE ccp_ID = ?");
            // Parameters start with 1
            preparedStatement.setDate(1, new java.sql.Date(casepayment.getCcp_PaymentDate().getTime()));
            preparedStatement.setString(2, casepayment.getCcp_PaymentType());
            preparedStatement.setString(3, casepayment.getCcp_PaymentAmount());
            preparedStatement.setDate(4, new java.sql.Date(casepayment.getCcp_PaymentChequeDate().getTime()));
            preparedStatement.setString(5, casepayment.getCcp_PaymentChequeNo());
            preparedStatement.setString(6, casepayment.getCcp_PaymentChequeName());
            preparedStatement.setString(7, casepayment.getCcp_NEFTTransactionNo());
            preparedStatement.setString(8, casepayment.getCcp_TDSAmount());
            preparedStatement.setString(9, casepayment.getCcp_DepositBank());
            preparedStatement.setDate(10, new java.sql.Date(casepayment.getCcp_ModifyDate().getTime()));
            preparedStatement.setInt(11, casepayment.getCcp_ModifyUser());
            preparedStatement.setString(12, casepayment.getCcp_PaymentChequeBank());
            preparedStatement.setInt(13, casepayment.getCcp_ID());
            
            i=preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
      
      public List<CaseMaster> getAllCaseMaster() {
        List<CaseMaster> casemasters = new ArrayList<CaseMaster>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_casediarymaster");
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
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_madvocates");
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
}
