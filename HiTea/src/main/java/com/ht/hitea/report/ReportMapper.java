package com.ht.hitea.report;

import java.util.List;

public interface ReportMapper {
	public abstract int reportReg(Report re);
	public abstract List<Report> reportList();
}
