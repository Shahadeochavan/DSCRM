<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
    <form action="UserRequestServlet" method="post">
 
        Name:<input type="text" name="userName"/><br/>
        Email:<input type="password" name="email"/><br/>
        Requirement:<input type="text" name="requirementDescription" /><br/>
        MobileNumber:<input type="text" name="mobile" /><br/>
        <input type="submit" value="Submit"/>
 
    </form>
</body>
</html>

