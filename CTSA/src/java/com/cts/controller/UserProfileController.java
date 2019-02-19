/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.controller;

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


/**
 *
 * @author nishad
 */
public class UserProfileController extends HttpServlet {

  private UserDAO dao;
    private EmailDAO edao;
    private String host;
    private String port;
    private String user1;
    private String pass;
        private static String INSERT_OR_EDIT = "/ctsAddUserById.jsp";
    private static String LIST_USER = "/ctsUserById.jsp";
    private static String HOME_PAGE = "/index.jsp";
    
        public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user1 = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }

    public UserProfileController() {
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
           int userID = Integer.parseInt(session.getAttribute("cmu_ID").toString());
System.out.println("user id is "+userID);

  if(action.equals("listUserDetail"))
  {
           
          forward = LIST_USER;
                  request.setAttribute("user", dao.getUserById(userID));
            
           System.out.println("im from if  "+userID);
            RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
  }
         else
  {
      System.out.println("im from else inside get of userprofilecontrolller");
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

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
          //HttpSession session = request.getSession(true);
         //response.setContentType("text/html");
         //PrintWriter out = response.getWriter();
           int userID;
      userID = (int) session.getAttribute("cmu_ID");
           
System.out.println("im from post, of userprofilecontrolller");
        if(request.getParameter("action").equals("update"))
        {
            int id;
             id = Integer.parseInt(request.getParameter("cmu_id"));
             int cmuid;
             cmuid=(int) session.getAttribute("cmu_ID");
             if(id==cmuid)
             {
                   recipient = request.getParameter("cmu_UserName");
                   
                     user.setCmu_FirstName(request.getParameter("cmu_FirstName"));
            user.setCmu_LastName(request.getParameter("cmu_LastName"));
             user.setCmu_Password(request.getParameter("NewPass1"));
             user.setCmu_ID(id);
             user.setCmu_UserName(request.getParameter("cmu_UserName"));
             
             
            
               int i=dao.updateUserById(user);
               if(i>0)
               {
                   
                     out.println("<script type=\"text/javascript\">");
                      out.println("alert('User Updated Successfully');");
                     
                        
            request.setAttribute("user", dao.getUserById(userID));
              out.println("location='UserProfileController?action=listUserDetail';");
                    out.println("</script>");
               }
               else
               {
                  out.println("<script type=\"text/javascript\">");
                  out.println("alert('try again');");
                   request.setAttribute("user", dao.getUserById(userID));
                  out.println("location='UserProfileController?action=listUserDetail';");
                  out.println("</script>"); 
               }
        
   
    }
             else
               {
                  out.println("<script type=\"text/javascript\">");
                    out.println("alert('Invalid User');");
                     out.println("location='LogOutController';");
                    out.println("</script>"); 
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
