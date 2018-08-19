<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="/Board/js/PointPaging.js"></script>	
<link rel="stylesheet" href="/Board/css/Point.css">
<link rel="stylesheet" href="/Board/BootStrap/css/bootstrap.css">
<body>


 <!-- 1~5까지 있는 페이지의 페이징, PointHistory 페이징처리. -->
<c:if test="${param.check==1}">
	<c:url var="action" value="/PointHistory.po"/>
	<div class="text-center">
		<ul class="pagination">	
			<li><a href="#" onclick="paging(1);">처음</a></li>
			<c:if test="${param.prev}">
				<li><a href="#" onclick="paging(${param.prev_pageno});">이전으로</a></li>
			</c:if>
			<c:forEach begin="${param.begin}" end="${param.end}" step="1" var="index">
	    		<c:choose>
        			<c:when test="${param.page==index}">
       					<li><a>${index}</a></li>
       				</c:when>
       				<c:otherwise>
           				<li><a href="#" onclick="paging(${index});">${index}</a></li>
       				</c:otherwise>
    			</c:choose>
			</c:forEach>
			<c:if test="${param.next}">
				<li><a href="#" onclick="paging(${param.next_pageno});">다음으로</a></li>
			</c:if>
			<li><a href="#" onclick="paging(${param.totalPage});">마지막</a></li>
		</ul>
	</div>
</c:if>

 <!-- 1~5까지 있는 페이지의 페이징, PointHistory에서 조건을주어 검색했을때 페이징-->
<c:if test="${param.check==2}">
	<c:url var="action" value="/PointSearchHistory.po"/>
	<div class="text-center">
		<ul class="pagination">	
			<li> <a href="#" onclick="paging(1,'${param.subjects}','${param.search}'); return false;" >처음</a></li>
			<c:if test="${param.prev}">
				<li><a href="#" onclick="paging(${param.prev_pageno},'${param.subjects}','${param.search}'); return false;">이전으로</a></li>
			</c:if>
			<c:forEach begin="${param.begin}" end="${param.end}" step="1" var="index">
    			<c:choose>
        			<c:when test="${param.page==index}">
        				<li><a>${index}</a></li>
        			</c:when>
       				<c:otherwise>
            			<li><a href="#" onclick="paging(${index},'${param.subjects}','${param.search}'); return false;">${index}</a></li>
        			</c:otherwise>
    			</c:choose>
			</c:forEach>
			<c:if test="${param.next}">
				<li><a href="#" onclick="paging(${param.next_pageno},'${param.subjects}','${param.search}'); return false;">다음으로</a></li>
			</c:if>
			<li><a href="#" onclick="paging(${param.totalPage},'${param.subjects}','${param.search}'); return false;">마지막</a></li>
		</ul>
	</div>
</c:if>

<!-- 1~5까지 있는 페이지의 페이징, PointList 페이징처리 -->
<c:if test="${param.check==3}">
	<c:url var="action" value="/PointList.po"/>
	<div class="text-center">
		<ul class="pagination">	
			<li><a href="#" onclick="paging(1);">처음</a></li>
			<c:if test="${param.prev}">
				<li><a href="#" onclick="paging(${param.prev_pageno});">이전으로</a></li>
			</c:if>
			<c:forEach begin="${param.begin}" end="${param.end}" step="1" var="index">
    			<c:choose>
        			<c:when test="${param.page==index}">
        				<li><a>${index}</a></li>
        			</c:when>
        			<c:otherwise>
            			<li><a href="#" onclick="paging(${index});">${index}</a></li>
        			</c:otherwise>
    			</c:choose>
			</c:forEach>
			<c:if test="${param.next}">
				<li><a href="#" onclick="paging(${param.next_pageno});">다음으로</a></li>
			</c:if>
			<li><a href="#" onclick="paging(${param.totalPage});">마지막</a></li>
		</ul>
	</div>
</c:if>

<form name="pagingform" action="${action}" method="post">
	<input type="hidden" name="page" value="" />
	<input type="hidden" name="subjects" value="" />
	<input type="hidden" name="search" value="" />
</form>

</body>
</html>