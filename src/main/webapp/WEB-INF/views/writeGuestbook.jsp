<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/HTML;charset=UTF-8" pageEncoding="UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<title>Write Guest book</title>
</head>
<script>
	history.pushState(null, null, location.href);
	window.onpopstate=function(event) {
		location.href="/guestbook/";
	};
</script>
<body>
	<h1>글 등록 페이지</h1>
</body>
</html>