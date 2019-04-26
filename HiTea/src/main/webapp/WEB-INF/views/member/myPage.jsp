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
 		follower2();
 		following2();
 	});
</script>
</head>
<body>
	<input type="hidden" value="${sessionScope.loginMember.hs_hm_nickname}" id="pageId">
	<input type="hidden" value="${sessionScope.loginMember.hm_id}" id="pageId2">

	<table class="memberMyPageUnderCoverTable" style="background-image: url('resources/img/member/${sessionScope.loginMember.hm_photo_back}')">
		<tr>
			<td></td>
		</tr>
	</table>

	<table class="memberMyPageTable">
		<tr>
			<td colspan="3">
				<div style="height: 120px;">　</div>
			</td>
		</tr>
		<tr class="MyPageTr1">
			<td rowspan="3" class="MyPageTd1">
				<div class="memberHm_photo_frontDiv" style="background: url('resources/img/member/${sessionScope.loginMember.hm_photo_front}') center center/cover no-repeat;"></div>
			</td>
			<td colspan="2">　</td>
		</tr>
		<tr class="MyPageTr2">
			<td class="MyPageTd2">
				<span>
					${sessionScope.loginMember.hm_nickname}
				</span>
				
			</td>
			<td rowspan="2" class="MyPageTd3" align="right" valign="bottom">
				<button class="memberMyPageFollowBut" onclick="goMyPageFollow();">팔로우&nbsp;0</button>
				<button class="memberMyPageFollowingBut" onclick="goMyPageFollowing();">팔로잉&nbsp;0</button>
				&nbsp;&nbsp;	
			</td>
		</tr>
		<tr class="MyPageTr3">
			<td class="MyPageTd4" valign="top">
				<div class="MyPageSelfIntroductionDiv">
					${sessionScope.loginMember.hm_selfIntroduction}
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<div style="height: 21px;">　</div>
			</td>
		</tr>
	</table>
	
	<table class="memberMyPageMenuTable">
		<tr>
			<td class="MyPageMenuTd1">
				<img class="MyPageMenuIcon" src="resources/img/member/mypage_icon/sns2.png" onclick="goMyPageWritin();">
				<span class="memberMyPageWritingBut" onclick="goMyPageWritin();">내 게시글</span>
			</td>
			<td class="MyPageMenuTd2">
				<img class="MyPageMenuIcon" src="resources/img/member/mypage_icon/like3_3.png" onclick="goMyPageGood();">
				<span class="memberMyPageGoodBut" onclick="goMyPageGood();">좋아요</span>
			</td>
			<td class="MyPageMenuTd2">
				<img class="MyPageMenuIcon" src="resources/img/member/mypage_icon/teabag2.png" onclick="goMyPageMoim();">
				<span class="memberMyPageMoimBut" onclick="goMyPageMoim();">티백</span>
			</td>
			<td class="MyPageMenuTd2">
				<img class="MyPageMenuIcon" src="resources/img/member/mypage_icon/mypage3.png" onclick="goMyPageUpdatePwCheck();">
				<span class="memberMyPageMemberUpdateBut" onclick="goMyPageUpdatePwCheck();">내 정보</span>
			</td>
			<td class="MyPageMenuTd2">
				<img class="MyPageMenuIcon" src="resources/img/member/mypage_icon/signout2.png" onclick="goMyPageDeleteGo();">
				<span class="memberMyPageMemberWithdrawalBut" onclick="goMyPageDeleteGo();">탈퇴하기</span>
			</td>
		</tr>
	</table>
	
	<div class="memberMyPageJSP">
		<div class="memberMyPageIncludeDiv">	
			<jsp:include page="${myPage }"></jsp:include>
		
			<div class="memberArrowImgDiv">
				<a class="memberArrowImgA" href="#">
					<img class="memberArrowImg" src="resources/img/member/basics/atTheTop.png">
				</a>
			</div>
		</div>
	</div>	
</body>
</html>