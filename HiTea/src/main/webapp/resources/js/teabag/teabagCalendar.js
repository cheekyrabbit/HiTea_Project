function calendarMini(arr) { 	// public static void main() 메소드 위에 따로 만들어준 메소드라고 생각하면 됨. main 함수 안에 넣으면 부르는 게 안되니까, 밖으로 뺴 준거라고 생각하면 됨.
	$('#calendarMini').fullCalendar({
        theme: true,
		header: {
            	left: 'month',
		        center: 'title',
		        right: 'custom2 prev,next'
        }, 
        eventAfterRender: function () {
            // add titles to "+# more links"
            $('.fc-more-cell a').each(function () {
                this.title = this.textContent;
            });
        },
        editable: true,
        displayEventTime : false,
	    googleCalendarApiKey: 'AIzaSyDPzc96PpSn5I1q13Wm7U5xZMtu7mcpyVc',
	    // 구글 캘린더 갖고 오려고 내 아이디 api 씀
		eventLimit: true,
		eventClick: false,
	    eventSources: [
			{
				googleCalendarId: 'ko.south_korea#holiday@group.v.calendar.google.com'					
				// 구글 캘린더
			},
			{
				events:arr
				// 배열에 있는 이벤트
			}
		]	
	});	
}

function getCalendarForMini() {
	var url="teabag.calendar.getCalendar";
	$.getJSON(url, function(data) {
		var ar = [];
		var color = null;
		$.each(data.calendar, function(i, p) {
			var color = "orange";
			if(p.hc_category == "여행"){
				color = "green";
			} else if(p.hc_category == "술자리"){
				color = "yellow";
			} else if(p.hc_category == "행사"){
				color = "blue";
			} 
			ar[i] = {title: p.hc_title, start: p.hc_start, end: p.hc_end, color:color, content:p.hc_content, no:p.hc_no};
		});
		calendarMini(ar);
	});
}

 		
function miniCalendarClick() {
	$("#calendarMini").click(function name() {
		location.href="teabag.calendar.go";
	});
}

function getCalendarForBig() {
	var url="teabag.calendar.getCalendar";
	$.getJSON(url, function(data) {
		var ar = [];
		var calendarNo = null;
		var color = null;
		$.each(data.calendar, function(i, p) {
			var color = "orange";
			if(p.hc_category == "여행"){
				var color = "green";
			} else if(p.hc_category == "술자리"){
				var color = "yellow";
			} else if(p.hc_category == "행사"){
				var color = "blue";
			} 
			ar[i] = {title: p.hc_title, start: p.hc_start, end: p.hc_end, color:color, content:p.hc_content, no:p.hc_no, bname:p.hc_tno};
		});
		calendarBig(ar);
	});
}

function calendarBig(arr) { 	// public static void main() 메소드 위에 따로 만들어준 메소드라고 생각하면 됨. main 함수 안에 넣으면 부르는 게 안되니까, 밖으로 뺴 준거라고 생각하면 됨.
	$('#calendar').fullCalendar({
	    header: {
	    	left: 'month',
	        center: 'title',
	        right: 'custom2 prev,next'
	    }, 
	    googleCalendarApiKey: 'AIzaSyDPzc96PpSn5I1q13Wm7U5xZMtu7mcpyVc',
	    // 구글 캘린더 갖고 오려고 내 아이디 api 씀
		defaultView: 'month',
		displayEventTime : false,
		eventMouseover: function(calEvent, jsEvent) {
			if(calEvent.content != 'undefined' && calEvent.content != null ){
				var tooltip = '<div class="tooltipevent" style="width:100px;height:100px;background:#ccc;position:absolute;z-index:10001;">' + calEvent.content + '</div>';
				$("body").append(tooltip);
				$(this).mouseover(function(e) {
					$(this).css('z-index', 10000);
					$('.tooltipevent').fadeIn('500');
					$('.tooltipevent').fadeTo('10', 1.9);
				}).mousemove(function(e) {
					$('.tooltipevent').css('top', e.pageY + 10);
					$('.tooltipevent').css('left', e.pageX + 20);
				});
			}
		},

		eventMouseout: function(calEvent, jsEvent) {
		     $(this).css('z-index', 8);
		     $('.tooltipevent').remove();
		},
        eventClick: function(eventObj, xy) {
        	calendarNo = eventObj.no;
			if($("#deleteCalendarGo").attr("class")=="delete"){
				deleteCal(calendarNo);
				getCalendarForBig();
			}
		},
		eventLimit: true,
		eventSources: [
			{
				googleCalendarId: 'ko.south_korea#holiday@group.v.calendar.google.com'					
				// 구글 캘린더
			},
			{
				events: arr
				// 배열에 있는 이벤트
			}
			]	
	});			
}
function goDeleteMode_TbCalendar() {
	$("#deleteCalendarGo").click(function() {
		if($("#deleteCalendarGo").attr("class")!="delete"){
			$("#deleteCalendarGo").text("삭제 끝");
			$("#calendarBig .fc-day").css("background-color", "#FFA7A7");
			$("#deleteCalendarGo").attr("class", "delete");
		} else {
			$("#deleteCalendarGo").text("삭제하러");
			$("#calendarBig .fc-day").css("background-color", "#ffffff00");
			$("#deleteCalendarGo").attr("class", "cancel");
		}
	});
}
function deleteCal(no) {
	if(confirm("일정을 삭제하시겠습니까?")){
	location.href="teabag.calendar.delete?hc_no="+no;
	}
}
