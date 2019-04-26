package com.ht.hitea.sns;

import java.util.List;

import com.ht.hitea.Inquiry;

public interface FileUploadMapper {
	
	public abstract int snsWrite2(SNSBean s);
	
	public abstract List<SNSBean> getAllSNSMsg2(); 
	public abstract List<SNSBean> getShowSNS(Inquiry in); 

	public abstract int fileWrite2(FileUploadBean2 f);
	
	public abstract SNSBean getOne2();

	public abstract List<FileUploadBean2> getAllfile2(SNSBean s);
	
	public abstract SNSBean getSNSMsg(SNSBean s);
	
	public abstract int snsDelete(SNSBean s);

	public abstract int getAllSNSCount();
	
	
	public abstract List<SNSBean> snsPage(Inquiry in);
	public abstract Integer snsPageCount(Inquiry in);
	public abstract List<SNSBean> snsPageHeart(Inquiry in);
	public abstract Integer snsPageHeartCount(Inquiry in);
		
}
