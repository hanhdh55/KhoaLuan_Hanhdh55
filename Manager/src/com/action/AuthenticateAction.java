package com.action;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import com.controller.UserController;

public class AuthenticateAction extends BaseAction {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7875640829723507932L;
	
	//Email regular expression
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	//username regular expression
	private static final String USERNAME_PATTERN = "^[a-z0-9_-]{4,15}$";
	private static final int MIN_LENGTH_PASSWORD = 6;
	private Map<String, Object> session;
	
	//Object dung de tao pattern va check su match cua String nhap vao va pattern
	private Pattern pattern;
	private Matcher matcher;
	
	//private int user_id;
	private String username;
	private String password;
	private String email;
	private String keyword;
	
	/* Ham action cua trang login.jsp-----------------------------------------
	 * 1.Kiem tra tinh hop le cua du lieu nhap vao
	 * 2.Kiem tra trong co so du lieu
	 * 3.Neu login thanh cong thi tao session logon
	*/
	public String login() {
		UserController userController = new UserController();
		
		int user_id;
		String loggedUsername = null;
		if (session.containsKey("username")) {
			loggedUsername = (String) session.get("username");
		} 
		if (loggedUsername != null) {
			user_id = userController.retrieveUser(loggedUsername).getUser_id();
			
			return "success";
		} else if (username == null) {
			return "error";
		}
		
		if (!validateFormLogin()) {
			return "error";
		} else {
			if (!userController.checkPassword(username, password)) {
				addActionError("Username or password is incorrect!");
				return "error";
			}
			
		}
		user_id = userController.retrieveUser(username).getUser_id();
		
		//Dang nhap hop le, tao session
		session.put("logon","true");
		session.put("username", username);
		session.put("user_id", user_id);
		
		return "success";
	}
	
	/*
	 * ham thuc hien dang ki tai khoan moi
	 */
	public String register(){
		UserController userController = new UserController();
	
		if (!validateFormRegister()) {
			return "error";
		} else {
			if (userController.checkUser(username)) {
				addActionError("User has existed!");
				return "error";
			}
		}
		System.out.println(keyword);
		userController.insertUser(username, password, email, keyword);
		addActionError("Create successful");
		return "success";
	}
	
	/*
	 * 
	 */
	public String registerPage(){
		return "success";
	}
	/*
	 * Ham thuc hien validate form login
	 */
	public boolean validateFormLogin() {
		if (username.equals("") && password.equals("")) {
			addActionError("Username and Password are required!");
			return false;
		}
		if (username.equals("")) {
			addActionError("Username is required!");
			return false;
		}
		if (password.equals("")) {
			addActionError("Password is required!");
			return false;
		}
		if (!validateUsername(username) || !validatePassword(password)) {
			addActionError("Invalid Username/Password!");
			return false;
		}
		return true;
	}
	/*
	 * Ham thuc hien validate form register
	 */
	public boolean validateFormRegister() {
		if (username.equals("") && password.equals("") && email.equals("")) {
			addActionError("Username Password and Email are required!");
			return false;
		}
		if (username.equals("")) {
			addActionError("Username is required!");
			return false;
		}
		if (password.equals("")) {
			addActionError("Password is required!");
			return false;
		}
		if (email.equals("")){
			addActionError("Email is required!");
			return false;
		}
		if (!validateUsername(username)) {
			addActionError("Invalid Username!");
			return false;
		}
		if (!validatePassword(password)) {
			addActionError("Invalid Password!");
			return false;
		}
		if (!validateEmail(email)) {
			addActionError("Invalid Email!");
			return false;
		}
		return true;
	}
	
	
	/*
	 * Ham action cua logout, xoa session
	 */
	public String logout() {
		session.remove("logon");
		session.remove("username");	
		return "success";
	}
	
	/*
	 * Validate Email
	 */
	public boolean validateEmail(String hex) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(hex);
		return matcher.matches();
	}
	/*
	 * Validate Username
	 */
	public boolean validateUsername(String hex){
		pattern = Pattern.compile(USERNAME_PATTERN);
		matcher = pattern.matcher(hex);
		return matcher.matches();
	}
	
	/*
	 * Validate Password
	 */
	public boolean validatePassword(String hex) {
		if (hex.length() < MIN_LENGTH_PASSWORD) {
			return false;
		} else {
			return true;
		}
	}
	
	/*
	 * setter va getter
	 */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}

//	public int getUser_id() {
//		return user_id;
//	}
//
//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
