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
import com.cts.model.CaseExpenses;
import com.cts.model.CaseMaster;
import com.cts.model.TaskMaster;
import com.cts.model.Client;
import com.cts.model.Court;
import com.cts.model.CaseStage;
import com.cts.util.Database;

public class CaseExpenseDAO {
    private Connection connection;

    public CaseExpenseDAO() {
        connection = Database.getConnection();
    }
    
    public void addCaseExpense(CaseExpenses caseexpense) {                  
      
         try {
             
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO cts_caseexpenses (cad_ID,cad_RegNo,cad_CaseNo,cad_FileNo,cad_FileName,cad_ClientName,cce_ExpenseDate,cce_ExpenseType,cce_ExpenseAmount,cce_ExpenseBy,cce_ExpenseInvoiceNo,cce_CreateDate,cce_CreateUser,cce_ModifyDate,cce_ModifyUser,cce_ActiveFlag,cce_DeleteFlag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                           
            // Parameters start with 1
             preparedStatement.setInt(1, caseexpense.getCad_ID());

            preparedStatement.setInt(2, caseexpense.getCad_RegNo());
            preparedStatement.setString(3, caseexpense.getCad_CaseNo());
            preparedStatement.setString(4, caseexpense.getCad_FileNo());
            preparedStatement.setString(5, caseexpense.getCad_FileName());
            preparedStatement.setString(6, caseexpense.getCad_ClientName());
            preparedStatement.setDate(7, new java.sql.Date(caseexpense.getCce_ExpenseDate().getTime()));
            preparedStatement.setString(8, caseexpense.getCce_ExpenseType());
            preparedStatement.setDouble(9, caseexpense.getCce_ExpenseAmount());
            
            preparedStatement.setString(10, caseexpense.getCce_ExpenseBy());
            preparedStatement.setString(11, caseexpense.getCce_ExpenseInvoiceNo());
            
  
            preparedStatement.setDate(12, new java.sql.Date(caseexpense.getCce_CreateDate().getTime()));
            preparedStatement.setInt(13, caseexpense.getCce_CreateUser());
            preparedStatement.setDate(14, new java.sql.Date(caseexpense.getCce_ModifyDate().getTime()));
            preparedStatement.setInt(15, caseexpense.getCce_ModifyUser());
            preparedStatement.setBoolean(16, caseexpense.isCce_ActiveFlag());
            preparedStatement.setBoolean(17, caseexpense.isCce_DeleteFlag());
           
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                 casedetail.setCad_ClientName(rs.getString("cad_ClientName"));
                
                
                
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
    
    public List<CaseExpenses> getAllCaseExpenseByID(int CaseMasterID) {
        List<CaseExpenses> caseexpensestable = new ArrayList<CaseExpenses>();
        try {
            
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT cce_ID,cad_ID,cad_RegNo,cad_CaseNo,cad_FileNo,cad_FileName,cad_ClientName,cce_ExpenseDate,cce_ExpenseType,cce_ExpenseAmount,cce_ExpenseBy,cce_ExpenseInvoiceNo FROM cts_caseexpenses where cad_ID = ? AND cce_DeleteFlag = 0");
            preparedStatement.setInt(1, CaseMasterID);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                CaseExpenses caseexpensetable = new CaseExpenses();

                caseexpensetable.setCce_ID(rs.getInt("cce_ID"));
                caseexpensetable.setCad_ID(rs.getInt("cad_ID"));
                caseexpensetable.setCad_RegNo(rs.getInt("cad_RegNo"));
                caseexpensetable.setCad_CaseNo(rs.getString("cad_CaseNo"));
                caseexpensetable.setCad_FileNo(rs.getString("cad_FileNo"));
                caseexpensetable.setCad_FileName(rs.getString("cad_FileName"));
                caseexpensetable.setCad_ClientName(rs.getString("cad_ClientName"));
                caseexpensetable.setCce_ExpenseDate(rs.getDate("cce_ExpenseDate"));
                caseexpensetable.setCce_ExpenseType(rs.getString("cce_ExpenseType"));
                caseexpensetable.setCce_ExpenseAmount(rs.getDouble("cce_ExpenseAmount"));
                caseexpensetable.setCce_ExpenseBy(rs.getString("cce_ExpenseBy"));
                caseexpensetable.setCce_ExpenseInvoiceNo(rs.getString("cce_ExpenseInvoiceNo"));
                                
                

                caseexpensestable.add(caseexpensetable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return caseexpensestable;
    }
    
    public List<CaseExpenses> getAllCaseExpenseByExpenseID(int CaseExpenseID) {
        List<CaseExpenses> caseexpensestable = new ArrayList<CaseExpenses>();
        try {
            
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT cce_ID,cad_ID,cad_RegNo,cad_CaseNo,cad_FileNo,cad_FileName,cad_ClientName,cce_ExpenseDate,cce_ExpenseType,cce_ExpenseAmount,cce_ExpenseBy,cce_ExpenseInvoiceNo FROM cts_caseexpenses where cad_ID = (Select cad_ID  from cts_caseexpenses where cce_ID = ?) AND cce_DeleteFlag = 0");
            preparedStatement.setInt(1, CaseExpenseID);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                CaseExpenses caseexpensetable = new CaseExpenses();

                caseexpensetable.setCce_ID(rs.getInt("cce_ID"));
                caseexpensetable.setCad_ID(rs.getInt("cad_ID"));
                caseexpensetable.setCad_RegNo(rs.getInt("cad_RegNo"));
                caseexpensetable.setCad_CaseNo(rs.getString("cad_CaseNo"));
                caseexpensetable.setCad_FileNo(rs.getString("cad_FileNo"));
                caseexpensetable.setCad_FileName(rs.getString("cad_FileName"));
                caseexpensetable.setCad_ClientName(rs.getString("cad_ClientName"));
                caseexpensetable.setCce_ExpenseDate(rs.getDate("cce_ExpenseDate"));
                caseexpensetable.setCce_ExpenseType(rs.getString("cce_ExpenseType"));
                caseexpensetable.setCce_ExpenseAmount(rs.getDouble("cce_ExpenseAmount"));
                caseexpensetable.setCce_ExpenseBy(rs.getString("cce_ExpenseBy"));
                caseexpensetable.setCce_ExpenseInvoiceNo(rs.getString("cce_ExpenseInvoiceNo"));
                                
                

                caseexpensestable.add(caseexpensetable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return caseexpensestable;
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
    
    public CasePayments getCaseDetailByExpenseId(int CaseExpenseID) {
        CasePayments casedetail = new CasePayments();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT cad_ID,cad_RegNo,cad_CaseNo,cad_FileNo,cad_FileName,cad_ClientName from cts_caseexpenses where cad_ID = (Select cad_ID  from cts_caseexpenses where cce_ID = ?)   AND cce_DeleteFlag = 0");
            preparedStatement.setInt(1, CaseExpenseID);
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
    
    public void deleteCaseExpense(int CaseExpenseID) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE cts_caseexpenses SET cce_DeleteFlag = 1 Where cce_ID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, CaseExpenseID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public CaseExpenses getCaseExpenseByID(int CaseExpenseID) {
        CaseExpenses caseexpense = new CaseExpenses();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT cce_ID,cad_ID,cad_RegNo,cad_CaseNo,cad_FileNo,cad_FileName,cad_ClientName,cce_ExpenseDate,cce_ExpenseType,cce_ExpenseAmount,cce_ExpenseBy,cce_ExpenseInvoiceNo FROM cts_caseexpenses where cce_ID = ? AND cce_DeleteFlag = 0");
            preparedStatement.setInt(1, CaseExpenseID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                //casedetail.setCcd_ID(rs.getInt("ccd_id"));
                caseexpense.setCce_ID(rs.getInt("cce_ID"));
                caseexpense.setCad_ID(rs.getInt("cad_ID"));
                caseexpense.setCad_RegNo(rs.getInt("cad_RegNo"));
                caseexpense.setCad_CaseNo(rs.getString("cad_CaseNo"));
                caseexpense.setCad_FileNo(rs.getString("cad_FileNo"));
                caseexpense.setCad_FileName(rs.getString("cad_FileName"));
                caseexpense.setCad_ClientName(rs.getString("cad_ClientName"));
                caseexpense.setCce_ExpenseDate(rs.getDate("cce_ExpenseDate"));
                caseexpense.setCce_ExpenseType(rs.getString("cce_ExpenseType"));
                caseexpense.setCce_ExpenseAmount(rs.getDouble("cce_ExpenseAmount"));
                caseexpense.setCce_ExpenseBy(rs.getString("cce_ExpenseBy"));
                caseexpense.setCce_ExpenseInvoiceNo(rs.getString("cce_ExpenseInvoiceNo"));
                                
               

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return caseexpense;
    }
    
     public CaseExpenses getCaseCaseExpenseTotalID(int CaseMasterID) {
        CaseExpenses caseexpensetotal = new CaseExpenses();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT SUM(cce_ExpenseAmount) AS cce_ExpenseAmount FROM cts_caseexpenses where cce_DeleteFlag = 0 GROUP BY cad_ID Having cad_ID = ?");
            preparedStatement.setInt(1, CaseMasterID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                //casedetail.setCcd_ID(rs.getInt("ccd_id"));

                caseexpensetotal.setCce_ExpenseAmount(rs.getDouble("cce_ExpenseAmount"));
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return caseexpensetotal;
    }
    
    
     public void updateCaseExpense(CaseExpenses casexpense) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE cts_caseexpenses SET cce_ExpenseDate = ?, cce_ExpenseType = ?, cce_ExpenseAmount = ?, cce_ExpenseBy = ?, cce_ExpenseInvoiceNo = ?, cce_CreateDate = ?, cce_CreateUser = ?, cce_ModifyDate = ?, cce_ModifyUser = ? WHERE cce_ID = ?");
            // Parameters start with 1
        
            preparedStatement.setDate(1, new java.sql.Date(casexpense.getCce_ExpenseDate().getTime()));
            
            preparedStatement.setString(2, casexpense.getCce_ExpenseType());
            preparedStatement.setDouble(3, casexpense.getCce_ExpenseAmount());
            preparedStatement.setString(4, casexpense.getCce_ExpenseBy());
            preparedStatement.setString(5, casexpense.getCce_ExpenseInvoiceNo());            
            preparedStatement.setDate(6, new java.sql.Date(casexpense.getCce_CreateDate().getTime()));
            preparedStatement.setInt(7, casexpense.getCce_CreateUser());
            preparedStatement.setDate(8, new java.sql.Date(casexpense.getCce_ModifyDate().getTime()));
            preparedStatement.setInt(9, casexpense.getCce_ModifyUser());
            
            preparedStatement.setInt(10, casexpense.getCce_ID());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      
     
   
}
