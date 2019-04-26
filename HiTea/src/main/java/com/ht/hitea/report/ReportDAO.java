package com.ht.hitea.report;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportDAO {
	
	@Autowired
	private SqlSession ss;
	
	public Reports reportReg(Report re) {
		List<Report> reports = new ArrayList<Report>();
		if (ss.getMapper(ReportMapper.class).reportReg(re) == 1) {
			return new Reports(reports);
		}else {
			return null;
		}
		
	}
	
	public Reports reportList() {
		return new Reports(ss.getMapper(ReportMapper.class).reportList());
	}
}
