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
	
	function checkContents() {
		var contents = document.getElementById("contents");
		
		if(contents.value == "") {
			alert("내용을 입력해주세요");
			contents.focus();
			return false;
		}
		
		return true;
	}
</script>
	<body>
		<h1>글 수정 페이지</h1>
		<form name="form_guestbookRevise" onsubmit="return checkContents();" id="form_guestbookRevise" method="post" action="/guestbook/update" >
			<table>
				<caption>방명록 수정</caption>
				<tr>
					<td colspan="2" class="view_text">
						<textarea rows="20" cols="100" title="내용" id="contents" name="contents">${contents}</textarea>
					</td>
				</tr>
				<tr>
					<th scope="row">방명록 번호</th>
					<td>${id}</td>
					<th scope="row">이메일</th>
					<td>${email}</td>
				</tr>
			</table>
			
			<input type="submit" name="submit" value="수정하기" id="submit">
			<a href="/guestbook/" class="btn" id="list">메인 화면</a>
		</form>
	</body>
</html>