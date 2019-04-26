package com.ht.hitea.alram;

import java.util.List;

import com.ht.hitea.Inquiry;

public interface AlramMapper {
	public abstract List<Alram> alramAll(Inquiry in);
	public abstract int alramRegHeart(Alram al);
	public abstract int alramRegFollow(Alram al);
	public abstract int alramRegSNS(Alram al);
}
