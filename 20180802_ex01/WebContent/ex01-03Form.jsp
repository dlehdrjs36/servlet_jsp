<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--   viewport : 기기에 맞춰서 변경-->

<h2>for문 예제 - 임의의 값을 임의의 횟수로 곱하기</h2>
<form method="post" action="ex01-03Pro.jsp">
	<dl>
		<dd>
			<label for="number"> 곱해질 값 :</label>
			<input type="number" name="number" autofocus required>	
		</dd>
		<dd>
			<label for="num">곱해질 횟수 :</label>
			<input type="number" name="num" required>
		</dd>
		<dd>
			<input type="submit" value="확인">
		</dd>
	</dl>
</form>
