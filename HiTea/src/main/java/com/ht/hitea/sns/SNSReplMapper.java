package com.ht.hitea.sns;

import java.util.List;

public interface SNSReplMapper {
	
	public abstract int snsReWrite(SNSRepl sr);

	public abstract int snsReDelete(SNSRepl sr);
	
	public abstract List<SNSRepl> getAllRepl(SNSBean s);
	public abstract List<SNSRepl> getAllRepl2(SNSBean s);
	public abstract List<SNSRepl> getSNSRepl(SNSRepl sr);

}
