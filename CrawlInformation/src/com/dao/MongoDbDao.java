package com.dao;

import java.net.UnknownHostException;
import java.util.Date;

import com.model.ResultBing;
import com.model.ResultGoogle;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.util.Config;
import com.util.ConnectDB;

public class MongoDbDao {
ConnectDB conn = new ConnectDB();
	
	/*
	 * The function check whether the record has already existed in db
	 */
	public boolean CheckExistsRecord(String key, String value, String collectionName){
		DBCollection collection = ConnectDB.ConnectToACollection(
				Config.DATABASE_MANAGEINFORMATION, 
				collectionName);
		DBObject query = new BasicDBObject(key, value);
		DBCursor result = collection.find(query);
		if(result.size() > 0){
			return true;
		}
		return false;
	}
	
	/*
	 * this function insert record to database if it didn't exist
	 */
	public void InsertDBObjectToDB(ResultGoogle result, String collectionName) throws UnknownHostException, MongoException{
		DBCollection collection = ConnectDB.ConnectToACollection(
												Config.DATABASE_MANAGEINFORMATION, 
												collectionName);
		
		BasicDBObject bs = new BasicDBObject();
//		bs.put("title", result.getTitle());
//		bs.put("link", result.getLink());
//		bs.put("displayLink", result.getDisplayLink());
//		bs.put("snippet", result.getSnippet());
//		bs.put("htmlSnippet", result.getHtmlSnippet());
//		bs.put("cacheId", result.getCacheId());
//		bs.put("formattedUrl", result.getFormattedUrl());
		bs.put("title", result.getTitle());
		bs.put("description", result.getSnippet());
		bs.put("displayUrl", result.getDisplayLink());
		bs.put("url", result.getLink());
		bs.put("sourceCode", result.getSourceCode());
		
		Date time = new Date();
		bs.put("time", time);
			collection.save(bs);
			System.out.println("insert successful");
	}
	
	
	public void InsertDBObjectToDB(ResultBing result, String collectionName) throws UnknownHostException, MongoException{
		DBCollection collection = ConnectDB.ConnectToACollection(
												Config.DATABASE_MANAGEINFORMATION, 
												collectionName);
		
		BasicDBObject bs = new BasicDBObject();
		
		bs.put("title", result.getTitle());
		bs.put("description", result.getDescription());
		bs.put("displayUrl", result.getDisplayUrl());
		bs.put("url", result.getUrl());
		bs.put("sourceCode", result.getSourceCode());
		
		Date time = new Date();
		bs.put("time", time);
			collection.save(bs);
			System.out.println("insert successful");
	}
	/*
	 * This function update a document
	 */
	public void UpdateDBObjectToDB(String key, String value, ResultGoogle result, String collectionName) throws UnknownHostException, MongoException{
		DBCollection collection = ConnectDB.ConnectToACollection(
												Config.DATABASE_MANAGEINFORMATION, 
												collectionName);
		DBObject oldOb = new BasicDBObject(key, value);
		BasicDBObject newOb = new BasicDBObject();
//		newOb.put("title", result.getTitle());
//		newOb.put("link", result.getLink());
//		newOb.put("displayLink", result.getDisplayLink());
//		newOb.put("snippet", result.getSnippet());
//		newOb.put("htmlSnippet", result.getHtmlSnippet());
//		newOb.put("cacheId", result.getCacheId());
//		newOb.put("formattedUrl", result.getFormattedUrl());
		newOb.put("Title", result.getTitle());
		newOb.put("Description", result.getSnippet());
		newOb.put("DisplayUrl", result.getDisplayLink());
		newOb.put("Url", result.getLink());
		newOb.put("sourceCode", result.getSourceCode());
		Date time = new Date();
		newOb.put("time", time);
		collection.update(oldOb, newOb);
		System.out.println("Update successful");
	}
	
	public void UpdateDBObjectToDB(String key, String value, ResultBing result, String collectionName) throws UnknownHostException, MongoException{
		DBCollection collection = ConnectDB.ConnectToACollection(
												Config.DATABASE_MANAGEINFORMATION, 
												collectionName);
		DBObject oldOb = new BasicDBObject(key, value);
		BasicDBObject newOb = new BasicDBObject();

		newOb.put("Title", result.getTitle());
		newOb.put("Description", result.getDescription());
		newOb.put("DisplayUrl", result.getDisplayUrl());
		newOb.put("Url", result.getUrl());
		newOb.put("sourceCode", result.getSourceCode());
		Date time = new Date();
		newOb.put("time", time);
		collection.update(oldOb, newOb);
		System.out.println("Update successful");
	}
	
	/*
	 * this function remove a document from mongodb
	 */
	public static void RemoveADocument(String key, String value, String col){
		DBCollection collection = ConnectDB.ConnectToACollection(
				Config.DATABASE_MANAGEINFORMATION, 
				col);
		DBObject query = new BasicDBObject(key, value);
		DBCursor result = collection.find(query);
		if(result.size() > 0){
			collection.remove(query);
			System.out.println("remove completed");
		}
		else{
			System.out.println("document dosen't exist");
		}
	}
	
	/*
	 * this function remove all documents from mongodb
	 */
	public static void RemoveAllDocuments(String col){
		DBCollection collection = ConnectDB.ConnectToACollection(
				Config.DATABASE_MANAGEINFORMATION, 
				col);
		
		DBCursor cursor = collection.find();
		while (cursor.hasNext()){
			collection.remove(cursor.next());
		}
		System.out.println("Delete all documents complete");
	}
}
