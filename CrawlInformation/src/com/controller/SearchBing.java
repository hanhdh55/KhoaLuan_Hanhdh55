package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;

import com.util.Config;

public class SearchBing {
	/*
	 * ham tao chuoi va truy van den bing de lay ve ket qua
	 */
	public String RequestToBing(String searchText){
		searchText = searchText.replaceAll(" ", "%20");
        //String accountKey="7QrIxJTGvXoU8Dzx4mqacYdhlw9z9hAdsRb85M6f03I";
      
        byte[] accountKeyBytes = Base64.encodeBase64((Config.accountKey + ":" + Config.accountKey).getBytes());
        String accountKeyEnc = new String(accountKeyBytes);
        URL url;
        try {
            url = new URL(
                    "https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=%27" + searchText + "%27&$top=50&$format=Json");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "Basic " + accountKeyEnc);
        //conn.setRequestProperty("Accept", "application/json");
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));
        String line;
        StringBuffer buffer=new StringBuffer();
        while((line=br.readLine())!=null){
            buffer.append(line);
        }
        return(splitFileBing(buffer.toString()));
        
		}catch (MalformedURLException e1) {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
        return null;
	}
	
	public static String splitFileBing(String json){
		String[] myresult1 = json.split("\"results\":");
		String[] myresult2 = myresult1[1].split(",\"__next\"");
		return myresult2[0];
		
	}
}
