/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Shiny
 */
@Stateless
public class DatabaseConnectEJB implements DatabaseConnectEJBRemote {
    
    private Connection conn;
    private Properties properties;
    private PreparedStatement addUser;
    private PreparedStatement addBooking;
    private PreparedStatement removeBooking;
    private PreparedStatement checkBooking;
    
    @Override
    public void DatabaseConnect() {
        properties = new Properties();
        try {
            properties.loadFromXML(getClass().getResourceAsStream("IH8UDB.xml"));
        } catch (IOException ex) {
            
        }
        
        String dbDriver = properties.getProperty("dbDriver").toString();
        String dbUrl = properties.getProperty("dbUrl").toString();
        String user = properties.getProperty("user").toString();
        String password = properties.getProperty("password").toString();
        
        String guestTable = properties.getProperty("guest").toString();
        String guest_ID = properties.getProperty("userID").toString();
        String guest_Password = properties.getProperty("password").toString();
        String guest_FirstName = properties.getProperty("firstName").toString();
        String guest_LastName = properties.getProperty("lastName").toString();
        String guest_Email = properties.getProperty("email").toString();
        String guest_PreviousVisits = properties.getProperty("previousVisits").toString();
       
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException ex) {
            
        }
        
        try {
            conn = DriverManager.getConnection(dbUrl, user, "");
        } catch (SQLException ex) {
        
        }
        try {
            // run prepared statements from here
            addUser = conn.prepareStatement("ADD SQL STATEMENT");
            //do this for all SQL queries
        } catch (SQLException ex) {
            
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
