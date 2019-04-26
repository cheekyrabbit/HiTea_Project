<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="memberMyPageFollowingJSPTable">
		<tr>
			<td class="memberMyPageFollowingJSPTd">
				<c:forEach var="myPageFollowingResult" items="${myPagefollowing}">
					<table  class="memberFollowingTable" onclick="goPage('${myPageFollowingResult.hm_nickname}');">					
						<tr>
							<td align="center">
								<div class="memberFollowingPhotoFrontImg" style="background: url('resources/img/member/${myPageFollowingResult.hm_photo_front}') center center no-repeat; background-size: auto 100%;"></div>
								<div class="memberFollowingNicknameDiv">${myPageFollowingResult.hm_nickname}</div>
								<div class="memberFollowingSelfIntroductionDiv">${myPageFollowingResult.hm_selfIntroduction}</div>
							</td>
						</tr>
					</table>
				</c:forEach>
				
				<c:forEach var="yourPageFollowingResult" items="${yourfollowing}">
								<c:choose>
				<c:when test="${yourPageFollowResult.hm_nickname == sessionScope.loginMember.hm_nickname}">
						<table class="memberFollowingTable" onclick="goMyPage('${yourPageFollowingResult.hm_nickname}');">				
					</c:when>
				<c:otherwise>
						<table class="memberFollowingTable" onclick="goPage('${yourPageFollowingResult.hm_nickname}');">					
				</c:otherwise>
			</c:choose>
						<tr>
							<td align="center">
								<div class="memberFollowingPhotoFrontImg" style="background: url('resources/img/member/${yourPageFollowingResult.hm_photo_front}') center center no-repeat; background-size: auto 100%;"></div>
								<div class="memberFollowingNicknameDiv">${yourPageFollowingResult.hm_nickname}</div>
								<div class="memberFollowingSelfIntroductionDiv">${yourPageFollowingResult.hm_selfIntroduction}</div>
							</td>
						</tr>
					</table>
				</c:forEach>
			</td>
		</tr>
	</table>
</body>
</html>