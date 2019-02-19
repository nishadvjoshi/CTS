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
public class TaskMaster {
      int ctm_ID,ctu_ID, ctm_TaskAssignToID, ctm_TaskAssignByID,ctm_CreateUser,ctm_ModifyUser,ctu_CreateUser,ctu_ModifyUser, ctm_WeeklyTaskCount;
    Date ctm_TaskAssignDate, ctm_TaskCompletionDate, ctm_TaskCloseDate, ctm_CreateDate, ctm_ModifyDate,ctu_TaskUpdateDate,ctu_CreateDate,ctu_ModifyDate;
    boolean ctm_ActiveFlag, ctm_DeleteFlag,ctu_ActiveFlag,ctu_DeleteFlag; 
    String ctm_TaskName, ctm_TaskDescription, ctm_TaskAssignedTo, ctm_TaskAssignedBy,ctu_TaskUpdate,ctu_TaskStatus,ctm_TaskLocation, ctm_TaskPriority ;

    public int getCtm_ID() {
        return ctm_ID;
    }

    public void setCtm_ID(int ctm_ID) {
        this.ctm_ID = ctm_ID;
    }

    public int getCtm_TaskAssignToID() {
        return ctm_TaskAssignToID;
    }

    public void setCtm_TaskAssignToID(int ctm_TaskAssignToID) {
        this.ctm_TaskAssignToID = ctm_TaskAssignToID;
    }

    public int getCtm_TaskAssignByID() {
        return ctm_TaskAssignByID;
    }

    public void setCtm_TaskAssignByID(int ctm_TaskAssignByID) {
        this.ctm_TaskAssignByID = ctm_TaskAssignByID;
    }

    public Date getCtm_TaskAssignDate() {
        return ctm_TaskAssignDate;
    }

    public void setCtm_TaskAssignDate(Date ctm_TaskAssignDate) {
        this.ctm_TaskAssignDate = ctm_TaskAssignDate;
    }

    public Date getCtm_TaskCloseDate() {
        return ctm_TaskCloseDate;
    }

    public void setCtm_TaskCloseDate(Date ctm_TaskCloseDate) {
        this.ctm_TaskCloseDate = ctm_TaskCloseDate;
    }

    public boolean isCtm_ActiveFlag() {
        return ctm_ActiveFlag;
    }

    public void setCtm_ActiveFlag(boolean ctm_ActiveFlag) {
        this.ctm_ActiveFlag = ctm_ActiveFlag;
    }

    public boolean isCtm_DeleteFlag() {
        return ctm_DeleteFlag;
    }

    public void setCtm_DeleteFlag(boolean ctm_DeleteFlag) {
        this.ctm_DeleteFlag = ctm_DeleteFlag;
    }

    public String getCtm_TaskName() {
        return ctm_TaskName;
    }

    public void setCtm_TaskName(String ctm_TaskName) {
        this.ctm_TaskName = ctm_TaskName;
    }

    public String getCtm_TaskDescription() {
        return ctm_TaskDescription;
    }

    public void setCtm_TaskDescription(String ctm_TaskDescription) {
        this.ctm_TaskDescription = ctm_TaskDescription;
    }

    public String getCtm_TaskAssignedTo() {
        return ctm_TaskAssignedTo;
    }

    public void setCtm_TaskAssignedTo(String ctm_TaskAssignedTo) {
        this.ctm_TaskAssignedTo = ctm_TaskAssignedTo;
    }

    public String getCtm_TaskAssignedBy() {
        return ctm_TaskAssignedBy;
    }

    public void setCtm_TaskAssignedBy(String ctm_TaskAssignedBy) {
        this.ctm_TaskAssignedBy = ctm_TaskAssignedBy;
    }

    public int getCtu_ID() {
        return ctu_ID;
    }

    public void setCtu_ID(int ctu_ID) {
        this.ctu_ID = ctu_ID;
    }

    public int getCtm_CreateUser() {
        return ctm_CreateUser;
    }

