package com.ht.hitea.hart;

import java.util.List;

import com.ht.hitea.sns.SNSBean;

public interface HartMapper {
	public abstract List<Hart> hart(SNSBean s);
	public abstract List<Hart> hartImgCheck(SNSBean s);
	public abstract int hartDelete(SNSBean s);
	public abstract int hartReg(SNSBean s);
}
