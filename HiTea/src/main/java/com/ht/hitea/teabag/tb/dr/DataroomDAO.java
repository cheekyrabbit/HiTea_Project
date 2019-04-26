package com.ht.hitea.teabag.tb.dr;

import java.io.File;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.hitea.member.Member;
import com.ht.hitea.teabag.tb.Teabag;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class DataroomDAO {
	
	@Autowired
	private SqlSession ss;
	
	private int countDRPhoto;
	private int countDRFile;
	
	public void countDRPhoto(HttpServletRequest req) {
		Teabag t = (Teabag) req.getSession().getAttribute("teabag");
		countDRPhoto = ss.getMapper(TeabagDRMapper.class).countDRPhoto(new Dataroom(null, null, null, null, t.getHt_no(), null, null, null, null, null));
	}
	
	public void setPageFile(int pageNo, HttpServletRequest req) {
		req.getSession().setAttribute("pageNo2", pageNo);
	}
	
	public void setPagePhoto(int pageNo, HttpServletRequest req) {
		req.getSession().setAttribute("pageNo3", pageNo);
	}
	
	public void countDRFile(HttpServletRequest req) {
		Teabag t = (Teabag) req.getSession().getAttribute("teabag");
		countDRFile = ss.getMapper(TeabagDRMapper.class).countDRFile(new Dataroom(null, null, null, null, t.getHt_no(), null, null, null, null, null));
	}
	
	public Datarooms getFileByTNo(HttpServletRequest req, HttpServletResponse res) {
		Teabag t = (Teabag) req.getSession().getAttribute("teabag");

		int pageNo = 1;
		
		if (req.getSession().getAttribute("pageNo2") != null) {
			pageNo = (Integer) req.getSession().getAttribute("pageNo2");
		}

		double count = 3.0; // 한 페이지당 보여줄 갯수

		int pageCount = (int) Math.ceil(countDRFile / count);
		
		req.getSession().setAttribute("pageCount2", pageCount);
		
		int start = (countDRFile - ((pageNo - 1) * (int) count)); 
																
		int end = (pageNo == pageCount) ? 1 : (int) (start - ((int) count - 1)); 
									
		
		List<Dataroom> drs = ss.getMapper(TeabagDRMapper.class).getFileByTNo(new Dataroom(null, null, null, null, t.getHt_no(), null, null, new BigDecimal(end), new BigDecimal(start), null));
		
		return new Datarooms(drs);
	}
	
	public Datarooms getPhotoByTNo(HttpServletRequest req, HttpServletResponse res) {
		Teabag t = (Teabag) req.getSession().getAttribute("teabag");
		
		int pageNo = 1;
		
		if (req.getSession().getAttribute("pageNo3") != null) {
			pageNo = (Integer) req.getSession().getAttribute("pageNo3");
		}
		
		double count = 3.0; // 한 페이지당 보여줄 갯수
		
		int pageCount = (int) Math.ceil(countDRPhoto / count);
		
		req.getSession().setAttribute("pageCount3", pageCount);
		
		int start = (countDRPhoto - ((pageNo - 1) * (int) count)); 
		
		int end = (pageNo == pageCount) ? 1 : (int) (start - ((int) count - 1)); 
		
		List<Dataroom> drs = ss.getMapper(TeabagDRMapper.class).getPhotoByTNo(new Dataroom(null, null, null, null, t.getHt_no(), null, null, new BigDecimal(end), new BigDecimal(start), null));
		
		return new Datarooms(drs);
	}
	
	public void writeDR(Dataroom dr, HttpServletRequest req, HttpServletResponse res){
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/img/teabag");
		//System.out.println(path);
		Member m = (Member) req.getSession().getAttribute("loginMember");
		Teabag t = (Teabag) req.getSession().getAttribute("teabag");
		try {
			mr = new MultipartRequest(req, path, 500 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			//System.out.println("업로드 실패");
			e.printStackTrace();
			return;
		}
		try {
			dr.setHd_id(m.getHm_id());
			dr.setHd_title(mr.getParameter("hd_title"));
			dr.setHd_tno(t.getHt_no());
			if(mr.getFilesystemName("tb_photo")!=null){
				String tb_photo = mr.getFilesystemName("tb_photo");
				tb_photo = URLEncoder.encode(tb_photo, "utf-8");
				tb_photo = tb_photo.replace("+", " ");
				dr.setHd_fname(tb_photo);
				ss.getMapper(TeabagDRMapper.class).writePhoto(dr);
				countDRPhoto++;
			} else if(mr.getFilesystemName("tb_file")!=null){
				String tb_file = mr.getFilesystemName("tb_file");
				tb_file = URLEncoder.encode(tb_file, "utf-8");
				tb_file = tb_file.replace("+", " ");
				dr.setHd_fname(tb_file);
				ss.getMapper(TeabagDRMapper.class).writeFile(dr);
				countDRFile++;
			}
			
		} catch (Exception e) {
			//System.out.println("업로드 실패");
			e.printStackTrace();
		}
	}
	
	public void deleteFile(Dataroom dr, HttpServletRequest req, HttpServletResponse res){
		String path = req.getSession().getServletContext().getRealPath("resources/img/teabag");
		Dataroom dr2 = ss.getMapper(TeabagDRMapper.class).getDRByNo(dr);
		String hd_fname = dr2.getHd_fname();
		if(ss.getMapper(TeabagDRMapper.class).deleteFile(dr)==1){
			try {
				hd_fname = URLDecoder.decode(hd_fname, "utf-8");
				File f = new File(path + "/" + hd_fname);
				f.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(dr2.getHd_ftype().equals("p")){
				countDRPhoto--;
			} else{
				countDRFile--;
			}
		}
	}
	
	public Integer pageCountPhoto(HttpServletRequest req){
		return (Integer) req.getSession().getAttribute("pageCount3");
	}

	public Integer pageCountFile(HttpServletRequest req){
		return (Integer) req.getSession().getAttribute("pageCount2");
	}
}
