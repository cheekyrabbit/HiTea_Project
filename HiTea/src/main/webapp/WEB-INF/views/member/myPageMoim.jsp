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
<h3 class="myPageMoimH">내가 만든 티백</h3>
<hr class="myPageMoimHr">
	<table class="memberMyPageMyTBagJSPTable">
		<tr>
			<td class="memberMyPageMyTBagJSPTd">
				<c:forEach var="myPageMyTBagResult" items="${myPageMyTBag}">
					<table  class="memberMyTBagTable" onclick="goTeabagPage('${myPageMyTBagResult.ht_no}')">
						<tr>
							<td align="center" valign="top">
								<div class="memberMyTBagPhotoFrontImg" style="background: url('resources/img/teabag/${myPageMyTBagResult.ht_profilepic}') center center no-repeat; background-size: auto 100%;"></div>
								<div class="memberMyTBagNicknameDiv">${myPageMyTBagResult.ht_name}</div>
								<div class="memberMyTBagSelfIntroductionDiv">${myPageMyTBagResult.ht_category}</div>
							</td>
						</tr>
					</table>
				</c:forEach>
				
				<c:forEach var="yourPageMyTBagResult" items="${yourPageMyTBag}">
					<table  class="memberMyTBagTable" onclick="goTeabagPage('${yourPageMyTBagResult.ht_no}')">
						<tr>
							<td align="center" valign="top">
								<div class="memberMyTBagPhotoFrontImg" style="background: url('resources/img/teabag/${yourPageMyTBagResult.ht_profilepic}') center center no-repeat; background-size: auto 100%;"></div>
								<div class="memberMyTBagNicknameTd">${yourPageMyTBagResult.ht_name}</div>
								<div class="memberMyTBagSelfIntroductionTd">${yourPageMyTBagResult.ht_category}</div>
							</td>
						</tr>
					</table>
				</c:forEach>
			</td>
		</tr>
	</table>
	
<h3 class="myPageMoimH">내가 가입한 티백</h3>
<hr class="myPageMoimHr">	
	<table class="memberMyPageAffiliatedTBagJSPTable">
		<tr>
			<td class="memberMyPageAffiliatedTBagJSPTd">
				<c:forEach var="myPageAffiliatedTBagResult" items="${myPageAffiliatedTBag}">
					<table  class="memberAffiliatedTBagTable" onclick="goTeabagPage('${myPageAffiliatedTBagResult.ht_no}')">
						<tr>
							<td align="center" valign="top">
								<img class="memberAffiliatedTBagPhotoFrontImg" src="resources/img/teabag/${myPageAffiliatedTBagResult.ht_profilepic}">
								<div class="memberAffiliatedTBagNicknameDiv">${myPageAffiliatedTBagResult.ht_name}</div>
								<div class="memberAffiliatedTBagSelfIntroductionDiv">${myPageAffiliatedTBagResult.ht_category}</div>
							</td>
						</tr>
					</table>
				</c:forEach>
				
				<c:forEach var="yourPageAffiliatedTBagResult" items="${yourPageAffiliatedTBag}">
					<table  class="memberAffiliatedTBagTable" onclick="goTeabagPage('${yourPageAffiliatedTBagResult.ht_no}')">
						<tr>
							<td align="center" valign="top">
								<img class="memberAffiliatedTBagPhotoFrontImg" src="resources/img/teabag/${yourPageAffiliatedTBagResult.ht_profilepic}">
								<div class="memberAffiliatedTBagNicknameDiv">${yourPageAffiliatedTBagResult.ht_name}</div>
								<div class="memberAffiliatedTBagSelfIntroductionDiv">${yourPageAffiliatedTBagResult.ht_category}</div>
							</td>
						</tr>
					</table>
				</c:forEach>
			</td>
		</tr>
	</table>
</body>
</html>