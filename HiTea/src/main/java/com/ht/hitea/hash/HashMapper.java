package com.ht.hitea.hash;

import java.util.List;

import com.ht.hitea.sns.SNSBean;

public interface HashMapper {
	public abstract int hashReg(Hash h);
	public abstract List<Hash> hashNoAll(SNSBean s);
}
