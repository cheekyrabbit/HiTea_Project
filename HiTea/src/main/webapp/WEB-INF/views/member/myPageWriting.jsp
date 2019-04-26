<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<script type="text/javascript">
	$(function() {
		scrollShowPage();
	});
</script>
</head>
<body>
<input type="hidden" value="${sessionScope.loginMember.hm_id }" id="et_login_hm_id">
	<input type="hidden" value="${sessionScope.loginMember.hm_nickname }" id="login_sm_nickname">

	<table>
		<tr>
			<td align="center" id="snsMsgTableTd">
			
			<td>
		</tr>
	</table>
	

</body>
</html>