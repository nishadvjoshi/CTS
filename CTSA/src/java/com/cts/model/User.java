/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.model;

/**
 *
 * @author nishad
 */
import java.util.Date;

public class User {
    int cmu_ID,cmu_CreateUser,cmu_ModifyUser, cmu_ClientID;
    String cmu_FirstName, cmu_LastName, cmu_Role, cmu_UserName, cmu_Password, cmu_City;
    Date cmu_CreateDate,cmu_ModifyDate;
    boolean cmu_DeleteFlag, cmu_ActiveFlag;

    public int getCmu_ID() {
        return cmu_ID;
    }

    public void setCmu_ID(int cmu_ID) {
        this.cmu_ID = cmu_ID;
    }

    public int getCmu_CreateUser() {
        return cmu_CreateUser;
    }

    public void setCmu_CreateUser(int cmu_CreateUser) {
        this.cmu_CreateUser = cmu_CreateUser;
    }

    public int getCmu_ModifyUser() {
        return cmu_ModifyUser;
    }

    public void setCmu_ModifyUser(int cmu_ModifyUser) {
        this.cmu_ModifyUser = cmu_ModifyUser;
    }

    public String getCmu_FirstName() {
        return cmu_FirstName;
    }

    public void setCmu_FirstName(String cmu_FirstName) {
        this.cmu_FirstName = cmu_FirstName;
    }

    public String getCmu_LastName() {
        return cmu_LastName;
    }

    public void setCmu_LastName(String cmu_LastName) {
        this.cmu_LastName = cmu_LastName;
    }

    public String getCmu_Role() {
        return cmu_Role;
    }

    public void setCmu_Role(String cmu_Role) {
        this.cmu_Role = cmu_Role;
    }

    public String getCmu_UserName() {
        return cmu_UserName;
    }

    public void setCmu_UserName(String cmu_UserName) {
        this.cmu_UserName = cmu_UserName;
    }

    public String getCmu_Password() {
        return cmu_Password;
    }

    public void setCmu_Password(String cmu_Password) {
        this.cmu_Password = cmu_Password;
    }

    public Date getCmu_CreateDate() {
        return cmu_CreateDate;
    }

    public void setCmu_CreateDate(Date cmu_CreateDate) {
        this.cmu_CreateDate = cmu_CreateDate;
    }

    public Date getCmu_ModifyDate() {
        return cmu_ModifyDate;
    }

    public void setCmu_ModifyDate(Date cmu_ModifyDate) {
        this.cmu_ModifyDate = cmu_ModifyDate;
    }

    public boolean isCmu_DeleteFlag() {
        return cmu_DeleteFlag;
    }

    public void setCmu_DeleteFlag(boolean cmu_DeleteFlag) {
        this.cmu_DeleteFlag = cmu_DeleteFlag;
    }

    public boolean isCmu_ActiveFlag() {
        return cmu_ActiveFlag;
    }

    public void setCmu_ActiveFlag(boolean cmu_ActiveFlag) {
        this.cmu_ActiveFlag = cmu_ActiveFlag;
    }

    public int getCmu_ClientID() {
        return cmu_ClientID;
    }

    public void setCmu_ClientID(int cmu_ClientID) {
        this.cmu_ClientID = cmu_ClientID;
    }

    public String getCmu_City() {
        return cmu_City;
    }

    public void setCmu_City(String cmu_City) {
        this.cmu_City = cmu_City;
    }
    
    
}
