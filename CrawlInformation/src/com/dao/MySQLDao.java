package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Keyword;
import com.util.Config;
import com.util.ConnectMySQL;

public class MySQLDao {
	ConnectMySQL connMySQL = new ConnectMySQL();
	
	public Keyword retrieveKeyword() throws SQLException{
		Keyword keyword = null;
		Connection conn = connMySQL.ConnectSQL();
		Statement stm = conn.createStatement();
		String sql = "SELECT * FROM " + Config.TABLE_KEYWORDS + " WHERE " + Config.COLUMN_KEY_ID + " = 1";
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next()){
			int id = rs.getInt("key_id");
			String name = rs.getString("keyname");
			keyword = new Keyword(id, name);
		}
		rs.close();
		return keyword;
	}
	
	public List<Keyword> getKeywords() throws SQLException{
		List<Keyword> listKeywords = new ArrayList<Keyword>();
		Connection conn = connMySQL.ConnectSQL();
		Statement stm = conn.createStatement();
		String sql = "SELECT * FROM " + Config.TABLE_KEYWORDS;
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next()){
			Keyword keyword = new Keyword(rs.getInt(1), rs.getString(2));
			listKeywords.add(keyword);
		}
		return listKeywords;
	}
	
	public int countRows() throws SQLException{
		int rows = 0;
		Connection conn = connMySQL.ConnectSQL();
		Statement stm = conn.createStatement();
		String sql = "SELECT COUNT(*) FROM " + Config.TABLE_KEYWORDS;
		ResultSet rs = stm.executeQuery(sql);
		
		while (rs.next()){
			rows = rs.getInt(1);
		}
		return rows;
	}
}
