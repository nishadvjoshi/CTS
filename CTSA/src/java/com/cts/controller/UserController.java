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
import com.cts.dao.UserDAO;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Random;
import java.security.SecureRandom;
import com.cts.dao.UserDAO;
import com.cts.model.User;
import com.cts.dao.EmailDAO;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public class UserController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/ctsAddUser.jsp";
    private static String LIST_USER = "/ctsUser.jsp";
    private static String HOME_PAGE = "/index.jsp";
    private UserDAO dao;
    private EmailDAO edao;
    private String host;
    private String port;
    private String user1;
    private String pass;
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user1 = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }

    public UserController() {
        super();
        dao = new UserDAO();
        edao = new EmailDAO();
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
        if (action.equalsIgnoreCase("listUser")) {
           // HttpSession session = request.getSession(false);
            if (session.getAttribute("Role").toString().contains("Administrator")) {

                forward = LIST_USER;
                request.setAttribute("users", dao.getAllUserDesc());
                request.setAttribute("advocates", dao.getAllAdvocate());
                request.setAttribute("clients", dao.getAllClient());
            } else {

                forward = HOME_PAGE;
            }

        } else if (action.equalsIgnoreCase("delete")) {
            int userID = Integer.parseInt(request.getParameter("userID"));
            dao.deleteUser(userID);
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUserDesc());
            request.setAttribute("advocates", dao.getAllAdvocate());
            request.setAttribute("clients", dao.getAllClient());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int userID = Integer.parseInt(request.getParameter("userID"));
            User user = dao.getUserById(userID);
            request.setAttribute("user", user);
            request.setAttribute("advocates", dao.getAllAdvocate());
            request.setAttribute("clients", dao.getAllClient());
        } else {
            forward = INSERT_OR_EDIT;
            request.setAttribute("advocates", dao.getAllAdvocate());
            request.setAttribute("clients", dao.getAllClient());
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
          
        
        User user = new User();
        String recipient;
        String subject;
        String content = "";
        String resultMessage = "";
        String FinalPWD="";
        String userPWD = randomString(8);
       // System.out.println("New Password Generated Is: " + userPWD);
  
  
        if (request.getParameter("AddUser") != null) {
            
            
            request.setAttribute("advocates", dao.getAllAdvocate());
            request.setAttribute("clients", dao.getAllClient());
            request.getRequestDispatcher("/ctsAddUser.jsp").forward(request, response);
        } else if (request.getParameter("SaveDetails") != null) {

            recipient = request.getParameter("cmu_UserName");
            subject = "CTS New User: " + request.getParameter("cmu_UserName");

            user.setCmu_FirstName(request.getParameter("cmu_FirstName"));
            user.setCmu_Role(request.getParameter("cmu_Role"));
            user.setCmu_LastName(request.getParameter("cmu_LastName"));
            
            
                  String oldPWD =request.getParameter("cmu_Password");
        if(oldPWD.length()<=0)
        {
            FinalPWD=userPWD;
        }
        else
        {
            FinalPWD=oldPWD;
        }
        
           user.setCmu_Password(FinalPWD);      //genrate random for  new user and keep as its when update
           //user.setCmu_Password(FinalPWD);  // random password 
           // user.setCmu_Password(request.getParameter("cmu_Password"));   //keep as its when registered user updated
            user.setCmu_UserName(request.getParameter("cmu_UserName"));

            boolean DeleteFlag = Boolean.parseBoolean(request.getParameter("cmu_DeleteFlag"));
            boolean ActiveFlag = Boolean.parseBoolean(request.getParameter("cmu_ActiveFlag"));
            user.setCmu_ActiveFlag(ActiveFlag);
            user.setCmu_DeleteFlag(DeleteFlag);

            int ClientID;
            if (request.getParameter("ctm_UserType").equalsIgnoreCase("Associate")) {
                ClientID = Integer.parseInt(request.getParameter("cmu_AAdvocate"));
                content = "<p> Hi " + request.getParameter("cmu_FirstName") + ",</p> <b>Welcome to CTS</b>. Following are your credentials to access the system. Please do not share these with anyone. </p> "
                        + "<p><b>Username: </b> " + request.getParameter("cmu_UserName") + "</p> <p><b>Password: </b>" + userPWD + ""
                        + "</p> <p>Use following URL to access the system outside office environment - http://59.99.244.139:8080/CTS "
                        + "<p>use url http://192.168.1.12:8080/CTS in office environment.</p>"
                        + "<p>Please send email to sushilnimbkar41@gmail.com in case of any difficulties.</p>";

            } else {
                ClientID = Integer.parseInt(request.getParameter("cmu_Client"));
                content = "<p> Hi " + request.getParameter("cmu_FirstName") + ",</p> <b>Welcome to CTS</b>. Following are your credentials to access the system. Please do not share these with anyone. </p> "
                        + "<p><b>Username: </b> " + request.getParameter("cmu_UserName") + "</p> <p><b>Password: </b>" + userPWD + ""
                        + "</p> <p>Use following URL to access the system - http://59.99.244.139:8080/CTSCLIENT"
                        + "<p>Please send email to sushilnimbkar41@gmail.com in case of any difficulties.</p>";

            }
            int CreateUser = Integer.parseInt(request.getParameter("cmu_CreateUser"));
            int ModifyUser = Integer.parseInt(request.getParameter("cmu_ModifyUser"));
            user.setCmu_CreateUser(CreateUser);
            user.setCmu_ModifyUser(ModifyUser);
            user.setCmu_ClientID(ClientID);

            try {
                Date CreateDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("cmu_CreateDate"));
                user.setCmu_CreateDate(CreateDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            try {
                Date ModifyDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("cmu_ModifyDate"));
                user.setCmu_ModifyDate(ModifyDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String userID = request.getParameter("userID");
            if (userID == null || userID.isEmpty()) {
                int i=dao.addUser(user);
                
                
                //sendFromGMail(from, pass, to, subject, Adminbody);
                //sendFromGMail(from, pass, to, subject, Userbody);
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
                
                
                if(i>0)
               {
                   //System.out.println("calling from  add user inner if");
                    request.setAttribute("users", dao.getAllUserDesc());
                     out.println("<script type=\"text/javascript\">");
                      out.println("alert('User Added Successfully');");
                     
                        
            
              out.println("location='UserController?action=listUser';");
                    out.println("</script>");
               }
               else
               {    
                   //System.out.println("calling from  add advocate inner else ");
                   request.setAttribute("users", dao.getAllUserDesc());
                  out.println("<script type=\"text/javascript\">");
                  out.println("alert('try again');");
                   request.setAttribute("users", dao.getAllUserDesc());
                  out.println("location='UserController?action=listUser';");
                  out.println("</script>"); 
               }
        
                
                

            } else {
                user.setCmu_ID(Integer.parseInt(userID));
                int i=dao.updateUser(user);
                
                    if(i>0)
               {
                   //System.out.println("calling from  add user inner if");
                    request.setAttribute("users", dao.getAllUserDesc());
                     out.println("<script type=\"text/javascript\">");
                      out.println("alert('User Updated Successfully');");
                     
                        
            
              out.println("location='UserController?action=listUser';");
                    out.println("</script>");
               }
               else
               {    
                   //System.out.println("calling from  add advocate inner else ");
                   request.setAttribute("users", dao.getAllUserDesc());
                  out.println("<script type=\"text/javascript\">");
                  out.println("alert('try again');");
                   request.setAttribute("users", dao.getAllUserDesc());
                  out.println("location='UserController?action=listUser';");
                  out.println("</script>"); 
               }
            }
           // RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
            request.setAttribute("users", dao.getAllUserDesc());
            //view.forward(request, response);
            
            
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
    String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }
}
