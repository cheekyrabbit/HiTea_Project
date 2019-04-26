package com.ht.hitea.follow;

import java.time.LocalDateTime;

public class Follow {
	private String hf_following_hm_id;
	private String hf_follower_id;
	private	LocalDateTime hf_date;
	public Follow() {
		// TODO Auto-generated constructor stub
	}
	public Follow(String hf_following_hm_id, String hf_follower_id, LocalDateTime hf_date) {
		super();
		this.hf_following_hm_id = hf_following_hm_id;
		this.hf_follower_id = hf_follower_id;
		this.hf_date = hf_date;
	}
	public String getHf_following_hm_id() {
		return hf_following_hm_id;
	}
	public void setHf_following_hm_id(String hf_following_hm_id) {
		this.hf_following_hm_id = hf_following_hm_id;
	}
	public String getHf_follower_id() {
		return hf_follower_id;
	}
	public void setHf_follower_id(String hf_follower_id) {
		this.hf_follower_id = hf_follower_id;
	}
	public LocalDateTime getHf_date() {
		return hf_date;
	}
	public void setHf_date(LocalDateTime hf_date) {
		this.hf_date = hf_date;
	}
	
}
