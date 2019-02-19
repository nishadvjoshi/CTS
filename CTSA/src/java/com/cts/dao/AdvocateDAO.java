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
import java.sql.*;
import java.util.*;
import com.cts.model.Advocate;
import com.cts.model.Category;
import com.cts.util.Database;

public class AdvocateDAO {

    private Connection connection;

    public AdvocateDAO() {
        connection = Database.getConnection();
    }

    public List<Advocate> getAllAdvocate() {
        List<Advocate> advocates = new ArrayList<Advocate>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_madvocates");
            while (rs.next()) {
                Advocate advocate = new Advocate();

                advocate.setCam_ID(rs.getInt("cam_ID"));
                advocate.setCam_ZipCode(rs.getInt("cam_ZipCode"));
                advocate.setCam_PZipCode(rs.getInt("cam_PZipCode"));
                advocate.setCam_CreateUser(rs.getInt("cam_CreateUser"));
                advocate.setCam_ModifyUser(rs.getInt("cam_ModifyUser"));

                advocate.setCam_FirstName(rs.getString("cam_FirstName"));
               
                advocate.setCam_AdvocateType(rs.getString("cam_AdvocateType"));
                advocate.setCam_AdvocateCode(rs.getString("cam_AdvocateCode"));
                advocate.setCam_LicenseNo(rs.getString("cam_LicenseNo"));
                advocate.setCam_EmailID1(rs.getString("cam_EmailID1"));
                advocate.setCam_EmailID2(rs.getString("cam_EmailID2"));
                advocate.setCam_CellNo1(rs.getString("cam_CellNo1"));
                advocate.setCam_CellNo2(rs.getString("cam_CellNo2"));
                advocate.setCam_LandlineNo(rs.getString("cam_LandlineNo"));
                advocate.setCam_Addr1(rs.getString("cam_Addr1"));
                advocate.setCam_Addr2(rs.getString("cam_Addr2"));
                advocate.setCam_NearLocation(rs.getString("cam_NearLocation"));
                advocate.setCam_District(rs.getString("cam_District"));
                advocate.setCam_City(rs.getString("cam_City"));
                advocate.setCam_State(rs.getString("cam_State"));
                advocate.setCam_Country(rs.getString("cam_Country"));

                advocate.setCam_PAddr1(rs.getString("cam_PAddr1"));
                advocate.setCam_PAddr2(rs.getString("cam_PAddr2"));
                advocate.setCam_PNearLocation(rs.getString("cam_PNearLocation"));
                advocate.setCam_PDistrict(rs.getString("cam_PDistrict"));
                advocate.setCam_PCity(rs.getString("cam_PCity"));
                advocate.setCam_PState(rs.getString("cam_State"));
                advocate.setCam_PCountry(rs.getString("cam_Country"));

                advocate.setCam_PassportNo(rs.getString("cam_PassportNo"));

                advocate.setCam_DOB(rs.getDate("cam_DOB"));
                advocate.setCam_CreateDate(rs.getDate("cam_CreateDate"));
                advocate.setCam_ModifyDate(rs.getDate("cam_ModifyDate"));

                advocate.setCam_ActiveFlag(rs.getBoolean("cam_ActiveFlag"));
                advocate.setCam_DeleteFlag(rs.getBoolean("cam_DeleteFlag"));

                advocates.add(advocate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return advocates;
    }

    
     public List<Advocate> getAllAdvocateDesc() {
        List<Advocate> advocates = new ArrayList<Advocate>();
        try {
             System.out.println("im from decs ");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cts_madvocates order by cam_ModifyDate desc");
            while (rs.next()) {
                Advocate advocate = new Advocate();
               
                advocate.setCam_ID(rs.getInt("cam_ID"));
                advocate.setCam_ZipCode(rs.getInt("cam_ZipCode"));
                advocate.setCam_PZipCode(rs.getInt("cam_PZipCode"));
                advocate.setCam_CreateUser(rs.getInt("cam_CreateUser"));
                advocate.setCam_ModifyUser(rs.getInt("cam_ModifyUser"));

                advocate.setCam_FirstName(rs.getString("cam_FirstName"));
               
                advocate.setCam_AdvocateType(rs.getString("cam_AdvocateType"));
                advocate.setCam_AdvocateCode(rs.getString("cam_AdvocateCode"));
                advocate.setCam_LicenseNo(rs.getString("cam_LicenseNo"));
                advocate.setCam_EmailID1(rs.getString("cam_EmailID1"));
                advocate.setCam_EmailID2(rs.getString("cam_EmailID2"));
                advocate.setCam_CellNo1(rs.getString("cam_CellNo1"));
                advocate.setCam_CellNo2(rs.getString("cam_CellNo2"));
                advocate.setCam_LandlineNo(rs.getString("cam_LandlineNo"));
                advocate.setCam_Addr1(rs.getString("cam_Addr1"));
                advocate.setCam_Addr2(rs.getString("cam_Addr2"));
                advocate.setCam_NearLocation(rs.getString("cam_NearLocation"));
                advocate.setCam_District(rs.getString("cam_District"));
                advocate.setCam_City(rs.getString("cam_City"));
                advocate.setCam_State(rs.getString("cam_State"));
                advocate.setCam_Country(rs.getString("cam_Country"));

                advocate.setCam_PAddr1(rs.getString("cam_PAddr1"));
                advocate.setCam_PAddr2(rs.getString("cam_PAddr2"));
                advocate.setCam_PNearLocation(rs.getString("cam_PNearLocation"));
                advocate.setCam_PDistrict(rs.getString("cam_PDistrict"));
                advocate.setCam_PCity(rs.getString("cam_PCity"));
                advocate.setCam_PState(rs.getString("cam_State"));
                advocate.setCam_PCountry(rs.getString("cam_Country"));

                advocate.setCam_PassportNo(rs.getString("cam_PassportNo"));

                advocate.setCam_DOB(rs.getDate("cam_DOB"));
                advocate.setCam_CreateDate(rs.getDate("cam_CreateDate"));
                advocate.setCam_ModifyDate(rs.getDate("cam_ModifyDate"));

                advocate.setCam_ActiveFlag(rs.getBoolean("cam_ActiveFlag"));
                advocate.setCam_DeleteFlag(rs.getBoolean("cam_DeleteFlag"));

                advocates.add(advocate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return advocates;
    }
    
    
    
    
    public void deleteAdvocate(int AdvocateID) {
        
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from cts_madvocates where cam_ID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, AdvocateID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }

    public Advocate getAdvocateById(int AdvocateID) {
        Advocate advocate = new Advocate();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from cts_madvocates where cam_ID=?");
            preparedStatement.setInt(1, AdvocateID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                advocate.setCam_ID(rs.getInt("cam_ID"));
                advocate.setCam_ZipCode(rs.getInt("cam_ZipCode"));
                advocate.setCam_PZipCode(rs.getInt("cam_PZipCode"));
                advocate.setCam_CreateUser(rs.getInt("cam_CreateUser"));
                advocate.setCam_ModifyUser(rs.getInt("cam_ModifyUser"));

                advocate.setCam_FirstName(rs.getString("cam_FirstName"));
                
                advocate.setCam_AdvocateType(rs.getString("cam_AdvocateType"));
                advocate.setCam_AdvocateCode(rs.getString("cam_AdvocateCode"));
                advocate.setCam_LicenseNo(rs.getString("cam_LicenseNo"));
                advocate.setCam_EmailID1(rs.getString("cam_EmailID1"));
                advocate.setCam_EmailID2(rs.getString("cam_EmailID2"));
                advocate.setCam_CellNo1(rs.getString("cam_CellNo1"));
                advocate.setCam_CellNo2(rs.getString("cam_CellNo2"));
                advocate.setCam_LandlineNo(rs.getString("cam_LandlineNo"));
                advocate.setCam_Addr1(rs.getString("cam_Addr1"));
                advocate.setCam_Addr2(rs.getString("cam_Addr2"));
                advocate.setCam_NearLocation(rs.getString("cam_NearLocation"));
                advocate.setCam_District(rs.getString("cam_District"));
                advocate.setCam_City(rs.getString("cam_City"));
                advocate.setCam_State(rs.getString("cam_State"));
                advocate.setCam_Country(rs.getString("cam_Country"));

                advocate.setCam_PAddr1(rs.getString("cam_PAddr1"));
                advocate.setCam_PAddr2(rs.getString("cam_PAddr2"));
                advocate.setCam_PNearLocation(rs.getString("cam_PNearLocation"));
                advocate.setCam_PDistrict(rs.getString("cam_PDistrict"));
                advocate.setCam_PCity(rs.getString("cam_PCity"));
                advocate.setCam_PState(rs.getString("cam_State"));
                advocate.setCam_PCountry(rs.getString("cam_Country"));

                advocate.setCam_PassportNo(rs.getString("cam_PassportNo"));

                advocate.setCam_DOB(rs.getDate("cam_DOB"));
                advocate.setCam_CreateDate(rs.getDate("cam_CreateDate"));
                advocate.setCam_ModifyDate(rs.getDate("cam_ModifyDate"));

                advocate.setCam_ActiveFlag(rs.getBoolean("cam_ActiveFlag"));
                advocate.setCam_DeleteFlag(rs.getBoolean("cam_DeleteFlag"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return advocate;
    }

    public int addAdvocate(Advocate advocate) {
         int i=0;
        try {
           
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO cts_madvocates"
                            + "(cam_FirstName,cam_AdvocateType,cam_AdvocateCode,cam_LicenseNo,cam_EmailID1,cam_EmailID2,cam_CellNo1,cam_CellNo2,cam_LandlineNo,cam_Addr1,cam_Addr2,cam_NearLocation,cam_District,cam_City,cam_State,cam_Country,cam_ZipCode,cam_PAddr1,cam_PAddr2,cam_PNearLocation,cam_PDistrict,cam_PCity,cam_PState,cam_PCountry,cam_PZipCode,cam_PassportNo,cam_DOB,cam_CreateDate,cam_CreateUser,cam_ModifyDate,cam_ModifyUser,cam_DeleteFlag,cam_ActiveFlag)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, advocate.getCam_FirstName());
           
            preparedStatement.setString(2, advocate.getCam_AdvocateType());
            preparedStatement.setString(3, advocate.getCam_AdvocateCode());
            preparedStatement.setString(4, advocate.getCam_LicenseNo());
            preparedStatement.setString(5, advocate.getCam_EmailID1());
            preparedStatement.setString(6, advocate.getCam_EmailID2());
            preparedStatement.setString(7, advocate.getCam_CellNo1());
            preparedStatement.setString(8, advocate.getCam_CellNo2());
            preparedStatement.setString(9, advocate.getCam_LandlineNo());
            preparedStatement.setString(10, advocate.getCam_Addr1());
            preparedStatement.setString(11, advocate.getCam_Addr2());
            preparedStatement.setString(12, advocate.getCam_NearLocation());
            preparedStatement.setString(13, advocate.getCam_District());
            preparedStatement.setString(14, advocate.getCam_City());
            preparedStatement.setString(15, advocate.getCam_State());
            preparedStatement.setString(16, advocate.getCam_Country());
            preparedStatement.setInt(17, advocate.getCam_ZipCode());
            preparedStatement.setString(18, advocate.getCam_PAddr1());
            preparedStatement.setString(19, advocate.getCam_PAddr2());
            preparedStatement.setString(20, advocate.getCam_PNearLocation());
            preparedStatement.setString(21, advocate.getCam_PDistrict());
            preparedStatement.setString(22, advocate.getCam_PCity());
            preparedStatement.setString(23, advocate.getCam_PState());
            preparedStatement.setString(24, advocate.getCam_PCountry());
            preparedStatement.setInt(25, advocate.getCam_PZipCode());
            preparedStatement.setString(26, advocate.getCam_PassportNo());
            preparedStatement.setDate(27, new java.sql.Date(advocate.getCam_DOB().getTime()));
            preparedStatement.setDate(28, new java.sql.Date(advocate.getCam_CreateDate().getTime()));
            preparedStatement.setInt(29, advocate.getCam_CreateUser());
            preparedStatement.setDate(30, new java.sql.Date(advocate.getCam_ModifyDate().getTime()));
            preparedStatement.setInt(31, advocate.getCam_ModifyUser());
            preparedStatement.setBoolean(32, advocate.isCam_DeleteFlag());
            preparedStatement.setBoolean(33, advocate.isCam_ActiveFlag());

             i=preparedStatement.executeUpdate();
             
              if(i>0)
                        {
                            System.out.println("success");
                        }
                        else
                        {
                                                        System.out.println("fail");

                        }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return i; 
    }

    public int updateAdvocate(Advocate advocate) {
        int i=0;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE cts_madvocates SET cam_FirstName = ?, cam_AdvocateType = ?,cam_AdvocateCode = ?, cam_LicenseNo = ?, cam_EmailID1 = ?, cam_EmailID2 = ?, cam_CellNo1 = ?, cam_CellNo2 = ?, cam_LandlineNo = ?, cam_Addr1 = ?, cam_Addr2 = ?, cam_NearLocation = ?, cam_District = ?, cam_City = ?, cam_State = ?, cam_Country = ?, cam_ZipCode = ?, cam_PAddr1 = ?, cam_PAddr2 = ?, cam_PNearLocation = ?, cam_PDistrict = ?, cam_PCity = ?, cam_PState = ?, cam_PCountry = ?, cam_PZipCode = ?, cam_PassportNo = ?, cam_DOB = ?, cam_CreateDate = ?, cam_CreateUser = ?, cam_ModifyDate = ?, cam_ModifyUser = ?,cam_DeleteFlag = ?, cam_ActiveFlag = ? WHERE cam_ID = ?");
            // Parameters start with 1
            preparedStatement.setString(1, advocate.getCam_FirstName());

            preparedStatement.setString(2, advocate.getCam_AdvocateType());
            preparedStatement.setString(3, advocate.getCam_AdvocateCode());
            preparedStatement.setString(4, advocate.getCam_LicenseNo());
            preparedStatement.setString(5, advocate.getCam_EmailID1());
            preparedStatement.setString(6, advocate.getCam_EmailID2());
            preparedStatement.setString(7, advocate.getCam_CellNo1());
            preparedStatement.setString(8, advocate.getCam_CellNo2());
            preparedStatement.setString(9, advocate.getCam_LandlineNo());
            preparedStatement.setString(10, advocate.getCam_Addr1());
            preparedStatement.setString(11, advocate.getCam_Addr2());
            preparedStatement.setString(12, advocate.getCam_NearLocation());
            preparedStatement.setString(13, advocate.getCam_District());
            preparedStatement.setString(14, advocate.getCam_City());
            preparedStatement.setString(15, advocate.getCam_State());
            preparedStatement.setString(16, advocate.getCam_Country());
            preparedStatement.setInt(17, advocate.getCam_ZipCode());
            preparedStatement.setString(18, advocate.getCam_PAddr1());
            preparedStatement.setString(19, advocate.getCam_PAddr2());
            preparedStatement.setString(20, advocate.getCam_PNearLocation());
            preparedStatement.setString(21, advocate.getCam_PDistrict());
            preparedStatement.setString(22, advocate.getCam_PCity());
            preparedStatement.setString(23, advocate.getCam_PState());
            preparedStatement.setString(24, advocate.getCam_PCountry());
            preparedStatement.setInt(25, advocate.getCam_PZipCode());
            preparedStatement.setString(26, advocate.getCam_PassportNo());
            preparedStatement.setDate(27, new java.sql.Date(advocate.getCam_DOB().getTime()));
            preparedStatement.setDate(28, new java.sql.Date(advocate.getCam_CreateDate().getTime()));
            preparedStatement.setInt(29, advocate.getCam_CreateUser());
            preparedStatement.setDate(30, new java.sql.Date(advocate.getCam_ModifyDate().getTime()));
            preparedStatement.setInt(31, advocate.getCam_ModifyUser());
            preparedStatement.setBoolean(32, advocate.isCam_DeleteFlag());
            preparedStatement.setBoolean(33, advocate.isCam_ActiveFlag());
            
            preparedStatement.setInt(34, advocate.getCam_ID());
            
           i= preparedStatement.executeUpdate();
           
            if(i>0)
                        {
                            System.out.println("success");
                        }
                        else
                        {
                                                        System.out.println("fail");

                        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

}
