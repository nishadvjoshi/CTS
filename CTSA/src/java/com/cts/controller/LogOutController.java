/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("logout")) {

            HttpSession session = request.getSession();
            session.invalidate();
          
            request.getRequestDispatcher("ctsLogin.jsp").include(request, response);

            //out.print("You are successfully logged out!");

            //out.close();
        }
    }
}
