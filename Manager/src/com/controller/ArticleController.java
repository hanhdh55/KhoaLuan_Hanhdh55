package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ArticleDao;
import com.dao.ReferenceDB;
import com.model.Keyword;
import com.model.ResultModel;

public class ArticleController {
	private static ArticleDao dao = new ArticleDao();
	private static ReferenceDB refer = new ReferenceDB();
	
	public ResultModel retrieveADoccument(String link) throws IOException{	
			ResultModel document = new ResultModel();
			document = dao.retrieveADoccument(link);
			return document;
	}
	
	/*
	 * this funtion get all document in database
	 */
	public List<ResultModel> retrieve(){
		List<ResultModel> listResult = new ArrayList<ResultModel>();
		listResult = dao.retrieve();
		return listResult;
	}
	
	public int CountPage(int user_id, int key_id){
		Keyword keyword = refer.getKeyword(user_id, key_id);
		
		String collection = keyword.getKey_id() + "";
		
		int totalPage = dao.CountPage(collection);
		return totalPage;
	}
	
	public List<ResultModel> retrieve2(int pageNumber, int pageSize){
		
		List<ResultModel> listResult = new ArrayList<ResultModel>();
		listResult = dao.retrieve2(pageNumber, pageSize);
		
		return listResult;
	}
	
	public List<ResultModel> retrieve3(int pageNumber, int pageSize, String col){
		
		List<ResultModel> listResult = new ArrayList<ResultModel>();
		listResult = dao.retrieve3(pageNumber, pageSize, col);
		
		return listResult;
	}
	
	public List<ResultModel> retrieve4(int pageNumber, int pageSize, int user_id, int key_id){
		Keyword keyword = refer.getKeyword(user_id, key_id);
		
		String collection = keyword.getKey_id() + "";
		List<ResultModel> listResult = new ArrayList<ResultModel>();
		listResult = dao.retrieve3(pageNumber, pageSize, collection);
		
		
		
		return listResult;
	}
	
	public List<Keyword> getListKey(int user_id){
		List<Keyword> listKeywords = new ArrayList<Keyword>();
		
		listKeywords = refer.getListKey(user_id);
		return listKeywords;
	}
	
	public Keyword getKeyword(int user_id, int key_id){
		Keyword keyword = refer.getKeyword(user_id, key_id);
		return keyword;
	}
}

