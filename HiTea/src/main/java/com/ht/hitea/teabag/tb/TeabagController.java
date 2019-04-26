package com.ht.hitea.teabag.tb;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.hitea.member.MemberDAO;
import com.ht.hitea.sns.SNSs;
import com.ht.hitea.teabag.tb.member.TbMemberDAO;


// sertvlet-context.xml에 등록해놓은거는 사용하지 않아도 다 생성 (AAC방식)
// dao에 @service 붙이는 것도 servlet-context.xml에 자동 등록.
// HomeController, SNSDAO, SqlSession
// 생성 순서를 원하는대로 돌리고 싶음.

@Controller // servlet-context.xml에 등록, 컨트롤러 역할로 사용
public class TeabagController { 
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private TeabagDAO tDAO;
	
	@Autowired
	private TbMemberDAO tmDAO;
	
	@RequestMapping(value = "/site.teabag.home", method = RequestMethod.GET)
	public String bandHome(HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			tDAO.countTeabagByLeader(req);
			req.setAttribute("contentPage", "teabag/allTeabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}

	@RequestMapping(value = "/site.teabag.make.go", method = RequestMethod.GET)
	public String goMakeTeabag(HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			req.setAttribute("contentPage", "teabag/makeTeabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}

	@RequestMapping(value = "/site.teabag.make", method = RequestMethod.GET)
	public String makeTeabag(Teabag b, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			tDAO.countTeabagByLeader(req);
			tDAO.makeTeabag(b, req, res);
			req.setAttribute("contentPage", "teabag/allTeabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/site.teabag.getAll", method = RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public @ResponseBody Teabags getFourBands(HttpServletRequest req, HttpServletResponse res) {
		return tDAO.getFourTeabags(req, res);
	}

	@RequestMapping(value = "/site.teabag.getBandByBNo", method = RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public @ResponseBody Teabag getBandByBNo(HttpServletRequest req, HttpServletResponse res) {
		return tDAO.getTeabagByTNo(req);
	}
	
	@RequestMapping(value = "/site.teabag.go", method = RequestMethod.GET)
	public String goTeabag(HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			tDAO.firstGoTeabag(req, res);
			req.setAttribute("teabagContentPage", "teabagSNS.jsp");
			req.setAttribute("contentPage", "teabag/teabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}

	@RequestMapping(value = "/site.teabag.join", method = RequestMethod.GET)
	public String joinTeabag(HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			tDAO.firstGoTeabag(req, res);
			req.setAttribute("contentPage", "teabag/teabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/site.teabag.leave", method = RequestMethod.GET)
	public String leaveTeabag(HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			tDAO.leaveTeabag(req, res);
			tDAO.firstGoTeabag(req, res);
			req.setAttribute("contentPage", "teabag/teabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}

	@RequestMapping(value = "/site.teabag.set", method = RequestMethod.GET)
	public String setTeabag(HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			tDAO.firstGoTeabag(req, res);
			req.setAttribute("teabagContentPage", "setTeabag.jsp");
			req.setAttribute("contentPage", "teabag/teabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}

	@RequestMapping(value = "/site.teabag.update", method = RequestMethod.POST)
	public String updateTeabag(Teabag b, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			tDAO.updateTeabag(b, req, res);
			req.setAttribute("contentPage", "teabag/allTeabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/site.teabag.updateNotice", method = RequestMethod.GET)
	public String updateNotice(Teabag t, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			tDAO.updateNotice(t, req, res);
			req.setAttribute("teabagContentPage", "teabagSNS.jsp");
			req.setAttribute("contentPage", "teabag/teabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}

	@RequestMapping(value = "/site.teabag.deleteTeabag", method = RequestMethod.GET)
	public String deleteTeabag(HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			tDAO.deleteTeabag(req);
			req.setAttribute("contentPage", "teabag/allTeabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}

	@RequestMapping(value = "/site.teabag.getFourTeabagById", method = RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public @ResponseBody Teabags getFourTeabagById(HttpServletRequest req, HttpServletResponse res) {
		return tDAO.getFourTeabagById(req, res);
	}

	@RequestMapping(value = "/site.teabag.getTeabagById", method = RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public @ResponseBody Teabags getTeabagById(HttpServletRequest req, HttpServletResponse res) {
		return tDAO.getTeabagById(req, res);
	}

	@RequestMapping(value = "/site.teabag.getAllTeabag", method = RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public @ResponseBody Teabags getAllTeabag(HttpServletRequest req, HttpServletResponse res) {
		return tDAO.getAllTeabag(req);
	}

	@RequestMapping(value = "/site.teabag.getTeabagByCategory", method = RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public @ResponseBody Teabags getTeabagByCategory(Teabag t, HttpServletRequest req, HttpServletResponse res) {
		return tDAO.getTeabagByCategory(t, req);
	}
	
	@RequestMapping(value = "/site.teabag.getTeabagByName", method = RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public @ResponseBody Teabags getTeabagByName(Teabag t, HttpServletRequest req, HttpServletResponse res) {
		return tDAO.getTeabagByName(t, req);
	}
	@RequestMapping(value = "/site.teabag.sns", method = RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public @ResponseBody SNSs getAllTeaBagSNSAjax(int page,String teabag, HttpServletRequest req, HttpServletResponse res) {
		return tDAO.getAllTeaBagSNSAjax(page, teabag, req);
	}
}
