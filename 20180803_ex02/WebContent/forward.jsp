<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!--  jsp페이지에서 jsp페이지를 호출할때 값을 넘겨 줄 수있는 방법. post방식으로 넘겨줌 -->
	<jsp:forward page="forward_param.jsp"> 
		<jsp:param name="id" value="abcdef" />
		<jsp:param name="pw" value="1234" />
	</jsp:forward>

</body>
</html>