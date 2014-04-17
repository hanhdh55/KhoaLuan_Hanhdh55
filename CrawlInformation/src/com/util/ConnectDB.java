package com.util;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class ConnectDB {
	public static MongoClient connect(){
		try {
		 
			/**** Connect to MongoDB ****/
			// Since 2.10.0, uses MongoClient
			MongoClient mongo = new MongoClient("localhost", 27017);
			return mongo;
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static DBCollection ConnectToACollection(String dbname, String colname){
		try{
			MongoClient conn = connect();
			DB database = conn.getDB(dbname);
			
			DBCollection collection = database.getCollection(colname);
			return collection;
			
		} catch (MongoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
