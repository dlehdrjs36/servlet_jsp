<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!
		String id, pw;
	%>
	<%
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		if(id.equals("abcde") && pw.equals("12345")) {
			//세션은 쿠키와달리 자동으로생성됨. 세션을 쓸지말지는 프로그래머가 결정함.
			//원래세션객체가 id 속성을 가지고 있는것은 아님.
			session.setAttribute("id", id); // 세션속성으로 "id"를 만들어서 거기에 id값을 넣겟다.	
			session.setAttribute("password", pw);
			response.sendRedirect("welcome.jsp");
		} else {
			response.sendRedirect("login.html");
		}
	%>

</body>
</html>