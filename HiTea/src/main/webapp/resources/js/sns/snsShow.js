function scrollShow() {
	var pNo = 1;
	snsAllShow(pNo);

	$(window).scroll(function() {
		var htmlHeight = $(document).height();
		var scrollBottom =$(window).scrollTop() + $(window).height();
		
		if (scrollBottom+1 >= htmlHeight) {
			pNo++;
			snsAllShow(pNo);
		}
	});
}
var login_sm_id;
var login_sm_nickname;
function snsAllShow(pNo) {
	login_sm_nickname = $("#login_sm_nickname").val();
	$.getJSON("sns.page.ajax?page="+pNo,function(data){
		login_sm_id = $("#login_sm_id").val();
		$.each(data.snsBeans,function(i1,s){
			snsShowShow(i1,s);
		});	
	});
}

function snsShowShow(i1,s) {
	var photo_front = s.hs_photo_front.replace(/ /gi, "%20");
	var snsMemberImgSpan = $("<span></span>").attr("class","snsMemberImgSpan").attr("style","background: url(resources/img/member/"+photo_front+") center center no-repeat; background-size: cover;");
	var snsMemberTd1 = $("<td></td>").attr("rowspan", "2").append(snsMemberImgSpan).attr("class", "snsMemberTd1");
	
	var snsMemberNickname = $("<span></span>").text(s.hs_hm_nickname).attr("class","snsHs_hm_nicknameSpan");
	var snsMemberInput = $("<input>").attr("class","snsHm_nicknameInput").attr("value",$("#hm_nickname").val()).attr("type","hidden");
	var snsMemberTd2_1 = $("<td></td>").append(snsMemberNickname, snsMemberInput);

	if (login_sm_id == s.hs_hm_id) {
		var snsButtonImg = $("<img>").attr("src","resources/img/sns/close.png").attr("class","snsDButtonImg");
		var snsNoInput = $("<input>").attr("class","snsNoInput").attr("value",s.hs_no).attr("type","hidden");
		var snsButton2 = $("<span></span>").attr("class","snsButton2").append(snsButtonImg, snsNoInput);
		
		snsMemberImgSpan = snsMemberImgSpan.attr("onclick", "goMyPage()");
		snsMemberNickname = snsMemberNickname.attr("onclick", "goMyPage()");
	}else {
		var snsButton2 = $("<span></span>");
		
		snsMemberImgSpan = snsMemberImgSpan.attr("onclick", "goPage('"+ s.hs_hm_nickname + "')");
		snsMemberNickname = snsMemberNickname.attr("onclick", "goPage('"+ s.hs_hm_nickname + "')");
	}
	var snsMemberTd3 = $("<td></td>").attr("rowspan", "2").append(snsButton2).attr("class", "snsMemberTd3").attr("align", "center");
	var snsMemberTr1_1 = $("<tr></tr>").append(snsMemberTd1, snsMemberTd2_1, snsMemberTd3);

	///////////////////////////////////////////////////
	// snsDate
	var snsDateYear = s.hs_date.year;
	var snsDatemonthValue = s.hs_date.monthValue;
	if (s.hs_date.monthValue < 10) {
		snsDatemonthValue = "0"+s.hs_date.monthValue;
	}
	var snsDatedayOfMonth = s.hs_date.dayOfMonth;
	if (s.hs_date.dayOfMonth < 10) {
		snsDatedayOfMonth = "0"+s.hs_date.dayOfMonth;
	}
	var snsDatehour = s.hs_date.hour;
	if (s.hs_date.hour < 10) {
		s.hs_date.hour = "0"+s.hs_date.hour;
	}
	var snsDateminute = s.hs_date.minute;
	if (s.hs_date.minute < 10) {
		s.hs_date.minute = "0"+s.hs_date.minute;
	}
	var dateAll = snsDateYear+"."+snsDatemonthValue+"."+snsDatedayOfMonth+"("+snsDatehour+":"+snsDateminute+")";
	var snsMemberTd2_2 = $("<td></td>").text(dateAll).attr("class", "snsDate");
	
	var snsMemberTr1_2 = $("<tr></tr>").append(snsMemberTd2_2);

	///////////////////////////////////////////////////
	var text = s.hs_txt;
		text = text.replace(/\n/gi, '<br>');
	var snsTxt = $("<div></div>").attr("class","snsTxt").attr("name","hs_txt").html(text);
	var snsTxtTd = $("<td></td>").attr("class","snsTxtTd").attr("align","center").attr("colspan","3").append(snsTxt);
	var snsTxtTdTr = $("<tr></tr>").append(snsTxtTd);
	
	///////////////////////////////////////////////////
	var snsTxt2Td = $("<td></td>").attr("class","snsTxt2Td").attr("colspan","3");
	for (var x = 0; x < s.s_hashs.length; x++) {
		var fHash = s.s_hashs[x].hhash_text;
		if (fHash.charAt(0)=="#") {
			var hameSNSHashA = $("<a></a>").attr("href", "seach.go?etseach="+s.s_hashs[x].hhash_text.substring(1)).append(s.s_hashs[x].hhash_text);
			var homeSNSHash = $("<span></span>").attr("class","snsHashTag").text(" ").append(hameSNSHashA);
			snsTxt2Td.append(homeSNSHash);		
		}
	}
	var snsTxt2TdTr = $("<tr></tr>").append(snsTxt2Td);
	
	///////////////////////////////////////////////////
	var snsTxt3Td = $("<td></td>").attr("class","snsTxt3Td").attr("colspan","3");
	for (var x = 0; x < s.s_hashs.length; x++) {
		var fHash = s.s_hashs[x].hhash_text;
		if (fHash.charAt(0)=="!") {
			var hameSNSHashA = $("<a></a>").attr("onclick", "teabagHashGo('"+s.s_hashs[x].hhash_text.substring(1)+"')").append(s.s_hashs[x].hhash_text);
			var homeSNSHash = $("<span></span>").attr("class","teabagHashTag").text(" ").append(hameSNSHashA);
			snsTxt3Td.append(homeSNSHash);		
		}
	}
	var snsTxt3TdTr = $("<tr></tr>").append(snsTxt3Td);
	
	///////////////////////////////////////////////////
	var snsFileTd = $("<td></td>").attr("align","center").attr("colspan","3");
	
	if (s.s_files.length != 0) {
		var snsbxslider = $("<div></div>").attr("class","snsbxslider").attr("align","center").attr("style","width: 100%;");
		for (var y = 0; y <s.s_files.length; y++) {
			if (s.s_files[y].hfile_img == 'X' || s.s_files[y].hfile_video == 'X') {
				var snsfileImg = $("<img>").attr("style","max-width: 80%; min-width:50%; height: 80%;").attr("src","resources/img/sns/file.png");
				var snsb = $("<div></div>").attr("class","snsb").append(snsfileImg);
			}else {
				if (s.s_files[y].hfile_img == 'no') {
					var snsfileVideo = $("<video></video>").attr("style","max-width: 80%; min-width:50%; height: 100%;").attr("src","resources/img/sns/"+s.s_files[y].hfile_video).attr("controls","controls");
					var snsb = $("<div></div>").attr("class","snsb").append(snsfileVideo);
				}else {
					var snsfileImg = $("<img>").attr("style","max-width: 80%; min-width:50%; height: 100%;").attr("src","resources/img/sns/"+s.s_files[y].hfile_img);
					var snsb = $("<div></div>").attr("class","snsb").append(snsfileImg);					
				}
			}
			snsbxslider.append(snsb);
		}
		snsFileTd.append(snsbxslider);
	}else {
		var snsbxslider = $("<div></div>").attr("align","center").attr("style","width: 100%;");
		snsFileTd.append(snsbxslider);
	}
	var snsFileTr = $("<tr></tr>").append(snsFileTd);
	
	/////////////////////////////////////////////////
	var heartCheck = "heart.png";
	
	if ( s.s_harts != null) {
		for (var i = 0; i < s.s_harts.length; i++) {
			if (s.s_harts[i].hh_heart_hm_id ==  login_sm_id) {
				heartCheck = "heartOk.png";
			}
		}
	}
	var snsHeartNoInput = $("<input>").attr("class","snsHeartNoInput").attr("type","hidden").attr("value",s.hs_no);
	var snsHeartIdInput = $("<input>").attr("class","snsHeartIdInput").attr("type","hidden").attr("value",s.hs_hm_id);

	var snsHeartImg = $("<img>").attr("class","heartImg").attr("src","resources/img/sns/"+heartCheck);;
	var snsHeartLength = $("<span></span>").attr("class","heartCount").text("("+s.s_harts.length+")");
	var snsReportBtn = $("<button></button>").attr("class", "reportBtn").text("신고").attr("onclick","reportClick('"+s.hs_no+"','"+login_sm_id+"','"+"글"+"')");
	var snsReportS =  $("<span></span>").html("&nbsp;").append(snsReportBtn);
	
	var snsHRTd = $("<td></td>").attr("colspan","3").append(snsHeartNoInput, snsHeartIdInput, snsHeartImg, snsHeartLength, snsReportS);
		snsHRTd = snsHRTd.attr("class", "snsHRTd");
	var snsHRTr = $("<tr></tr>").append(snsHRTd);
	
	///////////////////////////////////////////////
	var hsr_hs_no = $("<input>").attr("value",s.hs_no).attr("name","hsr_hs_no").attr("type","hidden").attr("class","hsr_hs_no");
	var snsReInput = $("<input>").attr("class","snsReInput").attr("name","hsr_txt").attr("placeholder","댓글 작성, 30자 이내로 쓰세요");
	var snsReButton = $("<button></button>").attr("class","snsReButton").text("등록");
	var snsReInputTd = $("<td></td>").attr("class","snsReInputTd").attr("style","width: 50%;").attr("colspan","3").append(hsr_hs_no,snsReInput,snsReButton);
	var snsReTr = $("<tr></tr>").append(snsReInputTd);
	
	//////////////////////////////////////////////
	var snsReTable = $("<td></td>").attr("class","snsReTable").attr("colspan","3");
	for (var z = 0; z < s.s_repls.length; z++) {
		var snsReMainRepl = $("<span></span>").attr("class","snsReMainRepl");
		var snsreImgSpan = $("<span></span>").attr("class","snsreImgSpan").attr("style","background: url(resources/img/member/"+s.s_repls[z].hsr_img+") center center no-repeat; background-size: cover;");
		var snsrenickname = $("<span></span>").html(s.s_repls[z].hsr_hm_nickname+"&nbsp;").attr("class","snsrenickname");
		if (login_sm_nickname == s.s_repls[z].hsr_hm_nickname) {
			var snssm1 = $("<span></span>").attr("class","snssm1").attr("onclick","goMyPage();").append(snsreImgSpan,snsrenickname);
		}else {
			var snssm1 = $("<span></span>").attr("class","snssm1").attr("onclick","goPage('"+s.s_repls[z].hsr_hm_nickname+"');").append(snsreImgSpan,snsrenickname);					
		}
		
		var snssm2 = $("<span></span>").attr("class", "snsReTxt").text(s.s_repls[z].hsr_txt);
		
		var snsDateYearre = s.s_repls[z].hsr_date.year;
		var snsDatemonthValuere = s.s_repls[z].hsr_date.monthValue;
		if (s.s_repls[z].hsr_date.monthValue < 10) {
			snsDatemonthValuere = "0"+s.s_repls[z].hsr_date.monthValue;
		}
		var snsDatedayOfMonthre = s.s_repls[z].hsr_date.dayOfMonth;
		if (s.s_repls[z].hsr_date.dayOfMonth < 10) {
			snsDatedayOfMonthre = "0"+s.s_repls[z].hsr_date.dayOfMonth;
		}
		var snsDatehourre = s.s_repls[z].hsr_date.hour;
		if (s.s_repls[z].hsr_date.hour < 10) {
			snsDatehourre  = "0"+s.s_repls[z].hsr_date.hour;
		}
		var snsDateminutere = s.s_repls[z].hsr_date.minute;
		if (s.s_repls[z].hsr_date.minute < 10) {
			snsDateminutere = "0"+s.s_repls[z].hsr_date.minute;
			}
		var dateAllre = snsDateYearre+"."+snsDatemonthValuere+"."+snsDatedayOfMonthre+"("+snsDatehourre+":"+snsDateminutere+")";
		
		var snssm3 = $("<span></span>").html(dateAllre+"&nbsp;").attr("class", "snsReDate");
		
		if (login_sm_nickname == s.s_repls[z].hsr_hm_nickname) {
			var snsredelete = $("<img>").attr("src","resources/img/sns/close.png").attr("class","srDeleteImg");					
			var snssm5 = $("<input>").attr("class","srNoInput").attr("value",s.s_repls[z].hsr_no).attr("type","hidden");
			var snssm4 = $("<span></span>").append(snsredelete,snssm5);
			
		}else {
			var snssm4 = $("<span></span>");	
		}
		var snsrebr = $("<br>");
		snsReMainRepl.append(snssm1,snssm2,snssm3,snssm4,snsrebr);
		snsReTable.prepend(snsReMainRepl);
	}
	var snsResTr = $("<tr></tr>").append(snsReTable);
	
	//////////////////////////////////////
	var snsNoInput = $("<input>").attr("class","snsNoInput").attr("type","hidden").attr("value",s.hs_no);
	var snsRessA = $("<span></span>").attr("class","snsRessA").text("이전 댓글 더보기");
	var snsRessTd = $("<td></td>").attr("colspan","2").append("<br>",snsNoInput,snsRessA);
	var snsRessTr = $("<tr></tr>").append(snsRessTd);
	
	var snsMsgTable = $("<table></table>").attr("class","snsMsgTable");
		snsMsgTable.append(snsMemberTr1_1, snsMemberTr1_2, snsTxtTdTr, snsTxt2TdTr, snsTxt3TdTr, snsFileTr, snsHRTr,snsReTr, snsResTr, snsRessTr);
	var snsMainSpan = $("<span></span>").attr("class","snsMainSpan");
		snsMainSpan.append(snsMsgTable);
	$("#snsMsgTableTd").append(snsMainSpan);
	
	///////////////////////////////////
	$('.snsbxslider').bxSlider({
		slideWidth : 485,
		adaptiveHeight : false,
		slideMargin : 0,
		mode : 'fade',
		caption : false
	});
	//////////////////////////////////////
}

