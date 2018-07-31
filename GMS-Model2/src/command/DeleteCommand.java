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
		execute();
	}
	
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("delete에 들어옴!!");
			MemberBean mem = new MemberBean();
			mem.setUserid(((MemberBean)request.getSession().getAttribute("user")).getUserid());
			mem.setPassword(request.getParameter("user_pass"));
			MemberServiceImpl.getInstance().deleteMember(mem);
			request.getSession().invalidate();//로그아웃
			System.out.println("Session in user :" +((MemberBean)request.getSession().getAttribute("user")));
			System.out.println("Session in CONTEXT :" +request.getSession().getAttribute("context"));
			System.out.println("Session in CSS :" +request.getSession().getAttribute("css"));
			System.out.println("Session in JS :" +request.getSession().getAttribute("js"));
			System.out.println("Session in IMG :" +request.getSession().getAttribute("img"));
			
			System.out.println("멤버제거 성공!!");
			break;
		}
		
		super.execute();
	}
}
