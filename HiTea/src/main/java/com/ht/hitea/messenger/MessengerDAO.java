package com.ht.hitea.messenger;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.hitea.member.Member;
import com.ht.hitea.member.MemberMapper;
import com.ht.hitea.member.Members;

@Service
public class MessengerDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void getMsgFollowerList(HttpServletRequest request) {
		Member lm = (Member) request.getSession().getAttribute("loginMember");
		List<Member> m = ss.getMapper(MessengerMapper.class).getFollowList(lm);
		request.setAttribute("mfList", m);
	}
	
	public Members getMsgFollowerListByNickname(HttpServletRequest request) {
		Member lm = (Member) request.getSession().getAttribute("loginMember");
		lm.setHm_nickname(request.getParameter("fn"));
		List<Member> m = ss.getMapper(MessengerMapper.class).getFollowListByNickname(lm);
		Members ms = new Members(m);
		return ms;
	}

	public MessengerLists getAllMsgListJSON(HttpServletRequest request) {
		List<MessengerList> mls = ss.getMapper(MessengerMapper.class).getAllMsgList();
		
		for (MessengerList ml : mls) {
			ml.setHmsl_hm_m1(ss.getMapper(MemberMapper.class).getMember(ml));
			ml.setHmsl_hm_m2(ss.getMapper(MemberMapper.class).getMember2(ml));
		}
		
		MessengerLists mls2 = new MessengerLists(mls);
		return mls2;
	}
	
	public MessengerLists checkMsgList(HttpServletRequest request) {
		MessengerList ml = new MessengerList();
		ml.setHmsl_m1(request.getParameter("hmsl_m1"));
		ml.setHmsl_m2(request.getParameter("hmsl_m2"));
		List<MessengerList> mls = ss.getMapper(MessengerMapper.class).checkMsgList(ml);
		
		MessengerLists mls2 = new MessengerLists(mls);
		return mls2;
	}
	
	public void regMsgList(HttpServletRequest request) {
		try {
			MessengerList ml = new MessengerList();
			ml.setHmsl_m1(request.getParameter("hmsl_m1"));
			ml.setHmsl_m2(request.getParameter("hmsl_m2"));
			ml.setHmsl_last_txt1("@empty@");
			ml.setHmsl_last_txt2("@empty@");
			
			LocalDateTime now = LocalDateTime.now();
			ml.setHmsl_last_date(now);
			
			if (ss.getMapper(MessengerMapper.class).regMsgList(ml) == 1) {
				//System.out.println("목록 생성 성공");
			} else {
				//System.out.println("목록 생성 실패");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("목록 생성 실패(DB 문제)");
		}
	}
	
	public MessengerLists getMsgListByLoginId(HttpServletRequest request) {
		Member lm = new Member();
		lm.setHm_id(request.getParameter("hm_id"));
		List<MessengerList> mls = ss.getMapper(MessengerMapper.class).getMsgListByLoginId(lm);
		
		for (MessengerList ml : mls) {
			ml.setHmsl_hm_m1(ss.getMapper(MemberMapper.class).getMember(ml));
			ml.setHmsl_hm_m2(ss.getMapper(MemberMapper.class).getMember2(ml));
		}
		
		MessengerLists mls2 = new MessengerLists(mls);
		return mls2;
	}
	
	public MessengerLists getRealMsgList(HttpServletRequest request) {
		MessengerList ml = new MessengerList();
		ml.setHmsl_m1(request.getParameter("hmsl_m1"));
		ml.setHmsl_m2(request.getParameter("hmsl_m2"));
		List<MessengerList> mls = ss.getMapper(MessengerMapper.class).getRealMsgList(ml); 
		
		MessengerLists mls2 = new MessengerLists(mls);
		return mls2;
	}
	
	public void updateMsgList(HttpServletRequest request) {
		try {
			MessengerList ml = new MessengerList();
			String txt = request.getParameter("hmsl_last_txt");
			ml.setHmsl_last_txt1(txt);
			ml.setHmsl_last_txt2(txt);
			ml.setHmsl_no(new BigDecimal(request.getParameter("hmsl_no")));
			if (ss.getMapper(MessengerMapper.class).updateMsgList(ml) == 1) {
				// System.out.println("채팅 목록 수정 완료");
			} else {
				// System.out.println("채팅 목록 수정 실패");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println("채팅 목록 수정 실패");
		}
	}
	
	public void deleteMsg(HttpServletRequest request) {
		try {
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String lm_id = m.getHm_id();
			
			MessengerList ml = new MessengerList();
			ml.setHmsl_no(new BigDecimal(request.getParameter("hmsl_no")));
			
			MessengerList ml2 = ss.getMapper(MessengerMapper.class).getMsgListByNo(ml);
			if (ml2.getHmsl_m1().equals(lm_id)) {
				ss.getMapper(MessengerMapper.class).deleteMsgListForM1(ml2);
			} else {
				ss.getMapper(MessengerMapper.class).deleteMsgListForM2(ml2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
