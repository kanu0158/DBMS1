package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class UpdateCommand extends Command {
	public UpdateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("update에 들어옴");
			MemberBean mem = new MemberBean();
			mem.setUserid(request.getParameter("USER-ID"));
			mem.setPassword(request.getParameter("USER-PASS")+"/"+request.getParameter("NEW-PASS"));
			MemberServiceImpl.getInstance().updateMemberPass(mem);
			System.out.println("update성공!!");
			break;

		default:
			break;
		}
		super.execute();
	}
}
