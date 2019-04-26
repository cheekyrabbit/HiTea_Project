package com.ht.hitea.teabag.tb.dr;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Dataroom {
	private BigDecimal hd_no;
	private String hd_id;
	private String hd_title;
	private String hd_fname;
	private BigDecimal hd_tno;
	private String hd_ftype;
	private LocalDateTime hd_date;
	private BigDecimal min;
	private BigDecimal max;
	private String hm_nickname;
	
	public Dataroom() {
		// TODO Auto-generated constructor stub
	}

	public Dataroom(BigDecimal hd_no, String hd_id, String hd_title, String hd_fname, BigDecimal hd_tno,
			String hd_ftype, LocalDateTime hd_date, BigDecimal min, BigDecimal max, String hm_nickname) {
		super();
		this.hd_no = hd_no;
		this.hd_id = hd_id;
		this.hd_title = hd_title;
		this.hd_fname = hd_fname;
		this.hd_tno = hd_tno;
		this.hd_ftype = hd_ftype;
		this.hd_date = hd_date;
		this.min = min;
		this.max = max;
		this.hm_nickname = hm_nickname;
	}

	public BigDecimal getHd_no() {
		return hd_no;
	}

	public void setHd_no(BigDecimal hd_no) {
		this.hd_no = hd_no;
	}

	public String getHd_id() {
		return hd_id;
	}

	public void setHd_id(String hd_id) {
		this.hd_id = hd_id;
	}

	public String getHd_title() {
		return hd_title;
	}

	public void setHd_title(String hd_title) {
		this.hd_title = hd_title;
	}

	public String getHd_fname() {
		return hd_fname;
	}

	public void setHd_fname(String hd_fname) {
		this.hd_fname = hd_fname;
	}

	public BigDecimal getHd_tno() {
		return hd_tno;
	}

	public void setHd_tno(BigDecimal hd_tno) {
		this.hd_tno = hd_tno;
	}

	public String getHd_ftype() {
		return hd_ftype;
	}

	public void setHd_ftype(String hd_ftype) {
		this.hd_ftype = hd_ftype;
	}

	public LocalDateTime getHd_date() {
		return hd_date;
	}

	public void setHd_date(LocalDateTime hd_date) {
		this.hd_date = hd_date;
	}

	public BigDecimal getMin() {
		return min;
	}

	public void setMin(BigDecimal min) {
		this.min = min;
	}

	public BigDecimal getMax() {
		return max;
	}

	public void setMax(BigDecimal max) {
		this.max = max;
	}

	public String getHm_nickname() {
		return hm_nickname;
	}

	public void setHm_nickname(String hm_nickname) {
		this.hm_nickname = hm_nickname;
	}

	
}
