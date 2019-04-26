function loginCheck() {
	var hm_id = document.loginForm.hm_id;
	var hm_pw = document.loginForm.hm_pw;

	if (isEmpty(hm_id)) {
		alert("아이디를 입력하세요");
		hm_id.value = "";
		hm_id.focus();
		return false;
	} else if (isEmpty(hm_pw)) {
		alert("비밀번호를 입력하세요");
		hm_pw.value = "";
		hm_pw.focus();
		return false;
	} 
	return true;
}

function joinTwoCheck() {
	var hm_id = document.joinTwoForm.hm_id;
	var hm_pw = document.joinTwoForm.hm_pw;
	var hm_pw_check = document.joinTwoForm.hm_pw_check;
	var hm_nickname = document.joinTwoForm.hm_nickname;

	if (isEmpty(hm_id) || lessThan(hm_id, 2) || containsHS(hm_id) || $(".memberJoinStepTwoIdCheck").text() == "사용하고 있는 중이거나 탈퇴한 아이디 입니다.") {
		alert("아이디는 최소 2글자 최대 20글자 입니다. 아이디는 영문 소문자 및 숫자만 입력 가능하고 한글은 입력 불가능합니다.");
		hm_id.value = "";
		hm_id.value = "";
		hm_id.focus();
		return false;
		
	} 
//	else if (isEmpty(hm_pw) || lessThan(hm_pw, 3) || notContains(hm_pw, "qwertyuiopasdfghjklzxcvbnm") || notContains(hm_pw, "QWERTYUIOPASDFGHJKLZXCVBNM"))  {
	else if (isEmpty(hm_pw)){	
		alert("비밀번호는 최소 8글자 최대 16글자 입니다. 비밀번호는 대문자 소문자 하나씩 필수로 넣어야 됩니다.");
		hm_pw.value = "";
		hm_pw.value = "";
		hm_pw.focus();
		return false;
	} else if (notEquals(hm_pw, hm_pw_check)) {
		alert("비밀번호가 같지 않습니다.");
		hm_pw_check.value = "";
		hm_pw_check.value = "";
		hm_pw_check.focus();
		return false;
	} else if (isEmpty(hm_nickname) || lessThan(hm_nickname, 2) || checkSpecial(hm_nickname.value) || $(".memberJoinStepTwoNicknameCheck").text() == "사용하고 있는 중이거나 탈퇴한 닉네임 입니다.") {
		alert("닉네임은 최소 3글자 최대 8글자 입니다. 특수문자는 _와~만 사용가능 합니다");
		hm_nickname.value = "";
		hm_nickname.value = "";
		hm_nickname.focus();
		return false;
	}
	return true;
}

function joinThreeCheck() {
	var hm_name = document.joinThreeForm.hm_name;
	var emailId = document.joinThreeForm.emailId;
	var emailDirect = document.joinThreeForm.emailDirect;
	var hm_pw_answer = document.joinThreeForm.hm_pw_answer;
	
	if (isEmpty(hm_name) || lessThan(hm_name, 2) || checkSpecial2(hm_name.value)) {
		alert("이름은 최소2글자");
		hm_name.value = "";
		hm_name.value = "";
		hm_name.focus();
		return false;
	} else if (isEmpty(emailId) || $(".memberJoinStepThreeEmailCheck").text() == "사용하고 있는 중이거나 탈퇴한 이메일 입니다.") {
		alert("이메일 확인하세요");
		emailId.value = "";
		emailId.value = "";
		emailId.focus();
		return false;
	} else if (!check(email, emailDirect) || emailDirect(emailDirect)) {
		alert("비밀번호찾기때사용합니다. 메일 형식에 맞게 적으세요");
		emailDirect.value = "";
		emailDirect.value = "";
		emailDirect.focus();
		return false;
	} else if (isEmpty(hm_pw_answer)) {
		alert("질문을 선택하고 답변을 작성해주세요");
		hm_pw_answer.value = "";
		hm_pw_answer.value = "";
		hm_pw_answer.focus();
		return false;
	}
	return true;
}

