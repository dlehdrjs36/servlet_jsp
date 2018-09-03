<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="id01" class="modal">
	
		<form class="modal-content animate" action="<%=request.getContextPath() %>/member/loginOk.jsp">
			<div
				class="bgimg w3-display-container w3-animate-opacity w3-text-white">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close Modal">&times;</span>

				<div class="w3-display-middle">
					<label for="uname" class="w3-jumbo w3-animate-top"><b>Username</b></label>
					<input type="text" placeholder="Enter Username" name="id"
						required> <label for="psw" class="w3-jumbo w3-animate-top"><b>Password</b></label>
					<input type="password" placeholder="Enter Password" name="pwd"
						required>

					<button type="submit"><b>Login</b></button>
					
					<div><a href="<%=request.getContextPath()%>/MemberJoin.do">회원가입</a></div>
					<span class="psw">Forgot <a href="#">password?</a></span>
				</div>

				<div class="w3-display-bottomleft w3-padding-large">
					<button type="button"
						onclick="document.getElementById('id01').style.display='none'"><b>Cancel</b></button>
				</div>
			</div>
		</form>
	</div>

<script>
// Get the modal
var modal = document.getElementById('id01');
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
</body>
</html>