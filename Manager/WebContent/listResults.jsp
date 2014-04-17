<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<HEAD>
</HEAD>
<BODY>
	<div class="divList">
		<s:iterator value="list">
		<div class="divdocument">
			<h3 class="h3title"><a class="title" href='<s:property value="link"/>'> <s:property value="title"/>	</a></h3>
			<br/>
			<a class="displayLink" href='<s:property value="link"/>'> <s:property value="displayLink"/>	</a>
			<p><s:property value="snippet"/></p>
		</div>
		</s:iterator>
	
	</div>
</body>
</html>