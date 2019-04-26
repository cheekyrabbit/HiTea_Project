package com.ht.hitea.teabag.tb.member;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.hitea.member.Member;
import com.ht.hitea.teabag.tb.Teabag;
import com.ht.hitea.teabag.tb.TeabagMapper;
import com.ht.hitea.teabag.tb.TeabagMember;
import com.ht.hitea.teabag.tb.TeabagMembers;

@Service
public class TbMemberDAO {
	@Autowired
	private SqlSession ss;
	
	public TeabagMembers getAllMemberByTNo(HttpServletRequest req, HttpServletResponse res) {
		Teabag t = (Teabag) req.getSession().getAttribute("teabag");
		return new TeabagMembers(ss.getMapper(TeabagMemberMapper.class).getMemberByTNo(new TeabagMember(null, t.getHt_no(), null, null, null, null, null)));
	}
	
	public void sendJoinReq(HttpServletRequest req, HttpServletResponse res){
		Teabag t = (Teabag) req.getSession().getAttribute("teabag");
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		req.getSession().setAttribute("teabagJoin", "R");
		ss.getMapper(TeabagMemberMapper.class).sendJoinReq(new JoinReq(null, m.getHm_id(), t.getHt_no(), null, null, null));
	}
	
	public JoinReqs getJoinReqByTNo(HttpServletRequest req, HttpServletResponse res){
		Teabag t = (Teabag) req.getSession().getAttribute("teabag");
		return new JoinReqs(ss.getMapper(TeabagMemberMapper.class).getJoinReqByTNo(new JoinReq(null, null, t.getHt_no(), null, null, null)));
	}
	
	public void acceptJoinReq(HttpServletRequest req, HttpServletResponse res){
		JoinReq j = ss.getMapper(TeabagMemberMapper.class).getJoinReqByNo(new JoinReq(new BigDecimal(req.getParameter("hj_no")), null, null, null, null, null));
		Teabag t = ss.getMapper(TeabagMapper.class).getByTNo(new Teabag(j.getHj_tno(), null, null, null, null, null, null, null, null, null));
		String hpn_content = t.getHt_name()+" 티백에 가입되었습니다.";
		if(ss.getMapper(TeabagMapper.class).joinTeabag(new TeabagMember(j.getHj_id(), j.getHj_tno(), null, null, null, null, null))==1){
			int count = countMemberByTNo(new TeabagMember(j.getHj_id(), j.getHj_tno(), null, null, null, null, null));
			count = count++;
			ss.getMapper(TeabagMapper.class).updateCountMember(new Teabag(t.getHt_no(), null, null, null, null, null, null, null, new BigDecimal(count), null));
			ss.getMapper(TeabagMemberMapper.class).sendPageNotice(new PageNotice(null, j.getHj_id(), t.getHt_no(), hpn_content, "solo", null, null));
			ss.getMapper(TeabagMemberMapper.class).deleteJoinReq(j);
		}
	}
	
	private int countMemberByTNo(TeabagMember tm){
		return ss.getMapper(TeabagMapper.class).countMemberByTNo(tm);
	}
	
	public void denyJoinReq(HttpServletRequest req, HttpServletResponse res){
		JoinReq j = ss.getMapper(TeabagMemberMapper.class).getJoinReqByNo(new JoinReq(new BigDecimal(req.getParameter("hj_no")), null, null, null, null, null));
		Teabag t = ss.getMapper(TeabagMapper.class).getByTNo(new Teabag(j.getHj_tno(), null, null, null, null, null, null, null, null, null));
		String hpn_content = t.getHt_name()+" 티백 가입 신청이 거절당했습니다.";
		if(ss.getMapper(TeabagMemberMapper.class).sendPageNotice(new PageNotice(null, j.getHj_id(), t.getHt_no(), hpn_content, "solo", null, null)) == 1){
			ss.getMapper(TeabagMemberMapper.class).deleteJoinReq(j);
		}
	}
	
	public void forceDeleteMember(HttpServletRequest req, HttpServletResponse res){
		Teabag t = (Teabag) req.getSession().getAttribute("teabag");
		String hpn_content = t.getHt_name()+" 티백에서 강퇴되었습니다.";
		if(ss.getMapper(TeabagMapper.class).leaveTeabag(new TeabagMember(req.getParameter("htm_id"), t.getHt_no(), null, null, null, null, null))== 1){
			ss.getMapper(TeabagMemberMapper.class).sendPageNotice(new PageNotice(null, req.getParameter("htm_id"), t.getHt_no(), hpn_content, "solo", null, null));
			int count = countMemberByTNo(new TeabagMember(null, t.getHt_no(), null, null, null, null, null));
			count = count--;
			ss.getMapper(TeabagMapper.class).updateCountMember(new Teabag(t.getHt_no(), null, null, null, null, null, null, null, new BigDecimal(count), null));
		}
	}
	
	public void delegateMember(HttpServletRequest req, HttpServletResponse res){
		Teabag t = (Teabag) req.getSession().getAttribute("teabag");
		List<TeabagMember> allTm= ss.getMapper(TeabagMemberMapper.class).getMemberByTNo(new TeabagMember(null, t.getHt_no(), null, null, null, null, null));
		String hpn_content = t.getHt_name()+" 티백의 티백장으로 위임되었습니다.";
		for (TeabagMember teabagMember : allTm) {
			if(teabagMember.getHtm_id().equals(req.getParameter("htm_id"))){
				//System.out.println("아이디 확인");
				ss.getMapper(TeabagMemberMapper.class).delegateTeabag(new TeabagMember(req.getParameter("htm_id"), t.getHt_no(), null, null, null, null, null));
				//System.out.println("위임완료");
				ss.getMapper(TeabagMemberMapper.class).sendPageNotice(new PageNotice(null, req.getParameter("htm_id"), t.getHt_no(), hpn_content, "solo", null, null));
				//System.out.println("메시지보냄");
			}
		}
	}
	
	public PageNotices getPageNoticeById(HttpServletRequest req){
		Member m = (Member) req.getSession().getAttribute("loginMember");
		return new PageNotices(ss.getMapper(TeabagMemberMapper.class).getPageNoticeById(new PageNotice(null, m.getHm_id(), null, null, null, null, null)));
	}

}
