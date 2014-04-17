<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML>

	<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<meta http-equiv="content-type" content="text/html" />
    
	<title>Register Page</title>
</head>

<body>
	<div id="divLogin">
    	<div class="headerLogin">Điền thông tin</div>
           
        <div class="loginForm">
			<form action="register" method="post">
				<p class="text txtUsername">Username</p>
				<input type="text" class="login" name="username" value="<s:property value='username'/>" />
				<p class="text txtPassword">Password</p>
				<input type="password" class="login" name="password" value="<s:property value='password'/>" />
				<p class="text txtUsername">Email</p>
				<input type="email" class="login" name="email" value="<s:property value='email'/>" />
				<p class="text txtUsername">Keyword</p>
				<input type="text" class="login" name="keyword"/>
				 <div id="errors">
	                	<s:actionerror/>
	             </div>
				
				<input type="submit" value="Submit" id="btLogin" class="button"/>
				 <div class="break"></div>
			</form>
			
		</div>
	</div>

</body>
</html>