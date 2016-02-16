package com.haris.DB;

import java.sql.*;

public class DBExitBean {

	private Connection conn;
	private String result;
	
	public DBExitBean() {
		conn = null;
	}
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public String getResult() {
		execute();
		return result;
	}
	
	private void execute() {
		StringBuffer b = new StringBuffer(10000);
		try {
			conn.close();
			b.append("<hr><h3>MySQL Database connection was successfully closed</h3>");
			b.append("<h3>Good Bye!</h3><hr>");
		}
	    catch (Exception e) {
			b.append("<hr>Error closing MySQL connection ...<hr>");
			b.append(e);
		}
		result = b.toString();
	}	
}
