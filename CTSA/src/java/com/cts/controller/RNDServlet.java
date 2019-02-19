package com.cts.controller;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.cts.dao.ZIpFIle;
 
public class RNDServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;
       private ZIpFIle dao;
    @Override
    public void init() throws ServletException{
        DiskFileItemFactory fileFactory = new DiskFileItemFactory();
        File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
        fileFactory.setRepository(filesDir);
        this.uploader = new ServletFileUpload(fileFactory);
    }
    
    
    public RNDServlet() {
        super();
        dao = new ZIpFIle();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        if(fileName == null || fileName.equals("")){
            throw new ServletException("File Name can't be null or empty");
        }
        File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileName);
        if(!file.exists()){
            throw new ServletException("File doesn't exists on server.");
        }
        System.out.println("File location on server::"+file.getAbsolutePath());
        ServletContext ctx = getServletContext();
    
        InputStream fis = new FileInputStream(file);
        String mimeType = ctx.getMimeType(file.getAbsolutePath());
        response.setContentType(mimeType != null? mimeType:"application/octet-stream");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
 
        ServletOutputStream os       = response.getOutputStream();
        byte[] bufferData = new byte[1024];
        int read=0;
        while((read = fis.read(bufferData))!= -1){
            os.write(bufferData, 0, read);
        }
        os.flush();
        os.close();
        fis.close();
        System.out.println("File downloaded at client successfully");
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
         /* if(!ServletFileUpload.isMultipartContent(request)){
            throw new ServletException("Content type is not multipart/form-data");
        }*/
        String relativePath="";
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
       
         if(ServletFileUpload.isMultipartContent(request)){
             
       String name=request.getParameter("xz");
       System.out.println("get data from multipart form "+name);
       
        try {
             String rootPath = System.getProperty("catalina.home");
        out.println(rootPath);
          String casemasterid="demo\\";
       
        Date date = new Date();  
    SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");  
    String strDate= formatter.format(date);  
    out.println(strDate);  
        
          
            relativePath = casemasterid+strDate;
        
        
        
        
        File file = new File(File.separator + relativePath);
        out.println("file  :"+file);
        if(!file.exists()) file.mkdirs();
        out.println("File Directory created to be used for storing files");
        request.setAttribute("FILES_DIR_FILE", file);
        request.setAttribute("FILES_DIR", rootPath + File.separator + relativePath);
        int i=0;
            List<FileItem> fileItemsList = uploader.parseRequest(request);
            Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
            while(fileItemsIterator.hasNext()){
                FileItem fileItem = fileItemsIterator.next();
                out.println("FieldName="+fileItem.getFieldName());
                out.println("FileName="+fileItem.getName());
                out.println("ContentType="+fileItem.getContentType());
                out.println("Size in bytes="+fileItem.getSize());
 
              //  File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileItem.getName());
                
                File file1=new File((file)+File.separator+fileItem.getName());
                out.println("file  ::"+file1);
                out.println("Absolute Path at server="+file1.getAbsolutePath());
                fileItem.write(file1);
                out.write("File "+fileItem.getName()+ " uploaded successfully.");
                out.write("<br>");
                out.write("<a href=\"#?fileName=C:\\demo1\\"+strDate+"\\"+fileItem.getName()+"\">Download "+fileItem.getName()+"</a>");
                i++;
            }
            out.println("no of iterartions="+i);
            dao.generateFileList(new File("C:\\"+relativePath),"C:\\"+relativePath);
             
              dao.zipIt("C:\\"+relativePath+".zip","C:\\"+relativePath);
 
            
        } 
        
        
        
        
        catch (Exception e)
        {
            out.write("Exception ."+e);
        }
        
        
                
        
        
         }
        else
        {
              out.println("multipart error");
                }
         
         
         
         
       
    }
 
}