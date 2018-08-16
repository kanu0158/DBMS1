package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class LogoutCommand extends Command{
	public LogoutCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	
	@Override
	public void execute() {
		System.out.println("LogoutCommand에 들어옴!!");
		request.getSession().invalidate();//로그아웃
		System.out.println("로그아웃 성공!!");
		
		super.execute();
	}
}
