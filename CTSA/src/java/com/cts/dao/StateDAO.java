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
import com.cts.model.State;
import com.cts.util.Database;


public class StateDAO {
     private Connection connection;
    
     public StateDAO() {
        connection = Database.getConnection();
    }
     
      public List<State> getAllState() {
            List<State> states = new ArrayList<State>();
            try {
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery("select * from cts_mState");
                    while (rs.next()) {
                            State state = new State();
                   
                      
                        state.setCms_ID(rs.getInt("cms_ID"));
                        state.setCms_StateName(rs.getString("ccm_StateName"));
                        state.setCms_StateDescription(rs.getString("ccm_StateDescription"));
                                                                        
                        states.add(state);
            }
        }
            catch (SQLException e) {
            e.printStackTrace();
            }
 
            return states;
        }
}
