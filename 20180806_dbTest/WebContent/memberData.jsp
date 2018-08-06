<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%!
		Connection connection;
		Statement statement;
		ResultSet resultSet;
	
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 이객체를통해서 로컬호스트에 접근함.
		String uid = "micol";
		String upw = "micol";
		String query = "select * from member";
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		try{
			
			Class.forName(driver);	// 1. oracle.jdbc.driver.OracleDriver 
			connection = DriverManager.getConnection(url, uid, upw);	// 2. jdbc:oracle:thin:@localhost:1521:xe
			statement = connection.createStatement(); // 3. sql문을 실행하기위해서 statement 객체를 만들어준다.
			resultSet = statement.executeQuery(query);	// 4. 쿼리문을 담아서 실행. select * from member
			
			while(resultSet.next()){
				String id = resultSet.getString("id");
				String pw = resultSet.getString("password");
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				
				out.println("아이디 : " + id + ", 비밀번호 : " + pw + ", 이름 : " + name + ", 전화번호 : " + phone + "<br />");
			}
			  
		} catch(Exception e) {
		} finally { // finally : 작업이 끝나면 시작한순서의 역순으로 닫아주어라(자원을 해지한다).
			try{
				if(resultSet != null) resultSet.close();
				if(statement != null) statement.close();
				if(connection != null) connection.close();
			} catch(Exception e){}
		}
	%>
	
</body>
</html>