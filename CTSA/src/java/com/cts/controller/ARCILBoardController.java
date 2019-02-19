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
import com.cts.dao.ARCILBoardDAO;
import com.cts.model.Client;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

public class ARCILBoardController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    //private static String INSERT_OR_EDIT = "/ctsCaseDetailRegistration.jsp";
      private static String LOGIN_PAGE = "/ctsLogin.jsp";
    private static String LIST_CASEDETAIL = "/ctsARCILDashboard.jsp";
    private static String LIST_ARCBOARD = "/ctsARCILBoard.jsp";
    private static String LIST_MONTHLY = "/ctsMonthlyBoard.jsp";
    private CaseMasterDAO dao;
    private ClientDAO clientDAO;
    private ARCILBoardDAO arcboardDAO;

    public ARCILBoardController() {
        super();
        dao = new CaseMasterDAO();
        clientDAO = new ClientDAO();
        arcboardDAO = new ARCILBoardDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        
        String action = request.getParameter("action");
   response.setContentType("text/html");
        PrintWriter out = response.getWriter();
HttpSession session = request.getSession(false);
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
        if (action.equalsIgnoreCase("listMonthlyBoard1")) {
            forward = LIST_CASEDETAIL;

            /*String CaseLocation = request.getParameter("Location");
             System.out.println(CaseLocation); 
             request.setAttribute("casemasters",dao.getARCILBoardByLocation(CaseLocation));*/
            //request.setAttribute("caselocations", dao.getARCILLocation()); 
            //request.setAttribute("casemasters", dao.getAllCaseMaster());
            //request.setAttribute("casemasters", dao.getARCILBoard());
            //request.setAttribute("casemasters", dao.getAllCaseMaster());
            request.setAttribute("cities", dao.getAllCity());
        } else if (action.equalsIgnoreCase("listMonthlyBoard")) {
            forward = LIST_MONTHLY;
            request.setAttribute("casemonthly", arcboardDAO.getMonthlyBoard(request.getParameter("ccc_ClientName")));
            //request.setAttribute("casemonthlycount", arcboardDAO.getMonthlyBoardCount());
        } else {
            forward = LIST_ARCBOARD;
            request.setAttribute("casemonthlycount", arcboardDAO.getMonthlyBoardCount());
            //request.setAttribute("caseundatedcount", dao.getUnDatedBoardCount());
            //request.setAttribute("casemastercount", dao.getCaseMasterCount());
            //request.setAttribute("weeklytaskcount", taskDAO.WeeklyTaskCountByID(Integer.parseInt(session.getAttribute("ClientID").toString())));
            //request.setAttribute("casedetails", dao.getDailyBoard());
            //request.setAttribute("caseweekly", dao.getWeeklyBoard());

        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = "";
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
        
        
        
        
        if (request.getParameter("GetDetails") != null) {
            forward = LIST_CASEDETAIL;
            String str = request.getParameter("ccc_CityName");
            System.out.println(str);
            String selected_Comments[] = request.getParameterValues("ccc_CityName");
            for (String comment : selected_Comments) {
                System.out.println(comment);

                request.setAttribute("casemasters", dao.getARCILBoardByLocation(comment));
                request.setAttribute("cities", dao.getAllCity());
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);

            }

        } else if (request.getParameter("GetARCBoard") != null) {
            forward = LIST_ARCBOARD;
            String clientName = request.getParameter("ccc_ClientName");
            String tDay = request.getParameter("tDay");
            //String clientName = request.getParameter("ccc_ClientName");
            request.setAttribute("casemonthlycount", arcboardDAO.getMonthlyBoardCountByARC(clientName));
            request.setAttribute("casedetails", arcboardDAO.getDailyBoard(clientName));
            request.setAttribute("caseweekly", arcboardDAO.getWeeklyBoard(clientName));
            request.setAttribute("casedetails", arcboardDAO.getDailyBoardByDay(tDay,clientName));
            RequestDispatcher view = request.getRequestDispatcher(LIST_ARCBOARD);
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
