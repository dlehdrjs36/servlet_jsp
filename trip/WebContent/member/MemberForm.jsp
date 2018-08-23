<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="/trip/js/MemberJoinCheck.js"></script>
<script type="text/javascript" src="/trip/js/MemberIdCheck.js"></script>
</head>
<body>
	<form action="MemberForm.do" method="post" name="userInfo"
		onsubmit="return checkValue()">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" maxlength="20" value='${id}' onchange="IdCheck()"> 
					<c:if test="${check==0}">
					중복된ID가 없습니다.
					</c:if> 
					<c:if test="${check==1}">
					중복된ID입니다.
					</c:if>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" maxlength="20" value='${password}'></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="passwordcheck" maxlength="20" value='${passwordcheck}'></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" maxlength="4" value='${name}'></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio" name="gender" value="1">남자 
					<input type="radio" name="gender" value="2">여자
				</td>
			</tr>
			<tr>
				<td>휴대전화</td>
				<td><select name="phone1">
						<option value="010" selected>010</option>
						<option value="011">011</option>
				</select>-<input type="text" name="phone2" size="4" maxlength="4"
					value='${phone2}'>-<input type="text" name="phone3"
					size="4" maxlength="4" value='${phone3}'></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" value='${email}'></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" id="postcode" name="postcode" placeholder="우편번호" value='${postcode}'> 
					<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
					<input type="text" id="roadAddress" name="roadAddress" placeholder="도로명주소" value='${roadAddress}'> 
					<input type="text" id="jibunAddress" name="jibunAddress" placeholder="지번주소" value='${jibunAddress}'>
					<span id="guide" name="guide" style="color: #999"></span>
				</td>
			</tr>
		</table>
		<input type="submit" value="회원가입"> 
		<input type="reset" value="다시작성"> 
		<input type="hidden" name="check" value="${check}" />
	</form>
	<script src="/trip/js/Addr.js"></script>

	<form action="MemberIdCheck.do" method="post" name="idCheck">
		<input type="hidden" name="id" value="" />
		<input type="hidden" name="password" value="" /> 
		<input type="hidden" name="passwordcheck" value="" /> 
		<input type="hidden" name="name" value="" /> 
		<input type="hidden" name="gender" value="" /> 
		<input type="hidden" name="phone1" value="" /> 
		<input type="hidden" name="phone2" value="" /> 
		<input type="hidden" name="phone3" value="" /> 
		<input type="hidden" name="email" value="" />
		<input type="hidden" name="postcode" value="" />
		<input type="hidden" name="roadAddress" value="" /> 
		<input type="hidden" name="jibunAddress" value="" />
		<input type="hidden" name="check" value="" />
	</form>

</body>
</html>