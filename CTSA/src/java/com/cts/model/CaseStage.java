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
public class CaseStage {
    
    int ccs_ID, ccs_CreateUser, ccs_ModifyUser;
    Date ccs_CreateDate, ccs_ModifyDate;
    boolean ccs_DeleteFlag, ccs_ActiveFlag;
    String ccs_StageName, ccs_Description;

    public int getCcs_ID() {
        return ccs_ID;
    }

    public void setCcs_ID(int ccs_ID) {
        this.ccs_ID = ccs_ID;
    }

    public int getCcs_CreateUser() {
        return ccs_CreateUser;
    }

    public void setCcs_CreateUser(int ccs_CreateUser) {
        this.ccs_CreateUser = ccs_CreateUser;
    }

    public int getCcs_ModifyUser() {
        return ccs_ModifyUser;
    }

    public void setCcs_ModifyUser(int ccs_ModifyUser) {
        this.ccs_ModifyUser = ccs_ModifyUser;
    }

    public Date getCcs_CreateDate() {
        return ccs_CreateDate;
    }

    public void setCcs_CreateDate(Date ccs_CreateDate) {
        this.ccs_CreateDate = ccs_CreateDate;
    }

    public Date getCcs_ModifyDate() {
        return ccs_ModifyDate;
    }

    public void setCcs_ModifyDate(Date ccs_ModifyDate) {
        this.ccs_ModifyDate = ccs_ModifyDate;
    }

    public boolean isCcs_DeleteFlag() {
        return ccs_DeleteFlag;
    }

    public void setCcs_DeleteFlag(boolean ccs_DeleteFlag) {
        this.ccs_DeleteFlag = ccs_DeleteFlag;
    }

    public boolean isCcs_ActiveFlag() {
        return ccs_ActiveFlag;
    }

    public void setCcs_ActiveFlag(boolean ccs_ActiveFlag) {
        this.ccs_ActiveFlag = ccs_ActiveFlag;
    }

    

    public String getCcs_StageName() {
        return ccs_StageName;
    }

        public void setCcs_StageName(String ccs_StageName) {
        this.ccs_StageName = ccs_StageName;
    }

    public String getCcs_Description() {
        return ccs_Description;
    }

    public void setCcs_Description(String ccs_Description) {
        this.ccs_Description = ccs_Description;
    }
    
    
    
}
