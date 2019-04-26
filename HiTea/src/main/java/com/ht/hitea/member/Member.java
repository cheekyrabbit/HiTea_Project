package com.ht.hitea.member;

import java.math.BigDecimal;

public class Member {
	private String hm_id;
	private String hm_pw;
	private String hm_nickname;
	private String hm_name;
	private String hm_email;
	private String hm_pw_question;
	private String hm_pw_answer;
	private String hm_selfIntroduction;
	private String hm_photo_front;
	private String hm_photo_back;
	
	private BigDecimal hs_no;
	private String hs_hm_nickname;

	private String hf_follower_id;
	private String hf_following_hm_id;
	
	private String ht_leaderid;
	private String ht_profilepic;
	private String ht_name;
	private String ht_category;
	private BigDecimal ht_no;
	
	private String hm_selfIntroduction2;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String hm_id, String hm_pw, String hm_nickname, String hm_name, String hm_email,
			String hm_pw_question, String hm_pw_answer, String hm_selfIntroduction, String hm_photo_front,
			String hm_photo_back, BigDecimal hs_no, String hs_hm_nickname, String hf_follower_id,
			String hf_following_hm_id, String ht_leaderid, String ht_profilepic, String ht_name, String ht_category,
			BigDecimal ht_no) {
		super();
		this.hm_id = hm_id;
		this.hm_pw = hm_pw;
		this.hm_nickname = hm_nickname;
		this.hm_name = hm_name;
		this.hm_email = hm_email;
		this.hm_pw_question = hm_pw_question;
		this.hm_pw_answer = hm_pw_answer;
		this.hm_selfIntroduction = hm_selfIntroduction;
		this.hm_photo_front = hm_photo_front;
		this.hm_photo_back = hm_photo_back;
		this.hs_no = hs_no;
		this.hs_hm_nickname = hs_hm_nickname;
		this.hf_follower_id = hf_follower_id;
		this.hf_following_hm_id = hf_following_hm_id;
		this.ht_leaderid = ht_leaderid;
		this.ht_profilepic = ht_profilepic;
		this.ht_name = ht_name;
		this.ht_category = ht_category;
		this.ht_no = ht_no;
	}

	public String getHm_id() {
		return hm_id;
	}

	public void setHm_id(String hm_id) {
		this.hm_id = hm_id;
	}

	public String getHm_pw() {
		return hm_pw;
	}

	public void setHm_pw(String hm_pw) {
		this.hm_pw = hm_pw;
	}

	public String getHm_nickname() {
		return hm_nickname;
	}

	public void setHm_nickname(String hm_nickname) {
		this.hm_nickname = hm_nickname;
	}

	public String getHm_name() {
		return hm_name;
	}

	public void setHm_name(String hm_name) {
		this.hm_name = hm_name;
	}

	public String getHm_email() {
		return hm_email;
	}

	public void setHm_email(String hm_email) {
		this.hm_email = hm_email;
	}

	public String getHm_pw_question() {
		return hm_pw_question;
	}

	public void setHm_pw_question(String hm_pw_question) {
		this.hm_pw_question = hm_pw_question;
	}

	public String getHm_pw_answer() {
		return hm_pw_answer;
	}

	public void setHm_pw_answer(String hm_pw_answer) {
		this.hm_pw_answer = hm_pw_answer;
	}

	public String getHm_selfIntroduction() {
		return hm_selfIntroduction;
	}

	public void setHm_selfIntroduction(String hm_selfIntroduction) {
		this.hm_selfIntroduction = hm_selfIntroduction;
	}

	public String getHm_photo_front() {
		return hm_photo_front;
	}

	public void setHm_photo_front(String hm_photo_front) {
		this.hm_photo_front = hm_photo_front;
	}

	public String getHm_photo_back() {
		return hm_photo_back;
	}

	public void setHm_photo_back(String hm_photo_back) {
		this.hm_photo_back = hm_photo_back;
	}

	public BigDecimal getHs_no() {
		return hs_no;
	}

	public void setHs_no(BigDecimal hs_no) {
		this.hs_no = hs_no;
	}

	public String getHs_hm_nickname() {
		return hs_hm_nickname;
	}

	public void setHs_hm_nickname(String hs_hm_nickname) {
		this.hs_hm_nickname = hs_hm_nickname;
	}

	public String getHf_follower_id() {
		return hf_follower_id;
	}

	public void setHf_follower_id(String hf_follower_id) {
		this.hf_follower_id = hf_follower_id;
	}

	public String getHf_following_hm_id() {
		return hf_following_hm_id;
	}

	public void setHf_following_hm_id(String hf_following_hm_id) {
		this.hf_following_hm_id = hf_following_hm_id;
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

	public BigDecimal getHt_no() {
		return ht_no;
	}

	public void setHt_no(BigDecimal ht_no) {
		this.ht_no = ht_no;
	}

	public String getHm_selfIntroduction2() {
		return hm_selfIntroduction2;
	}

	public void setHm_selfIntroduction2(String hm_selfIntroduction2) {
		this.hm_selfIntroduction2 = hm_selfIntroduction2;
	}

}
