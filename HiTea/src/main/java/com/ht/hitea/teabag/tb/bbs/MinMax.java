package com.ht.hitea.teabag.tb.bbs;

import java.math.BigDecimal;

public class MinMax {
	private BigDecimal min;
	private BigDecimal max;
	private BigDecimal hb_tno;
	
	public MinMax() {
		// TODO Auto-generated constructor stub
	}

	public MinMax(BigDecimal min, BigDecimal max, BigDecimal hb_tno) {
		super();
		this.min = min;
		this.max = max;
		this.hb_tno = hb_tno;
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

	public BigDecimal getHb_tno() {
		return hb_tno;
	}

	public void setHb_tno(BigDecimal hb_tno) {
		this.hb_tno = hb_tno;
	}

	
	
}
