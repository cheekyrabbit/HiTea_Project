package com.ht.hitea.teabag.tb.member;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class JoinReq {
	private BigDecimal hj_no;
	private String hj_id;
	private BigDecimal hj_tno;
	private LocalDateTime hj_date;
	private String hm_nickname;
	private String hm_photo_front;
	
	public JoinReq() {
		// TODO Auto-generated constructor stub
	}

	public JoinReq(BigDecimal hj_no, String hj_id, BigDecimal hj_tno, LocalDateTime hj_date, String hm_nickname,
			String hm_photo_front) {
		super();
		this.hj_no = hj_no;
		this.hj_id = hj_id;
		this.hj_tno = hj_tno;
		this.hj_date = hj_date;
		this.hm_nickname = hm_nickname;
		this.hm_photo_front = hm_photo_front;
	}

	public BigDecimal getHj_no() {
		return hj_no;
	}

	public void setHj_no(BigDecimal hj_no) {
		this.hj_no = hj_no;
	}

	public String getHj_id() {
		return hj_id;
	}

	public void setHj_id(String hj_id) {
		this.hj_id = hj_id;
	}

	public BigDecimal getHj_tno() {
		return hj_tno;
	}

	public void setHj_tno(BigDecimal hj_tno) {
		this.hj_tno = hj_tno;
	}

	public LocalDateTime getHj_date() {
		return hj_date;
	}

	public void setHj_date(LocalDateTime hj_date) {
		this.hj_date = hj_date;
	}

	public String getHm_nickname() {
		return hm_nickname;
	}

	public void setHm_nickname(String hm_nickname) {
		this.hm_nickname = hm_nickname;
	}

	public String getHm_photo_front() {
		return hm_photo_front;
	}

	public void setHm_photo_front(String hm_photo_front) {
		this.hm_photo_front = hm_photo_front;
	}

	
}
