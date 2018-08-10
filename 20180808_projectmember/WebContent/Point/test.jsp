<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

 <!-- 1~10까지 있는 페이지의 페이징 -->
<c:url var="action" value="/Point/memList.do"/>
<c:if test="${param.prev}">
<!-- 여기부분을 수정해서블록그룹 이전까지 할수잇게하기. -->
<a href="${action}?page=1">prev</a>
<!-- 		여기부분	-->
</c:if>
<c:forEach begin="${param.begin}" end="${param.end}" step="1" var="index">
    <c:choose>
        <c:when test="${param.page==index}">
            ${index}
        </c:when>
        <c:otherwise>
            <a href="${action}?page=${index}">${index}</a>
        </c:otherwise>
    </c:choose>
</c:forEach>
<c:if test="${param.next}">
<!-- 여기부분을 수정해서 토탈페이지 까지 할수잇게하기. -->
<a href="${action}?page=6">next</a>
<!-- 						 -->
</c:if>



</body>
</html>