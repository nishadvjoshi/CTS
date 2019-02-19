/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class CaseExpenses {
    
     Date cce_CreateDate, cce_ModifyDate, cce_ExpenseDate;
    boolean cce_DeleteFlag, cce_ActiveFlag;
    int cce_ID, cad_ID, cad_RegNo, cce_CreateUser, cce_ModifyUser;
    
    String cad_CaseNo, cad_FileNo, cad_FileName, cad_ClientName, cce_ExpenseType, cce_ExpenseBy,
            cce_ExpenseInvoiceNo;
    
    Double cce_ExpenseAmount;

    public Date getCce_CreateDate() {
        return cce_CreateDate;
    }

    public void setCce_CreateDate(Date cce_CreateDate) {
        this.cce_CreateDate = cce_CreateDate;
    }

    public Date getCce_ModifyDate() {
        return cce_ModifyDate;
    }

    public void setCce_ModifyDate(Date cce_ModifyDate) {
        this.cce_ModifyDate = cce_ModifyDate;
    }

    public Date getCce_ExpenseDate() {
        return cce_ExpenseDate;
    }

    public void setCce_ExpenseDate(Date cce_ExpenseDate) {
        this.cce_ExpenseDate = cce_ExpenseDate;
    }

    public boolean isCce_DeleteFlag() {
        return cce_DeleteFlag;
    }

    public void setCce_DeleteFlag(boolean cce_DeleteFlag) {
        this.cce_DeleteFlag = cce_DeleteFlag;
    }

    public boolean isCce_ActiveFlag() {
        return cce_ActiveFlag;
    }

    public void setCce_ActiveFlag(boolean cce_ActiveFlag) {
        this.cce_ActiveFlag = cce_ActiveFlag;
    }

    public int getCce_ID() {
        return cce_ID;
    }

    public void setCce_ID(int cce_ID) {
        this.cce_ID = cce_ID;
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

    public int getCce_CreateUser() {
        return cce_CreateUser;
    }

    public void setCce_CreateUser(int cce_CreateUser) {
        this.cce_CreateUser = cce_CreateUser;
    }

    public int getCce_ModifyUser() {
        return cce_ModifyUser;
    }

    public void setCce_ModifyUser(int cce_ModifyUser) {
        this.cce_ModifyUser = cce_ModifyUser;
    }

    public String getCad_CaseNo() {
        return cad_CaseNo;
    }

    public void setCad_CaseNo(String cad_CaseNo) {
        this.cad_CaseNo = cad_CaseNo;
    }

    public String getCad_FileNo() {
        return cad_FileNo;
    }

    public void setCad_FileNo(String cad_FileNo) {
        this.cad_FileNo = cad_FileNo;
    }

    public String getCad_FileName() {
        return cad_FileName;
    }

    public void setCad_FileName(String cad_FileName) {
        this.cad_FileName = cad_FileName;
    }

    public String getCad_ClientName() {
        return cad_ClientName;
    }

    public void setCad_ClientName(String cad_ClientName) {
        this.cad_ClientName = cad_ClientName;
    }

    public String getCce_ExpenseType() {
        return cce_ExpenseType;
    }

    public void setCce_ExpenseType(String cce_ExpenseType) {
        this.cce_ExpenseType = cce_ExpenseType;
    }

    public String getCce_ExpenseBy() {
        return cce_ExpenseBy;
    }

    public void setCce_ExpenseBy(String cce_ExpenseBy) {
        this.cce_ExpenseBy = cce_ExpenseBy;
    }

    public String getCce_ExpenseInvoiceNo() {
        return cce_ExpenseInvoiceNo;
    }

    public void setCce_ExpenseInvoiceNo(String cce_ExpenseInvoiceNo) {
        this.cce_ExpenseInvoiceNo = cce_ExpenseInvoiceNo;
    }

    public Double getCce_ExpenseAmount() {
        return cce_ExpenseAmount;
    }

    public void setCce_ExpenseAmount(Double cce_ExpenseAmount) {
        this.cce_ExpenseAmount = cce_ExpenseAmount;
    }
    
    
    
    
}
