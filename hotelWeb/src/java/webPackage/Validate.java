/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webPackage;

import java.sql.*;

/**
 *
 * @author Alex Heaps
 */
public class Validate {
    public static boolean checkUser(String email, String password){
        boolean st = false;
        
        try{
            //loaddrivers for mySQL
            Class.forName("com.mysql.jdbc.Driver");
            
            //create connection with DB
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/motelDatabase");
            PreparedStatement prepstat = conn.prepareStatement("SELECT * FROM guest where email=? and pass=?");
            prepstat.setString(1, email);
            prepstat.setString(1, password);
            ResultSet resSet = prepstat.executeQuery();
            st = resSet.next();
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return st;
    }
}
