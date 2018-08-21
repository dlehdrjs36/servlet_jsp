<%@page import="DAO.BoardDAO"%>
<%@page import="DTO.BoardBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<link rel="stylesheet" href="/Board/css/Board.css">
<link rel="stylesheet" href="/Board/BootStrap/css/bootstrap.css">

<script type="text/javascript" src="/Board/js/BoardCount.js"></script>
</head>
<body>
	<table border="1">
		<tr>
			<td class="td1">게시글번호</td>
			<td class="td1">제목</td>
			<td class="td1">작성자</td>
			<td class="td1">작성일자</td>
			<td class="td1">조회수</td>
		</tr>
		<%
        for(int i = 0 ; i < boardList.size() ; i++){
            BoardBean bean = (BoardBean) boardList.get(i);
		 %>
		<tr>
			<td class="td2"><%=bean.getWriteNum()%></td>
					
			<td class="td2" align="left">
			 <%	if(bean.getReLevel() > 0) { 
            		for(int j = 1; j<=bean.getReLevel(); j++){
            	%>
            		&nbsp;&nbsp;
           		 <% }%>
            		RE :
             <% }%>
            	
			<a href="./BoardDetail.bo?writenum=<%=bean.getWriteNum() %>"> <%=bean.getSubject() %></a>
			</td>
			
			<td class="td2"><%=bean.getAuthor() %></td>
			<td class="td2"><%=bean.getRegDate() %></td>
			<td class="td2"><%=bean.getReadCount() %></td>
		</tr>
		<%
		} 
		%>
	    
	    <tr align=center height=20>
	   
    	    <td class="td-button" colspan=5 style=font-family:Tahoma;font-size:10pt;>
    	    <div class="text-center">
    	    	<ui class="pagination">
        	    <%
            	if(nowpage<=1){ 
            	%>
            		
            	<%
            	}else{ 
            	%>
            		<li><a href="./BoardList.bo?page=<%=nowpage-1 %>">[이전]</a>&nbsp;</li>
            	<%
            	} 
           		%>

            	<%
            	for(int a=startpage;a<=endpage;a++){
                	//if(a==nowpage){
            	%>
            	    	<%-- <li>[<%=a %>]</li> --%>
                <%
                	//}else{ 
                %>
                		<li><a href="./BoardList.bo?page=<%=a %>">[<%=a %>]</a>&nbsp;</li>
                <%
                	//} 
                %>
            	<%
            	} 
            	%>

            	<%
            	if(nowpage>=maxpage){ 
            	%>
            		<li>[다음]</li>
            	<%
             	}else{ 
             	%>
            		<li><a href="./BoardList.bo?page=<%=nowpage+1 %>">[다음]</a></li>
            	<%
            	} 
            	%>
            	</ui>
            	</div>
        	</td>  	
    	</tr>
    	
    	<tr>
			<td class="td-button" colspan="5">
				<div>
				<form action="./BoardSearch.bo" method="get">
					<select name="subjects">
						<option>작성자</option>
						<option>제목</option>
					</select> <input type="text" name="search"> <input type="submit" value="검색">
										<%
					if (session.getAttribute("sessionID").equals("admin2")){
					%>
					<input type="button" value="글작성"
						onclick="location.href='BoardWriteForm.bo'">
					<%
					}
					%>
					
				</form>

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