package com.ht.hitea.sns;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.hitea.alram.AlramDAO;
import com.ht.hitea.member.MemberDAO;

@Controller
public class SNSReplController {
	
	@Autowired
	private SNSDAO sDAO;

	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private AlramDAO aDAO;
	
	
    @RequestMapping(value = "/snsRewrite.go", method = RequestMethod.GET)
   	public String snsReWrite(SNSRepl sr, HttpServletRequest req, HttpServletResponse res) {
    	
    	if (mDAO.loginCheck(req, res)) {
    		sDAO.snsReWrite(sr, req);
    		sDAO.getAllSNS(req);
    		aDAO.alramAll(req);
    		req.setAttribute("contentPage", "sns/sns.jsp");
    		return "index";
    	} else {
    		return "home";
    	}
    }
    
    
    @RequestMapping(value = "/snsRedelete.go", method = RequestMethod.GET)
    public String snsReDel(SNSRepl sr, HttpServletRequest req, HttpServletResponse res) {
    	
    	if (mDAO.loginCheck(req, res)) {
    		sDAO.snsReDelete(sr, req);
    		sDAO.getAllSNS(req);
    		aDAO.alramAll(req);

    		req.setAttribute("contentPage", "sns/sns.jsp");
    		return "index";
    	} else {
    		return "home";
    	}
    }
    
	@RequestMapping(value = "/sns.Repl.ajax", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	public @ResponseBody SNSRepls snsReplNoAjax(SNSBean s){	
		return sDAO.getAllRepl2(s);
		
	}
	@RequestMapping(value = "/sns.Repl3.ajax", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	public @ResponseBody SNSRepls snsReplNoAjax3(SNSBean s){	
		return sDAO.getAllRepl(s);
		
	}
	
	@RequestMapping(value = "/sns.repl.reg", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody SNSRepls snsReplReg(SNSRepl sr,HttpServletRequest req,HttpServletResponse res) {
		return sDAO.regRepls(sr, req);
	}
	@RequestMapping(value = "/sns.repl.delete", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody int snsReplDelete(SNSRepl sr,HttpServletRequest req,HttpServletResponse res) {
		return sDAO.deleteRepls(sr);
	}
}
