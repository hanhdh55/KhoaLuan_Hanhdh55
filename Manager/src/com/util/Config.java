package com.util;

public class Config {
	//user
	public final static String apiKey = "AIzaSyDoON2BsdIyJ-yxVVUvzAsVqwSy5p5oXYg";
	public final static String customSearchEngineKey = "015798612582090919907:x_mtwi4pw8w";
	public final static String restrict = "d";
	
	//key words
	public final static String key_NguyenTanDung = "Nguyễn Tấn Dũng";
	public final static String key_TruongTanSang = "Trương Tấn Sang";
	public final static String key_ViemXoang = "Viêm xoang";
	public final static String key_ghibli = "Studio Ghibli";
	
	
	//base url for the search query
	public final static  String searchURL = "https://www.googleapis.com/customsearch/v1?";
	
	//MongoDB
	public final static  String DATABASE_MANAGEINFORMATION = "manageInformation";
	public final static  String COLLECTION_ResultFromGG = "resultFromGG";
	
	public final static  String FIELD_title = "title";
	public final static  String FIELD_link = "link";
	public final static  String FIELD_displayLink = "displayLink";
	public final static  String FIELD_snippet = "snippet";
	public final static  String FIELD_formattedUrl = "formattedUrl";
	
	
	//
	public final static int pageSize = 7;
	
	//Mysql, table keywords
		public final static  String TABLE_KEYWORDS = "keywords";
		public final static  String KEYWORDS_KEY_ID = "key_id";
		public final static  String KEYWORDS_KEYNAME = "keyname";
	
	//Mysql, table users
		public final static  String TABLE_USERS = "users";
		public final static  String USERS_USER_ID = "user_id";
		public final static  String USERS_USERNAME = "username";
		public final static  String USERS_PASSWORD = "password";
		public final static  String USERS_EMAIL = "email";
		
	//Mysql, table users_keywords
		public final static  String TABLE_USERSKEYWORDS = "users_keywords";
		public final static  String USERSKEYWORDS_USER_ID = "user_id";
		public final static  String USERSKEYWORDS_KEY_ID = "key_id";
}
