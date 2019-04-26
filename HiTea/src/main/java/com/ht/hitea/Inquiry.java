package com.ht.hitea;
import java.math.BigDecimal;

public class Inquiry {
	private BigDecimal start;
	private BigDecimal end;
	private String content;
	public Inquiry() {
		// TODO Auto-generated constructor stub
	}
	public Inquiry(BigDecimal start, BigDecimal end, String content) {
		super();
		this.start = start;
		this.end = end;
		this.content = content;
	}
	public BigDecimal getStart() {
		return start;
	}
	public void setStart(BigDecimal start) {
		this.start = start;
	}
	public BigDecimal getEnd() {
		return end;
	}
	public void setEnd(BigDecimal end) {
		this.end = end;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	
	
}
