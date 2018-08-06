<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javalec.daotoex.MemberDAO" %>
<%@ page import="com.javalec.daotoex.MemberDTO" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = "홍길동";
		String id   = "hongil";
		String pw   = "1234";
		String phone1 = "010";
		String phone2 = "1235";
		String phone3 = "5678";
		String gen = "man";
		int i;
				
		MemberDAO memberDAO = new MemberDAO();	
		// 공간만 확보해놓고 변수의 개수에 영향받지않고 사용할수 있음.(Setter 사용) 보통 DB작업시 많이 사용.
		MemberDTO dt = new MemberDTO(); // 매개변수가 몇개든지 처리가능 대신에 setter를 사용해서 값을 넣어주어야 함. 비어있고 공간만 확보해놓은 상태.

		MemberDTO dto = new MemberDTO(name,id,pw,phone1,phone2,phone3,gen); // 반드시 7개 값을 모두 넣어야 생성됨.
		i = memberDAO.memberInsert(dto);
		if(i == 1) 	out.println("성공적으로 입력되었습니다.");//입력성공했을때 메세지 page
		
		else out.println("실패"); // 입력 실패했을때 메세지 page
	
	%>
</body>
</html>