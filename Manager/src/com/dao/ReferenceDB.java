package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Keyword;
import com.util.Config;
import com.util.ConnectMySQL;

public class ReferenceDB {
	ConnectMySQL mysql = new ConnectMySQL();
	
	/*
	 * this function return list keyword of user has user_id
	 */
	public List<Keyword> getListKey(int user_id){
		List<Keyword> listKeywords = new ArrayList<Keyword>();
		
		String sql= "SELECT * FROM " + Config.TABLE_KEYWORDS + 
				" k JOIN " + Config.TABLE_USERSKEYWORDS + " uk ON k." 
				+ Config.KEYWORDS_KEY_ID + " = uk." + Config.USERSKEYWORDS_KEY_ID + 
				" WHERE " + Config.USERSKEYWORDS_USER_ID + " = " + user_id;
		try {
			Connection conn = mysql.ConnectSQL();
			Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);
			
			while (res.next()){
				Keyword keyword = new Keyword(res.getInt(1), res.getString(2));
				listKeywords.add(keyword);
			}
			res.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listKeywords;
	}
	
	/*
	 * this function return  keyword has key_id of user_id
	 */
	public Keyword getKeyword(int user_id, int key_id){
		Keyword keyword = null;
		String sql= "SELECT * FROM " + Config.TABLE_KEYWORDS + 
				" k JOIN " + Config.TABLE_USERSKEYWORDS + " uk ON k." + Config.KEYWORDS_KEY_ID + " = uk." + Config.USERSKEYWORDS_KEY_ID + 
				" WHERE uk." + Config.USERSKEYWORDS_USER_ID + " = " + user_id + " AND uk." + Config.USERSKEYWORDS_KEY_ID + " = " + key_id;
	try {
		Connection conn = mysql.ConnectSQL();
		Statement stm = conn.createStatement();
		ResultSet res = stm.executeQuery(sql);
		while(res.next()){
			keyword = new Keyword(res.getInt(1), res.getString(2));
			
		}
		res.close();
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
		return keyword;
	}
}
