package com.ht.hitea.hart;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Hart {
	private BigDecimal hh_hs_no;
	private String hh_heart_hm_id;
	private LocalDateTime hh_date;
	public Hart() {
		// TODO Auto-generated constructor stub
	}
	public Hart(BigDecimal hh_hs_no, String hh_heart_hm_id, LocalDateTime hh_date) {
		super();
		this.hh_hs_no = hh_hs_no;
		this.hh_heart_hm_id = hh_heart_hm_id;
		this.hh_date = hh_date;
	}
	public BigDecimal getHh_hs_no() {
		return hh_hs_no;
	}
	public void setHh_hs_no(BigDecimal hh_hs_no) {
		this.hh_hs_no = hh_hs_no;
	}
	public String getHh_heart_hm_id() {
		return hh_heart_hm_id;
	}
	public void setHh_heart_hm_id(String hh_heart_hm_id) {
		this.hh_heart_hm_id = hh_heart_hm_id;
	}
	public LocalDateTime getHh_date() {
		return hh_date;
	}
	public void setHh_date(LocalDateTime hh_date) {
		this.hh_date = hh_date;
	}
	
}
