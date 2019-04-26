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
	<table id="teabagDataroom">
		<tr>
			<td id="tb_memberList" align="center">
				회원목록
				<input type="hidden" id="teabagJoin" value="${sessionScope.teabagJoin }">
				<input type="hidden" id="teabagLeaderId" value="${sessionScope.teabag.ht_leaderid }">
			</td>
			<c:if test="${sessionScope.teabag.ht_leaderid == sessionScope.loginMember.hm_id }">
				<td align="center" id="tb_joinList">
						<div id="tb_joinReqList" >가입수락</div>
				</td>
			</c:if>
		</tr>
		<tr>
			<td colspan="2" id="tb_memberList_tbMember">
				요기 티백원
			</td>
		</tr>
	</table>
</body>
</html>