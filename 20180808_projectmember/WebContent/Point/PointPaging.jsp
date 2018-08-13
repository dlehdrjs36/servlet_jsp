<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="/20180808_projectmember/js/PointPaging.js"></script>	
<body>

 <!-- 1~5까지 있는 페이지의 페이징, PointHistory 페이징처리. -->
<c:if test="${param.check==1}">
	<c:url var="action" value="/Point/PointHistory.do"/>
	<a href="#" onclick="paging(1);">[맨앞으로]</a>
	<c:if test="${param.prev}">
		<a href="#" onclick="paging(${param.prev_pageno});">[이전]</a>
	</c:if>
	<c:forEach begin="${param.begin}" end="${param.end}" step="1" var="index">
    	<c:choose>
        	<c:when test="${param.page==index}">
            	${index}
        	</c:when>
        	<c:otherwise>
            	<a href="#" onclick="paging(${index});">
            	${index}
            	</a>
        	</c:otherwise>
    	</c:choose>
	</c:forEach>
	<c:if test="${param.next}">
		<a href="#" onclick="paging(${param.next_pageno});">[다음]</a>
	</c:if>
	<a href="#" onclick="paging(${param.totalPage});">[맨뒤로]</a>
	
</c:if>




 <!-- 1~5까지 있는 페이지의 페이징, PointHistory에서 조건을주어 검색했을때 페이징-->
<c:if test="${param.check==2}">
	<c:url var="action" value="/Point/PointSearchHistory.do"/>
	<a href="#" onclick="paging(1,'${param.subjects}','${param.search}'); return false;" >[맨앞으로]</a>
	<c:if test="${param.prev}">
		<a href="#" onclick="paging(${param.prev_pageno},'${param.subjects}','${param.search}'); return false;">[이전]</a>
	</c:if>
	<c:forEach begin="${param.begin}" end="${param.end}" step="1" var="index">
    	<c:choose>
        	<c:when test="${param.page==index}">
            	${index}
        	</c:when>
       		<c:otherwise>
            	<a href="#" onclick="paging(${index},'${param.subjects}','${param.search}'); return false;">${index}</a>
        	</c:otherwise>
    	</c:choose>
	</c:forEach>
	<c:if test="${param.next}">
		<a href="#" onclick="paging(${param.next_pageno},'${param.subjects}','${param.search}'); return false;">[다음]</a>
	</c:if>
	<a href="#" onclick="paging(${param.totalPage},'${param.subjects}','${param.search}'); return false;">[맨뒤로]</a>
</c:if>




<!-- 1~5까지 있는 페이지의 페이징, PointList 페이징처리 -->
<c:if test="${param.check==3}">
	<c:url var="action" value="/Point/PointList.do"/>
	<a href="#" onclick="paging(1);">[맨앞으로]</a>
	<c:if test="${param.prev}">
		<a href="#" onclick="paging(${param.prev_pageno});">[이전]</a>
	</c:if>
	<c:forEach begin="${param.begin}" end="${param.end}" step="1" var="index">
    	<c:choose>
        	<c:when test="${param.page==index}">
            	${index}
        	</c:when>
        	<c:otherwise>
            	<a href="#" onclick="paging(${index});">${index}</a>
        	</c:otherwise>
    	</c:choose>
	</c:forEach>
	<c:if test="${param.next}">
		<a href="#" onclick="paging(${param.next_pageno});">[다음]</a>
	</c:if>
	<a href="#" onclick="paging(${param.totalPage});">[맨뒤로]</a>
</c:if>

<form name="pagingform" action="${action}" method="post">
	<input type="hidden" name="page" value="" />
	<input type="hidden" name="subjects" value="" />
	<input type="hidden" name="search" value="" />
</form>


</body>
</html>