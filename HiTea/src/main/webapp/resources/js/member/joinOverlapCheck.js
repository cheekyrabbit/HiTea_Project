function idOverlapCheck() {
	
	$(".memberJoinStepTwoHm_id").keyup(function() {		
		var id = $(".memberJoinStepTwoHm_id").val();
		$.ajax({
			url : "idCheckJson",
			data : {
				hm_id : id
			},
			success : function(data) {
				if (data == 1) {
					$(".memberJoinStepTwoIdCheck").text("사용하고 있는 중이거나 탈퇴한 아이디입니다.");
				} else if (data == 0) {
					$(".memberJoinStepTwoIdCheck").text("");
				}

			}
		});
	});
}

function nicknameOverlapCheck() {
	$(".memberJoinStepTwoHm_nickname").keyup(function() {
		var nickname = $(".memberJoinStepTwoHm_nickname").val();
		$.ajax({
			url : "nicknameCheckJson",
			data : {
				hm_nickname : nickname
			},
			success : function(data) {
				if (data == 1) {
					$(".memberJoinStepTwoNicknameCheck").text("사용하고 있는 중이거나 탈퇴한 닉네임입니다.");
				} else if (data == 0) {
					$(".memberJoinStepTwoNicknameCheck").text("");
				}

			}
		});
	});
}

function emailOverlapCheck() {
	$("#memberJoinStepThreeEmailAddress").change(function() {
		var emailId = $(".memberJoinStepThreeEmailId").val();
		var emailAddress = $("#memberJoinStepThreeEmailAddress option:selected").val();
		var emailDirectInput = null;
		var email = null;

		if (emailAddress == '직접 입력') {
			$(".memberJoinStepThreeEmailDirect").keyup(function() {
				emailDirectInput = $(".memberJoinStepThreeEmailDirect").val();
				email = emailId + "@" + emailDirectInput;
				emailAJAX(email);
			});
		} else {
			$(".memberJoinStepThreeEmailDirect").val("");
			email = emailId + "@" + emailAddress;
			emailAJAX(email);
		}
	});	
	
	$(".memberJoinStepThreeEmailId").keyup(function() {
		var emailId = $(".memberJoinStepThreeEmailId").val();
		var emailAddress = $("#memberJoinStepThreeEmailAddress option:selected").val();
		var emailDirectInput = null;
		var email = null;

		if (emailAddress == '직접 입력') {
			$(".memberJoinStepThreeEmailDirect").keyup(function() {
				emailDirectInput = $(".memberJoinStepThreeEmailDirect").val();
				email = emailId + "@" + emailDirectInput;
				emailAJAX(email);
			});
		} else {
			$(".memberJoinStepThreeEmailDirect").val("");
			email = emailId + "@" + emailAddress;
			emailAJAX(email);
		}
	});
}

function emailAJAX(email) {
	$.ajax({
		url : "emailCheckJson",
		data : {hm_email : email}, 
		success : function(data) {
			if (data == 1) {
				$(".memberJoinStepThreeEmailCheck").text("사용하고 있는 중이거나 탈퇴한 이메일입니다.");	
				emailId.text("");
			} else if (data == 0) {
				$(".memberJoinStepThreeEmailCheck").text("");
			}
		}
	});
}

