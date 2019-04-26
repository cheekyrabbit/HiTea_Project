<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="memberDeleteDiv">
		<form action="memberDelete">
			<div class="memberDeleteContent">
				<div>회원님의 계정을 삭제 합니다. 계정을 삭제하려면 하단의 '계정 삭제' 버튼을 눌러주세요.</div>
				<div>계정 삭제를 요청한 후 이름, 이메일, 사진만 파기되고 아이디와 닉네임은 파기되지 않습니다.</div>
				<div>또한 활동한 닉네임으로 작성한 게시글과 티백에 작성한 글들은 없어지지 않습니다.</div>
			</div>
			<button class="memberDeleteBut">계정 삭제</button>
		</form>	
	</div>
</body>
</html>