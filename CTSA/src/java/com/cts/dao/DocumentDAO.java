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
import com.cts.model.Document;
import com.cts.util.Database;
import com.cts.model.CaseDetail;
import com.cts.model.CaseMaster;


public class DocumentDAO {
    
    private Connection connection;
    
     public DocumentDAO() {
        connection = Database.getConnection();
    }
     
     public List<Document> getAllDocument() {
            List<Document> documents = new ArrayList<Document>();
            try {
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery("select * from cts_mdocuments");
                    while (rs.next()) {
                        Document document = new Document();
                   
                        document.setCmd_ID(rs.getInt("cmd_ID"));
                        document.setCmd_CreateUser(rs.getInt("cmd_CreateUser"));
                        document.setCmd_ModifyUser(rs.getInt("cmd_ModifyUser"));
                        
                        document.setCmd_CreateDate(rs.getDate("cmd_CreateDate"));
                        document.setCmd_ModifyDate(rs.getDate("cmd_ModifyDate"));
                        
                        document.setCmd_DocumentType(rs.getString("cmd_DocumentType"));
                        document.setCmd_Description(rs.getString("cmd_Description"));
                        
                        document.setCmd_DeleteFlag(rs.getBoolean("cmd_DeleteFlag"));
                        document.setCmd_ActiveFlag(rs.getBoolean("cmd_ActiveFlag"));
                        
                        
                        
                        documents.add(document);
            }
        }
            catch (SQLException e) {
            e.printStackTrace();
            }
 
            return documents;
        }
     
      public void deleteDocument(int documentID) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from cts_mdocuments where cmd_ID=?");
			// Parameters start with 1
			preparedStatement.setInt(1, documentID);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}   
      
      
       public void addDocument(Document document) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO cts_mdocuments(`cmd_DocumentType`,`cmd_Description`,`cmd_CreateDate`,`cmd_CreateUser`,`cmd_ModifyDate`,`cmd_ModifyUser`,`cmd_DeleteFlag`,`cmd_ActiveFlag`) VALUES(?,?,?,?,?,?,?,?)");
			// Parameters start with 1
			preparedStatement.setString(1, document.getCmd_DocumentType());
			preparedStatement.setString(2, document.getCmd_Description());
                        preparedStatement.setDate(3, new java.sql.Date(document.getCmd_CreateDate().getTime()));
			preparedStatement.setInt(4, document.getCmd_CreateUser());
                        preparedStatement.setDate(5, new java.sql.Date(document.getCmd_ModifyDate().getTime()));
			preparedStatement.setInt(6, document.getCmd_ModifyUser());
                        preparedStatement.setBoolean(7,document.isCmd_DeleteFlag());
                        preparedStatement.setBoolean(8,document.isCmd_ActiveFlag());
                        
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
       
        public void updateDocument(Document document) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE cts_mdocuments SET cmd_DocumentType = ?, cmd_Description = ? WHERE cmd_ID = ?");
			// Parameters start with 1
			preparedStatement.setString(1, document.getCmd_DocumentType());
			preparedStatement.setString(2, document.getCmd_Description());			
                        preparedStatement.setInt(3, document.getCmd_ID());	
                        
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
        
        public Document getCaseDocumentById(int documentID) {
		Document caseStage = new Document();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from cts_mdocuments where cmd_ID=?");
			preparedStatement.setInt(1, documentID);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				caseStage.setCmd_ID(rs.getInt("cmd_ID"));
                                caseStage.setCmd_DocumentType(rs.getString("cmd_DocumentType"));
                                caseStage.setCmd_Description(rs.getString("cmd_Description"));
                                
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return caseStage;
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
    
}