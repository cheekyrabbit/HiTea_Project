function scrollTeabagShow() {
	
	
	var pNo = 1;
	snsAllTeabagShow(pNo);
	
	

	
	$(window).scroll(function() {
		var htmlHeight = $(document).height();
		var scrollBottom =$(window).scrollTop() + $(window).height();
		
		if (scrollBottom+1 >= htmlHeight) {
			pNo++;
			snsAllTeabagShow(pNo);
			
			
		}
	});
}
var login_sm_id;
var login_sm_nickname
function snsAllTeabagShow(pNo) {
	login_sm_nickname = $("#hm_nickname").val();
	var ht_name = $("#ht_name").val();
	$.getJSON("site.teabag.sns?page="+pNo+"&teabag="+ht_name,function(data){
		login_sm_id = $("#shm_id").val();
		$.each(data.snsBeans,function(i1,s){
			snsShowShow(i1,s);
			//////////////////////////////////////
		});	
		
		
		
		
	});
}

function snsReTeabagAll() {
	$(document).on("click",".snsRessA",function(){
		login_sm_nickname = $("#hm_nickname").val();
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

function snsReTeabagAll3(){
	$(document).on("click",".snsRessB",function(){
		login_sm_nickname = $("#hm_nickname").val();
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