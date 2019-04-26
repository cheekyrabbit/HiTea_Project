<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="memberUpdatePwCheckDiv">
		<form action="memberUpdateGo" method="post" name="memberUpdatePwCheckForm" onsubmit="return memberUpdatePwCheck();">
			<input type="hidden" name="hm_id" value="${sessionScope.loginMember.hm_id}">
			<input type="password" name="hm_pw" class="memberUpdatePwCheckHm_pw" placeholder="비밀번호" autocomplete="off" maxlength="16">
			<div class="memberUpdatePwCheckResultText">${pwCkeck}</div>			
			<button class="memberUpdatePwCheckBut">확인</button>
		</form>
	</div>
</body>
</html>