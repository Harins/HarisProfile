package com.haris.DB;

import java.sql.*;

public class DBShowTableBean {

	private Connection conn;
	private String result;

	public DBShowTableBean() {
		conn = null;
	}

	public void setConn(Connection a) {
		conn = a;
	}

	public String getResult() {
		execute(); 
		return result;
	}

	private void execute() {
		StringBuffer b = new StringBuffer(10000);
		try {
			Statement s = conn.createStatement();
			ResultSet r = s.executeQuery("select * from harisdiary");
			b.append("<h3>HarisDiary Information</h3>");
			b.append("<hr><table border=\"3\"><tr>");
			ResultSetMetaData md = r.getMetaData();
			for (int i = 1; i <= md.getColumnCount(); i++)
				b.append("<th>" + md.getColumnName(i) + "</th>");
			b.append("</tr>");
			while (r.next()) {
				b.append("<tr>");
				for (int i = 1; i <= md.getColumnCount(); i++) {
					b.append("<td>");
					switch (md.getColumnType(i)) {
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
		} catch (Exception e) {
//			b.append("<hr>Database query failed ...<hr>");
		}
		result = b.toString();
	}

}
