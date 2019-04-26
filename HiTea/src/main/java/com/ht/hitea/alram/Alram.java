package com.ht.hitea.alram;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Alram {
	private BigDecimal halarm_no;
	private String halarm_to_nickname;
	private String halarm_to_id;
	private String halarm_from_id;
	private String halarm_txt;
	private LocalDateTime halarm_date;
	public Alram() {
		// TODO Auto-generated constructor stub
	}
	public Alram(BigDecimal halarm_no, String halarm_to_nickname, String halarm_to_id, String halarm_from_id,
			String halarm_txt, LocalDateTime halarm_date) {
		super();
		this.halarm_no = halarm_no;
		this.halarm_to_nickname = halarm_to_nickname;
		this.halarm_to_id = halarm_to_id;
		this.halarm_from_id = halarm_from_id;
		this.halarm_txt = halarm_txt;
		this.halarm_date = halarm_date;
	}
	public BigDecimal getHalarm_no() {
		return halarm_no;
	}
	public void setHalarm_no(BigDecimal halarm_no) {
		this.halarm_no = halarm_no;
	}
	public String getHalarm_to_nickname() {
		return halarm_to_nickname;
	}
	public void setHalarm_to_nickname(String halarm_to_nickname) {
		this.halarm_to_nickname = halarm_to_nickname;
	}
	public String getHalarm_to_id() {
		return halarm_to_id;
	}
	public void setHalarm_to_id(String halarm_to_id) {
		this.halarm_to_id = halarm_to_id;
	}
	public String getHalarm_from_id() {
		return halarm_from_id;
	}
	public void setHalarm_from_id(String halarm_from_id) {
		this.halarm_from_id = halarm_from_id;
	}
	public String getHalarm_txt() {
		return halarm_txt;
	}
	public void setHalarm_txt(String halarm_txt) {
		this.halarm_txt = halarm_txt;
	}
	public LocalDateTime getHalarm_date() {
		return halarm_date;
	}
	public void setHalarm_date(LocalDateTime halarm_date) {
		this.halarm_date = halarm_date;
	}
	
}
