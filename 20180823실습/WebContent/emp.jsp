<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DTO.DTO"%>
<%@ page import="DAO.DAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

DAO dao = new DAO(); 
ArrayList<DTO> dtos = dao.SelectMemberCheck();

for (DTO dto : dtos){
%>
 <table border="1" width="400">
 <tr>
 <td width="200">
  <%= dto.getFirstName() %>
 </td>
 <td width="200">
  <%= dto.getLastName() %>
 </td>
 </tr>
</table>
<%
}

%>


</body>
</html>