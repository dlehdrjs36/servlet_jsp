<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<div style="max-width:1000px; margin:50px">

 <table border="1">
  	
 	<tr><td colspan="3" >출발지                                             ------->              도착지</td></tr>
 	<tr>
 	<td><input id="dia_bt" class="input-field" type="text" placeholder="이름" name="from" readonly="readonly" value="한국" style="width:99%;"></td>
 	<td colspan="2"><input id="dia_bt" class="input-field" type="text" placeholder="국적" name="from" readonly="readonly" value="일본" style="width:99%;"></td>
 	</tr>
 	
   	<tr><td colspan="3">출발날짜</td></tr>
   	<tr>
   	<td><input id="dia_bt" class="input-field" type="text" placeholder="출발날짜" name="from" value="20180831" readonly="readonly"></td>
   	<td>성인</td>
   	<td>3</td>
   	</tr>   
    <tr><td>가는편날짜</td><td>출발시간</td> <td>출발공항명</td></tr>
 	<tr><td>20180831</td><td>06:00</td><td>아시아나</td></tr>
 	<tr><td>가는편날짜</td><td>도착시간</td><td>도착공항명</td></tr>
 	<tr><td>20180831</td><td>08:00</td><td>나리타</td></tr>
  </table>
</div>
  
<div style="max-width:1000px; margin:50px">
	<form action="#">  
  		<table border="1">  	
 			<tr><td>이름</td><td>국적</td></tr>
 			<tr><td><input id="dia_bt" class="input-field" type="text" placeholder="이름" name="from"></td>
 				<td><input id="dia_bt" class="input-field" type="text" placeholder="국적" name="from"></td>
		 	</tr>
   			<tr><td>연락처</td><td>이메일</td></tr>
 			<tr><td><input id="dia_bt" class="input-field" type="text" placeholder="연락처" name="from"></td>
 				<td><input id="dia_bt" class="input-field" type="text" placeholder="이메일" name="from"></td>
 			</tr>
    		<tr><td colspan="2" align="right"><button type="submit" class="btn" id="getBtn">좌석선택 GO</button></td></tr>
  		</table>
	</form>
</div>



</body>
</html>