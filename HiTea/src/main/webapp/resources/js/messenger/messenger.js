var socket = null;

function callback(cb) {
	cb();
}

function findFollwer() {
	var lm_id = $("#loginMember").val();
	
	$("#FollowerNickname").keyup(function(e){
		var fn = $(this).val();
		
		$("#includeMFLTable").empty();
		
		if (e.keyCode != 16 && e.keyCode != 17 && e.keyCode != 18) {			
			if (fn != null) {
				var url = "find.follower?fn=" + fn;
				$.getJSON(url, function(fms){
					$.each(fms.member, function(i, fm){				
						var div = $("<div></div>").attr("style", "background: url('resources/img/member/" + fm.hm_photo_front + "') center center no-repeat; " 
								+ "background-size: cover;");
							div = div.attr("class", "mflImgDiv");
						var td1 = $("<td></td>").append(div);
							td1 = td1.attr("class", "mflTd1");
						var td2 = $("<td></td>").text(fm.hm_nickname);
							td2 = td2.attr("class", "mflNick");
							td2 = td2.attr("align", "left");
						var tr = $("<tr></tr>").append(td1, td2);
						var table = $("<table></table>").append(tr);
							table = table.attr("class", "mflTable");
							$(table).click(function(){
								checkMessengerList(fm.hm_id, lm_id);
							});
						$("#includeMFLTable").append(table);
					});
				});
			}
		}
	});
}

function checkMessengerList(sendTo, sendFrom) {
	var url3 = "member.get?hm_id=" + sendTo;
	$.getJSON(url3, function (data3){
		summonChat(sendTo, sendFrom, data3.hm_nickname, data3.hm_photo_front);
		
		var url = "messenger.list.check.1";
		url += "?hmsl_m1=" + sendFrom + "&hmsl_m2=" + sendTo;
		$.getJSON(url, function(data){
			var d_length = Object.keys(data.msgLists).length;
			
			var url2 = "messenger.list.check.2";
			url2 += "?hmsl_m1=" + sendTo + "&hmsl_m2=" + sendFrom;
			$.getJSON(url2, function(data2){
				var d2_length = Object.keys(data2.msgLists).length;
			
				if (d_length == 0 && d2_length == 0) {
					// 메세지 목록 생성
					var url_reg = "messenger.list.reg";
					url_reg += "?hmsl_m1=" + sendFrom + "&hmsl_m2=" + sendTo;
					$.getJSON(url_reg, function(){});
				}
			});
		});
	});
}

