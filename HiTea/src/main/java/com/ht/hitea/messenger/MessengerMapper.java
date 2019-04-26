package com.ht.hitea.messenger;

import java.util.List;

import com.ht.hitea.member.Member;

public interface MessengerMapper {
	
	public abstract List<Member> getFollowList(Member m);
	
	public abstract List<Member> getFollowListByNickname(Member m);
	
	public abstract MessengerList getMsgListByNo(MessengerList ml);
	
	public abstract List<MessengerList> getAllMsgList();
	
	public abstract List<MessengerList> getMsgListByLoginId(Member lm);
	
	public abstract List<MessengerList> checkMsgList(MessengerList ml);
	
	public abstract List<MessengerList> getRealMsgList(MessengerList ml);
	
	public abstract int regMsgList(MessengerList ml);
	
	public abstract int updateMsgList(MessengerList ml);
	
	public abstract int deleteMsgListForM1(MessengerList ml);
	
	public abstract int deleteMsgListForM2(MessengerList ml);
	
}
