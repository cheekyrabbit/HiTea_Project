package com.ht.hitea.sns;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.hitea.alram.AlramDAO;
import com.ht.hitea.member.Member;
import com.ht.hitea.member.MemberDAO;

@Controller
public class FileUploadController2 {
	
	@Autowired
	private SNSDAO sDAO;
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private AlramDAO aDAO;


	@RequestMapping(value = "/sns", method = RequestMethod.GET)
	public String login(SNSBean s, FileUploadBean2 f, Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
    		sDAO.getAllSNS(req);
    		aDAO.alramAll(req);
    		req.setAttribute("contentPage", "sns/sns.jsp");
    		return "index";
    	} else {
    		return "home";
    	} 
	}

	@RequestMapping(value = "/sns2", method = RequestMethod.GET)
	public String snsFollow(SNSBean s, FileUploadBean2 f, Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			sDAO.getAllSNS(req);
			aDAO.alramAll(req);
			req.setAttribute("contentPage", "sns/sns2.jsp");
			return "index";
		} else {
			return "home";
		} 
	}
	@RequestMapping(value = "/sns.go", method = RequestMethod.GET)
	public String loginGo(SNSBean s, FileUploadBean2 f, Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			sDAO.getAllSNS(req);
			aDAO.alramAll(req);
			req.setAttribute("contentPage", "sns/sns.jsp");
			return "index";
		} else {
			return "home";
		} 
	}
	
	
    @RequestMapping(value = "/fileUpload2.do", method = RequestMethod.POST)
    public String fileUpload2(SNSBean s, FileUploadBean2 f, HttpServletRequest req, HttpServletResponse res) {
    	if (mDAO.loginCheck(req, res)) {
    		sDAO.fileUpload(s, f, req);
    		sDAO.getAllSNS(req);
    		aDAO.alramAll(req);
    		
  

    		req.setAttribute("contentPage", "sns/sns.jsp");
    		return "index";
    	} else {
    		return "home";
    	} 
    }
    
	
	@RequestMapping(value = "/sns.delete.go", method = RequestMethod.GET)
	public String snsDelete(SNSBean s, HttpServletRequest req, HttpServletResponse res){
		if (mDAO.loginCheck(req, res)) {
			sDAO.snsDelete(s, req);
			sDAO.getAllSNS(req);
			aDAO.alramAll(req);
			req.setAttribute("contentPage", "sns/sns.jsp");
    		return "index";
    	} else {
    		return "home";
    	}
	}
	
	@RequestMapping(value = "/sns.getNoSns", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	public @ResponseBody SNSBeans snsNo(SNSBean s, HttpServletRequest req, HttpServletResponse res){
		
		return sDAO.getJsonNo(s, req, res);
		
	}
	@RequestMapping(value = "/sns.page.ajax", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	public @ResponseBody SNSs snsNoAjax(int page,HttpServletRequest req, HttpServletResponse res){	
		return sDAO.getAllSNSAjax(page, req);
		
	}
	@RequestMapping(value = "/page.go.sns", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody SNSs pageSNS(int page,String pageId,HttpServletRequest req,HttpServletResponse res) {
		return sDAO.snsPage(page, pageId, req);	
	}
	@RequestMapping(value = "/page.go.heart", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody SNSs snsPageHeart(int page,String pageId,HttpServletRequest req,HttpServletResponse res) {
		return sDAO.snsPageHeart(page, pageId, req);
	}
	@RequestMapping(value = "/sns.delete.ajax", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody int snsDeleteAJAX(SNSBean s, HttpServletRequest req, HttpServletResponse res) {
		return sDAO.snsDeleteAJAX(s, req);
	}
    
	
}
