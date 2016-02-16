<%-- 
    Document   : index
    Created on : May 15, 2013, 4:04:54 PM
    Author     : haris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Haris JSP</title>
    </head>
    <body>
        <h1>Welcome to Haris Diary</h1><br>
        <p>The diary is related to the daily base information that the new events or task that has to be accomplished before <br>the due date.
            Inorder to used the software, the admin has to login first and if the connection is ok then the admin can insert new <br>information, update and even delete the 
        information from MySQL database datacenter.</p><br>
         <jsp:include page="DBLogin.jsp" flush="true" />
    </body>
</html>
