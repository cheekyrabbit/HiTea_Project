function scrollTop() {
	$(".memberArrowImgA").hide();
	$(document).ready(function() {
		$(window).scroll(function() {
			if ($(this).scrollTop() > 360) {
				$('.memberArrowImgA').fadeIn();
			} else {
				$('.memberArrowImgA').fadeOut();						
			}				
		});
	});
	
	$(".memberArrowImgA").click(function() {
		$("html").animate({
			scrollTop: 0
		}, 500);
		return false;
	});
}