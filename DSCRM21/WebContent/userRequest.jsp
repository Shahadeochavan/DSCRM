<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>DSCRM</h1>

<form action="UserRequestServlet" method="post">
<div style="text-align:center;display: block;">
<div style="text-align: center; width: 40%;border: 1px solid grey;">
     Name: <input type="text" style="padding: 10px;margin: 5px;" name="name"><br></br>
    Email: <input type="text" style="padding: 10px;margin: 5px;" name="email"><br></br>
     Requerment: <input type="text" style="padding: 10px;margin: 5px;" name="requirementDescription"><br></br>
    mobilenumber:<input type="text" style="padding: 10px;margin: 5px;" name="mobile"><br></br>
    <input class="btn btn-default" type="submit" value="submit">
    
    <div>
    <span class="error" style="padding: 10px;margin: 5px;">${error}</span>
    </div>
</div>    
</div>    
</form>

</body>
</html>