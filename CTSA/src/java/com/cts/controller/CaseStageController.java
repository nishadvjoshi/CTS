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


import com.cts.dao.CaseStageDAO;
import com.cts.model.CaseStage;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;



public class CaseStageController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/ctsAddCaseStage.jsp";
    private static String LIST_CASESTAGE = "/ctsCaseStage.jsp";
    private CaseStageDAO dao;
    
    public CaseStageController() {
        super();
        dao = new CaseStageDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
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
        if (action.equalsIgnoreCase("listCaseStage")){
            forward = LIST_CASESTAGE;
            request.setAttribute("casestages", dao.getAllCaseStageDesc());
        }
       else if (action.equalsIgnoreCase("delete")){
            int casestageID = Integer.parseInt(request.getParameter("casestageID"));
            dao.deleteCaseStage(casestageID);
            forward = LIST_CASESTAGE;
            request.setAttribute("casestages", dao.getAllCaseStageDesc());    
       }
       else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int casestageID = Integer.parseInt(request.getParameter("casestageID"));
            CaseStage caseStage = dao.getCaseCaseStageById(casestageID);
            request.setAttribute("casestage", caseStage);
        }
        else {
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
        CaseStage casestage = new CaseStage();
       
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
          
        casestage.setCcs_StageName(request.getParameter("ccs_StageName"));
        casestage.setCcs_Description(request.getParameter("ccs_Description"));
        
        boolean DeleteFlag = Boolean.parseBoolean(request.getParameter("ccs_DeleteFlag"));
        boolean ActiveFlag = Boolean.parseBoolean(request.getParameter("ccs_ActiveFlag"));
        casestage.setCcs_DeleteFlag(DeleteFlag);
        casestage.setCcs_ActiveFlag(ActiveFlag);
        
        int CreateUser = Integer.parseInt(request.getParameter("ccs_CreateUser"));
        int ModifyUser = Integer.parseInt(request.getParameter("ccs_ModifyUser"));
        casestage.setCcs_CreateUser(CreateUser);
        casestage.setCcs_ModifyUser(ModifyUser);
        
       
        
        try {
            Date CreateDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("ccs_CreateDate"));
            casestage.setCcs_CreateDate(CreateDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        try {
            Date ModifyDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("ccs_ModifyDate"));
            casestage.setCcs_ModifyDate(ModifyDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        
        String casestageID = request.getParameter("casestageID");
        if(casestageID == null || casestageID.isEmpty())
        {
            int i=dao.addCaseStage(casestage);
            
             if(i>0)
               {
                  
                     out.println("<script type=\"text/javascript\">");
                      out.println("alert('Case Stage Added Successfully');");
                     
                        
              
                 out.println("location='CaseStageController?action=listCaseStage';");
                    out.println("</script>");
               }
               else
               {    
                 
                  out.println("<script type=\"text/javascript\">");
                  out.println("alert('try again');");
                  
                 out.println("location='CaseStageController?action=listCaseStage';");
                  out.println("</script>"); 
               }
            
        }
        else
        {
            casestage.setCcs_ID(Integer.parseInt(casestageID));
            int i=dao.updateCaseStage(casestage);
           
            if(i>0)
               {
                  
                     out.println("<script type=\"text/javascript\">");
                      out.println("alert('Case Stage updated Successfully');");
                     
                        
              
                 out.println("location='CaseStageController?action=listCaseStage';");
                    out.println("</script>");
               }
               else
               {
                  out.println("<script type=\"text/javascript\">");
                  out.println("alert('try again');");
   
     out.println("location='CaseStageController?action=listCaseStage';");
                  out.println("</script>"); 
               }
        }
      /*  RequestDispatcher view = request.getRequestDispatcher(LIST_CASESTAGE);
        request.setAttribute("casestages", dao.getAllCaseStageDesc());
        view.forward(request, response);*/
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