function summonChat(sendTo, sendFrom, nickname, image) {
	if (sendTo == null) {
		sendTo = $("#gc_sendTo").val();
		sendFrom = $("#gc_sendFrom").val();
		nickname = $("#gc_nickname").val();
		image = $("#gc_image").val();		
	}
	
	var dateCheck = '20190101';
	var dCheck = false;
	var hmsl_no = null;
	
	var url = "messenger.list.real?hmsl_m1=" + sendTo + "&hmsl_m2=" + sendFrom;
	$.getJSON(url, function(data){
		hmsl_no = data.msgLists[0].hmsl_no;
		
		if (socket != null) {
			socket.disconnect();
		}
		
		socket = io.connect("http://192.168.0.2:31205");
		
		var url2 = 'http://192.168.0.2:43128/message.get?no=' + hmsl_no;
		$.getJSON(url2, function(msgs){
			$.each(msgs, function(i, msg){
				var date = msg.date;
					date = date.substr(0, 4) + date.substr(5, 2) + date.substr(8, 2); 
				if (dateCheck != date) {
					dateCheck = date;
					dCheck = true;
				} else {
					dCheck = false;
				}
				
				// ------------------------------------------------------------------------------
				chatMsg(hmsl_no, sendFrom, msg.sendFrom, msg.txt, msg.date, msg.sfDel, msg.stDel, false);
				// ------------------------------------------------------------------------------				
			});
			
			callback(function(){
				scrollEvent();
			});
		});
		
		var url3 = "http://192.168.0.2:43128/message.check?no=" + hmsl_no + "&id=" + sendFrom;
		$.getJSON(url3, function(){});
		
		$("#MsgChat").empty();
		
		var imgDiv = $("<div></div>").attr("style", "background: url('resources/img/member/" + image + "') center center no-repeat; " 
					+ "background-size: cover;");
			imgDiv = imgDiv.attr("class", "MsgChatImg");	
		var td1_1 = $("<td></td>").append(imgDiv);
			td1_1 = td1_1.attr("class", "MsgChatNameTd1");
		var div = $("<div></div>").text(nickname);
			div = div.attr("class", "MsgChatNameDiv");
		var td1_2 = $("<td></td>").append(div);
			td1_2 = td1_2.attr("class", "MsgChatNameTd2");
		var dImg = $("<img>").attr("src", "resources/img/messenger/delete.png");
			dImg = dImg.attr("class", "dImg");
			dImg = dImg.attr("onclick", "deleteMsg('"+ hmsl_no + "', '" + sendFrom + "');");
		var td1_3 = $("<td></td>").append(dImg);
			td1_3 = td1_3.attr("class", "MsgChatNameTd3");
		var tr1 = $("<tr></tr>").append(td1_1, td1_2, td1_3);
		
		var chatTable = $("<table></table>").attr("class", "chatTable");
		var includeChatTable = $("<div></div>").append(chatTable);
			includeChatTable = includeChatTable.attr("id", "includeChatTable"); 
		var td2 = $("<td></td>").append(includeChatTable);
			td2 = td2.attr("id", "MsgChatArea");
			td2 = td2.attr("colspan", "3");
		var tr2 = $("<tr></tr>").append(td2);
		
		var ta = $("<textarea></textarea>").attr("id", "cm_txt");
			ta = ta.attr("placeholder", "메시지 입력(보내기 단축키: Ctrl + Enter)");
			ta = ta.attr("class", "MsgChatInput");
			ta = ta.attr("maxlength", "300");
		var bt = $("<button></button>").text("보내기");
			bt = bt.attr("class", "MsgChatBtn");
		var td3 = $("<td></td>").append(ta, bt);
			td3 = td3.attr("colspan", "3");
			td3 = td3.attr("class", "MsgChatInputTd");
		var tr3 = $("<tr></tr>").append(td3);
		
		var hmsl_no = $("<input>").attr("type", "hidden");
			hmsl_no = hmsl_no.attr("value", data.msgLists[0].hmsl_no);
			hmsl_no = hmsl_no.attr("id", "MsgChatNo");
		var td4 = $("<td></td>").append(hmsl_no);
			td4 = td4.attr("colspan", "3");
			td4 = td4.css("background-color", "#E7ECEF");
		var tr4 = $("<tr></tr>").append(td4);
			tr4 = tr4.css("height", "0px");
		
		$("#MsgChat").append(tr1, tr2, tr3, tr4);
		$("#MsgChat").css("background-color", "white");
		
		chatting(socket, sendTo, sendFrom);
	});
}

function selectMessengerList() {
	var lm_id = $("#loginMember").val();
	var msgList = new Array;
	
	var url = "messenger.list.get?hm_id=" + lm_id;
	$.getJSON(url, function(data){
		for (var i = 0; i < data.msgLists.length; i++) {
			var ml = data.msgLists[i];
			var hmsl_no = ml.hmsl_no;
			
			var m1_id = ml.hmsl_m1;
			var m2_id = ml.hmsl_m2;
			var m1 = ml.hmsl_hm_m1[0];
			var m2 = ml.hmsl_hm_m2[0];
			
			// 상대방의 정보
			var hm_nickname = null;
			var hm_photo_front = null;
			if (m1_id == lm_id) {
				hm_nickname = m2.hm_nickname;
				hm_photo_front = m2.hm_photo_front;
			} else {
				hm_nickname = m1.hm_nickname;
				hm_photo_front = m1.hm_photo_front;
			}
			
			// 나의 메시지 삭제 여부
			var hmsl_last_txt = null;
			if (m1_id == lm_id) {
				hmsl_last_txt = ml.hmsl_last_txt1;
			} else {
				hmsl_last_txt = ml.hmsl_last_txt2;
			}
			
			// 로그인한 사람 구분
			var sendTo = null;
			var sendFrom = null;
			if (m1_id == lm_id) {
				sendTo = m2_id; 
				sendFrom = m1_id;
			} else {
				sendTo = m1_id; 
				sendFrom = m2_id;				
			}
			
			var d = ml.hmsl_last_date;
			var hmsl_last_date = d.year + "." 
								+ d.monthValue + "."
								+ d.dayOfMonth + "("
								+ d.hour + ":" 
								+ d.minute + ")";
			
		
			msgList.push({				
				"sendTo": sendTo,
				"sendFrom": sendFrom,
				"hmsl_no": hmsl_no,
				"hmsl_last_txt": hmsl_last_txt,
				"hmsl_last_date": hmsl_last_date,
				"hm_nickname": hm_nickname,
				"hm_photo_front": hm_photo_front
			});
		}
		
		callback(function(){
			var i = 0;
			summonMsgList2(msgList, i);
		})
	});

	
}

