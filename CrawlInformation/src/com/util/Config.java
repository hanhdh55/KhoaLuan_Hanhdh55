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
	
	
	//Bing
	public final static String accountKey="7QrIxJTGvXoU8Dzx4mqacYdhlw9z9hAdsRb85M6f03I";
	
	
	//MongoDB
	public final static  String DATABASE_MANAGEINFORMATION = "manageInformation";
	public final static  String COLLECTION_ResultFromGG = "resultFromGG";
	public final static  String COLLECTION_result2 = "result2";
	
	public final static  String FIELD_title = "Title";
	public final static  String FIELD_link = "Url";
	public final static  String FIELD_displayLink = "DisplayLink";
	public final static  String FIELD_snippet = "Description";
	public final static  String FIELD_formattedUrl = "formattedUrl";
	
	
	
	//Mysql, table keywords
	public final static  String TABLE_KEYWORDS = "keywords";
	public final static  String COLUMN_KEY_ID = "key_id";
	public final static  String COLUMN_KEYNAME = "keyname";
}
