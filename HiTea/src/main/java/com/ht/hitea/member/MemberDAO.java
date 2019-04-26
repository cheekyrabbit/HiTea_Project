package com.ht.hitea.member;

import java.io.File;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {

	@Autowired
	private SqlSession ss;
	
	private String emailID = "nadaas"; 
	private String emailPW = "qweasd123!"; 
	private String uuid = UUID.randomUUID().toString().replaceAll("-", "");
	private String receiver = ""; // 받는사람 이메일

	private String memberUpdatePath2 = "/resources/img/member";
	private File f = null;
	
	public boolean loginCheck(HttpServletRequest req, HttpServletResponse res) {
		autologin(req, res);
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		if (m != null) {
			return true;
		} else {
			req.setAttribute("loginPage", "member/login.jsp");
			return false;
		}
	}
	
	public void login(Member m, HttpServletRequest req, HttpServletResponse res) {
		try {
			Member dbM = ss.getMapper(MemberMapper.class).getMemberByID(m);
			dbM.setHm_selfIntroduction2(dbM.getHm_selfIntroduction());
			dbM.setHm_selfIntroduction(dbM.getHm_selfIntroduction().replaceAll("\r\n", "<br>"));
			String photo_front = dbM.getHm_photo_front().replaceAll(" ", "%20");
			String photo_back = dbM.getHm_photo_back().replaceAll(" ", "%20");
			dbM.setHm_photo_front(photo_front);
			dbM.setHm_photo_back(photo_back);
			
			if (dbM != null) {
				if (m.getHm_pw().equals(dbM.getHm_pw())) {
					req.getSession().setAttribute("loginMember", dbM);
					req.getSession().setMaxInactiveInterval(60 * 60 * 60);
					String hm_auto = req.getParameter("hm_auto");
					
					if (hm_auto != null) {
						Cookie autoLoginID = new Cookie("autoLoginID", m.getHm_id());
						autoLoginID.setMaxAge(1 * 60 * 60 * 24);
						res.addCookie(autoLoginID);
					}
					
				} else {
					req.setAttribute("result", "비밀번호 오류");
				}
			} else {
				req.setAttribute("result", "미가입 ID");
			}
		} catch (Exception e) {
			req.setAttribute("result", "DB 서버 오류");
			e.printStackTrace();
		}
	}
	
	public void autologin(HttpServletRequest req, HttpServletResponse res) {
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("autoLoginID")) {
					String hm_id = c.getValue();
					if (hm_id != null && hm_id != "") {
						try {
							Member m = new Member(hm_id, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
							Member mm = ss.getMapper(MemberMapper.class).getMemberByID(m);

							if (mm != null) {
								mm.setHm_photo_front(mm.getHm_photo_front().replaceAll(" ", "%20"));
								mm.setHm_photo_back(mm.getHm_photo_back().replaceAll(" ", "%20"));
								
								req.getSession().setAttribute("loginMember", mm);
								req.getSession().setMaxInactiveInterval(10 * 60);

							} else {
								req.setAttribute("result", "미가입 ID");
							}

						} catch (Exception e) {
							req.setAttribute("result", "DB서버 문제");
						}
					}
				}
			}
		}

	}
	
	public void logout(HttpServletRequest req, HttpServletResponse res) {

		req.getSession().setAttribute("loginMember", null);
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("autoLoginID")) {
					c.setValue(null);
					res.addCookie(c);
				}
			}
		}
	}
	
	
	
	public String join(Member m, HttpServletRequest req, HttpServletResponse res) {
		try {
			String hm_id = m.getHm_id();
			m.setHm_id(hm_id);

			String hm_pw = m.getHm_pw();
			m.setHm_pw(hm_pw);

			String hm_nickname = m.getHm_nickname();
			m.setHm_nickname(hm_nickname);

			String hm_name = req.getParameter("hm_name");
			m.setHm_name(hm_name);

			
			String emailId = req.getParameter("emailId");
			String emailAddress = req.getParameter("emailAddress");
			String emailDirect = req.getParameter("emailDirect");
			String hm_email = null;

			if (emailDirect != "") {
				emailAddress = emailDirect;
				hm_email = emailId + "@" + emailDirect;
				m.setHm_email(hm_email);
			} else {
				hm_email = emailId + "@" + emailAddress;
				m.setHm_email(hm_email);
			}

			String hm_pw_question = req.getParameter("hm_pw_question");
			m.setHm_pw_question(hm_pw_question);

			String hm_pw_answer = req.getParameter("hm_pw_answer");
			m.setHm_pw_answer(hm_pw_answer);

			String hm_seifIntroduction = "안녕하세요";
			m.setHm_selfIntroduction(hm_seifIntroduction);

			String hm_photo_front = "photo_front.png";
			m.setHm_photo_front(hm_photo_front);
			String hm_photo_back = "photo_back.jpg"; 
			m.setHm_photo_back(hm_photo_back);

			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				Cookie joinId = new Cookie("joinId", m.getHm_id());
				joinId.setMaxAge(30);
				res.addCookie(joinId);
				req.setAttribute("member", m);
				return "성공";
			} else {
				return "실패";
			}
			
		} catch (Exception e) {
			return "실패";			
		}
	}
	
	public int idCheckJson(Member m) {
		return new Integer(ss.getMapper(MemberMapper.class).idCheckJson(m));
	}

	public int nicknameCheckJson(Member m) {
		return new Integer(ss.getMapper(MemberMapper.class).nicknameCheckJson(m));
	}

	public int emailCheckJson(Member m) {
		return new Integer(ss.getMapper(MemberMapper.class).emailCheckJson(m));
	}
	
	public boolean idSearch(Member m, HttpServletRequest req) {
		String hm_name = req.getParameter("hm_name");
		m.setHm_name(hm_name);

		String hm_email = req.getParameter("hm_email");
		m.setHm_email(hm_email);;

		m = new Member(null, null, null, hm_name, hm_email, null, null, null, null, null, null, null, null, null, null, null, null, null,null);
		Member mm = ss.getMapper(MemberMapper.class).idSearch(m);

		if (mm != null) {
			req.setAttribute("memberID", mm);
			return true;
		} else {
			req.setAttribute("idSearchResult", "아이디 찾기 실패");
			return false;
		}
	}
	
	public String temporarilyPw() {
		String pw = null;
		
		for (int i = 0; i < 6; i++) {
			pw = uuid.substring(0, 6);
		}
		return pw;
	}

	public void pwEmail(Member m, HttpServletRequest req) {
		try {
			String host = "smtp.daum.net";
			int port = 465;

			receiver = this.pwSearchEmail(m, req);

			String sender = "HITEA<nadaas@daum.net>";

			// Property 정보 생성
			Properties props = System.getProperties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", port);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.ssl.trust", host);

			// 사용자 인증
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication(emailID, emailPW);
				}
			});
			session.setDebug(true);

			Message mimeMessage = new MimeMessage(session); // MimeMesage 생성
			mimeMessage.setFrom(new InternetAddress(sender)); // 보내는 EMAIL (정확히 적어야 SMTP 서버에서 인증 실패되지 않음)
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));

			mimeMessage.setSubject("임시비밀번호");
			String temporarilyPw = this.temporarilyPw();
			mimeMessage.setText("임시비밀번호 : " + temporarilyPw);

			Transport.send(mimeMessage); // Transfer

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String pwSearch(Member m, HttpServletRequest req) {
			String hm_id = req.getParameter("hm_id");
			m.setHm_id(hm_id);

			String hm_pw_question = req.getParameter("hm_pw_question");
			m.setHm_pw_question(hm_pw_question);

			String hm_pw_answer = req.getParameter("hm_pw_answer");
			m.setHm_pw_answer(hm_pw_answer);

			String temporarilyPw = this.temporarilyPw();
			m.setHm_pw(temporarilyPw);

			if (ss.getMapper(MemberMapper.class).pwSearch(m) == 1) {
				req.setAttribute("pwSearchEmail", m);
				return "성공";
			} else {
				req.setAttribute("pwSearchResult", "비밀번호 찾기 실패");
				return "실패";
			}
	}
	
	public String pwSearchEmail(Member m, HttpServletRequest req){
		Member pwSearchEmail = (Member) req.getAttribute("pwSearchEmail");
		String hm_id = pwSearchEmail.getHm_id();
		String hm_pw_question = pwSearchEmail.getHm_pw_question();
		String hm_pw_answer = pwSearchEmail.getHm_pw_answer();
		m = new Member(hm_id, null, null, null, null, hm_pw_question, hm_pw_answer, null, null, null, null, null, null, null, null, null, null, null,null);
		Member mm = ss.getMapper(MemberMapper.class).temporarilyPwEmail(m);

		if (mm != null) {
			req.setAttribute("memberPW", mm);
			return mm.getHm_email();
		} else {
			req.setAttribute("pwSearchResult", "이메일 찾기 실패");
			return "실패";
		}
	}
	
	public void memberUpdatePwCheck(Member m, HttpServletRequest req) {
		Member loginMember = (Member) req.getSession().getAttribute("loginMember");
		String hm_id = loginMember.getHm_id();
		String hm_pw = req.getParameter("hm_pw");
			
		m = new Member(hm_id, hm_pw, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		int mm = ss.getMapper(MemberMapper.class).memberUpdatePwCheck(m);
		
		if (mm == 1) {
			req.setAttribute("myPage", "memberUpdate.jsp");
		} else {
			req.setAttribute("myPage", "memberUpdatePwCheck.jsp");
			req.setAttribute("pwCkeck", "비밀번호 오류");
		}	
	}
	
	public void memberUpdate(Member m , HttpServletRequest req){
		MultipartRequest mr = null;
		String memberUpdatePath = req.getSession().getServletContext().getRealPath(memberUpdatePath2);
		try {
			mr = new MultipartRequest(req, memberUpdatePath, 50 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "사진 수정 실패");
			return;
		}
		
		try {
			Member loginMember = (Member) req.getSession().getAttribute("loginMember");
			
			m.setHm_id(mr.getParameter("hm_id"));
			m.setHm_pw(mr.getParameter("hm_pw"));
			m.setHm_nickname(mr.getParameter("hm_nickname"));
			m.setHm_name(mr.getParameter("hm_name"));
			m.setHm_email(mr.getParameter("hm_email"));
			m.setHm_pw_question(mr.getParameter("hm_pw_question"));
			m.setHm_pw_answer(mr.getParameter("hm_pw_answer"));
			m.setHm_selfIntroduction2(mr.getParameter("hm_selfIntroduction"));
			m.setHm_selfIntroduction(mr.getParameter("hm_selfIntroduction").replaceAll("\r\n", "<br>"));
			
			String hm_photo_front = mr.getFilesystemName("hm_photo_front");
			String hm_photo_back = mr.getFilesystemName("hm_photo_back");
			if (hm_photo_front != null){
				hm_photo_front = URLEncoder.encode(hm_photo_front, "utf-8");
				hm_photo_front = hm_photo_front.replace("+", " ");
				
				String hm_photo_front_before = loginMember.getHm_photo_front();
				
				
				hm_photo_front_before = URLDecoder.decode(hm_photo_front_before, "utf-8");
								
				if(!hm_photo_front_before.equals("photo_front.png")){
					f = new File(memberUpdatePath + "/" + hm_photo_front_before);
					f.delete();					
				}
				m.setHm_photo_front(hm_photo_front);
				ss.getMapper(MemberMapper.class).memberSNSUpdate(m);
				ss.getMapper(MemberMapper.class).memberSNSRelUpdate(m);
			} else {
				hm_photo_front = loginMember.getHm_photo_front();
				m.setHm_photo_front(hm_photo_front);
			} 
			
			if (hm_photo_back != null) {
				hm_photo_back = URLEncoder.encode(hm_photo_back, "utf-8");
				hm_photo_back = hm_photo_back.replace("+", " ");
				
				String hm_photo_back_before = loginMember.getHm_photo_back();
				hm_photo_back_before = URLDecoder.decode(hm_photo_back_before, "utf-8");
				
				if (!hm_photo_back_before.equals("photo_back.jpg")) {
					f = new File(memberUpdatePath + "/" + hm_photo_back_before);
					f.delete();										
				}
				
				
			} else {
				hm_photo_back = loginMember.getHm_photo_back();
			} 
			m.setHm_photo_back(hm_photo_back);
			
			if (ss.getMapper(MemberMapper.class).memberUpdate(m) == 1) {
				req.getSession().setAttribute("loginMember", m);
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("memberUpdate", "실패");
			f = new File(memberUpdatePath + "/" + mr.getFilesystemName("hm_photo_front"));
			f = new File(memberUpdatePath + "/" + mr.getFilesystemName("hm_photo_back"));			
			f.delete();
		}	
	}
	
	public void memberDelete(Member m, HttpServletRequest req){
		String memberUpdatePath = req.getSession().getServletContext().getRealPath(memberUpdatePath2);
		
		try {
			Member loginMember = (Member) req.getSession().getAttribute("loginMember");

			String hm_photo_front_before = loginMember.getHm_photo_front();
			hm_photo_front_before = URLDecoder.decode(hm_photo_front_before, "utf-8");
			f = new File(memberUpdatePath + "/" + hm_photo_front_before);
			f.delete();
			
			String hm_photo_back_before = loginMember.getHm_photo_back();
			hm_photo_back_before = URLDecoder.decode(hm_photo_back_before, "utf-8");
			f = new File(memberUpdatePath + "/" + hm_photo_back_before);
			f.delete();
						
			String hm_id = loginMember.getHm_id();
			String hm_nickname = loginMember.getHm_nickname();
			
			String hm_pw = "*";
			String hm_name = "*";
			String hm_email = "*";
			String hm_pw_question = "*";
			String hm_pw_answer = "*";
			String hm_selfIntroduction = "안녕하세요";
			String hm_photo_front = "dr2.png";
			String hm_photo_back = "photo_back.jpg";
			Member dm = new Member(hm_id, hm_pw, hm_nickname, hm_name, hm_email, hm_pw_question, hm_pw_answer, hm_selfIntroduction, hm_photo_front, hm_photo_back, null, null, null, null, null, null, null, null, null);
			ss.getMapper(MemberMapper.class).memberSNSUpdate(dm);
			ss.getMapper(MemberMapper.class).memberSNSRelUpdate(dm);
			int mm = ss.getMapper(MemberMapper.class).memberDelete(dm);
			
			if (mm == 1) {
				req.getSession().setAttribute("loginMember", m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}	
	
	public void yourPageInformation(Member m, HttpServletRequest req){
		String Mhs_hm_nickname = m.getHs_hm_nickname();
		Member dm = new Member();
		dm.setHs_hm_nickname(Mhs_hm_nickname);
		Member mi = ss.getMapper(MemberMapper.class).yourPageInformation(dm);
		
		if (mi != null) {
			BigDecimal hs_no = mi.getHs_no();
			String hm_id = mi.getHm_id();
			String hm_nickname = mi.getHm_nickname();
			String hm_selfIntroduction = mi.getHm_selfIntroduction();
			String hm_photo_front = mi.getHm_photo_front();
			String hm_photo_back = mi.getHm_photo_back();

			dm = new Member(hm_id, null, hm_nickname, null, null, null, null, hm_selfIntroduction, hm_photo_front, hm_photo_back, hs_no, null, null, null, null, null, null, null, null);
			req.setAttribute("dm", dm);
		}
	
	}
	
	public void myPageFollow(HttpServletRequest req) {

		Member loginMember = (Member) req.getSession().getAttribute("loginMember");
		String hf_follower_id = loginMember.getHm_id();
		
		Member m = new Member();
		m.setHf_follower_id(hf_follower_id);
		List<Member> myPageFollow = ss.getMapper(MemberMapper.class).memberFollow(m);
		
		req.setAttribute("myPagefollow", myPageFollow);

	}
	
	public void yourPageFollow(Member m, HttpServletRequest req) {

		String hf_follower_id = m.getHm_id();
		
		Member yourPageFollowerID = new Member();
		yourPageFollowerID.setHf_follower_id(hf_follower_id);
		List<Member> yourfollow = ss.getMapper(MemberMapper.class).memberFollow(yourPageFollowerID);
		
		req.setAttribute("yourfollow", yourfollow);
	}
	
	public void myPageFollowing(HttpServletRequest req) {

		Member loginMember = (Member) req.getSession().getAttribute("loginMember");
		String hf_following_hm_id = loginMember.getHm_id();
		
		Member m = new Member();
		m.setHf_following_hm_id(hf_following_hm_id);
		List<Member> myPageFollowing = ss.getMapper(MemberMapper.class).memberFollowing(m);

		req.setAttribute("myPagefollowing", myPageFollowing);
	}
	
	public void yourPageFollowing(Member m, HttpServletRequest req) {

		String hf_following_hm_id = m.getHm_id();
		
		Member yourPageFollowerID = new Member();
		yourPageFollowerID.setHf_following_hm_id(hf_following_hm_id);
		List<Member> yourfollowing = ss.getMapper(MemberMapper.class).memberFollowing(yourPageFollowerID);
		
		req.setAttribute("yourfollowing", yourfollowing);
	}
	
	public void myPageMyTBag(HttpServletRequest req) {

		Member loginMember = (Member) req.getSession().getAttribute("loginMember");
		String hm_nickname = loginMember.getHm_nickname();
		
		Member m = new Member();
		m.setHm_nickname(hm_nickname);
		List<Member> myPageMyTBag = ss.getMapper(MemberMapper.class).myTBag(m);
		
		req.setAttribute("myPageMyTBag", myPageMyTBag);
	}
	
	public void yourPageMyTBag(Member m, HttpServletRequest req) {

		String hm_nickname = m.getHs_hm_nickname();
		
		Member yourPageNickname = new Member();
		 yourPageNickname.setHm_nickname(hm_nickname);
		List<Member> yourPageMyTBag = ss.getMapper(MemberMapper.class).myTBag(yourPageNickname);

		req.setAttribute("yourPageMyTBag", yourPageMyTBag);
	}
	
	public void myPageAffiliatedTBag(HttpServletRequest req) {

		Member loginMember = (Member) req.getSession().getAttribute("loginMember");
		String hm_nickname = loginMember.getHm_nickname();
		
		Member m = new Member();
		m.setHm_nickname(hm_nickname);
		List<Member> myPageAffiliatedTBag = ss.getMapper(MemberMapper.class).affiliatedTBag(m);
		
		req.setAttribute("myPageAffiliatedTBag", myPageAffiliatedTBag);
	}
	
	public void yourPageAffiliatedTBag(Member m, HttpServletRequest req) {

		String hm_nickname = m.getHs_hm_nickname();
		
		Member yourPageNickname = new Member();
		yourPageNickname.setHm_nickname(hm_nickname);
		List<Member> yourPageAffiliatedTBag = ss.getMapper(MemberMapper.class).affiliatedTBag(yourPageNickname);

		req.setAttribute("yourPageAffiliatedTBag", yourPageAffiliatedTBag);
	}
	
	// Messenger
	// getAllMemberJSON
	public Members getAllMemberJSON() {
		List<Member> m = ss.getMapper(MemberMapper.class).getAllMemberOrderByNickname();
		Members ms = new Members(m);
		return ms;
	}
	
	// getMemberByIDJSON
	public Member getMemberByIDJSON(HttpServletRequest request) {
		Member m = new Member();
		m.setHm_id(request.getParameter("hm_id"));
		Member m2 = ss.getMapper(MemberMapper.class).getMemberByID(m);
		return m2;
	}
	
	
}
