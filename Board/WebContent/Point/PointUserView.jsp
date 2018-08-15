<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자기자신의 포인트 정보 확인</title>
<link rel="stylesheet" href="/Board/css/Point.css">
<link rel="stylesheet" href="/Board/BootStrap/css/bootstrap.css">
</head>
<body>
	<table border="1">
		<tr>
			<td class="td1">ID</td>
			<td class="td1">현재 가지고 있는 총포인트</td>
			<td class="td1">지금까지 적립된 포인트</td>
			<td class="td1">지금까지 사용한 포인트</td>
		</tr>
		<c:forEach items="${userpoint}" var="dto">
		<tr>
			<td class="td2">${dto.id}</td>
			<td class="td2">${dto.total_point}</td>
			<td class="td2">${dto.save}</td>
			<td class="td2">${dto.use}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>