package com.ht.hitea.report;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Report {
	private BigDecimal hr_no;
	private String hr_this;
	private String hr_report_id;
	private String hr_text;
	private String hr_catego;
	private LocalDateTime hr_date;
	
	public Report() {
		// TODO Auto-generated constructor stub
	}

	public Report(BigDecimal hr_no, String hr_this, String hr_report_id, String hr_text, String hr_catego,
			LocalDateTime hr_date) {
		super();
		this.hr_no = hr_no;
		this.hr_this = hr_this;
		this.hr_report_id = hr_report_id;
		this.hr_text = hr_text;
		this.hr_catego = hr_catego;
		this.hr_date = hr_date;
	}

	public BigDecimal getHr_no() {
		return hr_no;
	}

	public void setHr_no(BigDecimal hr_no) {
		this.hr_no = hr_no;
	}

	public String getHr_this() {
		return hr_this;
	}

	public void setHr_this(String hr_this) {
		this.hr_this = hr_this;
	}

	public String getHr_report_id() {
		return hr_report_id;
	}

	public void setHr_report_id(String hr_report_id) {
		this.hr_report_id = hr_report_id;
	}

	public String getHr_text() {
		return hr_text;
	}

	public void setHr_text(String hr_text) {
		this.hr_text = hr_text;
	}

	public String getHr_catego() {
		return hr_catego;
	}

	public void setHr_catego(String hr_catego) {
		this.hr_catego = hr_catego;
	}

	public LocalDateTime getHr_date() {
		return hr_date;
	}

	public void setHr_date(LocalDateTime hr_date) {
		this.hr_date = hr_date;
	}
	

}
