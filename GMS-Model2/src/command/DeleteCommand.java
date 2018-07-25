package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class DeleteCommand extends Command{
	public DeleteCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("delete에 들어옴!!");
			MemberBean mem = new MemberBean();
			mem.setUserid(request.getParameter("user_id"));
			mem.setPassword(request.getParameter("user_pass"));
			MemberServiceImpl.getInstance().deleteMember(mem);
			System.out.println("멤버제거 성공!!");
			break;
		}
		
		super.execute();
	}
}
