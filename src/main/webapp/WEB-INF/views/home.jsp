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
<script>
	function checkPwd() {
		var inputPwd = prompt("비밀번호를 입력하세요"+"");
		document.getElementById("inputPwd").value = inputPwd;
	}
</script>
<body>
	<h1>
		Hello world!  
	</h1>
	<button onclick="location='writeGuestbook'"> 방명록 작성 </button>
	<button onclick="location='reviseGuestbook'"> 방명록 수정</button>
	
	<c:forEach items="${guestbookList}" var="guestbook" varStatus="status">
		<form method="post" onsubmit="return checkPwd();" id="form_${status.index}" action="/guestbook/reviseGuestbook">
			<input type="hidden" name="id" id="id" value="${guestbook.id}"></input>
			<input type="hidden" name="email" id="email" value="${guestbook.email}"></input>
			<input type="hidden" name="contents"  id="contents" value="${guestbook.contents}"></input>
			<input type="hidden" name="inputPwd" id="inputPwd"></input>
			<input type="hidden" name="password" id="password" value="${guestbook.password}"></input>
			${guestbook.id}&nbsp;${guestbook.email}&nbsp;
			<table>
				<tr>
					<td width="50px"> ${guestbook.contents }</td>
				</tr>
			</table>
			작성 시간 : ${guestbook.writeTime }<br>
			수정 시간 : ${guestbook.reviseTime }<br>
			<input type="submit" value="수정하기"/>
			<hr>
		</form> 
	</c:forEach>
</body>
</html>
