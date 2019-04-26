<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/teabag/teabag.js"></script>
<script type="text/javascript" src="resources/js/teabag/teabagCalendar.js"></script>
<link rel="stylesheet" href="resources/css/teabag/teabagBBS.css">
<link rel="stylesheet" href="resources/css/teabag/teabagNotice.css">
<link rel="stylesheet" href="resources/css/teabag/teabagDataroom.css">
<link rel="stylesheet" href="resources/css/teabag/teabagCalendar.css">
<link rel="stylesheet" href="resources/css/teabag/teabagMember.css">
<link rel='stylesheet' href='resources/css/teabag/fullcalendar.css' />
<script src='resources/js/teabag/moment.min.js'></script>
<script src='resources/js/teabag/fullcalendar.js'></script>
<script type='text/javascript' src='resources/js/teabag/gcal.js'></script>
<style type="text/css">
	#tb_profileDiv2{
		background-image: url("resources/img/teabag/${sessionScope.teabag.ht_profilepic }");
		background-position: center center;
		background-repeat: no-repeat;
		background-size: cover;
	}
</style>
</head>
<body>

<input type="hidden" id="tb_no1" value="${sessionScope.teabag.ht_no}">
<input type="hidden" id="ht_name" value="${sessionScope.teabag.ht_name }">
<input type="hidden" id="login_sm_id" value="${sessionScope.loginMember.hm_id }">
	<table style="width: 1000px; border-spacing: 0px">
		<tr>
			<td colspan="3">
				<table class="TeabagProfileTable">
					<tr>
						<td colspan="3">
							<div id="tb_bgPic" style="background: url('resources/img/teabag/${sessionScope.teabag.ht_bgpic}') center center/cover no-repeat"></div>
						</td>
					</tr>
					<tr>
						<td class="TeabagProfileAreaTd1" rowspan="2">
							<div id="tb_profileDiv2" class="tb_profileDiv3"></div>
						</td>
						<td class="TeabagProfileAreaTd2">
							<div style="margin-top: 8px; margin-bottom: 2px;">
								${sessionScope.teabag.ht_name}
								<c:if test="${sessionScope.teabagJoin == 'L' }">
									<a href="site.teabag.set?ht_no=${sessionScope.teabag.ht_no }">
										<img class="teabag_set_img" src="resources/img/teabag/setting.png">
									</a>
								</c:if> 
							</div>
						</td>
						<td rowspan="2">
							<div class="TeabagServiceDiv">
								<c:choose>
									<c:when test="${sessionScope.teabagJoin == 'O'}">
										<button class="tb_join_btn" onclick="goLeaveTeabag(${sessionScope.teabag.ht_no})">탈퇴하기</button>
									</c:when>
									<c:when test="${sessionScope.teabagJoin == 'R'}">
								 		<button class="tb_join_btn">가입대기</button>
									</c:when>
									<c:when test="${sessionScope.teabagJoin == null}">
								 		<button class="tb_join_btn" onclick="goJoinTeabag()">가입하기</button>
									</c:when>
								</c:choose>
								<button class="tb_report_btn" onclick="reportClick('${sessionScope.teabag.ht_no}','${sessionScope.loginMember.hm_id }','모임');">신고</button>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="TeabagProfileIntroduceDiv">
								${sessionScope.teabag.ht_introduce2}							
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td style="height: 60px;">
			</td>
		</tr>
		<tr>
			<td id="tb_teabagMenu" valign="top">
				<div id="tb_teabagMenu1" align="center">
					<table class="tb_teabagMenuTable">
						<tr>
							<td>
								<img class="tb_teabagMenuImg" src="resources/img/teabag/sns1.png" onclick="goTeabagSNS()">
							</td>
							<td>
								<span class="tb_teabagMenuSpan" onclick="goTeabagSNS()">게시글</span>
							</td>
						</tr>
						<c:if test="${sessionScope.teabagJoin == 'L' || sessionScope.teabagJoin == 'O'  }">
						<tr>
							<td>
								<img class="tb_teabagMenuImg" src="resources/img/teabag/visitor_write.png" onclick="goTeabagBBS()">
							</td>
							<td>
								<span class="tb_teabagMenuSpan" onclick="goTeabagBBS()">방명록</span>
							</td>
						</tr>
						<tr>
							<td>
								<img class="tb_teabagMenuImg" src="resources/img/teabag/dataroom1.png" onclick="goTeabagDr()">
							</td>
							<td>
								<span class="tb_teabagMenuSpan" onclick="goTeabagDr()">자료실</span>
							</td>
						</tr>
						<tr>
							<td>
								<img class="tb_teabagMenuImg" src="resources/img/teabag/teabagMember1.png" onclick="goTeabagMember()">
							</td>
							<td>
								<span class="tb_teabagMenuSpan" onclick="goTeabagMember()">회원 목록</span>
							</td>
						</tr>
						</c:if>
					</table>
				</div>
			</td>
			<td align="center" valign="top" style="width: 608px;">
				<jsp:include page="${teabagContentPage}"></jsp:include>
			</td>
			<td class="calendarMiniTd" valign="top">
				<div id="mainTeabagNotice">
					<div id="teabagNoticeName">
						Teabag Notice
					</div>
					<div id="noticeSpace">
						<div id="teabagNotice" >&nbsp; ${sessionScope.teabag.ht_notice}</div>
						<c:if test="${sessionScope.teabagJoin == 'L' }">
							<div align="right" id="teabagNoticeUpdate" onclick="goUpdateNotice()"><span id="teabagNoticeUpdateSpan">수정</span></div>
						</c:if>
					</div>
					<c:if test="${sessionScope.teabagJoin == 'L' || sessionScope.teabagJoin == 'O'  }">
						<div id="calendarMini"></div>
					</c:if>
				</div>
			</td>
		</tr>
		<tr style="height: 100px;">
			<td>　</td>
		</tr>
	</table>
</body>
</html>