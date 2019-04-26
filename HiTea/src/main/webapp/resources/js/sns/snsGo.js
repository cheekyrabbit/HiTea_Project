function goSNSReDel(hsr_no) {
	if (confirm("진짜 삭제?")) {
		location.href = "snsRedelete.go?hsr_no=" + hsr_no;
	}
}


function goSNSDel(hs_no) {  
	if (confirm("진짜 삭제??")) {
   		location.href = "sns.delete.go?hs_no=" + encodeURI(hs_no);
   	}
}


function goYourPage() {
	location.href = "yourPageGo";
}


function snsstart() {
	var objDragDrop = $(".snsdragDropDiv");

	var abcd = -1;
	var abc = [];
	var index;

	$(document).on("change", "#snsfileInput", function(e) {

		abcd += 1;

		e.preventDefault();
		e.stopPropagation();
		handleFileUpload($(this)[0].files);
		
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);
		var bb = $('.snsaa');

		if (abcd == 0) {
			index = 0;
		} else {
			index = $(".snsaaTd").length - filesArr.length;
		}

		filesArr.forEach(function(f) {
			abc.push(f);
			var reader = new FileReader();
			reader.onload = function(e) {
				$(bb[index]).attr("src", e.target.result);
				index++;
			}
			reader.readAsDataURL(f);
		});

	});

	$(document).on("dragover", ".snsdragDropDiv", function(e) {
		e.stopPropagation();
		e.preventDefault();
		$(this).css('border', '2px solid #FAC03B');
	});

	$(document).on("drop", ".snsdragDropDiv", function(e) {

		abcd += 1;

		$(this).css('border', '2px solid #274554');
		e.preventDefault();

		var files = e.originalEvent.dataTransfer.files;
		handleFileUpload(files);

		var filesArr = Array.prototype.slice.call(files);
		var bb = $('.snsaa');

		if (abcd == 0) {
			index = 0;
		} else {
			index = $(".snsaaTd").length - filesArr.length;
		}

		filesArr.forEach(function(f) {
			abc.push(f);
			var reader = new FileReader();
			reader.onload = function(e) {
				$(bb[index]).attr("src", e.target.result);
				index++;
			}
			reader.readAsDataURL(f);
		});

	});

	$(document).on("dragover", ".snsdragDropDiv", function(e) {
		e.stopPropagation();
		e.preventDefault();
		objDragDrop.css('border', '2px solid #274554');
	});
	

		$('.snsbxslider').bxSlider({
		slideWidth : 485,
		adaptiveHeight : false,
		slideMargin : 0,
		mode : 'fade',
		caption : false
		});
}

function goSNSAll() {
	location.href = "sns2";
}

function goSNSFollow() {
	location.href = "sns";
}
