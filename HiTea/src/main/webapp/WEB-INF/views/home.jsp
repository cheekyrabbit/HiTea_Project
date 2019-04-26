<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HI TEA</title>
<link rel="shortcut icon" href="resources/img/member/basics/hiTea1.png">
<link rel="stylesheet" href="resources/css/member/login.css">
<link rel="stylesheet" href="resources/css/member/homePage.css">
<link rel="stylesheet" href="resources/css/member/joinStepOne.css">
<link rel="stylesheet" href="resources/css/member/joinStepTwo.css">
<link rel="stylesheet" href="resources/css/member/joinStepThree.css">
<link rel="stylesheet" href="resources/css/member/joinStepFour.css">
<link rel="stylesheet" href="resources/css/member/idpwSearch.css">
<link rel="stylesheet" href="resources/css/member/idSearch.css">
<link rel="stylesheet" href="resources/css/member/pwSearch.css">

<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="resources/js/member/jquery.js"></script>
<script type="text/javascript" src="resources/js/member/validCheck.js"></script>
<script type="text/javascript" src="resources/js/member/check.js"></script>
<script type="text/javascript" src="resources/js/member/pageMovement.js"></script>
<script type="text/javascript" src="resources/js/member/select.js"></script>
<script type="text/javascript" src="resources/js/member/joinOverlapCheck.js"></script>
<script type="text/javascript">
	$(function() {
		idOverlapCheck();
		nicknameOverlapCheck();
		joinSelect();
		emailOverlapCheck();
	});
</script>
</head>
<body>
	<jsp:include page="${loginPage }"></jsp:include> 
</body>
</html>