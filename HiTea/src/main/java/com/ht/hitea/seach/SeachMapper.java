package com.ht.hitea.seach;

import java.util.List;

import com.ht.hitea.Inquiry;
import com.ht.hitea.member.Member;
import com.ht.hitea.sns.SNSBean;

public interface SeachMapper {
	public abstract List<Member> memberSeach(Inquiry in);
	public abstract Integer memberSeachCount(Inquiry in);
	public abstract List<Member> memberSeachAll(Inquiry in);

	
	public abstract List<TeaBagSeach> teabagSeach(Inquiry in);
	public abstract Integer teabagSeachCount(Inquiry in);
	
	
	
	
	public abstract List<SNSBean> snsSeachAll(Inquiry in);
	public abstract Integer snsSeachCount(Inquiry in);
	public abstract List<SNSBean> snsSeach(Inquiry in);

}
