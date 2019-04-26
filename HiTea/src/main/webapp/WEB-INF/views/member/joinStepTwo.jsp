<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
// 	$(function() {
// 		idOverlapCheck();
// 		nicknameOverlapCheck();
// 	});
</script>
</head>
<body>

	<div class="memberJoinDiv">
		<div class="memberJoinStepDiv">
			<div class="memberJoinImgDivA"><span class="memberJoinSpan">1단계<br></span><img class="memberJoinImg" src="resources/img/member/basics/circleX.png"><hr class="memberJoinHr"></div>
			<div class="memberJoinImgDivB"><span class="memberJoinSpan">2단계<br></span><img class="memberJoinImg" src="resources/img/member/basics/circleO.png"><hr class="memberJoinHr"></div>
			<div class="memberJoinImgDivC"><span class="memberJoinSpan">3단계<br></span><img class="memberJoinImg" src="resources/img/member/basics/circleX.png"><hr class="memberJoinHr"></div>
			<div class="memberJoinImgDivD"><span class="memberJoinSpan">4단계<br></span><img class="memberJoinImg" src="resources/img/member/basics/circleX.png"></div>
		</div>
		
		<div class="memberJoinStepTwoDiv" align="center">
			<form action="joinStepThreeGo" method="post" name="joinTwoForm" onsubmit="return joinTwoCheck();">
				<input type="text" name="hm_id" class="memberJoinStepTwoHm_id" value="${member.hm_id}" placeholder="아이디" autocomplete="off" maxlength="20"><br>
				<span class="memberJoinStepTwoIdCheck"></span><p>
				<input type="password" name="hm_pw" class="memberJoinStepTwoHm_pw" value="${member.hm_pw}" placeholder="비밀번호" autocomplete="off" maxlength="16"><p>
				<input type="password" name="hm_pw_check" class="memberJoinStepTwoHm_pw" value="${member.hm_pw}" placeholder="비밀번호확인" autocomplete="off" ><p>
				<input  type="text"name="hm_nickname" class="memberJoinStepTwoHm_nickname" value="${member.hm_nickname}" placeholder="닉네임" autocomplete="off" maxlength="8"><br>
				<span class="memberJoinStepTwoNicknameCheck"></span>
				<br><br>	
				<button class="memberJoinStepThreeGoBut">다음</button>
			</form>
		</div>
	</div>
</body>
</html>