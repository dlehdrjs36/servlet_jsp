<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<link rel="stylesheet" href="/Board/BootStrap/css/bootstrap.css">
<link rel="stylesheet" href="/Board/css/MemberJoinForm.css">
<script type="text/javascript" src="/Board/js/JoinCheckValue.js"></script>
<!--
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="../../BootStrap/js/bootstrap.js"></script>
 -->

</head>
<body>
	<form action="./MemberJoin.do" method="post" name="userInfo"
		onsubmit="return checkValue()">
		<table>
			<tr class="tr-bg">
				<td class="td1">ID</td>
				<td class="td2"><div class="div-id">
						<input type="text" name="id"> &nbsp;&nbsp;
						<input type="button" value="ID 중복 체크"	class="btn btn-primary  btn-xs btn1">
					</div>
					<div class="div-id">아이디는 영문으로 시작해서 6자 이상 20자까지 사용가능 합니다.</div></td>
			</tr>
			<tr class="tr-bg">
				<td class="td1">
					<div class="div-password2">비밀번호</div>
					<div class="div-password2">비밀번호 확인</div>
				</td>
				<td class="td2">
					<div class="div-password">
						<input type="password" name="password">
					</div>
					<div class="div-password">
						<input type="password" name="passwordcheck">
					</div>
				</td>
			</tr>
			<tr class="tr-bg">
				<td class="td1">이메일</td>
				<td class="td2"><div class="div-email">
						<input type="email" name="email" placeholder="ooo@ooo.com">
					</div></td>
			</tr>
			<tr class="tr-bg">
				<td class="td1">이름</td>
				<td class="td2"><div class="div-name">
						<input type="text" name="name">
					</div></td>
			</tr>
			<tr class="tr-bg">
				<td class="td1">생년월일</td>
				<td class="td2"><div class="div-birthday">
						<input type="date" name="birthday">
					</div></td>
			</tr>
			<tr class="tr-bg">
				<td class="td1">성별</td>
				<td class="td2">
					<div class="div-gender">
						<input type="radio" name="gender" id="man" value="man">
						<label for="man">남성</label>&nbsp;&nbsp; 
						<input type="radio"	name="gender" id="woman" value="woman">
						<label for="woman">여성</label>
					</div>
				</td>
			</tr>
			<tr class="tr-bg">
			
			
				<td class="td1">주소</td>
				
						<input type="text" id="addrnum" name="addrnum">&nbsp;&nbsp;
						<input
							type="button" onclick="SearchPostcode()" value="우편번호검색"
							class=" btn btn-primary  btn-xs btn1"><br>
				
						<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
						<script src="/Board/js/SearchAddr.js"></script>
				
				
						<input type="text" id="addr" name="addr" class="addr">
				
				
						<input type="text" name="addrdetail" class="addrdetail">
				
				
			</tr>
			<tr class="tr-bg">
				<td class="td1">전화번호</td>
				<td class="td2"><div class="div-phonenum">
						<input type="text" width="100px" name="tel1" class="tel">-<input
							type="text" name="tel2" class="tel">-<input type="text"
							name="tel3" class="tel">
					</div></td>
			</tr>
			<tr>
				<td colspan="2" class="td-button"><div class=" button-div">
						<input type="submit" value="저  장"
							class="btn btn-primary btn-xs btn2">&nbsp;&nbsp;<input
							type="reset" value="다시작성" class="btn btn-primary  btn-xs btn2">
						&nbsp;&nbsp;<input type="button" value="취소 "
							onclick="ReturnLoginForm()" class="btn btn-primary  btn-xs btn2">
					</div></td>
			</tr>
		</table>
	</form>
</body>
</html>