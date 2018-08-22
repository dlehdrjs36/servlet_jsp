<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
</head>
<body>
<form action="../MemberForm.do" method="post" >

<table>
<tr>
<td>아이디</td> <td><input type="text" name="id"> </td>
</tr>
<tr>
<td>패스워드</td><td><input type="text" name="password"> </td>
</tr>
<tr>
<td>이름</td><td><input type="text" name="name"> </td>
</tr>
<tr>
<td>성별</td><td><input type="radio" name="gender" value="1">남자 <input type="radio" name="gender" value="2">여자</td>	
</tr>
<tr>
<td>휴대전화</td><td><input type="text" name="phone1">-<input type="text" name="phone2">-<input type="text" name="phone3"></td>
</tr>
<tr>
<td>이메일</td><td><input type="text" name="email"></td>
</tr>
<tr>
<td>주소</td>
<td>
<input type="text" id="postcode" name="postcode" placeholder="우편번호">
<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="roadAddress" name="roadAddress" placeholder="도로명주소">
<input type="text" id="jibunAddress" name="jibunAddress" placeholder="지번주소"> 
<span id="guide" name="guide" style="color:#999"></span>
</td>
</tr>
</table>
<input type="submit" value="회원가입">
<input type="reset" value="다시작성">  
</form>
<script src="/trip/js/Addr.js"></script>
</body>
</html>