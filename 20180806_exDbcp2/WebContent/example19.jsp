<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL</title>
</head>
<body>
<!-- http://localhost:8181/20180806_exDbcp2/example19.jsp?id=guest&pwd=12345 --> 
 ${ param.id } / ${ param.pwd }		<br> 
 ${ param["id"] } / ${ param["pwd"] }
  
  
</body>
</html>