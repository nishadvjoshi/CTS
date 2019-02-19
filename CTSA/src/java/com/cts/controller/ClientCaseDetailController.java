/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.controller;

/**
 *
 * @author Admin
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
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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

public class ClientCaseDetailController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/ctsClientCaseDairy.jsp";
    private static String LIST_DAIRY_SEARCH = "/ctsClientCaseDairy.jsp";
    private static String LIST_CASEDETAIL = "/ctsListCaseDetail.jsp";
    private CaseDetailDAO dao;
    private String host;
    private String port;
    private String user;
    private String pass;

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }

    private ClientDAO clientDAO;

    public ClientCaseDetailController() {
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
            forward = LIST_DAIRY_SEARCH;
            //request.setAttribute("casedetails", dao.getAllCaseDetail());
            // HttpSession session = request.getSession(false);
             int ClientID = Integer.parseInt(session.getAttribute("ClientID").toString());   
            request.setAttribute("casemasters", dao.getAllClientCaseMaster(ClientID));
            
        }  else {
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
        int TaskAssignToID = 0;
        String TaskAssignTo = "";
        String recipient = "";
        //String recipient = request.getParameter("recipient");
        String subject = "CTS Case Rojnama Notification: ";
        String content = "";
        String resultMessage = "";

        if (request.getParameter("GetDetails") != null) {

            String str = request.getParameter("cad_FileName1");
            System.out.println(str);
            String selected_Comments[] = request.getParameterValues("cad_FileName1");
            subject = subject + request.getParameterValues("cad_FileName1");
            //HttpSession session = request.getSession(false);
            int ClientID = Integer.parseInt(session.getAttribute("ClientID").toString());   
            for (String comment : selected_Comments) {
                System.out.println(comment);
                request.setAttribute("casemaster", dao.getCaseMasterById(Integer.parseInt(comment)));
                request.setAttribute("casedetail", dao.getCaseDetailById(Integer.parseInt(comment)));
                request.setAttribute("casemasters", dao.getAllCaseMaster());
                request.setAttribute("advocates", dao.getAllAdvocate());
                request.setAttribute("casestages", dao.getAllCaseStage());
                request.setAttribute("courts", dao.getAllCourt());
                request.setAttribute("casedetails", dao.getAllCaseDetailByClientID(Integer.parseInt(comment), ClientID));
                request.setAttribute("casemdetail", dao.getLastCaseDetailByID(Integer.parseInt(comment)));
                request.getRequestDispatcher("/ctsClientCaseDairy.jsp").forward(request, response);

            }

        } else if (request.getParameter("AddCase") != null) {
            request.setAttribute("advocates", dao.getAllAdvocate());
            request.setAttribute("casestages", dao.getAllCaseStage());
            request.setAttribute("courts", dao.getAllCourt());
            request.setAttribute("clients", dao.getAllClient());
            request.setAttribute("casemaster", dao.getMaxRegNo());
            request.getRequestDispatcher("/ctsCaseMasterRegistration.jsp").forward(request, response);
        } else if (request.getParameter("AddAdvocate") != null) {

            request.getRequestDispatcher("/ctsAdvocateRegistration.jsp").forward(request, response);

        } else if (request.getParameter("AddCaseStage") != null) {

            request.getRequestDispatcher("/ctsCaseStage.jsp").forward(request, response);

        } else if (request.getParameter("AddCourt") != null) {

            request.getRequestDispatcher("/ctsCourtRegistration.jsp").forward(request, response);

        } else if (request.getParameter("SaveDetails") != null) {
            //casecategory.setCcg_CategoryName(request.getParameter("CategoryName"));
            //casecategory.setCcg_Description(request.getParameter("Description"));
            //int ccd_ID = Integer.parseInt(request.getParameter("ccd_ID"));
            int cad_ID = Integer.parseInt(request.getParameter("cad_id"));
            int RegNo = Integer.parseInt(request.getParameter("cad_RegNo"));
            int CreateUser = Integer.parseInt(request.getParameter("ccd_CreateUser"));
            int ModifyUser = Integer.parseInt(request.getParameter("ccd_ModifyUser"));
            //casedetail.setCcd_ID(ccd_ID);        
            casedetail.setCad_ID(cad_ID);
            casedetail.setCcd_CreateUser(CreateUser);
            casedetail.setCcd_ModifyUser(ModifyUser);
            casedetail.setCad_RegNo(RegNo);

            System.out.println(request.getParameter("cad_CaseNo"));
            casedetail.setCad_CaseNo(request.getParameter("cad_CaseNo"));

            casedetail.setCad_FileNo(request.getParameter("cad_FileNo"));
            casedetail.setCad_FileName(request.getParameter("cad_FileName"));
            System.out.println(request.getParameter("cad_FileName"));
            System.out.println(request.getParameter("ccd_Judge"));
            casedetail.setCcd_Stage(request.getParameter("ccd_Stage"));
            casedetail.setCcd_AAdvocate(request.getParameter("ccd_AAdvocate"));
            System.out.println(request.getParameter("ccd_Judge"));
            casedetail.setCcd_Judge(request.getParameter("ccd_Judge"));
            casedetail.setCcd_Rojnama(request.getParameter("ccd_Rojnama"));
            casedetail.setCcd_Judgment(request.getParameter("ccd_Judgment"));
            casedetail.setCcd_Remarks(request.getParameter("ccd_Remarks"));
            casedetail.setCcd_Court(request.getParameter("ccd_Court"));
            casedetail.setCcd_CreateUserName(request.getParameter("ccd_CreateUserName"));
            casedetail.setCcd_ModifyUserName(request.getParameter("ccd_CreateUserName"));
            casedetail.setCcd_CaseLocation(request.getParameter("ccd_CaseLocation"));
            String tmpCurrentDate = "";

            try {
                Date CreateDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("ccd_CreateDate"));
                casedetail.setCcd_CreateDate(CreateDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            try {
                Date ModifyDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("ccd_ModifyDate"));
                casedetail.setCcd_ModifyDate(ModifyDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            boolean ActiveFlag = Boolean.parseBoolean(request.getParameter("ccd_ActiveFlag"));
            boolean DeleteFlag = Boolean.parseBoolean(request.getParameter("ccd_DeleteFlag"));
            casedetail.setCcd_ActiveFlag(ActiveFlag);
            casedetail.setCcd_DeleteFlag(DeleteFlag);

            String CaseDetailID = request.getParameter("ccd_id");
            String ccd_EditFlag = request.getParameter("ccd_EditFlag");

            if (!ccd_EditFlag.equals("update")) {
                if (request.getParameter("ccd_CurrentDate") == null || request.getParameter("ccd_CurrentDate").isEmpty()) {
                    tmpCurrentDate = request.getParameter("ccd_NextCurrentDate");
                } else {
                    tmpCurrentDate = request.getParameter("ccd_CurrentDate");
                }

            } else {
                if (request.getParameter("ccd_CurrentDate") == null || request.getParameter("ccd_CurrentDate").isEmpty()) {
                    tmpCurrentDate = request.getParameter("ccd_PreviousDate");
                } else {
                    tmpCurrentDate = request.getParameter("ccd_CurrentDate");
                }

            }

            try {
                Date CurrentDate = new SimpleDateFormat("dd/MM/yyyy").parse(tmpCurrentDate);
                casedetail.setCcd_CurrentDate(CurrentDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (!ccd_EditFlag.equals("update")) {

                System.out.println("Last Update ID - " + request.getParameter("LastDetail_ID"));
                dao.UpdateRojnama(Integer.parseInt(request.getParameter("LastDetail_ID")), request.getParameter("ccd_Rojnama"), request.getParameter("ccd_AAdvocate"));
                dao.addCaseDetail(casedetail);
                Client client = dao.getClientEmailByID(Integer.parseInt(request.getParameter("cmc_ID")));
                
                recipient = client.getCmc_EmailID1();
                
                System.out.println(recipient);
                content = "<p> Hi" + TaskAssignTo + ",</p> Hope you are doing good. Following is update on your case : </p> <p><b>Case Name: </b> " + request.getParameter("cad_FileName") + "</p> <p><b>Case Number: </b> " + request.getParameter("cad_CaseNo") + "</p> <p><b>Rojnama:</b>" + request.getParameter("ccd_Rojnama") + "</p> <p><b>Next Date:</b> " + request.getParameter("ccd_NextCurrentDate") + "</p><p>Please get in touch with CTS Admin (sushilnimbkar41@gmail.com) if you've any further questions.</p>";
                
                //Following code block will send email to client about Rojnama
                try {
                    EmailUtility.sendEmail( recipient, subject,
                            content);
                    //resultMessage = "The e-mail was sent successfully";
                } catch (Exception ex) {
                    ex.printStackTrace();
                    //resultMessage = "There were an error: " + ex.getMessage();
                } finally {
                    request.setAttribute("Message", resultMessage);
                    //getServletContext().getRequestDispatcher("/Result.jsp").forward(request, response);
                }

            } else {

                casedetail.setCcd_ID(Integer.parseInt(CaseDetailID));
                dao.updateCaseDetail(casedetail);
            }
            RequestDispatcher view = request.getRequestDispatcher(LIST_DAIRY_SEARCH);
            request.setAttribute("casemaster", dao.getCaseMasterById(Integer.parseInt(request.getParameter("cad_id"))));
            request.setAttribute("casemasters", dao.getAllCaseMasterByMasterID(Integer.parseInt(request.getParameter("cad_id"))));
            request.setAttribute("advocates", dao.getAllAdvocate());
            request.setAttribute("casestages", dao.getAllCaseStage());
            request.setAttribute("casemasters", dao.getAllCaseMaster());
            request.setAttribute("casedetails", dao.getAllCaseDetailByID(cad_ID));

            request.setAttribute("courts", dao.getAllCourt());
            view.forward(request, response);
        }
        
        
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