    public void setCtm_CreateUser(int ctm_CreateUser) {
        this.ctm_CreateUser = ctm_CreateUser;
    }

    public int getCtm_ModifyUser() {
        return ctm_ModifyUser;
    }

    public void setCtm_ModifyUser(int ctm_ModifyUser) {
        this.ctm_ModifyUser = ctm_ModifyUser;
    }

    public int getCtu_CreateUser() {
        return ctu_CreateUser;
    }

    public void setCtu_CreateUser(int ctu_CreateUser) {
        this.ctu_CreateUser = ctu_CreateUser;
    }

    public int getCtu_ModifyUser() {
        return ctu_ModifyUser;
    }

    public void setCtu_ModifyUser(int ctu_ModifyUser) {
        this.ctu_ModifyUser = ctu_ModifyUser;
    }

    public Date getCtm_CreateDate() {
        return ctm_CreateDate;
    }

    public void setCtm_CreateDate(Date ctm_CreateDate) {
        this.ctm_CreateDate = ctm_CreateDate;
    }

    public Date getCtm_ModifyDate() {
        return ctm_ModifyDate;
    }

    public void setCtm_ModifyDate(Date ctm_ModifyDate) {
        this.ctm_ModifyDate = ctm_ModifyDate;
    }

    public Date getCtu_TaskUpdateDate() {
        return ctu_TaskUpdateDate;
    }

    public void setCtu_TaskUpdateDate(Date ctu_TaskUpdateDate) {
        this.ctu_TaskUpdateDate = ctu_TaskUpdateDate;
    }

    public Date getCtu_CreateDate() {
        return ctu_CreateDate;
    }

    public void setCtu_CreateDate(Date ctu_CreateDate) {
        this.ctu_CreateDate = ctu_CreateDate;
    }

    public Date getCtu_ModifyDate() {
        return ctu_ModifyDate;
    }

    public void setCtu_ModifyDate(Date ctu_ModifyDate) {
        this.ctu_ModifyDate = ctu_ModifyDate;
    }

    public boolean isCtu_ActiveFlag() {
        return ctu_ActiveFlag;
    }

    public void setCtu_ActiveFlag(boolean ctu_ActiveFlag) {
        this.ctu_ActiveFlag = ctu_ActiveFlag;
    }

    public boolean isCtu_DeleteFlag() {
        return ctu_DeleteFlag;
    }

    public void setCtu_DeleteFlag(boolean ctu_DeleteFlag) {
        this.ctu_DeleteFlag = ctu_DeleteFlag;
    }

    public String getCtu_TaskUpdate() {
        return ctu_TaskUpdate;
    }

    public void setCtu_TaskUpdate(String ctu_TaskUpdate) {
        this.ctu_TaskUpdate = ctu_TaskUpdate;
    }

    public String getCtu_TaskStatus() {
        return ctu_TaskStatus;
    }

    public void setCtu_TaskStatus(String ctu_TaskStatus) {
        this.ctu_TaskStatus = ctu_TaskStatus;
    }

    public String getCtm_TaskLocation() {
        return ctm_TaskLocation;
    }

    public void setCtm_TaskLocation(String ctm_TaskLocation) {
        this.ctm_TaskLocation = ctm_TaskLocation;
    }

    public String getCtm_TaskPriority() {
        return ctm_TaskPriority;
    }

    public void setCtm_TaskPriority(String ctm_TaskPriority) {
        this.ctm_TaskPriority = ctm_TaskPriority;
    }

    public int getCtm_WeeklyTaskCount() {
        return ctm_WeeklyTaskCount;
    }

    public void setCtm_WeeklyTaskCount(int ctm_WeeklyTaskCount) {
        this.ctm_WeeklyTaskCount = ctm_WeeklyTaskCount;
    }

    public Date getCtm_TaskCompletionDate() {
        return ctm_TaskCompletionDate;
    }

    public void setCtm_TaskCompletionDate(Date ctm_TaskCompletionDate) {
        this.ctm_TaskCompletionDate = ctm_TaskCompletionDate;
    }

 

    
    
    
}
