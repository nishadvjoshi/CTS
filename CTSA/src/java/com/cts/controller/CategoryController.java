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


import com.cts.dao.CategoryDAO;
import com.cts.model.Category;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;



public class CategoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/ctsAddCategory.jsp";
    private static String LIST_CATEGORY = "/listcategory.jsp";
    private CategoryDAO dao;
    
    public CategoryController() {
        super();
        dao = new CategoryDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
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
        if (action.equalsIgnoreCase("listCategory")){
            forward = LIST_CATEGORY;
            request.setAttribute("categories", dao.getAllCategoryDesc());
        } else if (action.equalsIgnoreCase("delete")){
            int categoryID = Integer.parseInt(request.getParameter("categoryID"));
            dao.deleteCaseCategory(categoryID);
            forward = LIST_CATEGORY;
            request.setAttribute("categories", dao.getAllCategoryDesc());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int categoryID = Integer.parseInt(request.getParameter("categoryID"));
            Category casecategory = dao.getCaseCategoryById(categoryID);
            request.setAttribute("category", casecategory);
        }
        else {
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
          
        Category casecategory = new Category();
        casecategory.setCcg_CategoryName(request.getParameter("ccg_CategoryName"));
        casecategory.setCcg_Description(request.getParameter("ccg_Description"));
        
        boolean DeleteFlag = Boolean.parseBoolean(request.getParameter("ccg_DeleteFlag"));
        boolean ActiveFlag = Boolean.parseBoolean(request.getParameter("ccg_ActiveFlag"));
        casecategory.setCcg_DeleteFlag(DeleteFlag);
        casecategory.setCcg_ActiveFlag(ActiveFlag);

        int CreateUser = Integer.parseInt(request.getParameter("ccg_CreateUser"));
        int ModifyUser = Integer.parseInt(request.getParameter("ccg_ModifyUser"));
       casecategory.setCcg_CreateUser(CreateUser);
        casecategory.setCcg_ModifyUser(ModifyUser);
        
        
        
         try {
            Date CreateDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("ccg_CreateDate"));
             casecategory.setCcg_CreateDate(CreateDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            Date ModifyDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("ccg_ModifyDate"));
             casecategory.setCcg_ModifyDate(ModifyDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        
        
        
        
        
        
        
        
        String categoryID = request.getParameter("ccg_ID");
        if(categoryID == null || categoryID.isEmpty())
        {
            int i=dao.addCaseCategory(casecategory);
             if(i>0)
               {
                  
                     out.println("<script type=\"text/javascript\">");
                      out.println("alert('Category Added Successfully');");
                     
                        
              
                out.println("location='CategoryController?action=listCategory';");
                    out.println("</script>");
               }
               else
               {    
                 
                  out.println("<script type=\"text/javascript\">");
                  out.println("alert('try again');");
                  
                 out.println("location='CategoryController?action=listCategory';");
                  out.println("</script>"); 
               }
            
        }
        else
        {
            casecategory.setCcg_ID(Integer.parseInt(categoryID));
            int i=dao.updateCaseCategory(casecategory);
            
            if(i>0)
               {
                  
                     out.println("<script type=\"text/javascript\">");
                      out.println("alert('Category update Successfully');");
                     
                        
              
                out.println("location='CategoryController?action=listCategory';");
                    out.println("</script>");
               }
               else
               {    
                 
                  out.println("<script type=\"text/javascript\">");
                  out.println("alert('try again');");
                  
                 out.println("location='CategoryController?action=listCategory';");
                  out.println("</script>"); 
               }
        }
        /*RequestDispatcher view = request.getRequestDispatcher(LIST_CATEGORY);
        request.setAttribute("categories", dao.getAllCategoryDesc());
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
