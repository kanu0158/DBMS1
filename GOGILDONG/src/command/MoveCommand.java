package command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command {
	public MoveCommand(HttpServletRequest request) {
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setRequest(request);
		execute();
	}
}
