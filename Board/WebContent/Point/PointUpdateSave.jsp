<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body{
	background-color: lightblue;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>포인트 적립</title>
<script type="text/javascript" src="/Board/js/PointCheck.js"></script>
<link rel="stylesheet" href="/Board/css/Point.css">
<link rel="stylesheet" href="/Board/BootStrap/css/bootstrap.css">
</head>
<body>
	<form action="PointUpdateSave.po" method="post" onsubmit="return checkContent2()" name="searchoption">
		<table border="1">
			<tr>
				<td class="td1"> ID </td>
				<td class="td2"> <input id="id" type="text" name="id" size ="50"> </td>
			</tr>
			<tr>
				<td class="td1"> 적립할 Point </td>
				<td class="td2"> <input id="save" type="text" name="save" size ="50"> </td>		
			</tr>
			<tr>
			<td class="td-button" colspan="2">
			 <input class="btn btn-primary btn-xl" type="submit" value="포인트적립"></td>
			</tr>	
		</table>			
	</form>	
</body>
</html>