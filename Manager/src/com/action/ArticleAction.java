package com.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.controller.ArticleController;
import com.model.Keyword;
import com.model.ResultModel;
import com.util.Config;

public class ArticleAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5815744948867280826L;
	
	//variables for result from DB
	private ResultModel document;
	private List<ResultModel> list;
	
	private List<Keyword> listKeywords; 
	private Keyword keyword;
	private int key_id;
	private String keyname;
	private Map<String, Object> session;
	
	// variables for paging
	private String pageNumber;
	private String totalPage;
	private int pageSize = Config.pageSize;
	
	private String url;
	private String sourceCode;
	
	private ArticleController control = new ArticleController();
	
	/*
	 * this funtion retrieve document from db, 
	 * return to jsp page
	 */
	public String Retrieve() throws IOException{
		int user_id = (int) session.get("user_id");	
		//cac keyword cua nguoi dung co user_id
		listKeywords = control.getListKey(user_id);
		
		int keyid = getKey_id();
		if(keyid == 0){
			Keyword k = listKeywords.get(0);
			keyid =  k.getKey_id();
		}
		
		keyname = control.getKeyword(user_id, keyid).getKeyname();
		
		//list ket qua cua keyword co key_id
		list = new ArrayList<ResultModel>();
		
		//list = control.retrieve();
		if(pageNumber == null || pageNumber == "0" || pageNumber == ""){
			pageNumber = "1";
		}
		int pageNum = Integer.parseInt(pageNumber);
		
		list = control.retrieve4(pageNum, Config.pageSize, user_id, keyid);
		
		int _totalPage = control.CountPage(user_id, keyid);
		totalPage = _totalPage + "";
		
		if(_totalPage == 0){
			pageNumber = "0";
		}
		
		return "success3";
	}
	
	
	public String getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}

	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}


	public ArticleController getControl() {
		return control;
	}

	public void setControl(ArticleController control) {
		this.control = control;
	}

	public ResultModel getDocument() {
		return document;
	}
	public void setDocument(ResultModel document) {
		this.document = document;
	}
	public List<ResultModel> getList() {
		return list;
	}
	public void setList(List<ResultModel> list) {
		this.list = list;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public List<Keyword> getListKeywords() {
		return listKeywords;
	}


	public void setListKeywords(List<Keyword> listKeywords) {
		this.listKeywords = listKeywords;
	}


	public Keyword getKeyword() {
		return keyword;
	}


	public void setKeyword(Keyword keyword) {
		this.keyword = keyword;
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
