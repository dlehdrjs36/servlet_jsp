package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import DTO.DTO;

public class DAO {
	DataSource dataSource;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DTO dto = null;
	

	// 커넥션 풀 사용
	public DAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<DTO> SelectMemberCheck() {	
		ArrayList<DTO> dtos = new ArrayList<DTO>();	
		try {
			String sql = "SELECT first_name,last_name FROM employees";
			
			conn = dataSource.getConnection();	
			pstmt = conn.prepareStatement(sql);		
			rs = pstmt.executeQuery();

			while(rs.next()) { 
					dto = new DTO();
					dto.setFirstName(rs.getString("first_name"));
					dto.setLastName(rs.getString("last_name"));
	
					dtos.add(dto); 
				}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)	rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
}
