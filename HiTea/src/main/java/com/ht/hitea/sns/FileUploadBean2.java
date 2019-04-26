package com.ht.hitea.sns;

import java.math.BigDecimal;

public class FileUploadBean2 {

	private BigDecimal hfile_no;
	private String hfile_img;
	private String hfile_video;

	public FileUploadBean2() {
		// TODO Auto-generated constructor stub
	}

	public FileUploadBean2(BigDecimal hfile_no, String hfile_img, String hfile_video) {
		super();
		this.hfile_no = hfile_no;
		this.hfile_img = hfile_img;
		this.hfile_video = hfile_video;
	}

	public BigDecimal getHfile_no() {
		return hfile_no;
	}

	public void setHfile_no(BigDecimal hfile_no) {
		this.hfile_no = hfile_no;
	}

	public String getHfile_img() {
		return hfile_img;
	}

	public void setHfile_img(String hfile_img) {
		this.hfile_img = hfile_img;
	}

	public String getHfile_video() {
		return hfile_video;
	}

	public void setHfile_video(String hfile_video) {
		this.hfile_video = hfile_video;
	}

}
