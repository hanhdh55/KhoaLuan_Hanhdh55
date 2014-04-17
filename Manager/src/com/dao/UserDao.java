package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import com.model.User;
import com.util.Config;
import com.util.ConnectMySQL;

public class UserDao {
	ConnectMySQL mysql = new ConnectMySQL();
	
	public User retrieveUser(String username){
		String sql = "SELECT * FROM " + Config.TABLE_USERS + " WHERE " 
				+ Config.USERS_USERNAME + " = '" + username + "'";
		
		User _user = null;
		try {
			Connection conn = mysql.ConnectSQL();
			Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);
			if (res.next() == false) {
				return null;
			} else {
				_user = new User(res.getInt(1), res.getString(2), res.getString(3),
										res.getString(4));
			}
			
			res.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return _user;
	}
	
	public void insertUser(String name, String pass, String mail, String keyword){
		ResultSet rs = null;
		int user_id = 0;
		int keyword_id =0;
		
		String sql1 = "INSERT INTO " + Config.TABLE_USERS + "(username, password, email) VALUES ('" +
				name + "', '" + pass + "', '" + mail + "');";
		String sql2="INSERT INTO " + Config.TABLE_KEYWORDS + "(keyname) VALUES ('" + keyword + "')";
		
		
		
		
		try {
			Connection conn = mysql.ConnectSQL();
			Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_UPDATABLE);
			stmt.executeUpdate(sql1, Statement.RETURN_GENERATED_KEYS);
			rs = stmt.getGeneratedKeys();
			while (rs.next()) {
				user_id = rs.getInt(1);
			} 
			
			stmt.executeUpdate(sql2, Statement.RETURN_GENERATED_KEYS);
			rs = stmt.getGeneratedKeys();
			while (rs.next()) {
				keyword_id = rs.getInt(1);
			}
			
			String sql3="INSERT INTO " + Config.TABLE_USERSKEYWORDS + "(" + Config.USERSKEYWORDS_USER_ID +
					", " + Config.USERSKEYWORDS_KEY_ID + ") VALUES (" + user_id + ", " + keyword_id + ");";
			
			Statement stmt2 = conn.createStatement();
			stmt2.executeUpdate(sql3);
			
			stmt.close();
			stmt2.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
