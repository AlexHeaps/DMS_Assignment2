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
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:1527/motelDatabase");
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
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:1527/motelDatabase");
            PreparedStatement prepstat = conn.prepareStatement("SELECT email FROM guest WHERE email= '" + email + "'");
            prepstat.setString(1, email);
            ResultSet resSet = prepstat.executeQuery();
            st = resSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
    //adds a certain user/email/pass to db
    public static boolean addUserToDb(String password, String firstName, String lastName, String email) {
        boolean st = false;
        try {
            //loaddrivers for mySQL
            Class.forName("com.mysql.jdbc.Driver");

            //create connection with DB
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:1527/motelDatabase");
            int incrementedID = 0;
            //prepstat to find the number of users in guest
            PreparedStatement prepstat1 = conn.prepareStatement("SELECT COUNT(DISTINCT userID) as ID FROM guest");
            ResultSet resSet = prepstat1.executeQuery();
            if(resSet.next()){
                //set incrementedID as number of users in guest, then add one
                incrementedID = resSet.getInt("ID");
                incrementedID++;
                //printing to check value
                System.out.print("Incremented ID :" + incrementedID);
            }
            //add all details into table:Guest
            PreparedStatement prepstat = conn.prepareStatement("INSERT INTO guest VALUES (userID="+incrementedID+",email='"+email+"', firstName='"+firstName+"', lastName='"+lastName+"', password='"+password+"')");
            prepstat.executeQuery();
            st = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    } 
}
