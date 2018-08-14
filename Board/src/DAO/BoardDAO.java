package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import Common.DBConnection;
import DTO.BoardBean;

public class BoardDAO {

	private static BoardDAO instance;

	private BoardDAO() {
	}

	public static BoardDAO getInstance() {
		if (instance == null)
			instance = new BoardDAO();
		return instance;
	}

	public void WriteBoard(BoardBean boardBean) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			String sql = " INSERT INTO BOARD ( WRITE_NUM,AUTHOR,SUBJECT,CONTENT, "
					+ " FILE_NAME,RE_GROUP,RE_LEVEL,RE_SEQ,READ_COUNT,REG_DATE ) "
					+ " VALUES ( WRITE_NUM_SEQ.NEXTVAL, ?, ?, ?, 'DUMMY', WRITE_NUM_SEQ.CURRVAL, 0, 0, 0, sysdate ) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardBean.getAuthor());
			pstmt.setString(2, boardBean.getSubject());
			pstmt.setString(3, boardBean.getContent());
			pstmt.executeUpdate();
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
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	public int GetListCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = " SELECT COUNT(*) FROM BOARD ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (ClassNotFoundException | NamingException | SQLException sqle) {
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
		return count;

	}

	public List<BoardBean> getBoardList(int page, int limit) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardBean> list = new ArrayList<>();
		String sql = " SELECT * FROM (   																   							"
				+ "        	     SELECT ROWNUM RNUM, WRITE_NUM, AUTHOR, SUBJECT, CONTENT, FILE_NAME, 						"
				+ "        	            RE_GROUP, RE_LEVEL, RE_SEQ, READ_COUNT, TO_CHAR(REG_DATE,'yyyy/mm/dd') AS REG_DATE  "
				+ "        		 FROM ( SELECT * 													   						"
				+ "        		        FROM   board 												   						"
				+ "        		        ORDER BY RE_GROUP DESC, RE_SEQ ASC)						  							"
				+ "        	    ) WHERE RNUM >= ? AND RNUM <= ?	";

		int startrow = (page - 1) * 10 + 1; // 읽기 시작할 row 번호.
		int endrow = startrow + limit - 1; // 읽을 마지막 row 번호.
		System.out.println("s:" + startrow);
		System.out.println("e:" + endrow);
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardBean boardBean = new BoardBean();
				boardBean.setWriteNum(rs.getInt("WRITE_NUM"));
				boardBean.setAuthor(rs.getString("AUTHOR"));
				boardBean.setSubject(rs.getString("SUBJECT"));
				boardBean.setContent(rs.getString("CONTENT"));
				boardBean.setFileName(rs.getString("FILE_NAME"));
				boardBean.setReGroup(rs.getInt("RE_GROUP"));
				boardBean.setReLevel(rs.getInt("RE_LEVEL"));
				boardBean.setReSequence(rs.getInt("RE_SEQ"));
				boardBean.setReadCount(rs.getInt("READ_COUNT"));
				boardBean.setRegDate(rs.getString("REG_DATE"));
				list.add(boardBean);
			}
			return list;
		} catch (ClassNotFoundException | NamingException | SQLException sqle) {
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

	public BoardBean getBoardDetail(int writeNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " SELECT WRITE_NUM, AUTHOR, SUBJECT, CONTENT, FILE_NAME, "
				+ "        RE_GROUP,  RE_LEVEL, RE_SEQ, READ_COUNT, TO_CHAR(REG_DATE,'yy/mm/dd') AS REG_DATE "
				+ "   FROM BOARD  " + "  WHERE WRITE_NUM = ? ";
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, writeNum);
			rs = pstmt.executeQuery();
			BoardBean boardBean = new BoardBean();
			if (rs.next()) {
				boardBean.setWriteNum(rs.getInt("WRITE_NUM"));
				boardBean.setAuthor(rs.getString("AUTHOR"));
				boardBean.setSubject(rs.getString("SUBJECT"));
				boardBean.setContent(rs.getString("CONTENT"));
				boardBean.setFileName(rs.getString("FILE_NAME"));
				boardBean.setReGroup(rs.getInt("RE_GROUP"));
				boardBean.setReLevel(rs.getInt("RE_LEVEL"));
				boardBean.setReSequence(rs.getInt("RE_SEQ"));
				boardBean.setReadCount(rs.getInt("READ_COUNT"));
				boardBean.setRegDate(rs.getString("REG_DATE"));
			}
			return boardBean;
		} catch (ClassNotFoundException | NamingException | SQLException sqle) {
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

	public int deleteBoard(int writeNum, String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		String sql = " DELETE FROM BOARD  	" + "  WHERE WRITE_NUM = ? " + "    AND AUTHOR 	= ? ";
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, writeNum);
			pstmt.setString(2, id);
			rs = pstmt.executeUpdate();
			return rs;
		} catch (ClassNotFoundException | NamingException | SQLException sqle) {
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

}
