package com.ht.hitea.teabag.tb.calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.hitea.member.MemberDAO;

@Controller
public class CalendarController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private CalendarDAO cDAO;
	
	@RequestMapping(value = "/teabag.calendar.go", method = RequestMethod.GET)
	public String goCalendarTeabag(HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			cDAO.getToday(req);
			req.setAttribute("teabagContentPage", "calendar/teabagCalendar.jsp");
			req.setAttribute("contentPage", "teabag/teabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}

	@RequestMapping(value = "/teabag.calendar.write", method = RequestMethod.GET)
	public String writeCalendarTeabag(Calendar c, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			cDAO.writeCalendar(c, req, res);
			req.setAttribute("teabagContentPage", "calendar/teabagCalendar.jsp");
			req.setAttribute("contentPage", "teabag/teabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/teabag.calendar.getCalendar", method = RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public @ResponseBody Calendars getPhotoByTNo(HttpServletRequest req, HttpServletResponse res) {
		return cDAO.getCalendarByTNo(req, res);
	}
	
	@RequestMapping(value = "/teabag.calendar.delete", method = RequestMethod.GET)
	public String deleteCalendarTeabag(HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			cDAO.deleteCalendarByNo(req, res);
			req.setAttribute("teabagContentPage", "calendar/teabagCalendar.jsp");
			req.setAttribute("contentPage", "teabag/teabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}
}