function snsReAll() {
	$(document).on("click",".snsRessA",function(){
		login_sm_nickname = $("#hm_nickname").val();
		var hs_no = $(this).parent().find(".snsNoInput").val();
		var snsReTable = $(this).parent().parent().parent().find(".snsReTable");
		$(this).removeClass('snsRessA').text("댓글 3개 보기").attr("class","snsRessB");
		snsReTable.empty();
		$.getJSON("sns.Repl.ajax?hs_no="+hs_no,function(data){
			
			
			for (var z = 0; z < data.snsRepl.length; z++) {
				
				var snsReMainRepl = $("<span></span>").attr("class","snsReMainRepl");
				var snsreImgSpan = $("<span></span>").attr("class","snsreImgSpan").attr("style","background: url(resources/img/member/"+data.snsRepl[z].hsr_img+") center center no-repeat; background-size: cover;");
				var snsrenickname = $("<span></span>").html(data.snsRepl[z].hsr_hm_nickname+"&nbsp;").attr("class","snsrenickname");
				if (login_sm_nickname == data.snsRepl[z].hsr_hm_nickname) {	
					var snssm1 = $("<span></span>").attr("class","snssm1").attr("onclick","goMyPage();").append(snsreImgSpan,snsrenickname);
				}else {
					var snssm1 = $("<span></span>").attr("class","snssm1").attr("onclick","goPage('"+data.snsRepl[z].hsr_hm_nickname+"');").append(snsreImgSpan,snsrenickname);					
				}
				
				var snssm2 = $("<span></span>").attr("class", "snsReTxt").text(data.snsRepl[z].hsr_txt);
				
				var snsDateYearre = data.snsRepl[z].hsr_date.year;
				var snsDatemonthValuere = data.snsRepl[z].hsr_date.monthValue;
				if (data.snsRepl[z].hsr_date.monthValue < 10) {
					snsDatemonthValuere = "0"+data.snsRepl[z].hsr_date.monthValue;
				}
				var snsDatedayOfMonthre = data.snsRepl[z].hsr_date.dayOfMonth;
				if (data.snsRepl[z].hsr_date.dayOfMonth < 10) {
					snsDatedayOfMonthre = "0"+data.snsRepl[z].hsr_date.dayOfMonth;
				}
				var snsDatehourre = data.snsRepl[z].hsr_date.hour;
				if (data.snsRepl[z].hsr_date.hour < 10) {
					snsDatehourre  = "0"+data.snsRepl[z].hsr_date.hour;
				}
				var snsDateminutere = data.snsRepl[z].hsr_date.minute;
				if (data.snsRepl[z].hsr_date.minute < 10) {
					snsDateminutere = "0"+data.snsRepl[z].hsr_date.minute;
				}
				var dateAllre = snsDateYearre+"."+snsDatemonthValuere+"."+snsDatedayOfMonthre+"("+snsDatehourre+":"+snsDateminutere+")";
				
				var snssm3 = $("<span></span>").html(dateAllre+"&nbsp;").attr("class","snsReDate");
				
				if (login_sm_nickname == data.snsRepl[z].hsr_hm_nickname) {
					var snsredelete = $("<img>").attr("src","resources/img/sns/close.png").attr("class","srDeleteImg");;
					var snssm5 = $("<input>").attr("class","srNoInput").attr("value",data.snsRepl[z].hsr_no).attr("type","hidden");
					var snssm4 = $("<span></span>").append(snsredelete,snssm5);
					
				}else {
					var snssm4 = $("<span></span>");	
				}
				var snsrebr = $("<br>");
				snsReMainRepl.append(snssm1,snssm2,snssm3,snssm4,snsrebr);
				snsReTable.prepend(snsReMainRepl);
				
			}
		});
	});
}

