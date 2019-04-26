package com.ht.hitea.teabag.tb.bbs;

import java.util.List;

public interface TeabagBBSMapper {
	public abstract int writeBBS(BBS bbs);
	public abstract List<BBS> getBBSByTNo(BBS bbs);
	public abstract BBS getBBSByNo(BBS bbs);
	public abstract int updateBBS(BBS bbs);
	public abstract int deleteBBS(BBS bbs);
	public abstract int countBBS(BBS bbs);
	public abstract List<BBS> getBBSForPage(MinMax mm);
}
