<%@page import="DAO.BoardDAO"%>
<%@page import="DTO.BoardBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List boardList = (List) request.getAttribute("boardlist");
	int listcount = ((Integer) request.getAttribute("listcount")).intValue();
	int nowpage = ((Integer) request.getAttribute("page")).intValue();
	int maxpage = ((Integer) request.getAttribute("maxpage")).intValue();
	int startpage = ((Integer) request.getAttribute("startpage")).intValue();
	int endpage = ((Integer) request.getAttribute("endpage")).intValue();
%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>게시글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일자</td>
			<td>조회수</td>
		</tr>
		<%
        for(int i = 0 ; i < boardList.size() ; i++){
            BoardBean bean = (BoardBean) boardList.get(i);
		 %>
		<tr>
			<td><%=bean.getWriteNum()%></td>
			<td><a href="BoardDetail.bo?writenum=<%=bean.getWriteNum()%>"><%=bean.getSubject() %></a></td>
			<td><%=bean.getAuthor() %></td>
			<td><%=bean.getRegDate() %></td>
			<td><%=bean.getReadCount() %></td>
		</tr>
		<%
		} 
		%>
	    <tr align=center height=20>
    	    <td colspan=5 style=font-family:Tahoma;font-size:10pt;>
        	    <%
            	if(nowpage<=1){ 
            	%>
            		[이전]&nbsp;
            	<%
            	}else{ 
            	%>
            		<a href="./BoardList.bo?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
            	<%
            	} 
           		%>

            	<%
            	for(int a=startpage;a<=endpage;a++){
                	if(a==nowpage){
            	%>
            	    	[<%=a %>]
                <%
                	}else{ 
                %>
                		<a href="./BoardList.bo?page=<%=a %>">[<%=a %>]</a>&nbsp;
                <%
                	} 
                %>
            	<%
            	} 
            	%>

            	<%
            	if(nowpage>=maxpage){ 
            	%>
            		[다음]
            	<%
             	}else{ 
             	%>
            		<a href="./BoardList.bo?page=<%=nowpage+1 %>">[다음]</a>
            	<%
            	} 
            	%>
        	</td>
    	</tr>
    	<tr>
			<td colspan="5">
				<div>
					<select>
						<option value="author">작성자</option>
						<option value="title">제목</option>
					</select> <input type="text"> <input type="button" value="검색">
					<%
					if (session.getAttribute("sessionID").equals("admin2")){
					%>
					<input type="button" value="글작성"
						onclick="location.href='BoardWriteForm.bo'">
					<%
					}
					%>
				</div>

			</td>
		</tr>
	</table>
	<% 
            String msg=request.getParameter("msg");            
            if(msg!=null && msg.equals("1")) 
            {
	%>
     			<script>alert("정상 삭제 되었습니다..")</script>
    <%
    		}
    %>       	
</body>
</html>