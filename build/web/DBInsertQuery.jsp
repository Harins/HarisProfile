<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Event</title>
</head>
<body>

	<%
		if (request.getParameter("sn") == null) {
	%>
	<form method="post">
            SN: <input type="text" name="sn" size="40"><br><br>
            Subject: <input type="text" name="subject" size="40"><br><br>
            Place: <input type="text" name="place" size="40"><br><br>
            Deadline: <input type="text" name="deadline" size="40"> &nbsp;&nbsp;&nbsp; (in the form of YYYY-MM-DD)<br><br>
            Time: <input type="text" name="time" size="40">&nbsp;&nbsp;&nbsp; (in the form of HH-MM-SS)<br><br>
            Priority: <input type="text" name="priority" size="40"><br><br>
            <input type="submit" value="Submit" name="B1"><br>
	</form>
	<%
		} else {
	%>
	<jsp:useBean id="cb" class="com.haris.DB.DBConnectBean" scope="session" />
	<jsp:useBean id="ib" class="com.haris.DB.DBInsertBean" scope="session" />
	<%
		ib.setConn(cb.getConn());
	%>
	<jsp:setProperty name="ib" property="*" />
	<jsp:getProperty name="ib" property="result" />
	<form action="showtable.jsp" method="post">
		<button name="button" type="submit" value="View Table">View Table</button>
	</form>
	<%
		}
	%>
<p>OR Select the Database Operations::</p><br><br>
                <a href="DBInsertQuery.jsp">Enter a SQL INSERT</a><br>
                <a href="DBSelectQuery.jsp">Enter a SQL SELECT</a><br>
                <a href="DBUpdateQuery.jsp">Enter a SQL UPDATE</a><br>
                <a href="DBDeleteQuery.jsp">Enter a SQL DELETE</a><br>
                <a href="DBCloseQuery.jsp">Close the Transaction</a>
</body>
</html>