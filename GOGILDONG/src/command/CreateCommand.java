package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;

public class CreateCommand extends Command {
	public CreateCommand(HttpServletRequest request) {
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setRequest(request);
		execute();
	}
	@Override
	public void execute() {
		MemberBean mem = new MemberBean();
		mem.setUserid(request.getParameter("USER-ID"));
		mem.setPassword(request.getParameter("USER-PASS"));
		mem.setName(request.getParameter("USER-NAME"));
		mem.setSsn(request.getParameter("USER-SSN"));
		MemberServiceImpl.getInstance().joinMember(mem);
		super.execute();
	}
}
