package command;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;

public class ListCommand extends Command {
	public ListCommand(HttpServletRequest request) {
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setRequest(request);
		execute();
	}
	@Override
	public void execute() {
		request.setAttribute("list", MemberServiceImpl.getInstance().list());
		super.execute();
	}
}
