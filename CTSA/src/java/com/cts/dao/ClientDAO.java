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

import com.cts.model.Client;
import java.sql.*;
import java.util.*;
import com.cts.model.Client;
import com.cts.util.Database;

public class ClientDAO {
    private Connection connection;

    public ClientDAO() {
        connection = Database.getConnection();
    }

    public List<Client> getAllClient() {
        List<Client> clients = new ArrayList<Client>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_mclients");
            while (rs.next()) {
                Client client = new Client();

                client.setCmc_ID(rs.getInt("cmc_ID"));
                client.setCmc_ZipCode(rs.getInt("cmc_ZipCode"));
                client.setCmc_PZipCode(rs.getInt("cmc_PZipCode"));
                client.setCmc_CreateUser(rs.getInt("cmc_CreateUser"));
                client.setCmc_ModifyUser(rs.getInt("cmc_ModifyUser"));

                client.setCmc_FirstName(rs.getString("cmc_FirstName"));                
                client.setCmc_ClientType(rs.getString("cmc_ClientType"));
                client.setCmc_OrgName(rs.getString("cmc_OrgName"));
               
                client.setCmc_EmailID1(rs.getString("cmc_EmailID1"));
                client.setCmc_EmailID2(rs.getString("cmc_EmailID2"));
                client.setCmc_CellNo1(rs.getString("cmc_CellNo1"));
                client.setCmc_CellNo2(rs.getString("cmc_CellNo2"));
                client.setCmc_LandlineNo(rs.getString("cmc_LandlineNo"));
                client.setCmc_Addr1(rs.getString("cmc_Addr1"));
                client.setCmc_Addr2(rs.getString("cmc_Addr2"));
                client.setCmc_NearLocation(rs.getString("cmc_NearLocation"));
                client.setCmc_District(rs.getString("cmc_District"));
                client.setCmc_City(rs.getString("cmc_City"));
                client.setCmc_State(rs.getString("cmc_State"));
                client.setCmc_Country(rs.getString("cmc_Country"));

                client.setCmc_PAddr1(rs.getString("cmc_PAddr1"));
                client.setCmc_PAddr2(rs.getString("cmc_PAddr2"));
                client.setCmc_PNearLocation(rs.getString("cmc_PNearLocation"));
                client.setCmc_PDistrict(rs.getString("cmc_PDistrict"));
                client.setCmc_PCity(rs.getString("cmc_PCity"));
                client.setCmc_PState(rs.getString("cmc_State"));
                client.setCmc_PCountry(rs.getString("cmc_Country"));

                

               
                client.setCmc_CreateDate(rs.getDate("cmc_CreateDate"));
                client.setCmc_ModifyDate(rs.getDate("cmc_ModifyDate"));

                client.setCmc_ActiveFlag(rs.getBoolean("cmc_ActiveFlag"));
                client.setCmc_DeleteFlag(rs.getBoolean("cmc_DeleteFlag"));

                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }
    
    
    //descending order 
     public List<Client> getAllClientDesc() {
        List<Client> clients = new ArrayList<Client>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_mclients order by cmc_ModifyDate desc ");
            while (rs.next()) {
                Client client = new Client();
                //System.out.println("im from client desc");
                client.setCmc_ID(rs.getInt("cmc_ID"));
                client.setCmc_ZipCode(rs.getInt("cmc_ZipCode"));
                client.setCmc_PZipCode(rs.getInt("cmc_PZipCode"));
                client.setCmc_CreateUser(rs.getInt("cmc_CreateUser"));
                client.setCmc_ModifyUser(rs.getInt("cmc_ModifyUser"));

                client.setCmc_FirstName(rs.getString("cmc_FirstName"));                
                client.setCmc_ClientType(rs.getString("cmc_ClientType"));
                client.setCmc_OrgName(rs.getString("cmc_OrgName"));
               
                client.setCmc_EmailID1(rs.getString("cmc_EmailID1"));
                client.setCmc_EmailID2(rs.getString("cmc_EmailID2"));
                client.setCmc_CellNo1(rs.getString("cmc_CellNo1"));
                client.setCmc_CellNo2(rs.getString("cmc_CellNo2"));
                client.setCmc_LandlineNo(rs.getString("cmc_LandlineNo"));
                client.setCmc_Addr1(rs.getString("cmc_Addr1"));
                client.setCmc_Addr2(rs.getString("cmc_Addr2"));
                client.setCmc_NearLocation(rs.getString("cmc_NearLocation"));
                client.setCmc_District(rs.getString("cmc_District"));
                client.setCmc_City(rs.getString("cmc_City"));
                client.setCmc_State(rs.getString("cmc_State"));
                client.setCmc_Country(rs.getString("cmc_Country"));

                client.setCmc_PAddr1(rs.getString("cmc_PAddr1"));
                client.setCmc_PAddr2(rs.getString("cmc_PAddr2"));
                client.setCmc_PNearLocation(rs.getString("cmc_PNearLocation"));
                client.setCmc_PDistrict(rs.getString("cmc_PDistrict"));
                client.setCmc_PCity(rs.getString("cmc_PCity"));
                client.setCmc_PState(rs.getString("cmc_State"));
                client.setCmc_PCountry(rs.getString("cmc_Country"));

                

               
                client.setCmc_CreateDate(rs.getDate("cmc_CreateDate"));
                client.setCmc_ModifyDate(rs.getDate("cmc_ModifyDate"));

                client.setCmc_ActiveFlag(rs.getBoolean("cmc_ActiveFlag"));
                client.setCmc_DeleteFlag(rs.getBoolean("cmc_DeleteFlag"));

                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }
    
    
    

    public void deleteClient(int ClientID) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from cts_mclients where cmc_ID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, ClientID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Client getClientById(int ClientID) {
        Client client = new Client();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from cts_mclients where cmc_ID=?");
            preparedStatement.setInt(1, ClientID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                client.setCmc_ID(rs.getInt("cmc_ID"));
                client.setCmc_ZipCode(rs.getInt("cmc_ZipCode"));
                client.setCmc_PZipCode(rs.getInt("cmc_PZipCode"));
                client.setCmc_CreateUser(rs.getInt("cmc_CreateUser"));
                client.setCmc_ModifyUser(rs.getInt("cmc_ModifyUser"));

                client.setCmc_FirstName(rs.getString("cmc_FirstName"));
 
                client.setCmc_ClientType(rs.getString("cmc_ClientType"));
                client.setCmc_OrgName(rs.getString("cmc_OrgName"));
                
                client.setCmc_EmailID1(rs.getString("cmc_EmailID1"));
                client.setCmc_EmailID2(rs.getString("cmc_EmailID2"));
                client.setCmc_CellNo1(rs.getString("cmc_CellNo1"));
                client.setCmc_CellNo2(rs.getString("cmc_CellNo2"));
                client.setCmc_LandlineNo(rs.getString("cmc_LandlineNo"));
                client.setCmc_Addr1(rs.getString("cmc_Addr1"));
                client.setCmc_Addr2(rs.getString("cmc_Addr2"));
                client.setCmc_NearLocation(rs.getString("cmc_NearLocation"));
                client.setCmc_District(rs.getString("cmc_District"));
                client.setCmc_City(rs.getString("cmc_City"));
                client.setCmc_State(rs.getString("cmc_State"));
                client.setCmc_Country(rs.getString("cmc_Country"));

                client.setCmc_PAddr1(rs.getString("cmc_PAddr1"));
                client.setCmc_PAddr2(rs.getString("cmc_PAddr2"));
                client.setCmc_PNearLocation(rs.getString("cmc_PNearLocation"));
                client.setCmc_PDistrict(rs.getString("cmc_PDistrict"));
                client.setCmc_PCity(rs.getString("cmc_PCity"));
                client.setCmc_PState(rs.getString("cmc_State"));
                client.setCmc_PCountry(rs.getString("cmc_Country"));

                

               // client.setCmc_DOB(rs.getDate("cmc_DOB"));
                client.setCmc_CreateDate(rs.getDate("cmc_CreateDate"));
                client.setCmc_ModifyDate(rs.getDate("cmc_ModifyDate"));

                client.setCmc_ActiveFlag(rs.getBoolean("cmc_ActiveFlag"));
                client.setCmc_DeleteFlag(rs.getBoolean("cmc_DeleteFlag"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return client;
    }

    public int addClient(Client client) {
        int i=0;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO cts_mclients"
                            + "(cmc_FirstName,cmc_ClientType,cmc_OrgName,cmc_EmailID1,cmc_EmailID2,cmc_CellNo1,cmc_CellNo2,cmc_LandlineNo,cmc_Addr1,cmc_Addr2,cmc_NearLocation,cmc_District,cmc_City,cmc_State,cmc_Country,cmc_ZipCode,cmc_PAddr1,cmc_PAddr2,cmc_PNearLocation,cmc_PDistrict,cmc_PCity,cmc_PState,cmc_PCountry,cmc_PZipCode,cmc_CreateDate,cmc_CreateUser,cmc_ModifyDate,cmc_ModifyUser,cmc_DeleteFlag,cmc_ActiveFlag)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, client.getCmc_FirstName());

            preparedStatement.setString(2, client.getCmc_ClientType());
            preparedStatement.setString(3, client.getCmc_OrgName());
            
            preparedStatement.setString(4, client.getCmc_EmailID1());
            preparedStatement.setString(5, client.getCmc_EmailID2());
            preparedStatement.setString(6, client.getCmc_CellNo1());
            preparedStatement.setString(7, client.getCmc_CellNo2());
            preparedStatement.setString(8, client.getCmc_LandlineNo());
            preparedStatement.setString(9, client.getCmc_Addr1());
            preparedStatement.setString(10, client.getCmc_Addr2());
            preparedStatement.setString(11, client.getCmc_NearLocation());
            preparedStatement.setString(12, client.getCmc_District());
            preparedStatement.setString(13, client.getCmc_City());
            preparedStatement.setString(14, client.getCmc_State());
            preparedStatement.setString(15, client.getCmc_Country());
            preparedStatement.setInt(16, client.getCmc_ZipCode());
            preparedStatement.setString(17, client.getCmc_PAddr1());
            preparedStatement.setString(18, client.getCmc_PAddr2());
            preparedStatement.setString(19, client.getCmc_PNearLocation());
            preparedStatement.setString(20, client.getCmc_PDistrict());
            preparedStatement.setString(21, client.getCmc_PCity());
            preparedStatement.setString(22, client.getCmc_PState());
            preparedStatement.setString(23, client.getCmc_PCountry());
            preparedStatement.setInt(24, client.getCmc_PZipCode());
            
            
            preparedStatement.setDate(25, new java.sql.Date(client.getCmc_CreateDate().getTime()));
            preparedStatement.setInt(26, client.getCmc_CreateUser());
            preparedStatement.setDate(27, new java.sql.Date(client.getCmc_ModifyDate().getTime()));
            preparedStatement.setInt(28, client.getCmc_ModifyUser());
            preparedStatement.setBoolean(29, client.isCmc_DeleteFlag());
            preparedStatement.setBoolean(30, client.isCmc_ActiveFlag());

            i=preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public int updateClient(Client client) {
        int i=0;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE cts_mclients SET cmc_FirstName = ?, cmc_ClientType = ?,cmc_OrgName = ?, cmc_EmailID1 = ?, cmc_EmailID2 = ?, cmc_CellNo1 = ?, cmc_CellNo2 = ?, cmc_LandlineNo = ?, cmc_Addr1 = ?, cmc_Addr2 = ?, cmc_NearLocation = ?, cmc_District = ?, cmc_City = ?, cmc_State = ?, cmc_Country = ?, cmc_ZipCode = ?, cmc_PAddr1 = ?, cmc_PAddr2 = ?, cmc_PNearLocation = ?, cmc_PDistrict = ?, cmc_PCity = ?, cmc_PState = ?, cmc_PCountry = ?, cmc_PZipCode = ?, cmc_CreateDate = ?, cmc_CreateUser = ?, cmc_ModifyDate = ?, cmc_ModifyUser = ?,cmc_DeleteFlag = ?, cmc_ActiveFlag = ? WHERE cmc_ID = ?");
            // Parameters start with 1
            preparedStatement.setString(1, client.getCmc_FirstName());

            preparedStatement.setString(2, client.getCmc_ClientType());
            preparedStatement.setString(3, client.getCmc_OrgName());
            
            preparedStatement.setString(4, client.getCmc_EmailID1());
            preparedStatement.setString(5, client.getCmc_EmailID2());
            preparedStatement.setString(6, client.getCmc_CellNo1());
            preparedStatement.setString(7, client.getCmc_CellNo2());
            preparedStatement.setString(8, client.getCmc_LandlineNo());
            preparedStatement.setString(9, client.getCmc_Addr1());
            preparedStatement.setString(10, client.getCmc_Addr2());
            preparedStatement.setString(11, client.getCmc_NearLocation());
            preparedStatement.setString(12, client.getCmc_District());
            preparedStatement.setString(13, client.getCmc_City());
            preparedStatement.setString(14, client.getCmc_State());
            preparedStatement.setString(15, client.getCmc_Country());
            preparedStatement.setInt(16, client.getCmc_ZipCode());
            preparedStatement.setString(17, client.getCmc_PAddr1());
            preparedStatement.setString(18, client.getCmc_PAddr2());
            preparedStatement.setString(19, client.getCmc_PNearLocation());
            preparedStatement.setString(20, client.getCmc_PDistrict());
            preparedStatement.setString(21, client.getCmc_PCity());
            preparedStatement.setString(22, client.getCmc_PState());
            preparedStatement.setString(23, client.getCmc_PCountry());
            preparedStatement.setInt(24, client.getCmc_PZipCode());
            
            preparedStatement.setDate(25, new java.sql.Date(client.getCmc_CreateDate().getTime()));
            preparedStatement.setInt(26, client.getCmc_CreateUser());
            preparedStatement.setDate(27, new java.sql.Date(client.getCmc_ModifyDate().getTime()));
            preparedStatement.setInt(28, client.getCmc_ModifyUser());
            preparedStatement.setBoolean(29, client.isCmc_DeleteFlag());
            preparedStatement.setBoolean(30, client.isCmc_ActiveFlag());
            
            preparedStatement.setInt(31, client.getCmc_ID());
            
            i= preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

}
