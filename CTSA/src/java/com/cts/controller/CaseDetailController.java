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

import com.cts.dao.ClientDAO;
import com.cts.model.CaseMaster;
import com.cts.model.CaseDetail;
import com.cts.dao.CaseDetailDAO;
import com.cts.model.Client;

public class CaseDetailController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/ctsRojnama.jsp";
    private static String LIST_DAIRY_SEARCH = "/ctsCaseDiary.jsp";
    private static String LIST_DAIRY_ROJNAMA = "/ctsRojnama.jsp";
    private static String LIST_CASEDETAIL = "/ctsListCaseDetail.jsp";
    private static String LOGIN_PAGE = "/ctsLogin.jsp";
    private CaseDetailDAO dao;
    private String host;
    private String port;
    private String user;
    private String pass;
InputStream inputStream;
    public void init() {
       
        
        
        ServletContext context = getServletContext();
     
        try
        {
           
            String current = new java.io.File( "ctsConfig.properties" ).getCanonicalPath();
       // System.out.println("Current dir:"+current);
          FileReader reader = new FileReader(current);
    Properties prop = new Properties();
    prop.load(reader);

    String host = prop.getProperty("email.host");
    String port = prop.getProperty("email.port");
      String user = prop.getProperty("email.user");
    String pass = prop.getProperty("email.pass");
    System.out.println(host+""+port+""+user+""+pass);

        }
        catch(IOException pros)
        {
         System.out.println("Email Properties is not accessed because of"+pros);
        }
        
    }

    private ClientDAO clientDAO;

    public CaseDetailController() {
        super();
        dao = new CaseDetailDAO();
        clientDAO = new ClientDAO();
    }

    @Override
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

           
            if (session == null) {                
                forward = LOGIN_PAGE;
            } else {

              
                //request.setAttribute("casedetails", dao.getAllCaseDetail());
                request.setAttribute("casemasters", dao.getAllCaseMaster());
                request.setAttribute("advocates", dao.getAllAdvocate());
                request.setAttribute("casestages", dao.getAllCaseStage());
                request.setAttribute("courts", dao.getAllCourt());
                
                  forward = LIST_DAIRY_SEARCH;
            }
        }
    else if (action.equalsIgnoreCase ("delete")) {
            int CaseDetailID = Integer.parseInt(request.getParameter("CaseDetailID"));

        System.out.println("This is var: " + request.getParameter("cad_ID"));

            //request.setAttribute("casedetailsTMP", dao.getAllCaseDetailByDetailID(CaseDetailID));
        //int cad_ID = Integer.parseInt(dao.getAllCaseDetailByDetailID(CaseDetailID).toString());
        dao.deleteCaseDetail(CaseDetailID);
        CaseDetail casedetail = dao.getCaseDetailByDId(CaseDetailID);
        CaseMaster casemster = dao.getCaseMasterByDetailId(CaseDetailID);
        request.setAttribute("casemaster", casemster);
        request.setAttribute("casedetail", casedetail);
        request.setAttribute("casedetails", dao.getAllCaseDetailByDetailID(CaseDetailID));
        request.setAttribute("casemasters", dao.getAllCaseMaster());
        request.setAttribute("advocates", dao.getAllAdvocate());
        request.setAttribute("casestages", dao.getAllCaseStage());
        request.setAttribute("courts", dao.getAllCourt());
        forward = LIST_DAIRY_SEARCH;

    }

    else if (action.equalsIgnoreCase ("edit")) {

            int CaseDetailID = Integer.parseInt(request.getParameter("CaseDetailID"));
        CaseMaster casemster = dao.getCaseMasterByDetailId(CaseDetailID);
        CaseMaster casemasters = dao.getCaseMasterByDetailId(CaseDetailID);
        String up = "update";
        CaseDetail casemdetail = dao.getCaseDetailByDId(CaseDetailID);
        request.setAttribute("casemaster", casemster);
        request.setAttribute("casemdetail", casemdetail);
        request.setAttribute("casemaster", casemasters);
        request.setAttribute("casedetails", dao.getAllCaseDetailByDetailID(CaseDetailID));
        request.setAttribute("casemasters", dao.getAllCaseMaster());
        request.setAttribute("advocates", dao.getAllAdvocate());
        request.setAttribute("casestages", dao.getAllCaseStage());
        request.setAttribute("courts", dao.getAllCourt());
        request.setAttribute("upd", up);
        forward = INSERT_OR_EDIT;
      //   forward="/ctsCaseDiary.jsp";

    }

    else if (action.equalsIgnoreCase ("update")) {
            int CaseMasterID = Integer.parseInt(request.getParameter("CaseMasterID"));
        request.setAttribute("casemaster", dao.getCaseMasterById(CaseMasterID));
        request.setAttribute("casedetail", dao.getCaseDetailById(CaseMasterID));
        request.setAttribute("casemasters", dao.getAllCaseMaster());
        request.setAttribute("advocates", dao.getAllAdvocate());
        request.setAttribute("casestages", dao.getAllCaseStage());
        request.setAttribute("courts", dao.getAllCourt());
        request.setAttribute("casedetails", dao.getAllCaseDetailByID(CaseMasterID));
        request.setAttribute("casemdetail", dao.getLastCaseDetailByID(CaseMasterID));
        forward = LIST_DAIRY_ROJNAMA;

    }
    else if (request.getParameter("action").equalsIgnoreCase("AddAdvocate")) {

            request.getRequestDispatcher("/ctsAddAdvocate.jsp").forward(request, response);

        } else if (request.getParameter("action").equalsIgnoreCase("AddCaseStage") ) {

            request.getRequestDispatcher("/ctsAddCaseStage.jsp").forward(request, response);

        } else if (request.getParameter("action").equalsIgnoreCase("AddCourt")) {

            request.getRequestDispatcher("/ctsCourt.jsp").forward(request, response);

        } 

    
        else {
            forward = INSERT_OR_EDIT;
    }

    RequestDispatcher view = request.getRequestDispatcher(forward);

    view.forward (request, response);
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
        CaseDetail casedetail = new CaseDetail();
        
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
          
        
        
        
        int TaskAssignToID = 0;
        int i=0;
        String TaskAssignTo = "";
        String recipient = "";
        //String recipient = request.getParameter("recipient");
        String subject = "CTS Case Rojnama Notification: ";
        String content = "";
        String resultMessage = "";

        if (request.getParameter("GetDetails") != null) {

            String str = request.getParameter("cad_FileName");
            System.out.println("file NAME IS"+str);
            String selected_Comments[] = request.getParameterValues("cad_FileName");
            subject = subject + request.getParameterValues("cad_FileName");
            for (String comment : selected_Comments) {
                //System.out.println("inside"+comment);
                request.setAttribute("casemaster", dao.getCaseMasterById(Integer.parseInt(comment)));
                request.setAttribute("casedetail", dao.getCaseDetailById(Integer.parseInt(comment)));
                request.setAttribute("casemasters", dao.getAllCaseMaster());
                request.setAttribute("advocates", dao.getAllAdvocate());
                request.setAttribute("casestages", dao.getAllCaseStage());
                request.setAttribute("courts", dao.getAllCourt());
                request.setAttribute("casedetails", dao.getAllCaseDetailByID(Integer.parseInt(comment)));
                request.setAttribute("casemdetail", dao.getLastCaseDetailByID(Integer.parseInt(comment)));
                request.getRequestDispatcher("/ctsCaseDiary.jsp").forward(request, response);

            }

        } else if (request.getParameter("AddCase") != null) {
            request.setAttribute("advocates", dao.getAllAdvocate());
            request.setAttribute("casestages", dao.getAllCaseStage());
            request.setAttribute("courts", dao.getAllCourt());
            request.setAttribute("clients", dao.getAllClient());
            request.setAttribute("casemaster", dao.getMaxRegNo());
            request.getRequestDispatcher("/ctsCaseMasterRegistration.jsp").forward(request, response);
        } else if (request.getParameter("AddAdvocate") != null) {

            request.getRequestDispatcher("/ctsAddAdvocate.jsp").forward(request, response);

        } else if (request.getParameter("AddCaseStage") != null) {

            request.getRequestDispatcher("/ctsAddCaseStage.jsp").forward(request, response);

        } else if (request.getParameter("AddCourt") != null) {

            request.getRequestDispatcher("/ctsCourt.jsp").forward(request, response);

        } else if (request.getParameter("NewRojnama") != null) {
            
                String str = request.getParameter("cad_FileName");
            System.out.println(str);
            String selected_Comments[] = request.getParameterValues("cad_FileName");
            subject = subject + request.getParameterValues("cad_FileName");;
            for (String comment : selected_Comments) {
              //  System.out.println(comment);
                request.setAttribute("casemaster", dao.getCaseMasterById(Integer.parseInt(comment)));
              
                request.setAttribute("casedetail", dao.getCaseDetailById(Integer.parseInt(comment)));
                request.setAttribute("casemasters", dao.getAllCaseMaster());
                request.setAttribute("advocates", dao.getAllAdvocate());
                request.setAttribute("casestages", dao.getAllCaseStage());
                request.setAttribute("courts", dao.getAllCourt());
            
                request.setAttribute("casedetails", dao.getAllCaseDetailByID(Integer.parseInt(comment)));
                request.setAttribute("casemdetail", dao.getLastCaseDetailByID(Integer.parseInt(comment)));
                
                request.getRequestDispatcher("/ctsRojnama.jsp").forward(request, response);
            }
        } else if (request.getParameter("SaveDetails") != null) {
            //casecategory.setCcg_CategoryName(request.getParameter("CategoryName"));
            //casecategory.setCcg_Description(request.getParameter("Description"));
            //
            
            
            int cad_ID = Integer.parseInt(request.getParameter("cad_ID"));
            System.out.println("This is var: "+cad_ID);
            
            
          
            
          System.out.println("This is ccd id: "+request.getParameter("ccd_id"));

            int ccd_ID;
            
            ccd_ID=Integer.parseInt(request.getParameter("ccd_id"));
             System.out.println("This is ccd id: "+ccd_ID);
             
  
             
             
            int RegNo = Integer.parseInt(request.getParameter("cad_RegNo"));
            String updat_editflag=request.getParameter("ccd_EditFlag");
           System.out.println(updat_editflag);
            
            
            
            int CreateUser;
          
            CreateUser = Integer.parseInt(request.getParameter("ccd_CreateUser"));
            
            int ModifyUser = Integer.parseInt(request.getParameter("ccd_ModifyUser"));
            //
            casedetail.setCcd_ID(ccd_ID);        
            casedetail.setCad_ID(cad_ID);
            casedetail.setCcd_CreateUser(CreateUser);
            casedetail.setCcd_ModifyUser(ModifyUser);
            casedetail.setCad_RegNo(RegNo);

            System.out.println("Case No"+request.getParameter("cad_CaseNo"));
            casedetail.setCad_CaseNo(request.getParameter("cad_CaseNo"));

            casedetail.setCad_FileNo(request.getParameter("cad_FileNo"));
            casedetail.setCad_FileName(request.getParameter("cad_FileName"));
            System.out.println("Name of file"+request.getParameter("cad_FileName"));
            System.out.println("Name of judge"+request.getParameter("ccd_Judge"));
            casedetail.setCcd_Stage(request.getParameter("ccd_Stage"));
            casedetail.setCcd_AAdvocate(request.getParameter("ccd_AAdvocate"));
         //   System.out.println(request.getParameter("ccd_Judge"));
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
            //String ccd_EditFlag = request.getParameter("ccd_EditFlag");

           
            tmpCurrentDate = request.getParameter("ccd_NextCurrentDate");
             System.out.println("Current date"+tmpCurrentDate);
            try {
                Date CurrentDate = new SimpleDateFormat("dd/MM/yyyy").parse(tmpCurrentDate);
                casedetail.setCcd_CurrentDate(CurrentDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (!updat_editflag.equals("update")) {

                System.out.println("Last Update ID - " + request.getParameter("LastDetail_ID"));
                dao.UpdateRojnama(Integer.parseInt(request.getParameter("LastDetail_ID")), request.getParameter("ccd_Rojnama"), request.getParameter("ccd_AAdvocate"));
                dao.addCaseDetail(casedetail);
                Client client = dao.getClientEmailByID(Integer.parseInt(request.getParameter("cmc_ID")));
                
                recipient = client.getCmc_EmailID1();
                
                System.out.println("he is a recipient"+recipient);
                content = "<p> Hi" + TaskAssignTo + ",</p> Hope you are doing good. Following is update on your case : </p> <p><b>Case Name: </b> " + request.getParameter("cad_FileName") + "</p> <p><b>Case Number: </b> " + request.getParameter("cad_CaseNo") + "</p> <p><b>Rojnama:</b>" + request.getParameter("ccd_Rojnama") + "</p> <p><b>Next Date:</b> " + request.getParameter("ccd_NextCurrentDate") + "</p><p>Please get in touch with CTS Admin (sushilnimbkar41@gmail.com) if you've any further questions.</p>";
                
                //Following code block will send email to client about Rojnama
                try {
                    
                    
                    EmailUtility.sendEmail(recipient, subject,content);
                    //resultMessage = "The e-mail was sent successfully";
                } catch (Exception ex) {
                    ex.printStackTrace();
                    //resultMessage = "There were an error: " + ex.getMessage();
                } finally {
                    request.setAttribute("Message", resultMessage);
                    //getServletContext().getRequestDispatcher("/Result.jsp").forward(request, response);
                }

            } 
            
            else {

                casedetail.setCcd_ID(Integer.parseInt(CaseDetailID));
                dao.updateCaseDetail(casedetail);
                Client client = dao.getClientEmailByID(Integer.parseInt(request.getParameter("cmc_ID")));
                System.out.println(" cmc id is"+request.getParameter("cmc_ID"));
                recipient = client.getCmc_EmailID1();
                
                          System.out.println("he is a recipient"+recipient);
                          
                content = "<p> Hi" + TaskAssignTo + ",</p> Hope you are doing good. Following is update on your case : </p> <p><b>Case Name: </b> " + request.getParameter("cad_FileName") + "</p> <p><b>Case Number: </b> " + request.getParameter("cad_CaseNo") + "</p> <p><b>Rojnama:</b>" + request.getParameter("ccd_Rojnama") + "</p> <p><b>Next Date:</b> " + request.getParameter("ccd_NextCurrentDate") + "</p><p>Please get in touch with CTS Admin (sushilnimbkar41@gmail.com) if you've any further questions.</p>";
                
                //Following code block will send email to client about Rojnama
                
                try {
                    

                    EmailUtility.sendEmail( recipient, subject,content);
                    //resultMessage = "The e-mail was sent successfully";
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("email not sent "+ex);
                       
                    //resultMessage = "There were an error: " + ex.getMessage();
                } finally {
                    request.setAttribute("Message", resultMessage);
                    //getServletContext().getRequestDispatcher("/Result.jsp").forward(request, response);
                }

            }
             try
                {
                    int doc_flag=Integer.parseInt(request.getParameter("Document"));
                       
                if(doc_flag>0)
              {
                      session.setAttribute("cad_ID", request.getParameter("cad_ID"));
                session.setAttribute("cad_CaseNo",request.getParameter("cad_CaseNo"));
                session.setAttribute("cad_FileName", request.getParameter("cad_FileName"));
                  session.setAttribute("cad_RegNo", request.getParameter("cad_RegNo")); 
                  session.setAttribute("redirect", "casediary"); 
                    System.out.println(" after  update else"+doc_flag);
                    RequestDispatcher view = request.getRequestDispatcher("AddCaseDocument.jsp");
                  view.forward(request, response);
              }
                }
                catch (Exception exp){
                    System.out.println(" after  update exception "+exp); 
            RequestDispatcher view = request.getRequestDispatcher(LIST_DAIRY_SEARCH);
            request.setAttribute("casemaster", dao.getCaseMasterById(Integer.parseInt(request.getParameter("cad_ID"))));
            request.setAttribute("casemasters", dao.getAllCaseMasterByMasterID(Integer.parseInt(request.getParameter("cad_ID"))));
            request.setAttribute("advocates", dao.getAllAdvocate());
            request.setAttribute("casestages", dao.getAllCaseStage());
            request.setAttribute("casemasters", dao.getAllCaseMaster());
            request.setAttribute("casedetails", dao.getAllCaseDetailByID(cad_ID));

            request.setAttribute("courts", dao.getAllCourt());
            view.forward(request, response);
        }
        
        
      
        }
        
        //update
        
        
        
        
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
