package com.ht.hitea.seach;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.hitea.member.MemberDAO;
import com.ht.hitea.member.Members;
import com.ht.hitea.sns.SNSs;

@Controller
public class SeachController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private SeachDAO seachDAO;
	
	@RequestMapping(value = "/seach.go", method = RequestMethod.GET)
	public String seachGo(HttpServletRequest req, HttpServletResponse res) {
		
		if (mDAO.loginCheck(req, res)) {
			req.setAttribute("contentPage", "seach/seach.jsp");
			return "index";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/seach.go.member", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody Members seachMember(int page,String etseach,HttpServletRequest req,HttpServletResponse res) {
			return seachDAO.memberSeach(page, etseach, req);	
	}
	@RequestMapping(value = "/seach.go.member.count", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody Integer seachMemberCont(String etseach) {
		return seachDAO.memberSeachCount(etseach);	
	}
	
	@RequestMapping(value = "/seach.go.teabag", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody TeaBagSeachs seachTeabag(int page,String etseach,HttpServletRequest req,HttpServletResponse res) {
		return seachDAO.teabagSeach(page, etseach, req);	
	}
	@RequestMapping(value = "/seach.go.teabag.count", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody Integer seachTeabagCont(String etseach) {
		return seachDAO.teabagSeachCount(etseach);
	}
	@RequestMapping(value = "/seach.go.sns", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody SNSs seachSNS(int page,String seach,HttpServletRequest req,HttpServletResponse res) {
		return seachDAO.snsSeach(page, seach, req);	
	}
	@RequestMapping(value = "/seach.sns.all", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody Integer seachSNSAll(String seach,HttpServletRequest req,HttpServletResponse res) {
		return seachDAO.snsSeachAll(seach);	
	}
}
