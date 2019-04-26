function follower() {
	var pageId = $("#pageId").val();
	$.getJSON("follow.follower?hf_follower_id="+pageId,function(data){
		$(".memberYourPageFollowBut").html("팔로우&nbsp;"+data);
	});
}
function following() {
	var pageId = $("#pageId").val();
	$.getJSON("follow.following?hf_following_hm_id="+pageId,function(data){
		$(".memberYourPageFollowingBut").html("팔로잉&nbsp;"+data);
	});
}
function follower2() {
	var pageId = $("#pageId2").val();
	$.getJSON("follow.follower?hf_follower_id="+pageId,function(data){
		$(".memberMyPageFollowBut").html("팔로우&nbsp;"+data);
	});
}
function following2() {
	var pageId = $("#pageId2").val();
	$.getJSON("follow.following?hf_following_hm_id="+pageId,function(data){
		$(".memberMyPageFollowingBut").html("팔로잉&nbsp;"+data);
	});
}

function followCheck() {
	var shm_id = $("#shm_id").val();
	var pageId = $("#pageId").val();
	
	$.getJSON("follow.followerCheck?hf_following_hm_id="+shm_id+"&hf_follower_id="+pageId,function(data){
		if (data.follow.length == 1) {
			$(".memberYourPageMakingFriendBut").text("팔로우 중");
			$(".memberYourPageMakingFriendBut").css("background","linear-gradient(to right, #FF5A5AC8, #FF5A5A98)");
			$(".memberYourPageMakingFriendBut").mouseenter(function(){
				$(".memberYourPageMakingFriendBut").css("background","linear-gradient(to right, #FF5A5AC8, #FF5A5A98)");
			});
			$(".memberYourPageMakingFriendBut").mouseleave(function(){
				$(".memberYourPageMakingFriendBut").css("background","linear-gradient(to right, #FF5A5A98, #FF5A5A68)");
			});
		} else {
			$(".memberYourPageMakingFriendBut").text("팔로우하기");
			$(".memberYourPageMakingFriendBut").css("background","linear-gradient(to right, #455A64C8, #607D8B98)");
			$(".memberYourPageMakingFriendBut").mouseenter(function(){
				$(".memberYourPageMakingFriendBut").css("background","linear-gradient(to right, #455A64C8, #607D8B98)");
			});
			$(".memberYourPageMakingFriendBut").mouseleave(function(){
				$(".memberYourPageMakingFriendBut").css("background","linear-gradient(to right, #455A6488, #607D8B68)");
			});			
		}
	});
	
}

function followerRD() {
	var shm_id = $("#shm_id").val();
	var pageId = $("#pageId").val();
	$(".memberYourPageMakingFriendBut").click(function() {
		$.getJSON("follow.followerCheck?hf_following_hm_id="+shm_id+"&hf_follower_id="+pageId,function(data){
			if (data.follow.length == 1) {
				followerDelete(shm_id,pageId);
				$(".memberYourPageMakingFriendBut").text("팔로우하기");
				$(".memberYourPageMakingFriendBut").mouseenter(function(){
					$(".memberYourPageMakingFriendBut").css("background","linear-gradient(to right, #455A64C8, #607D8B98)");
				});
				$(".memberYourPageMakingFriendBut").mouseleave(function(){
					$(".memberYourPageMakingFriendBut").css("background","linear-gradient(to right, #455A6488, #607D8B68)");
				});
			}else {
				followerReg(shm_id,pageId);
				$(".memberYourPageMakingFriendBut").text("팔로우 중");
				$(".memberYourPageMakingFriendBut").mouseenter(function(){
					$(".memberYourPageMakingFriendBut").css("background","linear-gradient(to right, #FF5A5AC8, #FF5A5A98)");
				});
				$(".memberYourPageMakingFriendBut").mouseleave(function(){
					$(".memberYourPageMakingFriendBut").css("background","linear-gradient(to right, #FF5A5A98, #FF5A5A68)");
				});
			}
		});
		callback(function(){
			follower();
		});
	});
}

function callback(cb) {
	cb();
}

function followerReg(shm_id,pageId) {
	$.getJSON("follow.followerReg?hf_following_hm_id="+shm_id+"&hf_follower_id="+pageId,function(data){
	
	});
}
function followerDelete(shm_id,pageId) {
	$.getJSON("follow.followerDelete?hf_following_hm_id="+shm_id+"&hf_follower_id="+pageId,function(data){
	});
}

