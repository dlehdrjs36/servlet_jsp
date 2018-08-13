package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import Common.DBConnection;
import DTO.MemberBean;

public class MemberDAO {
	private static MemberDAO instance;

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		if (instance == null)
			instance = new MemberDAO();
		return instance;
	}

	public void insertMember(MemberBean member) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			String phoneNum = member.getTel1() + "-" + member.getTel2() + "-" + member.getTel3();
			String sql = "insert into MEMBER values (?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ? )";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, member.getBirthday());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, phoneNum);
			pstmt.setString(8, member.getAddr());
			pstmt.setString(9, member.getAddrdetail());
			pstmt.setString(10, member.getAddrnum());
			pstmt.executeUpdate();
			String sql2 = "insert into point(id) values ( ? )";
			pstmt2=conn.prepareStatement(sql2);
			pstmt2.setString(1, member.getId());
			pstmt2.executeQuery();
			conn.commit();
		} catch (ClassNotFoundException | NamingException | SQLException sqle) {
			conn.rollback();
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (pstmt2 != null) {
					pstmt2.close();
					pstmt2 = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	public int loginMember(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String password = "";
		int x = 0;

		try {
			String sql = "SELECT PASSWORD FROM MEMBER WHERE ID= ? ";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) // 입려된 아이디에 해당하는 비번 있을경우
			{
				password = rs.getString("password"); // 비번을 변수에 넣는다.
				if (password.equals(pw))
					x = 1;
				else
					x = 0; // DB의 비밀번호와 입력받은 비밀번호 다름, 인증실패
			}
			return x;
		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	public MemberBean SearchMemberInfo(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberBean member = null;
		try {
			String sql = "SELECT member.id, member.password, member.name, member.gender,TO_CHAR(member.birthday,'yyyy-mm-dd') AS BIRTHDAY, " + 
					 "       member.EMAIL, member.PHONE_NUM, member.ADDR_NUM, member.ADDR, member.ADDR_DETAIL,point.TOTAL_POINT FROM MEMBER JOIN POINT " + 
					 "	     ON MEMBER.id = POINT.id WHERE member.ID = ?";
		conn = DBConnection.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			member = new MemberBean();
			member.setId(rs.getString("ID"));
			member.setPassword(rs.getString("PASSWORD"));
			member.setName(rs.getString("NAME"));
			member.setGender(rs.getString("GENDER"));
			member.setBirthday(rs.getString("BIRTHDAY"));
			member.setEmail(rs.getString("EMAIL"));
			member.setPhonenum(rs.getString("PHONE_NUM"));
			member.setAddrnum(rs.getString("ADDR_NUM"));
			member.setAddr(rs.getString("ADDR"));
			member.setAddrdetail(rs.getString("ADDR_DETAIL"));
			member.setPoint(rs.getString("TOTAL_POINT"));
		}
		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return member;
	}
	public int ChangeMemberInfo(String id, String pw, MemberBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String phonenum = bean.getTel1() + "-" + bean.getTel2() + "-" + bean.getTel3();
		int rs;
		try {
			String sql = "UPDATE MEMBER SET PASSWORD = ?, NAME = ?, GENDER = ?,   "
					   + "BIRTHDAY = ?, EMAIL = ?, PHONE_NUM = ?, ADDR_NUM = ?,   "
					   + "ADDR = ?, ADDR_DETAIL = ? WHERE ID = ? AND PASSWORD = ? ";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getPassword());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getGender());
			pstmt.setString(4, bean.getBirthday());
			pstmt.setString(5, bean.getEmail());
			pstmt.setString(6, phonenum);
			pstmt.setString(7, bean.getAddrnum());
			pstmt.setString(8, bean.getAddr());
			pstmt.setString(9, bean.getAddrdetail());
			pstmt.setString(10, id);
			pstmt.setString(11, pw);
			rs = pstmt.executeUpdate();
		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return rs;
	}
	
	public int MemberLeave (String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs;
		try {
			String sql = "DELETE FROM MEMBER WHERE ID = ?  AND PASSWORD = ? ";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeUpdate();
		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return rs;
	}
}
