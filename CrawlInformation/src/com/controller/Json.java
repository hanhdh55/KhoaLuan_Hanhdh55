package com.controller;

import com.google.gson.Gson;
import com.model.ResultBing;
import com.model.ResultGoogle;


public class Json {
	
	/*
	 * this function convert json result to java object
	 */
	public ResultGoogle[] convertToJavaObjectGoogle(String json){
		try{
			ResultGoogle[] result = new Gson().fromJson(json, ResultGoogle[].class);
			for(ResultGoogle re : result){
				String[] cut = re.getSnippet().split("giờ trước ... ");
				if(cut.length == 2){
					re.setSnippet(cut[1]);
				}
				
			}
			return result;
			
			
		}catch (Exception e) {  
			   e.printStackTrace();  
		}
		return null;
	}
	
	public ResultBing[] convertToJavaObjectBing(String json){
		try{
			ResultBing[] result = new Gson().fromJson(json, ResultBing[].class);
			return result;
			
		}catch (Exception e) {  
			   e.printStackTrace();  
		}
		return null;
	}
}
