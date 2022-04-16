package com.jforce.tr.model;

public class Message {

	private String text;
	
	private Receipents receipents;
	
	
	public Message() {

	}

	public Message(String text, Receipents receipents) {
		this.text = text;
		this.receipents = receipents;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Receipents getReceipents() {
		return receipents;
	}

	public void setReceipents(Receipents receipents) {
		this.receipents = receipents;
	}
	
	
}
