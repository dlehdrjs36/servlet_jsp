<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>

<!--  내가서버에게 던져줄때 문자셋형태는 utf-8이다. -->
<% request.setCharacterEncoding("utf-8");%>

<jsp:useBean id="testBean" class="ch08.bean.TestBean">
     <jsp:setProperty name="testBean" property="id"/>	
     <!--  setProperty : TestBean클래스의 id에 값을 넣어라 ., property="*" .  순서대로 담김.  -->
</jsp:useBean>

입력된 아이디: <jsp:getProperty name="testBean" property="id"/>
<!--  getProperty : TestBean클래스의 id 값을 가져와라 -->