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

	<table class="memberMyPageFollowJSPTable">
		<tr>
			<td class="memberMyPageFollowJSPTd">
				<c:forEach var="myPageFollowResult" items="${myPagefollow}">
					<table  class="memberFollowTable" onclick="goPage('${myPageFollowResult.hm_nickname}')">					
						<tr>
							<td align="center">
								<div class="memberFollowPhotoFrontImg" style="background: url('resources/img/member/${myPageFollowResult.hm_photo_front}') center center no-repeat; background-size: auto 100%;"></div>								
								<div class="memberFollowNicknameDiv">${myPageFollowResult.hm_nickname}</div>
								<div class="memberFollowSelfIntroductionDiv" >
									${myPageFollowResult.hm_selfIntroduction}
								</div>
							</td>
						</tr>
					</table>
				</c:forEach>
				
				<c:forEach var="yourPageFollowResult" items="${yourfollow}">
			<c:choose>
				<c:when test="${yourPageFollowResult.hm_nickname == sessionScope.loginMember.hm_nickname}">
						<table class="memberFollowTable" onclick="goMyPage('${yourPageFollowResult.hm_nickname}');">				
					</c:when>
				<c:otherwise>
						<table class="memberFollowTable" onclick="goPage('${yourPageFollowResult.hm_nickname}');">					
				</c:otherwise>
			</c:choose>
						<tr>
							<td align="center">
								<div class="memberFollowPhotoFrontImg" style="background: url('resources/img/member/${yourPageFollowResult.hm_photo_front}') center center no-repeat; background-size: auto 100%;"></div>
								<div class="memberFollowNicknameDiv">${yourPageFollowResult.hm_nickname}</div>
								<div class="memberFollowSelfIntroductionDiv">${yourPageFollowResult.hm_selfIntroduction}</div>
							</td>
						</tr>
					</table>
				</c:forEach>
			</td>
		</tr>
	</table>
</body>
</html>