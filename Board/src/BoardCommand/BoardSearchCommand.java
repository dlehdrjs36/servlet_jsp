package BoardCommand;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.BoardDAO;
import DTO.BoardBean;
import DTO.BoardSearchBean;
//게시판 검색기능 구현중
public class BoardSearchCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardBean> boardlist = new ArrayList<>();
		BoardSearchBean vo = new BoardSearchBean();
		
		String subjects = req.getParameter("subjects");
		String search = req.getParameter("search");
		
		vo.setSubjects(subjects);
		vo.setSearch(search);
			
		int page = 1;
		int limit = 10;
		if (req.getParameter("page") != null) {
			page = Integer.parseInt(req.getParameter("page"));
		}
		int listcount = dao.BoardSearchTotalCount( vo ); // 검색한 결과의 총리스트 수를 받아옴.
		boardlist = dao.BoardSearchList( vo , page); // 검색 결과 리스트를 받아옴.
		// 총 페이지 수.
		int maxpage = (int) ((double) listcount / limit + 0.95); // 0.95를 더해서 올림 처리.
		// 현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
		int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		// 현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
		int endpage = maxpage;
		if (endpage > startpage + 10 - 1) endpage = startpage + 10 - 1;
		
		req.setAttribute("page", page); // 현재 페이지 수.
		req.setAttribute("maxpage", maxpage); // 최대 페이지 수.
		req.setAttribute("startpage", startpage); // 현재 페이지에 표시할 첫 페이지 수.
		req.setAttribute("endpage", endpage); // 현재 페이지에 표시할 끝 페이지 수.
		req.setAttribute("listcount", listcount); // 글 수.
		req.setAttribute("boardlist", boardlist);
	}
}