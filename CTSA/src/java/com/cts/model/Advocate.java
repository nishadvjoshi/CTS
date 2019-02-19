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
public class Advocate {
    int cam_ID, cam_ZipCode, cam_PZipCode,cam_CreateUser,cam_ModifyUser;
    String cam_FirstName , cam_AdvocateType, cam_AdvocateCode, cam_LicenseNo, cam_EmailID1, cam_EmailID2;
    String cam_CellNo1, cam_CellNo2, cam_LandlineNo , cam_Addr1, cam_Addr2;
    String cam_NearLocation , cam_District , cam_City , cam_State , cam_Country , cam_PAddr1;
    String cam_PAddr2, cam_PNearLocation , cam_PDistrict , cam_PCity , cam_PState , cam_PCountry, cam_PassportNo; 
    Date cam_DOB, cam_CreateDate, cam_ModifyDate;
    boolean cam_DeleteFlag,cam_ActiveFlag ; 

    public int getCam_ID() {
        return cam_ID;
    }

    public void setCam_ID(int cam_ID) {
        this.cam_ID = cam_ID;
    }

    public int getCam_ZipCode() {
        return cam_ZipCode;
    }

    public void setCam_ZipCode(int cam_ZipCode) {
        this.cam_ZipCode = cam_ZipCode;
    }

    public int getCam_PZipCode() {
        return cam_PZipCode;
    }

    public void setCam_PZipCode(int cam_PZipCode) {
        this.cam_PZipCode = cam_PZipCode;
    }

    public int getCam_CreateUser() {
        return cam_CreateUser;
    }

    public void setCam_CreateUser(int cam_CreateUser) {
        this.cam_CreateUser = cam_CreateUser;
    }

    public int getCam_ModifyUser() {
        return cam_ModifyUser;
    }

    public void setCam_ModifyUser(int cam_ModifyUser) {
        this.cam_ModifyUser = cam_ModifyUser;
    }

    public String getCam_FirstName() {
        return cam_FirstName;
    }

    public void setCam_FirstName(String cam_FirstName) {
        this.cam_FirstName = cam_FirstName;
    }

    
    public String getCam_AdvocateType() {
        return cam_AdvocateType;
    }

    public void setCam_AdvocateType(String cam_AdvocateType) {
        this.cam_AdvocateType = cam_AdvocateType;
    }

    public String getCam_AdvocateCode() {
        return cam_AdvocateCode;
    }

    public void setCam_AdvocateCode(String cam_AdvocateCode) {
        this.cam_AdvocateCode = cam_AdvocateCode;
    }

    public String getCam_LicenseNo() {
        return cam_LicenseNo;
    }

    public void setCam_LicenseNo(String cam_LicenseNo) {
        this.cam_LicenseNo = cam_LicenseNo;
    }

    public String getCam_EmailID1() {
        return cam_EmailID1;
    }

    public void setCam_EmailID1(String cam_EmailID1) {
        this.cam_EmailID1 = cam_EmailID1;
    }

    public String getCam_EmailID2() {
        return cam_EmailID2;
    }

    public void setCam_EmailID2(String cam_EmailID2) {
        this.cam_EmailID2 = cam_EmailID2;
    }

    public String getCam_CellNo1() {
        return cam_CellNo1;
    }

    public void setCam_CellNo1(String cam_CellNo1) {
        this.cam_CellNo1 = cam_CellNo1;
    }

    public String getCam_CellNo2() {
        return cam_CellNo2;
    }

    public void setCam_CellNo2(String cam_CellNo2) {
        this.cam_CellNo2 = cam_CellNo2;
    }

    public String getCam_LandlineNo() {
        return cam_LandlineNo;
    }

    public void setCam_LandlineNo(String cam_LandlineNo) {
        this.cam_LandlineNo = cam_LandlineNo;
    }

    public String getCam_Addr1() {
        return cam_Addr1;
    }

    public void setCam_Addr1(String cam_Addr1) {
        this.cam_Addr1 = cam_Addr1;
    }

    public String getCam_Addr2() {
        return cam_Addr2;
    }

    public void setCam_Addr2(String cam_Addr2) {
        this.cam_Addr2 = cam_Addr2;
    }

    public String getCam_NearLocation() {
        return cam_NearLocation;
    }

    public void setCam_NearLocation(String cam_NearLocation) {
        this.cam_NearLocation = cam_NearLocation;
    }

    public String getCam_District() {
        return cam_District;
    }

    public void setCam_District(String cam_District) {
        this.cam_District = cam_District;
    }

    public String getCam_City() {
        return cam_City;
    }

    public void setCam_City(String cam_City) {
        this.cam_City = cam_City;
    }

    public String getCam_State() {
        return cam_State;
    }

    public void setCam_State(String cam_State) {
        this.cam_State = cam_State;
    }

    public String getCam_Country() {
        return cam_Country;
    }

    public void setCam_Country(String cam_Country) {
        this.cam_Country = cam_Country;
    }

    public String getCam_PAddr1() {
        return cam_PAddr1;
    }

    public void setCam_PAddr1(String cam_PAddr1) {
        this.cam_PAddr1 = cam_PAddr1;
    }

    public String getCam_PAddr2() {
        return cam_PAddr2;
    }

    public void setCam_PAddr2(String cam_PAddr2) {
        this.cam_PAddr2 = cam_PAddr2;
    }

    public String getCam_PNearLocation() {
        return cam_PNearLocation;
    }

    public void setCam_PNearLocation(String cam_PNearLocation) {
        this.cam_PNearLocation = cam_PNearLocation;
    }

    public String getCam_PDistrict() {
        return cam_PDistrict;
    }

    public void setCam_PDistrict(String cam_PDistrict) {
        this.cam_PDistrict = cam_PDistrict;
    }

    public String getCam_PCity() {
        return cam_PCity;
    }

    public void setCam_PCity(String cam_PCity) {
        this.cam_PCity = cam_PCity;
    }

    public String getCam_PState() {
        return cam_PState;
    }

    public void setCam_PState(String cam_PState) {
        this.cam_PState = cam_PState;
    }
    
    public String getCam_PCountry() {
        return cam_PCountry;
    }

    public void setCam_PCountry(String cam_PCountry) {
        this.cam_PCountry = cam_PCountry;
    }
    
    public String getCam_PassportNo() {
        return cam_PassportNo;
    }

    public void setCam_PassportNo(String cam_PassportNo) {
        this.cam_PassportNo = cam_PassportNo;
    }

    public Date getCam_DOB() {
        return cam_DOB;
    }

    public void setCam_DOB(Date cam_DOB) {
        this.cam_DOB = cam_DOB;
    }

    public Date getCam_CreateDate() {
        return cam_CreateDate;
    }

    public void setCam_CreateDate(Date cam_CreateDate) {
        this.cam_CreateDate = cam_CreateDate;
    }

    public Date getCam_ModifyDate() {
        return cam_ModifyDate;
    }

    public void setCam_ModifyDate(Date cam_ModifyDate) {
        this.cam_ModifyDate = cam_ModifyDate;
    }

    public boolean isCam_DeleteFlag() {
        return cam_DeleteFlag;
    }

    public void setCam_DeleteFlag(boolean cam_DeleteFlag) {
        this.cam_DeleteFlag = cam_DeleteFlag;
    }

    public boolean isCam_ActiveFlag() {
        return cam_ActiveFlag;
    }

    public void setCam_ActiveFlag(boolean cam_ActiveFlag) {
        this.cam_ActiveFlag = cam_ActiveFlag;
    }
    
    
}
