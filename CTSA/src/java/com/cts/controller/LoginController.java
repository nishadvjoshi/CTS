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
import com.cts.dao.EmailDAO;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.dao.LoginDAO;
import com.cts.dao.UserDAO;
import com.cts.model.User;
import javax.servlet.ServletContext;

public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final LoginDAO dao;

    private EmailDAO edao;
    private String host;
    private String port;
    private String user1;
    private String pass;
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static java.security.SecureRandom rnd = new java.security.SecureRandom();

  
    public LoginController() {
        super();
        dao = new LoginDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        String recipient;
        String subject;
        String content = "";
        String resultMessage = "";
        String userPWD = randomString(8);
        System.out.println("New Password Generated Is: " + userPWD);

        if (action.equalsIgnoreCase("forgotPassword")) {

            String n = request.getParameter("exampleInputEmail1");
            

            if (dao.validateUser(n)) {
                User userdetail = dao.getUserDetailByName(n);
                request.setAttribute("userdetail", userdetail);
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n = request.getParameter("username");
        String p = request.getParameter("userpass");
       
       System.out.println(" "+n+ "  " +p);

        if (dao.validate(n, p)) {
            User userdetail = dao.getUserDetailByID(n, p);
            HttpSession session = request.getSession(true);
            if(userdetail!=null)
            {
            if (session != null) {
                //session.setAttribute("name", n);
                session.setAttribute("cmu_ID", userdetail.getCmu_ID());
                session.setAttribute("FirstName", userdetail.getCmu_FirstName());
                session.setAttribute("Role", userdetail.getCmu_Role());
                System.out.println(userdetail.getCmu_Role());
                session.setAttribute("UserCity", userdetail.getCmu_City());
                session.setAttribute("ClientID", userdetail.getCmu_ClientID());
                  session.setAttribute("UserPSWD", userdetail.getCmu_Password());
            }
            
            // check roles of the user 
            if (userdetail.getCmu_Role().contains("Client")) {
                RequestDispatcher rd = request.getRequestDispatcher("ctsClientIndex.jsp");
                rd.forward(request, response);
            } else {
                System.out.println("User Logged in - " + userdetail.getCmu_FirstName());
                 System.out.println(userdetail.getCmu_Role());
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
            
            
            } 
            else
            {
                  out.println("<script type=\"text/javascript\">");
   out.println("alert('Something went wrong.');");
   out.println("location='ctsLogin.jsp';");
   out.println("</script>");
                
            }
            

        } else {
            
             out.println("<script type=\"text/javascript\">");
   out.println("alert('User or password incorrect');");
   out.println("location='ctsWrongPassword.jsp';");
   out.println("</script>");
            
          /*  out.print("<p style=\"color:red\">Sorry username or password error</p>");*/
            RequestDispatcher rd = request.getRequestDispatcher("ctsWrongPassword.jsp");
            rd.include(request, response);
        }

        out.close();
    }

    String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }
}

/*
    if(userdetail.getCmu_Role().equalsIgnoreCase("Client") || userdetail.getCmu_Role().equalsIgnoreCase("intern") || userdetail.getCmu_Role().equalsIgnoreCase("viewer")||userdetail.getCmu_Role().equalsIgnoreCase("operatore")||userdetail.getCmu_Role().equalsIgnoreCase("Admin"))
            {
                //redirect as a client
                 if (userdetail.getCmu_Role().equalsIgnoreCase("Client")) {
                RequestDispatcher rd = request.getRequestDispatcher("ctsClientIndex.jsp");
                rd.forward(request, response);
            } 
              //redirect as a intern
                 else if(userdetail.getCmu_Role().equalsIgnoreCase("intern")) {
                RequestDispatcher rd = request.getRequestDispatcher("ctsClientIndex.jsp");
                rd.forward(request, response);
                 }
                 */