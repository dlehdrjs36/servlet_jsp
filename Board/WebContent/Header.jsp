<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function changeView(value) {
		if (value == "0") // HOME 버튼 클릭시 첫화면으로 이동
		{
			location.href = "MainForm.do";
		} 
		else if (value == "1") // 로그인 버튼 클릭시 로그인 화면으로 이동
		{
			location.href = "MemberLoginForm.do";
		} 
		else if (value == "2") // 회원가입 버튼 클릭시 회원가입 화면으로 이동
		{
			location.href = "MemberJoinForm.do";
		} 
		else if (value == "3") 
		{
			location.href = "MemberInfoForm.do";
		}
		//20180813
		else if (value == "4") 
		{
			location.href = "PointUser.do";
		}
		else if (value == "5") 
		{
			location.href = "PointUpdateSaveView.do";
		}
		else if (value == "6") 
		{
			location.href = "PointUpdateUseView.do";
		}
		else if (value == "7") 
		{
			location.href = "PointList.do";
		}
		else if (value == "8") 
		{
			location.href = "PointHistory.do";
		}
		//
		else if (value == "99") // 로그아웃 버튼 클릭시 로그아웃 처리
		{
			location.href = "MemberLogout.do";
		}

	}
</script>
	<nav class="navbar  navbar-expand-sm  bg-dark  navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" onclick="changeView(0)">홈</a></li>
			<%
				// 로그인 안되었을 경우 - 로그인, 회원가입 버튼을 보여준다.
				if (session.getAttribute("sessionID") == null) {		
			%>
			<li class="nav-item"><a class="nav-link" onclick="changeView(1)">로그인</a></li>
			<li class="nav-item"><a class="nav-link" onclick="changeView(2)">회원가입</a></li>
			<%
				// 관리자가로그인 되었을 경우 - 로그아웃, 내정보 버튼을 보여준다.
				} else if (session.getAttribute("sessionID").equals("admin2")){
			%>
			<li class="nav-item"><a class="nav-link" onclick="changeView(3)">내정보보기</a></li>
			
			<li class="nav-item"><a class="nav-link" onclick="changeView(5)">사용자 포인트적립하기</a></li>
			<li class="nav-item"><a class="nav-link" onclick="changeView(6)">사용자 포인트사용하기</a></li>
			<li class="nav-item"><a class="nav-link" onclick="changeView(7)">전체이용자의 포인트확인하기</a></li>
			<li class="nav-item"><a class="nav-link" onclick="changeView(8)">포인트사용 이력확인하기</a></li>
			
			<li class="nav-item"><a class="nav-link" onclick="changeView(98)">공지사항</a></li>
			
			<li class="nav-item"><a class="nav-link" onclick="changeView(99)">로그아웃</a></li>
			<%
				// 로그인 되었을 경우 - 로그아웃, 내정보 버튼을 보여준다.
				} else {
			%>
			<li class="nav-item"><a class="nav-link" onclick="changeView(3)">내정보보기</a></li>
			
			<li class="nav-item"><a class="nav-link" onclick="changeView(4)">포인트확인하기</a></li>
			<li class="nav-item"><a class="nav-link" onclick="changeView(98)">공지사항</a></li>		
			<li class="nav-item"><a class="nav-link" onclick="changeView(99)">로그아웃</a></li>
			<%
				}
			%>

			
		</ul>
	</nav>