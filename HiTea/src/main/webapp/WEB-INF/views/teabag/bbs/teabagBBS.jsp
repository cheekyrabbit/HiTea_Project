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
	<table id="teabagBBS">
		<tr>
			<td align="center">	
				<input type="hidden" id="hb_contentUpdate2" name="hb_no">
				<textarea placeholder="최대 180글자" id="hb_content" name="hb_content" autofocus="autofocus" maxlength="180"></textarea>
				<button id="tb_bbs_button1">등록</button>
			</td>
		</tr>
		<tr>
			<td align="center">
			<p>	
				<c:forEach var="i" begin="1" end="${pageCount }">
					<a class="tb_bbs_paging" href="teabag.bbs.page?p=${i }">${i }</a>&nbsp;&nbsp;
				</c:forEach><br><br>
				<c:forEach var="hb" items="${allBBS }">
					<input type="hidden" value="${hb.hb_no }" >
					<table class="teabagBBSs">
						<tr>
							<td class="tb_bbs_profileSpace" rowspan="3" valign="top" align="left">
								<div class="teabagBBSProfile" style="background: url(resources/img/member/${hb.hm_photo_front }) center center no-repeat; 
									background-size: cover;"></div>
							</td>
							<td class="tb_bbs_nickname">
								${hb.hm_nickname}
							</td>
							<td align="right">
								<c:if test="${hb.hb_id == sessionScope.loginMember.hm_id  }">
									<button class="tb_bbs_updateDelete" onclick="tb_bbs_goUpdate(${hb.hb_no})">수정</button>
									<button class="tb_bbs_updateDelete" onclick="goDeleteBBS(${hb.hb_no})">삭제</button>
								</c:if>
								<c:if test="${sessionScope.teabagJoin == 'L' && hb.hb_id != sessionScope.loginMember.hm_id }">
									<button class="tb_bbs_updateDelete" onclick="goDeleteBBS(${hb.hb_no})">삭제</button>
								</c:if>
							</td>
						</tr>
						<tr>
							<td colspan="2" class="tb_bbs_content">
								<div class="tb_bbs_contentDiv">${hb.hb_content}</div>
							</td>
						</tr>
						<tr>
							<td colspan="2" class="tb_bbs_date">	
								${hb.hb_date}
							</td>
						</tr>
					</table>
				</c:forEach>
			</td>
		</tr>
	</table>
</body>
</html>