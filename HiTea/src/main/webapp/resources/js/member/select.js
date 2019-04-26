function joinSelect() {
	
	setEmail();
	changeEmail();
	setFindPw();
}



function setEmail() {
	var EAddress = ['주소 입력', 'naver.com', 'gmail.com', 'daum.net', 'yahoo.co.kr', 'nate.com', 'hanmail.net', '직접 입력'];
	
	$.each(EAddress,function(i, e) {
		if (i == 0) {
			$("#memberJoinStepThreeEmailAddress").append("<option value='"+e+"'selected='selected'>"+EAddress[i]+"</option>");
		} else {			
			$("#memberJoinStepThreeEmailAddress").append("<option value='"+e+"'>"+EAddress[i]+"</option>");
		}
		$("#memberJoinStepThreeEmailAddress").css("color", "gray");

	});
}

function changeEmail() {
	if ($("#memberJoinStepThreeEmailAddress").val() == "직접 입력") {
		$(".memberJoinStepThreeEmailDirect").attr('type','text');
		$(".hiddenP").css("display", "");
	}else{
		$(".memberJoinStepThreeEmailDirect").attr('type','hidden');
		$(".hiddenP").css("display", "none");
	}	
}

function setFindPw() {
	var question = ['비밀번호 찾기 질문 선택', '생년월일?', '1~9까지 좋아하는 숫자?', '자주 쓰는 핸드폰 뒷자리?', '자신의 보물 제1호는?', '아버지의 성함은?', '어머니의 성함은?', '형제는 몇 명?', '처음 해본 게임은?', '학창시절 별명은?', '좋아하는 색깔은?'];	

	$.each(question,function(i, e) {
		$(".memberJoinStepThreeHm_pw_question").append("<option value='"+e+"'>"+question[i]+"</option>");
		$(".memberJoinStepThreeHm_pw_question").css("color", "gray");
	});
}

