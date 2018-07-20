package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class CreateCommand extends Command {
	public CreateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("회원가입에 들어옴!!");
			MemberBean mem = new MemberBean();
			mem.setUserid(request.getParameter("USER-ID"));
			mem.setPassword(request.getParameter("USER-PASS"));
			mem.setName(request.getParameter("USER-NAME"));
			mem.setSsn(request.getParameter("USER-SSN"));
			MemberServiceImpl.getInstance().createMember(mem);
			System.out.println("회원가입성공!!");
			
			break;
			default:
				break;
		}
		super.execute();
	}
}
