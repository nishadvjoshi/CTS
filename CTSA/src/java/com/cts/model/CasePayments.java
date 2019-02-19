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
public class CasePayments {

    Date ccp_CreateDate, ccp_ModifyDate, ccp_PaymentDate, ccp_PaymentChequeDate;
    boolean ccp_DeleteFlag, ccp_ActiveFlag;
    int ccp_ID, cad_ID, cad_RegNo, ccp_CreateUser, ccp_ModifyUser;
    
    String cad_CaseNo, cad_FileNo, cad_FileName, cad_ClientName, ccp_PaymentType, ccp_PaymentChequeNo,
            ccp_PaymentChequeName, ccp_NEFTTransactionNo,ccp_DepositBank,ccp_PaymentChequeBank;
    
    String ccp_PaymentAmount, ccp_TDSAmount;

    public int getCcp_CreateUser() {
        return ccp_CreateUser;
    }

    public void setCcp_CreateUser(int ccp_CreateUser) {
        this.ccp_CreateUser = ccp_CreateUser;
    }

    public int getCcp_ModifyUser() {
        return ccp_ModifyUser;
    }

    public void setCcp_ModifyUser(int ccp_ModifyUser) {
        this.ccp_ModifyUser = ccp_ModifyUser;
    }
    
    

    public Date getCcp_CreateDate() {
        return ccp_CreateDate;
    }

    public void setCcp_CreateDate(Date ccp_CreateDate) {
        this.ccp_CreateDate = ccp_CreateDate;
    }

    public Date getCcp_ModifyDate() {
        return ccp_ModifyDate;
    }

    public void setCcp_ModifyDate(Date ccp_ModifyDate) {
        this.ccp_ModifyDate = ccp_ModifyDate;
    }

    public Date getCcp_PaymentDate() {
        return ccp_PaymentDate;
    }

    public void setCcp_PaymentDate(Date ccp_PaymentDate) {
        this.ccp_PaymentDate = ccp_PaymentDate;
    }

    public Date getCcp_PaymentChequeDate() {
        return ccp_PaymentChequeDate;
    }

    public void setCcp_PaymentChequeDate(Date ccp_PaymentChequeDate) {
        this.ccp_PaymentChequeDate = ccp_PaymentChequeDate;
    }

    public boolean isCcp_DeleteFlag() {
        return ccp_DeleteFlag;
    }

    public void setCcp_DeleteFlag(boolean ccp_DeleteFlag) {
        this.ccp_DeleteFlag = ccp_DeleteFlag;
    }

    public boolean isCcp_ActiveFlag() {
        return ccp_ActiveFlag;
    }

    public void setCcp_ActiveFlag(boolean ccp_ActiveFlag) {
        this.ccp_ActiveFlag = ccp_ActiveFlag;
    }

    public int getCcp_ID() {
        return ccp_ID;
    }

    public void setCcp_ID(int ccp_ID) {
        this.ccp_ID = ccp_ID;
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

    public String getCcp_PaymentType() {
        return ccp_PaymentType;
    }

    public void setCcp_PaymentType(String ccp_PaymentType) {
        this.ccp_PaymentType = ccp_PaymentType;
    }

    public String getCcp_PaymentChequeNo() {
        return ccp_PaymentChequeNo;
    }

    public void setCcp_PaymentChequeNo(String ccp_PaymentChequeNo) {
        this.ccp_PaymentChequeNo = ccp_PaymentChequeNo;
    }

    public String getCcp_PaymentChequeName() {
        return ccp_PaymentChequeName;
    }

    public void setCcp_PaymentChequeName(String ccp_PaymentChequeName) {
        this.ccp_PaymentChequeName = ccp_PaymentChequeName;
    }

    public String getCcp_NEFTTransactionNo() {
        return ccp_NEFTTransactionNo;
    }

    public void setCcp_NEFTTransactionNo(String ccp_NEFTTransactionNo) {
        this.ccp_NEFTTransactionNo = ccp_NEFTTransactionNo;
    }

    public String getCcp_PaymentAmount() {
        return ccp_PaymentAmount;
    }

    public void setCcp_PaymentAmount(String ccp_PaymentAmount) {
        this.ccp_PaymentAmount = ccp_PaymentAmount;
    }

    public String getCcp_TDSAmount() {
        return ccp_TDSAmount;
    }

    public void setCcp_TDSAmount(String ccp_TDSAmount) {
        this.ccp_TDSAmount = ccp_TDSAmount;
    }

    public String getCcp_DepositBank() {
        return ccp_DepositBank;
    }

    public void setCcp_DepositBank(String ccp_DepositBank) {
        this.ccp_DepositBank = ccp_DepositBank;
    }

    public String getCcp_PaymentChequeBank() {
        return ccp_PaymentChequeBank;
    }

    public void setCcp_PaymentChequeBank(String ccp_PaymentChequeBank) {
        this.ccp_PaymentChequeBank = ccp_PaymentChequeBank;
    }
    
    
    
}