function snsReAll3(){
	$(document).on("click",".snsRessB",function(){
		login_sm_nickname = $("#hm_nickname").val();
		var hs_no = $(this).parent().find(".snsNoInput").val();
		var snsReTable = $(this).parent().parent().parent().find(".snsReTable");
		$(this).removeClass('snsRessB').text("이전 댓글 보기").attr("class","snsRessA");
		snsReTable.empty();
		$.getJSON("sns.Repl3.ajax?hs_no="+hs_no,function(data){
			
			
			for (var z = 0; z < data.snsRepl.length; z++) {
				var snsReMainRepl = $("<span></span>").attr("class","snsReMainRepl");
				var snsreImgSpan = $("<span></span>").attr("class","snsreImgSpan").attr("style","background: url(resources/img/member/"+data.snsRepl[z].hsr_img+") center center no-repeat; background-size: cover;");

				var snsrenickname = $("<span></span>").html(data.snsRepl[z].hsr_hm_nickname+"&nbsp;").attr("class","snsrenickname");
				if (login_sm_nickname == data.snsRepl[z].hsr_hm_nickname) {
					
					var snssm1 = $("<span></span>").attr("class","snssm1").attr("onclick","goMyPage();").append(snsreImgSpan,snsrenickname);
				}else {
					var snssm1 = $("<span></span>").attr("class","snssm1").attr("onclick","goPage('"+data.snsRepl[z].hsr_hm_nickname+"');").append(snsreImgSpan,snsrenickname);					
				}
				
				var snssm2 = $("<span></span>").attr("class","snsReTxt").text(data.snsRepl[z].hsr_txt);
				
				var snsDateYearre = data.snsRepl[z].hsr_date.year;
				var snsDatemonthValuere = data.snsRepl[z].hsr_date.monthValue;
				if (data.snsRepl[z].hsr_date.monthValue < 10) {
					snsDatemonthValuere = "0"+data.snsRepl[z].hsr_date.monthValue;
				}
				var snsDatedayOfMonthre = data.snsRepl[z].hsr_date.dayOfMonth;
				if (data.snsRepl[z].hsr_date.dayOfMonth < 10) {
					snsDatedayOfMonthre = "0"+data.snsRepl[z].hsr_date.dayOfMonth;
				}
				var snsDatehourre = data.snsRepl[z].hsr_date.hour;
				if (data.snsRepl[z].hsr_date.hour < 10) {
					snsDatehourre  = "0"+data.snsRepl[z].hsr_date.hour;
				}
				var snsDateminutere = data.snsRepl[z].hsr_date.minute;
				if (data.snsRepl[z].hsr_date.minute < 10) {
					snsDateminutere = "0"+data.snsRepl[z].hsr_date.minute;
				}
				var dateAllre = snsDateYearre+"."+snsDatemonthValuere+"."+snsDatedayOfMonthre+"("+snsDatehourre+":"+snsDateminutere+")";
				
				var snssm3 = $("<span></span>").html(dateAllre+"&nbsp;").attr("class","snsReDate");
				
				if (login_sm_nickname == data.snsRepl[z].hsr_hm_nickname) {
					var snsredelete = $("<img>").attr("src","resources/img/sns/close.png").attr("class","srDeleteImg");
					var snssm5 = $("<input>").attr("class","srNoInput").attr("value",data.snsRepl[z].hsr_no).attr("type","hidden");
					var snssm4 = $("<span></span>").append(snsredelete,snssm5);
					
				}else {
					var snssm4 = $("<span></span>");	
				}
				var snsrebr = $("<br>");
				snsReMainRepl.append(snssm1,snssm2,snssm3,snssm4,snsrebr);
				snsReTable.prepend(snsReMainRepl);
				
			}
		});
	});
}


