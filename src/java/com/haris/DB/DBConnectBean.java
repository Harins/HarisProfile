package com.haris.DB;

import java.sql.*;

public class DBConnectBean {
    
    private String user;
    private String pwd;
    private Connection conn; 
    
    public DBConnectBean() {
        conn = null;
    }
    
    public void setUser(String a) {
        user = a;
    }
    
    public void setPwd(String a) {
        pwd = a;
    }
    
    public Connection getConn() {
        return conn;
    }
    
    public boolean connect() {
        try {
           Class.forName("com.mysql.jdbc.Driver");
//           String db = "jdbc:mysql://mysql.metropolia.fi:3306/" + user;
           String db = "jdbc:mysql://localhost:3306/haris";
           conn = DriverManager.getConnection(db, user, pwd); 
           return true; 
        } catch(Exception e) {
            return false;
        }
    }
    
}


