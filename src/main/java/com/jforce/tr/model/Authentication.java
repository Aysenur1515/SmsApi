package com.jforce.tr.model;

public class Authentication {

	 private String key;
	 
	 private String hash;
	 
	 public Authentication() {

	 }

	public Authentication(String key, String hash) {
		this.key = key;
		this.hash = hash;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
	
	
}
