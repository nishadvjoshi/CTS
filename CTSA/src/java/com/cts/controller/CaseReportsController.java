/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.controller;

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
import com.cts.model.Client;
import com.cts.model.TaskMaster;
import com.cts.dao.CaseTaskDAO;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

public class CaseReportsController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
     //private static String INSERT_OR_EDIT = "/ctsCaseDetailRegistration.jsp";
     private static String LIST_CASEDETAIL = "/DailyBoard.jsp";
     private static String LIST_MONTHLY = "/ctsCaseReports.jsp";
     private static String LIST_UNDATED = "/ctsUnDatedBoard.jsp";
     private CaseDairyDAO dao; 
     private ClientDAO clientDAO;
     private CaseTaskDAO taskDAO;
     
      public CaseReportsController() {
        super();
        dao = new CaseDairyDAO();
        clientDAO = new ClientDAO();
        taskDAO = new CaseTaskDAO();
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

            if (action.equalsIgnoreCase("listMonthlyBoard")) {
                forward = LIST_MONTHLY;
                request.setAttribute("casemonthly", dao.getMonthlyBoard());
            }
            else if (action.equalsIgnoreCase("listUnDatedBoard")) {
                forward = LIST_UNDATED;
                request.setAttribute("caseundated", dao.getUnDatedBoard());
            }
            else
            {
            forward = LIST_CASEDETAIL;
            request.setAttribute("casemonthlycount", dao.getMonthlyBoardCount());
            request.setAttribute("caseundatedcount", dao.getUnDatedBoardCount());
            //request.setAttribute("weeklytaskcount", taskDAO.WeeklyTaskCountByID(Integer.parseInt(session.getAttribute("ClientID").toString())));
            request.setAttribute("casedetails", dao.getDailyBoard());
            request.setAttribute("caseweekly", dao.getWeeklyBoard());
            
            
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
          

        if (request.getParameter("GetMonthlyBoard") != null) {

            Integer yr = Integer.parseInt(request.getParameter("ctm_SelectYear"));
            System.out.println(yr);
            String selected_Comments[] = request.getParameterValues("ctm_SelectMonth");
            for (String comment : selected_Comments) {
                System.out.println(comment);
                request.setAttribute("casemonthly", dao.getMonthlyBoardByMonth(Integer.parseInt(comment), yr));
                
                request.getRequestDispatcher("/ctsCaseReports.jsp").forward(request, response);

            }

        
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
