<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<HEAD>
</HEAD>
<BODY>
	<div id="wrapper">
<%-- 		<h3 class="h3title"><a class="title" href='<s:property value="%{document.link}"/>'> <s:property value="%{document.title}"/>	</a></h3> --%>
<!-- 		<br/> -->
<%-- 		<a class="displayLink" href='<s:property value="%{document.link}"/>'> <s:property value="%{document.displayLink}"/>	</a> --%>
<%-- 		<p><s:property value="%{document.snippet}"/></p> --%>

		<a href="retrieveAContent?sourceCode='<s:property value="%{document.sourceCode}"/>'"><s:property value="%{document.link}"/></a>
		
	</div>
</body>
</html>