function summonMsgList2(msgList, i){
	var time = 0;
	if (i < msgList.length) {
		time += 1000;
	
		setTimeout(summonMsgList(msgList, i), time);
	}
}

function summonMsgList(msgList, i) {
	var checkCount = 0;
	var url2 = 'http://192.168.0.2:43128/message.uncheck.get?no=' + msgList[i].hmsl_no + '&id=' + msgList[i].sendFrom;
	$.getJSON(url2, function(ms){
		checkCount = ms.length;
		
		// 마지막 메시지가 있을 때만 테이블 생성 
		if (msgList[i].hmsl_last_txt.indexOf('@empty@') == -1) {
			var div = $("<div></div>").attr("style", "background: url('resources/img/member/" + msgList[i].hm_photo_front + "') center center no-repeat; " 
					+ "background-size: cover;");
				div = div.attr("class", "mflImgDiv");
				
			var checkDiv = $("<div></div>").text(checkCount);
				checkDiv = checkDiv.attr("class", "mflCheckDiv");
			
			if (checkCount == 0) {
				checkDiv = checkDiv.css("background-color", "lightgray");
			} else {
				checkDiv = checkDiv.css("background-color", "#FF5A5F");						
			}
			var td1_1 = $("<td></td>").append(div, checkDiv);
				td1_1 = td1_1.attr("rowspan", "3");
				td1_1 = td1_1.attr("class", "MsgListImgTd");
			var td1_2 = $("<td></td>").text(msgList[i].hm_nickname);
				td1_2 = td1_2.attr("class", "mflNick");
				td1_2 = td1_2.attr("align", "left");
			var tr1 = $("<tr></tr>").append(td1_1, td1_2);
			
			var hmsl_last_txt = msgList[i].hmsl_last_txt.replace(/<br>/gi, " ");
			var len = hmsl_last_txt.length;
			var td2 = null;
			if (len > 30) {
				td2 = $("<td></td>").text(hmsl_last_txt.substr(0, 28) + "...");
			} else {
				td2 = $("<td></td>").text(hmsl_last_txt);
			}
			var tr2 = $("<tr></tr>").append(td2);
				tr2 = tr2.attr("class", "mflTxt");
				tr2 = tr2.attr("align", "left");
			
			var td3 = $("<td></td>").text(msgList[i].hmsl_last_date);
				td3 = td3.css("padding-top", "2px");
			var tr3 = $("<tr></tr>").append(td3);
				tr3 = tr3.attr("class", "mflDate");
				tr3 = tr3.attr("align", "right");
			var table = $("<table></table>").attr("class", "MsgList");
				table = table.append(tr1, tr2, tr3);
				table = table.attr("onclick", "summonChat('" + msgList[i].sendTo + "', '" + msgList[i].sendFrom + "', '" + msgList[i].hm_nickname + "', '" + msgList[i].hm_photo_front + "');");
			$("#includeMsgListTable").append(table);
		}
		callback(function() {
			i++;
			summonMsgList2(msgList, i);
		})
	});
}

function refreshMsgList() {
	$("#includeMsgListTable").empty();
	selectMessengerList();
}

function deleteMsg(no, lm_id) {
	var t = "상대방에게는 대화 기록이 삭제되지 않습니다.\n"
			+ "이전 대화 기록을 모두 삭제하시겠습니까?"
	if (confirm(t)) {
		var url = 'http://192.168.0.2:43128/message.delete?no=' + no + '&id=' + lm_id;
		$.getJSON(url, function(){
			callback(function(){
				var url2 = "message.delete?hmsl_no=" + no;
				$.getJSON(url2, function(){});
				goMessenger();				
			});
		});
	}
}

