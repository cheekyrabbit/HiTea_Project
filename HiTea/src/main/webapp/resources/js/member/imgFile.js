function photoPreview() {
	photo_front();
	photo_back()
}

function photo_front() {
	$(document).ready(function(){
		$(".memberMyPagePhoto_frontImgFile").on("change", photoFront);
	});
	
	function photoFront(e) {
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);
		
		filesArr.forEach(function(f) {
			var reader = new FileReader();
			
			reader.onload = function(e) {
				$(".memberHm_photo_frontDiv").css("background", "url('" + e.target.result + "') center center/cover no-repeat");
			}
			reader.readAsDataURL(f);
		});
	}	
}

function photo_back() {
	$(document).ready(function(){
		$(".memberMyPagePhoto_backImgFile").on("change", photoBack);
	});
	
	function photoBack(e) {
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);
		
		filesArr.forEach(function(f) {
			var reader = new FileReader();
			
			reader.onload = function(e) {
				$(".memberMyPageUnderCoverTable").css("background-image", "url('" + e.target.result + "')");
			}
			reader.readAsDataURL(f);
		});
	}	
}
	
	