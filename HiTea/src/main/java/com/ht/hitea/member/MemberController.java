package com.ht.hitea.member;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.hitea.alram.AlramDAO;
import com.ht.hitea.sns.SNSDAO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private SNSDAO sDAO;
	
	@Autowired
	private AlramDAO aDAO;
	
	@RequestMapping(value = "/joinStepOneGo", method = RequestMethod.GET)
	public String joinOne(Member m, HttpServletRequest req) {
		req.setAttribute("homePage", "joinStepOne.jsp");
		req.setAttribute("loginPage", "member/homePage.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/joinStepTwoGo", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinTwoGo(Member m, HttpServletRequest req) {
		if (!"".equals(m.getHm_id())) {
			req.setAttribute("member", m);
		}
		req.setAttribute("homePage", "joinStepTwo.jsp");
		req.setAttribute("loginPage", "member/homePage.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/joinStepThreeGo", method = RequestMethod.POST)
	public String joinTwo(Member m, HttpServletRequest req) {
		req.setAttribute("member", m);
		req.setAttribute("homePage", "joinStepThree.jsp");
		req.setAttribute("loginPage", "member/homePage.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/joinStepFourGo", method = RequestMethod.POST)
	public String joinThreeStep(Member m, HttpServletRequest req, HttpServletResponse res) {

		String joinResult = "실패";

			if (!joinResult.equals(mDAO.join(m, req, res))) {
				req.setAttribute("homePage", "joinStepFour.jsp");
				req.setAttribute("loginPage", "member/homePage.jsp");				
			} else {
			req.setAttribute("homePage", "joinStepThree.jsp");
			req.setAttribute("loginPage", "member/homePage.jsp");
		}
		return "home";
	}
	
	@RequestMapping(value = "/idCheckJson", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody int idCheckJson(Member m) {
		return mDAO.idCheckJson(m);
	}

	@RequestMapping(value = "/nicknameCheckJson", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody int nicknameCheckJson(Member m) {
		return mDAO.nicknameCheckJson(m);
	}

	@RequestMapping(value = "/emailCheckJson", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody int emailCheckJson(Member m) {
		return mDAO.emailCheckJson(m);
	}
	
	@RequestMapping(value = "/idpwSearchGo", method = RequestMethod.GET)
	public String idpwSearch(Member m, HttpServletRequest req) {
		req.setAttribute("homePage", "idpwSearch.jsp");
		req.setAttribute("loginPage", "member/homePage.jsp");
		return "home";
	}

	@RequestMapping(value = "/idSearchGo", method = RequestMethod.GET)
	public String idSearchGo(Member m, HttpServletRequest req) {
		boolean idSearch = mDAO.idSearch(m, req);
		if (idSearch) {
			req.setAttribute("homePage", "idSearch.jsp");
			req.setAttribute("loginPage", "member/homePage.jsp");
		} else {
			req.setAttribute("homePage", "idpwSearch.jsp");
			req.setAttribute("loginPage", "member/homePage.jsp");
		}
		return "home";
	}

	@RequestMapping(value = "/pwSearchGo", method = RequestMethod.GET)
	public String pwSearchGo(Member m, HttpServletRequest req) throws AddressException, MessagingException {
		String pwSearchResult = "실패";
		
		if (!pwSearchResult.equals(mDAO.pwSearch(m, req))) {
			mDAO.pwEmail(m, req);
			req.setAttribute("homePage", "pwSearch.jsp");
			req.setAttribute("loginPage", "member/homePage.jsp");			
		} else {
			req.setAttribute("homePage", "idpwSearch.jsp");
			req.setAttribute("loginPage", "member/homePage.jsp");
		}
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Member m, HttpServletRequest req, HttpServletResponse res) {
		mDAO.login(m, req, res);
		if (mDAO.loginCheck(req, res)) {		
			sDAO.getAllSNS(req);
			aDAO.alramAll(req);
			req.setAttribute("contentPage", "sns/sns.jsp");			
			return "index";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/logout.go", method = RequestMethod.GET)
	public String logout(Member m, HttpServletRequest req, HttpServletResponse res) {
		mDAO.logout(req, res); 
		if (mDAO.loginCheck(req, res)) {
			sDAO.getAllSNS(req);
			req.setAttribute("contentPage", "sns/sns.jsp");
			return "index";
		} else {
			return "home";
		}
	}	
	
	@RequestMapping(value = "/myPageGo", method = RequestMethod.GET)
	public String myPage(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			req.setAttribute("myPage", "myPageWriting.jsp");
			req.setAttribute("contentPage", "member/myPage.jsp");			
			return "index";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/myPageUpdatePwCheckGo", method = RequestMethod.GET)
	public String myPageUpdate(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			req.setAttribute("myPage", "memberUpdatePwCheck.jsp");
			req.setAttribute("contentPage", "member/myPage.jsp");
			return "index";			
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/memberUpdateGo", method = RequestMethod.POST)
	public String memberUpdateGo(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			mDAO.memberUpdatePwCheck(m, req);
			req.setAttribute("contentPage", "member/myPage.jsp");
			return "index";			
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/memberUpdate", method = RequestMethod.POST)
	public String memberUpdate(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			mDAO.memberUpdate(m, req);
			req.setAttribute("myPage", "myPageWriting.jsp");
			req.setAttribute("contentPage", "member/myPage.jsp");
			return "index";			
		} else {
			return "home";
		}
	}

	@RequestMapping(value = "/memberDeleteGo", method = RequestMethod.GET)
	public String memberDeleteGo(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			req.setAttribute("myPage", "memberDelete.jsp");
			req.setAttribute("contentPage", "member/myPage.jsp");
			return "index";			
		} else {
			return "home";
		}
	}

	@RequestMapping(value = "/memberDelete", method = RequestMethod.GET)
	public String memberDelete(Member m, HttpServletRequest req) {
		mDAO.memberDelete(m, req);
		req.setAttribute("loginPage", "member/login.jsp");
		return "home";
	}

	@RequestMapping(value = "/myPageWritingGo", method = RequestMethod.GET)
	public String myPageWritingGo(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			// 게시글 버튼
			req.setAttribute("myPage", "myPageWriting.jsp");
			req.setAttribute("contentPage", "member/myPage.jsp");
			return "index";			
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/myPageMoimGo", method = RequestMethod.GET)
	public String myPageMoimGo(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			// 모임 버튼
			mDAO.myPageMyTBag(req);
			mDAO.myPageAffiliatedTBag(req);
			req.setAttribute("myPage", "myPageMoim.jsp");
			req.setAttribute("contentPage", "member/myPage.jsp");
			return "index";			
		} else {
			return "home";
		}
	}

	@RequestMapping(value = "/myPageGoodGo", method = RequestMethod.GET)
	public String myPageGoodGo(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			// 좋아요 버튼
			req.setAttribute("myPage", "myPageGood.jsp");
			req.setAttribute("contentPage", "member/myPage.jsp");
			return "index";			
		} else {
			return "home";
		}
	}

	@RequestMapping(value = "/myPageFollowGo", method = RequestMethod.GET)
	public String myPageFollowGo(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			// 팔로우 버튼
			mDAO.myPageFollow(req);
			req.setAttribute("myPage", "myPageFollow.jsp");
			req.setAttribute("contentPage", "member/myPage.jsp");
			return "index";			
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/myPageFollowingGo", method = RequestMethod.GET)
	public String myPageFollowingGo(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			// 팔로잉 버튼
			mDAO.myPageFollowing(req);
			req.setAttribute("myPage", "myPageFollowing.jsp");
			req.setAttribute("contentPage", "member/myPage.jsp");
			return "index";			
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/yourPageGo",  method = RequestMethod.GET)
	public String yourPageGo(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {				
			
			mDAO.yourPageInformation(m, req);
			req.setAttribute("myPage", "myPageWriting.jsp");
			req.setAttribute("contentPage", "member/yourPage.jsp");

			return "index";
		} else {
			return "home";				
		}			
	}
	
	@RequestMapping(value = "/yourPageWritingGo", method = RequestMethod.GET)
	public String yourPageWritingGo(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			// 게시글 버튼
			mDAO.yourPageInformation(m, req);
			req.setAttribute("myPage", "myPageWriting.jsp");
			req.setAttribute("contentPage", "member/yourPage.jsp");
			

			
			return "index";			
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/yourPageMoimGo", method = RequestMethod.GET)
	public String yourPageMoimGo(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			// 모임 버튼
			mDAO.yourPageInformation(m, req);
			mDAO.yourPageMyTBag(m, req);
			mDAO.yourPageAffiliatedTBag(m, req);
			req.setAttribute("myPage", "myPageMoim.jsp");
			req.setAttribute("contentPage", "member/yourPage.jsp");
			

			
			return "index";			
		} else {
			return "home";
		}
	}

	@RequestMapping(value = "/yourPageGoodGo", method = RequestMethod.GET)
	public String yourPageGoodGo(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			// 좋아요 버튼
			mDAO.yourPageInformation(m, req);
			req.setAttribute("myPage", "myPageGood.jsp");
			req.setAttribute("contentPage", "member/yourPage.jsp");
			

			
			return "index";			
		} else {
			return "home";
		}
	}

	@RequestMapping(value = "/yourPageFollowGo", method = RequestMethod.GET)
	public String yourPageFollowGo(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			// 팔로우 버튼
			mDAO.yourPageInformation(m, req);
			mDAO.yourPageFollow(m, req);
			req.setAttribute("myPage", "myPageFollow.jsp");
			req.setAttribute("contentPage", "member/yourPage.jsp");
			

			
			return "index";			
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/yourPageFollowingGo", method = RequestMethod.GET)
	public String yourPageFollowingGo(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.loginCheck(req, res)) {
			// 팔로잉 버튼
			mDAO.yourPageInformation(m, req);
			mDAO.yourPageFollowing(m, req);
			req.setAttribute("myPage", "myPageFollowing.jsp");
			req.setAttribute("contentPage", "member/yourPage.jsp");

			return "index";			
		} else {
			return "home";
		}
	}
	
	// Messenger
	@RequestMapping(value="/member.get.all", 
				method=RequestMethod.GET,
				produces="application/json; charset=utf-8")
	public @ResponseBody Members getAllMemberJSON() {
		return mDAO.getAllMemberJSON();
	}
	
	@RequestMapping(value="/member.get", 
		method=RequestMethod.GET,
		produces="application/json; charset=utf-8")
	public @ResponseBody Member getMemberByIDJSON(HttpServletRequest request) {
		return mDAO.getMemberByIDJSON(request);
	}
	
}
