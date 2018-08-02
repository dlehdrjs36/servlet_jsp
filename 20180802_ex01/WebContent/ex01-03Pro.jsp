<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

<% request.setCharacterEncoding("utf-8"); %>

<h2> for문 예제 - 임의의 값을 임의의 횟수로 곱하기</h2>
<%
	int number = Integer.parseInt(request.getParameter("number"));
	int num = Integer.parseInt(request.getParameter("num"));
	long multiply = 1;
	
	for ( int count = 1 ; count <= num ; count++) {
		multiply *= count; 		// 팩토리얼 구하는 공식  number값은 어떤값이들어와도 무시함. num의 숫자가 팩토리얼임. ex) num = 6 이 전달되면 6! 계산값이 결과로나옴.
	}
%>
결과: <%= multiply %>

