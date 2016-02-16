package com.haris.DB;
import java.sql.*;
public class DBDeleteBean {
    private String sn;
    private String result;
    private Connection conn;

    public DBDeleteBean() {
        conn = null;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
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
    
    private void execute(){
        StringBuffer deleting = new StringBuffer(10000);
        try{
            String sql = "delete from harisdiary where sn=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, sn);
            int numRowsChanged = pst.executeUpdate();
            if(numRowsChanged != 0){
                deleting.append("<hr><h3>Record has been deleted</h3><hr>");
            }else{
                deleting.append("<hr><h3>Unable to delete the Record</h3><hr>");
            }
            pst.close();
        }catch(SQLException e){
            deleting.append("<hr><h3>SQLException caught:</h3><hr>");
        }catch(Exception ee){
            deleting.append(ee);
        }
        result = deleting.toString();
    }
    
}
