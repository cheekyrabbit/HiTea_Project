<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="site.teabag.update" method="post" enctype="multipart/form-data">
	<input type="hidden" value="${sessionScope.teabag.ht_no }">
	<table id="tb_setTeabagTable">
		<tr>
			<td colspan="2">
				<hr style="width: 100%; border: #E0E0E0 solid 1px; margin: 0px;">
			</td>
		</tr>
		<tr>
			<td style="width: 80px;">
				<span class="tb_profileOptionTitle">프로필 사진</span>
			</td>
			<td>
				<input type="file" id="tb_profilePic" name="ht_profilepic">
			</td>
		</tr>
		<tr>
			<td>
				<span class="tb_profileOptionTitle">배경 사진</span>
			</td>
			<td>
				<input type="file" id="tb_bgPic1" name="ht_bgpic">
			</td>
		</tr>
		<tr>
			<td valign="top">
				<span class="tb_profileOptionTitle">소개글</span>
			</td>
			<td>
				<textarea id="tb_set_introduce" maxlength="100" name="ht_introduce">${sessionScope.teabag.ht_introduce}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<hr style="width: 100%; border: #E0E0E0 solid 1px; margin: 0px;">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<button id="tb_set_button">수정</button>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>