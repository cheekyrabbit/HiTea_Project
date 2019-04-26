<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="memberLoginDiv">
		<div class="memberImgDiv">
 			<img class="memberImg" src="resources/img/member/basics/hiTea1.png"> 	
		</div>
		<div class="memberLoginFormDiv">
			<div class="memberLoginResultDiv">　${result}</div>
			<form action="login" method="post" class="memberLoginForm" name="loginForm" onsubmit="return loginCheck();">
				<input type="text" name="hm_id" class="memberLoginHm_id" placeholder="아이디" autocomplete="off" maxlength="20"><p>
				<input type="password" name="hm_pw" class="memberLoginHm_pw" type="password" placeholder="비밀번호" autocomplete="off"><p>
				<button class="memberLoginBtn">로그인</button> 				
 			</form>
 			<div class="memeberLoginServiceDiv">
	 			<input type="checkbox" name="hm_auto" class="memberHm_auto" type="checkbox">
	 			로그인 상태 유지
				<a class="memberLoginIdpwBtn" onclick="goSearch();">계정 찾기</a>
				 · 
				<a class="memberLoginJoinBtn" onclick="goJoinOne();">회원가입</a> 			
 			</div>
		</div>
	</div>
</body>
</html>