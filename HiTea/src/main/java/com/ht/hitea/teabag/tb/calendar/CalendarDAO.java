package com.ht.hitea.teabag.tb.calendar;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.hitea.teabag.tb.Teabag;
import com.ht.hitea.teabag.tb.member.PageNotice;
import com.ht.hitea.teabag.tb.member.TeabagMemberMapper;

@Service
public class CalendarDAO {

	@Autowired
	private SqlSession ss;
	
	public void getToday(HttpServletRequest req){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date d = new Date();
		String today = sdf.format(d);
		
		req.setAttribute("today", today);
	}
	
	public void writeCalendar(Calendar c, HttpServletRequest req, HttpServletResponse res){
		try {
			Teabag t = (Teabag) req.getSession().getAttribute("teabag");
			String hc_start = req.getParameter("hc_start");
			String hc_end = req.getParameter("hc_end");
			String hpn_content = t.getHt_name() +" 티백에 일정이 추가되었습니다.";
			c.setHc_tno(t.getHt_no());
			boolean bbb = true;
			if(Integer.parseInt(hc_end)-Integer.parseInt(hc_start)>0){
				bbb = false;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			hc_end = sdf2.format(sdf.parse(hc_end));
			if(!bbb){
				hc_end = hc_end +"T24:00:00";
			}
			c.setHc_start(sdf2.format(sdf.parse(hc_start)));
			c.setHc_end(hc_end);
			if(req.getParameter("hc_content").equals("")){
				c.setHc_content("undefined");
			}
			if(ss.getMapper(TeabagCalendarMapper.class).writeCalendar(c) == 1){
				ss.getMapper(TeabagMemberMapper.class).sendPageNotice(new PageNotice(null, "null", t.getHt_no(), hpn_content, "all", null, null));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Calendars getCalendarByTNo(HttpServletRequest req, HttpServletResponse res){
		Teabag t = (Teabag) req.getSession().getAttribute("teabag");
		return new Calendars(ss.getMapper(TeabagCalendarMapper.class).getCalendarByTNo(new Calendar(null, t.getHt_no(), null, null, null, null, null)));
	}
	
	public void deleteCalendarByNo(HttpServletRequest req, HttpServletResponse res){
		ss.getMapper(TeabagCalendarMapper.class).deleteCalendarByNo(new Calendar(new BigDecimal(req.getParameter("hc_no")), null, null, null, null, null, null));
	}
	
}
