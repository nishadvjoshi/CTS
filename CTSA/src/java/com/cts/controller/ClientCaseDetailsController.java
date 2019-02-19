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

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import com.cts.dao.CaseMasterDAO;
import com.cts.dao.ClientDAO;
import com.cts.model.CaseMaster;
import com.cts.model.CaseDetail;
import com.cts.dao.CaseDetailDAO;
import com.cts.model.Client;

public class ClientCaseDetailsController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/ctsClientCaseDiary.jsp";
    private static String LIST_DAIRY_SEARCH = "/ctsClientCaseDiary.jsp";
    private static String LIST_CASEDETAIL = "/ctsClientCaseDiary.jsp";
    private static String LOGIN_PAGE = "/ctsLogin.jsp";
    private CaseDetailDAO dao;
    private static int ClientID;

    private ClientDAO clientDAO;

    public ClientCaseDetailsController() {
        super();
        dao = new CaseDetailDAO();
        clientDAO = new ClientDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
               
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
HttpSession session = request.getSession(false);
try
{
            if (session.getAttribute("cmu_ID")==null ) {                
          session.invalidate();
              //  forward = LOGIN_PAGE;
               // System.out.println("im from session if"+session.getAttribute("cmu_ID")+" here "+session);
                 out.println("<script type=\"text/javascript\">");
                      out.println("alert('Session timeout Please Log in again');");
                     
                        
              
                  out.println("location='LogOutController?action=logout';");
                    out.println("</script>");
            } else {
               // System.out.println("im from session else where id is "+session.getAttribute("cmu_ID"));
        if (action.equalsIgnoreCase("listCaseDetail")) {

            //HttpSession session = request.getSession(false);
            if (session == null) {
                forward = LOGIN_PAGE;
            } else {
                
                
                ClientID  = Integer.parseInt(session.getAttribute("ClientID").toString());
                forward = LIST_DAIRY_SEARCH;
                //request.setAttribute("casedetails", dao.getAllCaseDetail());
                request.setAttribute("casemasters", dao.getAllClientCaseMaster(ClientID));
                request.setAttribute("advocates", dao.getAllAdvocate());
                request.setAttribute("casestages", dao.getAllCaseStage());
                request.setAttribute("courts", dao.getAllCourt());
            }
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
             }
                                    catch(Exception ioex)
{
     System.out.println("im from exception block of controller"+ioex);
                         out.println("<script type=\"text/javascript\">");
                      out.println("alert('Session timeout Please Log in again');");
                                       out.println("location='LogOutController?action=logout';");
                    out.println("</script>");  
}
}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         response.setContentType("text/html");
        PrintWriter out = response.getWriter();
HttpSession session = request.getSession(false);
try
{
            if (session.getAttribute("cmu_ID")==null ) {                
          session.invalidate();
              //  forward = LOGIN_PAGE;
               // System.out.println("im from session if"+session.getAttribute("cmu_ID")+" here "+session);
                 out.println("<script type=\"text/javascript\">");
                      out.println("alert('Session timeout Please Log in again');");
                     out.println("location='LogOutController?action=logout';");
                    out.println("</script>");
            } else {
               // System.out.println("im from session else where id is "+session.getAttribute("cmu_ID"));
          
        
        
        
        CaseDetail casedetail = new CaseDetail();

        if (request.getParameter("GetDetails") != null) {

            String str = request.getParameter("cad_FileName1");
            System.out.println(str);
            String selected_Comments[] = request.getParameterValues("cad_FileName1");

            for (String comment : selected_Comments) {
                System.out.println(comment);
                request.setAttribute("casemaster", dao.getCaseMasterById(Integer.parseInt(comment)));
                request.setAttribute("casedetail", dao.getCaseDetailById(Integer.parseInt(comment)));
                //request.setAttribute("casemasters", dao.getAllCaseMaster());
                request.setAttribute("casemasters", dao.getAllClientCaseMaster(ClientID));
                
                request.setAttribute("casedetails", dao.getAllCaseDetailByID(Integer.parseInt(comment)));
                request.setAttribute("casemdetail", dao.getLastCaseDetailByID(Integer.parseInt(comment)));
                request.getRequestDispatcher("/ctsClientCaseDiary.jsp").forward(request, response);

            }

        }

        RequestDispatcher view = request.getRequestDispatcher(LIST_DAIRY_SEARCH);
        request.setAttribute("casemaster", dao.getCaseMasterById(Integer.parseInt(request.getParameter("cad_id"))));
        request.setAttribute("casemasters", dao.getAllCaseMasterByMasterID(Integer.parseInt(request.getParameter("cad_id"))));
     
        request.setAttribute("casemasters", dao.getAllCaseMaster());
        request.setAttribute("casedetails", dao.getAllCaseDetailByID(Integer.parseInt(request.getParameter("cad_id"))));

        
        view.forward(request, response);
        
         }
             
    }
   catch(Exception ioex)
{
                      System.out.println("im from exception block of controller"+ioex);
                      out.println("<script type=\"text/javascript\">");
                      out.println("alert('Session timeout Please Log in again');");
                      out.println("location='LogOutController?action=logout';");
                      out.println("</script>");  
}
    }
}
