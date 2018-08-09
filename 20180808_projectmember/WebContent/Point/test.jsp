<%@page import="point.dto.PointHistoryDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="point.dao.PointDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

 PointDao dao = new PointDao();
 ArrayList<PointHistoryDto> list = new ArrayList<PointHistoryDto>();
 ArrayList<PointHistoryDto> reqlist = (ArrayList<PointHistoryDto>)request.getAttribute("list");
 int pagenum = 1;  // 페이지 번호
 if(request.getParameter("memberPage") != null){
  pagenum = Integer.parseInt(request.getParameter("memberPage"));
 }
 int size = 15;
 int tot;
 int cnt = dao.PointTotalCount();
 tot = cnt/size;
 if(cnt%size != 0){
  tot++;
 }
 int start = (pagenum - 1) * size;
 int end = pagenum * size - 1;
 if(reqlist==null){
  list = dao.PointGetList(start, end);
 }else{
  list = reqlist;
 }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>