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
public class State {
    int cms_ID;
    String cms_StateName, cms_StateDescription;

    public int getCms_ID() {
        return cms_ID;
    }

    public void setCms_ID(int cms_ID) {
        this.cms_ID = cms_ID;
    }

    public String getCms_StateName() {
        return cms_StateName;
    }

    public void setCms_StateName(String cms_StateName) {
        this.cms_StateName = cms_StateName;
    }

    public String getCms_StateDescription() {
        return cms_StateDescription;
    }

    public void setCms_StateDescription(String cms_StateDescription) {
        this.cms_StateDescription = cms_StateDescription;
    }
    
}
