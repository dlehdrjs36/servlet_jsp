package point.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PointCommand {
	void execute(HttpServletRequest request, HttpServletResponse response);
	
}
