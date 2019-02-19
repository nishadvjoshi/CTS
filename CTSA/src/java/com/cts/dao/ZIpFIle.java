package com.cts.dao;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class ZIpFIle {
	
	private List <String> fileList;
    private static final String OUTPUT_ZIP_FILE = "";//destination with folder name
    private static final String SOURCE_FOLDER = ""; // SourceFolder path
     
    public ZIpFIle() {
        fileList = new ArrayList < String > ();
      
    }

	
	String source1="";
	
	public void zipIt(String zipFile,String source11) {
             System.out.println("source path"+zipFile); 
        byte[] buffer = new byte[1024];
       this.source1=source11;
      
        String source = new File(source1).getName();
        
         System.out.println("source1 folder path"+source1);
        System.out.println("source folder name"+source);
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            fos = new FileOutputStream(zipFile);
            zos = new ZipOutputStream(fos);
           
            
            System.out.println("Output to Zip : " + zipFile);
            FileInputStream in = null;

            for (String file: this.fileList) {
                System.out.println("File Added : " + file);
                ZipEntry ze = new ZipEntry(source + File.separator + file);
                System.out.println(" after adding files"+ze);
                zos.putNextEntry(ze);
                  
                try {
                    in = new FileInputStream(source1 + File.separator + file);
                    int len;
                    while ((len = in .read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }
                } finally {
                    in.close();
                }
            }

            zos.closeEntry();
            System.out.println("Folder successfully compressed");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                zos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void generateFileList(File node,String source11) {
         System.out.println("im from generateFileList"+node);
        // add file only
        this.source1=source11;
        if (node.isFile()) {
            
            fileList.add(generateZipEntry(node.toString(),source1));
             System.out.println("im from generateFileList file if "+node.toString());
        }
        else
        {
             System.out.println("im from generateFileList file else");
        }

        if (node.isDirectory()) {
             System.out.println("im from generateFileList directory if ");
            String[] subNote = node.list();
            for (String filename: subNote) {
                generateFileList(new File(node, filename),source1);
                }
            
         
        }
            else
        {
             System.out.println("im from generateFileList  direcory else");
        }
            
    }

    private String generateZipEntry(String file,String source11) {
          this.source1=source11;
           System.out.println("im from generateZipEntry  ");
        return file.substring(source1.length() + 1, file.length());
        
    }

}
