package com.ht.hitea.sns;

import java.io.File;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.hitea.Inquiry;
import com.ht.hitea.alram.Alram;
import com.ht.hitea.alram.AlramMapper;
import com.ht.hitea.hart.HartMapper;
import com.ht.hitea.hash.Hash;
import com.ht.hitea.hash.HashMapper;
import com.ht.hitea.member.Member;
import com.ht.hitea.seach.SeachMapper;
import com.oreilly.servlet.MultipartRequest;
//import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class SNSDAO {

	private int snsCount;

	@Autowired
	private SqlSession ss;

	public void fileUpload(SNSBean s, FileUploadBean2 f, HttpServletRequest req) {

		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/img/sns");

		try {
			mr = new MultipartRequest(req, path, 50 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			s.setHs_hm_id(m.getHm_id());
			s.setHs_hm_nickname(m.getHm_nickname());
			s.setHs_photo_front(m.getHm_photo_front());

			String s_txt = mr.getParameter("hs_txt");
			String s_txt2 = mr.getParameter("hs_txt2");
			String s_txt3 = mr.getParameter("hs_txt3");

			if (!s_txt.equals("")) {
			} else {
				s_txt = " ";
			}

			if (!s_txt2.equals("")) {
			} else {
				s_txt2 = " ";
			}

			if (!s_txt3.equals("")) {
			} else {
				s_txt3 = " ";
			}


			s.setHs_txt(s_txt);
			s.setHs_txt2(s_txt2);
			s.setHs_txt3(s_txt3);

			ss.getMapper(FileUploadMapper.class).snsWrite2(s);

			Enumeration forms = mr.getFileNames();

			String formName = null;
			String f_name = null;

			String f_img = null;
			String f_video = null;

			SNSBean s2 = ss.getMapper(FileUploadMapper.class).getOne2();
			while (forms.hasMoreElements()) {
				formName = (String) forms.nextElement();

				String ext = formName.substring(formName.lastIndexOf(".") + 1, formName.length());

				if (ext.equals("png") || ext.equals("jpg") || ext.equals("gif") || ext.equals("bmp")
						|| ext.equals("jpeg")) {
					f_img = mr.getFilesystemName(formName);
					f_video = "no";
				} else if (ext.equals("avi") || ext.equals("wmv") || ext.equals("mpeg") || ext.equals("mpg")
						|| ext.equals("asf") || ext.equals("mp4") || ext.equals("mov")) {
					f_video = mr.getFilesystemName(formName);
					f_img = "no";
				}

				else {
					f_img = "X";
					f_video = "X";
				}

				f.setHfile_img(f_img);
				f.setHfile_video(f_video);

				f.setHfile_no(s2.getHs_no());

				ss.getMapper(FileUploadMapper.class).fileWrite2(f);

				
			}

			String hashT[] = s_txt2.split(" ");
			Hash h = null;
			if (!s_txt2.equals("#")) {
				for (String h2 : hashT) {
					h = new Hash(s2.getHs_no(), h2);
					ss.getMapper(HashMapper.class).hashReg(h);
				}

			}

			String hashT2[] = s_txt3.split(" ");
			h = null;
			if (!s_txt3.equals("!")) {
				for (String h2 : hashT2) {
					h = new Hash(s2.getHs_no(), h2);
					ss.getMapper(HashMapper.class).hashReg(h);
				}

			}
			Alram al = new Alram(null, m.getHm_nickname(), m.getHm_id(), null, null, null);
			ss.getMapper(AlramMapper.class).alramRegSNS(al);
			snsCount++;

		} catch (Exception e) {
			req.setAttribute("result", "글쓰기 실패");
			e.printStackTrace();
			File file = new File(path + "/" + mr.getFilesystemName("m_photo"));
			file.delete();
		}

	}

	public void getAllSNS(HttpServletRequest req) {

		List<SNSBean> allmsg = ss.getMapper(FileUploadMapper.class).getAllSNSMsg2();
		for (SNSBean sb2 : allmsg) {
			sb2.setS_files(ss.getMapper(FileUploadMapper.class).getAllfile2(sb2));
			sb2.setS_repls(ss.getMapper(SNSReplMapper.class).getAllRepl(sb2));

		}
		req.setAttribute("msgs", allmsg);
	}

	public SNSs getAllSNSAjax(int page,HttpServletRequest req){

		double count = 5;
		int pageCount = (int) Math.ceil(snsCount / count);
		
		if (snsCount > 0) {
			
			
			int start = snsCount - (page - 1) * (int) count;
			int end = (page == pageCount) ? 1 : start - ((int) count - 1);
			
			
			Inquiry in = new Inquiry(new BigDecimal(start), new BigDecimal(end),null);
			List<SNSBean> snssRownum = ss.getMapper(FileUploadMapper.class).getShowSNS(in);
			
			
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

	public SNSBeans getJsonNo(SNSBean s, HttpServletRequest req, HttpServletResponse res) {

		SNSBean s2 = ss.getMapper(FileUploadMapper.class).getSNSMsg(s);
		s2.setS_files(ss.getMapper(FileUploadMapper.class).getAllfile2(s));
		s2.setS_repls(ss.getMapper(SNSReplMapper.class).getAllRepl(s));

		return new SNSBeans(s2);
	}

	public void snsDelete(SNSBean s, HttpServletRequest req) {

		List<FileUploadBean2> f = ss.getMapper(FileUploadMapper.class).getAllfile2(s);

		try {
			if (ss.getMapper(FileUploadMapper.class).snsDelete(s) == 1) {

				for (FileUploadBean2 fb2 : f) {

					String f_img = fb2.getHfile_img();
					f_img = URLDecoder.decode(f_img, "utf-8");
					String path = req.getSession().getServletContext().getRealPath("resources/img/sns");

					File file = new File(path + "/" + f_img);
					file.delete();

					String f_video = fb2.getHfile_video();
					f_video = URLDecoder.decode(f_video, "utf-8");

					File file2 = new File(path + "/" + f_video);
					file2.delete();
				}
				snsCount--;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public int snsDeleteAJAX(SNSBean s, HttpServletRequest req) {
		
		List<FileUploadBean2> f = ss.getMapper(FileUploadMapper.class).getAllfile2(s);
		
		try {
			if (ss.getMapper(FileUploadMapper.class).snsDelete(s) == 1) {
				
				for (FileUploadBean2 fb2 : f) {
					
					String f_img = fb2.getHfile_img();
					f_img = URLDecoder.decode(f_img, "utf-8");
					String path = req.getSession().getServletContext().getRealPath("resources/img/sns");
					
					File file = new File(path + "/" + f_img);
					file.delete();
					
					String f_video = fb2.getHfile_video();
					f_video = URLDecoder.decode(f_video, "utf-8");
					
					File file2 = new File(path + "/" + f_video);
					file2.delete();
				}
				snsCount--;
				return 1;
				
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		
	}

	public void snsReWrite(SNSRepl sr, HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			sr.setHsr_hm_nickname(m.getHm_nickname());
			sr.setHsr_img(m.getHm_photo_front());
			ss.getMapper(SNSReplMapper.class).snsReWrite(sr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void snsReDelete(SNSRepl sr, HttpServletRequest req) {
		try {
			ss.getMapper(SNSReplMapper.class).snsReDelete(sr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAllSNSCount() {
		snsCount = ss.getMapper(FileUploadMapper.class).getAllSNSCount();

	}
	
	public SNSRepls getAllRepl2(SNSBean s) {
		return new SNSRepls(ss.getMapper(SNSReplMapper.class).getAllRepl2(s));
	}
	public SNSRepls getAllRepl(SNSBean s) {
		return new SNSRepls(ss.getMapper(SNSReplMapper.class).getAllRepl(s));
	}
	
	public SNSs snsPage(int page,String pageId,HttpServletRequest req) {
		Inquiry in = new Inquiry(null,null,pageId);
		int count2 = ss.getMapper(FileUploadMapper.class).snsPageCount(in);
		double count = 4;
		int pageCount = (int) Math.ceil(count2 / count);
		if (count2>0) {
			int start = count2 - (page - 1) * (int) count;
			int end = (page == pageCount) ? 1 : start - ((int) count - 1);
			
			in.setStart(new BigDecimal(start));
			in.setEnd(new BigDecimal(end));
			
			List<SNSBean> snsSeachs = ss.getMapper(FileUploadMapper.class).snsPage(in);
			
			for (SNSBean sb2 : snsSeachs) {
				sb2.setS_harts(ss.getMapper(HartMapper.class).hart(sb2));
				sb2.setS_hashs(ss.getMapper(HashMapper.class).hashNoAll(sb2));
				sb2.setS_files(ss.getMapper(FileUploadMapper.class).getAllfile2(sb2));
				sb2.setS_repls(ss.getMapper(SNSReplMapper.class).getAllRepl(sb2));
			}
			
			
			return new SNSs(snsSeachs);
		}
		return null;
	}
	public SNSs snsPageHeart(int page,String pageId,HttpServletRequest req) {
		Inquiry in = new Inquiry(null,null,pageId);
		int count2 = ss.getMapper(FileUploadMapper.class).snsPageHeartCount(in);
		double count = 4;
		int pageCount = (int) Math.ceil(count2 / count);
		if (count2>0) {
			int start = count2 - (page - 1) * (int) count;
			int end = (page == pageCount) ? 1 : start - ((int) count - 1);
			
			in.setStart(new BigDecimal(start));
			in.setEnd(new BigDecimal(end));
			
			List<SNSBean> snsSeachs = ss.getMapper(FileUploadMapper.class).snsPageHeart(in);
			
			for (SNSBean sb2 : snsSeachs) {
				sb2.setS_harts(ss.getMapper(HartMapper.class).hart(sb2));
				sb2.setS_hashs(ss.getMapper(HashMapper.class).hashNoAll(sb2));
				sb2.setS_files(ss.getMapper(FileUploadMapper.class).getAllfile2(sb2));
				sb2.setS_repls(ss.getMapper(SNSReplMapper.class).getAllRepl(sb2));
				
			}
			
			
			return new SNSs(snsSeachs);
		}
		return null;
	}
	
	public SNSRepls regRepls(SNSRepl sr, HttpServletRequest req) {
		Member loginMember = (Member) req.getSession().getAttribute("loginMember");
		sr.setHsr_hm_nickname(loginMember.getHm_nickname());
		sr.setHsr_img(loginMember.getHm_photo_front());
		if(ss.getMapper(SNSReplMapper.class).snsReWrite(sr) == 1){
			return new SNSRepls(ss.getMapper(SNSReplMapper.class).getSNSRepl(sr));
		}
		return null;	
	}
	
	public int deleteRepls(SNSRepl sr) {
		return ss.getMapper(SNSReplMapper.class).snsReDelete(sr);
	}
	

}
