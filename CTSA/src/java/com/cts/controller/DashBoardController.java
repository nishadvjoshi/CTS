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

import com.cts.dao.CaseMasterDAO;
import com.cts.dao.ClientDAO;
import com.cts.model.CaseMaster;
import com.cts.model.CaseDetail;
import com.cts.dao.CaseDairyDAO;
import com.cts.dao.CaseDetailDAO;
import com.cts.dao.CaseDocumentDAO;
import com.cts.model.Client;
import com.cts.model.TaskMaster;
import com.cts.dao.CaseTaskDAO;
import com.cts.dao.UserDAO;
import com.cts.dao.ZIpFIle;
import com.cts.model.CaseDocument;
import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class DashBoardController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    //private static String INSERT_OR_EDIT = "/ctsCaseDetailRegistration.jsp";
    private static String LIST_CASEDETAIL = "/ctsDashboard.jsp";
    private static String LIST_MONTHLY = "/ctsMonthlyBoard.jsp";
    private static String LIST_UNDATED = "/ctsUnDatedBoard.jsp";
    private static String LIST_USER = "/ctsUserById.jsp";
    private CaseDairyDAO dao;
    private ClientDAO clientDAO;
    private CaseTaskDAO taskDAO;
    private CaseDetailDAO case_deatils_dao;
    private UserDAO userdao;
        private String host;
    private String port;
    private String user;
    private String pass;
        private CaseDocumentDAO edao;
            private ServletFileUpload uploader = null;
       private ZIpFIle daod;
     
    
        public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }

    public DashBoardController() {
        super();
        userdao = new UserDAO();
        dao = new CaseDairyDAO();
        clientDAO = new ClientDAO();
        taskDAO = new CaseTaskDAO();
        case_deatils_dao=new CaseDetailDAO();
        daod=new ZIpFIle();
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

try
{
        HttpSession session = request.getSession(false);
            if (session.getAttribute("cmu_ID")==null ) {                
          session.invalidate();
              //  forward = LOGIN_PAGE;
                System.out.println("im from session if"+session.getAttribute("cmu_ID")+" here "+session);
                 out.println("<script type=\"text/javascript\">");
                      out.println("alert('Session timeout Please Log in again');");
                      out.println("location='LogOutController?action=logout';");
                    out.println("</script>");
            } else {
                System.out.println("im from session else where id is "+session.getAttribute("cmu_ID"));
       
        if(!session.getAttribute("Role").equals("Client"))
        {
System.out.println("im not a "+session.getAttribute("Role"));
        if (action.equalsIgnoreCase("listMonthlyBoard")) {
            forward = LIST_MONTHLY;
            request.setAttribute("casemonthly", dao.getMonthlyBoard());
            request.setAttribute("casemonthlycount", dao.getMonthlyBoardCount());
        } else if (action.equalsIgnoreCase("listUnDatedBoard")) {
            forward = LIST_UNDATED;
            request.setAttribute("caseundated", dao.getUnDatedBoard());
            request.setAttribute("caseundatedcount", dao.getUnDatedBoardCount());
             request.setAttribute("casemasters", case_deatils_dao.getAllCaseMaster());
                request.setAttribute("advocates", case_deatils_dao.getAllAdvocate());
               request.setAttribute("casestages", case_deatils_dao.getAllCaseStage());
                request.setAttribute("courts", case_deatils_dao.getAllCourt());
        }
           else if (request.getParameter("action") .equals("AddAdvocate")) {

            request.getRequestDispatcher("/ctsAddAdvocate.jsp").forward(request, response);

        }
            else if (request.getParameter("action") .equals("AddCaseStage")) {

            request.getRequestDispatcher("/ctsAddCaseStage.jsp").forward(request, response);

        }
           else if (request.getParameter("action") .equals("AddCourt")) {

            request.getRequestDispatcher("/ctsAddCourt.jsp").forward(request, response);

        }
        
        
        
        
        else {
            forward = LIST_CASEDETAIL;
            request.setAttribute("casemonthlycount", dao.getMonthlyBoardCount());
            request.setAttribute("caseundatedcount", dao.getUnDatedBoardCount());
            request.setAttribute("casemastercount", dao.getCaseMasterCount());
            //request.setAttribute("weeklytaskcount", taskDAO.WeeklyTaskCountByID(Integer.parseInt(session.getAttribute("ClientID").toString())));
            request.setAttribute("casedetails", dao.getDailyBoard());
            request.setAttribute("caseweekly", dao.getWeeklyBoard());
               request.setAttribute("casemasters", case_deatils_dao.getAllCaseMaster());
                request.setAttribute("advocates", case_deatils_dao.getAllAdvocate());
               request.setAttribute("casestages", case_deatils_dao.getAllCaseStage());
                request.setAttribute("courts", case_deatils_dao.getAllCourt());
               // request.setAttribute("casedetails", case_deatils_dao.getAllCaseDetail());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
        else  
        {  
            System.out.println("im  a "+session.getAttribute("Role"));

      if(action.equals("listUserDetail"))
  {
       int userID = Integer.parseInt(session.getAttribute("cmu_ID").toString());
           
          forward = LIST_USER;
                  request.setAttribute("user", userdao.getUserById(userID));
                  RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
  }
         else
  {
      System.out.println("im from else inside get of userprofilecontrolller");
  }      
             RequestDispatcher view = request.getRequestDispatcher("ctsClientDashboard.jsp");
        view.forward(request, response);
        }
    }
   }
    catch(Exception ioex)
{
     System.out.println("im from exception block of bashbaordcontroller"+ioex);
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
         String relativePath="";
          CaseDocument casedocument = new CaseDocument();
                      
try
{
        HttpSession session = request.getSession(false);
            if (session.getAttribute("cmu_ID")==null ) {                
          session.invalidate();
              //  forward = LOGIN_PAGE;
                System.out.println("im from session if"+session.getAttribute("cmu_ID")+" here "+session);
                 out.println("<script type=\"text/javascript\">");
                      out.println("alert('Session timeout Please Log in again');");
                      out.println("location='LogOutController?action=logout';");
                    out.println("</script>");
            } else {
        
        
        if (request.getParameter("GetMonthlyBoard") != null) {

            Integer yr = Integer.parseInt(request.getParameter("ctm_SelectYear"));
            System.out.println(yr);
            String selected_Comments[] = request.getParameterValues("ctm_SelectMonth");
            for (String comment : selected_Comments) {
                System.out.println(comment);
                request.setAttribute("casemonthly", dao.getMonthlyBoardByMonth(Integer.parseInt(comment), yr));

                request.getRequestDispatcher("/ctsMonthlyBoard.jsp").forward(request, response);

            }

        } else if (request.getParameter("GetDailyBoard") != null) {
            
            String tDay = request.getParameter("tDay");
            System.out.println(tDay);
            request.setAttribute("casemonthlycount", dao.getMonthlyBoardCount());
            request.setAttribute("caseundatedcount", dao.getUnDatedBoardCount());
            request.setAttribute("casemastercount", dao.getCaseMasterCount());
            //request.setAttribute("weeklytaskcount", taskDAO.WeeklyTaskCountByID(Integer.parseInt(session.getAttribute("ClientID").toString())));
            request.setAttribute("casedetails", dao.getDailyBoardByDay(tDay));
            request.setAttribute("caseweekly", dao.getWeeklyBoard());
            request.getRequestDispatcher("/DailyBoard.jsp").forward(request, response);

        } else if (request.getParameter("Reset") != null) {
            request.setAttribute("casemonthlycount", dao.getMonthlyBoardCount());
            request.setAttribute("caseundatedcount", dao.getUnDatedBoardCount());
            request.setAttribute("casemastercount", dao.getCaseMasterCount());
            //request.setAttribute("weeklytaskcount", taskDAO.WeeklyTaskCountByID(Integer.parseInt(session.getAttribute("ClientID").toString())));
            request.setAttribute("casedetails", dao.getDailyBoard());
            request.setAttribute("caseweekly", dao.getWeeklyBoard());
            request.getRequestDispatcher("/DailyBoard.jsp").forward(request, response);

        }
        
        
       else if (request.getParameter("AddAdvocate") != null) {

            request.getRequestDispatcher("/ctsAddAdvocate.jsp").forward(request, response);

        } else if (request.getParameter("AddCaseStage") != null) {

            request.getRequestDispatcher("/ctsAddCaseStage.jsp").forward(request, response);

        } else if (request.getParameter("AddCourt") != null) {

            request.getRequestDispatcher("/ctsCourt.jsp").forward(request, response);

        }
        
        
        
      else  if (request.getParameter("SaveDetails") != null) {
            //casecategory.setCcg_CategoryName(request.getParameter("CategoryName"));
            //casecategory.setCcg_Description(request.getParameter("Description"));
            //
            
            
            int cad_ID = Integer.parseInt(request.getParameter("cad_ID"));
            System.out.println("This is var: "+cad_ID);
            request.setAttribute("cad_ID",cad_ID );
            
            System.out.println("This is ccd id: "+request.getParameter("ccd_id"));

            int ccd_ID = Integer.parseInt(request.getParameter("ccd_id"));
             System.out.println("This is ccd id: "+ccd_ID);
             
  
            int RegNo = Integer.parseInt(request.getParameter("cad_RegNo"));
            request.setAttribute("cad_RegNo",RegNo );
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
               request.setAttribute("cad_CaseNo",request.getParameter("cad_CaseNo") );
               
                
                
            casedetail.setCad_FileNo(request.getParameter("cad_FileNo"));
            casedetail.setCad_FileName(request.getParameter("cad_FileName"));
             request.setAttribute("cad_FileName",request.getParameter("cad_FileName") );
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

            if (updat_editflag.equals("update")) {
                
                       out.println("from update");    

                System.out.println("Last Update ID - " + request.getParameter("LastDetail_ID"));
                case_deatils_dao.UpdateRojnama(Integer.parseInt(request.getParameter("LastDetail_ID")), request.getParameter("ccd_Rojnama"), request.getParameter("ccd_AAdvocate"));
                case_deatils_dao.addCaseDetail(casedetail);
               // Int cmc_id=case_deatils_dao.getClientDetails(request.getParameter("cad_ID"));
                
                Client client = case_deatils_dao.getClientDetails(Integer.parseInt(request.getParameter("cad_ID")));
              
                          
                  String recipient = "abc@gmail.com";
                
                System.out.println("he is a recipient from if"+recipient);
                String TaskAssignTo = null;
                String content = "<p> Hi" + TaskAssignTo + ",</p> Hope you are doing good. Following is update on your case : </p> <p><b>Case Name: </b> " + request.getParameter("cad_FileName") + "</p> <p><b>Case Number: </b> " + request.getParameter("cad_CaseNo") + "</p> <p><b>Rojnama:</b>" + request.getParameter("ccd_Rojnama") + "</p> <p><b>Next Date:</b> " + request.getParameter("ccd_NextCurrentDate") + "</p><p>Please get in touch with CTS Admin (sushilnimbkar41@gmail.com) if you've any further questions.</p>";
                
                
           
                //Following code block will send email to client about Rojnama
                try {
                    String subject = null;
                        EmailUtility.sendEmail( recipient, subject,content);
                    //resultMessage = "The e-mail was sent successfully";
                } catch (Exception ex) {
                    ex.printStackTrace();
                    //resultMessage = "There were an error: " + ex.getMessage();
                } finally {
                    Object resultMessage = null;
                    request.setAttribute("Message", resultMessage);
                    //getServletContext().getRequestDispatcher("/Result.jsp").forward(request, response);
                }
                   
            } 
            
            else {
                  out.println("from update else");    
                casedetail.setCcd_ID(Integer.parseInt(CaseDetailID));
                case_deatils_dao.updateCaseDetail(casedetail);
             
                Client client = case_deatils_dao.getClientDetails(Integer.parseInt(request.getParameter("cad_ID")));
                
                //String recipient = client.getCmc_EmailID1();
                  String recipient = "abc@gmail.com";
                
                          System.out.println("he is a recipient from else ecdc "+recipient);
                String TaskAssignTo = null;
                          
                String content = "<p> Hi" + TaskAssignTo + ",</p> Hope you are doing good. Following is update on your case : </p> <p><b>Case Name: </b> " + request.getParameter("cad_FileName") + "</p> <p><b>Case Number: </b> " + request.getParameter("cad_CaseNo") + "</p> <p><b>Rojnama:</b>" + request.getParameter("ccd_Rojnama") + "</p> <p><b>Next Date:</b> " + request.getParameter("ccd_NextCurrentDate") + "</p><p>Please get in touch with CTS Admin (sushilnimbkar41@gmail.com) if you've any further questions.</p>";
                
                //Following code block will send email to client about Rojnama
                
                try {
                    String subject = null;
                    

                    EmailUtility.sendEmail( recipient, subject,content);
                    //resultMessage = "The e-mail was sent successfully";
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("email not sent "+ex);
                       
                    //resultMessage = "There were an error: " + ex.getMessage();
                } finally {
                    Object resultMessage = null;
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
                   session.setAttribute("redirect", "dashboard");
                    System.out.println(" after  update else"+doc_flag);
                    RequestDispatcher view = request.getRequestDispatcher("AddCaseDocument.jsp");
                  view.forward(request, response);
              }
                }
                catch (Exception exp){
                    System.out.println(" after  update exception "+exp); 
            RequestDispatcher view = request.getRequestDispatcher(LIST_CASEDETAIL);
            request.setAttribute("casemaster", case_deatils_dao.getCaseMasterById(Integer.parseInt(request.getParameter("cad_ID"))));
            request.setAttribute("casemasters", case_deatils_dao.getAllCaseMasterByMasterID(Integer.parseInt(request.getParameter("cad_ID"))));
            request.setAttribute("advocates", case_deatils_dao.getAllAdvocate());
            request.setAttribute("casestages", case_deatils_dao.getAllCaseStage());
            request.setAttribute("casemasters", case_deatils_dao.getAllCaseMaster());
            request.setAttribute("casedetails", case_deatils_dao.getAllCaseDetailByID(cad_ID));

            request.setAttribute("courts", case_deatils_dao.getAllCourt());
           view.forward(request, response);
              }
                    
               
            
            
                          

           /* RequestDispatcher view = request.getRequestDispatcher(LIST_CASEDETAIL);
            request.setAttribute("casemaster", case_deatils_dao.getCaseMasterById(Integer.parseInt(request.getParameter("cad_ID"))));
            request.setAttribute("casemasters", case_deatils_dao.getAllCaseMasterByMasterID(Integer.parseInt(request.getParameter("cad_ID"))));
            request.setAttribute("advocates", case_deatils_dao.getAllAdvocate());
            request.setAttribute("casestages", case_deatils_dao.getAllCaseStage());
            request.setAttribute("casemasters", case_deatils_dao.getAllCaseMaster());
            request.setAttribute("casedetails", case_deatils_dao.getAllCaseDetailByID(cad_ID));

            request.setAttribute("courts", case_deatils_dao.getAllCourt());
           view.forward(request, response);*/
        }
         
                   
             
                  
        
        
        
        
        
        
        
        
        
        
        
    }
           
}
       catch(Exception ioex)
{
                      System.out.println("im from exception block of controller\n"+ioex);
                      out.println("<script type=\"text/javascript\">");
                      out.println("alert('Session timeout Please Log in again');");
                      out.println("location='LogOutController?action=logout';");
                      out.println("</script>");  
}
}
}