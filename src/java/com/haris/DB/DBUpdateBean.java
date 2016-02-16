package com.haris.DB;

import java.sql.*;

public class DBUpdateBean {

    private String osn;
    private String nsn;
    private String nsub;
    private String nplace;
    private String ndeadline;
    private String ntime;
    private String npriority;
    private String result;
    private Connection conn;

    public DBUpdateBean() {
        conn = null;
    }

    public String getOsn() {
        return osn;
    }

    public void setOsn(String osn) {
        this.osn = osn;
    }

    public String getNsn() {
        return nsn;
    }

    public void setNsn(String nsn) {
        this.nsn = nsn;
    }

    public String getNpriority() {
        return npriority;
    }

    public void setNpriority(String npriority) {
        this.npriority = npriority;
    }

    
    
    public String getNsub() {
        return nsub;
    }

    public void setNsub(String nsub) {
        this.nsub = nsub;
    }
    public String getNplace() {
        return nplace;
    }

    public void setNplace(String nplace) {
        this.nplace = nplace;
    }

    public String getNdeadline() {
        return ndeadline;
    }

    public void setNdeadline(String ndeadline) {
        this.ndeadline = ndeadline;
    }

    public String getNtime() {
        return ntime;
    }

    public void setNtime(String ntime) {
        this.ntime = ntime;
    }

    public String getResult() {
        execute();
        return result;
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

    private void execute() {
        StringBuffer b = new StringBuffer(10000);
        try {
            String sql = "update harisdiary set sn=?, subject=?, place=?, deadline=?, time=?, priority=? where sn=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nsn);
            pst.setString(2, nsub);
            pst.setString(3, nplace);
            pst.setString(4, ndeadline);
            pst.setString(5, ntime);
            pst.setString(6, npriority);
            pst.setString(7, osn);
            int numRowsChanged = pst.executeUpdate();
            if (numRowsChanged != 0) {
                b.append("<hr><h3>Record has been successfully updated</h3><hr>");
            } else {
                b.append("<hr><h3>failed to update the record</h3><hr>");
            }
            pst.close();
        } catch (SQLException e) {
            b.append("<hr><h3>SQLException caught: </h3><hr>");
        } catch (Exception e) {
//            b.append("<hr><eh3>Database query failed ...</h3><hr>");
            b.append(e);
        }
        result = b.toString();
    }
}
