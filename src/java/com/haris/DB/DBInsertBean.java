
package com.haris.DB;
import java.sql.*;

public class DBInsertBean {
        private String sn;
	private String subject;
	private String place;
	private String deadline;
        private String time;
	private String priority;
	private String result;
	private Connection conn;

    public DBInsertBean() {
        conn = null;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

   

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public void setResult(String result) {
        this.result = result;
    }

    public Connection getConn() {
        return conn;
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
			String sql = "insert into harisdiary values (?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
                        pst.setString(1, sn);
			pst.setString(2, subject);
			pst.setString(3, place);
			pst.setString(4, deadline);
                        pst.setString(5, time);
                        pst.setString(6, priority);
			int numRowsChanged = pst.executeUpdate();
			if (numRowsChanged != 0) {
				b.append("<hr><h3>New event has been inserted</h3><hr>");
			} else {
				b.append("<hr><h3>Failed to insert the new event data, Check the date and time format..</h3><hr>");
			}
			pst.close();
		} catch (SQLException e) {
			b.append("<hr><h3>SQLException caught: </h3><hr>");
		} catch (Exception e) {
			b.append("<hr><h3>Database query failed ...</h3><hr>");
			b.append(e);
		}
		result = b.toString();
	}
}
