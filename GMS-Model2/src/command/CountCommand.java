package command;

import javax.servlet.http.HttpServletRequest;

import enums.Domain;
import lombok.Data;
import service.MemberServiceImpl;
public class CountCommand extends Command {
/*	private int count;
	public int getCount() {
		return count;
	}*/

	public CountCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		//this.count = MemberServiceImpl.getInstance().count();
		//super.execute();
		request.setAttribute("count", MemberServiceImpl.getInstance().count());
		super.execute();
	}
}
