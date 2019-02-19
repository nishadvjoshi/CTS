/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility {
    
    public static void sendEmail( String toAddress,
			String subject, String message) throws AddressException,
			MessagingException,
			IOException {
   try
        {
           
            String current = new java.io.File( "ctsConfig.properties" ).getCanonicalPath();
       // System.out.println("Current dir:"+current);
          FileReader reader = new FileReader(current);
    Properties prop = new Properties();
    prop.load(reader);

             String host = prop.getProperty("email.host");
             String port = prop.getProperty("email.port");
             final String userName = prop.getProperty("email.user");
             final String password = prop.getProperty("email.pass");
            //System.out.println(host+""+port+""+userName+""+password);
		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
                        @Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		msg.setText(message);
                msg.setContent(message, "text/html" );
		// sends the e-mail
		Transport.send(msg);
                System.out.println("im from sendEmail");
	}
    
      catch(IOException pros)
        {
         System.out.println("Email Properties is not accessed because of"+pros);
        }
    }
    
   
    
}
