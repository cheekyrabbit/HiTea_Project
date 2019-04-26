<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		$(function() { 
			$("#tb_teabagAllButton2").on("click", function() {
				alert('모임 생성은 최대 10개까지 가능합니다.');
			});
			
			$(".CreateTeabagImg").mouseenter(function(){
				$(".CreateTeabagImg").attr("src", "resources/img/teabag/create_teabag2.png");
			});
			$(".CreateTeabagImg").mouseleave(function(){
				$(".CreateTeabagImg").attr("src", "resources/img/teabag/create_teabag.png");
			});
			
			$(".CreateTeabagImg2").click(function(){
				alert("더 이상 티백을 만드실 수 없습니다.");
			});
			
		});
	</script>
</head>
<body>
	<table class="SiteContentTable">
		<tr>
			<!-- site menu area -->
			<td class="SiteContentTd1">
				<table class="SiteMenuArea">
					<tr>
						<td>
							<button class="SiteMenuButton" onclick="goSNSFollow()">Follow</button>
						</td>
					</tr>
					<tr>
						<td>
							<button class="SiteMenuButton" onclick="goSNSAll()">All</button>
						</td>
					</tr>
					<tr>
						<td>
							<button class="SiteMenuButton" onclick="goMessenger()">Messenger</button>
						</td>
					</tr>
				</table>
			</td>
			
			<!-- site content area -->
			<td class="SiteContentTd2" colspan="2" align="center" valign="top">
				<table style="margin-bottom: 100px;">
					<tr>
						<td id="tb_goMaketeabag" align="center" >
							<c:choose>
								<c:when test="${sessionScope.possibleMakeB == null }">
									<img class="CreateTeabagImg" onclick="goMakeTeabag()" src="resources/img/teabag/create_teabag.png">
									<!-- 
									<a href="site.teabag.make.go" style="text-decoration: none;">
										<button id="tb_teabagAllButton">티백만들기</button>
									</a>
									 -->
								</c:when>
								<c:otherwise>
									<img class="CreateTeabagImg2" src="resources/img/teabag/create_teabag3.png">
								</c:otherwise>
							</c:choose>
						</td>
						<td id="tb_noticeTd" align="center">
							<table id="tb_noticeSpace">
								<tr>
									<td id="tb_personalNotice" align="left" valign="top">
										티백 관련 공지가 없습니다.
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center" id="tb_latestTd">
							<br><br>
							최신티백
							<hr style="border: solid 1px #274554;">
						</td>
					</tr>
					<tr>
						<td id="tb_latestTeaBagsTd" colspan="2" align="center">
							<div id="tb_latestTeaBags"></div>
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2" id="tb_joinTeaBagsTd">
							<br>
							내 티백
							<hr style="border: solid 1px #274554;">
						</td>
					</tr>
					<tr id="tb_JoinTeabagTr">
						<td colspan="2"  align="center" id="tb_JoinTeabag">
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center" id="tb_moreTeabagImgTd">
							<div id="tb_moreTeabagImg">
								<img src="resources/img/teabag/plus.png" >
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center" id="tb_teabagCategoryTableTd">
							<br><br>
							<table id="tb_teabagCategoryTable">
								<tr>
									<td class="tb_teabagCategory1" >
										전체
									</td>
									<td class="tb_teabagCategory" id="스포츠">
										스포츠
									</td>
									<td class="tb_teabagCategory" id="정치">
										정치
									</td>
									<td class="tb_teabagCategory" id="음악">
										음악
									</td>
									<td class="tb_teabagCategory" id="음식">
										음식
									</td>
									<td class="tb_teabagCategory" id="디자인">
										디자인
									</td>
									<td class="tb_teabagCategory" id="게임">
										게임
									</td>
									<td class="tb_teabagCategory" id="연예인">
										연예인
									</td>
									<td class="tb_teabagCategory" id="기타">
										기타
									</td>
								</tr>
							</table>
							<hr style="border: solid 1px #274554;">
						</td>
					</tr>
					<tr>
						<td colspan="2" id="tb_popularityTeabags" align="center"></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>