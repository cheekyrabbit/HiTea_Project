package com.ht.hitea.follow;

import java.util.List;

import com.ht.hitea.Inquiry;
import com.ht.hitea.sns.SNSBean;

public interface FollowMapper {
	public abstract int following(Follow fo);	
	public abstract int follower(Follow fo);	
	public abstract List<Follow> followerCheck(Follow fo);	
	public abstract int followerReg(Follow fo);
	public abstract int followerDelete(Follow fo);
	public abstract List<SNSBean> getShowSNSFollow(Inquiry in);	
	public abstract int getShowSNSFollowCount(Inquiry in);	
}
