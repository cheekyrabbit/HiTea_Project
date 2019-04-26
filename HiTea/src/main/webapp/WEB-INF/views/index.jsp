<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>HiTea</title>
	<link rel="stylesheet" href="resources/css/index.css" >
	<link rel="stylesheet" href="resources/css/site_content.css" >
	<link rel="stylesheet" href="resources/css/sns/sns.css" >
	<link rel="shortcut icon" href="resources/img/member/basics/hiTea1.png">
	<link rel="stylesheet" href="resources/css/sns/jquery.bxslider.css">
	<link rel="stylesheet" href="resources/css/seach/seach.css">
	<link rel="stylesheet" href="resources/css/alram/alram.css">
	<link rel="stylesheet" href="resources/css/teabag/makeTeabag.css">
	<link rel="stylesheet" href="resources/css/teabag/teabag2.css">
	<link rel="stylesheet" href="resources/css/teabag/teabag.css">
	<link rel="stylesheet" href="resources/css/messenger/messenger.css">
	
	<link rel="stylesheet" href="resources/css/member/myPage.css" >
	<link rel="stylesheet" href="resources/css/member/yourPage.css" >
	<link rel="stylesheet" href="resources/css/member/memberUpdatePwCheck.css" >
	<link rel="stylesheet" href="resources/css/member/memberUpdate.css" >
	<link rel="stylesheet" href="resources/css/member/memberDelete.css" >
	<link rel="stylesheet" href="resources/css/member/myPageWriting.css" >
	<link rel="stylesheet" href="resources/css/member/myPageGood.css" >
	
	<link rel="stylesheet" href="resources/css/member/myPageFollow.css" >
	<link rel="stylesheet" href="resources/css/member/myPageFollowing.css" >
	<link rel="stylesheet" href="resources/css/member/myPageMoim.css" >
	
	<script type="text/javascript" src="resources/js/teabag/teabag.js"></script>
	<script type="text/javascript" src="resources/js/teabag/validCheckLee.js"></script>
	<script type="text/javascript" src="resources/js/teabag/validCheckTeabag.js"></script>
	<script type="text/javascript" src="resources/js/teabag/go.js"></script>
	<script type="text/javascript" src="resources/js/teabag/teabagSNS.js"></script>
	<script type="text/javascript" src="resources/js/messenger/go.js"></script>
	<script type="text/javascript" src="resources/js/messenger/messenger.js"></script>
	
	<script src="https://code.jquery.com/jquery-latest.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
	<script type="text/javascript" src="resources/js/sns/snsSummon.js"></script>
	<script type="text/javascript" src="resources/js/sns/snsGo.js"></script>
	<script type="text/javascript" src="resources/js/sns/map.js"></script>
	<script type="text/javascript" src="resources/js/sns/stringBuffer.js"></script>
	<script type="text/javascript" src="resources/js/sns/fileupload.js"></script>
	<script type="text/javascript" src="resources/js/sns/snsValidCheck.js"></script>
	<script type="text/javascript" src="resources/js/sns/bxslider.js"></script>
	<script	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
	<script type="text/javascript" src="resources/js/index/index.js"></script>
	
	<script type="text/javascript" src="resources/js/sns/snsValidCheck.js"></script>
	<script type="text/javascript" src="resources/js/sns/snsShow.js"></script>
	<script type="text/javascript" src="resources/js/seach/seach.js"></script>
	<script type="text/javascript" src="resources/js/report/report.js"></script>
	<script type="text/javascript" src="resources/js/follow/follow.js"></script>
	<script type="text/javascript" src="resources/js/follow/followSNS.js"></script>
	
	<script type="text/javascript" src="resources/js/member/validCheck.js"></script>
	<script type="text/javascript" src="resources/js/member/check.js"></script>
	<script type="text/javascript" src="resources/js/member/pageMovement.js"></script>
	<script type="text/javascript" src="resources/js/member/imgFile.js"></script>
	<script type="text/javascript" src="resources/js/member/scrollTop.js"></script>
	<script type="text/javascript" src="resources/js/page/pageSNS.js"></script>
	<script type="text/javascript" src="resources/js/page/pageSNSHeart.js"></script>
	
	<script type="text/javascript">
		$(function() {
			snsDel();
			regSNSRe();
			snsRDel();
			scrollTop();
			snsMember_YourPage();
			photoPreview();
			myPageWritingGo();
			yourPageMoimGo();
			yourPageGoodGo();
			yourPageFollowGo();
			yourPageFollowingGo();
			snsMember_YourPage2();
			hartImgClic();
			snsReAll3();
			snsReAll();
			
			loginPageClick();
			teabagNameCheck();
			teabagPreview();
			tb_joinReq_pick();
			tb_dataroom_pick();
			tb_member_pick();
			getLatestTeabag();
			getJoinTeabag();
			getTeabagPageNotice();
			getJoinTeabagMore();
			getTeabagsByPopularity();
			getTeabagsByCategory();
			getTeabagsByPopularityClick();
			miniCalendarClick();
			getCalendarForMini();
			getCalendarForBig();
			tb_bbs_write();
			tb_bbs_update();
			getDataroomAll();
			goDeleteMode_TbCalendar();
			tb_dataroom_getPhoto();
			tb_member_getAllByTNo();
			
			//////
		
		});
	</script>
</head>
<body>
	<input type="hidden" value="${sessionScope.loginMember.hm_id}" id="shm_id">
	<input type="hidden" value="${sessionScope.loginMember.hm_nickname}" id="hm_nickname">
	<input type="hidden" value="${sessionScope.loginMember.hm_photo_front}" id="hm_photo_front">
	<table id="theTopTable">
		<tr>
			<td id="theTopTd" align="center">
				<table id="mainTopTable">
					<tr>
						<td style="width: 30%;">
							<img id="topLogo" src="resources/img/index/Upside_logo.png" onclick="goLogo();">
						</td>
						<td id="mainSeachTd" style="width: 47%;" >
							<form action="seach.go" name="seachForm" onsubmit="return indexSeachForm();" method="get">
								<input name="etseach" id="mainSeachInput">
								<button id="etseachButton">
									<img id="mainSeachButton" src="resources/img/index/search_icon.png" >
								</button>
							</form>
						</td>
						<td align="right" id="SiteTitleArea">
							<c:if test="${sessionScope.loginMember != null }">
								<span class="profileDiv" onclick="goMyPage()" style="background: url(resources/img/member/${sessionScope.loginMember.hm_photo_front}) center center/cover no-repeat;"></span>&nbsp;
								<span class="profileNickname" onclick="goMyPage()">${sessionScope.loginMember.hm_nickname }</span>
								<span class="siteArrow">
									▼
								</span>
								<span class="memberMyVarious"></span>
							</c:if>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>


	<table id="contentPage">
		<tr>
			<td align="center">
				<jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>