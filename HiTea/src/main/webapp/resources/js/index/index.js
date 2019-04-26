function goHome() {
	location.href = "jc";
}

function goLogo() {
	location.href = "sns.go";
}

function loginPageClick() {
	
	var summon = false;
	
	$(".siteArrow").click(function(e) {
		if (!summon) {			
			var td1 = $("<td></td>").text("내 페이지");
				td1 = td1.attr("class", "memberMyPageTd");
				td1 = td1.attr("onclick", "goMyPage();");
			var td2 = $("<td></td>").text("로그아웃");
				td2 = td2.attr("class", "memberLogoutTd");
				td2 = td2.attr("onclick", "logout();");
			
			var tr1 = $("<tr></tr>").append(td1);
			var tr2 = $("<tr></tr>").append(td2);
			
			var table = $("<table></table>").append(tr1, tr2);
				table = table.attr("class", "mmvTable");
			
			$(".memberMyVarious").append(table);
			
			var ww = $(window).width(); 
			if (e.pageX >= (ww - 80)) {
				$(".memberMyVarious").css("margin-left", "-100px");
			} else {
				$(".memberMyVarious").css("margin-left", "5px");
			}
		} else {
			$(".memberMyVarious").empty();
		}
		summon = !summon;
		
	});
}

function indexSeachForm() {
	var etseach = document.seachForm.etseach;
	etseach.value=etseach.value.trim();
	if (isEmpty(etseach)) {
		alert("검색 내용을 쓰세요");
		etseach.value="";
		etseach.focus();
		return false;
		
	}
	return true;
}