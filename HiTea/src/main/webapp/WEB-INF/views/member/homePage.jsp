<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<table id="goHomeTable">
		<tr>
			<td align="center">
				<img class="memberLogoImg" onclick="goHome();" src="resources/img/member/basics/home_logo.png">
			</td>
		</tr>
		<tr>
			<td>
				<jsp:include page="${homePage}"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>