package com.ht.hitea.seach;

import java.math.BigDecimal;

public class TeaBagSeach {
	private BigDecimal ht_no;
	private String ht_name;
	private String ht_category;
	private String ht_profilepic;
	
	public TeaBagSeach() {
		// TODO Auto-generated constructor stub
	}

	public TeaBagSeach(BigDecimal ht_no, String ht_name, String ht_category, String ht_profilepic) {
		super();
		this.ht_no = ht_no;
		this.ht_name = ht_name;
		this.ht_category = ht_category;
		this.ht_profilepic = ht_profilepic;
	}

	public BigDecimal getHt_no() {
		return ht_no;
	}

	public void setHt_no(BigDecimal ht_no) {
		this.ht_no = ht_no;
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

	public String getHt_profilepic() {
		return ht_profilepic;
	}

	public void setHt_profilepic(String ht_profilepic) {
		this.ht_profilepic = ht_profilepic;
	}
	
}
