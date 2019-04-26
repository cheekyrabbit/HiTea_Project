package com.ht.hitea.messenger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.hitea.member.MemberDAO;
import com.ht.hitea.member.Members;

@Controller
public class MessengerController {

	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private MessengerDAO msgDAO;
	
	@RequestMapping(value="/messenger", method=RequestMethod.GET)
	public String goMessenger(HttpServletRequest request, HttpServletResponse response) {
		if (mDAO.loginCheck(request, response)) {
			msgDAO.getMsgFollowerList(request);
			request.setAttribute("contentPage", "messenger/messenger.jsp");
			return "index";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value="/find.follower", 
			method=RequestMethod.GET, 
			produces="application/json; charset=utf-8")
	public @ResponseBody Members getFollowerListByNickname(HttpServletRequest request) {
		return msgDAO.getMsgFollowerListByNickname(request);
	}
	
	@RequestMapping(value="/messenger.list.get.all", 
			method=RequestMethod.GET, 
			produces="application/json; charset=utf-8")	
	public @ResponseBody MessengerLists getAllMsgList(HttpServletRequest request) {
		return msgDAO.getAllMsgListJSON(request);
	}
	
	@RequestMapping(value="/messenger.list.get", 
			method=RequestMethod.GET, 
			produces="application/json; charset=utf-8")	
	public @ResponseBody MessengerLists getMsgList(HttpServletRequest request) {
		return msgDAO.getMsgListByLoginId(request);
	}
	
	@RequestMapping(value="/messenger.list.check.1", 
			method=RequestMethod.GET, 
			produces="application/json; charset=utf-8")	
	public @ResponseBody MessengerLists checkMsgList1(HttpServletRequest request) {
		return msgDAO.checkMsgList(request);
	}
	
	@RequestMapping(value="/messenger.list.check.2", 
			method=RequestMethod.GET, 
			produces="application/json; charset=utf-8")	
	public @ResponseBody MessengerLists checkMsgList2(HttpServletRequest request) {
		return msgDAO.checkMsgList(request);
	}
	
	@RequestMapping(value="/messenger.list.reg", method=RequestMethod.GET)	
	public String regMsgList(HttpServletRequest request, HttpServletResponse response) {
		if (mDAO.loginCheck(request, response)) {			
			msgDAO.getMsgFollowerList(request);
			msgDAO.regMsgList(request);
			request.setAttribute("contentPage", "messenger/messenger.jsp");
			return "index";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value="/messenger.list.real", 
			method=RequestMethod.GET, 
			produces="application/json; charset=utf-8")	
	public @ResponseBody MessengerLists getRealMsgList(HttpServletRequest request) {
		return msgDAO.getRealMsgList(request);
	}
	
	@RequestMapping(value="/messenger.list.update", method=RequestMethod.GET)	
	public String updateMsgList(HttpServletRequest request, HttpServletResponse response) {
		if (mDAO.loginCheck(request, response)) {			
			msgDAO.getMsgFollowerList(request);
			msgDAO.updateMsgList(request);			
			request.setAttribute("contentPage", "messenger/messenger.jsp");
			return "index";
		} else {
			return "home";
		}
	}	
	
	@RequestMapping(value="/message.delete", method=RequestMethod.GET)	
	public String deleteMsgList(HttpServletRequest request, HttpServletResponse response) {
		if (mDAO.loginCheck(request, response)) {			
			msgDAO.getMsgFollowerList(request);
			msgDAO.deleteMsg(request);
			request.setAttribute("contentPage", "messenger/messenger.jsp");
			return "index";
		} else {
			return "home";
		}
	}	
}
