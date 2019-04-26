function snsReWriteCheck(form) {
	var hsr_txt = form.snsReForm.hsr_txt;
	
	if (isEmpty(hsr_txt) || lessThan(hsr_txt, 30)) {
		alert("다시 입력");
		hsr_txt.focus();
		return false;
	}
	return true;
}


