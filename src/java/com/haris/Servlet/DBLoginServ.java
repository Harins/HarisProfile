package com.haris.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*; 

public class DBLoginServ extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
                      throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        StringBuffer b = new StringBuffer(1000);
        b.append("<html><head><title>MySQL Login</title></head><body>");
        b.append("<form method=\"post\">");
        b.append("<p><h3>Connect to MySQL database :</h3></p><hr>");
        b.append("<p>User name <input type=\"text\" name=\"user\" size=20>");
        b.append("<p>Password <input type=\"password\" name=\"passwd\" size=20>");
        b.append("<p><input type=\"submit\" value=\"Connect\"></p>");
        b.append("</form>");
        b.append("</body></html>");
        out.println(b.toString());
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
                      throws ServletException, IOException {
        String user = request.getParameter("user");
        String passwd = request.getParameter("passwd");
//        String db = "jdbc:mysql://mysql.metropolia.fi:3306/" + user;
        String db = "jdbc:mysql://localhost:3306/haris";
        Connection conn = null;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        StringBuffer b = new StringBuffer(1000);
        b.append("<html><head><title>Going on</title></head><body>");
        try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(db, user, passwd);
                HttpSession sess = request.getSession();
                sess.setAttribute("conn", conn);
                b.append("<hr>Connection to MySQL database established !<hr>");
                b.append("<a href=\"DBQueryServ\">Enter a database query</a>");
        } catch(Exception e) {
                b.append("<hr>Connection not established - wrong user and/or password ...<hr>");
                b.append("<a href=" + request.getRequestURI() + ">Retry to connect</a>");
        }
        b.append("</body></html>");
        out.println(b.toString());
        out.close();
    }

}


