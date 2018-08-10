<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>테스트</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>ID</td>
			<td>포인트</td>
			<td>구분(1:적립, 2사용)</td>
			<td>날짜</td>
		</tr>
		<c:forEach items="${memList}" var="dto">
		<tr>
			<td>${dto.id}</td>
			<td>${dto.point}</td>
			<td>${dto.flag}</td>
			<td>${dto.p_date}</td>
		</tr>
		</c:forEach>
		</table>
		<div>
		<jsp:include page="/Point/test.jsp">
        <jsp:param value="${paging.page}" name="page"/>
        <jsp:param value="${paging.beginPage}" name="begin"/>
        <jsp:param value="${paging.endPage}" name="end"/>
        <jsp:param value="${paging.prev}" name="prev"/>
        <jsp:param value="${paging.next}" name="next"/>
		</jsp:include>
		</div>
</body>
</html>