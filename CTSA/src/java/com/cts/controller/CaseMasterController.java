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
import com.cts.model.Document;
import com.cts.model.CaseDetail;
import com.cts.dao.CaseDetailDAO;
import com.cts.model.Client;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.http.HttpSession;


public class CaseMasterController extends HttpServlet {
     private static final long serialVersionUID = 1L;
     private static String INSERT_OR_EDIT = "/ctsAddCaseMaster.jsp";
     private static String LIST_CASEMASTER = "/ctsCaseMaster.jsp";
     private static String UPLOAD_CASEDOCS = "/ctsCaseDocuments.jsp";
     private static String UPDATE_CASEDIARY = "/RNDctsCaseDetailRegistration.jsp";
     private CaseMasterDAO dao; 
     private CaseDetailDAO caseDetailDAO;
     
     
      public CaseMasterController() {
        super();
        dao = new CaseMasterDAO();
        caseDetailDAO = new CaseDetailDAO();
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
        if (action.equalsIgnoreCase("listCaseMaster")) {
            forward = LIST_CASEMASTER;
            request.setAttribute("casemasters", dao.getAllCaseMaster());
        } else if (action.equalsIgnoreCase("delete")) {
            int CaseMasterID = Integer.parseInt(request.getParameter("CaseMasterID"));
            dao.deleteCaseMaster(CaseMasterID);
            forward = LIST_CASEMASTER;
            request.setAttribute("casemasters", dao.getAllCaseMaster());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int CaseMasterID = Integer.parseInt(request.getParameter("CaseMasterID"));
            CaseMaster casemaster = dao.getCaseMasterById(CaseMasterID);
             request.setAttribute("casemasters", dao.getAllCaseMaster());
            request.setAttribute("advocates", dao.getAllAdvocate());
            request.setAttribute("casestages", dao.getAllCaseStage());
            request.setAttribute("clients", dao.getAllClient()); 
            request.setAttribute("courts", dao.getAllCourt());
            request.setAttribute("casemaster", casemaster);
        } 
        else if (action.equalsIgnoreCase("upload")) {
            forward = UPLOAD_CASEDOCS;
            int CaseMasterID = Integer.parseInt(request.getParameter("CaseMasterID"));            
            CaseMaster casemaster = dao.getCaseMasterById(CaseMasterID);
            request.setAttribute("casemaster", casemaster);
            request.setAttribute("casedocuments", dao.GetDocumentType());
        }
        else if (action.equalsIgnoreCase("dairy")) {
            forward = UPDATE_CASEDIARY;
            int CaseMasterID = Integer.parseInt(request.getParameter("CaseMasterID"));
            CaseMaster casemaster = dao.getCaseMasterById(CaseMasterID);
            request.setAttribute("casemaster", casemaster);
            request.setAttribute("casemasters", dao.getAllCaseMaster());
            //request.setAttribute("casedetails", caseDetailDAO.getCaseDetailForCase(CaseMasterID));
        }
        else if (action.equalsIgnoreCase("frmAddCaseDetail")) {
            forward = INSERT_OR_EDIT;
            request.setAttribute("casemasters", dao.getAllCaseMaster());
            request.setAttribute("advocates", dao.getAllAdvocate());
            request.setAttribute("casestages", dao.getAllCaseStage());
            request.setAttribute("courts", dao.getAllCourt());
        }
        else {
            forward = INSERT_OR_EDIT;
            request.setAttribute("casemasters", dao.getAllCaseMaster());
            request.setAttribute("advocates", dao.getAllAdvocate());
            request.setAttribute("casestages", dao.getAllCaseStage());
            request.setAttribute("courts", dao.getAllCourt());
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
          
        if (request.getParameter("AddCase") != null) {
             
            request.setAttribute("advocates", dao.getAllAdvocate());
            request.setAttribute("casestages", dao.getAllCaseStage());
            request.setAttribute("courts", dao.getAllCourt());
            request.setAttribute("clients", dao.getAllClient()); 
            request.setAttribute("casemaster", dao.getMaxRegNo()); 
            request.getRequestDispatcher("/ctsAddCaseMaster.jsp").forward(request, response);   
         }     
        else if (request.getParameter("SaveDetails") != null) {    
             
        CaseMaster casemaster = new CaseMaster();
        
            String ClientID, ClientName = request.getParameter("cad_ClientName");
            System.out.println(ClientName);
            String selected_Comments[] = request.getParameterValues("cad_ClientName");
            
            for (String comment : selected_Comments) {
                System.out.println("ClientID is" + comment);
                ClientID = comment;
                casemaster.setCmc_ID(Integer.parseInt(ClientID));
            }

        
        //casecategory.setCcg_CategoryName(request.getParameter("CategoryName"));
        //casecategory.setCcg_Description(request.getParameter("Description"));
        
        int RegNo =  Integer.parseInt(request.getParameter("cad_RegNo"));
        int CreateUser = Integer.parseInt(request.getParameter("cad_CreateUser"));
        int ModifyUser = Integer.parseInt(request.getParameter("cad_ModifyUser"));
        casemaster.setCad_CreateUser(CreateUser);
        casemaster.setCad_ModifyUser(ModifyUser);
        casemaster.setCad_RegNo(RegNo);               

        casemaster.setCad_ClientName(request.getParameter("cad_ClientName"));
               
        casemaster.setCad_CaseNo(request.getParameter("cad_CaseNo"));
        casemaster.setCad_FileNo(request.getParameter("cad_FileNo"));
        casemaster.setCad_FileName(request.getParameter("cad_FileName"));
        casemaster.setCad_Location(request.getParameter("cad_Location"));
        casemaster.setCad_Court(request.getParameter("cad_Court"));
        casemaster.setCad_AppearingFor(request.getParameter("cad_AppearingFor"));
        casemaster.setCad_Advocate(request.getParameter("cad_Advocate"));
        casemaster.setCad_ACT(request.getParameter("cad_ACT"));
        casemaster.setCad_Stage(request.getParameter("cad_Stage"));
        casemaster.setCad_VakilPatraFiledBy(request.getParameter("cad_VakilPatraFiledBy"));
        casemaster.setCad_CaseCategory(request.getParameter("cad_CaseCategory"));
        casemaster.setCad_OpponentName(request.getParameter("cad_OpponentName"));
        casemaster.setCad_OpponentAdvocate(request.getParameter("cad_OpponentAdvocate"));
        casemaster.setCad_CaseType(request.getParameter("cad_CaseType"));
        casemaster.setCad_AssetCode(request.getParameter("cad_AssetCode"));
        casemaster.setCad_Remarks(request.getParameter("cad_Remarks"));
        casemaster.setCad_OtherInfo(request.getParameter("cad_OtherInfo"));
                
        
        try {
            Date VakilPatraFiledOn = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("cad_VakilPatraFiledOn"));
            casemaster.setCad_VakilPatraFiledOn(VakilPatraFiledOn);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Date CreateDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("cad_CreateDate"));
            casemaster.setCad_CreateDate(CreateDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            Date ModifyDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("cad_ModifyDate"));
            casemaster.setCad_ModifyDate(ModifyDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        boolean ActiveFlag = Boolean.parseBoolean(request.getParameter("cad_ActiveFlag"));
        boolean DeleteFlag = Boolean.parseBoolean(request.getParameter("cad_DeleteFlag"));
        casemaster.setCad_ActiveFlag(ActiveFlag);
        casemaster.setCad_DeleteFlag(DeleteFlag);
        
        
        String CaseMasterID = request.getParameter("CaseMasterID");
        if (CaseMasterID == null || CaseMasterID.isEmpty() || CaseMasterID.equals("0")) {
           int i= dao.addCaseMaster(casemaster);
           
            if(i>0)
               {
                  
                     out.println("<script type=\"text/javascript\">");
                      out.println("alert('Case Added Successfully');");
                     
                        
              
                    out.println("location='CaseMasterController?action=listCaseMaster';");
                    out.println("</script>");
               }
               else
               {    
                 
                  out.println("<script type=\"text/javascript\">");
                  out.println("alert('try again');");
                  
                   out.println("location='CaseMasterController?action=listCaseMaster';");
                  out.println("</script>"); 
               }
            
           
           
        } else {
            casemaster.setCad_ID(Integer.parseInt(CaseMasterID));
            int i=dao.updateCaseMaster(casemaster);
            
                if(i>0)
               {
                  
                     out.println("<script type=\"text/javascript\">");
                      out.println("alert('Casegory update Successfully');");
                     
                        
              
                  out.println("location='CaseMasterController?action=listCaseMaster';");
                    out.println("</script>");
               }
               else
               {    
                 
                  out.println("<script type=\"text/javascript\">");
                  out.println("alert('try again');");
                  
                 out.println("location='CaseMasterController?action=listCaseMaster';");
                  out.println("</script>"); 
               }
        }
        
        /*RequestDispatcher view = request.getRequestDispatcher(LIST_CASEMASTER);       
        request.setAttribute("casemasters", dao.getAllCaseMaster());
        view.forward(request, response);*/
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
