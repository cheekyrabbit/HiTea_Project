package com.ht.hitea.member;

import java.util.List;

import com.ht.hitea.messenger.MessengerList;

public interface MemberMapper {
	
	public abstract Member getMemberByID(Member m);
	public abstract int join(Member m);
	
	public abstract Integer idCheckJson(Member m);
	public abstract Integer nicknameCheckJson(Member m);
	public abstract Integer emailCheckJson(Member m);
	
	public abstract Member idSearch(Member m);
	public abstract int pwSearch(Member m);
	public abstract Member temporarilyPwEmail(Member m);	
	
	public abstract Integer memberUpdatePwCheck(Member m);
	public abstract Integer memberUpdate(Member m);
	public abstract Integer memberDelete(Member m);
	
	public abstract Member yourPageInformation(Member m);

	public abstract List<Member> memberFollow(Member m);
	public abstract List<Member> memberFollowing(Member m);
	
	public abstract List<Member> myTBag(Member m);
	public abstract List<Member> affiliatedTBag(Member m);

	public abstract int memberSNSUpdate(Member m);
	public abstract int memberSNSRelUpdate(Member m);
	
	// messenger
	public abstract List<Member> getAllMemberOrderByNickname();
	public abstract List<Member> getMember(MessengerList ml);
	public abstract List<Member> getMember2(MessengerList ml);
}
