<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="memberJoinDiv">
		<div class="memberJoinStepDiv">
			<div class="memberJoinImgDivA"><span class="memberJoinSpan">1단계<br></span><img class="memberJoinImg" src="resources/img/member/basics/circleO.png"><hr class="memberJoinHr"></div>
			<div class="memberJoinImgDivB"><span class="memberJoinSpan">2단계<br></span><img class="memberJoinImg" src="resources/img/member/basics/circleX.png"><hr class="memberJoinHr"></div>
			<div class="memberJoinImgDivC"><span class="memberJoinSpan">3단계<br></span><img class="memberJoinImg" src="resources/img/member/basics/circleX.png"><hr class="memberJoinHr"></div>
			<div class="memberJoinImgDivD"><span class="memberJoinSpan">4단계<br></span><img class="memberJoinImg" src="resources/img/member/basics/circleX.png"></div>
		</div>
		<div class="memberJoinStepOneContentDiv">
			<div class="memberJoinStepOneContent">
				<div class="memberJoinStepOneContentA" align="center">가입 약관 동의</div>
				<span class="memberJoinStepOneContentB">이용약관, 개인정보 수집 및 이용, 프로모션 안내 메일 수신에 모두 동의합니다.</span><br>
				<span class="memberJoinStepOneContentB">자세한 내용은 아래를 참고하세요.</span><p>
				<span class="memberJoinStepOneContentC">&nbsp;&nbsp;&nbsp;1. 서비스 이용 안내<br></span>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;서비스 제공을 위해 필요한 최소한의 개인정보이므로 동의를 해주셔야 서비스 <br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이용이 가능합니다.<p>
		
				<span class="memberJoinStepOneContentC">&nbsp;&nbsp;&nbsp;2. 수집 목적<br></span>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• 이용자 식별, 원활한 의사소통, 부정이용 시 제재 및 기록 <br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• 회원제 서비스 제공, 문의사항 또는 불만 처리, 공지사항 전달<br> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• 서비스 이용 기록 및 통계 분석을 통한 서비스 개선 및 맞춤형 서비스 제공<br> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;• 프라이버시 보호 측면의 서비스 환경 구축<p>	

				<span class="memberJoinStepOneContentC">&nbsp;&nbsp;&nbsp;3. 수집 항목<br></span>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;아이디, 비밀번호, 닉네임, 이름, 이메일, 사진<p>	

				<span class="memberJoinStepOneContentC">&nbsp;&nbsp;&nbsp;4. 보유 기간<br></span>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;수집된 정보는 회원탈퇴 후 바로 비밀번호, 이름, 이메일, 사진만 파기되고 아이디,<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;닉네임은 파기되지 않습니다.
			</div>
			<p>
			<div align="center">
				<button class="memberJoinStepTwoGoButA" onclick="goJoinTwo();">동의</button>		
				<button class="memberHomeGoButA" onclick="history.back();">비동의</button>
			</div>
		</div>
	</div>
	
</body>
</html>