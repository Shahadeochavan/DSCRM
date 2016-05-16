<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Request Success </title>
</head>
<body>
      %%%%%%%%   Your data inserted successfully  %%%%%%%%%%
      <%
      request.getRequestDispatcher("/update.jsp").forward(request,
              response);
      %>

</body>
</html>