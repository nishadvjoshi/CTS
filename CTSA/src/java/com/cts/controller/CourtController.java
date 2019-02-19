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

import com.cts.dao.CourtDAO;
import com.cts.model.Court;
import com.cts.model.City;
import com.cts.dao.CityDAO;
import com.cts.model.State;
import com.cts.dao.StateDAO;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

public class CourtController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/ctsAddCourt.jsp";
    private static String LIST_COURT = "/ctsCourt.jsp";
    private CourtDAO dao;
    private CityDAO dao1;
    private StateDAO dao2;

    public CourtController() {
        super();
        dao = new CourtDAO();
        dao1 = new CityDAO();
        dao2 = new StateDAO();
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
        if (action.equalsIgnoreCase("listCourt")) {
            forward = LIST_COURT;
            request.setAttribute("courts", dao.getAllCourtDesc());
            request.setAttribute("citys", dao1.getAllCity());
            request.setAttribute("states", dao2.getAllState());
            
        } else if (action.equalsIgnoreCase("delete")) {
            int courtID = Integer.parseInt(request.getParameter("courtID"));
            dao.deleteCourt(courtID);
            forward = LIST_COURT;
            request.setAttribute("courts", dao.getAllCourtDesc());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int courtID = Integer.parseInt(request.getParameter("courtID"));
            Court court = dao.getCourtById(courtID);
            request.setAttribute("court", court);
        } else {
            forward = INSERT_OR_EDIT;
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
          
        
        
        
        Court court = new Court();
        
        
        court.setCcm_CourtName(request.getParameter("ccm_CourtName"));
        court.setCcm_Description(request.getParameter("ccm_Description"));
        court.setCcm_CourtType(request.getParameter("ccm_CourtType"));
        court.setCcm_CourtCity(request.getParameter("ccm_CourtCity"));
        court.setCcm_CourtState(request.getParameter("ccm_CourtState"));
        
        boolean DeleteFlag = Boolean.parseBoolean(request.getParameter("ccm_DeleteFlag"));
        boolean ActiveFlag = Boolean.parseBoolean(request.getParameter("ccm_ActiveFlag"));
        court.setCcm_DeleteFlag(DeleteFlag);
        court.setCcm_ActiveFlag(ActiveFlag);

        int CreateUser = Integer.parseInt(request.getParameter("ccm_CreateUser"));
        int ModifyUser = Integer.parseInt(request.getParameter("ccm_ModifyUser"));
        court.setCcm_CreateUser(CreateUser);
        court.setCcm_ModifyUser(ModifyUser);

        try {
            Date CreateDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("ccm_CreateDate"));
            court.setCcm_CreateDate(CreateDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            Date ModifyDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("ccm_ModifyDate"));
            court.setCcm_ModifyDate(ModifyDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String courtID = request.getParameter("courtID");
        if (courtID == null || courtID.isEmpty()) {
           int i= dao.addCourt(court);
           
            if(i>0)
               {
                   System.out.println("calling from  add advocate inner if");
                    request.setAttribute("advocates", dao.getAllCourtDesc());
                     out.println("<script type=\"text/javascript\">");
                      out.println("alert('Court Added Successfully');");
                     
                        
            
              out.println("location='CourtController?action=listCourt';");
                    out.println("</script>");
               }
               else
               {    
                   System.out.println("calling from  add advocate inner else ");
                   request.setAttribute("courts", dao.getAllCourtDesc());
                  out.println("<script type=\"text/javascript\">");
                  out.println("alert('try again');");
                   request.setAttribute("courts", dao.getAllCourtDesc());
                  out.println("location='CourtController?action=listCourt';");
                  out.println("</script>"); 
               }
        
           
           
        } else {
            court.setCcm_ID(Integer.parseInt(courtID));
            int i=dao.updateCourt(court);
            
            
            if(i>0)
               {
                    request.setAttribute("advocates", dao.getAllCourtDesc());
                     out.println("<script type=\"text/javascript\">");
                      out.println("alert('Court updated Successfully');");
                     
                        
             request.setAttribute("courts", dao.getAllCourtDesc());
                 out.println("location='CourtController?action=listCourt';");
                    out.println("</script>");
               }
               else
               {
                  out.println("<script type=\"text/javascript\">");
                  out.println("alert('try again');");
 request.setAttribute("courts", dao.getAllCourtDesc());    
    out.println("location='CourtController?action=listCourt';");
                  out.println("</script>"); 
               }
            
        }
      /*  RequestDispatcher view = request.getRequestDispatcher(LIST_COURT);
        request.setAttribute("courts", dao.getAllCourtDesc());
        view.forward(request, response);*/
      
      
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
