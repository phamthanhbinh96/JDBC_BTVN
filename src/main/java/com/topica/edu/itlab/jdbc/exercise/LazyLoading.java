/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topica.edu.itlab.jdbc.exercise;

import com.topica.edu.itlab.jdbc.tutorial.annotation.Column;
import com.topica.edu.itlab.jdbc.tutorial.annotation.OneToMany;
import com.topica.edu.itlab.jdbc.tutorial.annotation.Table;
import com.topica.edu.itlab.jdbc.tutorial.entity.ClassEntity;
import com.topica.edu.itlab.jdbc.tutorial.entity.StudentEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author P.T.B
 */
public class LazyLoading {
    public List<ClassEntity> loadListClass() throws NoSuchFieldException, SQLException{
        List<ClassEntity> listCE = new ArrayList<ClassEntity>();  
        String sql="select * from "+ClassEntity.class.getAnnotation(Table.class).name();
        
        ResultSet rs = null;
        PreparedStatement pStmt = null;
        try{
            String classId = ClassEntity.class.getDeclaredField("id").getAnnotation(Column.class).name();
            String className = ClassEntity.class.getDeclaredField("name").getAnnotation(Column.class).name();
            rs = pStmt.executeQuery(sql);
            while (rs.next()) {
                ClassEntity classEntity = new ClassEntity();
                classEntity.setId(Long.valueOf(rs.getInt(classId)));
                classEntity.setName(rs.getString(className));

                listCE.add(classEntity);
            }
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listCE;
}       
    
    public List<StudentEntity> loadListStudent(long id) throws NoSuchFieldException, SQLException{
            List<StudentEntity> listStd = new ArrayList<StudentEntity>();
            String sql="select * from "+ClassEntity.class.getAnnotation(OneToMany.class).mappedBy();
            ResultSet rs = null;
            PreparedStatement pStmt = null;
            try{
                String stdId=StudentEntity.class.getDeclaredField("id").getAnnotation(Column.class).name();
                String stdName=StudentEntity.class.getDeclaredField("name").getAnnotation(Column.class).name();

                rs = pStmt.executeQuery(sql);
                while (rs.next()) {
                    StudentEntity studentEntity = new StudentEntity();

                    studentEntity.setId(Long.valueOf(rs.getInt(stdId)));
                    studentEntity.setName(rs.getString(stdName));

                    studentEntity.add(studentEntity);
                }
                return listStd;
            }
            catch (NoSuchFieldException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        return listStd;
    }
}

