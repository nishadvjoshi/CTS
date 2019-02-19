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
import com.cts.model.City;
import com.cts.util.Database;


public class CityDAO {
    private Connection connection;
    
     public CityDAO() {
        connection = Database.getConnection();
    }
     public List<City> getAllCity() {
            List<City> citys = new ArrayList<City>();
            try {
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery("select * from cts_mCity");
                    while (rs.next()) {
                            City city = new City();
                   
                        city.setCcc_ID(rs.getInt("ccm_ID"));
                        city.setCms_ID(rs.getInt("cms_ID"));
                        city.setCcc_CityName(rs.getString("ccm_CityName"));
                        city.setCcc_CityDescription(rs.getString("ccm_CityDescription"));
                                                                        
                        citys.add(city);
            }
        }
            catch (SQLException e) {
            e.printStackTrace();
            }
 
            return citys;
        }
}
