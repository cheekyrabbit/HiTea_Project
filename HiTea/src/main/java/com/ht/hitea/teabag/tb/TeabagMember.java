package com.ht.hitea.teabag.tb;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TeabagMember {
	private String htm_id;
	private BigDecimal htm_tno;
	private LocalDateTime htm_date;
	private BigDecimal min;
	private BigDecimal max;
	private String hm_photo_front; 
	private String hm_nickname;
	
	public TeabagMember() {
		// TODO Auto-generated constructor stub
	}

	public TeabagMember(String htm_id, BigDecimal htm_tno, LocalDateTime htm_date, BigDecimal min, BigDecimal max,
			String hm_photo_front, String hm_nickname) {
		super();
		this.htm_id = htm_id;
		this.htm_tno = htm_tno;
		this.htm_date = htm_date;
		this.min = min;
		this.max = max;
		this.hm_photo_front = hm_photo_front;
		this.hm_nickname = hm_nickname;
	}

	public String getHtm_id() {
		return htm_id;
	}

	public void setHtm_id(String htm_id) {
		this.htm_id = htm_id;
	}

	public BigDecimal getHtm_tno() {
		return htm_tno;
	}

	public void setHtm_tno(BigDecimal htm_tno) {
		this.htm_tno = htm_tno;
	}

	public LocalDateTime getHtm_date() {
		return htm_date;
	}

	public void setHtm_date(LocalDateTime htm_date) {
		this.htm_date = htm_date;
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
