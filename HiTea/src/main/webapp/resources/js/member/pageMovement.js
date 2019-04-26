function goHome() {
	location.href = "jc";	
}


function goJoinOne() {
	location.href = "joinStepOneGo";	
}

function goJoinTwo() {
	location.href = "joinStepTwoGo";	
}

function goSearch() {
	location.href = "idpwSearchGo";	
}

function goMyPage() {
	$(".memberMyPageTd").click(function() {
		location.href = "myPageGo";					
	});
}

function goMyPageUpdatePwCheck() {
	location.href = "myPageUpdatePwCheckGo";
}

function goMyPageDeleteGo() {
	location.href = "memberDeleteGo";
}

function goMyPageWritin() {
	location.href = "myPageWritingGo";	
}

function goMyPageMoim() {
	location.href = "myPageMoimGo";	
}

function goMyPageGood() {
	location.href = "myPageGoodGo";	
}

function goMyPageFollow() {
	location.href = "myPageFollowGo";	
}

function goMyPageFollowing() {
	location.href = "myPageFollowingGo";	
}

function snsMember_YourPage() {
	$(document).on("click",".snsMember",function() {
		var hhn = $(this).find(".snsHs_hm_nicknameSpan").text();
		var hn = $(this).find(".snsHm_nicknameInput").val();
		if (hhn != hn) {
			location.href = "yourPageGo?hs_hm_nickname=" + hhn;	
			
		} else {
			location.href = "myPageGo";		
		}		
	});
}

function goMyPage() {
	location.href = "myPageGo";
}

function goPage(hn) {
	location.href = "yourPageGo?hs_hm_nickname=" + hn;	
}

function snsMember_YourPage2() {
	$(document).on("click",".etAlramDiv",function() {
		var hh = $(this).find(".etNicknameInput").val();
		location.href = "yourPageGo?hs_hm_nickname=" + hh;	
				
	});
}

function myPageWritingGo() {
	$(".memberYourPageWritingBut").click(function() {
		var hhn = $(".memberYourPageHm_nicknameSpan").text().replace(" ", "");
		location.href = "yourPageWritingGo?hs_hm_nickname=" + hhn;				
	});
}

function yourPageMoimGo() {
	$(".memberYourPageMoimBut").click(function() {
		var hhn = $(".memberYourPageHm_nicknameSpan").text().replace(" ", "");
		location.href = "yourPageMoimGo?hs_hm_nickname=" + hhn;				
	});
}

function yourPageGoodGo() {
	$(".memberYourPageGoodBut").click(function() {
		var hhn = $(".memberYourPageHm_nicknameSpan").text().replace(" ", "");
		location.href = "yourPageGoodGo?hs_hm_nickname=" + hhn;				
	});
}

function yourPageFollowGo() {
	$(".memberYourPageFollowBut").click(function() {
		var pageId = $("#pageId").val();
		var hhn = $(".memberYourPageHm_nicknameSpan").text().replace(" ", "");
		location.href = "yourPageFollowGo?hs_hm_nickname=" + hhn+"&hm_id="+pageId;				
	});
}

function yourPageFollowingGo() {
	$(".memberYourPageFollowingBut").click(function() {
		var pageId = $("#pageId").val();
		var hhn = $(".memberYourPageHm_nicknameSpan").text().replace(" ", "");
		location.href = "yourPageFollowingGo?hs_hm_nickname="+hhn+"&hm_id="+pageId;				
	});
}


function logout() {
	if (confirm("로그아웃?")) {
		location.href="logout.go";
	}
}
