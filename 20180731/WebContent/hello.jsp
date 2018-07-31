<!--  JSP코드가 포함되면 서블릿이 해석함.
      JSP의 파일형태 <%         %> <!doctype html><html> ~ </html>  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Hello JSP</title>
</head>
<body>
<center>
     <p> 처음으로 하는 JSP </p>
      <hr>
      현재 날짜와 시간은 : <%=new java.util.Date() %>
</center> 
</body>
</html>