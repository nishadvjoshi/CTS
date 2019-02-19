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
import java.sql.*;
import java.util.*;
import com.cts.model.CaseMaster;
import com.cts.model.CaseStage;
import com.cts.model.Document;
import com.cts.model.Client;
import com.cts.model.City;
import com.cts.model.Court;
import com.cts.util.Database;

public class CaseMasterDAO {
    private Connection connection;
    int generatedKey = 0;

    public CaseMasterDAO() {
        connection = Database.getConnection();
    }
    
    public List<CaseMaster> getAllCaseMaster() {
        List<CaseMaster> casemasters = new ArrayList<CaseMaster>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_casediarymaster;");
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
    
    public void deleteCaseMaster(int CaseMasterID) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from cts_casediarymaster where cad_ID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, CaseMasterID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE cts_casediarydetails SET ccd_DeleteFlag = 1 Where cad_ID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, CaseMasterID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public CaseMaster getCaseMasterById(int CaseMasterID) {
        CaseMaster casemaster = new CaseMaster();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from cts_casediarymaster where cad_ID=?");
            preparedStatement.setInt(1, CaseMasterID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
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

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casemaster;
    }
    
    public int addCaseMaster(CaseMaster casemaster) {
        int i=0;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO cts_casediarymaster"
                            + "(cad_RegNo,cad_CaseType,cad_AssetCode,cad_ClientName,cad_CaseNo,cad_FileNo,cad_FileName,cad_Location,cad_Court,cad_AppearingFor,cad_Advocate,cad_ACT,cad_Stage,cad_VakilPatraFiledBy,cad_VakilPatraFiledOn,cad_CaseCategory,cad_OpponentName,cad_OpponentAdvocate,cad_Remarks,cad_OtherInfo,cad_CreateDate,cad_CreateUser,cad_ModifyDate,cad_ModifyUser,cad_ActiveFlag,cad_DeleteFlag, cmc_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            // Parameters start with 1
            preparedStatement.setInt(1, casemaster.getCad_RegNo());
           
            preparedStatement.setString(2, casemaster.getCad_CaseType());
            preparedStatement.setString(3, casemaster.getCad_AssetCode());
            preparedStatement.setString(4, casemaster.getCad_ClientName());
            preparedStatement.setString(5, casemaster.getCad_CaseNo());
            preparedStatement.setString(6, casemaster.getCad_FileNo());
            preparedStatement.setString(7, casemaster.getCad_FileName());
            preparedStatement.setString(8, casemaster.getCad_Location());
            preparedStatement.setString(9, casemaster.getCad_Court());
            preparedStatement.setString(10, casemaster.getCad_AppearingFor());
            preparedStatement.setString(11, casemaster.getCad_Advocate());
            preparedStatement.setString(12, casemaster.getCad_ACT());
            preparedStatement.setString(13, casemaster.getCad_Stage());
            preparedStatement.setString(14, casemaster.getCad_VakilPatraFiledBy());
            preparedStatement.setDate(15, new java.sql.Date(casemaster.getCad_VakilPatraFiledOn().getTime()));
            preparedStatement.setString(16, casemaster.getCad_CaseCategory());
            preparedStatement.setString(17, casemaster.getCad_OpponentName());
            preparedStatement.setString(18, casemaster.getCad_OpponentAdvocate());
            preparedStatement.setString(19, casemaster.getCad_Remarks());
            preparedStatement.setString(20, casemaster.getCad_OtherInfo());
            preparedStatement.setDate(21, new java.sql.Date(casemaster.getCad_CreateDate().getTime()));
            preparedStatement.setInt(22, casemaster.getCad_CreateUser());
            preparedStatement.setDate(23, new java.sql.Date(casemaster.getCad_ModifyDate().getTime()));
            preparedStatement.setInt(24, casemaster.getCad_ModifyUser());
            preparedStatement.setBoolean(25, casemaster.isCad_ActiveFlag());
            preparedStatement.setBoolean(26, casemaster.isCad_DeleteFlag());
            preparedStatement.setInt(27, casemaster.getCmc_ID());

            i=preparedStatement.executeUpdate();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
            System.out.println("Inserted record's ID: " + generatedKey);
        return i;
    }
    
    public int  updateCaseMaster(CaseMaster casemaster) {
        int j=0;
        int i=0;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE cts_casediarymaster SET cad_RegNo = ?,cad_CaseType = ?,cad_AssetCode = ?,cad_ClientName = ?,cad_CaseNo = ?,cad_FileNo = ?,cad_FileName = ?,cad_Location = ?,cad_Court = ?,cad_AppearingFor = ?,cad_Advocate = ?,cad_ACT = ?,cad_Stage = ?,cad_VakilPatraFiledBy = ?,cad_VakilPatraFiledOn = ?,cad_CaseCategory = ?,cad_OpponentName = ?,cad_OpponentAdvocate = ?,cad_Remarks = ?,cad_OtherInfo = ?,cad_CreateDate = ?,cad_CreateUser = ?,cad_ModifyDate = ?,cad_ModifyUser = ?,cad_ActiveFlag = ?,cad_DeleteFlag = ?, cmc_ID = ? WHERE cad_ID = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, casemaster.getCad_RegNo());
           
            preparedStatement.setString(2, casemaster.getCad_CaseType());
            preparedStatement.setString(3, casemaster.getCad_AssetCode());
            preparedStatement.setString(4, casemaster.getCad_ClientName());
            preparedStatement.setString(5, casemaster.getCad_CaseNo());
            preparedStatement.setString(6, casemaster.getCad_FileNo());
            preparedStatement.setString(7, casemaster.getCad_FileName());
            preparedStatement.setString(8, casemaster.getCad_Location());
            preparedStatement.setString(9, casemaster.getCad_Court());
            preparedStatement.setString(10, casemaster.getCad_AppearingFor());
            preparedStatement.setString(11, casemaster.getCad_Advocate());
            preparedStatement.setString(12, casemaster.getCad_ACT());
            preparedStatement.setString(13, casemaster.getCad_Stage());
            preparedStatement.setString(14, casemaster.getCad_VakilPatraFiledBy());
            preparedStatement.setDate(15, new java.sql.Date(casemaster.getCad_VakilPatraFiledOn().getTime()));
            preparedStatement.setString(16, casemaster.getCad_CaseCategory());
            preparedStatement.setString(17, casemaster.getCad_OpponentName());
            preparedStatement.setString(18, casemaster.getCad_OpponentAdvocate());
            preparedStatement.setString(19, casemaster.getCad_Remarks());
            preparedStatement.setString(20, casemaster.getCad_OtherInfo());
            preparedStatement.setDate(21, new java.sql.Date(casemaster.getCad_CreateDate().getTime()));
            preparedStatement.setInt(22, casemaster.getCad_CreateUser());
            preparedStatement.setDate(23, new java.sql.Date(casemaster.getCad_ModifyDate().getTime()));
            preparedStatement.setInt(24, casemaster.getCad_ModifyUser());
            preparedStatement.setBoolean(25, casemaster.isCad_ActiveFlag());
            preparedStatement.setBoolean(26, casemaster.isCad_DeleteFlag());
            preparedStatement.setInt(27, casemaster.getCmc_ID());
            
            preparedStatement.setInt(28, casemaster.getCad_ID());
            
           i= preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE cts_casediarydetails SET cad_RegNo = ?,cad_CaseNo = ?,cad_FileNo = ?,cad_FileName = ? WHERE cad_ID = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, casemaster.getCad_RegNo());
        
            preparedStatement.setString(2, casemaster.getCad_CaseNo());
            preparedStatement.setString(3, casemaster.getCad_FileNo());
            preparedStatement.setString(4, casemaster.getCad_FileName());
           
            
            preparedStatement.setInt(5, casemaster.getCad_ID());
            
            j=preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if(i>0&&j>0) {
            i=1;
        } else {
            i=0;
        }
        return i;
    }
    
