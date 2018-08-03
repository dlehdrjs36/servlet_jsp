<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<% //jsp에서 request 객체를 선언하지않아도 자동으로 request객체에 데이터를 담아서 넘겨준다. (다른페이지로) 
		out.println("서버 : " + request.getServerName() + "<br />");
		out.println("포트 번호 : " + request.getServerPort() + "<br />");
		out.println("요청 방식 : " + request.getMethod() + "<br />");
		out.println("프로토콜 : " + request.getProtocol() + "<br />");
		out.println("URL : " + request.getRequestURL() + "<br />");
		// 도메인네임을 기준으로 위치 출력.
		out.println("URI : " + request.getRequestURI() + "<br />");
		//톰캣 서버를 기준으로 위치 출력.
	%>

</body>
</html>