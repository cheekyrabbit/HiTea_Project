<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset=UTF-8">
	<title>Cotyledon Land</title>
	<link rel="stylesheet" href="resources/css/messenger/messenger.css?v=<%=System.currentTimeMillis()%>">
	<script type="text/javascript" src="resources/js/messenger/messenger.js?v=<%=System.currentTimeMillis()%>"></script>
	<script src="http://192.168.0.2:31205/socket.io/socket.io.js"></script>
	<c:choose>
		<c:when test="${param.sendTo != null}">
			<script type="text/javascript">
				$(function(){
					findFollwer();
					selectMessengerList();
					summonChat(null, null, null, null);
				});
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				$(function(){
					findFollwer();
					selectMessengerList();
				});
			</script>
		</c:otherwise>
	</c:choose>
</head>
<body>
	<c:if test="${param.sendTo != null }">
		<input type="hidden" id="gc_sendTo" value="${param.sendTo}">
		<input type="hidden" id="gc_sendFrom" value="${param.sendFrom}">
		<input type="hidden" id="gc_nickname" value="${param.nickname}">
		<input type="hidden" id="gc_image" value="${param.image}">		
	</c:if>

	<table class="SiteContentTable">
		<tr>
			<!-- site menu area -->
			<td class="SiteContentTd1">
				<table class="SiteMenuArea">
					<tr>
						<td>
							<button class="SiteMenuButton" onclick="goSNSFollow()">All</button>
						</td>
					</tr>
					<tr>
						<td>
							<button class="SiteMenuButton" onclick="goSNSFollow()">SNS</button>
						</td>
					</tr>
					<tr>
						<td>
							<button class="SiteMenuButton" onclick="goAllTeabag()">Teabag</button>
						</td>
					</tr>
				</table>
			</td>
			
			<!-- content page area -->
			<td class="SiteContentTd2" colspan="2" valign="top">
				<table id="MessengerTable">
					<tr>
						<td id="MessengerTd1" valign="top">
							<input id="loginMember" type="hidden" value="${sessionScope.loginMember.hm_id}">
							
							<!-- 대화 상대(MsgFollowList) -->
							<div class="MsgTitle1">Following</div>
							
							<table id="FindMFLTable">
								<tr>
									<td id="fmflTd">
										찾기
										<input id="FollowerNickname" placeholder="닉네임 입력">
									</td>
								</tr>
							</table>
							
							<div id="includeMFLTable">
								<c:forEach var="mf" items="${mfList}">
									<table class="mflTable" 
											onclick="checkMessengerList('${mf.hm_id}', '${sessionScope.loginMember.hm_id}');">
										<tr>
											<td class="mflTd1">
												<div class="mflImgDiv"
													style="background: url('resources/img/member/${mf.hm_photo_front}') center center no-repeat; 
															background-size: cover" ></div>
											</td>
											<td class="mflNick" align="left">${mf.hm_nickname}</td>
										</tr>
									</table>
								</c:forEach>
							</div>
						</td>
						
						<td id="MessengerTd2" valign="top">
							<!-- 개설된 대화방(MsgChatList) -->
							<div class="MsgTitle2">Chat List</div>
							<div id="refreshDiv">
								<img id="refreshIcon" onclick="refreshMsgList();" 
									src="resources/img/messenger/refresh_page.png">
							</div>
							<div id="includeMsgListTable"></div>
						</td>
					
						<td id="MessengerTd3" valign="top">
							<!-- 대화방(MsgChat) -->
							<table id="MsgChat">
								<tr>
									<td>			
										<div id="MessengerEmpty">
											<img src="resources/img/messenger/paper_plane.png">
											<p>
											Start a conversation<br>
											with your friend<br>
											or follower
										</div>									
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table><p>
			</td>
		</tr>
	</table>
	
	<div id="stbDiv">▼</div>
</body>
</html>