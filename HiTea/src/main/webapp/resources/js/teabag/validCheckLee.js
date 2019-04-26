// 잘못되면 true, 정상이면 false

// <input>을 넣어주면 거기에 글자가 없는지 체크해줄 함수
// 없으면 true, 있으면 false 리턴
function isEmpty(field) {
	return(!field.value); // 없으면 true 있으면 false
	/*if(!field.value){
		return true;
	}
	return false;*/
	
//	boolean a = true;
//	boolean a = 0; // 0은 false고 나머지 값은 다 true.
}

// <input>, 최소 글자수를 넣어주면 체크해줄 함수
// 최소글자수보다 짧으면 true, 길면 false 리턴
function lessThan(field, min) {
	return(field.value.length<min);

	//	if(field.value.length < min){
//		return true;
//	}
//	return false;
}

// <input> 넣어주면 거기에 한글/특수문자 있는지 체크해줄 함수
// 한글/특수문자가 들어있으면 TRUE, 없으면 FALSE 리턴
function containsHS(field) {
	var str = "@_.1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM"; // 이거 이외의 글자가 보이면 잘못된 걸로. 한글은 경우의 수가 너무 많아서.
	for (var i = 0; i < field.value.length; i++) {
		if(str.indexOf(field.value[i]) == -1){
			return true;
		}		
	}
	return false;
}

// <input> 2개 넣어서, 그 2개 값 다른지 체크할 함수 
// 다르면 true, 같으면 false
function notEquals(field1, field2) {
	return (field1.value !=field2.value);
}

// <input>, 허용할 문자열 세트를 넣었을 때 
// 그게 들어있지 않으면 true, 들어있으면 false
// 특수문자 사용하고 싶을 때 "는 \"로, \는 \\으로 해줘야됨. 
function notContains(field, charset) {
	for (var i = 0; i < charset.length; i++) {
		if(field.value.indexOf(charset[i]) != -1){
			return false;
		}
	}
	return true;
}

//<input>을 넣어주면 숫자만 있는지
//숫자 아닌 게 있으면 true, 아니면 false
function isNotNumber(field) {
	return isNaN(field.value);
}

//a.png
//a.PNG 둘 다 되도록. toLowerCase는 무조건 소문자로 바꿔주는 자바 함수 endsWith (그걸로 끝나는지)

//<input>, 파일 확장자(png)를 넣어주면
//value가 확장자로 안 끝나면 true, 끝나면 false
function isNotType(field, type) {
	return(!field.value.toLowerCase().endsWith("." + type));
}