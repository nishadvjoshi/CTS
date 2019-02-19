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

import com.cts.dao.ClientDAO;
import com.cts.model.Client;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;


public class ClientController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/ctsAddClient.jsp";
    private static String LIST_CLIENT = "/ctsClients.jsp";
    private static String HOME_PAGE = "/index.jsp";
    private ClientDAO dao;

    public ClientController() {
        super();
        dao = new ClientDAO();
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
        if (action.equalsIgnoreCase("listClient")) {
            //HttpSession session = request.getSession(false);
             if (session.getAttribute("Role").toString().contains("Administrator")) {

                    forward = LIST_CLIENT;
                    //request.setAttribute("clients", dao.getAllClient());
                       request.setAttribute("clients", dao.getAllClientDesc());
                } else {

                    forward = HOME_PAGE;
                }
            
        } else if (action.equalsIgnoreCase("delete")) {
            int ClientID = Integer.parseInt(request.getParameter("ClientID"));
            dao.deleteClient(ClientID);
            forward = LIST_CLIENT;
            request.setAttribute("clients", dao.getAllClientDesc());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int ClientID = Integer.parseInt(request.getParameter("ClientID"));
            Client client = dao.getClientById(ClientID);
            request.setAttribute("client", client);
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
          
        
        
        
        Client client = new Client();
        //casecategory.setCcg_CategoryName(request.getParameter("CategoryName"));
        //casecategory.setCcg_Description(request.getParameter("Description"));
       
        int ZipCode = Integer.parseInt(request.getParameter("cmc_ZipCode"));
        int PZipCode = Integer.parseInt(request.getParameter("cmc_PZipCode"));
        int CreateUser = Integer.parseInt(request.getParameter("cmc_CreateUser"));
        int ModifyUser = Integer.parseInt(request.getParameter("cmc_ModifyUser"));
        client.setCmc_ZipCode(ZipCode);
        client.setCmc_PZipCode(PZipCode);
        client.setCmc_CreateUser(CreateUser);
        client.setCmc_ModifyUser(ModifyUser);

        client.setCmc_FirstName(request.getParameter("cmc_FirstName"));

        client.setCmc_ClientType(request.getParameter("cmc_ClientType"));
        client.setCmc_OrgName(request.getParameter("cmc_OrgName"));
        
        client.setCmc_EmailID1(request.getParameter("cmc_EmailID1"));
        client.setCmc_EmailID2(request.getParameter("cmc_EmailID2"));
        client.setCmc_CellNo1(request.getParameter("cmc_CellNo1"));
        client.setCmc_CellNo2(request.getParameter("cmc_CellNo2"));
        client.setCmc_LandlineNo(request.getParameter("cmc_LandlineNo"));
        client.setCmc_Addr1(request.getParameter("cmc_Addr1"));
        client.setCmc_Addr2(request.getParameter("cmc_Addr2"));
        client.setCmc_NearLocation(request.getParameter("cmc_NearLocation"));
        client.setCmc_District(request.getParameter("cmc_District"));
        client.setCmc_City(request.getParameter("cmc_City"));
        client.setCmc_State(request.getParameter("cmc_State"));
        client.setCmc_Country(request.getParameter("cmc_Country"));

        client.setCmc_PAddr1(request.getParameter("cmc_PAddr1"));
        client.setCmc_PAddr2(request.getParameter("cmc_PAddr2"));
        client.setCmc_PNearLocation(request.getParameter("cmc_PNearLocation"));
        client.setCmc_PDistrict(request.getParameter("cmc_PDistrict"));
        client.setCmc_PCity(request.getParameter("cmc_PCity"));
        client.setCmc_PState(request.getParameter("cmc_State"));
        client.setCmc_PCountry(request.getParameter("cmc_Country"));

       
      
        try {
            Date CreateDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("cmc_CreateDate"));
            client.setCmc_CreateDate(CreateDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            Date ModifyDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("cmc_ModifyDate"));
            client.setCmc_ModifyDate(ModifyDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        boolean ActiveFlag = Boolean.parseBoolean(request.getParameter("cmc_ActiveFlag"));
        boolean DeleteFlag = Boolean.parseBoolean(request.getParameter("cmc_DeleteFlag"));
        client.setCmc_ActiveFlag(ActiveFlag);
        client.setCmc_DeleteFlag(DeleteFlag);

        String ClientID = request.getParameter("ClientID");
        if (ClientID == null || ClientID.isEmpty()) {
            int i=dao.addClient(client);
            
            if(i>0)
               {
                   System.out.println("calling from  add advocate inner if");
                    request.setAttribute("advocates", dao.getAllClientDesc());
                     out.println("<script type=\"text/javascript\">");
                      out.println("alert('Client Added Successfully');");
                     
                        
            
              out.println("location='ClientController?action=listClient';");
                    out.println("</script>");
               }
               else
               {    
                   System.out.println("calling from  add advocate inner else ");
                   request.setAttribute("advocates", dao.getAllClientDesc());
                  out.println("<script type=\"text/javascript\">");
                  out.println("alert('try again');");
                 
                  out.println("location='ClientController?action=listClient';");
                  out.println("</script>"); 
               }
        
            
            
        } else {
            client.setCmc_ID(Integer.parseInt(ClientID));
            int i=dao.updateClient(client);
            
             if(i>0)
               {
                   System.out.println("calling from  add advocate inner if");
                    request.setAttribute("advocates", dao.getAllClientDesc());
                     out.println("<script type=\"text/javascript\">");
                      out.println("alert('Client Updated Successfully');");
                     
                        
            
              out.println("location='ClientController?action=listClient';");
                    out.println("</script>");
               }
               else
               {    
                   System.out.println("calling from  add advocate inner else ");
                   request.setAttribute("advocates", dao.getAllClientDesc());
                  out.println("<script type=\"text/javascript\">");
                  out.println("alert('try again');");
                 
                  out.println("location='ClientController?action=listClient';");
                  out.println("</script>"); 
               }
        }
      
        /*RequestDispatcher view = request.getRequestDispatcher(LIST_CLIENT);
        request.setAttribute("clients", dao.getAllClientDesc());
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