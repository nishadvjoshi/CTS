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
import com.cts.dao.CaseDetailDAO;
import com.cts.model.TaskMaster;
import com.cts.model.Advocate;
import com.cts.dao.CaseTaskDAO;
import java.util.Properties;
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

public class TaskUpdateController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/ctsUpdateTask.jsp";
    private static String LIST_DAIRY_SEARCH = "/ctsUpdateTask.jsp";
    private static String LIST_CASEDETAIL = "/ctsUpdateTask.jsp";
    private CaseTaskDAO dao;

    public TaskUpdateController() {
        super();
        dao = new CaseTaskDAO();

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

        if (action.equalsIgnoreCase("listTaskDetails")) {
            forward = LIST_DAIRY_SEARCH;

            // request.setAttribute("mytasklist", dao.getUserWeeklyTasks(Integer.parseInt(session.getAttribute("ClientID").toString())));
            request.setAttribute("advocates", dao.getAllAdvocate());

            request.setAttribute("taskmasters", dao.getAllTasks());
            //request.setAttribute("mycompletetasklist", dao.getUserAllTasks(Integer.parseInt(session.getAttribute("ClientID").toString())));

        } else if (action.equalsIgnoreCase("UpdateTask")) {
            forward = LIST_DAIRY_SEARCH;
            request.setAttribute("advocates", dao.getAllAdvocate());
            //request.setAttribute("taskmasters", dao.getAllTasks());
            //request.setAttribute("mytasklist", dao.getUserWeeklyTasks(Integer.parseInt(session.getAttribute("ClientID").toString())));
            //request.setAttribute("mycompletetasklist", dao.getUserAllTasks(Integer.parseInt(session.getAttribute("ClientID").toString())));

        } else if (action.equalsIgnoreCase("delete")) {
            forward = LIST_DAIRY_SEARCH;
            int TaskID = Integer.parseInt(request.getParameter("TaskID"));
            dao.deleteCaseTask(TaskID);
            request.setAttribute("taskmasters", dao.getAllTasks());
            request.setAttribute("advocates", dao.getAllAdvocate());

        } else if (action.equalsIgnoreCase("edit")) {
            System.out.println(request.getParameter("ctm_TaskAssignToID"));
            forward = LIST_DAIRY_SEARCH;

            int TaskID = Integer.parseInt(request.getParameter("TaskID"));

            request.setAttribute("mycompletetasklist", dao.getUserAllTasks(Integer.parseInt(session.getAttribute("TaskAssignToID").toString())));
            request.setAttribute("advocates", dao.getAllAdvocate());
            request.setAttribute("taskupdates", dao.getAllTaskUpdates(TaskID));
            request.setAttribute("mytask", dao.getDetailsByTaskID(TaskID));

        } else {
            request.setAttribute("advocates", dao.getAllAdvocate());
            request.setAttribute("taskmasters", dao.getAllTasks());
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
          
        
        
        
        TaskMaster taskmaster = new TaskMaster();
        int TaskAssignToID = 0;
        String TaskAssignTo = "";
        //HttpSession session = request.getSession(false);

        if (request.getParameter("WTasks") != null) {

            String[] selected_Comments = request.getParameterValues("ccd_AAdvocate");

            if (selected_Comments != null) {
                for (String item : selected_Comments) {
                    String keyValue[] = item.split(":");
                    TaskAssignToID = Integer.parseInt(keyValue[0].trim());
                    TaskAssignTo = keyValue[1].trim();
                    //recipient = keyValue[2].trim();
                    session.setAttribute("TaskAssignToID", TaskAssignToID);
                }
            }
            System.out.println("AdvocateID is " + TaskAssignToID);
            System.out.println("AdvocateName is " + TaskAssignTo);
            request.setAttribute("mytasklist", dao.getUserWeeklyTasks(TaskAssignToID));
           //request.setAttribute("advocate", dao.getAdvocateById(TaskAssignToID));

        } else if (request.getParameter("MTasks") != null) {

            String[] selected_Comments = request.getParameterValues("ccd_AAdvocate");

            if (selected_Comments != null) {
                for (String item : selected_Comments) {
                    String keyValue[] = item.split(":");
                    TaskAssignToID = Integer.parseInt(keyValue[0].trim());
                    TaskAssignTo = keyValue[1].trim();
                    //recipient = keyValue[2].trim();
                    session.setAttribute("TaskAssignToID", TaskAssignToID);
                }
            }
            System.out.println("AdvocateID is " + TaskAssignToID);
            System.out.println("AdvocateName is " + TaskAssignTo);
            request.setAttribute("mycompletetasklist", dao.getUserAllTasks(TaskAssignToID));
            request.setAttribute("advocate", dao.getAdvocateById(TaskAssignToID));
        } 
        
        else if (request.getParameter("SaveDetails") != null) {
            
            int ctm_ID = Integer.parseInt(request.getParameter("ctm_ID"));
            //int RegNo = Integer.parseInt(request.getParameter("cad_RegNo"));
            int CreateUser = Integer.parseInt(request.getParameter("ctu_CreateUser"));
            int ModifyUser = Integer.parseInt(request.getParameter("ctu_CreateUser"));
            //casedetail.setCcd_ID(ccd_ID);        
            taskmaster.setCtm_ID(ctm_ID);
            taskmaster.setCtu_CreateUser(CreateUser);
            taskmaster.setCtu_ModifyUser(ModifyUser);
            
            boolean ActiveFlag = Boolean.parseBoolean(request.getParameter("ctu_ActiveFlag"));
            boolean DeleteFlag = Boolean.parseBoolean(request.getParameter("ctu_DeleteFlag"));
            taskmaster.setCtu_ActiveFlag(ActiveFlag);
            taskmaster.setCtu_DeleteFlag(DeleteFlag);
            
            try {
                Date CreateDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("ctu_CreateDate"));
                taskmaster.setCtu_CreateDate(CreateDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            try {
                Date ModifyDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("ctu_ModifyDate"));
                taskmaster.setCtu_ModifyDate(ModifyDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                Date CreateDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("ctu_CreateDate"));
                taskmaster.setCtu_TaskUpdateDate(CreateDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            taskmaster.setCtu_TaskStatus(request.getParameter("ctu_TaskStatus"));
            taskmaster.setCtu_TaskUpdate(request.getParameter("ctu_TaskUpdate"));
            
            dao.addCaseTaskUpdate(taskmaster);


        }

        RequestDispatcher view = request.getRequestDispatcher(LIST_DAIRY_SEARCH);
        //request.setAttribute("mycompletetasklist", dao.getUserAllTasks(TaskAssignToID));

        request.setAttribute("advocates", dao.getAllAdvocate());
        request.setAttribute("taskmasters", dao.getAllTasks());
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
