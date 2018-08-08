package point.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import point.dto.PointDto;

public class PointDao {
	DataSource dataSource;
	
	public PointDao() {	
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g"); // 톰캣의 context.xml에서 <Resource ~~~ name = "jdbc/Oracle11g" ~~~ />을 찾는 부분임. 커넥션풀 . context.xml과 파싱하는것임.
			// 커넥션풀은 { server.xml, web.xml, context.xml } 어디에서든지 만들 수 있음. 차례대로 파싱하면서 위의 문장이 있는 곳으로 찾아감. (context.xml)
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); // 위에서 DB 못찾으면 에러. DB관련해서 작업할때는 try,catch 써주어야함.
		}
	}
	
	public void InsertPoint(String id, int save) throws SQLException  {
		// TODO Auto-generated method stub
		// 적립 flag = 1, 사용 flag = 2
		Connection connection = null;
		PreparedStatement preparedStatement = null;	
		try {		
			String query = "insert into point (id, save) values (?, ?)";
			String query2 = "insert into point_history ( id, point, flag ) values (?, ?, 1)";
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setInt(2, save);
			int rn = preparedStatement.executeUpdate();			
			
			preparedStatement = connection.prepareStatement(query2);
			preparedStatement.setString(1, id);
			preparedStatement.setInt(2, save);
			int rn2 = preparedStatement.executeUpdate();
			
			connection.commit();
		}
		catch (SQLException sqle) {
			if(connection!=null) try {connection.rollback();} catch (SQLException eqle) {}
		}		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		connection.setAutoCommit(true);
	}
	
	public ArrayList<PointDto> PointList() {
		
		ArrayList<PointDto> dtos = new ArrayList<PointDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select id, total_point, save, use from point"; 
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				int total_point = resultSet.getInt("total_point");
				int save = resultSet.getInt("save");
				int use = resultSet.getInt("use");
				
				PointDto dto = new PointDto(id, total_point, save, use);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
}
