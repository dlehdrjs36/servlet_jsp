<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String id, pw;
	%>
	<% 
		request.setCharacterEncoding("UTF-8");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		if(id.equals("이동건") && pw.equals("12345")) {
			// Cokie 클래스를 이용해서 cookie를 만듬.
	//data영역(클래스): Cookie   heap영역(객체): cookie	= new Cookie("id",id);
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(60); // 1분. 60초
			response.addCookie(cookie); // 서버가 클라이언트로 준다. 쿠키를 response객체에 담아서.
			response.sendRedirect("welcome.jsp");
		} else {
			//실패하면 페이지에 머무름. login.html 
			response.sendRedirect("login.html");
		}
	%>
	</body>
</html>
