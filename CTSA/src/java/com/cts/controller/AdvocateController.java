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
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.dao.AdvocateDAO;
import com.cts.model.Advocate;
import com.cts.model.City;
import com.cts.model.State;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

public class AdvocateController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/ctsAddAdvocate.jsp";
    private static String LIST_ADVOCATE = "/ctsAdvocates.jsp";
    private static String HOME_PAGE = "/index.jsp";
    private AdvocateDAO dao;

    public AdvocateController() {
        super();
        dao = new AdvocateDAO();
        
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
        if (action.equalsIgnoreCase("listAdvocate")) {
             //HttpSession session = request.getSession(false);
             if (session.getAttribute("Role").toString().contains("Administrator")) {

                     forward = LIST_ADVOCATE;
                       System.out.println("calling from  listadvocate");
                     request.setAttribute("advocates", dao.getAllAdvocateDesc());
                } else {

                    forward = HOME_PAGE;
                }
            
           
        } else if (action.equalsIgnoreCase("delete")) {
         
            int AdvocateID = Integer.parseInt(request.getParameter("AdvocateID"));
            dao.deleteAdvocate(AdvocateID);
            
           
            
           forward = LIST_ADVOCATE;
           System.out.println("calling from  delete");
            request.setAttribute("advocates", dao.getAllAdvocateDesc());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int AdvocateID = Integer.parseInt(request.getParameter("AdvocateID"));
            Advocate advocate = dao.getAdvocateById(AdvocateID);
            request.setAttribute("advocate", advocate);
        } else {
            forward = INSERT_OR_EDIT;
        }
        System.out.println("calling from get default");
          request.setAttribute("advocates", dao.getAllAdvocateDesc());
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
          
        Advocate advocate = new Advocate();
        //casecategory.setCcg_CategoryName(request.getParameter("CategoryName"));
        //casecategory.setCcg_Description(request.getParameter("Description"));
        
        int ZipCode = Integer.parseInt(request.getParameter("cam_ZipCode"));
        int PZipCode = Integer.parseInt(request.getParameter("cam_PZipCode"));
        int CreateUser = Integer.parseInt(request.getParameter("cam_CreateUser"));
        int ModifyUser = Integer.parseInt(request.getParameter("cam_ModifyUser"));
        advocate.setCam_ZipCode(ZipCode);
        advocate.setCam_PZipCode(PZipCode);
        advocate.setCam_CreateUser(CreateUser);
        advocate.setCam_ModifyUser(ModifyUser);

        advocate.setCam_FirstName(request.getParameter("cam_FirstName"));
        
        advocate.setCam_AdvocateType(request.getParameter("cam_AdvocateType"));
        advocate.setCam_AdvocateCode(request.getParameter("cam_AdvocateCode"));
        advocate.setCam_LicenseNo(request.getParameter("cam_LicenseNo"));
        advocate.setCam_EmailID1(request.getParameter("cam_EmailID1"));
        advocate.setCam_EmailID2(request.getParameter("cam_EmailID2"));
        advocate.setCam_CellNo1(request.getParameter("cam_CellNo1"));
        advocate.setCam_CellNo2(request.getParameter("cam_CellNo2"));
        advocate.setCam_LandlineNo(request.getParameter("cam_LandlineNo"));
        advocate.setCam_Addr1(request.getParameter("cam_Addr1"));
        advocate.setCam_Addr2(request.getParameter("cam_Addr2"));
        advocate.setCam_NearLocation(request.getParameter("cam_NearLocation"));
        advocate.setCam_District(request.getParameter("cam_District"));
        advocate.setCam_City(request.getParameter("cam_City"));
        advocate.setCam_State(request.getParameter("cam_State"));
        advocate.setCam_Country(request.getParameter("cam_Country"));

        advocate.setCam_PAddr1(request.getParameter("cam_PAddr1"));
        advocate.setCam_PAddr2(request.getParameter("cam_PAddr2"));
        advocate.setCam_PNearLocation(request.getParameter("cam_PNearLocation"));
        advocate.setCam_PDistrict(request.getParameter("cam_PDistrict"));
        advocate.setCam_PCity(request.getParameter("cam_PCity"));
        advocate.setCam_PState(request.getParameter("cam_State"));
        advocate.setCam_PCountry(request.getParameter("cam_Country"));

        advocate.setCam_PassportNo(request.getParameter("cam_PassportNo"));

        try {
            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("cam_DOB"));
            advocate.setCam_DOB(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Date CreateDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("cam_CreateDate"));
            advocate.setCam_CreateDate(CreateDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            Date ModifyDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("cam_ModifyDate"));
            advocate.setCam_ModifyDate(ModifyDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        boolean ActiveFlag = Boolean.parseBoolean(request.getParameter("cam_ActiveFlag"));
        boolean DeleteFlag = Boolean.parseBoolean(request.getParameter("cam_DeleteFlag"));
        advocate.setCam_ActiveFlag(ActiveFlag);
        advocate.setCam_DeleteFlag(DeleteFlag);

        String AdvocateID = request.getParameter("AdvocateID");
        if (AdvocateID == null || AdvocateID.isEmpty()) {
           int i= dao.addAdvocate(advocate);
           //  System.out.println("calling from  add advocate");
           request.setAttribute("advocates", dao.getAllAdvocateDesc());
            if(i>0)
               {
                   System.out.println("calling from  add advocate inner if");
                    request.setAttribute("advocates", dao.getAllAdvocateDesc());
                     out.println("<script type=\"text/javascript\">");
                      out.println("alert('Advocate Added Successfully');");
                     
                        
            
              out.println("location='AdvocateController?action=listAdvocate';");
                    out.println("</script>");
               }
               else
               {    
                   System.out.println("calling from  add advocate inner else ");
                   request.setAttribute("advocates", dao.getAllAdvocateDesc());
                  out.println("<script type=\"text/javascript\">");
                  out.println("alert('try again');");
                   request.setAttribute("advocates", dao.getAllAdvocateDesc());
                  out.println("location='AdvocateController?action=listAdvocate';");
                  out.println("</script>"); 
               }
        
            
        } else {
            advocate.setCam_ID(Integer.parseInt(AdvocateID));
            int i=dao.updateAdvocate(advocate);
            
            
               if(i>0)
               {
                    request.setAttribute("advocates", dao.getAllAdvocateDesc());
                     out.println("<script type=\"text/javascript\">");
                      out.println("alert('Advocate updated Successfully');");
                     
                        
            request.setAttribute("advocates", dao.getAllAdvocateDesc());
              out.println("location='AdvocateController?action=listAdvocate';");
                    out.println("</script>");
               }
               else
               {
                  out.println("<script type=\"text/javascript\">");
                  out.println("alert('try again');");
                   request.setAttribute("advocates", dao.getAllAdvocateDesc());
                  out.println("location='AdvocateController?action=listAdvocate';");
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
        /*RequestDispatcher view = request.getRequestDispatcher(LIST_ADVOCATE);
        request.setAttribute("advocates", dao.getAllAdvocateDesc());
        view.forward(request, response);*/
        
    }

}
