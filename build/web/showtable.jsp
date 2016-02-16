<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display the Content of the Table</title>
</head>
<body>
	<jsp:useBean id="cb" class="com.haris.DB.DBConnectBean" scope="session" />
	<jsp:useBean id="sb" class="com.haris.DB.DBShowTableBean" scope="session" />
	<% sb.setConn(cb.getConn()); %>
	<jsp:getProperty name="sb" property="result" />
	<form action="DBSelectQuery.jsp" method="post">
            <button name="b1" type="submit" value="Back">Back to SELECT query</button>
	</form>


</body>
</html>