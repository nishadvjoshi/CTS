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

import com.cts.dao.UserDAO;
import com.cts.model.User;
import com.cts.dao.EmailDAO;
import javax.servlet.http.HttpSession;

public class ChangePasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/ctsChangePassword.jsp";
    private static String LIST_USER = "/ctsChangePassword.jsp";
    private UserDAO dao;
    private EmailDAO edao;
    
    public ChangePasswordController() {
        super();
        dao = new UserDAO();        
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward= INSERT_OR_EDIT;
        String action = request.getParameter("action");
        
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        
    }
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
       
        HttpSession session = request.getSession(false);
        System.out.println(session.getAttribute("cmu_ID"));
        Integer UserID = (Integer) session.getAttribute("cmu_ID");
        
        
        
        boolean DeleteFlag = Boolean.parseBoolean(request.getParameter("cmu_DeleteFlag"));
        boolean ActiveFlag = Boolean.parseBoolean(request.getParameter("cmu_ActiveFlag"));
        user.setCmu_ActiveFlag(ActiveFlag);
        user.setCmu_DeleteFlag(DeleteFlag);
        
        int CreateUser = Integer.parseInt(request.getParameter("cmu_CreateUser"));
        int ModifyUser = Integer.parseInt(request.getParameter("cmu_ModifyUser"));
        user.setCmu_CreateUser(CreateUser);
        user.setCmu_ModifyUser(ModifyUser);
        user.setCmu_Password(request.getParameter("cmu_NewPassword"));
       
        
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
        
        
        
            user.setCmu_ID(UserID);
            dao.updateUserPassword(user);
        
        RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
        request.setAttribute("users", dao.getAllUser());
        view.forward(request, response);
    }
}
