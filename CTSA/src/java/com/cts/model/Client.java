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
public class Client {
    int cmc_ID, cmc_ZipCode, cmc_PZipCode,cmc_CreateUser,cmc_ModifyUser;
    String cmc_FirstName , cmc_ClientType, cmc_OrgName,  cmc_EmailID1, cmc_EmailID2;
    String cmc_CellNo1, cmc_CellNo2, cmc_LandlineNo , cmc_Addr1, cmc_Addr2;
    String cmc_NearLocation , cmc_District , cmc_City , cmc_State , cmc_Country , cmc_PAddr1;
    String cmc_PAddr2, cmc_PNearLocation , cmc_PDistrict , cmc_PCity , cmc_PState , cmc_PCountry, cmc_PassportNo; 
    Date cmc_DOB, cmc_CreateDate, cmc_ModifyDate;
    boolean cmc_DeleteFlag,cmc_ActiveFlag ; 

    public int getCmc_ID() {
        return cmc_ID;
    }

    public void setCmc_ID(int cmc_ID) {
        this.cmc_ID = cmc_ID;
    }

    public int getCmc_ZipCode() {
        return cmc_ZipCode;
    }

    public void setCmc_ZipCode(int cmc_ZipCode) {
        this.cmc_ZipCode = cmc_ZipCode;
    }

    public int getCmc_PZipCode() {
        return cmc_PZipCode;
    }

    public void setCmc_PZipCode(int cmc_PZipCode) {
        this.cmc_PZipCode = cmc_PZipCode;
    }

    public int getCmc_CreateUser() {
        return cmc_CreateUser;
    }

    public void setCmc_CreateUser(int cmc_CreateUser) {
        this.cmc_CreateUser = cmc_CreateUser;
    }

    public int getCmc_ModifyUser() {
        return cmc_ModifyUser;
    }

    public void setCmc_ModifyUser(int cmc_ModifyUser) {
        this.cmc_ModifyUser = cmc_ModifyUser;
    }

    public String getCmc_FirstName() {
        return cmc_FirstName;
    }

    public void setCmc_FirstName(String cmc_FirstName) {
        this.cmc_FirstName = cmc_FirstName;
    }
   
    public String getCmc_ClientType() {
        return cmc_ClientType;
    }

    public void setCmc_ClientType(String cmc_ClientType) {
        this.cmc_ClientType = cmc_ClientType;
    }

    public String getCmc_OrgName() {
        return cmc_OrgName;
    }

    public void setCmc_OrgName(String cmc_OrgName) {
        this.cmc_OrgName = cmc_OrgName;
    }

    public String getCmc_EmailID1() {
        return cmc_EmailID1;
    }

    public void setCmc_EmailID1(String cmc_EmailID1) {
        this.cmc_EmailID1 = cmc_EmailID1;
    }

    public String getCmc_EmailID2() {
        return cmc_EmailID2;
    }

    public void setCmc_EmailID2(String cmc_EmailID2) {
        this.cmc_EmailID2 = cmc_EmailID2;
    }

    public String getCmc_CellNo1() {
        return cmc_CellNo1;
    }

    public void setCmc_CellNo1(String cmc_CellNo1) {
        this.cmc_CellNo1 = cmc_CellNo1;
    }

    public String getCmc_CellNo2() {
        return cmc_CellNo2;
    }

    public void setCmc_CellNo2(String cmc_CellNo2) {
        this.cmc_CellNo2 = cmc_CellNo2;
    }

    public String getCmc_LandlineNo() {
        return cmc_LandlineNo;
    }

    public void setCmc_LandlineNo(String cmc_LandlineNo) {
        this.cmc_LandlineNo = cmc_LandlineNo;
    }

    public String getCmc_Addr1() {
        return cmc_Addr1;
    }

    public void setCmc_Addr1(String cmc_Addr1) {
        this.cmc_Addr1 = cmc_Addr1;
    }

