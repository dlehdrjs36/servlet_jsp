<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자기자신의 포인트 정보 확인</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>ID</td>
			<td>현재 가지고 있는 총포인트</td>
			<td>지금까지 적립된 포인트</td>
			<td>지금까지 사용한 포인트</td>
		</tr>
		<c:forEach items="${userpoint}" var="dto">
		<tr>
			<td>${dto.id}</td>
			<td>${dto.total_point}</td>
			<td>${dto.save}</td>
			<td>${dto.use}</td>
		</tr>
		</c:forEach>
		<a href="#">되돌아가기</a>
</body>
</html>