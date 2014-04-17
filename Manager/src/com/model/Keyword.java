package com.model;

public class Keyword {
	private int key_id;
	private String keyname;
	
	public Keyword(int _id, String name){
		key_id = _id;
		keyname = name;
	}
	
	public int getKey_id() {
		return key_id;
	}
	public void setKey_id(int key_id) {
		this.key_id = key_id;
	}
	public String getKeyname() {
		return keyname;
	}
	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}
	
}
