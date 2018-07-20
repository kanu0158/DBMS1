package command;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;

public class SearchCommand extends Command {
	public SearchCommand(HttpServletRequest request) {
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setRequest(request);
		execute();
	}
	@Override
	public void execute() {
		request.setAttribute("team", MemberServiceImpl.getInstance().search(request.getParameter("TEAM-ID")));
		super.execute();
	}
}
