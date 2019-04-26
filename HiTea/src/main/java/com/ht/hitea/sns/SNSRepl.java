package com.ht.hitea.sns;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SNSRepl {

	private BigDecimal hsr_no;
	private BigDecimal hsr_hs_no;
	private String hsr_hm_nickname;
	private String hsr_txt;
	private LocalDateTime hsr_date;
	private String hsr_img;

	public SNSRepl() {
		// TODO Auto-generated constructor stub
	}

	public SNSRepl(BigDecimal hsr_no, BigDecimal hsr_hs_no, String hsr_hm_nickname, String hsr_txt,
			LocalDateTime hsr_date, String hsr_img) {
		super();
		this.hsr_no = hsr_no;
		this.hsr_hs_no = hsr_hs_no;
		this.hsr_hm_nickname = hsr_hm_nickname;
		this.hsr_txt = hsr_txt;
		this.hsr_date = hsr_date;
		this.hsr_img = hsr_img;
	}

	public BigDecimal getHsr_no() {
		return hsr_no;
	}

	public void setHsr_no(BigDecimal hsr_no) {
		this.hsr_no = hsr_no;
	}

	public BigDecimal getHsr_hs_no() {
		return hsr_hs_no;
	}

	public void setHsr_hs_no(BigDecimal hsr_hs_no) {
		this.hsr_hs_no = hsr_hs_no;
	}

	public String getHsr_hm_nickname() {
		return hsr_hm_nickname;
	}

	public void setHsr_hm_nickname(String hsr_hm_nickname) {
		this.hsr_hm_nickname = hsr_hm_nickname;
	}

	public String getHsr_txt() {
		return hsr_txt;
	}

	public void setHsr_txt(String hsr_txt) {
		this.hsr_txt = hsr_txt;
	}

	public LocalDateTime getHsr_date() {
		return hsr_date;
	}

	public void setHsr_date(LocalDateTime hsr_date) {
		this.hsr_date = hsr_date;
	}

	public String getHsr_img() {
		return hsr_img;
	}

	public void setHsr_img(String hsr_img) {
		this.hsr_img = hsr_img;
	}



	
}
