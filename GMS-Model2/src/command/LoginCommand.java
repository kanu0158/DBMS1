package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import enums.Term;
import service.MemberServiceImpl;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage("mypage");
		execute();
	}
	
	@Override
	public void execute() {
			super.execute();
			System.out.println("로그인에 들어옴!!");
			MemberBean mem = new MemberBean();
			mem.setUserid(request.getParameter("user_id"));
			mem.setPassword(request.getParameter("user_pass"));
			if(MemberServiceImpl.getInstance().login(mem)) {
				request.setAttribute(Term.MATCH.toString(), "TRUE");
				request.getSession().setAttribute(Domain.USER.toString(), MemberServiceImpl.getInstance().findById(request.getParameter("user_id")));
				System.out.println("로그인성공!!");
			}else {
				request.setAttribute(Term.MATCH.toString(), "FALSE");
			}
		
	}
}
