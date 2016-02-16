package com.haris.DB;

import java.sql.*;

public class DBSelectBean { 
   private String query;
   private String result;
   private Connection conn; 
   
    public DBSelectBean() {
        conn = null;
    }
    
    public void setQuery(String a) {
        query = a;
    }
    
    public void setConn(Connection a) {
        conn = a;
    }
    
    public String getResult() {
        execute();    //  Actual execution of SQL query
        return result;
    }
    
    private void execute() {
        ResultSet r;
        StringBuffer b = new StringBuffer(10000);
        try {
                Statement s = conn.createStatement();
                if(query == null){
                    query = "select * from harisdiary";
                     r = s.executeQuery(query);
                }else{
                      r = s.executeQuery(query);
                }
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
                                case Types.DATE:
                                        b.append(r.getDate(i));
                                        break;
                                case Types.TIME:
                                        b.append(r.getTime(i));
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
        result = b.toString();
        query = null;
    }
    
}

