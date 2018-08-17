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
<<<<<<< HEAD
import DTO.BoardSearchBean;

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
	
	//게시판 검색
	// 특정조건을 주어 검색한 결과만 포인트 사용이력 목록으로 보여주기위한 메소드.
		public List<BoardBean> BoardSearchList( BoardSearchBean vo, int page) { 
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;		
			List<BoardBean> list = new ArrayList<>();  
	    	int startrow = (page-1)*10+1;
	        int endrow = page*10;       
	        
	        try {
				conn = DBConnection.getConnection();

					if( vo.getSubjects().equals("제목")) {   
						String sql =  "SELECT * FROM (  																																	"
								+ "SELECT ROWNUM RNUM, WRITE_NUM, AUTHOR, SUBJECT, CONTENT, FILE_NAME,RE_GROUP, RE_LEVEL, RE_SEQ, READ_COUNT, TO_CHAR(REG_DATE,'yyyy/mm/dd') AS REG_DATE	"  
								+ "  FROM ( SELECT *																																		"	
								+ " FROM   board																																			" 				
								+ " WHERE  SUBJECT LIKE ?																																"
								+ " ORDER BY RE_GROUP DESC, RE_SEQ ASC)																														"						  						
								+ "  	    ) WHERE RNUM >= ? AND RNUM <= ?																												";	
						pstmt = conn.prepareStatement(sql); // sql명령문 담아둠						
						pstmt.setString(1, "%" + vo.getSearch() + "%" );						
						pstmt.setInt(2, startrow);
						pstmt.setInt(3, endrow);
					}
					else if ( vo.getSubjects().equals("작성자")) {      
						String sql =  "SELECT * FROM (  																																	"
								+ "SELECT ROWNUM RNUM, WRITE_NUM, AUTHOR, SUBJECT, CONTENT, FILE_NAME,RE_GROUP, RE_LEVEL, RE_SEQ, READ_COUNT, TO_CHAR(REG_DATE,'yyyy/mm/dd') AS REG_DATE	"  
								+ "  FROM ( SELECT *																																		"	
								+ " FROM   board																																			" 				
								+ " WHERE  AUTHOR = ?																																"
								+ " ORDER BY RE_GROUP DESC, RE_SEQ ASC)																														"						  						
								+ "  	    ) WHERE RNUM >= ? AND RNUM <= ?																												";	
				
						pstmt = conn.prepareStatement(sql); // sql명령문 담아둠
						pstmt.setString(1, vo.getSearch());						
						pstmt.setInt(2, startrow);
						pstmt.setInt(3, endrow);			      	
					}	
	        	rs = pstmt.executeQuery();       	
				while(rs.next()) { 
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
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
	    	return list;     
		}
		
		// 검색을 햇을때 검색결과(총 데이터수)를 가져오는 메소드.
		public int BoardSearchTotalCount( String subjects, String search) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int totalCount = 0;
			try {
				conn = DBConnection.getConnection();
				
				if( subjects.equals("작성자")) {
						String sql = "select count(*) from board where AUTHOR = ?";
						pstmt = conn.prepareStatement(sql); 
			        	pstmt.setString(1, search);		        
			    }
				else if( subjects.equals("제목")) {
						String sql = "select count(*) from board where SUBJECT like ?"; 
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, "%" + search + "%");											
				}
				rs = pstmt.executeQuery();	
				rs.next();		
				totalCount = rs.getInt("count(*)");			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return totalCount;
		}	
		// 수정기능하는 dao
		public void UpdateBoard(int writeNum, BoardBean Bo ) throws SQLException {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBConnection.getConnection();
				conn.setAutoCommit(false);
				String sql = " UPDATE BOARD "
							+" SET subject=?, content=? "
							+" WHERE write_num=?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, Bo.getSubject());
				pstmt.setString(2, Bo.getContent());
				pstmt.setInt(3, writeNum);
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
		
	// 조회수 증가를 위한 메소드
		public void UpdateCountBoard(int writeNum, BoardBean Bo ) throws SQLException {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBConnection.getConnection();
				conn.setAutoCommit(false);
				String sql = " UPDATE BOARD "
							+" SET read_count=? "
							+" WHERE write_num=?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Bo.getReadCount());
				pstmt.setInt(2, writeNum);
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
	//
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
	// 답글
	public int boardReply(BoardBean board) throws SQLException{ 
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		
        String board_max_sql="select max(write_num) from board";
        
        int num=0; 
        int result=0; 
         
        //int re_ref=board.getWriteNum(); //원본글 번호 
        int re_ref=board.getReGroup(); //원본글 번호
        int re_lev=board.getReLevel(); // 답변글의 깊이 
        int re_seq=board.getReSequence(); //답변글의 순서 
         
        try{ 
        	conn = DBConnection.getConnection();
        	conn.setAutoCommit(false);
            pstmt=conn.prepareStatement(board_max_sql); 
            rs = pstmt.executeQuery(); 
            if(rs.next())num =rs.getInt(1)+1; //답변글이 있을경우 max에 +1해서 글번호를 먹여준다. 
            else num=1;  //글 등록이 되어있지 않으면 num=1
            System.out.println(num);
            /*ref값과 seq값을 확인하여 원본 글에 다른 답변 글이 있으면,  
             * 답변 글 중 답변 글보다 상위에 있는 글의 seq보다 높은 글의 seq값을 1씩 증가시킨다.*/ 
            String sql="update board set RE_SEQ = RE_SEQ+1 where RE_GROUP = ? and RE_SEQ > ? "; 
             
            pstmt2 = conn.prepareStatement(sql); 
            pstmt2.setInt(1,re_ref); 
            pstmt2.setInt(2,re_seq); 
            result=pstmt2.executeUpdate(); 
            conn.commit();
            pstmt2.close();
            
            re_seq = re_seq +1; //답변 글이 원본 글 보다 아래에 출력되어야 하기 때문에 re_seq값을 1증가시킨다. 
            re_lev = re_lev+1; // 답변을 하는것이므로 현재 답변 레벨 단계에서 1을 증가시킨다. 
             
            String sql2="insert into board (WRITE_NUM,AUTHOR,SUBJECT,CONTENT,FILE_NAME,RE_GROUP,RE_LEVEL,RE_SEQ,READ_COUNT,REG_DATE) values(?,?,?,?,?,?,?,?,?,sysdate)"; 
             
            pstmt3 = conn.prepareStatement(sql2); 
            pstmt3.setInt(1, num); 
            pstmt3.setString(2, board.getAuthor()); 
            pstmt3.setString(3, board.getSubject()); 
            pstmt3.setString(4, board.getContent()); 
            pstmt3.setString(5, "0"); //답장에는 파일을 업로드하지 않음. 
            pstmt3.setInt(6, re_ref); 
            pstmt3.setInt(7, re_lev); 
            pstmt3.setInt(8, re_seq); 
            pstmt3.setInt(9, 0); 
            pstmt3.executeUpdate(); 
            conn.commit();
            pstmt3.close();
            return num; 
        }catch(SQLException ex){ 
        	conn.rollback();
            System.out.println("boardReply 에러 : "+ex); 
        } catch (ClassNotFoundException e) {
        	conn.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			conn.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
            if(rs!=null)try{rs.close();}catch(SQLException ex){} 
            if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
            if(conn!=null)try{conn.close();}catch(SQLException ex){} 
        } 
        return 0; 
    }


=======

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
>>>>>>> refs/remotes/origin/master

}