// **************************************************************************
function chatting(socket, sendTo, sendFrom) {
	var no = $("#MsgChatNo").val();
	var ci = {no: no, sendTo: sendTo, sendFrom: sendFrom};
	socket.emit('chatInfo', ci);
	
	// ctrl + Enter ----------------------------------------
	var ctrlKey = false;
	$(".MsgChatInput").keydown(function(e){
		if (e.keyCode == 17) {
			ctrlKey = true;
		}
		
		if (e.keyCode == 13 && ctrlKey) {
			var txt = $(".MsgChatInput").val();
				txt = txt.replace(/\n/gi, '<br>');
			
			if (txt != null && txt != "") {
				if (txt != '@empty@') {					
					socket.emit('MsgChat', txt);
				} else {
					alert('[알림] @empty@는 입력 불가능합니다.');
				}
				$(".MsgChatInput").val("");				
			}
			ctrlKey = false;
		}
	});
	
	$(".MsgChatInput").keyup(function(e){
		if (e.keyCode == 17) {
			ctrlKey = false;
		}
	});
	// -----------------------------------------------------
	
	$(".MsgChatBtn").click(function(){
		var txt = $(".MsgChatInput").val();
			txt = txt.replace(/\n/gi, "<br>");
		
		if (txt != null && txt != "") {
			if (txt != '@empty@') {
				socket.emit('MsgChat', txt);
			} else {
				alert('[알림] @empty@는 입력 불가능합니다.');
			}
			$(".MsgChatInput").val("");
		} else {
			alert("메시지 내용 입력 필수");
		}
	});
	
	socket.on(sendFrom + no, function(msg){
		// ------------------------------------------------------------------------------
		chatMsg(no, sendFrom, msg.sendFrom, msg.txt, msg.date, msg.sfDel, msg.stDel, false);
		// ------------------------------------------------------------------------------
		var txt = msg.txt;
			txt = encodeURIComponent(txt); 
		var url = "messenger.list.update?hmsl_last_txt=" + txt + "&hmsl_no=" + msg.no;
		$.getJSON(url, function(){});

		callback(function(){
			scrollEvent();
		});
	});
}

function chatMsg(no, sendFrom, MsgSendFrom, MsgTxt, MsgDate, sfDel, stDel, dCheck) {
	if (((sendFrom == MsgSendFrom) && sfDel == false)
			|| ((sendFrom != MsgSendFrom) && stDel == false)) {
		// 2019-03-19T10:22:46.139Z
		var year = MsgDate.substr(0, 4);
		var month = MsgDate.substr(5, 2);
		var day = MsgDate.substr(8, 2);
		
		if (dCheck) {
			var dateLine = $("<div></div>").text(year + "년 " + month + "월 " + day + "일");
				dateLine = dateLine.attr("class", "dateLine");
			var dateTd = $("<td></td>").append(dateLine);
				dateTd = dateTd.attr("align", "center");
				dateTd = dateTd.attr("colspan", "4");
			var dateTr = $("<tr></tr>").append(dateTd);
			$(".chatTable").append(dateTr);
		}
		
		var time = MsgDate.substr(11, 2) + ":" + MsgDate.substr(14, 2);
		
		var div = $("<div></div>").html(MsgTxt);
		
		var td1 = $("<td></td>").css("width", "42%");
			td1 = td1.attr("class", "chatLeftTd");
		var td2 = $("<td></td>").css("width", "8%");
			td2 = td2.attr("class", "chatDate1");
		var td3 = $("<td></td>").css("width", "8%");
			td3 = td3.attr("class", "chatDate2");
		var td4 = $("<td></td>").css("width", "42%");
			td4 = td4.attr("class", "chatRightTd");
		
		if (MsgSendFrom == sendFrom) {
			td3 = td3.html(time + "<br>");
			div = div.attr("class", "chatDiv2");
			td4 = td4.append(div);
		} else {
			td2 = td2.html(time + "<br>");
			div = div.attr("class", "chatDiv1");
			td1 = td1.append(div);
		}
		
		var tr = $("<tr></tr>").append(td1, td2, td3, td4);
		$(".chatTable").append(tr);
		
		var url3 = "http://192.168.0.2:43128/message.check?no=" + no + "&id=" + sendFrom;
		$.getJSON(url3, function(){});
	}
}

function scrollEvent() {
	var chatHeight = $("#includeChatTable").height();
	var allChatHeight = $(".chatTable").height();
	
	$("#includeChatTable").scrollTop(allChatHeight);
	
	$("#includeChatTable").scroll(function(){
		var scrollOffset = $("#includeChatTable").scrollTop();
		
		if (chatHeight + scrollOffset < allChatHeight) {
			$("#stbDiv").css("opacity", "1");
		} else {
			$("#stbDiv").css("opacity", "0");
		}
	});
	
	$("#stbDiv").click(function(){
		$("#includeChatTable").animate({
			scrollTop: allChatHeight
		}, 400);
	});
}

