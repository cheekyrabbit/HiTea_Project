<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="memberIdSearchDiv">
		<form action="jc">
			<span class="memberIdSearchSpan">아이디:&nbsp;&nbsp;${memberID.hm_id}</span><p>
			<button class="memberIdSearchLoginBut">로그인</button>
		</form>
		<button class="memberIdSearchPwSearchBut" onclick="goSearch();">비밀번호 찾기</button>
	</div>
</body>
</html> 