package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import enums.Term;
import service.MemberServiceImpl;

public class FileCommand extends Command{
	public FileCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	
	@Override
	public void execute() {
			super.execute();
			System.out.println("FileCommand 들어옴!!");
	}
}
