<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- jsp의 스크립트 기반태그에서는 속성에 값을 지정할 때 정적인 데이터만 줄 수 있다. 그러나 xml 기반의 jsp태그는 속성에 값을 지정할때 
 결과표현식과 ${}을 사용하여 동적으로 줄 수 있다. 이때문에 소스코드의 양을 현저하게 줄일 수 있다. -->
<jsp:forward page="${param.p}" />
 
 
</body>
</html>