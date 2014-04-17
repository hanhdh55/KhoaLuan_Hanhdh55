package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.model.ResultModel;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.util.Config;
import com.util.ConnectDB;

public class ArticleDao {
	public ArticleDao(){}
	
	/*
	 * this funtion get all document in database sort by time
	 */
	public List<ResultModel> retrieve(){
		List<ResultModel> listResult = new ArrayList<ResultModel>();
		DBCollection collection = ConnectDB.ConnectToACollection(
				Config.DATABASE_MANAGEINFORMATION, 
				Config.COLLECTION_ResultFromGG);
		
		DBCursor cur = collection.find().sort(new BasicDBObject("time", -1));
		while(cur.hasNext()){
			DBObject ob = cur.next();
			listResult.add((new Gson()).fromJson(ob.toString(), ResultModel.class));

		}

		return listResult;
	}
	
	/*
	 * this funtion count total document in DB
	 */
	public int CountPage(String collectionName){
		DBCollection collection = ConnectDB.ConnectToACollection(
				Config.DATABASE_MANAGEINFORMATION, 
				collectionName);
		
		int totalRe = (int) collection.count();
		int totalPage = 0;
		if(totalRe%Config.pageSize == 0){
			 totalPage = totalRe/(Config.pageSize);
		}
		else{
			totalPage = totalRe/(Config.pageSize) + 1;
		}

		return totalPage;
	}
	
	
	/*
	 * this funtion get document from DB and paging
	 */
	public List<ResultModel> retrieve2(int pageNumber, int pageSize){
		List<ResultModel> listResult = new ArrayList<ResultModel>();
		DBCollection collection = ConnectDB.ConnectToACollection(
				Config.DATABASE_MANAGEINFORMATION, 
				Config.COLLECTION_ResultFromGG);
		
		int toStart = (pageNumber - 1)*pageSize;
		
		DBCursor cur = collection.find().sort(new BasicDBObject("time", -1)).skip(toStart).limit(pageSize);
		while(cur.hasNext()){
			DBObject ob = cur.next();
			listResult.add((new Gson()).fromJson(ob.toString(), ResultModel.class));

		}

		return listResult;
	}
	
	/*
	 * this funtion get documents from DB and paging and table
	 */
	public List<ResultModel> retrieve3(int pageNumber, int pageSize, String col){
		List<ResultModel> listResult = new ArrayList<ResultModel>();
		DBCollection collection = ConnectDB.ConnectToACollection(
				Config.DATABASE_MANAGEINFORMATION, 
				col);
		
		int toStart = (pageNumber - 1)*pageSize;
		
		DBCursor cur = collection.find().sort(new BasicDBObject("time", -1)).skip(toStart).limit(pageSize);
		while(cur.hasNext()){
			DBObject ob = cur.next();
			listResult.add((new Gson()).fromJson(ob.toString(), ResultModel.class));

		}

		return listResult;
	}
	
	
	/*
	 * this function retrieve a document by link
	 */
	public ResultModel retrieveADoccument(String link){
		
		DBCollection collection = ConnectDB.ConnectToACollection(
				Config.DATABASE_MANAGEINFORMATION, 
				Config.COLLECTION_ResultFromGG);
		
		DBObject ob = new BasicDBObject("link", link);
		DBCursor dc = collection.find(ob);
		DBObject dob = dc.next();
		ResultModel document = new Gson().fromJson(dob.toString(), ResultModel.class);
		
		return document;
	}
	
	
}
