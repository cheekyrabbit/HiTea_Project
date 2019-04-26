function scrollShowPage() {
	
	var pNo = 1;
	snsAllShowPage(pNo);
	
	

	
	$(window).scroll(function() {
		var htmlHeight = $(document).height();
		var scrollBottom =$(window).scrollTop() + $(window).height();
		
		if (scrollBottom+1 >= htmlHeight) {
			pNo++;
			snsAllShowPage(pNo);			
		}
	});
}

var login_sm_id;

function snsAllShowPage(pNo) {
	login_sm_nickname = $("#login_sm_nickname").val();
	var ssid = $("#pageId2").val();
	$.getJSON("page.go.sns?page="+pNo+"&pageId="+ssid,function(data){
		login_sm_id = $("#shm_id").val();
		
		$.each(data.snsBeans,function(i1,s){
			
			snsShowShow(i1,s);
			//////////////////////////////////////
		});			
		
	});
}
var login_sm_nickname;
function snsReAllPage() {
	login_sm_nickname = $("#hm_nickname").val();
	$(document).on("click",".snsRessA",function(){
		var hs_no = $(this).parent().find(".snsNoInput").val();
		var snsReTable = $(this).parent().parent().parent().find(".snsReTable");
		$(this).removeClass('snsRessA').text("댓글 3개 보기").attr("class","snsRessB");
		snsReTable.empty();
		$.getJSON("sns.Repl.ajax?hs_no="+hs_no,function(data){
			
			
			for (var z = 0; z < data.snsRepl.length; z++) {
				
				var snsReMainRepl = $("<span></span>").attr("class","snsReMainRepl");
				var snsreImg = $("<img>").attr("src","resources/img/member/"+data.snsRepl[z].hsr_img).attr("style","width: 30px;");
				var snsrenickname = $("<span></span>").html(data.snsRepl[z].hsr_hm_nickname+"&nbsp;");
				var snssm1 = $("<span></span>").attr("class","snssm1").attr("onclick","goYourPage();").append(snsreImg,snsrenickname);
				
				var snssm2 = $("<span></span>").text(data.snsRepl[z].hsr_txt);
				
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
				var dateAllre = snsDateYearre+"/"+snsDatemonthValuere+"/"+snsDatedayOfMonthre+"/"+snsDatehourre+":"+snsDateminutere;
				
				var snssm3 = $("<span></span>").html(dateAllre+"&nbsp;").attr("style","color: #FAC03B; font-size: 6pt;");
				
				if (login_sm_nickname == data.snsRepl[z].hsr_hm_nickname) {
					var snsredelete = $("<img>").attr("src","resources/img/sns/snsdelete.png").attr("style","width: 15px;").attr("class","srDeleteImg");;
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

function snsReAll3Page(){
	login_sm_nickname = $("#hm_nickname").val();
	$(document).on("click",".snsRessB",function(){
		var hs_no = $(this).parent().find(".snsNoInput").val();
		var snsReTable = $(this).parent().parent().parent().find(".snsReTable");
		$(this).removeClass('snsRessB').text("이전 댓글 보기").attr("class","snsRessA");
		snsReTable.empty();
		$.getJSON("sns.Repl3.ajax?hs_no="+hs_no,function(data){
			
			
			for (var z = 0; z < data.snsRepl.length; z++) {
				
				var snsReMainRepl = $("<span></span>").attr("class","snsReMainRepl");
				var snsreImg = $("<img>").attr("src","resources/img/member/"+data.snsRepl[z].hsr_img).attr("style","width: 30px;");
				var snsrenickname = $("<span></span>").html(data.snsRepl[z].hsr_hm_nickname+"&nbsp;");
				var snssm1 = $("<span></span>").attr("class","snssm1").attr("onclick","goYourPage();").append(snsreImg,snsrenickname);
				
				var snssm2 = $("<span></span>").text(data.snsRepl[z].hsr_txt);
				
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
				var dateAllre = snsDateYearre+"/"+snsDatemonthValuere+"/"+snsDatedayOfMonthre+"/"+snsDatehourre+":"+snsDateminutere;
				
				var snssm3 = $("<span></span>").html(dateAllre+"&nbsp;").attr("style","color: #FAC03B; font-size: 6pt;");
				
				if (login_sm_nickname == data.snsRepl[z].hsr_hm_nickname) {
					var snsredelete = $("<img>").attr("src","resources/img/sns/snsdelete.png").attr("style","width: 15px;").attr("class","srDeleteImg");;
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




function hartImgClicPage() {
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
