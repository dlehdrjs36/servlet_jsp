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
			//������ ��Ű�ʹ޸� �ڵ����λ�����. ������ ���������� ���α׷��Ӱ� ������.
			//�������ǰ�ü�� id �Ӽ��� ������ �ִ°��� �ƴ�.
			session.setAttribute("id", id); // ���ǼӼ����� "id"�� ���� �ű⿡ id���� �ְٴ�.	
			session.setAttribute("password", pw);
			response.sendRedirect("welcome.jsp");
		} else {
			response.sendRedirect("login.html");
		}
	%>

</body>
</html>