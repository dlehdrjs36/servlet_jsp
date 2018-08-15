package PointCommand;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.write.WriteException;
import DAO.PointDAO;

public class PointHistoryDownCommand implements PointCommand {
// 회원 포인트사용이력 다운
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {	
		PointDAO dao = new PointDAO();
		try {
			dao.excelExport();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
