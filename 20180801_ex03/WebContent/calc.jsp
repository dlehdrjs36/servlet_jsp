<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 변수 설정
	int result = 0;
	// 웹페이지요청이 post인경우에만 수행.
	// 초기 로딩시 오류 방지.
	if(request.getMethod().equals("POST")) {
		// 연산자를 가지고 옴.
		String op = request.getParameter("operator");
		
		// 문자열 형태로 전달된 인자들을 int 로 변환함. request : jsp가 가지고있는 내장 객체
	int num1 = Integer.parseInt(request.getParameter("num1")); // request.getParameter("num1") : 요청한것중에 num1이라는 파라미터를 찾는다.
	int num2 = Integer.parseInt(request.getParameter("num2"));
		 
		// 각 연산자별 처리
		if(op.equals("+")) {
			result = num1 + num2;
		}
		else if(op.equals("-")) {
			result = num1 - num2;
		}
		else if(op.equals("*")) {
			result = num1 * num2;
		}		
		else if(op.equals("/")) {
			result = num1 / num2;
		}
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>계산기</title>
</head>
<body>
 <h3> 계산기 </h3>
 <form name=form1 method =post >

  <input type="text" name ="num1" width=200 size="5">

  <select name="operator">
	 <option selected> + </option>
	 <option>-</option>
	 <option>*</option>
	 <option>/</option>
  </select>

  <input type ="text" name="num2" width=200 size="5">
  <input type ="submit" value="계산" name="B1"> <input type="reset" value="다시입력" name = "B2">

 </form>
<hr>
계산결과 : <%= result %>
</body>
</html>