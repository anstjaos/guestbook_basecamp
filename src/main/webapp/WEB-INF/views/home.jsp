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
	<button onclick="location='writeGuestbook'"> 방명록 작성 </button>
	<button onclick="location='reviseGuestbook'"> 방명록 수정</button>
	
	<table border="5" bordercolor="Lightgray" align="center">
		<tr>
			<td width="50px" align="center">email</td>
			<td align="center">내용</td>
			<td align="center">작성일</td>
			<td align="center">수정일</td>
		</tr>
		<c:forEach items="${guestbookList}" var="guestbook">
			<tr>
				<td>${guestbook.email}</td>
				<td>${guestbook.contents }</td>
				<td>${guestbook.writeTime }</td>
				<td>${guestbook.reviseTime }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
