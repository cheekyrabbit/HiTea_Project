function goAllTeabag() {
	location.href="site.teabag.home";
}

function goMakeTeabag() {
	location.href = "site.teabag.make.go";
}

function goLeaveTeabag(tno) {
	if(confirm("티백을 탈퇴하시겠습니까?")){
		location.href="site.teabag.leave?ht_no="+tno;
	} else{
		return false;
	}
}

function goDeleteBBS(tno) {
	if(confirm("방명록을 삭제하시겠습니까?")){
		location.href="teabag.bbs.delete?hb_no="+tno;
	} else{
		return false;
	}
}

function goDeleteDR(no) {
	if(confirm("파일을 삭제하시겠습니까?")){
		location.href="teabag.dr.delete?hd_no="+no;
	} else{
		return false;
	}
}

function goPagePhoto(i) {
	url = "teabag.dr.pagePhoto?p="+i;
	tb_dataroom_getPhoto();
}

function goForceDeleteMember(htm_id, ht_no) {
	if(confirm("강제 탈퇴 시키시겠습니까?")){
		location.href="teabag.member.forceDeleteMember?htm_id="+htm_id + "&ht_no=" + ht_no;
	} else{
		return false;
	}
}

function goDelegateMember(htm_id, ht_no) {
	if(confirm("티백장을 위임하시겠습니까?")){
		location.href="teabag.member.delegateMember?htm_id="+htm_id + "&ht_no=" + ht_no;
	} else{
		return false;
	}
}

function goPageFile(i) {
	url = "teabag.dr.pageFile?p="+i;
	tb_dataroom_getFile();
}

function goUpdateNotice() {
	var input = prompt('수정할 내용을 입력하세요.');
	if(input != null){
		location.href="site.teabag.updateNotice?ht_notice="+input;		
	}else{
		return false;
	}
}

function goTeabagPage(no) {
	location.href="site.teabag.go?ht_no="+no;
}

function goDeleteTeabag() {
	if(confirm("티백을 삭제하겠습니까?")){
		location.href="site.teabag.deleteTeabag";
	} else{
		return false;
	}
}

function goJoinTeabag() {
	location.href = "site.member.sendjoinReq";
}

function goTeabagSNS() {
	location.href = "teabag.sns.go";
}

function goTeabagBBS() {
	location.href = "teabag.bbs.go";
}

function goTeabagDr() {
	location.href = "teabag.dr.go";
}

function goTeabagMember() {
	location.href = "teabag.member.go";
}
