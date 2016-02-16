<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Record Page</title>
</head>
<body>
	<jsp:useBean id="cb" class="com.haris.DB.DBConnectBean" scope="session" />
	<jsp:useBean id="sb" class="com.haris.DB.DBShowTableBean" scope="session" />
        <%
		sb.setConn(cb.getConn());
	%>
	<jsp:getProperty name="sb" property="result" />
	<h3>Enter SN for the Record you wish to update</h3>
	<%
		if (request.getParameter("sn") == null) {
	%>
	<form method="post">
                SN: <input type="text" name="sn" /><br>
                <input type="submit" value="Check primary key" />
	</form>

	<%
		} else {
	%>
	<jsp:useBean id="crb" class="com.haris.DB.DBCheckRecordBean" scope="session" />
	<%
		crb.setConn(cb.getConn());
	%>
        <%
                crb.setSerialnumber(request.getParameter("sn"));
	%>
	<%
		if (crb.getResult()) {
	%>
	<hr><h3>Record Found You Can Start Modifying It!</h3>
	<form action="update.jsp" method="post">
            <input type="submit" value="Start Record Update" />
	</form>
	<%
		} else {
	%>
	<hr><h3>SN did not found in the MySQL DataBase!</h3>
	<form action="DBUpdateQuery.jsp" method="post">
            <input type="submit" value="Try Again" />
	</form>
	<%
		}
	%>
	<% } %>
        <p>OR Select the Database Operations::</p><br>
                <a href="DBInsertQuery.jsp">Enter a SQL INSERT</a><br>
                <a href="DBSelectQuery.jsp">Enter a SQL SELECT</a><br>
                <a href="DBUpdateQuery.jsp">Enter a SQL UPDATE</a><br>
                <a href="DBDeleteQuery.jsp">Enter a SQL DELETE</a><br>
                <a href="DBCloseQuery.jsp">Close the Transaction</a>
</body>
</html>