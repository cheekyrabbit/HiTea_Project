<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function name() {
		$("#abc").hide();
		
			
	});
</script>
</head>
<body>
	<form action="site.teabag.make" name="makeTeabagForm" onsubmit="return makeTeabagCheck();">
	<table id="makeBandTable">
		<tr>
			<td align="center">
				<img id="makeTeabagLogoImg" src="resources/img/member/basics/home_logo.png" onclick="goAllTeabag();">
			</td>
		</tr>
		<tr>
			<td id="makeTeabagCheckTd" align="center">
				<div id="makeTeabagNoticeDiv">
					<div>1. 티백은 삭제 불가능하며, 티백명 및 분류는 추후 수정할 수 없습니다.</div>
					<div>&nbsp;&nbsp;&nbsp;(단, 티백에 티백장 본인만 남았을 경우에는 티백 삭제가 가능합니다.)</div>
					<div>2. 티백장이 티백 탈퇴를 원할 시 티백장을 위임한 후 탈퇴가 가능합니다.</div>
					<div>3. 최대 생성 가능한 티백의 개수는 10개입니다.</div><p>
					
					<div>상기 사항들을 반드시 숙지하시고 티백 생성을 신중히 결정해주시기 바랍니다.</div>
				</div>
			</td>
		</tr>
		<tr>
			<td align="right">
				<input id="abc" class="check" type="radio" name="check" value="0">
				<input class="check" type="radio" name="check" value="1">
				<span id="htCheckSpan">확인했습니다.</span>
				<br>
			</td>
		</tr>
		<tr style="height: 30px;">
			<td>　</td>
		</tr>
		<tr>
			<td align="left">
				<div class="makeTeabagOptionDiv">
					<span class="makeTeabagOptionTitle">티백명</span>				
					<input name="ht_name" placeholder="4~15글자" maxlength="15" autofocus="autofocus" autocomplete="off" class="ht_nameInput">
					<span id="tb_name_overlap_result"></span>
				</div>
			</td>
		</tr>
		<tr>
			<td align="left">
				<div class="makeTeabagOptionDiv">
					<span class="makeTeabagOptionTitle">티백 분류</span>
					<select name="ht_category" class="ht_categorySelect">
						<option>스포츠</option>
						<option>정치</option>
						<option>음악</option>
						<option>음식</option>
						<option>디자인</option>
						<option>게임</option>
						<option>연예인</option>
						<option>기타</option>
					</select> 
				</div>
			</td >
		</tr>
		<tr>
			<td align="center">
				<button id="button123">만들기</button>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>