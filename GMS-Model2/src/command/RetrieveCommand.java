package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command {
/*	MemberBean mem;
	public MemberBean getMem() {
		return mem;
	}
*/
	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		request.setAttribute(Domain.MEMBER.toString(), MemberServiceImpl.getInstance().findById(request.getParameter("user_id")));
		/*switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("RetrieveCommand 진입");
			this.mem = MemberServiceImpl.getInstance().findById(request.getParameter("USER-ID"));
			System.out.println("RetrieveCommand 성공");
			break;

		default:
			break;
		}*/
		super.execute();
	}
}
