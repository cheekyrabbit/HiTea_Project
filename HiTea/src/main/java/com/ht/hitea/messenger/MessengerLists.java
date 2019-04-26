package com.ht.hitea.messenger;

import java.util.List;

public class MessengerLists {
	
	private List<MessengerList> msgLists;
	
	public MessengerLists() {
		// TODO Auto-generated constructor stub
	}

	public MessengerLists(List<MessengerList> msgLists) {
		super();
		this.msgLists = msgLists;
	}

	public List<MessengerList> getMsgLists() {
		return msgLists;
	}

	public void setMsgLists(List<MessengerList> msgLists) {
		this.msgLists = msgLists;
	}
	
}
