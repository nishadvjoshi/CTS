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
public class Court {
    int ccm_ID, ccm_CreateUser, ccm_ModifyUser;
    Date ccm_CreateDate, ccm_ModifyDate;
    boolean ccm_DeleteFlag, ccm_ActiveFlag;
    String ccm_CourtName, ccm_Description, ccm_CourtType, ccm_CourtCity, ccm_CourtState;

    public int getCcm_ID() {
        return ccm_ID;
    }

    public void setCcm_ID(int ccm_ID) {
        this.ccm_ID = ccm_ID;
    }

    public int getCcm_CreateUser() {
        return ccm_CreateUser;
    }

    public void setCcm_CreateUser(int ccm_CreateUser) {
        this.ccm_CreateUser = ccm_CreateUser;
    }

    public int getCcm_ModifyUser() {
        return ccm_ModifyUser;
    }

    public void setCcm_ModifyUser(int ccm_ModifyUser) {
        this.ccm_ModifyUser = ccm_ModifyUser;
    }

    public Date getCcm_CreateDate() {
        return ccm_CreateDate;
    }

    public void setCcm_CreateDate(Date ccm_CreateDate) {
        this.ccm_CreateDate = ccm_CreateDate;
    }

    public Date getCcm_ModifyDate() {
        return ccm_ModifyDate;
    }

    public void setCcm_ModifyDate(Date ccm_ModifyDate) {
        this.ccm_ModifyDate = ccm_ModifyDate;
    }

    public boolean isCcm_DeleteFlag() {
        return ccm_DeleteFlag;
    }

    public void setCcm_DeleteFlag(boolean ccm_DeleteFlag) {
        this.ccm_DeleteFlag = ccm_DeleteFlag;
    }

    public boolean isCcm_ActiveFlag() {
        return ccm_ActiveFlag;
    }

    public void setCcm_ActiveFlag(boolean ccm_ActiveFlag) {
        this.ccm_ActiveFlag = ccm_ActiveFlag;
    }

    public String getCcm_CourtName() {
        return ccm_CourtName;
    }

    public void setCcm_CourtName(String ccm_CourtName) {
        this.ccm_CourtName = ccm_CourtName;
    }

    public String getCcm_Description() {
        return ccm_Description;
    }

    public void setCcm_Description(String ccm_Description) {
        this.ccm_Description = ccm_Description;
    }

    public String getCcm_CourtType() {
        return ccm_CourtType;
    }

    public void setCcm_CourtType(String ccm_CourtType) {
        this.ccm_CourtType = ccm_CourtType;
    }

    public String getCcm_CourtCity() {
        return ccm_CourtCity;
    }

    public void setCcm_CourtCity(String ccm_CourtCity) {
        this.ccm_CourtCity = ccm_CourtCity;
    }

    public String getCcm_CourtState() {
        return ccm_CourtState;
    }

    public void setCcm_CourtState(String ccm_CourtState) {
        this.ccm_CourtState = ccm_CourtState;
    }
    
    
}
