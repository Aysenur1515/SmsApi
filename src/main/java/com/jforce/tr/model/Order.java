package com.jforce.tr.model;

import java.util.Date;

public class Order {
	
	private String sender;
    private Date[] sendDateTime;
    private int iys;
    private String iysList;
    private Message message;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Date[] getSendDateTime() {
		return sendDateTime;
	}
	public void setSendDateTime(Date[] sendDateTime) {
		this.sendDateTime = sendDateTime;
	}
	public int getIys() {
		return iys;
	}
	public void setIys(int iys) {
		this.iys = iys;
	}
	public String getIysList() {
		return iysList;
	}
	public void setIysList(String iysList) {
		this.iysList = iysList;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
}
