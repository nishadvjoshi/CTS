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
import com.cts.model.Client;
import com.cts.model.CasePayments;
import com.cts.model.CaseExpenses;
import com.cts.dao.CasePaymentsDAO;
import com.cts.dao.CaseExpenseDAO;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

public class CaseExpensesController extends HttpServlet {
    
     private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/ctsCaseExpenses.jsp";
    private static String LIST_DAIRY_SEARCH = "/ctsCaseExpenses.jsp";
    private static String LIST_CASEDETAIL = "/ctsCaseExpenses.jsp";
    private static String HOME_PAGE = "/index.jsp";
    private CaseExpenseDAO dao1;
    private CasePaymentsDAO dao;
    private ClientDAO clientDAO;
    
    public CaseExpensesController() {
        super();
        dao1 = new CaseExpenseDAO();
        dao = new CasePaymentsDAO();
        clientDAO = new ClientDAO();
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
         if (action.equalsIgnoreCase("listExpenses")) {
             
             // HttpSession session = request.getSession(false);
             if (session.getAttribute("Role").toString().contains("Administrator")) {

                    forward = LIST_DAIRY_SEARCH;            
                    request.setAttribute("casemasters", dao.getAllCaseMaster());
                } else {

                    forward = HOME_PAGE;
                }
            
         }    
         else if (action.equalsIgnoreCase("delete")) {
            System.out.println("This is delete var - " + request.getParameter("CaseExpenseID"));
              dao1.deleteCaseExpense(Integer.parseInt(request.getParameter("CaseExpenseID")));
            request.setAttribute("casemasters", dao.getAllCaseMaster());
            request.setAttribute("caseexpensestable", dao1.getAllCaseExpenseByExpenseID(Integer.parseInt(request.getParameter("CaseExpenseID"))));
            request.setAttribute("casedetail", dao1.getCaseDetailByExpenseId(Integer.parseInt(request.getParameter("CaseExpenseID"))));
             
            forward = INSERT_OR_EDIT;
        }
         
          else if (action.equalsIgnoreCase("edit")) {
            System.out.println("This is edit var - " + request.getParameter("CaseExpenseID"));
            CaseExpenses caseexpense = dao1.getCaseExpenseByID(Integer.parseInt(request.getParameter("CaseExpenseID"))); 
             request.setAttribute("caseexpense", caseexpense);
            request.setAttribute("casemasters", dao.getAllCaseMaster());
            request.setAttribute("caseexpensestable", dao1.getAllCaseExpenseByExpenseID(Integer.parseInt(request.getParameter("CaseExpenseID"))));
            request.setAttribute("casedetail", dao1.getCaseDetailByExpenseId(Integer.parseInt(request.getParameter("CaseExpenseID"))));
             
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
        CaseExpenses caseexpense = new CaseExpenses();
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
          
        if (request.getParameter("GetDetails") != null) {

            String str = request.getParameter("cad_FileName1");
            System.out.println(str);
            String selected_Comments[] = request.getParameterValues("cad_FileName1");
            for (String comment : selected_Comments) {
                System.out.println(comment);
                request.setAttribute("casedetail", dao1.getCaseDetailById(Integer.parseInt(comment)));
                request.setAttribute("caseexpensetotal", dao1.getCaseCaseExpenseTotalID(Integer.parseInt(comment)));
                request.setAttribute("caseexpensestable", dao1.getAllCaseExpenseByID(Integer.parseInt(comment)));
                request.setAttribute("casemasters", dao1.getAllCaseMaster());
                request.getRequestDispatcher("/ctsCaseExpenses.jsp").forward(request, response);

            }

        } 
        
        else if (request.getParameter("SaveDetails") != null) {
             int cad_ID = Integer.parseInt(request.getParameter("cad_id"));
            int RegNo = Integer.parseInt(request.getParameter("cad_RegNo"));
            int CreateUser = Integer.parseInt(request.getParameter("cce_CreateUser"));
            int ModifyUser = Integer.parseInt(request.getParameter("cce_ModifyUser"));
            //casedetail.setCcd_ID(ccd_ID);        
            caseexpense.setCad_ID(cad_ID);
            caseexpense.setCce_CreateUser(CreateUser);
            caseexpense.setCce_ModifyUser(ModifyUser);
            caseexpense.setCad_RegNo(RegNo);

            System.out.println(request.getParameter("cad_CaseNo"));
            caseexpense.setCad_CaseNo(request.getParameter("cad_CaseNo"));

            caseexpense.setCad_FileNo(request.getParameter("cad_FileNo"));
            caseexpense.setCad_FileName(request.getParameter("cad_FileName"));
            caseexpense.setCad_ClientName(request.getParameter("cad_ClientName"));
            
            caseexpense.setCce_ExpenseType(request.getParameter("cce_ExpenseType"));
            caseexpense.setCce_ExpenseBy(request.getParameter("cce_ExpenseBy"));
            caseexpense.setCce_ExpenseInvoiceNo(request.getParameter("cce_ExpenseInvoiceNo"));
            
          
                 

          
            try {
                Date ExpenseDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("cce_ExpenseDate"));
                caseexpense.setCce_ExpenseDate(ExpenseDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
         
            
             try {
                Date CreateDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("cce_CreateDate"));
                caseexpense.setCce_CreateDate(CreateDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }


            try {
                Date ModifyDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("cce_ModifyDate"));
                caseexpense.setCce_ModifyDate(ModifyDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            boolean ActiveFlag = Boolean.parseBoolean(request.getParameter("cce_ActiveFlag"));
            boolean DeleteFlag = Boolean.parseBoolean(request.getParameter("cce_DeleteFlag"));
            caseexpense.setCce_ActiveFlag(ActiveFlag);
            caseexpense.setCce_DeleteFlag(DeleteFlag);
            
            Double ExpenseAmount = Double.parseDouble(request.getParameter("cce_ExpenseAmount"));
            
            caseexpense.setCce_ExpenseAmount(ExpenseAmount);
           
            

            String CaseExpenseID = request.getParameter("cce_ID");
            if (CaseExpenseID == null || CaseExpenseID.isEmpty() || CaseExpenseID.equalsIgnoreCase("0")) {
                dao1.addCaseExpense(caseexpense);
            } else {
                caseexpense.setCce_ID(Integer.parseInt(CaseExpenseID));
                dao1.updateCaseExpense(caseexpense);
            }
            RequestDispatcher view = request.getRequestDispatcher(LIST_DAIRY_SEARCH);
           
            request.setAttribute("casemasters", dao.getAllCaseMaster());
            request.setAttribute("caseexpensestable", dao1.getAllCaseExpenseByID(Integer.parseInt(request.getParameter("cad_id"))));
            request.setAttribute("caseexpensetotal", dao1.getCaseCaseExpenseTotalID(Integer.parseInt(request.getParameter("cad_id"))));
            request.setAttribute("casedetail", dao1.getCaseDetailByCaseID(Integer.parseInt(request.getParameter("cad_id"))));
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
