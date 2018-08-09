package point.dao;

import java.io.File;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import point.dto.PointDto;
import point.dto.PointHistoryDto;

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
	

	// 포인트 추가
	public void UpdateSavePoint(String id, int save)  {
		// TODO Auto-generated method stub
		// 적립 flag = 1, 사용 flag = 2
		Connection connection = null;
		PreparedStatement preparedStatement = null;	
		try {		
			String query = "update point set save =save+?, total_point=(?+save)+use where id=?";
			String query2 = "insert into point_history ( id, point, flag ) values (?, ?, 1)";
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, save);
			preparedStatement.setInt(2, save);
			preparedStatement.setString(3, id);
			preparedStatement.executeUpdate();			
			
			preparedStatement = connection.prepareStatement(query2);
			preparedStatement.setString(1, id);
			preparedStatement.setInt(2, save);
			preparedStatement.executeUpdate();
			
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
				connection.setAutoCommit(true);
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}
	// 포인트 사용
	public void UpdateUsePoint(String id, int use)  {
		// TODO Auto-generated method stub
		// 적립 flag = 1, 사용 flag = 2
		Connection connection = null;
		PreparedStatement preparedStatement = null;	
		ResultSet resultSet = null;
		int total_point = 0;
		try {		
			String query = "update point set use=-(-use+?), total_point=-(-use+?)+save where id=?";
			String query2 = "insert into point_history ( id, point, flag ) values (?, ?, 2)";
			String query3 = "select total_point from point where id=?"; 
	
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, use);
			preparedStatement.setInt(2, use);
			preparedStatement.setString(3, id);
			preparedStatement.executeUpdate();				
			
			//
			preparedStatement = connection.prepareStatement(query3);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				total_point = resultSet.getInt("total_point");
			}
			// 총포인트가 0보다 작으면 사용불가능. 이전상태로 만듬.
			
			if ( total_point >= 0) {
			preparedStatement = connection.prepareStatement(query2);
			preparedStatement.setString(1, id);
			preparedStatement.setInt(2, use);
			preparedStatement.executeUpdate();

			connection.commit();
			}
			else if ( total_point < 0) {
				connection.rollback();
				point.command.PointUpdateUseCommand.error_code = 1;
				
			}
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
				connection.setAutoCommit(true);
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}	
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
	//전체조회
	public ArrayList<PointHistoryDto> PointHistory() {
		
		ArrayList<PointHistoryDto> dtos = new ArrayList<PointHistoryDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select id, point, flag, p_date from point_history"; 
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				int point = resultSet.getInt("point");
				int flag = resultSet.getInt("flag");
				Timestamp p_date = resultSet.getTimestamp("p_date");
				
				PointHistoryDto dto = new PointHistoryDto(id, point, flag, p_date);
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

	// 포인트 이력 엑셀파일로 출력.
	public void excelExport() throws IOException, WriteException {
	// 워크북만들기 -> Sheet 만들기 -> 셀 만들기.
	WritableWorkbook workbook = Workbook.createWorkbook(new File("new2.xls"));
	WritableSheet sheet = workbook.createSheet("PointHistory", 0);
	WritableCellFormat wcf = new WritableCellFormat();
	// 셀옵션 설정
	wcf.setAlignment(Alignment.CENTRE);
	wcf.setBackground(Colour.GOLD);
	WritableFont arial10Bold = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
	wcf.setFont(arial10Bold);
	// 시트에 셀번호,크기설정
	sheet.setColumnView(0, 20);
	sheet.setColumnView(1, 20);
	sheet.setColumnView(2, 20);
	sheet.setColumnView(3, 20);

	// 셀에 순서대로 Data 삽입
	sheet.addCell(new Label(0, 0, "id", wcf));
	sheet.addCell(new Label(1, 0, "point", wcf));
	sheet.addCell(new Label(2, 0, "flag(적립:1 사용:2)", wcf));
	sheet.addCell(new Label(3, 0, "date", wcf));
		
	List<PointHistoryDto> list = PointHistory();
	int j = 1;
	for (PointHistoryDto ph : list) {
	Label lblId = new Label(0, j, ph.getId());
	Label lblPoint = new Label(1, j, String.valueOf(ph.getPoint()));
	Label lblFlag = new Label(2, j, String.valueOf(ph.getFlag()));
	Label lblPdate = new Label(3, j, String.valueOf(ph.getP_date()));

		sheet.addCell(lblId);
		sheet.addCell(lblPoint);
		sheet.addCell(lblFlag);
		sheet.addCell(lblPdate);
		j++;
			}
	
			workbook.write();
			workbook.close();
			System.out.println("excel down completed.");
		}
	
	//조건검색
	public ArrayList<PointHistoryDto> PointSearchList(String search, int subjects) { 
        //초기화작업
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		PointHistoryDto dto = null;
        ArrayList<PointHistoryDto> dtos = new ArrayList<PointHistoryDto>();     	      			
        try {
        	connection = dataSource.getConnection();
        	 //id를 조회하고싶다. 
        	if( subjects == 1) {
           	String sql = "select id, point, flag, p_date from point_history where id =?";              	
			preparedStatement = connection.prepareStatement(sql); // sql명령문 담아둠
            preparedStatement.setString(1, search);
        	}
        	else if ( subjects == 2) {
        	String sql = "select id, point, flag, p_date from point_history where flag =?";              	
    		preparedStatement = connection.prepareStatement(sql); // sql명령문 담아둠
            preparedStatement.setInt(1, Integer.parseInt(search));		
        	}	
			resultSet = preparedStatement.executeQuery(); 		
			while(resultSet.next()) { 
				dto = new PointHistoryDto();
				dto.setId(resultSet.getString("id"));
				dto.setPoint(resultSet.getInt("point"));
				dto.setFlag(resultSet.getInt("flag"));
				dto.setP_date(resultSet.getTimestamp("p_date"));

				dtos.add(dto); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
        
	}
	// 페이징을 위한 검색, 글의 갯수 구하기.
public int PointTotalCount() {
		ArrayList<PointHistoryDto> dtos = new ArrayList<PointHistoryDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int totalCount = 0;
		try {
			connection = dataSource.getConnection();		
			String query = "select count(*) from point_history"; 
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();		
			totalCount = resultSet.getInt("count(*)");				
		 	
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
		return totalCount;
	}
	//글 목록 보기 20개씩 가져오게하고싶음. 가져옴.
public ArrayList<PointHistoryDto> PointGetList(int startRow, int endRow) {
	
	ArrayList<PointHistoryDto> dtos = new ArrayList<PointHistoryDto>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	PointHistoryDto dto = null;
    try {
    	connection = dataSource.getConnection();	
       
      String sql = "select * from (SELECT * FROM ( SELECT rownum rnum,id,point,flag,p_date FROM point_history ) pointhistory where rnum <= ? ) where rnum >= ?";


      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, endRow);
      preparedStatement.setInt(2, startRow);
      resultSet = preparedStatement.executeQuery();
        
      while(resultSet.next()) {
    	  
		dto = new PointHistoryDto();
		dto.setId(resultSet.getString("id"));
		dto.setPoint(resultSet.getInt("point"));
		dto.setFlag(resultSet.getInt("flag"));
		dto.setP_date(resultSet.getTimestamp("p_date"));

		dtos.add(dto); 
      }
       
    } catch (Exception e){
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
