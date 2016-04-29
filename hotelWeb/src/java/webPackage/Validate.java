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
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:1527/moteldb");
            Statement statement = conn.createStatement();
            ResultSet resSet = statement.executeQuery("SELECT email, password FROM guest WHERE email='"+email+"' AND password='"+password+"'");
            if(resSet.next()){
                st=true;
            }
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
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:1527/moteldb");
            Statement statement= conn.createStatement();
            //prepstat.setString(1, email);
            ResultSet resSet = statement.executeQuery("SELECT email FROM guest WHERE email='"+email+"'");
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
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:1527/moteldb");
            int incrementedID = 0;
            //prepstat to find the number of users in guest
            Statement statement1 = conn.createStatement();
            ResultSet resSet = statement1.executeQuery("SELECT COUNT(DISTINCT userID) as IDCount FROM guest");
            if(resSet.next()){
                //set incrementedID as number of users in guest, then add one
                incrementedID = resSet.getInt("IDCount");
                incrementedID++;
                //printing to check value
                System.out.print("Incremented ID :" + incrementedID);
            }
            //add all details into table:Guest
            Statement statement2 = conn.createStatement();
            statement2.executeQuery("INSERT INTO guest (userID, email, firstName, lastName, password) VALUES ('"+incrementedID+"', '"+email+"', '"+firstName+"', '"+lastName+"', '"+password+"')");
            st = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    } 
}
