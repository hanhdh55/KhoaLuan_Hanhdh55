<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:if test="#session.username != null">
	<META HTTP-EQUIV="Refresh" CONTENT="0;URL=loginAction">
</s:if>
<s:else>
	<html>
		<head>
			<script src="js/menu.js" type="text/javascript"></script>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<meta name="author" content="fullahead.org" />
		  	<meta name="keywords" content="XHTML, CSS, template, FullAhead" />
		 	<meta name="description" content="A valid, XHTML 1.0 template" />
		  	<meta name="robots" content="index, follow, noarchive" />
		 	<meta name="googlebot" content="noarchive" />
		  
		<!-- 	<link rel="stylesheet" type="text/css" href="css/master.css" /> -->
			<link rel="stylesheet" type="text/css" href="css/body.css" />
			<link rel="stylesheet" type="text/css" href="css/html.css" media="screen, projection, tv " />
		  	<link rel="stylesheet" type="text/css" href="css/layout.css" media="screen, projection, tv" />
		  	<link rel="stylesheet" type="text/css" href="css/print.css" media="print" />
			<title><tiles:insertAttribute name="title" ignore="true" /></title>
		</head>
		<body>
			<div id="wrapperLogin">
				<div id="contentLogin">
					<div id="hearderLogin">		
						<tiles:insertAttribute name="header" />
					</div>
					<div id="page">
						<tiles:insertAttribute name="body" />
					</div>
					
<!-- 					<div id="footer" class="footer"> -->
<%-- 						<tiles:insertAttribute name="footer" /> --%>
<!-- 					</div> -->
				</div>
			</div>
		</body>
	</html>
</s:else>

