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
import com.cts.model.CaseDetail;
import com.cts.model.CaseExpenses;
import com.cts.model.CaseMaster;
import com.cts.model.CasePayments;
import com.cts.model.CaseDocument;
import com.cts.model.Client;
import com.cts.model.Court;
import com.cts.model.CaseStage;
import com.cts.util.Database;

public class CaseDocumentDAO {
    private Connection connection;

    public CaseDocumentDAO() {
        connection = Database.getConnection();
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
                casedetail.setCad_ClientName(rs.getString("cad_ClientName"));
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
    
    public int  addCaseDocument(CaseDocument casedocument) {                  
       int i=0;
         
         try {
           
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO cts_casedocuments (cad_id,cad_RegNo,cad_CaseNo,cad_FileName,cdd_DocumentType,cdd_DocumentName,cdd_DocumentRevisedName,cdd_DocumentLocation,cdd_CreateDate,cdd_CreateUser,cdd_ModifyDate,cdd_ModifyUser,cdd_ActiveFlag,cdd_DeleteFlag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setInt(1, casedocument.getCad_id());
            preparedStatement.setInt(2, casedocument.getCad_RegNo());
            preparedStatement.setString(3, casedocument.getCad_CaseNo());
            preparedStatement.setString(4, casedocument.getCad_FileName());
            preparedStatement.setString(5, casedocument.getCdd_DocumentType());
            
            preparedStatement.setString(6, casedocument.getCdd_DocumentName());
            preparedStatement.setString(7, casedocument.getCdd_DocumentRevisedName());
            preparedStatement.setString(8, casedocument.getCdd_DocumentLocation());
           
            
            preparedStatement.setDate(9, new java.sql.Date(casedocument.getCdd_CreateDate().getTime()));
            preparedStatement.setInt(10, casedocument.getCdd_CreateUser());
            preparedStatement.setDate(11, new java.sql.Date(casedocument.getCdd_ModifyDate().getTime()));
            preparedStatement.setInt(12, casedocument.getCdd_ModifyUser());
            preparedStatement.setBoolean(13, casedocument.isCdd_ActiveFlag());
            preparedStatement.setBoolean(14, casedocument.isCdd_DeleteFlag());
          
            i=preparedStatement.executeUpdate();
  System.out.println("\n\n im from add case document"+casedocument.getCad_RegNo());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\n\n error in database insertion"+e);
        }
        return i;
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
    
    
    public List<CaseDocument> getAllCaseDocuments() {
        List<CaseDocument> casedocuments = new ArrayList<CaseDocument>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT cdd_DocumentName FROM cts_casedocuments");
            while (rs.next()) {
                CaseDocument casedocument = new CaseDocument();

                               
                casedocument.setCdd_DocumentName(rs.getString("cdd_DocumentName"));
                

                casedocuments.add(casedocument);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casedocuments;
    }
    
    public List<CaseDocument> getCaseDocuments(Integer CaseMasterID) {
        List<CaseDocument> casedocuments = new ArrayList<CaseDocument>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT cdd_DocumentLocation,cdd_DocumentName,cdd_DocumentType,cdd_CreateDate FROM cts_casedocuments where cad_ID = ?");
            preparedStatement.setInt(1, CaseMasterID);
            ResultSet rs = preparedStatement.executeQuery();
           
            while (rs.next()) {
                CaseDocument casedocument = new CaseDocument();

                               
                casedocument.setCdd_DocumentName(rs.getString("cdd_DocumentName"));
                casedocument.setCdd_DocumentType(rs.getString("cdd_DocumentType"));
                casedocument.setCdd_CreateDate(rs.getDate("cdd_CreateDate"));
                 casedocument.setCdd_DocumentLocation(rs.getString("cdd_DocumentLocation"));

                casedocuments.add(casedocument);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casedocuments;
    }
    
    
}
