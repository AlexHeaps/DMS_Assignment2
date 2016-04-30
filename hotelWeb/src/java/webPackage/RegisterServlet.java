/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Ryan
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String password = request.getParameter("password");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            //if there are no emails in db, then:
            if (!uniqueEmailQuery(email)) {
                //Add client to db
                Validate.addUserToDb(password, firstName, lastName, email);
                out.println("You have successfully created an account!");
                RequestDispatcher resDis = request.getRequestDispatcher("login.jsp");
                resDis.forward(request, response);
            } else {
                out.println("Email is taken, try again");
                //maybe instead of going to index, go back to register tab?
                RequestDispatcher resDis = request.getRequestDispatcher("register.jsp");
                resDis.include(request, response);
            }
            /* TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>"); */
        }
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
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
