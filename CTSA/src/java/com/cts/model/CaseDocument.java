/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author nishad
 */
public class CaseDocument {

    int cdd_id, cad_id, cad_RegNo, cdd_CreateUser, cdd_ModifyUser;
    boolean cdd_ActiveFlag, cdd_DeleteFlag;
    String cad_CaseNo, cad_FileName, cdd_DocumentType, cdd_DocumentName, cdd_DocumentRevisedName, cdd_DocumentLocation;
    Date cdd_CreateDate, cdd_ModifyDate;

    public int getCdd_id() {
        return cdd_id;
    }

    public void setCdd_id(int cdd_id) {
        this.cdd_id = cdd_id;
    }

    public int getCad_id() {
        return cad_id;
    }

    public void setCad_id(int cad_id) {
        this.cad_id = cad_id;
    }

    public int getCad_RegNo() {
        return cad_RegNo;
    }

    public void setCad_RegNo(int cad_RegNo) {
        this.cad_RegNo = cad_RegNo;
    }

    public int getCdd_CreateUser() {
        return cdd_CreateUser;
    }

    public void setCdd_CreateUser(int cdd_CreateUser) {
        this.cdd_CreateUser = cdd_CreateUser;
    }

    public int getCdd_ModifyUser() {
        return cdd_ModifyUser;
    }

    public void setCdd_ModifyUser(int cdd_ModifyUser) {
        this.cdd_ModifyUser = cdd_ModifyUser;
    }

    public boolean isCdd_ActiveFlag() {
        return cdd_ActiveFlag;
    }

    public void setCdd_ActiveFlag(boolean cdd_ActiveFlag) {
        this.cdd_ActiveFlag = cdd_ActiveFlag;
    }

    public boolean isCdd_DeleteFlag() {
        return cdd_DeleteFlag;
    }

    public void setCdd_DeleteFlag(boolean cdd_DeleteFlag) {
        this.cdd_DeleteFlag = cdd_DeleteFlag;
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

    public String getCdd_DocumentType() {
        return cdd_DocumentType;
    }

    public void setCdd_DocumentType(String cdd_DocumentType) {
        this.cdd_DocumentType = cdd_DocumentType;
    }

    public String getCdd_DocumentName() {
        return cdd_DocumentName;
    }

    public void setCdd_DocumentName(String cdd_DocumentName) {
        this.cdd_DocumentName = cdd_DocumentName;
    }

    public String getCdd_DocumentRevisedName() {
        return cdd_DocumentRevisedName;
    }

    public void setCdd_DocumentRevisedName(String cdd_DocumentRevisedName) {
        this.cdd_DocumentRevisedName = cdd_DocumentRevisedName;
    }

    public String getCdd_DocumentLocation() {
        return cdd_DocumentLocation;
    }

    public void setCdd_DocumentLocation(String cdd_DocumentLocation) {
        this.cdd_DocumentLocation = cdd_DocumentLocation;
    }

    public Date getCdd_CreateDate() {
        return cdd_CreateDate;
    }

    public void setCdd_CreateDate(Date cdd_CreateDate) {
        this.cdd_CreateDate = cdd_CreateDate;
    }

    public Date getCdd_ModifyDate() {
        return cdd_ModifyDate;
    }

    public void setCdd_ModifyDate(Date cdd_ModifyDate) {
        this.cdd_ModifyDate = cdd_ModifyDate;
    }

    public void setCdd_CreateDate(String strDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCdd_ModifyDate(SimpleDateFormat ModifyDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
