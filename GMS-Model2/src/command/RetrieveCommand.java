package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import enums.Domain;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command {
	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	
	@Override
	public void execute() {
		Map<String , String> param = new HashMap<String,String>();
		param.put("userId", request.getParameter("userId"));
		request.getSession().setAttribute(Domain.USER.toString(), MemberServiceImpl.getInstance().retrieve(param));
		request.setAttribute("pageName", "retrieve");
		System.out.println("RetrieveCommand excute내부 member : "+ request.getSession().getAttribute("user"));
		super.execute();
	}
}
