package com.ht.hitea.teabag.tb.bbs;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.hitea.member.Member;
import com.ht.hitea.teabag.tb.Teabag;

@Service
public class BBSDAO {
	
	@Autowired
	private SqlSession ss;
	
	private int countBBS;
	
	public void countSNS(HttpServletRequest req) {
		Teabag t = (Teabag) req.getSession().getAttribute("teabag");
		countBBS = ss.getMapper(TeabagBBSMapper.class).countBBS(new BBS(null, null, null, null, t.getHt_no(), null, null));
	}
	
	public void writeBBS(BBS b, HttpServletRequest req, HttpServletResponse res){
		Member m = (Member) req.getSession().getAttribute("loginMember");
		Teabag t = (Teabag) req.getSession().getAttribute("teabag");
		b.setHb_id(m.getHm_id());
		b.setHb_tno(t.getHt_no());
		ss.getMapper(TeabagBBSMapper.class).writeBBS(b);
		countBBS++;
	}
	
	public BBS getBBSByNo(HttpServletRequest req, HttpServletResponse res){
		return ss.getMapper(TeabagBBSMapper.class).getBBSByNo(new BBS(new BigDecimal(req.getParameter("hb_no")) , null, null, null, null, null, null) );
	}
	
	public void updateBBS(BBS b, HttpServletRequest req, HttpServletResponse res){
		ss.getMapper(TeabagBBSMapper.class).updateBBS(b);
	}
	
	public void deleteBBS(BBS b, HttpServletRequest req, HttpServletResponse res){
		ss.getMapper(TeabagBBSMapper.class).deleteBBS(b);
		countBBS--;
	}
	
	public void getBBSByTNo(HttpServletRequest req, HttpServletResponse res) {
		Teabag t = (Teabag) req.getSession().getAttribute("teabag");

		int pageNo = 1;
		if (req.getSession().getAttribute("pageNo") != null) {
			pageNo = (Integer) req.getSession().getAttribute("pageNo");
		}

		double count = 10.0; // 한 페이지당 보여줄 갯수

		int pageCount = (int) Math.ceil(countBBS / count);
		
		req.setAttribute("pageCount", pageCount);

		int start = (countBBS - ((pageNo - 1) * (int) count)); 
																
		int end = (pageNo == pageCount) ? 1 : (int) (start - ((int) count - 1)); 
																				
		MinMax mm = new MinMax(new BigDecimal(start), new BigDecimal(end), t.getHt_no());

		List<BBS> bbs = ss.getMapper(TeabagBBSMapper.class).getBBSForPage(mm);

		req.setAttribute("allBBS", bbs);
	}
	
	public void setPage(int pageNo, HttpServletRequest req) {
		req.getSession().setAttribute("pageNo", pageNo);
	}
}


