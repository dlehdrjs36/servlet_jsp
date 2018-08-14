
<%@page import="DTO.BoardBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	BoardBean boardBean= (BoardBean) request.getAttribute("BoardBean");
%>
<!DOCTYPE html>
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function CheckConfirm() {
		var check= confirm("정말 삭제하시겠습니까?");
		if (check) // HOME 버튼 클릭시 첫화면으로 이동
		{
			location.href = "BoardDelete.bo?writenum=<%=boardBean.getWriteNum()%>";
		} 
		
	}
</script>
<body>
	<table border="1">
		<tr>
			<td>게시글번호</td>
			<td><%=boardBean.getWriteNum()%></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%=boardBean.getAuthor()%></td>
		</tr>
		<tr>
			<td>작성일자</td>
			<td><%=boardBean.getRegDate()%></td>
		</tr>
		<tr>
			<td>조회수</td>
			<td><%=boardBean.getReadCount()%></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><%=boardBean.getSubject()%></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><%=boardBean.getContent()%></td>
		</tr>
		<tr>
			<td colspan="2">
			<%
				String id = request.getSession().getAttribute("sessionID").toString();
				System.out.println("aaaa : " + id);
				System.out.println("aaaa : " + boardBean.getAuthor().toString());
				if( boardBean.getAuthor().toString().equals(id)){
			%>
				<input type="button" value="수정" onclick="location.href='BoardUpdateForm.bo'"> 
				<input type="button" value="삭제" onclick="CheckConfirm()"> 
			<%
				}
			%>
				<input type="button" value="답글달기" >
				<input type="button" value="목록으로가기" onclick="location.href='BoardList.bo'">
			</td>
		</tr>
	</table>
</body>
</html>