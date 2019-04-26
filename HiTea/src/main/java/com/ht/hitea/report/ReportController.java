package com.ht.hitea.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class ReportController {
	
	@Autowired
	private ReportDAO rDAO;
	
	@RequestMapping(value = "/report.reg", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody Reports reportReg(Report re) {
		return rDAO.reportReg(re);
	}
	
	@RequestMapping(value = "/report.list", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody Reports reportList() {
		return rDAO.reportList();
	}
}
