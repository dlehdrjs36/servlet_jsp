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
	 <a href="PointUpdateSaveView.do"> 포인트 적립</a>
	 <a href="PointUpdateUseView.do"> 포인트 사용</a> 
	 <a href="PointHistory.do"> 포인트 이력보기</a>
	 <a href="Page.do"> 페이징테스트용</a>
	 <a href="PointUser.do"> 유저포인트확인테스트용</a>    
</body>
</html>