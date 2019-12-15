<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/HTML;charset=UTF-8" pageEncoding="UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P> ${popItList[0].id}</P>
<P> ${popItList[0].password } </P>
</body>
</html>
