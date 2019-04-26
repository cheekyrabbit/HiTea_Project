<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		seachMemberShow();
		seachTeaBagShow();
		scrollShowSeach();

	});
</script>

</head>
<body>
	<input type="hidden" value="${sessionScope.loginMember.hm_id }"
id="et_login_hm_id">
	<input type="hidden" value="${sessionScope.loginMember.hm_nickname }" id="login_sm_nickname">

	<input type="hidden" value="${param.etseach }" id="etseach">
	<table class="SiteContentTable">
		<tr>
			<td class="SiteContentTd1">
				<table class="SiteMenuArea">
					<tr>
						<td>
							<button class="SiteMenuButton" onclick="goSNSFollow()">Follow</button>
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
			<td class="SiteContentTd2" align="center" valign="top">
				<table id="tTable">
					<tr>
						<td id="ttd"></td>
					</tr>
				</table>
				
<hr>
				<table id="etTeaBagTable">
					<tr>
						<td id="ttd2">
						
						</td>
					</tr>
				</table>				
				
<hr>
				<table id="SNSSeachTable">
					<tr>
						<td id="SNSSeachCountTd" align="left"></td>
					</tr>
					<tr>
						<td id="snsMsgTableTd" align="center">
						<br>
						</td>
					</tr>
				</table>

			</td>

		</tr>
	</table>
</body>
</html>