/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webPackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


/**
 *
 * @author Alex Heaps
 */
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if(Validate.checkUser(email, password)){
            out.println("Successful login");
            RequestDispatcher resDis = request.getRequestDispatcher("account.jsp");
            resDis.forward(request, response);
        } else {
            out.println("Email or Password is incorect. you have typed " +email+" "+password);
            System.out.println("Email or Password is incorect. you have typed " +email+" "+password);
            RequestDispatcher resDis = request.getRequestDispatcher("login.jsp");
            resDis.include(request, response);
        }
    }
    
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
