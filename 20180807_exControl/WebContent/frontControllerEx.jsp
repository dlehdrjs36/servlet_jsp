<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!--  FrontController ���. -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
		
	<a href="insert.do">insert</a>  <!--  insert��ư�������� insert.do�� ȣ�� -->
	<hr />
	<a href="http://localhost:8181<%=request.getContextPath()%>/update.do">update</a>
	<hr />
	<a href="http://localhost:8181/20180807_exControl/select.do">select</a>
	<hr />
	<a href="<%=request.getContextPath()%>/delete.do">delete</a>

</body>
</html>