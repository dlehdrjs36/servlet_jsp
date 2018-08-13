
<%@page import="DTO.MemberBean"%>
<%@page import="DAO.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Board/BootStrap/css/bootstrap.css">
<link rel="stylesheet" href="/Board/css/MemberChangeInfoForm.css">
<script type="text/javascript" src="/Board/js/ChangeInfoCheckValue.js"></script>

</head>
<body>
	<%
	String id = session.getAttribute("sessionID").toString();
	MemberDAO dao =  MemberDAO.getInstance();
	MemberBean memberBean = dao.SearchMemberInfo(id);	
	%>
	<form action="MemberChangeInfo.do" method="post" name="userInfo"
		onsubmit="return checkValue()">
		<table>
			<tr class="tr-bg">
				<td class="td1">
					<div class="div-password2">기존비밀번호</div>
					<div class="div-password2">비밀번호</div>
					<div class="div-password2">비밀번호 확인</div>
				</td>
				<td class="td2">
					<div class="div-password">
						<input type="password" name="oldpassword">
					</div>
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
						<input type="email" name="email" placeholder="ooo@ooo.com" value="<%=memberBean.getEmail()%>">
					</div></td>
			</tr>
			<tr class="tr-bg">
				<td class="td1">이름</td>
				<td class="td2"><div class="div-name">
						<input type="text" name="name" value="<%=memberBean.getName()%>">
					</div></td>
			</tr>
			<tr class="tr-bg">
				<td class="td1">생년월일</td>
				<td class="td2"><div class="div-birthday">
						<input type="date" name="birthday" value="<%=memberBean.getBirthday()%>">
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
				<td class="td2">
					<div class="div-addr">
						<input type="text" id="addrnum" name="addrnum" value="<%=memberBean.getAddrnum()%>">&nbsp;&nbsp;<input
							type="button" onclick="SearchPostcode()" value="우편번호검색"
							class=" btn btn-primary  btn-xs btn1"><br>
						<div id="layer"
							style="display: none; position: fixed; overflow: hidden; z-index: 1; -webkit-overflow-scrolling: touch;">
							<img
								src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png"
								id="btnCloseLayer"
								style="cursor: pointer; position: absolute; right: -3px; top: -3px; z-index: 1"
								onclick="closeDaumPostcode()" alt="닫기 버튼">
						</div>
						<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
						<script src="/Board/js/SearchAddr.js"></script>
					</div>
					<div class="div-addr">
						<input type="text" id="addr" name="addr" class="addr"value="<%=memberBean.getAddr()%>">
					</div>
					<div class="div-addr">
						<input type="text" name="addrdetail" class="addrdetail" value="<%=memberBean.getAddrdetail()%>">
					</div>
				</td>
			</tr>
			<tr class="tr-bg">
				<td class="td1">전화번호</td>
				<td class="td2"><div class="div-phonenum">
						<input type="text" name="tel1" class="tel" value="<%=memberBean.getPhonenum().substring(0,3)%>">-
						<input type="text" name="tel2" class="tel" value="<%=memberBean.getPhonenum().substring(4,8)%>">-
						<input type="text" name="tel3" class="tel" value="<%=memberBean.getPhonenum().substring(9,13)%>">
					</div></td>
			</tr>
			<tr>
				<td colspan="2" class="td-button">
					<div class=" button-div">
						<input type="submit" value="저  장" class="btn btn-primary btn-xs btn2">&nbsp;&nbsp;
						<input type="reset" value="다시작성" class="btn btn-primary  btn-xs btn2">	&nbsp;&nbsp;
						<input type="button" value="취소 " onclick="location.href='MemberInfoForm.do'" class="btn btn-primary  btn-xs btn2">
					</div></td>
			</tr>
		</table>
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