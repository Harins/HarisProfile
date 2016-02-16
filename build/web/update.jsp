<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update page</title>
</head>
<body>
<jsp:useBean id="cb" class="com.haris.DB.DBConnectBean" scope="session" />
<jsp:useBean id="sb" class="com.haris.DB.DBShowTableBean" scope="session" />
<jsp:useBean id="crb" class="com.haris.DB.DBCheckRecordBean" scope="session" />
	<%
		sb.setConn(cb.getConn());
	%>
<jsp:getProperty name="sb" property="result" />
	<%  if(request.getParameter("nsn") == null)  { %>
	<form method="post">
		SN: <input type="text" name="nsn" size="40"><br><br>
                Subject: <input type="text" name="nsub" size="40"><br><br>
                Place: <input type="text" name="nplace" size="40"><br><br>
                Deadline: <input type="text" name="ndeadline" size="40"> &nbsp;&nbsp; (in the form of YYYY-MM-DD)<br><br>
                Time: <input type="text" name="ntime" size="40">&nbsp;&nbsp;&nbsp; (in the form of HH-MM-SS)<br><br>
                Priority: <input type="text" name="npriority" size="40"><br><br>
                <input type="submit" value="Submit" name="B1"><br>
	</form>

 <%  } else {  %>
	<jsp:useBean id="ub" class="com.haris.DB.DBUpdateBean" scope="session" />
	<jsp:setProperty name="ub" property="*" />
	<% ub.setConn(cb.getConn()); 
        ub.setOsn(crb.getSerialnumber());
    %>
    <jsp:getProperty name="ub" property="result" />	
    <form action="update.jsp" method="post">
	<input type="submit" value="Refresh Table" /><br>
    </form>
	
    <form action="DBUpdateQuery.jsp" method="post">
	<input type="submit" value="Update Another Record" /><br>
    </form>
    
    <form action="DBCloseQuery.jsp" method="post">
	<input type="submit" value="Close the Connection" />
    </form>
 <%  }  %>
</body>
</html>