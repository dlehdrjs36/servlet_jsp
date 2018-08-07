<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String str = request.getParameter("msg");
%>

<c:catch var="e"> <!-- exception 처리변수가 e이다.  -->
	<%
		if (str.equals("add")) { // add로 넘어오지않아서 exception 발생.
				out.print(str);
			}
	%>

</c:catch>
<c:out value="${e}" />  <!-- exception의 종류를 출력하라.  -->