<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String contentPage=request.getParameter("contentPage");
if(contentPage==null)
    contentPage="FirstView.jsp";
%>


<!DOCTYPE html>
<html>
<head>
<title> Welcom </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="utf-8">
</head>
<body>
	<jsp:include page="Header.jsp" />
	<div id="main">
		<jsp:include page="<%=contentPage%>" />
	</div>
  
</body>
</html>