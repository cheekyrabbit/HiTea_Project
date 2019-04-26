package com.ht.hitea.teabag.tb.calendar;

import java.math.BigDecimal;

public class Calendar {
	private BigDecimal hc_no;
	private BigDecimal hc_tno;
	private String hc_category;
	private String hc_title;
	private String hc_content;
	private String hc_start;
	private String hc_end;
	
	public Calendar() {
		// TODO Auto-generated constructor stub
	}

	public Calendar(BigDecimal hc_no, BigDecimal hc_tno, String hc_category, String hc_title, String hc_content,
			String hc_start, String hc_end) {
		super();
		this.hc_no = hc_no;
		this.hc_tno = hc_tno;
		this.hc_category = hc_category;
		this.hc_title = hc_title;
		this.hc_content = hc_content;
		this.hc_start = hc_start;
		this.hc_end = hc_end;
	}

	public BigDecimal getHc_no() {
		return hc_no;
	}

	public void setHc_no(BigDecimal hc_no) {
		this.hc_no = hc_no;
	}

	public BigDecimal getHc_tno() {
		return hc_tno;
	}

	public void setHc_tno(BigDecimal hc_tno) {
		this.hc_tno = hc_tno;
	}

	public String getHc_category() {
		return hc_category;
	}

	public void setHc_category(String hc_category) {
		this.hc_category = hc_category;
	}

	public String getHc_title() {
		return hc_title;
	}

	public void setHc_title(String hc_title) {
		this.hc_title = hc_title;
	}

	public String getHc_content() {
		return hc_content;
	}

	public void setHc_content(String hc_content) {
		this.hc_content = hc_content;
	}

	public String getHc_start() {
		return hc_start;
	}

	public void setHc_start(String hc_start) {
		this.hc_start = hc_start;
	}

	public String getHc_end() {
		return hc_end;
	}

	public void setHc_end(String hc_end) {
		this.hc_end = hc_end;
	}
	
	
}
