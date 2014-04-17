<!DOCTYPE HTML>

	<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<meta http-equiv="content-type" content="text/html" />
    
	<title>Login Page</title>
</head>

<body>
	<div id="divLogin">
    	<div class="headerLogin">LOGIN</div>
           
        <div class="loginForm">
			<form action="loginAction" method="post">
				<p class="text txtUsername">Username</p>
				<input type="text" class="login" name="username" value="<s:property value='username'/>" />
				<p class="text txtPassword">Password</p>
				<input type="password" class="login" name="password" value="<s:property value='password'/>" />
				<!-- <p class="error" id="loginErr"></p> -->
				 <div id="errors">
	                	<s:actionerror/>
	             </div>
				<p><a id="forgotPwd" href="registerPage" class="link"> Đăng kí </a></p>
				<input type="submit" value="Login" id="btLogin" class="button"/>
				 <div class="break"></div>
			</form>
			
		</div>
	</div>

</body>
</html>