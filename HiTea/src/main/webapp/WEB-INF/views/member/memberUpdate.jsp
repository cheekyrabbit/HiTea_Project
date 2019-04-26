<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<div class="memberUpdateDiv">
		<div class="memberUpdateTitle">내 정보</div>
		
		<form action="memberUpdate" name="memberUpdateForm" method="post" enctype="multipart/form-data" onsubmit="return memberUpdateCheck();">
			<input type="text" name="hm_id" class="memberUpdateHm_id" 
					value="${sessionScope.loginMember.hm_id}" readonly="readonly"><p>
			<input type="password" name="hm_pw" class="memberUpdateHm_pw" 
					placeholder="비밀번호"><p>
			<input type="password" name="hm_pw_check" class="memberUpdateHm_pw_check" 
					placeholder="비밀번호 확인"><p>
			<input type="text" name="hm_nickname" class="memberUpdateHm_nickname" value="${sessionScope.loginMember.hm_nickname}" 
					placeholder="닉네임" readonly="readonly"><p>
			<input type="text" name="hm_email" class="memberUpdateHm_email" value="${sessionScope.loginMember.hm_email}" 
					placeholder="이메일" readonly="readonly"><p>
			<textarea name="hm_selfIntroduction" class="memberUpdateHm_selfIntroduction" 
					class="myTextarea" placeholder="자기 소개" autocomplete="off" 
					maxlength="80">${sessionScope.loginMember.hm_selfIntroduction2}</textarea>
			
			<div class="memberUpdatePhotoArea">
				<span class="memberUpdatePhotoTitle">프로필 사진</span><br>
				<input type="file" name="hm_photo_front" class="memberMyPagePhoto_frontImgFile"><p>
				<span class="memberUpdatePhotoTitle">배경 사진</span><br>
				<input type="file" name="hm_photo_back" class="memberMyPagePhoto_backImgFile"><p>
			</div>
			
			<input type="hidden" name="hm_name" value="${sessionScope.loginMember.hm_name}" readonly="readonly"><p>
			<input type="hidden" name="hm_pw_question" value="${sessionScope.loginMember.hm_pw_question}" readonly="readonly"><p>
			<input type="hidden" name="hm_pw_answer" value="${sessionScope.loginMember.hm_pw_answer}" readonly="readonly"><p>
			
			<button class="memberUpdateBut">수정</button>
			<div class="memberUpdateResultTextDiv">${memberUpdate}</div>
		</form>
	</div>
</body>
</html>