package com.ht.hitea.follow;

import java.util.List;

public class Follows {
	private List<Follow> follow;
	public Follows() {
		// TODO Auto-generated constructor stub
	}
	public Follows(List<Follow> follow) {
		super();
		this.follow = follow;
	}
	public List<Follow> getFollow() {
		return follow;
	}
	public void setFollow(List<Follow> follow) {
		this.follow = follow;
	}
	
}
