<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String path = application.getRealPath("updownFile");
	File dir = new File(path);
	
	String fName[] = dir.list();
	
	for(String fileName : fName )
	{
		out.write("<a href=\"" + request.getContextPath() + 
			"/FileDownLoad?filename=" + java.net.URLEncoder.encode(fileName, "UTF-8")
			+ "\">" + fileName + "</a><br>");
	}
%>

	</body>
</html>