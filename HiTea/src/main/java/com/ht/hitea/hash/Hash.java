package com.ht.hitea.hash;

import java.math.BigDecimal;

public class Hash {
	private BigDecimal hhash_hs_no;
	private String hhash_text;
	public Hash() {
		// TODO Auto-generated constructor stub
	}
	public Hash(BigDecimal hhash_hs_no, String hhash_text) {
		super();
		this.hhash_hs_no = hhash_hs_no;
		this.hhash_text = hhash_text;
	}
	public BigDecimal getHhash_hs_no() {
		return hhash_hs_no;
	}
	public void setHhash_hs_no(BigDecimal hhash_hs_no) {
		this.hhash_hs_no = hhash_hs_no;
	}
	public String getHhash_text() {
		return hhash_text;
	}
	public void setHhash_text(String hhash_text) {
		this.hhash_text = hhash_text;
	}
	
}
