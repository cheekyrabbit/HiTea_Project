<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		$(function() {
			snsstart();
			snsWriteSummonEvent();
			scrollShowFollow();
			hashSharp();
		});
		
		function resize(obj) {
			obj.style.height = "1px";
			obj.style.height = (12 + obj.scrollHeight) + "px";
		}
	</script>
</head>
<body>
	<input type="hidden" id="login_sm_id" value="${sessionScope.loginMember.hm_id }">
	<input type="hidden" id="login_sm_nickname" value="${sessionScope.loginMember.hm_nickname }">
	<table class="SiteContentTable">
		<tr>
			<!-- site menu area -->
			<td class="SiteContentTd1">
				<table class="SiteMenuArea">
					<tr>
						<td>
							<button class="SiteMenuButton" onclick="goSNSAll()">All</button>
						</td>
					</tr>
					<tr>
						<td>
							<button class="SiteMenuButton" onclick="goAllTeabag()">Teabag</button>
						</td>
					</tr>
					<tr>
						<td>
							<button class="SiteMenuButton" onclick="goMessenger()">Messenger</button>
						</td>
					</tr>
				</table>
			</td>
			
			<!-- content page area -->
			<td class="SiteContentTd2" align="center" valign="top">
				<table class="snsWriteTable">
					<tr>
						<td>
							<input type="hidden" name="hs_no" class="hs_no"> 
							<textarea name="hs_txt" class="hs_txt" placeholder="게시글 내용 입력"
									onkeydown="resize(this)" onkeyup="resize(this)"></textarea>
						</td>
					</tr>
					<tr>
						<td>
							<input name="hs_txt2" class="hs_txt2"  placeholder="게시글 해시태그" autocomplete="off">
						</td>
					</tr>
					<tr>
						<td>
							<input placeholder="모임 해시태그"  name="hs_txt3" class="hs_txt3" autocomplete="off">
						</td>
					</tr>
					<tr>
						<td>
							<hr style="border: #E0E0E0 dashed 1px;">
						</td>
					</tr>
					<tr>
						<td align="right">
							<img src="resources/img/sns/multifile2.png" id="snsWriteSummon">&nbsp;
							<img src="resources/img/sns/send.png" id="snsWriteButton" onclick="submitFile()">
						</td>
					</tr>
				</table>

				<div class="snsdragdiv"></div> 
				
				<br><hr style="border: #E0E0E0 solid 1px;"><br>
				
				<table class="snsMsgTableArea">
					<tr>
						<td id="snsMsgTableTd"></td>
					</tr>
				</table>
			</td>

			<!-- site right side area -->
			<td class="SiteContentTd3">
				<table id="checkBox">
					<tr>
						<td id="etAlramList">
							&nbsp;&nbsp;&nbsp;Recent Notice
						</td>
					</tr>
					<tr style="height: 6px;">
						<td></td>
					</tr>
					<tr>
						<td align="center" valign="top">
							<c:forEach var="alram" items="${alramAll }">
								
								<c:choose>
									<c:when test="${alram.halarm_txt == '새글' }">
										<div align="left" class="etAlramDiv"><span class="etAlramSpan">${alram.halarm_to_nickname }</span>님이 글을 등록 했습니다.
										<input type="hidden" value="${alram.halarm_to_nickname }" class="etNicknameInput">
										</div>
									</c:when>
									<c:when test="${alram.halarm_txt == '좋아요' }">
										<div align="left" class="etAlramDiv"><span class="etAlramSpan">${alram.halarm_to_nickname }</span>님이 내 글을 좋아합니다.
										<input type="hidden" value="${alram.halarm_to_nickname }" class="etNicknameInput">
										</div>
									</c:when>
									<c:when test="${alram.halarm_txt == '팔로우' }">
										<div align="left" class="etAlramDiv"><span class="etAlramSpan">${alram.halarm_to_nickname }</span>님이 팔로우합니다.
										<input type="hidden" value="${alram.halarm_to_nickname }" class="etNicknameInput">
										</div>
									</c:when>
								</c:choose>
								
							</c:forEach>						
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>