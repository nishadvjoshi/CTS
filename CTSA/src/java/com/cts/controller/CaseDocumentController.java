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
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.cts.dao.CaseDocumentDAO;
import com.cts.dao.ZIpFIle;
import com.cts.model.CaseDocument;
import com.cts.model.CaseDetail;
import static java.lang.System.out;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.http.HttpSession;

public class CaseDocumentController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/ctsCaseDocuments.jsp";
    private static String LIST_CASEDETAIL = "/ctsCaseDocuments.jsp";
    private static String LIST_CASEDDOCUMENTS = "/ctsDownloadDocuments.jsp";
    private CaseDocumentDAO dao;
      private ServletFileUpload uploader = null;
       private ZIpFIle daod;
   // private final String UPLOAD_DIRECTORY = "d:/uploads";

    public CaseDocumentController() {
        super();
        dao = new CaseDocumentDAO();
        daod=new ZIpFIle();
    }
  public void init() throws ServletException{
        DiskFileItemFactory fileFactory = new DiskFileItemFactory();
        File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
        fileFactory.setRepository(filesDir);
        this.uploader = new ServletFileUpload(fileFactory);
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
          
        if (action.equalsIgnoreCase("download")) {
            
            response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		String filename = request.getParameter("FileName");
                System.out.println("filename is"+filename);
		String filepath = "C:\\demo\\" + session.getAttribute("cad_ID").toString() + "\\";
                response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ filename + "\"");

		// use inline if you want to view the content in browser, helpful for
		// pdf file
		// response.setHeader("Content-Disposition","inline; filename=\"" +
		// filename + "\"");
		FileInputStream fileInputStream = new FileInputStream(filepath
				+ filename);

		int i;
		while ((i = fileInputStream.read()) != -1) {
			out.write(i);
		}
		fileInputStream.close();
		out.close();
        }
        
        else if (action.equalsIgnoreCase("listDocument")) {
                    forward = LIST_CASEDETAIL;
                    request.setAttribute("casemasters", dao.getAllCaseMaster());
         }
         
         else
         {
                    forward = LIST_CASEDDOCUMENTS;
                    request.setAttribute("casemasters", dao.getAllCaseMaster());
                    request.setAttribute("casedocuments", dao.getAllCaseDocuments());
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
        CaseDocument casedocument = new CaseDocument();
         HttpSession session = request.getSession(false);
 String relativePath="";
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (request.getParameter("GetDetails") != null) {

            String str = request.getParameter("cad_FileName1");
            // System.out.println("file NAME IS"+str);
            String selected_Comments[] = request.getParameterValues("cad_FileName1");
               for (String comment : selected_Comments) {
                
               // System.out.println("comments"+comment.length());
                //HttpSession session = request.getSession(false);
                System.out.println("inside"+comment);
                CaseDetail casedetail = dao.getCaseDetailById(Integer.parseInt(comment));
                request.setAttribute("casedetail", dao.getCaseDetailById(Integer.parseInt(comment)));
                session.setAttribute("cad_ID", casedetail.getCad_ID());
                session.setAttribute("cad_CaseNo", casedetail.getCad_CaseNo());
                session.setAttribute("cad_FileName", casedetail.getCad_FileName());
                session.setAttribute("cad_ClientName", casedetail.getCad_ClientName());
                
                //session.setAttribute("ClientID", userdetail.getCmu_ClientID());
                request.setAttribute("casemasters", dao.getAllCaseMaster());
                request.setAttribute("casedocuments", dao.getCaseDocuments(Integer.parseInt(comment)));
                //request.getRequestDispatcher("/ctsCaseDocuments.jsp").forward(request, response);
                RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
               
                
                

            }

        }

        else   if(ServletFileUpload.isMultipartContent(request)){
       
       
        try {
             String rootPath = System.getProperty("catalina.home");
              System.out.println("here is the root path"+rootPath);
        
            System.out.println("File name is "+session.getAttribute("cad_FileName"));
                System.out.println("Cad id is"+session.getAttribute("cad_ID"));
        
            int casemasterid=Integer.parseInt((String) session.getAttribute("cad_ID"));
     
        Date date = new Date();  
    SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");  
    String strDate= formatter.format(date);  
    out.println(strDate);  
        
          
            relativePath = "demo\\"+casemasterid+"\\"+strDate; //put your path instead of demo then we can create folder inside that folder 
        
                String fname = null;
                String fsize = null;
                String ftype = null;
        
        
        File file = new File(File.separator + relativePath);
        out.println("file  :"+file);
        if(!file.exists()) file.mkdirs();
        out.println("File Directory created to be used for storing files");
        request.setAttribute("FILES_DIR_FILE", file);
        request.setAttribute("FILES_DIR", rootPath + File.separator + relativePath);
        
            List<FileItem> fileItemsList = uploader.parseRequest(request);
            Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
            while(fileItemsIterator.hasNext()){
               
                FileItem fileItem = fileItemsIterator.next();
                System.out.println("FieldName="+fileItem.getFieldName());
                 System.out.println("FileName="+fileItem.getName());
                 System.out.println("ContentType="+fileItem.getContentType());
                 System.out.println("Size in bytes="+fileItem.getSize());
                
              //  File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileItem.getName());
                
                File file1=new File((file)+File.separator+fileItem.getName());
                out.println("file  ::"+file1);
                out.println("Absolute Path at server="+file1.getAbsolutePath());
                fileItem.write(file1);
                System.out.println("File "+fileItem.getName()+ " uploaded successfully.");
                out.write("<br>");
                out.write("<a href=\"#?fileName=C:\\demo\\"+strDate+"\\"+fileItem.getName()+"\">Download "+fileItem.getName()+"</a>");
                
            }
                 
            daod.generateFileList(new File("C:\\"+relativePath+"\\"),"C:\\"+relativePath);
             
              daod.zipIt("C:\\"+relativePath+".zip","C:\\"+relativePath);
               // File uploaded successfully
                //request.setAttribute("message", "File Uploaded Successfully");
                request.setAttribute("name", fname);
                request.setAttribute("size", fsize);
                request.setAttribute("type", ftype);
               
                System.out.println(session.getAttribute("FirstName"));
                System.out.println(session.getAttribute("cad_ID"));

                //int CreateUser = Integer.parseInt(request.getParameter("cdd_CreateUser"));
                //int ModifyUser = Integer.parseInt(request.getParameter("cdd_ModifyUser"));
                int CreateUser = 1;
                int ModifyUser = 1;
                //casedetail.setCcd_ID(ccd_ID);        
               
                casedocument.setCdd_CreateUser(CreateUser);
                casedocument.setCdd_ModifyUser(ModifyUser);
               

                casedocument.setCad_id(Integer.parseInt(session.getAttribute("cad_ID").toString()));
                casedocument.setCad_RegNo(Integer.parseInt(session.getAttribute("cad_RegNo").toString()));
                casedocument.setCad_CaseNo(session.getAttribute("cad_CaseNo").toString());
                casedocument.setCad_FileName(session.getAttribute("cad_FileName").toString());
                casedocument.setCdd_DocumentType("zip");
                casedocument.setCdd_DocumentName(strDate+".zip");
                casedocument.setCdd_DocumentLocation("C:\\"+relativePath+".zip");
                casedocument.setCdd_DocumentRevisedName(strDate);

                try {
                    Date CreateDate = new SimpleDateFormat("dd/MM/yyyy").parse("02/02/2019");
                    casedocument.setCdd_CreateDate(CreateDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                try {
                    Date ModifyDate = new SimpleDateFormat("dd/MM/yyyy").parse("02/02/2019");
                    casedocument.setCdd_ModifyDate(ModifyDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                boolean ActiveFlag = true;
                boolean DeleteFlag = false;
                casedocument.setCdd_ActiveFlag(ActiveFlag);
                casedocument.setCdd_DeleteFlag(DeleteFlag);
               
              int i=dao.addCaseDocument(casedocument); // add entry to database
              
            if(i>0)
                    
                    {
                        System.out.println("data uploaded");
                    }
            else{
                System.out.println(" not uploaded");
            }
        } 
        
        
        
        
        catch (Exception e)
        {
            out.println("Exception ."+e);
        }
        
        
                
        
        
         }
        else
        {
              out.println("multipart error");
                }
         
            /*if (ServletFileUpload.isMultipartContent(request)) {
            try {
                String fname = null;
                String fsize = null;
                String ftype = null;
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : multiparts) {
                    System.out.println("multipart"+item);
                    if (!item.isFormField()) {
                        fname = new File(item.getName()).getName();
                        fsize = new Long(item.getSize()).toString();
                        ftype = item.getContentType();
                        item.write(new File(UPLOAD_DIRECTORY + File.separator
                                + session.getAttribute("cad_ID") + File.separator +  fname));
                    }
                }
                // File uploaded successfully
                request.setAttribute("message", "File Uploaded Successfully");
                request.setAttribute("name", fname);
                request.setAttribute("size", fsize);
                request.setAttribute("type", ftype);
               
                System.out.println(session.getAttribute("FirstName"));
                System.out.println(session.getAttribute("cad_ID"));

                //int CreateUser = Integer.parseInt(request.getParameter("cdd_CreateUser"));
                //int ModifyUser = Integer.parseInt(request.getParameter("cdd_ModifyUser"));
                int CreateUser = 1;
                int ModifyUser = 1;
                //casedetail.setCcd_ID(ccd_ID);        
               
                casedocument.setCdd_CreateUser(CreateUser);
                casedocument.setCdd_ModifyUser(ModifyUser);
               

                casedocument.setCad_id(Integer.parseInt(session.getAttribute("cad_ID").toString()));
                casedocument.setCad_RegNo(9999);
                casedocument.setCad_CaseNo(session.getAttribute("cad_CaseNo").toString());
                casedocument.setCad_FileName(session.getAttribute("cad_FileName").toString());
                casedocument.setCdd_DocumentType(ftype);
                casedocument.setCdd_DocumentName(fname);
                casedocument.setCdd_DocumentLocation(UPLOAD_DIRECTORY);
                casedocument.setCdd_DocumentRevisedName(fname);

                try {
                    Date CreateDate = new SimpleDateFormat("dd/MM/yyyy").parse("20/06/2016");
                    casedocument.setCdd_CreateDate(CreateDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                try {
                    Date ModifyDate = new SimpleDateFormat("dd/MM/yyyy").parse("20/06/2016");
                    casedocument.setCdd_ModifyDate(ModifyDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                boolean ActiveFlag = true;
                boolean DeleteFlag = false;
                casedocument.setCdd_ActiveFlag(ActiveFlag);
                casedocument.setCdd_DeleteFlag(DeleteFlag);
                dao.addCaseDocument(casedocument);
                
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to "
                        + ex);
            }

        } else {
            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");
        }*/
            
            
            
            
        request.setAttribute("casedetail", dao.getCaseDetailById(Integer.parseInt(session.getAttribute("cad_ID").toString())));
        request.setAttribute("casemasters", dao.getAllCaseMaster());
        //request.getRequestDispatcher("/ctsCaseDocuments.jsp").forward(request, response);
        RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
        view.forward(request, response);
    }

}
