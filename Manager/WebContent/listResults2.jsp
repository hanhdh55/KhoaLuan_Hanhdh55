<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<HEAD>
	<title>Giám sát thông tin liên quan</title>
	<script src="js/list.js" type="text/javascript"></script>
</HEAD>
<BODY>
	<div class="divList">
	<form id="data_form" action="showArticle" method="post">
		<s:iterator value="list">
		<div class="divdocument">
			<h3 class="h3title"><a class="title" href='<s:property value="url"/>'> <s:property value="title"/>	</a></h3>
			<a class="displayUrl" href='<s:property value="url"/>'> <s:property value="displayUrl"/>	</a>
			<p><s:property value="description"/></p>
		</div>
		</s:iterator>
		
		<div class="pageNavi">
					<a class="link" onclick="FirstPageHandler();">|&lt; &nbsp;</a>
					<a class="link" onclick="PreviousPageHandler();">&nbsp;&lt;&nbsp;</a>
					Page <s:property value="pageNumber"/> of <s:property value="totalPage"/> 
					<a class="link" onclick="NextPageHandler();">&nbsp;&gt;&nbsp;</a>
					<a class="link" onclick="LastPageHandler();">&nbsp;&gt;&nbsp;|</a>
		</div>
		
		<input name="pageNumber" id="pageNumber" type="hidden" value="<s:property value="pageNumber"/>" />
		<input name="totalPage" id="totalPage" type="hidden" value="<s:property value="totalPage"/>" />
	</form>
	</div>
</body>
</html>