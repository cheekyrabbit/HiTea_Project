<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.teabagJoin == 'L' }">	
		<form action="teabag.calendar.write" name="writeCalendar" onsubmit="return writeCalendarCheck();" >
				<table >
					<tr>
						<td align="left">
							<select name="hc_category" id="tb_calendar_category">
								<option>여행</option>
								<option>술자리</option>
								<option>행사</option>
								<option>생일</option>
							</select>
							<input value="${today }" name="hc_start" maxlength="8" autofocus="autofocus" class="tb_calendar_minMax">
							&nbsp;~&nbsp;&nbsp;<input value="${today }" name="hc_end" maxlength="8" class="tb_calendar_minMax">
							<br><input placeholder="제목" name="hc_title" maxlength="20" class="tb_calendar_titleContent">
							<input placeholder="내용" name="hc_content" maxlength="200" class="tb_calendar_titleContent">
							<button id="tb_set_button">등록</button>
						</td>
					</tr>
				</table>
		</form>
		<br><button id="deleteCalendarGo">일정 삭제하러 가기</button><br><br>
	</c:if>
	<div id="calendarBig"><div id=calendar></div></div>
</body>
</html>