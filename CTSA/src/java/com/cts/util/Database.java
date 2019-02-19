/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.util;

/**
 *
 * @author nishad
 */
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
public class Database {
      public static Connection getConnection() {
          try  {
            /*  Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection
                      ("jdbc:mysql://localhost:3306/case_tracking_system",
                      "root","nvj123");*/
            
                   String current = new java.io.File( "ctsConfig.properties" ).getCanonicalPath();
       // System.out.println("Current dir:"+current);
          FileReader reader = new FileReader(current);
    Properties prop = new Properties();
    prop.load(reader);

    String drivers = prop.getProperty("jdbc.driverClassName");
    String connectionURL = prop.getProperty("jdbc.url");
      String dbname = prop.getProperty("jdbc.dbname");
    String username = prop.getProperty("jdbc.username");
    String password = prop.getProperty("jdbc.password");
    Class.forName(drivers);
    Connection con = DriverManager.getConnection(connectionURL+dbname, username, password);
              return con;
          }
          catch(Exception ex) {
              System.out.println("Database.getConnection() Error -->" + ex.getMessage());
              return null;
          }
      }
 
       public static void close(Connection con) {
          try  {
              con.close();
          }
          catch(Exception ex) {
          }
      }
}