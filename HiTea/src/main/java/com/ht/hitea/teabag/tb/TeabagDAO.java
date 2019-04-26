package com.ht.hitea.teabag.tb;

import java.io.File;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.hitea.Inquiry;
import com.ht.hitea.hart.HartMapper;
import com.ht.hitea.hash.HashMapper;
import com.ht.hitea.member.Member;
import com.ht.hitea.sns.FileUploadMapper;
import com.ht.hitea.sns.SNSBean;
import com.ht.hitea.sns.SNSReplMapper;
import com.ht.hitea.sns.SNSs;
import com.ht.hitea.teabag.tb.member.JoinReq;
import com.ht.hitea.teabag.tb.member.PageNotice;
import com.ht.hitea.teabag.tb.member.TeabagMemberMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class TeabagDAO {
	@Autowired
	private SqlSession ss;
	
	public void makeTeabag(Teabag t, HttpServletRequest req, HttpServletResponse res){
		if(req.getSession().getAttribute("possibleMakeB")==null){
			Member m = (Member) req.getSession().getAttribute("loginMember");
			t.setHt_leaderid(m.getHm_id());
			t.setHt_introduce(String.format("안녕하세요. %s 티백입니다.", t.getHt_name()));
			t.setHt_notice(String.format("%s 티백 공지입니다.", t.getHt_name()));
			ss.getMapper(TeabagMapper.class).makeTeabag(t);
			Teabag t2 =  ss.getMapper(TeabagMapper.class).getTeabagByLeaderId(t);
			ss.getMapper(TeabagMapper.class).joinTeabag(new TeabagMember(m.getHm_id(), t2.getHt_no(), null, null, null, null, null));
		}
	}
	
	// 리더만 보이는 버튼 따로 있어서
	public int countTeabagByLeader(HttpServletRequest req){
		Member m = (Member) req.getSession().getAttribute("loginMember");
		Teabag t = new Teabag(null, null, null, null, m.getHm_id(), null, null, null, null, null);
		int countMember = ss.getMapper(TeabagMapper.class).countTeabagByMember(t);
		if(countMember >= 10){
			req.getSession().setAttribute("possibleMakeB", "X");
		} else{
			req.getSession().setAttribute("possibleMakeB", null);
		}
		return countMember;
	}
	
	public Teabags getFourTeabags(HttpServletRequest req, HttpServletResponse res){
		return new Teabags(ss.getMapper(TeabagMapper.class).getFourTeabags());
	}
	
	public void firstGoTeabag(HttpServletRequest req, HttpServletResponse res){
		// 모임 들어갈때 처음 한번만 검사해주고 세션에 넣기.
		Member m = (Member) req.getSession().getAttribute("loginMember");
		TeabagMember tm = new TeabagMember(m.getHm_id(), new BigDecimal(req.getParameter("ht_no")), null, null, null, null, null);
		Teabag t2 = ss.getMapper(TeabagMapper.class).getByTNo(new Teabag(new BigDecimal(req.getParameter("ht_no")), null, null, null, null, null, null, null, null, null));
		List<JoinReq>j = ss.getMapper(TeabagMemberMapper.class).getJoinReqByTNo(new JoinReq(null, null, new BigDecimal(req.getParameter("ht_no")), null, null, null));
		if(t2.getHt_leaderid().equals(m.getHm_id())){
			req.getSession().setAttribute("teabagJoin", "L");
		} else if(ss.getMapper(TeabagMapper.class).getMemberByTNoAndId(tm)!=null){
			req.getSession().setAttribute("teabagJoin", "O");
		} else{
			req.getSession().setAttribute("teabagJoin", null);
			for (JoinReq joinReq : j) {
				if(joinReq.getHj_id().equals(m.getHm_id())){
					req.getSession().setAttribute("teabagJoin", "R");
				}
			}
		}
		t2.setHt_introduce2(t2.getHt_introduce().replace("\r\n", "<br>"));
		req.getSession().setAttribute("teabag", t2);
		//System.out.println("세션에 티백 넣어줌");
	}
	
	public Teabag getTeabagByTNo(HttpServletRequest req){
		return ss.getMapper(TeabagMapper.class).getByTNo(new Teabag(new BigDecimal(req.getParameter("ht_no")), null, null, null, null, null, null, null, null, null));
	}

	public void leaveTeabag(HttpServletRequest req, HttpServletResponse res){
		Member m = (Member) req.getSession().getAttribute("loginMember");
		Teabag t = (Teabag) req.getSession().getAttribute("teabag");
		TeabagMember tm = new TeabagMember(m.getHm_id(), t.getHt_no(), null, null, null, null, null);
		if(ss.getMapper(TeabagMapper.class).leaveTeabag(tm) == 1){
			int count = countMemberByTNo(tm);
			count = count--;
			t.setHt_count(new BigDecimal(count));
			ss.getMapper(TeabagMapper.class).updateCountMember(t);
		}
	}
	
	private int countMemberByTNo(TeabagMember tm){
		return ss.getMapper(TeabagMapper.class).countMemberByTNo(tm);
	}
	
	public void updateTeabag(Teabag t, HttpServletRequest req, HttpServletResponse res){
		String path = req.getSession().getServletContext().getRealPath("resources/img/teabag");
		MultipartRequest mr = null;
		Teabag t2 = (Teabag) req.getSession().getAttribute("teabag");
		String ht_profilePic1 = t2.getHt_profilepic();
		String ht_bgPic1 = t2.getHt_bgpic();
		try {
			 mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			 System.out.println(path);
		} catch (Exception e) {
			req.setAttribute("r", "사진 용량이 너무 큽니다.");
			return;
		}
		try {
			String t_profilePic = mr.getFilesystemName("ht_profilepic");
			String t_bgPic = mr.getFilesystemName("ht_bgpic");
			t.setHt_introduce(mr.getParameter("ht_introduce"));
			t.setHt_no(t2.getHt_no());
			t.setHt_name(t2.getHt_name());
			if(mr.getFilesystemName("ht_profilepic")!=null){
				t_profilePic = URLEncoder.encode(t_profilePic, "utf-8");
				t_profilePic = t_profilePic.replace("+", " ");
				t.setHt_profilepic(t_profilePic);
			} else{ // 넣은 프로필 사진이 없는 경우
				t.setHt_profilepic(t2.getHt_profilepic());
			}
			if(mr.getFilesystemName("ht_bgpic")!=null){
				t_bgPic = URLEncoder.encode(t_bgPic, "utf-8");
				t_bgPic = t_bgPic.replace("+", " ");
				t.setHt_bgpic(t_bgPic);
			} else{ // 넣은 배경 사진이 없는 경우
				t.setHt_bgpic(t2.getHt_bgpic());
			}
			if (ss.getMapper(TeabagMapper.class).updateTeabag(t) == 1) {
				req.setAttribute("r", "티백 수정 성공");
				req.getSession().setAttribute("teabag", t);
				
				if(mr.getFilesystemName("ht_profilepic")!=null && !ht_profilePic1.equals("basicPro.png")){
					ht_profilePic1 = URLDecoder.decode(ht_profilePic1, "utf-8");
					File f = new File(path + "/" + ht_profilePic1);
					f.delete();
				}
				if(mr.getFilesystemName("ht_bgpic")!=null && !ht_bgPic1.equals("basicBG.png")){
					ht_bgPic1 = URLDecoder.decode(ht_bgPic1, "utf-8");
					File f = new File(path + "/" + ht_bgPic1);
					f.delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "수정 실패");
		}
	} 
	
	public void updateNotice(Teabag t, HttpServletRequest req, HttpServletResponse res){
		Teabag t2 = (Teabag) req.getSession().getAttribute("teabag");
		t.setHt_no(t2.getHt_no());
		if(ss.getMapper(TeabagMapper.class).updateNotice(t) == 1){
			Teabag t3 = ss.getMapper(TeabagMapper.class).getByTNo(new Teabag(t.getHt_no(), null, null, null, null, null, null, null, null, null));
			req.getSession().setAttribute("teabag", t3);
			ss.getMapper(TeabagMemberMapper.class).sendPageNotice(new PageNotice(null, "null", t.getHt_no(), t2.getHt_name()+" 티백의 공지가 수정되었습니다.", "all", null, null));
		}
	}
	
	public Teabags getFourTeabagById(HttpServletRequest req, HttpServletResponse res){
		Member m = (Member) req.getSession().getAttribute("loginMember");
		return new Teabags(ss.getMapper(TeabagMapper.class).getFourTeabagById(new TeabagMember(m.getHm_id(), null, null, null, null, null, null)));
	}

	public Teabags getTeabagById(HttpServletRequest req, HttpServletResponse res){
		Member m = (Member) req.getSession().getAttribute("loginMember");
		return new Teabags(ss.getMapper(TeabagMapper.class).getAllTeabagById(new TeabagMember(m.getHm_id(), null, null, null, null, null, null)));
	}
	
	public Teabags getAllTeabag(HttpServletRequest req){
		return new Teabags(ss.getMapper(TeabagMapper.class).getAllTeabag());
	}

	public Teabags getTeabagByCategory(Teabag t, HttpServletRequest req){
		return new Teabags(ss.getMapper(TeabagMapper.class).getTeabagByCategory(t));
	}

	public Teabags getTeabagByName(Teabag t, HttpServletRequest req){
		return new Teabags(ss.getMapper(TeabagMapper.class).getTeabagByName(t));
	}
	public SNSs getAllTeaBagSNSAjax(int page,String teabag, HttpServletRequest req){
		Inquiry in = new Inquiry(null,null,teabag);
		int snsCount = ss.getMapper(TeabagMapper.class).getTeaBagSNSCount(in);
		double count = 5;
		int pageCount = (int) Math.ceil(snsCount / count);
		
		if (snsCount > 0) {
			
			
			int start = snsCount - (page - 1) * (int) count;
			int end = (page == pageCount) ? 1 : start - ((int) count - 1);
			
			
			in = new Inquiry(new BigDecimal(start), new BigDecimal(end),teabag);
			List<SNSBean> snssRownum = ss.getMapper(TeabagMapper.class).getTeaBagSNS(in);
			
			
			for (SNSBean sb2 : snssRownum) {
				sb2.setS_harts(ss.getMapper(HartMapper.class).hart(sb2));
				sb2.setS_hashs(ss.getMapper(HashMapper.class).hashNoAll(sb2));
				sb2.setS_files(ss.getMapper(FileUploadMapper.class).getAllfile2(sb2));
				sb2.setS_repls(ss.getMapper(SNSReplMapper.class).getAllRepl(sb2));
				
			}
			return new SNSs(snssRownum);
		}else {
			return null;
		}
		
	}

	public void deleteTeabag(HttpServletRequest req){
		Teabag t = (Teabag) req.getSession().getAttribute("teabag");
		//System.out.println(ss.getMapper(TeabagMapper.class).countMemberByTNo(new TeabagMember(null, t.getHt_no(), null, null, null, null, null)));
		if(ss.getMapper(TeabagMapper.class).countMemberByTNo(new TeabagMember(null, t.getHt_no(), null, null, null, null, null)) == 1){
			ss.getMapper(TeabagMapper.class).deleteTeabag(t);
		}
	}
}