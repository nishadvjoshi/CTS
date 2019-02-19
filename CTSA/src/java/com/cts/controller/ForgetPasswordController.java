/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.controller;

import com.cts.dao.EmailDAO;
import java.io.IOException;
import java.io.PrintWriter;
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

import com.cts.dao.LoginDAO;
import com.cts.dao.UserDAO;
import com.cts.model.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;


/**
 *
 * @author Administrator
 */
public class ForgetPasswordController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private final LoginDAO dao;

    private EmailDAO edao;
    private String host;
    private String port;
    private String user1;
    private String pass;

  
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user1 = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
    
    
     public ForgetPasswordController() {
        super();
        dao = new LoginDAO();
    }
   
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n = request.getParameter("username");
         out.println("username "+n);
         if (dao.validateUser(n)) {
            User userdetail = dao.getUserDetailByUserName(n);
             HttpSession session = request.getSession(false);
             if(userdetail!=null)
            {
            if (session != null) {
                //session.setAttribute("name", n);
              //  session.setAttribute("cmu_ID", userdetail.getCmu_ID());
               // session.setAttribute("FirstName", userdetail.getCmu_FirstName());
               // session.setAttribute("Role", userdetail.getCmu_Role());
                System.out.println(userdetail.getCmu_FirstName());
               // session.setAttribute("UserCity", userdetail.getCmu_City());
               // session.setAttribute("ClientID", userdetail.getCmu_ClientID());
                //  session.setAttribute("UserPSWD", userdetail.getCmu_Password());
                  System.out.println(userdetail.getCmu_ID());
                  System.out.println(userdetail.getCmu_Password());
                  System.out.println(userdetail.getCmu_Role());
                    String username=userdetail.getCmu_UserName();
                  String userpass=userdetail.getCmu_Password();
                  //userdetail.getcmu_UserName()
                  out.println(host+"  "+port+"  "+pass+"  "+user1);
                  String subject="From CTS";
                  String message="Hello user Your Email id:"+username+ " \n and pawwsord is :"+userpass;
                  
                  
                  
                try {
                    EmailUtility.sendEmail(username,subject,message);
                } catch (MessagingException ex) {
                    System.out.println(ex);
                    Logger.getLogger(ForgetPasswordController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }
             else
             {
              out.println("<script type=\"text/javascript\">");
   out.println("alert('Data Not Found.');");
   out.println("location='ctsForgtPassword.jsp';");
   out.println("</script>");
            }
        
         }
         else
         {
              out.println("<script type=\"text/javascript\">");
   out.println("alert('Not a valid user.');");
   out.println("location='ctsForgtPassword.jsp';");
   out.println("</script>");
         }
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
