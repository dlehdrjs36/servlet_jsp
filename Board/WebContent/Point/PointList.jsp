<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>포인트 리스트</title>
</head>
<body>

	<c:if test="${totalcount==0}">
		<script>alert('존재하지 않는 ID 입니다.');</script>
	</c:if>
	
	<c:if test="${error==1}">
		<script>alert('포인트 사용불가. 잔액이 부족해집니다.');</script>
	</c:if>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>ID</td>
			<td>가지고있는 총포인트</td>
			<td>적립된 포인트</td>
			<td>사용한 포인트</td>
		</tr>
		<c:forEach items="${PointList}" var="dto">
		<tr>
			<td>${dto.id}</td>
			<td>${dto.total_point}</td>
			<td>${dto.save}</td>
			<td>${dto.use}</td>
		</tr>
		</c:forEach>
		</table>
		

 		<jsp:include page="/Point/PointPaging.jsp">
 		<jsp:param value="3" name="check"/>
        <jsp:param value="${paging.page}" name="page"/>
        <jsp:param value="${paging.beginPage}" name="begin"/>
        <jsp:param value="${paging.endPage}" name="end"/>
        <jsp:param value="${paging.prev}" name="prev"/>
        <jsp:param value="${paging.next}" name="next"/>              
        <jsp:param value="${paging.prev_pageno}" name="prev_pageno"/>
        <jsp:param value="${paging.next_pageno}" name="next_pageno"/>
        <jsp:param value="${paging.totalPage}" name="totalPage"/>
		</jsp:include>

		  
</body>
</html>