function hashSharp() {
	$(document).on("click",".hs_txt2",function(){
		if ($(".hs_txt2").val()=="") {
			$(".hs_txt2").val("#");
			
		}
	});
	$(document).on("click",".hs_txt3",function(){
		if ($(".hs_txt3").val()=="") {
		$(".hs_txt3").val("!");
		}
	});
	
	$(".hs_txt2").keyup(function(e) {
		if (e.keyCode == "9") {
			$(".hs_txt2").val("#");
		}
		if (e.keyCode == "32") {
			var what = $(".hs_txt2").val();
			var what2 = what+"#";
			var arr = what2.split(" ");
			arr = removeDuplicatesArray(arr);
			var s = arr.join(' ');
			$(".hs_txt2").val(s);
		}
		
		if (e.keyCode == "8") {
			if ($(".hs_txt2").val() == "") {
				$(".hs_txt2").val("#");
			}
		}
	});
	$(".hs_txt3").keyup(function(e) {
		if (e.keyCode == "9") {
			$(".hs_txt3").val("!");
		}
		if (e.keyCode == "32") {
			var what = $(".hs_txt3").val();
			var what2 = what+"!";
			var arr = what2.split(" ");
			arr = removeDuplicatesArray(arr);
			var s = arr.join(' ');
			$(".hs_txt3").val(s);
		}
		
		if (e.keyCode == "8") {
			if ($(".hs_txt3").val() == "") {
				$(".hs_txt3").val("!");
			}
		}
	});
	
	
}

