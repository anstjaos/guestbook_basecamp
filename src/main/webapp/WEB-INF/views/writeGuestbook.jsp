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
	
	function vaildate() {
		var regularExpression = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/

		var email = document.getElementById("email");
		var contents = document.getElementById("contents");
		
		if(email.value == "") {
			alert("이메일을 입력해주세요");
			email.focus();
			return false;
		}
		
		if(form_guestbookWrite.password.value == "") {
			alert("비밀번호를 입력해주세요");
			form_guestbookWrite.password.focus();
			return false;
		}
		
		if(contents.value == "") {
			alert("본문을 입력해주세요");
			contents.focus();
			return false;
		}
	
		if(regularExpression.test(email.value) == false) {
			alert("올바른 이메일 형태가 아닙니다");
			email.focus();
			return false;
		}
		return true;
	}
</script>
<body>
	<h1>글 등록 페이지</h1>
	<form name="form_guestbookWrite" onsubmit="return vaildate();" id="form_guestbookWrite" method="post" action="/guestbook/write" >
		<table>
			<caption>방명록 작성</caption>
			
			<tbody>
				<tr>
					<td colspan="2" class="view_text">
						<textarea rows="20" cols="100" title="내용" id="contents" name="contents"></textarea>
					</td>
				</tr>
				<tr>
					<th scope="row">이메일</th>
					<td><input type="text" id="email" name="email" size="40"></input></td>
					<th scope="row">비밀번호</th>
					<td><input type="password" name="password" size="20"></input></td>
				</tr>
			</tbody>
		</table>
		
		<input type="submit" name="submit" value="등록하기" id="submit">
		<a href="/guestbook/" class="btn" id="list">메인 화면</a>
	</form>
</body>
</html>