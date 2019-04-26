package com.ht.hitea.teabag.tb.bbs;

import java.math.BigDecimal;

public class BBS {
	private BigDecimal hb_no;
	private String hb_id;
	private String hb_content;
	private String hb_date;
	private BigDecimal hb_tno;
	private String hm_photo_front;
	private String hm_nickname;
	
	public BBS() {
		// TODO Auto-generated constructor stub
	}

	public BBS(BigDecimal hb_no, String hb_id, String hb_content, String hb_date, BigDecimal hb_tno,
			String hm_photo_front, String hm_nickname) {
		super();
		this.hb_no = hb_no;
		this.hb_id = hb_id;
		this.hb_content = hb_content;
		this.hb_date = hb_date;
		this.hb_tno = hb_tno;
		this.hm_photo_front = hm_photo_front;
		this.hm_nickname = hm_nickname;
	}

	public BigDecimal getHb_no() {
		return hb_no;
	}

	public void setHb_no(BigDecimal hb_no) {
		this.hb_no = hb_no;
	}

	public String getHb_id() {
		return hb_id;
	}

	public void setHb_id(String hb_id) {
		this.hb_id = hb_id;
	}

	public String getHb_content() {
		return hb_content;
	}

	public void setHb_content(String hb_content) {
		this.hb_content = hb_content;
	}

	public String getHb_date() {
		return hb_date;
	}

	public void setHb_date(String hb_date) {
		this.hb_date = hb_date;
	}

	public BigDecimal getHb_tno() {
		return hb_tno;
	}

	public void setHb_tno(BigDecimal hb_tno) {
		this.hb_tno = hb_tno;
	}

	public String getHm_photo_front() {
		return hm_photo_front;
	}

	public void setHm_photo_front(String hm_photo_front) {
		this.hm_photo_front = hm_photo_front;
	}

	public String getHm_nickname() {
		return hm_nickname;
	}

	public void setHm_nickname(String hm_nickname) {
		this.hm_nickname = hm_nickname;
	}

	
}
