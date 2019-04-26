function reportClick(hr_this,hr_report_id,hr_catego) {
	var hr_text = prompt("신고 내용을 쓰시오");
	
	if (hr_text != null && hr_text != "") {
		var url = "report.reg?hr_this=";
		url +=hr_this+"&hr_report_id=";
		url +=hr_report_id+"&hr_text=";
		url +=hr_text+"&hr_catego=";
		url +=hr_catego;
		
		$.getJSON(url,function(data){
			alert("신고 완료");
		});
		
	}
}