/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topica.edu.itlab.jdbc.exercise;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author P.T.B
 */
public class DbConnect {
     public static Connection getConnection() {
        String dbURL = "jdbc:mysql://localhost:3306/database_jdbc";
        String username ="root";
        String password = "root";
        
        Connection dbCon = null;
        Statement stmt;
        ResultSet rs;
        try{
            //getting database connection to MySQL server
            dbCon = DriverManager.getConnection(dbURL, username, password);
            if (dbCon != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        }catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbCon;
    }
}

