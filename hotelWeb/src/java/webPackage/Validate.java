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

    public static boolean checkUser(String email, String password) {
        boolean st = false;

        try {
            //loaddrivers for mySQL
            Class.forName("com.mysql.jdbc.Driver");

            //create connection with DB
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/motelDatabase");
            PreparedStatement prepstat = conn.prepareStatement("SELECT * FROM guest where email=? and pass=?");
            prepstat.setString(1, email);
            prepstat.setString(1, password);
            ResultSet resSet = prepstat.executeQuery();
            st = resSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return st;
    }
    //checks if there is a certain email in userlist
    public static boolean uniqueEmailQuery(String email) {
        boolean st = false;
        try {
            //loaddrivers for mySQL
            Class.forName("com.mysql.jdbc.Driver");

            //create connection with DB
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/motelDatabase");
            PreparedStatement prepstat = conn.prepareStatement("SELECT email FROM guest WHERE email= " + email + ";");
            prepstat.setString(1, email);
            ResultSet resSet = prepstat.executeQuery();
            st = resSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
    //adds a certain user/email/pass to db
    public static boolean addUserToDb(String username, String email, String password) {
        boolean st = false;
        try {
            //loaddrivers for mySQL
            Class.forName("com.mysql.jdbc.Driver");

            //create connection with DB
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/motelDatabase");
            PreparedStatement prepstat = conn.prepareStatement("INSERT INTO guest VALUES (" + username + ", " + email + ", " + password + ");");
            //prepstat.setString(1, email);
            prepstat.executeQuery();
            st = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    } 
}
