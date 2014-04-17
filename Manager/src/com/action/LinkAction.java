package com.action;

import com.opensymphony.xwork2.ActionSupport;

public class LinkAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String forgotPassword() {
		return "forgotPassword";
	}
	public String login() {
		return "login";
	}
	public String first() {
		return "first";
	}

}
