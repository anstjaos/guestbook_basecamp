<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/HTML;charset=UTF-8" pageEncoding="UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<meta charset="EUC-KR">
	<title>Revise Guest Book</title>
</head>
<script>
	history.pushState(null, null, location.href);
	window.onpopstate=function(event) {
		location.href="/guestbook/";
	};
</script>
	<body>
		<h1>글 수정 페이지</h1>
		<form name="form_guestbookRevise" id="form_guestbookRevise" method="post" action="/guestbook/update" >
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
			
			<input type="submit" name="submit" value="수정하기" id="submit">
			<a href="/guestbook/" class="btn" id="list">메인 화면</a>
		</form>
	</body>
</html>