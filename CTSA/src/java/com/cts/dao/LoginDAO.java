/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.dao;

/**
 *
 * @author nishad
 */
import com.cts.model.CaseMaster;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cts.util.Database;
import java.sql.Statement;

import com.cts.model.User;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoginDAO {

    
    private Connection connection;

    public LoginDAO() {
        connection = Database.getConnection();
    }
    
    
    
    public boolean validate(String name, String pass) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

     
        try {
             Statement statement = connection.createStatement();
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
            
            preparedStatement = connection.
                    prepareStatement("select * from cts_musers where cmu_UserName=? and cmu_Password=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, pass);
            rs = preparedStatement.executeQuery();
           
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;

    }
    
    public boolean validateUser(String name) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

       
        try {
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
            
            preparedStatement = connection.
                    prepareStatement("select * from cts_musers where cmu_UserName=?");
            preparedStatement.setString(1, name);
            
            rs = preparedStatement.executeQuery();
            
   
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;

    }
    
    public User getUserDetailByID(String name, String pass) throws FileNotFoundException, IOException {
        User userdetail = new User();
        try {
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
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select cmu_ID,cmu_UserName,cmu_Role,cmu_FirstName,cmu_LastName,cmu_ClientID,cmu_City from cts_musers where cmu_UserName=? and cmu_Password=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, pass);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                //casedetail.setCcd_ID(rs.getInt("ccd_id"));
                userdetail.setCmu_ID(rs.getInt("cmu_ID"));
                userdetail.setCmu_UserName(rs.getString("cmu_UserName"));
                userdetail.setCmu_Role(rs.getString("cmu_Role"));
                userdetail.setCmu_FirstName(rs.getString("cmu_FirstName"));
                userdetail.setCmu_LastName(rs.getString("cmu_LastName"));
                userdetail.setCmu_ClientID(rs.getInt("cmu_ClientID"));
                userdetail.setCmu_City(rs.getString("cmu_City"));
                


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userdetail;
    }
    
    public User getUserDetailByName(String name) throws IOException {
       User userdetail = new User();
        try {
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
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select cmu_UserName,cmu_Password from cts_musers where cmu_UserName=?");
            preparedStatement.setString(1, name);
            
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
               //User userdetail = new User();
                userdetail.setCmu_FirstName(rs.getString("cmu_UserName"));
                userdetail.setCmu_Password(rs.getString("cmu_UserName"));
                
               
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userdetail;
    }
    
    
    
        public User getUserDetailByUserName(String name) throws IOException {
        User userdetail = new User();
        try {
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
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select cmu_ID,cmu_Password,cmu_UserName,cmu_Role,cmu_FirstName,cmu_LastName,cmu_ClientID,cmu_City from cts_musers where cmu_UserName=? ");
            preparedStatement.setString(1, name);
          
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                //casedetail.setCcd_ID(rs.getInt("ccd_id"));
                userdetail.setCmu_ID(rs.getInt("cmu_ID"));
                userdetail.setCmu_UserName(rs.getString("cmu_UserName"));
                userdetail.setCmu_Role(rs.getString("cmu_Role"));
                userdetail.setCmu_FirstName(rs.getString("cmu_FirstName"));
                userdetail.setCmu_LastName(rs.getString("cmu_LastName"));
                userdetail.setCmu_ClientID(rs.getInt("cmu_ClientID"));
                userdetail.setCmu_City(rs.getString("cmu_City"));
                userdetail.setCmu_Password(rs.getString("cmu_Password"));
                


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userdetail;
    }

  
    
    
}
