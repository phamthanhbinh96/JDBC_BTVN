/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topica.edu.itlab.jdbc.exercise;

import com.topica.edu.itlab.jdbc.tutorial.entity.ClassEntity;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author P.T.B
 */
public class Run {
    public static void main(String[] args) throws NoSuchFieldException, SQLException {
        Statement stmt =(Statement) DbConnect.getConnection();
        LazyLoading lzLoad = new LazyLoading();
        List<ClassEntity> listCE = lzLoad.loadListClass();
      
    }
}