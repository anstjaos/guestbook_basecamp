<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/HTML;charset=UTF-8" pageEncoding="UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<meta charset="EUC-KR">
<title>Redirect page</title>
</head>
<body>
	<script type="text/javascript">
		var message='${msg}';
		var returnUrl='${url}';
		alert(message);
		document.location.href=returnUrl;
	</script>
</body>
</html>