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
public class CaseDetail {
    
     Date ccd_CreateDate, ccd_ModifyDate,ccd_CurrentDate,ccd_NextDate;
     boolean ccd_DeleteFlag,ccd_ActiveFlag;
     int ccd_ID, cad_ID, cad_RegNo, ccd_CreateUser,ccd_ModifyUser,ccd_MonthlyCaseCount, ccd_UnDatedCaseCount;
     String cad_CaseNo, cad_FileNo, cad_FileName, ccd_Stage, cad_ClientName, ccd_AAdvocate, ccd_Judge, ccd_Rojnama, ccd_Judgment,ccd_Remarks,ccd_Court, ccd_CreateUserName, ccd_ModifyUserName, ccd_CaseLocation;

    public Date getCcd_CreateDate() { 
        return ccd_CreateDate;
    }

    public void setCcd_CreateDate(Date ccd_CreateDate) {
        this.ccd_CreateDate = ccd_CreateDate;
    }

    public Date getCcd_ModifyDate() {
        return ccd_ModifyDate;
    }

    public void setCcd_ModifyDate(Date ccd_ModifyDate) {
        this.ccd_ModifyDate = ccd_ModifyDate;
    }

    public Date getCcd_CurrentDate() {
        return ccd_CurrentDate;
    }

    public void setCcd_CurrentDate(Date ccd_CurrentDate) {
        this.ccd_CurrentDate = ccd_CurrentDate;
    }

    public Date getCcd_NextDate() {
        return ccd_NextDate;
    }

    public void setCcd_NextDate(Date ccd_NextDate) {
        this.ccd_NextDate = ccd_NextDate;
    }

    public boolean isCcd_DeleteFlag() {
        return ccd_DeleteFlag;
    }

    public void setCcd_DeleteFlag(boolean ccd_DeleteFlag) {
        this.ccd_DeleteFlag = ccd_DeleteFlag;
    }

    public boolean isCcd_ActiveFlag() {
        return ccd_ActiveFlag;
    }

    public void setCcd_ActiveFlag(boolean ccd_ActiveFlag) {
        this.ccd_ActiveFlag = ccd_ActiveFlag;
    }

    public int getCcd_ID() {
        return ccd_ID;
    }

    public void setCcd_ID(int ccd_ID) {
        this.ccd_ID = ccd_ID;
    }

    public int getCad_ID() {
        return cad_ID;
    }

    public void setCad_ID(int cad_id) {
        this.cad_ID = cad_id;
    }

    public int getCad_RegNo() {
        return cad_RegNo;
    }

    public void setCad_RegNo(int cad_RegNo) {
        this.cad_RegNo = cad_RegNo;
    }

    public int getCcd_CreateUser() {
        return ccd_CreateUser;
    }

    public void setCcd_CreateUser(int ccd_CreateUser) {
        this.ccd_CreateUser = ccd_CreateUser;
    }

    public int getCcd_ModifyUser() {
        return ccd_ModifyUser;
    }

    public void setCcd_ModifyUser(int ccd_ModifyUser) {
        this.ccd_ModifyUser = ccd_ModifyUser;
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

    public String getCcd_Stage() {
        return ccd_Stage;
    }

    public void setCcd_Stage(String ccd_Stage) {
        this.ccd_Stage = ccd_Stage;
    }

    public String getCcd_Judge() {
        return ccd_Judge;
    }

    public void setCcd_Judge(String ccd_Judge) {
        this.ccd_Judge = ccd_Judge;
    }

    public String getCcd_Rojnama() {
        return ccd_Rojnama;
    }

    public void setCcd_Rojnama(String ccd_Rojnama) {
        this.ccd_Rojnama = ccd_Rojnama;
    }

    public String getCcd_Judgment() {
        return ccd_Judgment;
    }

    public void setCcd_Judgment(String ccd_Judgment) {
        this.ccd_Judgment = ccd_Judgment;
    }

    public String getCcd_Remarks() {
        return ccd_Remarks;
    }

    public void setCcd_Remarks(String ccd_Remarks) {
        this.ccd_Remarks = ccd_Remarks;
    }

    public String getCcd_Court() {
        return ccd_Court;
    }

    public void setCcd_Court(String ccd_Court) {
        this.ccd_Court = ccd_Court;
    }

    public String getCad_FileNo() {
        return cad_FileNo;
    }

    public void setCad_FileNo(String cad_FileNo) {
        this.cad_FileNo = cad_FileNo;
    }

    public String getCcd_AAdvocate() {
        return ccd_AAdvocate;
    }

    public void setCcd_AAdvocate(String ccd_AAdvocate) {
        this.ccd_AAdvocate = ccd_AAdvocate;
    }

    public int getCcd_MonthlyCaseCount() {
        return ccd_MonthlyCaseCount;
    }

    public void setCcd_MonthlyCaseCount(int ccd_MonthlyCaseCount) {
        this.ccd_MonthlyCaseCount = ccd_MonthlyCaseCount;
    }

    public int getCcd_UnDatedCaseCount() {
        return ccd_UnDatedCaseCount;
    }

    public void setCcd_UnDatedCaseCount(int ccd_UnDatedCaseCount) {
        this.ccd_UnDatedCaseCount = ccd_UnDatedCaseCount;
    }

    public String getCad_ClientName() {
        return cad_ClientName;
    }

    public void setCad_ClientName(String cad_ClientName) {
        this.cad_ClientName = cad_ClientName;
    }

    public String getCcd_CreateUserName() {
        return ccd_CreateUserName;
    }

    public void setCcd_CreateUserName(String ccd_CreateUserName) {
        this.ccd_CreateUserName = ccd_CreateUserName;
    }

    public String getCcd_ModifyUserName() {
        return ccd_ModifyUserName;
    }

    public void setCcd_ModifyUserName(String ccd_ModifyUserName) {
        this.ccd_ModifyUserName = ccd_ModifyUserName;
    }

    public String getCcd_CaseLocation() {
        return ccd_CaseLocation;
    }

    public void setCcd_CaseLocation(String ccd_CaseLocation) {
        this.ccd_CaseLocation = ccd_CaseLocation;
    }

     
     
    
}
