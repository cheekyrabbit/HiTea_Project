package com.ht.hitea.follow;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.hitea.sns.SNSs;

@Controller
public class FollowController {
	@Autowired
	private FollowDAO foDAO;
	
	@RequestMapping(value = "/follow.follower", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody Integer followerCount(Follow fo) {
		return foDAO.follower(fo);
	}
	@RequestMapping(value = "/follow.following", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody Integer followingCount(Follow fo) {
		return foDAO.following(fo);
	}
	@RequestMapping(value = "/follow.followerCheck", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody Follows followerCheck(Follow fo) {
		return foDAO.followCheck(fo);
	}
	@RequestMapping(value = "/follow.followerReg", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody Integer followerReg(Follow fo,HttpServletRequest req) {
		return foDAO.followerReg(fo,req);
	}
	@RequestMapping(value = "/follow.followerDelete", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody Integer followerDelete(Follow fo) {
		return foDAO.followerDelete(fo);
	}
	@RequestMapping(value = "/follow.sns", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody SNSs snsFollow(int page,String ssid,HttpServletRequest req) {
		return foDAO.snsFollow(page, ssid, req);
	}
}
