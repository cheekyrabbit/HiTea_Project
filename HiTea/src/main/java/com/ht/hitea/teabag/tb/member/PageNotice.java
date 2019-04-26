package com.ht.hitea.teabag.tb.member;

import java.math.BigDecimal;

public class PageNotice {
	private BigDecimal hpn_no;
	private String hpn_id;
	private BigDecimal hpn_tno;
	private String hpn_content;
	private String hpn_type;
	private String hpn_date;
	private String ht_name;
	
	public PageNotice() {
		// TODO Auto-generated constructor stub
	}

	public PageNotice(BigDecimal hpn_no, String hpn_id, BigDecimal hpn_tno, String hpn_content, String hpn_type,
			String hpn_date, String ht_name) {
		super();
		this.hpn_no = hpn_no;
		this.hpn_id = hpn_id;
		this.hpn_tno = hpn_tno;
		this.hpn_content = hpn_content;
		this.hpn_type = hpn_type;
		this.hpn_date = hpn_date;
		this.ht_name = ht_name;
	}

	public BigDecimal getHpn_no() {
		return hpn_no;
	}

	public void setHpn_no(BigDecimal hpn_no) {
		this.hpn_no = hpn_no;
	}

	public String getHpn_id() {
		return hpn_id;
	}

	public void setHpn_id(String hpn_id) {
		this.hpn_id = hpn_id;
	}

	public BigDecimal getHpn_tno() {
		return hpn_tno;
	}

	public void setHpn_tno(BigDecimal hpn_tno) {
		this.hpn_tno = hpn_tno;
	}

	public String getHpn_content() {
		return hpn_content;
	}

	public void setHpn_content(String hpn_content) {
		this.hpn_content = hpn_content;
	}

	public String getHpn_type() {
		return hpn_type;
	}

	public void setHpn_type(String hpn_type) {
		this.hpn_type = hpn_type;
	}

	public String getHpn_date() {
		return hpn_date;
	}

	public void setHpn_date(String hpn_date) {
		this.hpn_date = hpn_date;
	}

	public String getHt_name() {
		return ht_name;
	}

	public void setHt_name(String ht_name) {
		this.ht_name = ht_name;
	}

	
	
}