function idSearchCheck() {
	var hm_name = document.idSearchForm.hm_name;
	var hm_email = document.idSearchForm.hm_email;

	if (isEmpty(hm_name)) {
		alert("이름를 입력하세요");
		hm_name.value = "";
		hm_name.focus();
		return false;
	} else if (isEmpty(hm_email)) {
		alert("이메일를 입력하세요");
		hm_email.value = "";
		hm_email.focus();
		return false;
	} 
	return true;
}

function pwSearchCheck() {
	var hm_id = document.pwSearchForm.hm_id;
	var hm_pw_answer = document.pwSearchForm.hm_pw_answer;

	if (isEmpty(hm_id)) {
		alert("아이디를 입력하세요");
		hm_id.value = "";
		hm_id.focus();
		return false;
	} else if (isEmpty(hm_pw_answer)) {
		alert("답변를 입력하세요");
		hm_pw_answer.value = "";
		hm_pw_answer.focus();
		return false;
	} 
	return true;
}

function memberUpdatePwCheck() {
	var hm_pw = document.memberUpdatePwCheckForm.hm_pw;

	if (isEmpty(hm_pw)) {
		alert("비밀번호를 입력하세요");
		hm_id.value = "";
		hm_id.focus();
		return false;
	} 
	return true;
}

//////////////////////////////////////////////////////////////////////////////
function memberUpdateCheck() {
	var hm_pw = document.memberUpdateForm.hm_pw;
	var hm_pw_check = document.memberUpdateForm.hm_pw_check;
	var hm_selfIntroduction = document.memberUpdateForm.hm_selfIntroduction;
	var hm_photo_front = document.memberUpdateForm.hm_photo_front;
	var hm_photo_back = document.memberUpdateForm.hm_photo_back;
//	if (isEmpty(hm_pw) || lessThan(hm_pw, 3) || notContains(hm_pw, "qwertyuiopasdfghjklzxcvbnm") || notContains(hm_pw, "QWERTYUIOPASDFGHJKLZXCVBNM"))  {
	if (isEmpty(hm_pw))  {
		alert("비밀번호는 최소 8글자 최대 16글자 입니다. 비밀번호는 대문자 소문자 하나씩 필수로 넣어야 됩니다.");
		hm_pw.value = "";
		hm_pw.value = "";
		hm_pw.focus();
		return false;
		
	} else if (notEquals(hm_pw, hm_pw_check)) {
		alert("비밀번호가 같지 않습니다.");
		hm_pw_check.value = "";
		hm_pw_check.value = "";
		hm_pw_check.focus();
		return false;
	} else if (isEmpty(hm_selfIntroduction)) {
		alert("자기소개를 입력하세요");
		hm_selfIntroduction.value = "";
		hm_selfIntroduction.focus();
		return false;
	}
	else if (isEmpty(hm_photo_front) && isEmpty(hm_photo_back) ) {
		return true;
	}else if(isEmpty(hm_photo_front)){
		if (isNotType(hm_photo_back, "png") && isNotType(hm_photo_back, "jpg")
				&& isNotType(hm_photo_back, "gif") && isNotType(hm_photo_back, "bmp")
				&& isNotType(hm_photo_back, "jpeg")) {
			alert("사진만 가능합니다.");
			hm_photo_back.value = "";
			return false;
		}
	}else if (isEmpty(hm_photo_back)) {
		if ( isNotType(hm_photo_front, "png") && isNotType(hm_photo_front, "jpg")
				&& isNotType(hm_photo_front, "gif") && isNotType(hm_photo_front, "bmp")
				&& isNotType(hm_photo_front, "jpeg")) {
			alert("사진만 가능합니다.");
			hm_photo_front.value = "";
			return false;
		}
	}
	
	return true;
}