<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  검색 조건 페이징 부분 미완성(렉) check == 2 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {

	background-color: lightblue;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>포인트 사용이력</title>
<script type="text/javascript" src="/Board/js/PointCheck.js"></script>
<link rel="stylesheet" href="/Board/css/Point.css">
<link rel="stylesheet" href="/Board/BootStrap/css/bootstrap.css">
</head>
<body>
	<c:if test="${totalcount==0}">
	<script> alert('해당하는 ID의 검색값이 없습니다.'); history.back();</script>
	</c:if>
	
	<table width="1200" border="1">
		<tr>
			<td class="td1" >ID</td>
			<td class="td1">포인트</td>
			<td class="td1">구분(1:적립, 2사용)</td>
			<td class="td1">구분(Type)</td>
			<td class="td1">날짜</td>
		</tr>
			<c:forEach items="${PointHistory}" var="dto">
		<tr>
			<td class="td2">${dto.id}</td>
			<td class="td2">${dto.point}</td>
			<td class="td2">${dto.flag}</td>
			<td class="td2">${dto.type}</td>
			<td class="td2">${dto.p_date}</td>
		</tr>
		</c:forEach>
		
	</table>
	
	<c:if test="${check==1}">	
		<jsp:include page="/Point/PointPaging.jsp">
		<jsp:param value="1" name="check"/>
        <jsp:param value="${paging.page}" name="page"/>
        <jsp:param value="${paging.beginPage}" name="begin"/>
        <jsp:param value="${paging.endPage}" name="end"/>
        <jsp:param value="${paging.prev}" name="prev"/>
        <jsp:param value="${paging.next}" name="next"/>       
        <jsp:param value="${paging.prev_pageno}" name="prev_pageno"/>
        <jsp:param value="${paging.next_pageno}" name="next_pageno"/>
        <jsp:param value="${paging.totalPage}" name="totalPage"/>
		</jsp:include>			
	</c:if>

	<c:if test="${check==2}">		
		<jsp:include page="/Point/PointPaging.jsp">
		<jsp:param value="2" name="check"/>
		<jsp:param value="${paging.subjects}" name="subjects"/>
		<jsp:param value="${paging.search}" name="search"/>		
        <jsp:param value="${paging.page}" name="page"/>
        <jsp:param value="${paging.beginPage}" name="begin"/>
        <jsp:param value="${paging.endPage}" name="end"/>
        <jsp:param value="${paging.prev}" name="prev"/>
        <jsp:param value="${paging.next}" name="next"/>          
        <jsp:param value="${paging.prev_pageno}" name="prev_pageno"/>
        <jsp:param value="${paging.next_pageno}" name="next_pageno"/>
        <jsp:param value="${paging.totalPage}" name="totalPage"/>
		</jsp:include>			
	 </c:if>
	 
 <form action="PointSearchHistory.po" method="post" onsubmit="return checkContent()" name="searchoption"> 
	<table> 
		<tr>
	 		<td> 
	 			<div class="div-button"> 
	 				<select name="subjects" id="subjects"> 
	 					<option value="id" selected>id</option>
	 					<option value="flag" >flag</option> 				
	 				</select>
					<input id="content" type="text" name="search" size ="20">	 	
	 				<input class="btn btn-primary btn-xl" type="reset" value="다시작성"> 
	 				<input class="btn btn-primary btn-xl" type="submit" value="검색" >
	 				<button class="btn btn-primary btn-xl" type="button" onclick="location.href='PointHistoryDown.po'">전체 포인트 사용이력 다운로드</button>
	 		 	</div>
	 		</td>
		</tr>
	</table>
</form>
	
	
</body>
</html>