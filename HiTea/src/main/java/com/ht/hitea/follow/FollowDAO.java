package com.ht.hitea.follow;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.hitea.Inquiry;
import com.ht.hitea.alram.Alram;
import com.ht.hitea.alram.AlramMapper;
import com.ht.hitea.hart.HartMapper;
import com.ht.hitea.hash.HashMapper;
import com.ht.hitea.member.Member;
import com.ht.hitea.sns.FileUploadMapper;
import com.ht.hitea.sns.SNSBean;
import com.ht.hitea.sns.SNSReplMapper;
import com.ht.hitea.sns.SNSs;

@Service
public class FollowDAO {

	@Autowired
	private SqlSession ss;
	
	public Follows followCheck(Follow fo) {
		return new Follows(ss.getMapper(FollowMapper.class).followerCheck(fo));
	}
	public Integer following(Follow fo) {
		return ss.getMapper(FollowMapper.class).following(fo);
	}
	public Integer follower(Follow fo) {
		return ss.getMapper(FollowMapper.class).follower(fo);
	}
	public Integer followerReg(Follow fo,HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		Alram al = new Alram(null,m.getHm_nickname(),fo.getHf_following_hm_id(),fo.getHf_follower_id(),null,null);
		ss.getMapper(AlramMapper.class).alramRegFollow(al);	
		
		return ss.getMapper(FollowMapper.class).followerReg(fo);		
	}
	public Integer followerDelete(Follow fo) {
		return ss.getMapper(FollowMapper.class).followerDelete(fo);		
	}
	
	
	public SNSs snsFollow(int page,String ssid,HttpServletRequest req) {
		Inquiry in = new Inquiry(null,null,ssid);
		int count2 = ss.getMapper(FollowMapper.class).getShowSNSFollowCount(in);
		double count = 4;
		int pageCount = (int) Math.ceil(count2 / count);
		if (count2>0) {
			int start = count2 - (page - 1) * (int) count;
			int end = (page == pageCount) ? 1 : start - ((int) count - 1);
			
			in.setStart(new BigDecimal(start));
			in.setEnd(new BigDecimal(end));
			
			List<SNSBean> snsFollows = ss.getMapper(FollowMapper.class).getShowSNSFollow(in);
			
			for (SNSBean sb2 : snsFollows) {
				sb2.setS_harts(ss.getMapper(HartMapper.class).hart(sb2));
				sb2.setS_hashs(ss.getMapper(HashMapper.class).hashNoAll(sb2));
				sb2.setS_files(ss.getMapper(FileUploadMapper.class).getAllfile2(sb2));
				sb2.setS_repls(ss.getMapper(SNSReplMapper.class).getAllRepl(sb2));
				
			}
			
			
			return new SNSs(snsFollows);
		}
		return null;
	}
	
}
