package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import DTO.MemberBean;

public class MemberDAO {
	DataSource dataSource;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	MemberBean dto = null;
	ArrayList<MemberBean> dtos = null;

	// 커넥션 풀 사용
	public MemberDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int InsertMember(MemberBean MB) {
		int check = 0;
		try {
			String sql = "INSERT INTO member2(ID,PW,PHONE,ADDRESS,GENDER,NAME,EMAIL) VALUES ( ?, ? , ? , ? , ? , ?, ?)";
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
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
	}

	public int SelectMemberCheck(MemberBean MB) {
		int check = 0;
		try {
			String sql = "SELECT count(*) FROM member2 WHERE id = ?";

			conn = dataSource.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MB.getId());

			rs = pstmt.executeQuery();

			if (rs.next())
				check = rs.getInt("count(*)");
			System.out.println(check);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
	}
}
