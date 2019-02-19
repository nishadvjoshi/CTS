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
public class Document {
     int cmd_ID, cmd_CreateUser, cmd_ModifyUser;
    Date cmd_CreateDate, cmd_ModifyDate;
    boolean cmd_DeleteFlag, cmd_ActiveFlag;
    String cmd_DocumentType, cmd_Description;

    public int getCmd_ID() {
        return cmd_ID;
    }

    public void setCmd_ID(int cmd_ID) {
        this.cmd_ID = cmd_ID;
    }

    public int getCmd_CreateUser() {
        return cmd_CreateUser;
    }

    public void setCmd_CreateUser(int cmd_CreateUser) {
        this.cmd_CreateUser = cmd_CreateUser;
    }

    public int getCmd_ModifyUser() {
        return cmd_ModifyUser;
    }

    public void setCmd_ModifyUser(int cmd_ModifyUser) {
        this.cmd_ModifyUser = cmd_ModifyUser;
    }

    public Date getCmd_CreateDate() {
        return cmd_CreateDate;
    }

    public void setCmd_CreateDate(Date cmd_CreateDate) {
        this.cmd_CreateDate = cmd_CreateDate;
    }

    public Date getCmd_ModifyDate() {
        return cmd_ModifyDate;
    }

    public void setCmd_ModifyDate(Date cmd_ModifyDate) {
        this.cmd_ModifyDate = cmd_ModifyDate;
    }

    public boolean isCmd_DeleteFlag() {
        return cmd_DeleteFlag;
    }

    public void setCmd_DeleteFlag(boolean cmd_DeleteFlag) {
        this.cmd_DeleteFlag = cmd_DeleteFlag;
    }

    public boolean isCmd_ActiveFlag() {
        return cmd_ActiveFlag;
    }

    public void setCmd_ActiveFlag(boolean cmd_ActiveFlag) {
        this.cmd_ActiveFlag = cmd_ActiveFlag;
    }

    public String getCmd_DocumentType() {
        return cmd_DocumentType;
    }

    public void setCmd_DocumentType(String cmd_DocumentType) {
        this.cmd_DocumentType = cmd_DocumentType;
    }

    public String getCmd_Description() {
        return cmd_Description;
    }

    public void setCmd_Description(String cmd_Description) {
        this.cmd_Description = cmd_Description;
    }
    
    
}