    public String getCmc_Addr2() {
        return cmc_Addr2;
    }

    public void setCmc_Addr2(String cmc_Addr2) {
        this.cmc_Addr2 = cmc_Addr2;
    }

    public String getCmc_NearLocation() {
        return cmc_NearLocation;
    }

    public void setCmc_NearLocation(String cmc_NearLocation) {
        this.cmc_NearLocation = cmc_NearLocation;
    }

    public String getCmc_District() {
        return cmc_District;
    }

    public void setCmc_District(String cmc_District) {
        this.cmc_District = cmc_District;
    }

    public String getCmc_City() {
        return cmc_City;
    }

    public void setCmc_City(String cmc_City) {
        this.cmc_City = cmc_City;
    }

    public String getCmc_State() {
        return cmc_State;
    }

    public void setCmc_State(String cmc_State) {
        this.cmc_State = cmc_State;
    }

    public String getCmc_Country() {
        return cmc_Country;
    }

    public void setCmc_Country(String cmc_Country) {
        this.cmc_Country = cmc_Country;
    }

    public String getCmc_PAddr1() {
        return cmc_PAddr1;
    }

    public void setCmc_PAddr1(String cmc_PAddr1) {
        this.cmc_PAddr1 = cmc_PAddr1;
    }

    public String getCmc_PAddr2() {
        return cmc_PAddr2;
    }

    public void setCmc_PAddr2(String cmc_PAddr2) {
        this.cmc_PAddr2 = cmc_PAddr2;
    }

    public String getCmc_PNearLocation() {
        return cmc_PNearLocation;
    }

    public void setCmc_PNearLocation(String cmc_PNearLocation) {
        this.cmc_PNearLocation = cmc_PNearLocation;
    }

    public String getCmc_PDistrict() {
        return cmc_PDistrict;
    }

    public void setCmc_PDistrict(String cmc_PDistrict) {
        this.cmc_PDistrict = cmc_PDistrict;
    }

    public String getCmc_PCity() {
        return cmc_PCity;
    }

    public void setCmc_PCity(String cmc_PCity) {
        this.cmc_PCity = cmc_PCity;
    }

    public String getCmc_PState() {
        return cmc_PState;
    }

    public void setCmc_PState(String cmc_PState) {
        this.cmc_PState = cmc_PState;
    }

    public String getCmc_PCountry() {
        return cmc_PCountry;
    }

    public void setCmc_PCountry(String cmc_PCountry) {
        this.cmc_PCountry = cmc_PCountry;
    }

    public String getCmc_PassportNo() {
        return cmc_PassportNo;
    }

    public void setCmc_PassportNo(String cmc_PassportNo) {
        this.cmc_PassportNo = cmc_PassportNo;
    }

    public Date getCmc_DOB() {
        return cmc_DOB;
    }

    public void setCmc_DOB(Date cmc_DOB) {
        this.cmc_DOB = cmc_DOB;
    }

    public Date getCmc_CreateDate() {
        return cmc_CreateDate;
    }

    public void setCmc_CreateDate(Date cmc_CreateDate) {
        this.cmc_CreateDate = cmc_CreateDate;
    }

    public Date getCmc_ModifyDate() {
        return cmc_ModifyDate;
    }

    public void setCmc_ModifyDate(Date cmc_ModifyDate) {
        this.cmc_ModifyDate = cmc_ModifyDate;
    }

    public boolean isCmc_DeleteFlag() {
        return cmc_DeleteFlag;
    }

    public void setCmc_DeleteFlag(boolean cmc_DeleteFlag) {
        this.cmc_DeleteFlag = cmc_DeleteFlag;
    }

    public boolean isCmc_ActiveFlag() {
        return cmc_ActiveFlag;
    }

    public void setCmc_ActiveFlag(boolean cmc_ActiveFlag) {
        this.cmc_ActiveFlag = cmc_ActiveFlag;
    }
    
    
}
