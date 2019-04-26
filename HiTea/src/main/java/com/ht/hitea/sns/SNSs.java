package com.ht.hitea.sns;

import java.util.List;

public class SNSs {
	private List<SNSBean> snsBeans;
	
	public SNSs() {
		// TODO Auto-generated constructor stub
	}

	public SNSs(List<SNSBean> snsBeans) {
		super();
		this.snsBeans = snsBeans;
	}

	public List<SNSBean> getSnsBeans() {
		return snsBeans;
	}

	public void setSnsBeans(List<SNSBean> snsBeans) {
		this.snsBeans = snsBeans;
	}
	
}
