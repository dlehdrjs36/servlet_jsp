<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>포인트 적립</title>
</head>
<body>
	<form action="PointUpdateSave.do" method="post">
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td> ID </td>
				<td> <input type="text" name="id" size = "50"> </td>
			</tr>
			<tr>
				<td> 적립할 Point </td>
				<td> <input type="text" name="save" size ="50"> </td>		
			</tr>
		</table>
					<input type="submit" value="포인트적립" >	
		</form>				
		
	

				
</body>
</html>