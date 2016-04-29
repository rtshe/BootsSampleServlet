<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success page</title>
</head>
<body>
</body>
<%

String name=(String)request.getAttribute("name");

if(name!=null)
{
    %>
    <h1>Hi, you are welcome. ^_^ <%=name%> </h1>    
<%
}
%>
<a href="${pageContext.request.contextPath}/com.sampleservlet.controller/UserController">link</a>

</body>
</html>