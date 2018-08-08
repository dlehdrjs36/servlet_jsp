<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="PointUpdateUse.do" method="post">
			<tr>
				<td> ID </td>
				<td> <input type="text" name="id" size = "50"> </td>
			</tr>
			<tr>
				<td> 사용할 Point </td>
				<td> <input type="text" name="save" size ="50"> </td>
			
			</tr>		
			<tr>
			<td><input type="submit" value="포인트사용"></td>
			</tr>
		</form>
	</table>
	 <a href="PointList.do">목록보기</a>
	</body>
</html>