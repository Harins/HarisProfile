package com.haris.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*; 

public class DBQueryServ extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        StringBuffer b = new StringBuffer(1000);
        b.append("<html><head><title>MySQL Query</title></head><body>");
        b.append("<form method=\"post\">");
        b.append("<p><b>Enter here a SQL SELECT statement :</b></p><hr>");
        b.append("<p>Query <input type=\"text\" name=\"query\" size=50>");
        b.append("<p><input type=\"submit\" value=\"Run query\"></p>");
        b.append("</form>");
        b.append("</body></html>");
        out.println(b.toString());
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        HttpSession sess = request.getSession();
        Connection conn;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        StringBuffer b = new StringBuffer(20000);
        b.append("<html><head><title>Going on</title></head><body>");
        try {
                conn = (Connection) sess.getAttribute("conn");
                Statement s = conn.createStatement();
                ResultSet r = s.executeQuery(query);
                b.append("<h3>Query results</h3>");
                b.append("<hr><table border=\"3\"><tr>");
                ResultSetMetaData md = r.getMetaData();
                for (int i=1; i <= md.getColumnCount(); i++)
                        b.append("<th>" + md.getColumnName(i) + "</th>");
                b.append("</tr>");
                while(r.next()) {
                        b.append("<tr>");
                        for (int i=1; i <= md.getColumnCount(); i++) {
                                b.append("<td>");
                                switch(md.getColumnType(i))  {
                                case Types.CHAR:
                                case Types.VARCHAR:
                                        b.append(r.getString(i));
                                        break;
                                case Types.INTEGER:
                                        b.append(r.getInt(i));
                                        break;
                                case Types.DOUBLE:
                                        b.append(r.getDouble(i));
                                        break;
                                default:
                                        b.append("N/A");
                                }
                                b.append("</td>");                
                        }
                        b.append("</tr>");
                }
                b.append("</table><hr>");
        } catch(Exception e) {
                b.append("<hr>Database query failed ...<hr>");
        }
        b.append("<a href=" + request.getRequestURI() + ">Enter a database query</a>");
        b.append("</body></html>");
        out.println(b.toString());
        out.close();
    }

}


