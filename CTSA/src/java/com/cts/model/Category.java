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
public class Category {
    int ccg_ID,ccg_CreateUser,ccg_ModifyUser;
    String ccg_CategoryName,ccg_Description;
    Date ccg_ModifyDate,ccg_CreateDate;
    Boolean ccg_ActiveFlag,ccg_DeleteFlag;


    public int getCcg_ID() {
        return ccg_ID;
    }

    public void setCcg_ID(int ccg_ID) {
        this.ccg_ID = ccg_ID;
    }

    public String getCcg_CategoryName() {
        return ccg_CategoryName;
    }

    public void setCcg_CategoryName(String ccg_CategoryName) {
        this.ccg_CategoryName = ccg_CategoryName;
    }

    public String getCcg_Description() {
        return ccg_Description;
    }

    public void setCcg_Description(String ccg_Description) {
        this.ccg_Description = ccg_Description;
    }
    
    //active flag
    
    public Boolean getCcg_ActiveFlag() {
        return ccg_ActiveFlag;
    }

    public void setCcg_ActiveFlag(Boolean ccg_ActiveFlag) {
       this.ccg_ActiveFlag =  ccg_ActiveFlag;
      }
    
    
    //delete flag
    
    public Boolean getCcg_DeleteFlag() {
        return ccg_DeleteFlag;
    }

    public void setCcg_DeleteFlag(Boolean ccg_DeleteFlag) {
       this.ccg_DeleteFlag =  ccg_DeleteFlag;
      }

// getter and setter of create date and modify date 
    
     public Date getCcg_CreateDate() {
        return ccg_CreateDate;
    }

    public void setCcg_CreateDate(Date ccg_CreateDate) {
        this.ccg_CreateDate = ccg_CreateDate;
    }
    
    
     public Date getCcg_ModifyDate() {
        return ccg_ModifyDate;
    }

    public void setCcg_ModifyDate(Date ccg_ModifyDate) {
        this.ccg_ModifyDate = ccg_ModifyDate;
    }
    
    //create user
    
     public int getCcg_CreateUser() {
        return ccg_CreateUser;
    }
      public void setCcg_CreateUser(int ccg_CreateUser) {
        this.ccg_CreateUser = ccg_CreateUser;
    }

      
        public int getCcg_ModifyUser() {
        return ccg_ModifyUser;
    }
      
      
    public void setCcg_ModifyUser(int ccg_ModifyUser) {
        this.ccg_ModifyUser=ccg_ModifyUser;
    }

    
        
   
}
