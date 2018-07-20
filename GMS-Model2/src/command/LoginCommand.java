package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
			System.out.println("로그인에 들어옴!!");
			MemberBean mem = new MemberBean();
			mem.setUserid(request.getParameter("USER-ID"));
			mem.setPassword(request.getParameter("USER-PASS"));
			if(MemberServiceImpl.getInstance().login(mem)) {
				request.setAttribute("match", "TRUE");
				request.setAttribute("user", MemberServiceImpl.getInstance().findById(request.getParameter("USER-ID")));
				System.out.println("로그인성공!!");
			}else {
				request.setAttribute("match", "FALSE");
			}
		super.execute();
	}
}
