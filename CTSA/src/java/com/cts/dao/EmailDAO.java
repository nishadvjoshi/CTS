package com.cts.dao;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;  
  
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
  
public class EmailDAO { 
    
  /*  private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        
        
        
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }

   
}  
*/


 private static void sendFromGMail(String from, String pass1, String[] to, String subject, String body) {
        
         try
        {
           
            String current = new java.io.File( "ctsConfig.properties" ).getCanonicalPath();
       // System.out.println("Current dir:"+current);
          FileReader reader = new FileReader(current);
    Properties prop = new Properties();
    prop.load(reader);

             String host = prop.getProperty("email.host");
             String port = prop.getProperty("email.port");
             String user = prop.getProperty("email.user");
             String pass = prop.getProperty("email.pass");
        System.out.println(host+""+port+""+user+""+pass);

       
        
        Properties props = System.getProperties();
        
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", user);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(user));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
          
        catch(IOException pros)
        {
         System.out.println("Email Properties is not accessed because of"+pros);
        }

    }
}  