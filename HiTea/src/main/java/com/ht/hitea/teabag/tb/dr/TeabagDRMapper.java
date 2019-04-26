package com.ht.hitea.teabag.tb.dr;

import java.util.List;

public interface TeabagDRMapper {
	public abstract int writeFile(Dataroom dr);
	public abstract int writePhoto(Dataroom dr);
	public abstract List<Dataroom> getPhotoByTNo(Dataroom dr);
	public abstract List<Dataroom> getFileByTNo(Dataroom dr);
	public abstract Dataroom getDRByNo(Dataroom dr);
	public abstract int deleteFile(Dataroom dr);
	public abstract int countDRPhoto(Dataroom dr);
	public abstract int countDRFile(Dataroom dr);
}
