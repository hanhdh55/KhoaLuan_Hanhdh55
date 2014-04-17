<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="js/menu.js" type="text/javascript"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/master.css" />
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<div id="divbody">
		<table class="layout">
			<tr id="header">
				<td colspan="2">
				<tiles:insertAttribute name="header" />
			</td>
			</tr>
			<tr id="topnav">
				<td colspan="2">
					<tiles:insertAttribute name="nave" />
				</td>
			</tr>
			<tr id="body">
				<td >
					<tiles:insertAttribute name="body" />
				</td>
			</tr>
			<tr id="footer">
				<td colspan="2">
					<tiles:insertAttribute name="footer" />
				</td>
			</tr>
		</table>
	</div>
</body>
</html>