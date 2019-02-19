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
import com.cts.dao.SCasePaymentsDAO;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

public class SCasePaymentsController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/ctsSCasePayments.jsp";
    private static String LIST_DAIRY_SEARCH = "/ctsSCasePayments.jsp";
    private static String LIST_CASEDETAIL = "/ctsSCasePayments.jsp";
    private static String HOME_PAGE = "/index.jsp";
    private SCasePaymentsDAO dao;
    private ClientDAO clientDAO;

    public SCasePaymentsController() {
        super();
        dao = new SCasePaymentsDAO();
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
        if (action.equalsIgnoreCase("listCaseDetail")) {
            forward = LIST_DAIRY_SEARCH;
            //request.setAttribute("casedetails", dao.getAllCaseDetail());
            request.setAttribute("casemasters", dao.getAllCaseMaster());

        } else if (action.equalsIgnoreCase("delete")) {
            int CasePaymentID = Integer.parseInt(request.getParameter("CasePaymentID"));

            System.out.println("This is var: " + request.getParameter("cad_ID"));

            //request.setAttribute("casedetailsTMP", dao.getAllCaseDetailByDetailID(CaseDetailID));
            //int cad_ID = Integer.parseInt(dao.getAllCaseDetailByDetailID(CaseDetailID).toString());
            dao.deleteCasePayment(CasePaymentID);
            //request.setAttribute("casedetails", dao.getAllCaseDetailByDetailID(CaseDetailID));
            request.setAttribute("casemasters", dao.getAllCaseMaster());
            request.setAttribute("casepaymentstable", dao.getAllCasePaymentByPaymentID(CasePaymentID));
            request.setAttribute("casedetail", dao.getCaseDetailByPaymentId(CasePaymentID));
            forward = LIST_DAIRY_SEARCH;

        } else if (action.equalsIgnoreCase("edit")) {

            int CasePaymentID = Integer.parseInt(request.getParameter("CasePaymentID"));
            CasePayments casepayment = dao.getCasePaymentByID(CasePaymentID);
            // CaseDetail casedetail = dao.getCaseDetailByDId(CaseDetailID);
            request.setAttribute("casepayment", casepayment);
            request.setAttribute("casemasters", dao.getAllCaseMaster());
            request.setAttribute("casepaymentstable", dao.getAllCasePaymentByPaymentID(CasePaymentID));
            request.setAttribute("casedetail", dao.getCaseDetailByPaymentId(CasePaymentID));
            //request.setAttribute("casedetail", dao.getCaseDetailById(Integer.parseInt(request.getParameter("cad_id"))));
            //request.setAttribute("casepaymentstable", dao.getAllCasePaymentByID(Integer.parseInt(request.getParameter("cad_id"))));

            forward = LIST_DAIRY_SEARCH;

        } else {
           // HttpSession session = request.getSession(false);
            if (session != null) {
                System.out.println(session.getAttribute("FirstName"));
                if (session.getAttribute("FirstName").toString().contains("Sushil")) {

                    request.setAttribute("casemasters", dao.getAllCaseMaster());
                    forward = INSERT_OR_EDIT;
                } else {

                    forward = HOME_PAGE;
                }
            }

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
          
        CasePayments casepayment = new CasePayments();

        if (request.getParameter("GetDetails") != null) {

            String str = request.getParameter("cad_FileName1");
            System.out.println(str);
            String selected_Comments[] = request.getParameterValues("cad_FileName1");
            for (String comment : selected_Comments) {
                System.out.println(comment);
                request.setAttribute("casedetail", dao.getCaseDetailById(Integer.parseInt(comment)));

                request.setAttribute("casepaymentstable", dao.getAllCasePaymentByID(Integer.parseInt(comment)));
                request.setAttribute("casemasters", dao.getAllCaseMaster());
                request.getRequestDispatcher("/ctsSCasePayments.jsp").forward(request, response);

            }

        } else if (request.getParameter("SaveDetails") != null) {
            int cad_ID = Integer.parseInt(request.getParameter("cad_id"));
            int RegNo = Integer.parseInt(request.getParameter("cad_RegNo"));
            int CreateUser = Integer.parseInt(request.getParameter("ccp_CreateUser"));
            int ModifyUser = Integer.parseInt(request.getParameter("ccp_ModifyUser"));
            //casedetail.setCcd_ID(ccd_ID);        
            casepayment.setCad_ID(cad_ID);
            casepayment.setCcp_CreateUser(CreateUser);
            casepayment.setCcp_ModifyUser(ModifyUser);
            casepayment.setCad_RegNo(RegNo);

            System.out.println(request.getParameter("cad_CaseNo"));
            casepayment.setCad_CaseNo(request.getParameter("cad_CaseNo"));

            casepayment.setCad_FileNo(request.getParameter("cad_FileNo"));
            casepayment.setCad_FileName(request.getParameter("cad_FileName"));
            casepayment.setCad_ClientName(request.getParameter("cad_ClientName"));

            casepayment.setCcp_PaymentType(request.getParameter("ccp_PaymentType"));
            casepayment.setCcp_PaymentChequeNo(request.getParameter("ccp_PaymentChequeNo"));
            casepayment.setCcp_PaymentChequeName(request.getParameter("ccp_PaymentChequeName"));
            casepayment.setCcp_NEFTTransactionNo(request.getParameter("ccp_NEFTTransactionNo"));
            casepayment.setCcp_DepositBank(request.getParameter("ccp_DepositBank"));
            casepayment.setCcp_PaymentChequeBank(request.getParameter("ccp_PaymentChequeBank"));

            try {
                Date PaymentDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("ccp_PaymentDate"));
                casepayment.setCcp_PaymentDate(PaymentDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            try {
                Date PaymentChequeDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("ccp_PaymentChequeDate"));
                casepayment.setCcp_PaymentChequeDate(PaymentChequeDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            try {
                Date CreateDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("ccp_CreateDate"));
                casepayment.setCcp_CreateDate(CreateDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            try {
                Date ModifyDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("ccp_ModifyDate"));
                casepayment.setCcp_ModifyDate(ModifyDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            boolean ActiveFlag = Boolean.parseBoolean(request.getParameter("ccp_ActiveFlag"));
            boolean DeleteFlag = Boolean.parseBoolean(request.getParameter("ccp_DeleteFlag"));
            casepayment.setCcp_ActiveFlag(ActiveFlag);
            casepayment.setCcp_DeleteFlag(DeleteFlag);

            String PaymentAmount = request.getParameter("ccp_PaymentAmount");
            String TDSAmount = request.getParameter("ccp_TDSAmount");
            casepayment.setCcp_PaymentAmount(PaymentAmount);
            casepayment.setCcp_TDSAmount(TDSAmount);

            String CasePaymentID = request.getParameter("ccp_ID");
            if (CasePaymentID == null || CasePaymentID.isEmpty() || CasePaymentID.equalsIgnoreCase("0")) {
                dao.addCasePayment(casepayment);
            } else {
                casepayment.setCcp_ID(Integer.parseInt(CasePaymentID));
                dao.updateCasePayment(casepayment);
            }
            RequestDispatcher view = request.getRequestDispatcher(LIST_DAIRY_SEARCH);

            request.setAttribute("casemasters", dao.getAllCaseMaster());
            request.setAttribute("casepaymentstable", dao.getAllCasePaymentByID(Integer.parseInt(request.getParameter("cad_id"))));
            request.setAttribute("casedetail", dao.getCaseDetailByCaseID(Integer.parseInt(request.getParameter("cad_id"))));
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
