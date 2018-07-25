package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import enums.Term;
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
			mem.setUserid(request.getParameter("user_id"));
			mem.setPassword(request.getParameter("user_pass"));
			mem.setName(request.getParameter("user_name"));
			mem.setSsn(request.getParameter("user_ssn"));
			if(MemberServiceImpl.getInstance().login(mem)) {
				MemberServiceImpl.getInstance().createMember(mem);
				request.setAttribute(Term.ISID.toString(), "TRUE");
				System.out.println("회원가입성공!!");
			}else {
				request.setAttribute(Term.ISID.toString(), "FALSE");
			}
			
			
			break;
			default:
				break;
		}
		super.execute();
	}
}
