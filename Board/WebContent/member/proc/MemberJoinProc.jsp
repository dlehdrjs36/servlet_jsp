<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입을 축하합니다.</title>
<link rel="stylesheet" href="/Board/BootStrap/css/bootstrap.css">
<style>
html {
	height: 100%;
}
body {
	width: 100%;
	height: 100%;
	margin: 0;
	font-family: "Nanum Gothic", arial, helvetica, sans-serif;
	background-repeat: no-repeat;
	background: linear-gradient(to bottom right, #0098FF, #6BA8D1);
}
table {
	border-collapse: collapse;
	margin-left: auto;
	margin-right:auto;
	background-color: white;
	font-size: 15pt;
}

td, tr {
	border: 1px solid black;
}
.div1{
	text-align: center;
}
.title{
	width : 130px;
	text-align: center;
}
.content{
	width : 500px;
	padding-left: 20px;
}

</style>
</head>
<body>
 
	<div id="wrap">
		<br>
		<br>
		<div class="div1">

			<br>
			<br> 
			<font size="6" color="white">${param.name}님 가입을 축하드립니다. </font> 
			<br>
			<br> 
			<b><font size="5">회원가입 정보를 확인하세요.</font></b> 
			<br>
			<br>
		</div>
		<table>
			<tr>
				<td class="title">아이디</td>
				<td class="content">${param.id}</td>
			</tr>
			<tr>
				<td class="title">비밀번호</td>
				<td class="content">${param.password}</td>
			</tr>
			<tr>
				<td class="title">이름</td>
				<td class="content">${param.name}</td>
			</tr>
			<tr>
				<td class="title">성별</td>
				<td class="content">${param.gender}</td>
			</tr>
			<tr>
				<td class="title">생일</td>
				<td class="content">${param.birthday}</td>
			</tr>
			<tr>
				<td class="title">이메일</td>
				<td class="content">${param.email }</td>
			</tr>
			<tr>
				<td class="title">휴대전화</td>
				<td class="content">${param.tel1}-${param.tel2}-${param.tel3}</td>
			</tr>
			<tr>
				<td class="title">주소</td>
				<td class="content">
					<div>${param.addrnum}</div>
					<div>${param.addr}</div>
					<div>${param.addrdetail}</div>
				</td>
			</tr>
		</table>
		<br>
		<div class="div1"><input type="button" class="btn btn-primary  btn-lg " value="확인" onclick="location.href='/Board/MainForm.do?contentPage=/member/view/MemberLoginForm.jsp'"></div> 
	</div>
</body>
