<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
// 	$(function() {
// 		joinSelect();
// 	});
</script>
</head>
<body>
	<div class="memberIdPwSearchDiv" align="center">
		<table class="memberIdPwSearchTable">
			<tr>
				<td valign="bottom">
				 	<form action="idSearchGo" name="idSearchForm" onsubmit="return idSearchCheck();">	
						<input type="text" class="memberIPSHm_name" name="hm_name" placeholder="이름" autocomplete="off" maxlength="10"><p>
						<input type="text" class="memberIPSHm_email" name="hm_email" placeholder="이메일" autocomplete="off" maxlength="90"><p>
						<button class="memberIPSIdSearchBut">아이디 찾기</button>
					</form>
					<div class="memberIdSearchResultDiv">${idSearchResult}</div>
				</td>
				<td>
					<form action="pwSearchGo" name="pwSearchForm" onsubmit="return pwSearchCheck();">
						<input type="text" name="hm_id" class="memberIPSHm_id" placeholder="아이디" autocomplete="off" maxlength="20"><p>
						<select name="hm_pw_question" class="memberJoinStepThreeHm_pw_question"></select><p>
						<input type="text" name="hm_pw_answer" class="memberIPSHm_pw_answer" placeholder="질문 답" autocomplete="off" maxlength="50"><p>
						<button class="memberIPSPwSearchBut">비밀번호 찾기</button>
					</form>
					<div class="memberPwSearchResultDiv">${pwSearchResult}</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>