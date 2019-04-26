package com.ht.hitea.teabag.tb.member;

import java.util.List;

import com.ht.hitea.teabag.tb.TeabagMember;

public interface TeabagMemberMapper {

	public abstract List<TeabagMember> getAllMemberByTNo(TeabagMember tm);
	public abstract List<TeabagMember> getMemberByTNo(TeabagMember tm);
	public abstract int countAllMemberByTNo(TeabagMember tm);
	public abstract int sendJoinReq(JoinReq j);
	public abstract List<JoinReq> getJoinReqByTNo(JoinReq j);
	public abstract JoinReq getJoinReqByNo(JoinReq j);
	public abstract int sendPageNotice(PageNotice pn);
	public abstract int deleteJoinReq(JoinReq j);
	public abstract int delegateTeabag(TeabagMember tm);
	public abstract List<PageNotice> getPageNoticeById(PageNotice p);
	public abstract List<PageNotice> getPageNoticeByTNo(PageNotice p);
}
