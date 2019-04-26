package com.ht.hitea.seach;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.hitea.Inquiry;
import com.ht.hitea.hart.HartMapper;
import com.ht.hitea.hash.HashMapper;
import com.ht.hitea.member.Member;
import com.ht.hitea.member.Members;
import com.ht.hitea.sns.FileUploadMapper;
import com.ht.hitea.sns.SNSBean;
import com.ht.hitea.sns.SNSReplMapper;
import com.ht.hitea.sns.SNSs;




@Service
public class SeachDAO {

	@Autowired
	private SqlSession ss;
	
	public Members memberSeach(int page,String etseach,HttpServletRequest req) {
		Inquiry in = new Inquiry(null,null,etseach);
		int count2 = ss.getMapper(SeachMapper.class).memberSeachCount(in);
		double count = 4;
		int pageCount = (int) Math.ceil(count2 / count);
		if (count2>0) {
			int start = count2 - (page - 1) * (int) count;
			int end = (page == pageCount) ? 1 : start - ((int) count - 1);
			
			in.setStart(new BigDecimal(start));
			in.setEnd(new BigDecimal(end));
			
			List<Member> memberSeachs = ss.getMapper(SeachMapper.class).memberSeach(in);
			
			return new Members(memberSeachs);
		}
		return null;
	}
	
	public Integer memberSeachCount(String etseach) {
		Inquiry in = new Inquiry(null,null,etseach);
		return ss.getMapper(SeachMapper.class).memberSeachCount(in);
	}
	//////////////////////////////////////////
	
	public TeaBagSeachs teabagSeach(int page,String etseach,HttpServletRequest req) {
		Inquiry in = new Inquiry(null,null,etseach);
		int count2 = ss.getMapper(SeachMapper.class).teabagSeachCount(in);
		double count = 4;
		int pageCount = (int) Math.ceil(count2 / count);
		if (count2>0) {
			int start = count2 - (page - 1) * (int) count;
			int end = (page == pageCount) ? 1 : start - ((int) count - 1);
			
			in.setStart(new BigDecimal(start));
			in.setEnd(new BigDecimal(end));
			
			List<TeaBagSeach> teabagSeach = ss.getMapper(SeachMapper.class).teabagSeach(in);
			
			return new TeaBagSeachs(teabagSeach);
		}
		return null;
	}
	
	public Integer teabagSeachCount(String etseach) {
		Inquiry in = new Inquiry(null,null,etseach);
		return ss.getMapper(SeachMapper.class).teabagSeachCount(in);
	}
	
	
	
	
	
	
	
	
	
	
	////////////////////////
	
	

	
	public Integer snsSeachAll(String seach) {
		seach = "#"+seach;
		Inquiry in = new Inquiry(null,null,seach);
		int snsSeachs = ss.getMapper(SeachMapper.class).snsSeachCount(in);
		return snsSeachs;
	}
	
	public SNSs snsSeach(int page,String seach,HttpServletRequest req) {
		seach = "#"+seach;
		Inquiry in = new Inquiry(null,null,seach);
		int count2 = ss.getMapper(SeachMapper.class).snsSeachCount(in);
		double count = 4;
		int pageCount = (int) Math.ceil(count2 / count);
		if (count2>0) {
			int start = count2 - (page - 1) * (int) count;
			int end = (page == pageCount) ? 1 : start - ((int) count - 1);
			
			in.setStart(new BigDecimal(start));
			in.setEnd(new BigDecimal(end));
			
			List<SNSBean> snsSeachs = ss.getMapper(SeachMapper.class).snsSeach(in);
			
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
}
