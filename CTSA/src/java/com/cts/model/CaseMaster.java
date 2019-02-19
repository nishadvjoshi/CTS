/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.model;

import java.util.Date;

/**
 *
 * @author nishad
 */
public class CaseMaster {
    Date cad_CreateDate, cad_ModifyDate,cad_VakilPatraFiledOn;
    boolean cad_DeleteFlag,cad_ActiveFlag ;
    int cad_ID, cad_RegNo, cad_CreateUser,cad_ModifyUser,cad_CaseMasterCount, cmc_ID;
    
    String cad_CaseNo, cad_ClientName, cad_Stage, cad_FileName,cad_Location,cad_Court,cad_AppearingFor;
    String cad_Advocate,cad_ACT,cad_VakilPatraFiledBy, cad_CaseCategory,cad_OpponentName,cad_OpponentAdvocate;
    String cad_CaseType, cad_FileNo, cad_AssetCode, cad_Remarks, cad_OtherInfo;
    public Date getCad_CreateDate() {
        return cad_CreateDate;
    }

    public void setCad_CreateDate(Date cad_CreateDate) {
        this.cad_CreateDate = cad_CreateDate;
    }

    public Date getCad_ModifyDate() {
        return cad_ModifyDate;
    }

    public void setCad_ModifyDate(Date cad_ModifyDate) {
        this.cad_ModifyDate = cad_ModifyDate;
    }

    public Date getCad_VakilPatraFiledOn() {
        return cad_VakilPatraFiledOn;
    }

    public void setCad_VakilPatraFiledOn(Date cad_VakilPatraFiledOn) {
        this.cad_VakilPatraFiledOn = cad_VakilPatraFiledOn;
    }

    public boolean isCad_DeleteFlag() {
        return cad_DeleteFlag;
    }

    public void setCad_DeleteFlag(boolean cad_DeleteFlag) {
        this.cad_DeleteFlag = cad_DeleteFlag;
    }

    public boolean isCad_ActiveFlag() {
        return cad_ActiveFlag;
    }

    public void setCad_ActiveFlag(boolean cad_ActiveFlag) {
        this.cad_ActiveFlag = cad_ActiveFlag;
    }

    public int getCad_ID() {
        return cad_ID;
    }

    public void setCad_ID(int cad_ID) {
        this.cad_ID = cad_ID;
    }

    public int getCad_RegNo() {
        return cad_RegNo;
    }

    public void setCad_RegNo(int cad_RegNo) {
        this.cad_RegNo = cad_RegNo;
    }

    public int getCad_CreateUser() {
        return cad_CreateUser;
    }

    public void setCad_CreateUser(int cad_CreateUser) {
        this.cad_CreateUser = cad_CreateUser;
    }

    public int getCad_ModifyUser() {
        return cad_ModifyUser;
    }

    public void setCad_ModifyUser(int cad_ModifyUser) {
        this.cad_ModifyUser = cad_ModifyUser;
    }

    public String getCad_CaseNo() {
        return cad_CaseNo;
    }

    public void setCad_CaseNo(String cad_CaseNo) {
        this.cad_CaseNo = cad_CaseNo;
    }

    public String getCad_FileName() {
        return cad_FileName;
    }

    public void setCad_FileName(String cad_FileName) {
        this.cad_FileName = cad_FileName;
    }

    public String getCad_Location() {
        return cad_Location;
    }

    public void setCad_Location(String cad_Location) {
        this.cad_Location = cad_Location;
    }

    public String getCad_Court() {
        return cad_Court;
    }

    public void setCad_Court(String cad_Court) {
        this.cad_Court = cad_Court;
    }

    public String getCad_AppearingFor() {
        return cad_AppearingFor;
    }

    public void setCad_AppearingFor(String cad_AppearingFor) {
        this.cad_AppearingFor = cad_AppearingFor;
    }

    public String getCad_Advocate() {
        return cad_Advocate;
    }

    public void setCad_Advocate(String cad_Advocate) {
        this.cad_Advocate = cad_Advocate;
    }

    public String getCad_ACT() {
        return cad_ACT;
    }

    public void setCad_ACT(String cad_ACT) {
        this.cad_ACT = cad_ACT;
    }

    public String getCad_VakilPatraFiledBy() {
        return cad_VakilPatraFiledBy;
    }

    public void setCad_VakilPatraFiledBy(String cad_VakilPatraFiledBy) {
        this.cad_VakilPatraFiledBy = cad_VakilPatraFiledBy;
    }

    public String getCad_CaseCategory() {
        return cad_CaseCategory;
    }

    public void setCad_CaseCategory(String cad_CaseCategory) {
        this.cad_CaseCategory = cad_CaseCategory;
    }

    public String getCad_OpponentName() {
        return cad_OpponentName;
    }

    public void setCad_OpponentName(String cad_OpponentName) {
        this.cad_OpponentName = cad_OpponentName;
    }

    public String getCad_OpponentAdvocate() {
        return cad_OpponentAdvocate;
    }

    public void setCad_OpponentAdvocate(String cad_OpponentAdvocate) {
        this.cad_OpponentAdvocate = cad_OpponentAdvocate;
    }

    public String getCad_ClientName() {
        return cad_ClientName;
    }

    public void setCad_ClientName(String cad_ClientName) {
        this.cad_ClientName = cad_ClientName;
    }

    public String getCad_Stage() {
        return cad_Stage;
    }

    public void setCad_Stage(String cad_Stage) {
        this.cad_Stage = cad_Stage;
    }

    public String getCad_CaseType() {
        return cad_CaseType;
    }

    public void setCad_CaseType(String cad_CaseType) {
        this.cad_CaseType = cad_CaseType;
    }

    public String getCad_AssetCode() {
        return cad_AssetCode;
    }

    public void setCad_AssetCode(String cad_AssetCode) {
        this.cad_AssetCode = cad_AssetCode;
    }

    public String getCad_Remarks() {
        return cad_Remarks;
    }

    public void setCad_Remarks(String cad_Remarks) {
        this.cad_Remarks = cad_Remarks;
    }

    public String getCad_OtherInfo() {
        return cad_OtherInfo;
    }

    public void setCad_OtherInfo(String cad_OtherInfo) {
        this.cad_OtherInfo = cad_OtherInfo;
    }

    public String getCad_FileNo() {
        return cad_FileNo;
    }

    public void setCad_FileNo(String cad_FileNo) {
        this.cad_FileNo = cad_FileNo;
    }

    public int getCad_CaseMasterCount() {
        return cad_CaseMasterCount;
    }

    public void setCad_CaseMasterCount(int cad_CaseMasterCount) {
        this.cad_CaseMasterCount = cad_CaseMasterCount;
    }

    public int getCmc_ID() {
        return cmc_ID;
    }

    public void setCmc_ID(int cmc_ID) {
        this.cmc_ID = cmc_ID;
    }
    
    

}
