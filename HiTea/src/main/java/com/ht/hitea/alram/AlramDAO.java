package com.ht.hitea.alram;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.hitea.Inquiry;
import com.ht.hitea.member.Member;

@Service
public class AlramDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void alramAll(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		Inquiry in = new Inquiry(null,null,m.getHm_id());
		List<Alram> alrams = ss.getMapper(AlramMapper.class).alramAll(in);
		req.setAttribute("alramAll", alrams);
	}

}