function removeDuplicatesArray(arr) {
    var tempArr = [];
    for (var i = 0; i < arr.length; i++) {
        if (tempArr.length == 0) {
            tempArr.push(arr[i]);
        } else {
            var duplicatesFlag = true;
            for (var j = 0; j < tempArr.length; j++) {
                if (tempArr[j] == arr[i]) {
                    duplicatesFlag = false;
                    break;
                }
            }
            if (duplicatesFlag) {
                tempArr.push(arr[i]);
            }
        }
    }
    return tempArr;
}

function hartImgClic() {
	$(document).on("click",".heartImg",function(){
		var heartImg = $(this);
		var heartCount = $(this).parent().find(".heartCount");
		var st_no2 = $(this).parent().find(".snsHeartNoInput").val();
		var st_id = $(this).parent().find(".snsHeartIdInput").val();
		var le = 0;
		$.getJSON("hart.check.img?hs_no="+st_no2+"&hs_hm_id="+login_sm_id,function(data) {
			$.getJSON("hart.check?hs_no="+st_no2,function(data3) {
				le = data.hart.length;
				if (le >= 1) {	
					$.getJSON("hart.delete?hs_no="+st_no2+"&hs_hm_id="+login_sm_id,function(data2) {
						
						var num = data3.hart.length-1;
						heartImg.attr("class","heartImg").attr("src","resources/img/sns/heart.png");
						heartCount.empty();
						heartCount.text("("+num+")");
					});
				}else {
					$.getJSON("hart.reg?hs_no="+st_no2+"&hs_hm_id="+login_sm_id+"&hs_hm_id2="+login_sm_id+"&st_id="+st_id,function(data2) {
						
						var num = data3.hart.length+1;
						heartImg.attr("class","heartImg").attr("src","resources/img/sns/heartOk.png");
						heartCount.empty();
						heartCount.text("("+num+")");
					});
				}
			});
		});
	}); 
}

