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
	
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>ID</td>
			<td>포인트</td>
			<td>구분(1:적립, 2사용)</td>
			<td>날짜</td>
		</tr>
		<c:forEach items="${PointHistory}" var="dto">
		<tr>
			<td>${dto.id}</td>
			<td>${dto.point}</td>
			<td>${dto.flag}</td>
			<td>${dto.p_date}</td>
		</tr>
		</c:forEach>
 
	</table>
	 <a href="PointList.do"> 목록 보기</a> <a href="PointHistoryDown.do"> 포인트이력 다운</a>
	 
	 <form action="PointSearchHistory.do" method="post">
	 	<select name="subjects"> 
	 		<option value="1" selected>id</option>
	 		<option value="2" >flag</option>	
	 	</select>
	 <input type="text" name="search" size ="20">
	 <input type="reset" value="다시작성">
	 <input type="submit" value="검색">
	 </form>
	
 

</body>
</html>