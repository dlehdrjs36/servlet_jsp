<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  useBean 액션으로 CalcBean 클래스 인스턴스 생성 -->
<jsp:useBean id="calc" class="com.javalec.ex03.CalcBean" />
<!--  setProperty 를 이용해 사용자 입력값을 자동으로 CalcBean 클래스의 멤버변수에 넣어줌 -->
<jsp:setProperty name= "calc" property="*" />

<!--  연산 수행 메서드 호출 -->
<% calc.calculate(); %>



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
계산결과 : <jsp:getProperty name="calc" property="result" />
</body>
</html>