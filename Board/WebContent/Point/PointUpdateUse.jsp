<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {

	background-color: lightblue;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>포인트 사용</title>
<script type="text/javascript" src="/Board/js/PointCheck.js"></script>
</head>
<body>	
	<form action="PointUpdateUse.do" method="post" onsubmit="return checkContent3()" name="searchoption">
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td> ID </td>
				<td> <input id="id" type="text" name="id" size = "50"> </td>
			</tr>
			<tr>
				<td> 사용할 Point </td>
		 		<td> <input id="use" type="text" name="use" size ="50"> </td>			
			</tr>	
			<tr>
				<td colspan="2" align="right"> <input type="submit" value="포인트사용"></td>
			</tr>		
		</table>
	</form>
</body>
</html>