package com.ht.hitea.teabag.tb.bbs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.hitea.member.MemberDAO;


// sertvlet-context.xml에 등록해놓은거는 사용하지 않아도 다 생성 (AAC방식)
// dao에 @service 붙이는 것도 servlet-context.xml에 자동 등록.
// HomeController, SNSDAO, SqlSession
// 생성 순서를 원하는대로 돌리고 싶음.

@Controller // servlet-context.xml에 등록, 컨트롤러 역할로 사용
public class BBSController { 
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private BBSDAO bDAO;
	
	@RequestMapping(value = "/teabag.bbs.go", method = RequestMethod.GET)
	public String goBBSTeabag(HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			bDAO.countSNS(req);
			bDAO.setPage(1, req);
			bDAO.getBBSByTNo(req, res);
			req.setAttribute("teabagContentPage", "bbs/teabagBBS.jsp");
			req.setAttribute("contentPage", "teabag/teabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}
	@RequestMapping(value = "/teabag.sns.go", method = RequestMethod.GET)
	public String goSNSTeabag(HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			req.setAttribute("teabagContentPage", "teabagSNS.jsp");
			req.setAttribute("contentPage", "teabag/teabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}

	@RequestMapping(value="/teabag.bbs.page", method=RequestMethod.GET)
	public String goPage(@RequestParam(value="p") int p, HttpServletRequest req, HttpServletResponse res){
		if(mDAO.loginCheck(req, res)){
			bDAO.setPage(p, req);
			bDAO.getBBSByTNo(req, res);
			req.setAttribute("teabagContentPage", "bbs/teabagBBS.jsp");
			req.setAttribute("contentPage", "teabag/teabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/teabag.bbs.write", method = RequestMethod.GET)
	public String writeBBSTeabag(BBS b, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			bDAO.writeBBS(b, req, res);
			bDAO.getBBSByTNo(req, res);
			req.setAttribute("teabagContentPage", "bbs/teabagBBS.jsp");
			req.setAttribute("contentPage", "teabag/teabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/teabag.bbs.goUpdate", method = RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public @ResponseBody BBS getBBSByNo(HttpServletRequest req, HttpServletResponse res) {
		return bDAO.getBBSByNo(req, res);
	}
	
	@RequestMapping(value = "/teabag.bbs.update", method = RequestMethod.GET)
	public String updateBBSTeabag(BBS b, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			bDAO.updateBBS(b, req, res);
			bDAO.getBBSByTNo(req, res);
			req.setAttribute("teabagContentPage", "bbs/teabagBBS.jsp");
			req.setAttribute("contentPage", "teabag/teabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}

	@RequestMapping(value = "/teabag.bbs.delete", method = RequestMethod.GET)
	public String deleteBBSTeabag(BBS b, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			bDAO.deleteBBS(b, req, res);
			bDAO.getBBSByTNo(req, res);
			req.setAttribute("teabagContentPage", "bbs/teabagBBS.jsp");
			req.setAttribute("contentPage", "teabag/teabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}

}