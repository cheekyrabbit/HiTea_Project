<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		$(function(){
			$(".memberJoinStepThreeEmailDirect").keyup(function(){
				var address = $(".memberJoinStepThreeEmailDirect").val();
				if (address.indexOf('@') != -1) {
					alert('특수문자 @ 사용 불가, 이메일 주소만 입력해주세요.');
				}
			});
		});
	</script>
</head>
<body>
	<div class="memberJoinDiv">
		<div class="memberJoinStepDiv">
			<div class="memberJoinImgDivA"><span class="memberJoinSpan">1단계<br></span><img class="memberJoinImg" src="resources/img/member/basics/circleX.png"><hr class="memberJoinHr"></div>
			<div class="memberJoinImgDivB"><span class="memberJoinSpan">2단계<br></span><img class="memberJoinImg" src="resources/img/member/basics/circleX.png"><hr class="memberJoinHr"></div>
			<div class="memberJoinImgDivC"><span class="memberJoinSpan">3단계<br></span><img class="memberJoinImg" src="resources/img/member/basics/circleO.png"><hr class="memberJoinHr"></div>
			<div class="memberJoinImgDivD"><span class="memberJoinSpan">4단계<br></span><img class="memberJoinImg" src="resources/img/member/basics/circleX.png"></div>
		</div>
		<div class="memberJoinStepThreeDiv">
			<form action="joinStepFourGo" name="joinThreeForm" method="post" onsubmit="return joinThreeCheck();">
				<input type="text" name="hm_name" class="memberJoinStepThreeHm_name" value="${member.hm_name}" placeholder="이름" autocomplete="off" maxlength="10"><p>
				
				<input type="text" name="emailId" class="memberJoinStepThreeEmailId" value="${emailId}" placeholder="이메일" autocomplete="off" maxlength="20">&nbsp;@
				<select name="emailAddress" id="memberJoinStepThreeEmailAddress" onchange="changeEmail();"></select>
				<p class="hiddenP" style="display: none;">
				<input type="hidden" name="emailDirect" class="memberJoinStepThreeEmailDirect" value="${emailDirect}" placeholder="이메일 주소" autocomplete="off"  maxlength="50">
				
				<span class="memberJoinStepThreeEmailCheck"></span><p>
			
				<select name="hm_pw_question" class="memberJoinStepThreeHm_pw_question"></select><p>
			
				<input type="text" name="hm_pw_answer" class="memberJoinStepThreePwAnswer" value="${member.hm_pw_answer}" placeholder="비밀번호 찾기 답" autocomplete="off" maxlength="50"><br>
			 
				<div class="memberJoinStepTwoInformationDiv">
 					<input type="hidden" name="hm_id" value="${member.hm_id}"><br>
					<input type="hidden" name="hm_pw" value="${member.hm_pw}"><br>
					<input type="hidden" name="hm_nickname" value="${member.hm_nickname}"><br>						
				</div>  
				<div class="memberJoinStepFourGoButDiv">
					<button class="memberJoinStepFourGoBut">다음</button>
				</div>
			</form>
		
			<form action="joinStepTwoGo" method="post">
				<div class="memberJoinStepTwoGoButBDiv">
					<button class="memberJoinStepTwoGoButB">이전</button><br>
				</div>
  				<div class="memberJoinStepTwoGoInformationDiv">
					<input type="hidden" name="hm_id" value="${member.hm_id}"><br>
					<input type="hidden" name="hm_pw" value="${member.hm_pw}"><br>
					<input type="hidden" name="hm_nickname" value="${member.hm_nickname}"><br>	
				</div>  
			</form>
		</div>
	</div>
</body>
</html>