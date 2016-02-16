package com.haris.DB;

import java.sql.*;

public class DBCheckRecordBean {

    private Connection conn;
    private String sn;

    public DBCheckRecordBean() {
        conn = null;
    }
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public boolean getResult() {
        boolean dummy = execute();
        return dummy;
    }

    public String getSerialnumber() {
        return sn;
    }

    public void setSerialnumber(String sn) {
        this.sn = sn;
    }

    private boolean execute() {

        try {
            String sql = "select * from harisdiary where sn=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, sn);
            ResultSet rs = pst.executeQuery();
            rs.next();
            if (rs.getRow() != 1) {
                pst.close();
                return false;
            } else {
                pst.close();
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
