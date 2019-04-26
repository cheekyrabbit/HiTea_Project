package com.ht.hitea.teabag.tb.dr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.hitea.member.MemberDAO;
import com.ht.hitea.teabag.tb.Teabags;

@Controller
public class DataroomController {

	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private DataroomDAO dDAO;
	
	@RequestMapping(value = "/teabag.dr.go", method = RequestMethod.GET)
	public String goDataroomTeabag(HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			req.getSession().setAttribute("pageNo2", null);
			req.getSession().setAttribute("pageNo3", null);
			dDAO.countDRPhoto(req);
			dDAO.countDRFile(req);
			req.setAttribute("teabagContentPage", "dataroom/teabagDataroom.jsp");
			req.setAttribute("contentPage", "teabag/teabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}

	@RequestMapping(value = "/teabag.dr.write", method = RequestMethod.POST)
	public String writeDataroomTeabag(Dataroom dr, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			req.getSession().setAttribute("pageNo2", null);
			req.getSession().setAttribute("pageNo3", null);
			dDAO.writeDR(dr, req, res);
			req.setAttribute("teabagContentPage", "dataroom/teabagDataroom.jsp");
			req.setAttribute("contentPage", "teabag/teabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/teabag.dr.getPhoto", method = RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public @ResponseBody Datarooms getPhotoByTNo(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("pageNo2", null);
		return dDAO.getPhotoByTNo(req, res);
	}

	@RequestMapping(value = "/teabag.dr.getFile", method = RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public @ResponseBody Datarooms getFileByTNo(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("pageNo3", null);
		return dDAO.getFileByTNo(req, res);
	}

	@RequestMapping(value = "/teabag.dr.pageCountFile", method = RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public @ResponseBody Integer pageCountFile(HttpServletRequest req, HttpServletResponse res) {
		return dDAO.pageCountFile(req);
	}

	@RequestMapping(value = "/teabag.dr.pageCountPhoto", method = RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public @ResponseBody Integer pageCountPhoto(HttpServletRequest req, HttpServletResponse res) {
		return dDAO.pageCountPhoto(req);
	}
	
	@RequestMapping(value = "/teabag.dr.delete", method = RequestMethod.GET)
	public String deleteFile(Dataroom dr, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			dDAO.deleteFile(dr, req, res);
			req.setAttribute("teabagContentPage", "dataroom/teabagDataroom.jsp");
			req.setAttribute("contentPage", "teabag/teabag.jsp");
			return "index";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/teabag.dr.pageFile", method = RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public @ResponseBody Datarooms goPageFile(@RequestParam(value="p") int p, HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("pageNo3", null);
		dDAO.setPageFile(p, req);
		return dDAO.getFileByTNo(req, res);
	}

	@RequestMapping(value = "/teabag.dr.pagePhoto", method = RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public @ResponseBody Datarooms goPagePhoto(@RequestParam(value="p") int p, HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("pageNo2", null);
		dDAO.setPagePhoto(p, req);
		return dDAO.getPhotoByTNo(req, res);
	}
	
}
