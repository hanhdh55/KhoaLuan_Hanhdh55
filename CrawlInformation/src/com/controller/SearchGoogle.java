package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import com.util.Config;
import com.util.Exception404;


public class SearchGoogle {
	
	/*
	 * this function create form of a search query and send to Google
	 */
	public String RequestToGoogle(String qSearch,int start,int numOfResults)
	{
	    String toSearch = Config.searchURL + "key=" + Config.apiKey + "&cx=" + Config.customSearchEngineKey +"&q=";
	
	    String keys[]=qSearch.split(" ");
	    for(String key:keys){   
	        toSearch += key +"+";
	    }
    	toSearch+="&sort=date";
    	toSearch+="&safe=medium";
        toSearch+="&alt=json";
        toSearch+="&start="+start;
        toSearch+="&num="+numOfResults;
        
        try {
        	
	        URL url=new URL(toSearch);
	        
	        HttpURLConnection connection=(HttpURLConnection)url.openConnection();
	        
	        
//		        connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
//		        connection.setRequestProperty("Cookie", "foo=bar"); 
	        BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String line;
	        StringBuffer buffer=new StringBuffer();
	        while((line=br.readLine())!=null){
	            buffer.append(line);
	        }
	        return (SplitJson(buffer.toString()));
	   
	    }catch(Exception e){
	        e.printStackTrace();
	   }
	    return null;
	}
	
	
	
	/*
	 * this function spilt json result
	 */
	public String SplitJson(String string){
		String[] myresult = string.split("\"items\":");
	
		myresult[1] = myresult[1].substring(0, myresult[1].length()-1);
		return myresult[1];
	}
	
	/*
	 *  this function fetch content of a webpage
	 */
	public String FetchPage(String u){
	    try {
	    	
	        URL url = new URL(u);
	        URLConnection urlc = url.openConnection();
	       
	        //BufferedInputStream buffer = new BufferedInputStream(urlc.getInputStream());
	        BufferedReader buffer = new BufferedReader(new InputStreamReader(urlc.getInputStream(), "UTF8"));

	        StringBuilder builder = new StringBuilder();

	        int byteRead;

	        while ((byteRead = buffer.read()) != -1)
	            builder.append((char) byteRead);

	        buffer.close();
	        String text=builder.toString();
	        return text;
	    } 
	catch (IOException e) 
	{
	    e.printStackTrace();

	}catch (Exception e){
		System.out.println("Site still available");
	}
	    return "0";
	}
	
}
