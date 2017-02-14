/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author mashiro
 */
public class Conn {
     private Connection connection;
    final private String dbClass = "com.mysql.jdbc.Driver"; 
    final private String dbUrl = "jdbc:mysql://localhost/uts";
    final private String dbUsername = "root";
    final private String dbPassword = "root";
    
    public Connection Conn(){
        try{
            if(connection == null){
                Class.forName(dbClass);
                connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                System.out.println("connected");
            }
        } catch(ClassNotFoundException ex){
            System.out.println("error1");
            System.out.println(ex.getMessage());
        } catch(SQLException ex){
            System.out.println("error");
            System.out.println(ex.getMessage());
        }
        
        return connection;
    }
    
    public Connection Conn(String dbUrl, String dbUsername, String dbPassword){
        try{
            if(connection == null){
                Class.forName(dbClass);
                connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            }
        } catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return connection;
    }
    
    public void disconnect(){
        try{
            if(connection != null){
                connection.close();
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
