package com.ht.hitea.hart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.hitea.sns.SNSBean;

@Controller
public class HartController {
	
	@Autowired
	private HartDAO hDAO;
	
	@RequestMapping(value = "/hart.check", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody Harts hartCount(SNSBean s,HttpServletRequest req,HttpServletResponse res) {
		return hDAO.hartCheck(s);
	}
	@RequestMapping(value = "/hart.check.img", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody Harts hartImg(SNSBean s,HttpServletRequest req,HttpServletResponse res) {
		return hDAO.hartImgCheck(s);
	}
	@RequestMapping(value = "/hart.reg", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody Integer hartReg(SNSBean s,HttpServletRequest req,HttpServletResponse res) {
		return hDAO.hartReg(s,req);
	}
	@RequestMapping(value = "/hart.delete", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody Integer hartDelete(SNSBean s,HttpServletRequest req,HttpServletResponse res) {
		return hDAO.hartDelete(s);
	}
}
