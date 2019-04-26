package com.ht.hitea.teabag.tb;

import java.math.BigDecimal;

public class Teabag {
	private BigDecimal ht_no;
	private String ht_name;
	private String ht_category;
	private String ht_date;
	private String ht_leaderid;
	private String ht_profilepic;
	private String ht_bgpic;
	private String ht_introduce;
	private BigDecimal ht_count;
	private String ht_notice;
	
	private String ht_introduce2;
	
	public Teabag() {
		// TODO Auto-generated constructor stub
	}

	public Teabag(BigDecimal ht_no, String ht_name, String ht_category, String ht_date, String ht_leaderid,
			String ht_profilepic, String ht_bgpic, String ht_introduce, BigDecimal ht_count, String ht_notice) {
		super();
		this.ht_no = ht_no;
		this.ht_name = ht_name;
		this.ht_category = ht_category;
		this.ht_date = ht_date;
		this.ht_leaderid = ht_leaderid;
		this.ht_profilepic = ht_profilepic;
		this.ht_bgpic = ht_bgpic;
		this.ht_introduce = ht_introduce;
		this.ht_count = ht_count;
		this.ht_notice = ht_notice;
	}

	public BigDecimal getHt_no() {
		return ht_no;
	}

	public void setHt_no(BigDecimal ht_no) {
		this.ht_no = ht_no;
	}

	public String getHt_name() {
		return ht_name;
	}

	public void setHt_name(String ht_name) {
		this.ht_name = ht_name;
	}

	public String getHt_category() {
		return ht_category;
	}

	public void setHt_category(String ht_category) {
		this.ht_category = ht_category;
	}

	public String getHt_date() {
		return ht_date;
	}

	public void setHt_date(String ht_date) {
		this.ht_date = ht_date;
	}

	public String getHt_leaderid() {
		return ht_leaderid;
	}

	public void setHt_leaderid(String ht_leaderid) {
		this.ht_leaderid = ht_leaderid;
	}

	public String getHt_profilepic() {
		return ht_profilepic;
	}

	public void setHt_profilepic(String ht_profilepic) {
		this.ht_profilepic = ht_profilepic;
	}

	public String getHt_bgpic() {
		return ht_bgpic;
	}

	public void setHt_bgpic(String ht_bgpic) {
		this.ht_bgpic = ht_bgpic;
	}

	public String getHt_introduce() {
		return ht_introduce;
	}

	public void setHt_introduce(String ht_introduce) {
		this.ht_introduce = ht_introduce;
	}

	public BigDecimal getHt_count() {
		return ht_count;
	}

	public void setHt_count(BigDecimal ht_count) {
		this.ht_count = ht_count;
	}

	public String getHt_notice() {
		return ht_notice;
	}

	public void setHt_notice(String ht_notice) {
		this.ht_notice = ht_notice;
	}

	public String getHt_introduce2() {
		return ht_introduce2;
	}

	public void setHt_introduce2(String ht_introduce2) {
		this.ht_introduce2 = ht_introduce2;
	}

}
