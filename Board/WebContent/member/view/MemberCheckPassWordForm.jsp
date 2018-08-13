<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>탈퇴확인</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
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

</style>
</head>
<body>
	<form action="MemberLeave.do" method="post">
		<div style="text-align: center; margin-top:200px;">
			<div style="display: inline-block;">
				<div class="form-group" style="display: inline-block;">
					<input type="password" class="form-control" name="password" style="width:350px">
				</div>&nbsp;&nbsp;&nbsp;
				<span><input type="submit" class="btn btn-primary btn-xl" value="확인">&nbsp;&nbsp;&nbsp;<input type="button" onclick="location.href='MemberInfoForm.do'" class="btn btn-primary btn-xl" value="취소"></span>
			</div>
			<div>
				<font color="white" font-size="3pt">회원 탈퇴를 하시려면 비밀번호를 입력하여 주세요.</font>
			</div>
		</div>
	</form>
	<% 
            String msg=request.getParameter("msg");            
            if(msg!=null && msg.equals("1")) 
            {
	%>
     			<script>alert("비밀번호가 잘못되었습니다.")</script>
    <%
    		}
    %>   
</body>
</html>