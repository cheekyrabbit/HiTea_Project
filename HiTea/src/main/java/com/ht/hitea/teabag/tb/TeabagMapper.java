package com.ht.hitea.teabag.tb;

import java.util.List;

import com.ht.hitea.Inquiry;
import com.ht.hitea.sns.SNSBean;

public interface TeabagMapper {
	public abstract int makeTeabag(Teabag t);

	public abstract int countTeabagByMember(Teabag t);
	
	public abstract List<Teabag> getFourTeabags();

	public abstract List<Teabag> getFourTeabagById(TeabagMember tm );
	
	public abstract Teabag getByTNo(Teabag t);

	public abstract Teabag getTeabagByLeaderId(Teabag t);
	
	public abstract int joinTeabag(TeabagMember tm);
	
	public abstract TeabagMember getMemberByTNoAndId(TeabagMember tm);
	
	public abstract int leaveTeabag(TeabagMember tm);
	
	public abstract int countMemberByTNo(TeabagMember tm);

	public abstract int updateCountMember(Teabag t);
	
	public abstract int updateTeabag(Teabag t);

	public abstract int updateNotice(Teabag t);
	
	public abstract List<Teabag> getAllTeabagById(TeabagMember tm);

	public abstract List<Teabag> getAllTeabag();

	public abstract List<Teabag> getTeabagByCategory(Teabag t);
	
	public abstract List<Teabag> getTeabagByName(Teabag t);
	
	public abstract List<SNSBean> getTeaBagSNS(Inquiry in);
	public abstract int getTeaBagSNSCount(Inquiry in);

	public abstract int deleteTeabag(Teabag t);
}
