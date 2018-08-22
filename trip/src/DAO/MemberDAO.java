package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import DTO.MemberBean;

public class MemberDAO {
	DataSource dataSource;	
	Connection conn = null;
	PreparedStatement pstmt = null;	
	//커넥션 풀 사용
	public MemberDAO() {	
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}	
	public int InsertMember(MemberBean MB) {
		int check= 0;
		try {
			String sql = "insert into member2(ID,PW,PHONE,ADDRESS,GENDER,NAME,EMAIL) values ( ?, ? , ? , ? , ? , ?, ?)";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MB.getId());
			pstmt.setInt(2, MB.getPw());
			pstmt.setString(3, MB.getPhone());
			pstmt.setString(4, MB.getAddress());
			pstmt.setInt(5, MB.getGender());
			pstmt.setString(6, MB.getName());
			pstmt.setString(7, MB.getEmail());
			
			check = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {				
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
	}	
}
