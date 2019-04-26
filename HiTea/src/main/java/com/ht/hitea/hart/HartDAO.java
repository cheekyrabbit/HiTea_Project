package com.ht.hitea.hart;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.hitea.alram.Alram;
import com.ht.hitea.alram.AlramMapper;
import com.ht.hitea.member.Member;
import com.ht.hitea.sns.SNSBean;

@Service
public class HartDAO {
	@Autowired
	private SqlSession ss;

	public Harts hartCheck(SNSBean s) {
		return new Harts(ss.getMapper(HartMapper.class).hart(s));
	}

	public Harts hartImgCheck(SNSBean s) {
		return new Harts(ss.getMapper(HartMapper.class).hartImgCheck(s));
	}

	public int hartReg(SNSBean s, HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		Alram al = new Alram(null, m.getHm_nickname(), m.getHm_id(), req.getParameter("st_id"), null, null);
		s.setHs_hm_id(req.getParameter("hs_hm_id2"));
		String sid = req.getParameter("st_id");
		String sid2 = req.getParameter("hs_hm_id2");
		if (sid.equals(sid2)) {
			return ss.getMapper(HartMapper.class).hartReg(s);
		} else {
			ss.getMapper(AlramMapper.class).alramRegHeart(al);
			return ss.getMapper(HartMapper.class).hartReg(s);

		}
	}

	public int hartDelete(SNSBean s) {
		return ss.getMapper(HartMapper.class).hartDelete(s);
	}

}
