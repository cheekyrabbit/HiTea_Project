package com.ht.hitea.sns;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.ht.hitea.hart.Hart;
import com.ht.hitea.hash.Hash;

public class SNSBean {

	private BigDecimal hs_no;
	private String hs_hm_id;
	private String hs_hm_nickname;
	private String hs_txt;
	private String hs_txt2;
	private String hs_txt3;
	private String hs_photo_front;
	private LocalDateTime hs_date;

	private String hm_nickname;
	
	private List<FileUploadBean2> s_files;

	private List<SNSRepl> s_repls;
	
	private List<Hash> s_hashs;
	
	private List<Hart> s_harts;

	public SNSBean() {
		// TODO Auto-generated constructor stub
	}

	public SNSBean(BigDecimal hs_no, String hs_hm_id, String hs_hm_nickname, String hs_txt, String hs_txt2,
			String hs_txt3, String hs_photo_front, LocalDateTime hs_date, String hm_nickname,
			List<FileUploadBean2> s_files, List<SNSRepl> s_repls, List<Hash> s_hashs, List<Hart> s_harts) {
		super();
		this.hs_no = hs_no;
		this.hs_hm_id = hs_hm_id;
		this.hs_hm_nickname = hs_hm_nickname;
		this.hs_txt = hs_txt;
		this.hs_txt2 = hs_txt2;
		this.hs_txt3 = hs_txt3;
		this.hs_photo_front = hs_photo_front;
		this.hs_date = hs_date;
		this.hm_nickname = hm_nickname;
		this.s_files = s_files;
		this.s_repls = s_repls;
		this.s_hashs = s_hashs;
		this.s_harts = s_harts;
	}

	public BigDecimal getHs_no() {
		return hs_no;
	}

	public void setHs_no(BigDecimal hs_no) {
		this.hs_no = hs_no;
	}

	public String getHs_hm_id() {
		return hs_hm_id;
	}

	public void setHs_hm_id(String hs_hm_id) {
		this.hs_hm_id = hs_hm_id;
	}

	public String getHs_hm_nickname() {
		return hs_hm_nickname;
	}

	public void setHs_hm_nickname(String hs_hm_nickname) {
		this.hs_hm_nickname = hs_hm_nickname;
	}

	public String getHs_txt() {
		return hs_txt;
	}

	public void setHs_txt(String hs_txt) {
		this.hs_txt = hs_txt;
	}

	public String getHs_txt2() {
		return hs_txt2;
	}

	public void setHs_txt2(String hs_txt2) {
		this.hs_txt2 = hs_txt2;
	}

	public String getHs_txt3() {
		return hs_txt3;
	}

	public void setHs_txt3(String hs_txt3) {
		this.hs_txt3 = hs_txt3;
	}

	public String getHs_photo_front() {
		return hs_photo_front;
	}

	public void setHs_photo_front(String hs_photo_front) {
		this.hs_photo_front = hs_photo_front;
	}

	public LocalDateTime getHs_date() {
		return hs_date;
	}

	public void setHs_date(LocalDateTime hs_date) {
		this.hs_date = hs_date;
	}

	public String getHm_nickname() {
		return hm_nickname;
	}

	public void setHm_nickname(String hm_nickname) {
		this.hm_nickname = hm_nickname;
	}

	public List<FileUploadBean2> getS_files() {
		return s_files;
	}

	public void setS_files(List<FileUploadBean2> s_files) {
		this.s_files = s_files;
	}

	public List<SNSRepl> getS_repls() {
		return s_repls;
	}

	public void setS_repls(List<SNSRepl> s_repls) {
		this.s_repls = s_repls;
	}

	public List<Hash> getS_hashs() {
		return s_hashs;
	}

	public void setS_hashs(List<Hash> s_hashs) {
		this.s_hashs = s_hashs;
	}

	public List<Hart> getS_harts() {
		return s_harts;
	}

	public void setS_harts(List<Hart> s_harts) {
		this.s_harts = s_harts;
	}

	
}
