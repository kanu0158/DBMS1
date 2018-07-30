package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import enums.Term;
import service.MemberServiceImpl;

public class UpdateCommand extends Command {
	public UpdateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage("user_login_form");
		execute();
	}
	@Override
	public void execute() {
		super.execute();
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("update에 들어옴");
			MemberBean m = (MemberBean) request.getSession().getAttribute("user");
			m.setPassword(request.getParameter("password"));
			m.setRoll(request.getParameter("roll"));
			m.setTeamid(request.getParameter("teamid"));
			MemberServiceImpl.getInstance().updateMember(m);
			System.out.println("업뎃커맨드내부 세션값:"+request.getSession().getAttribute("user"));
			
			/*MemberBean mem = new MemberBean();
			mem.setUserid(request.getParameter("userid"));
			mem.setPassword(request.getParameter("password"));
			mem.setRoll(request.getParameter("roll"));
			mem.setTeamid(request.getParameter("teamid"));
			MemberServiceImpl.getInstance().updateMember(mem);
			System.out.println("update성공!!");
			if(MemberServiceImpl.getInstance().login(mem)) {
				System.out.println("update내부 match true!!");
				request.setAttribute(Term.MATCH.toString(), "TRUE");
				request.setAttribute(Domain.USER.toString(), MemberServiceImpl.getInstance().findById(request.getParameter("user_id")));
			}else {
				System.out.println("update내부 match false!!");
				request.setAttribute(Term.MATCH.toString(), "FALSE");
			}*/
			break;

		default:
			break;
		}
   }
}
