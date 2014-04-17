package com.controller;

import java.io.ObjectInputStream.GetField;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.ws.WebEndpoint;

import com.dao.MongoDbDao;
import com.dao.MySQLDao;
import com.model.Keyword;
import com.model.ResultBing;
import com.model.ResultGoogle;
import com.mongodb.MongoException;
import com.util.Config;
import com.util.ConnectDB;


public class main {
	
	public static void execute() throws UnknownHostException, MongoException, SQLException{
		MySQLDao mysql = new MySQLDao();
		//MongoDbDao mongo = new MongoDbDao();
		//mongo.RemoveAllDocuments("1");
		int time = 0;
		
		//Keyword
		//String qsearch = mysql.retrieveKeyword().getKeyname();
		List<Keyword> listKeyword = mysql.getKeywords();
		if(listKeyword.size() == 0){
			System.out.println("There are no any keywords");
			System.exit(0);
		}
		else{
			time = 86400000*(2*listKeyword.size())/100;
			
			long a  = System.currentTimeMillis();
			for(Keyword keyword : listKeyword){
				
				//lay keyword de search
				String qsearch = keyword.getKeyname();
				//ten collection luu dl
				String collectionName = keyword.getKey_id() + "";
				System.out.println("\n\n--------------Keyword: " + keyword.getKeyname() + "---------------------\n");
				
				Json cv = new Json();
				SearchGoogle web = new SearchGoogle();
				MongoDbDao dao = new MongoDbDao();
				for (int k = 1; k <12; k+=10){
					SearchGoogle search = new SearchGoogle();
					String result = search.RequestToGoogle(qsearch, k, 10);
					ResultGoogle[] listResultGG = cv.convertToJavaObjectGoogle(result);
					
					for (int i = 0; i < listResultGG.length; i++){
						System.out.println(listResultGG[i].getLink());
						listResultGG[i].setSourceCode(web.FetchPage(listResultGG[i].getLink()));
						
						if(dao.CheckExistsRecord(Config.FIELD_link, listResultGG[i].getLink(), collectionName)){
							dao.UpdateDBObjectToDB(Config.FIELD_link, listResultGG[i].getLink(), listResultGG[i], collectionName);
						}
						else{
							dao.InsertDBObjectToDB(listResultGG[i], collectionName);
						}
					}
				}
				
				SearchBing bing = new SearchBing();
				String resultBing = bing.RequestToBing(qsearch);
				ResultBing[] listResultBing = cv.convertToJavaObjectBing(resultBing);
				for(int i = 0; i < 20; i++){
					System.out.println(listResultBing[i].getUrl());
					listResultBing[i].setSourceCode(web.FetchPage(listResultBing[i].getUrl()));
					if(dao.CheckExistsRecord(Config.FIELD_link, listResultBing[i].getUrl(), collectionName)){
						dao.UpdateDBObjectToDB(Config.FIELD_link, listResultBing[i].getUrl(), listResultBing[i], collectionName);
					}
					else {
						dao.InsertDBObjectToDB(listResultBing[i], collectionName);
					}
				}
			}
			long b = System.currentTimeMillis();
			System.out.println("Total time is " + (b-a) + "ms. Waiting " + time + " ms.");
		}
	
		int interval = time; // seconds
		Date timeToRun = new Date(System.currentTimeMillis() + interval);
		time(timeToRun);
	}
	
	public static void time(Date date){
		int interval = 10000; // 10 sec
	    Date timeToRun = new Date(System.currentTimeMillis() + interval);
	    Timer timer = new Timer();
	    
	    timer.schedule(new TimerTask() {
	            public void run() {
	            	try {
						execute();
					} catch (UnknownHostException | MongoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        }, date);
	}
	
	public static void main(String[] args) throws  MongoException, UnknownHostException{
		int interval = 10000; // 10 sec
		Date timeToRun = new Date(System.currentTimeMillis() + interval);
		time(timeToRun);
		
	}
}

