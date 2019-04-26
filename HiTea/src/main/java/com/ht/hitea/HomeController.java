package com.ht.hitea;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ht.hitea.sns.SNSDAO;

@Controller
public class HomeController {
	
	@Autowired
	private SNSDAO snsDAO;
	
	private boolean firstReq;
	public HomeController() {
		firstReq = true;
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		if (firstReq) {
			snsDAO.getAllSNSCount();
			firstReq = false;
		}
		
		req.setAttribute("loginPage", "member/login.jsp");
		return "home";
	}

	
	@RequestMapping(value = "/jc", method = RequestMethod.GET)
	public String homeGo(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("loginPage", "member/login.jsp");
		return "home";
	}
	
	
}
