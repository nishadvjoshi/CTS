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


import com.cts.dao.DocumentDAO;
import com.cts.model.Document;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;



public class DocumentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/ctsDocument.jsp";
    private static String LIST_CASESTAGE = "/ctsListDocument.jsp";
    private DocumentDAO dao;
    
    public DocumentController() {
        super();
        dao = new DocumentDAO();
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
        if (action.equalsIgnoreCase("listDocument")){
            forward = LIST_CASESTAGE;
            request.setAttribute("casemasters", dao.getAllCaseMaster());
        }
       else if (action.equalsIgnoreCase("delete")){
            int documentID = Integer.parseInt(request.getParameter("documentID"));
            dao.deleteDocument(documentID);
            forward = LIST_CASESTAGE;
            request.setAttribute("casemasters", dao.getAllCaseMaster());    
       }
       else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int documentID = Integer.parseInt(request.getParameter("documentID"));
            Document caseStage = dao.getCaseDocumentById(documentID);
            request.setAttribute("casemasters", dao.getAllCaseMaster());
        }
        else {
            forward = INSERT_OR_EDIT;
            request.setAttribute("casemasters", dao.getAllCaseMaster());
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
          
        
        
        
        Document document = new Document();
       
        
        document.setCmd_DocumentType(request.getParameter("cmd_DocumentType"));
        document.setCmd_Description(request.getParameter("cmd_Description"));
        
        boolean DeleteFlag = Boolean.parseBoolean(request.getParameter("cmd_DeleteFlag"));
        boolean ActiveFlag = Boolean.parseBoolean(request.getParameter("cmd_ActiveFlag"));
        document.setCmd_DeleteFlag(DeleteFlag);
        document.setCmd_ActiveFlag(ActiveFlag);
        
        int CreateUser = Integer.parseInt(request.getParameter("cmd_CreateUser"));
        int ModifyUser = Integer.parseInt(request.getParameter("cmd_ModifyUser"));
        document.setCmd_CreateUser(CreateUser);
        document.setCmd_ModifyUser(ModifyUser);
        
       
        
        try {
            Date CreateDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("cmd_CreateDate"));
            document.setCmd_CreateDate(CreateDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        try {
            Date ModifyDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("cmd_ModifyDate"));
            document.setCmd_ModifyDate(ModifyDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        
        String documentID = request.getParameter("documentID");
        if(documentID == null || documentID.isEmpty())
        {
            dao.addDocument(document);
        }
        else
        {
            document.setCmd_ID(Integer.parseInt(documentID));
            dao.updateDocument(document);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_CASESTAGE);
        request.setAttribute("documents", dao.getAllDocument());
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
