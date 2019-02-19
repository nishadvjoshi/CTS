/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.controller;

/**
 *
 * @author nishad
 */
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cts.dao.CaseMasterDAO;
import com.cts.dao.ClientDAO;
import com.cts.model.CaseMaster;
import com.cts.model.CaseMaster;
import com.cts.model.Client;

public class CaseMController extends HttpServlet {
    private static final long serialVersionUID = 1L;
     private static String INSERT_OR_EDIT = "/ctsCaseDetailRegistration.jsp";
     private static String LIST_CASEMASTER = "/ctsListCaseMaster.jsp";
     private CaseMasterDAO dao; 
  
     
     
}
