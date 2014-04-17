<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
	<div>
		<div>
			<h2> Từ Khóa</h2>
			<hr/>
		</div>
		<div>
		     <ul>
		     <s:iterator value="listKeywords">
		     	<li><a href='showArticle?key_id=<s:property value="key_id"/>'><s:property value = "keyname"/></a></li>
		     </s:iterator>
		     </ul>
     	</div>	
    </div>
</body>
</html>
