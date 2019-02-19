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
import com.cts.dao.CaseDetailDAO;
import com.cts.model.TaskMaster;
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

public class CaseTaskController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/ctsAddTask.jsp";
    private static String LIST_DAIRY_SEARCH = "/ctsAddTask.jsp";
    private static String LIST_CASEDETAIL = "/ctsAddTask.jsp";
    private CaseTaskDAO dao;
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

    public CaseTaskController() {
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

            request.setAttribute("taskmasters", dao.getAllTasks());
            request.setAttribute("advocates", dao.getAllAdvocate());

        } else if (action.equalsIgnoreCase("delete")) {
            forward = LIST_DAIRY_SEARCH;
            int TaskID = Integer.parseInt(request.getParameter("TaskID"));
            dao.deleteCaseTask(TaskID);
            request.setAttribute("taskmasters", dao.getAllTasks());
            request.setAttribute("advocates", dao.getAllAdvocate());

        }
        else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int ctm_ID = Integer.parseInt(request.getParameter("TaskID"));
            TaskMaster taskmaster = dao.getDetailsByTaskID(ctm_ID);
             request.setAttribute("taskmaster", taskmaster);
             request.setAttribute("taskmasters", dao.getAllTasks());
            request.setAttribute("advocates", dao.getAllAdvocate());
            
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
        TaskMaster taskmaster = new TaskMaster();
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
        String TaskAssignTo = "";
        String recipient = "";
        //String recipient = request.getParameter("recipient");
        String subject = "CTS New Task: " + request.getParameter("ctm_TaskName");
        String content = "";
        String resultMessage = "";

        if (request.getParameter("SaveDetails") != null) {
            //casecategory.setCcg_CategoryName(request.getParameter("CategoryName"));
            //casecategory.setCcg_Description(request.getParameter("Description"));
            //int ccd_ID = Integer.parseInt(request.getParameter("ccd_ID"));

            int CreateUser = Integer.parseInt(request.getParameter("ctm_CreateUser"));
            int ModifyUser = Integer.parseInt(request.getParameter("ctm_ModifyUser"));
            String[] selected_Comments = request.getParameterValues("ccd_AAdvocate");

            if (selected_Comments != null) {
                for (String item : selected_Comments) {
                    String keyValue[] = item.split(":");
                    TaskAssignToID = Integer.parseInt(keyValue[0].trim());
                    TaskAssignTo = keyValue[1].trim();
                    recipient = keyValue[2].trim();
                }
            }
            System.out.println("AdvocateID is " + TaskAssignToID);
            System.out.println("AdvocateName is " + TaskAssignTo);
            //int TaskAssignByID = 1;

            int TaskAssignByID = Integer.parseInt(request.getParameter("ctm_CreateUser"));
            //casedetail.setCcd_ID(ccd_ID);        
            content = "<p> Hi " + TaskAssignTo + ",</p> Following Task is Assigned to you : </p> <p><b>Task Name: </b> " + request.getParameter("ctm_TaskName") + "</p> <p><b>Complete Task by Date: </b> " + request.getParameter("ctm_TaskCompletionDate") + "</p> <p><b>Task Priority:</b>" + request.getParameter("ctm_TaskPriority") + "</p> <p><b>Task Description:</b> " + request.getParameter("ctm_TaskDescription") + "</p>";
                    
            taskmaster.setCtm_CreateUser(CreateUser);
            taskmaster.setCtm_ModifyUser(ModifyUser);
            taskmaster.setCtm_TaskAssignToID(TaskAssignToID);
            taskmaster.setCtm_TaskAssignByID(TaskAssignByID);

            taskmaster.setCtm_TaskName(request.getParameter("ctm_TaskName"));
            taskmaster.setCtm_TaskDescription(request.getParameter("ctm_TaskDescription"));
            taskmaster.setCtm_TaskAssignedTo(TaskAssignTo);
            taskmaster.setCtm_TaskAssignedBy(request.getParameter("ctm_TaskAssignedBy"));
            taskmaster.setCtm_TaskLocation(request.getParameter("ctm_TaskLocation"));
            taskmaster.setCtm_TaskPriority(request.getParameter("ctm_TaskPriority"));

            try {
                Date CreateDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("ctm_CreateDate"));
                taskmaster.setCtm_CreateDate(CreateDate);
                taskmaster.setCtm_TaskAssignDate(CreateDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            try {
                Date TaskCompletionDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("ctm_TaskCompletionDate"));
                taskmaster.setCtm_TaskCompletionDate(TaskCompletionDate);

            } catch (ParseException e) {
                e.printStackTrace();
            }
    
            try {
                Date ModifyDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("ctm_ModifyDate"));
                taskmaster.setCtm_ModifyDate(ModifyDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            boolean ActiveFlag = Boolean.parseBoolean(request.getParameter("ctm_ActiveFlag"));
            boolean DeleteFlag = Boolean.parseBoolean(request.getParameter("ctm_DeleteFlag"));
            taskmaster.setCtm_ActiveFlag(ActiveFlag);
            taskmaster.setCtm_DeleteFlag(DeleteFlag);

            String TaskID = request.getParameter("ctm_ID");
            if (TaskID == null || TaskID.isEmpty() || TaskID.equalsIgnoreCase("0")) {
                dao.addCaseTaskMaster(taskmaster);
            } else {
                
                taskmaster.setCtm_ID(Integer.parseInt(TaskID));
                dao.updateTask(taskmaster);
            }
            
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
            RequestDispatcher view = request.getRequestDispatcher(LIST_DAIRY_SEARCH);
            request.setAttribute("advocates", dao.getAllAdvocate());
            request.setAttribute("taskmasters", dao.getAllTasks());
            //request.setAttribute("courts", dao.getAllCourt());
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