    public List<Document> GetDocumentType() {
        List<Document> casedocuments = new ArrayList<Document>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_casedocuments");
            while (rs.next()) {
                Document casedocument = new Document();
                
                casedocument.setCmd_ID(rs.getInt("cmd_ID"));
                casedocument.setCmd_DocumentType("cmd_DocumentType");
                

                casedocuments.add(casedocument);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casedocuments;
    }
    
    public List<CaseMaster> getARCILBoard() {
        List<CaseMaster> casemasters = new ArrayList<CaseMaster>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_casediarymaster where cad_ClientName='ARCIL' ");
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

    public List<CaseMaster> getARCILBoardByLocation(String cad_Location) {
        List<CaseMaster> casemasters = new ArrayList<CaseMaster>();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from cts_casediarymaster where cmc_ID = 125 AND cad_Location=?");
            preparedStatement.setString(1, cad_Location);
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

    public List<CaseMaster> getAhmedabadBoard() {
        List<CaseMaster> caseAmasters = new ArrayList<CaseMaster>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_casediarymaster where cad_ClientName='ARCIL' AND cad_Location = 'Ahmedabad'");
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

                caseAmasters.add(casemaster);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return caseAmasters;
    }

    public List<CaseMaster> getBangaloreBoard() {
        List<CaseMaster> caseBmasters = new ArrayList<CaseMaster>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_casediarymaster where cad_ClientName='ARCIL' AND cad_Location = 'Bangalore'");
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

                caseBmasters.add(casemaster);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return caseBmasters;
    }

    public List<CaseMaster> getDelhiBoard() {
        List<CaseMaster> caseDmasters = new ArrayList<CaseMaster>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_casediarymaster where cad_ClientName='ARCIL' AND cad_Location = 'Delhi'");
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

                caseDmasters.add(casemaster);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return caseDmasters;
    }

    public List<CaseMaster> getKolkataBoard() {
        List<CaseMaster> caseKmasters = new ArrayList<CaseMaster>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_casediarymaster where cad_ClientName='ARCIL' AND cad_Location = 'Kolkata'");
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

                caseKmasters.add(casemaster);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return caseKmasters;
    }

    public List<CaseMaster> getARCILLocation() {
        List<CaseMaster> caselocations = new ArrayList<CaseMaster>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select distinct cad_Location from cts_casediarymaster where cad_ClientName='ARCIL' ");
            while (rs.next()) {
                CaseMaster casemaster = new CaseMaster();

                casemaster.setCad_Location(rs.getString("cad_Location"));

                caselocations.add(casemaster);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return caselocations;
    }
    
    public List<City> getAllCity() {
        List<City> cities = new ArrayList<City>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_mcity order by ccc_CityName");
            while (rs.next()) {
                City city = new City();

                city.setCcc_CityName(rs.getString("ccc_CityName"));
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cities;
    }
    
    public List<Advocate> getAllAdvocate() {
        List<Advocate> advocates = new ArrayList<Advocate>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_madvocates Order by cam_ID ");
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
}