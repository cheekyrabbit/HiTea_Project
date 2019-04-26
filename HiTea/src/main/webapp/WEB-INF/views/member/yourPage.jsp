<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/member/jquery.js"></script>
<script type="text/javascript">
 	$(function() {	
 		follower();
 		following();
 		followCheck();
 		followerRD();
 	});
</script>
</head>
<body>
	<input type="hidden" value="${dm.hm_id}" id="pageId">
	<input type="hidden" value="${dm.hm_id}" id="pageId2">
	
	<table class="memberYourPageUnderCoverTable" style="background-image: url('resources/img/member/${dm.hm_photo_back}')">
		<tr>
			<td></td>
		</tr>
	</table>

	<table class="memberYourPageTable">
		<tr>
			<td colspan="3">
				<div style="height: 120px;">　</div>
			</td>
		</tr>
		<tr class="YourPageTr1">
			<td rowspan="3" class="YourPageTd1">
				<div class="memberHm_photo_frontDiv" style="background: url('resources/img/member/${dm.hm_photo_front}') center center/cover no-repeat;"></div>
			</td>
			<td colspan="2">　</td>
		</tr>
		<tr class="YourPageTr2">
			<td class="YourPageTd2">
				<span class="memberYourPageHm_nicknameSpan">
					${dm.hm_nickname}
				</span>
			</td>
			<td rowspan="2" class="YourPageTd3" align="right" valign="bottom">
				<button class="memberYourPageMakingFriendBut">팔로우 하기</button>
				<button class="memberYourPageFollowBut" onclick="YourPageFollowGo();">팔로우&nbsp;0</button>
				<button class="memberYourPageFollowingBut" onclick="YourPageFollowingGo();">팔로잉&nbsp;0</button>
				<button class="reportBtn2" onclick="reportClick('${dm.hm_id}','${sessionScope.loginMember.hm_id}','사람')">신고</button>
				&nbsp;&nbsp;
			</td>
		</tr>
		<tr class="YourPageTr3">
			<td class="YourPageTd4" valign="top">
				<div class="MyPageSelfIntroductionDiv">
					${dm.hm_selfIntroduction}
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<div style="height: 21px;">　</div>
			</td>
		</tr>
	</table>
	
	<table class="memberYourPageMenuTable">
		<tr>
			<td class="YourPageMenuTd1">
				<img class="MyPageMenuIcon" src="resources/img/member/mypage_icon/sns2.png" onclick="myPageWritingGo();">
				<span class="memberYourPageWritingBut" onclick="myPageWritingGo();">게시글</span>		
			</td>
			<td class="YourPageMenuTd2">
				<img class="MyPageMenuIcon" src="resources/img/member/mypage_icon/like3_3.png" onclick="yourPageGoodGo();">		
				<span class="memberYourPageGoodBut" onclick="yourPageGoodGo();">좋아요</span>
			</td>
			<td class="YourPageMenuTd2">
				<img class="MyPageMenuIcon" src="resources/img/member/mypage_icon/teabag2.png" onclick="yourPageMoimGo();">
				<span class="memberYourPageMoimBut" onclick="yourPageMoimGo();">티백</span>
			</td>
			<td class="YourPageMenuTd2">
				<img class="MyPageMenuIcon" src="resources/img/member/mypage_icon/send_message.png" onclick="">
				<span class="memberSendMessageBut" onclick="goToChat('${dm.hm_id}', '${sessionScope.loginMember.hm_id}', '${dm.hm_nickname}', '${dm.hm_photo_front}')">메시지 보내기</span>
			</td>
		</tr>
	</table>
	
	<div class="memberYourPageJSP">
		<div class="memberYourPageIncludeDiv">	
			<jsp:include page="${myPage}"></jsp:include>
		
			<div class="memberArrowImgDiv">
				<a class="memberArrowImgA" href="#">
					<img class="memberArrowImg" src="resources/img/member/basics/atTheTop.png">
				</a>
			</div>
		</div>	
	</div>
</body>
</html>