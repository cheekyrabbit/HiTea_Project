function makeTeabagCheck() {
	var check=document.makeTeabagForm.check;
	var ht_name=document.makeTeabagForm.ht_name;
	var ht_minAge =document.makeTeabagForm.ht_minAge;
	var ht_maxAge =document.makeTeabagForm.ht_maxAge;
	
	if(check.value == 0){
		alert('공지사항 확인해 주세요.');
		return false;
	} else if(isEmpty(ht_name)|| lessThan(ht_name, 4) || $("#tb_name_overlap_result").text()=="중복" || !notContains(ht_name, " ")){
		alert("밴드 이름 확인");
		ht_name.value="";
		ht_name.focus();
		$("#tb_name_overlap_result").text("티백명 필수 입력").css("font-size", "10.5pt").css("color", "red");
		return false;
	} else if(isEmpty(ht_minAge)|| lessThan(ht_minAge, 4) || isNotNumber(ht_minAge)){
		alert("최소 연도 확인");
		ht_minAge.value="";
		ht_minAge.focus();
		return false;
	} else if(isEmpty(ht_maxAge)|| lessThan(ht_maxAge, 4) || isNotNumber(ht_maxAge)){
		alert("최대 연도 확인");
		ht_maxAge.value="";
		ht_maxAge.focus();
		return false;
	} else if((ht_maxAge.value-ht_minAge.value)<0){
		alert("년도 범위 제대로 입력");
		ht_maxAge.value="";
		ht_minAge.value="";
		ht_minAge.focus();
		return false;
	} 
}
function writeCalendarCheck() {
	var hc_start=document.writeCalendar.hc_start;
	var hc_end=document.writeCalendar.hc_end;
	var hc_title=document.writeCalendar.hc_title;
	
	if(isEmpty(hc_start)|| lessThan(hc_start, 8) || isNotNumber(hc_start)){
		alert("시작 날짜 확인");
		hc_start.focus();
		return false;
	} else if(isEmpty(hc_end)|| lessThan(hc_end, 8) || isNotNumber(hc_end)){
		alert("끝나는 날짜 확인");
		hc_end.focus();
		return false;
	} else if((hc_end.value-hc_start.value)<0){
		alert("날짜 범위 제대로 입력");
		hc_start.focus();
		return false;
	} else if(isEmpty(hc_title)){
		alert("제목 필수 입력");
		hc_title.value="";
		hc_title.focus();
		return false;
	} 
	return true;
	
}
function writeDataroomCheck() {
	var hd_title=document.tb_dataroom.hd_title;
	var tb_photo=document.tb_dataroom.tb_photo;
	var tb_file=document.tb_dataroom.tb_file;
	
	if(isEmpty(hd_title)){
		alert("제목 필수 입력");
		hd_title.value="";
		hd_title.focus();
		return false;
	} else if(isEmpty(tb_photo)|| isNotType(tb_photo, "gif") && isNotType(tb_photo, "png") && isNotType(tb_photo, "jpeg") && isNotType(tb_photo, "jpg") ){
		alert("gif, jpeg, jpg, png 파일만 업로드 가능.");
		tb_photo.value="";
		tb_photo.focus();
		return false;
	} 
	// input 한개로 써서 파일은 유효성 검사가 안 됨;; 
	return true;
	
}
