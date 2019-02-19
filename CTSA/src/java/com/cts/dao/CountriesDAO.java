/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.dao;

import com.cts.model.Advocate;
import com.cts.model.Client;
import java.sql.*;
import java.util.*;

import com.cts.model.Countries;
import com.cts.model.CaseStage;
import com.cts.util.Database;

/**
 *
 * @author Admin
 */
public class CountriesDAO {

    private Connection connection;

    public CountriesDAO() {
        connection = Database.getConnection();
    }

    public ArrayList<Countries> getAllCountries() {
        ArrayList<Countries> countryList = new ArrayList<Countries>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from country limit 10");
            
            while (rs.next()) {
                Countries country = new Countries();
                country.setCode(rs.getString("Code"));
                country.setName(rs.getString("Name"));
                country.setContinent(rs.getString("Continent"));
                country.setRegion(rs.getString("Region"));
                country.setPopulation(rs.getInt("Population"));
                country.setCapital(rs.getString("Capital"));
                countryList.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countryList;
    }

}
