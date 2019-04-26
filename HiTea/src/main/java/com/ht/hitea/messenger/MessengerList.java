package com.ht.hitea.messenger;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.ht.hitea.member.Member;

public class MessengerList {
	private BigDecimal hmsl_no;
	private String hmsl_m1;
	private String hmsl_m2;
	private String hmsl_last_txt1;
	private String hmsl_last_txt2;
	private LocalDateTime hmsl_last_date;
	
	private List<Member> hmsl_hm_m1;
	private List<Member> hmsl_hm_m2;
	
	public MessengerList() {
		// TODO Auto-generated constructor stub
	}

	public MessengerList(BigDecimal hmsl_no, String hmsl_m1, String hmsl_m2, String hmsl_last_txt1,
			String hmsl_last_txt2, LocalDateTime hmsl_last_date, List<Member> hmsl_hm_m1, List<Member> hmsl_hm_m2) {
		super();
		this.hmsl_no = hmsl_no;
		this.hmsl_m1 = hmsl_m1;
		this.hmsl_m2 = hmsl_m2;
		this.hmsl_last_txt1 = hmsl_last_txt1;
		this.hmsl_last_txt2 = hmsl_last_txt2;
		this.hmsl_last_date = hmsl_last_date;
		this.hmsl_hm_m1 = hmsl_hm_m1;
		this.hmsl_hm_m2 = hmsl_hm_m2;
	}

	public BigDecimal getHmsl_no() {
		return hmsl_no;
	}

	public void setHmsl_no(BigDecimal hmsl_no) {
		this.hmsl_no = hmsl_no;
	}

	public String getHmsl_m1() {
		return hmsl_m1;
	}

	public void setHmsl_m1(String hmsl_m1) {
		this.hmsl_m1 = hmsl_m1;
	}

	public String getHmsl_m2() {
		return hmsl_m2;
	}

	public void setHmsl_m2(String hmsl_m2) {
		this.hmsl_m2 = hmsl_m2;
	}

	public String getHmsl_last_txt1() {
		return hmsl_last_txt1;
	}

	public void setHmsl_last_txt1(String hmsl_last_txt1) {
		this.hmsl_last_txt1 = hmsl_last_txt1;
	}

	public String getHmsl_last_txt2() {
		return hmsl_last_txt2;
	}

	public void setHmsl_last_txt2(String hmsl_last_txt2) {
		this.hmsl_last_txt2 = hmsl_last_txt2;
	}

	public LocalDateTime getHmsl_last_date() {
		return hmsl_last_date;
	}

	public void setHmsl_last_date(LocalDateTime hmsl_last_date) {
		this.hmsl_last_date = hmsl_last_date;
	}

	public List<Member> getHmsl_hm_m1() {
		return hmsl_hm_m1;
	}

	public void setHmsl_hm_m1(List<Member> hmsl_hm_m1) {
		this.hmsl_hm_m1 = hmsl_hm_m1;
	}

	public List<Member> getHmsl_hm_m2() {
		return hmsl_hm_m2;
	}

	public void setHmsl_hm_m2(List<Member> hmsl_hm_m2) {
		this.hmsl_hm_m2 = hmsl_hm_m2;
	}

}
