function goMessenger() {
	location.href = "messenger";
}

function goToChat(sendTo, sendFrom, nickname, image) {
	location.href = "messenger?sendTo=" + sendTo 
					+ "&sendFrom=" + sendFrom 
					+ "&nickname=" + nickname 
					+ "&image=" + image;
}