function teabagHashGo(ht_name) {
	$.getJSON("site.teabag.getTeabagByName?ht_name="+ht_name,function(data){
		if (data.teabag.length == 1) {
			location.href="site.teabag.go?ht_no="+data.teabag[0].ht_no;
		}else {
			alert("존재하지 않는 티백입니다.");
		}
	});
}

function regSNSRe() {
	$(document).on("click",".snsReButton",function(){
		var d = new Date();
		var hhm_nickname = $("#hm_nickname").val();
		var hm_photo_front = $("#hm_photo_front").val();
		var snsReInput = $(this).parent().find(".snsReInput").val();
		var hsr_hs_no = $(this).parent().find(".hsr_hs_no").val();
		var snsReTable = $(this).parent().parent().parent().find(".snsReTable");
		$(this).parent().find(".snsReInput").val("");
		$.getJSON("sns.repl.reg?hsr_hs_no="+hsr_hs_no+"&hsr_txt="+ snsReInput,function(data){
			
			var sr = data.snsRepl[0]
			var snsReMainRepl = $("<span></span>").attr("class","snsReMainRepl");
			var snsreImgSpan = $("<span></span>").attr("class","snsreImgSpan").attr("style","background: url(resources/img/member/"+hm_photo_front+") center center no-repeat; background-size: cover;");

			var snsrenickname = $("<span></span>").html(hhm_nickname+"&nbsp;").attr("class","snsrenickname");
			var snssm1 = $("<span></span>").attr("class","snssm1").attr("onclick","goMyPage();").append(snsreImgSpan,snsrenickname);
			
			var snssm2 = $("<span></span>").attr("class","snssm2").text(snsReInput);
			
			var snsDateYearre = d.getFullYear();
			var snsDatemonthValuere = d.getMonth();
			if (d.getMonth() < 10) {
				snsDatemonthValuere = "0"+d.getMonth();
			}
			var snsDatedayOfMonthre = d.getDate();
			if (d.getDate() < 10) {
				snsDatedayOfMonthre = "0"+d.getDate();
			}
			var snsDatehourre = d.getHours();
			if (d.getHours() < 10) {
				snsDatehourre  = "0"+d.getHours();
			}
			var snsDateminutere = d.getMinutes();
			if (d.getMinutes() < 10) {
				snsDateminutere = "0"+d.getMinutes();
			}
			var dateAllre = snsDateYearre+"."+snsDatemonthValuere+"."+snsDatedayOfMonthre+"("+snsDatehourre+":"+snsDateminutere+")";
			
			var snssm3 = $("<span></span>").html(dateAllre+"&nbsp;").attr("class","snssm3");
			
			
			var snsredelete = $("<img>").attr("src","resources/img/sns/close.png").attr("class","srDeleteImg");
			var snssm5 = $("<input>").attr("class","srNoInput").attr("value",sr.hsr_no).attr("type","hidden");
			var snssm4 = $("<span></span>").append(snsredelete,snssm5).attr("class","snssm4");
			var snsrebr = $("<br>");
			snsReMainRepl.append(snssm1,snssm2,snssm3,snssm4,snsrebr);
			snsReTable.prepend(snsReMainRepl);
		});
	});	
}

function snsRDel() {
	$(document).on("click",".srDeleteImg",function(){
		var hsr_no = $(this).parent().find(".srNoInput").val();
		$.getJSON("sns.repl.delete?hsr_no="+hsr_no,function(){
		});
		$(this).parent().parent(".snsReMainRepl").remove();
		
	});
}

function snsDel() {
	$(document).on("click",".snsDButtonImg",function(){
		var snsDelCon = confirm("게시글을 삭제 하겠습니까?");
		if (snsDelCon) {
			
			var hs_no = $(this).parent().find(".snsNoInput").val();
			$.getJSON("sns.delete.ajax?hs_no="+hs_no,function(){
			});
			$(this).parent().parent().parent().parent(".snsMsgTable").remove();
		}
	});
}