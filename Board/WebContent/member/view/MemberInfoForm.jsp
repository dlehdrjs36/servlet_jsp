<%@ page import="DTO.MemberBean"%>
<%@ page import="DAO.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 보기</title>
<link rel="stylesheet" href="/Board/css/MemberInfoForm.css">
<link rel="stylesheet" href="/Board/BootStrap/css/bootstrap.css">
</head>
<body>
	<%
		MemberBean memberBean =(MemberBean)request.getAttribute("memberBean");
	%>	
	<table border="1">
		<tr>
			<td class="td1">ID</td>
			<td class="td2">${memberBean.getId()}</td>
		</tr>
		<tr>
			<td class="td1">포인트</td>
			<td class="td2"><%=memberBean.getPoint()%></td>
		</tr>
		<tr>
			<td class="td1">이메일</td>
			<td class="td2"><%=memberBean.getEmail()%></td>
		</tr>
		<tr>
			<td class="td1">이름</td>
			<td class="td2"><%=memberBean.getName()%></td>
		</tr>
		<tr>
			<td class="td1">생년월일</td>
			<td class="td2"><%=memberBean.getBirthday()%></td>
		</tr>
		<tr>
			<td class="td1">성별</td>
			<td class="td2"><%=memberBean.getGender()%></td>
		</tr>
		<tr>
			<td class="td1">주소</td>
			<td class="td2"><%=memberBean.getAddrnum()%>, <br><%=memberBean.getAddr()%><br>
				<%=memberBean.getAddrdetail()%></td>
		</tr>
		<tr>
			<td class="td1">전화번호</td>
			<td class="td2"><%=memberBean.getPhonenum()%></td>
		</tr>
		<tr class="tr-button">
			<td colspan="2" class="td-button">
				<div class="div-button">
					<input type="button" class="btn btn-primary btn-xl" value="회원정보변경" onclick="location.href='MemberChangeInfoForm.do'">&nbsp;&nbsp;&nbsp;
					<input type="button" class="btn btn-primary btn-xl" value="사이트 탈퇴" onclick="location.href='MemberCheckPassWordForm.do'">
				</div>
			</td>
		</tr>
	</table>
		<% 
            String msg=request.getParameter("msg");            
            if(msg!=null && msg.equals("1")) 
            {
	%>
     			<script>alert("정상적으로 수정되었습니다.")</script>
    <%
    		}
    %>  
</body>
</html>