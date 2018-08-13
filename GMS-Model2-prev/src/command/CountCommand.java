package command;

import javax.servlet.http.HttpServletRequest;

import enums.Domain;
import lombok.Data;
import service.MemberServiceImpl;
public class CountCommand extends Command {
/*	private int count;
	public int getCount() {
		return count;
	}*/

	public CountCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		//this.count = MemberServiceImpl.getInstance().count();
		//super.execute();
		request.setAttribute("count", MemberServiceImpl.getInstance().count());
		System.out.println((int)request.getAttribute("count"));
		request.setAttribute("pagenum", (int)request.getAttribute("count") == 0 ? (int)request.getAttribute("count")/5:(int)request.getAttribute("count")/5+1 );
		
		System.out.println("countcommand excute내부 getAttribute count  : " + request.getAttribute("count"));
		System.out.println("countcommand excute내부 getAttribute page  : " + request.getAttribute("pagenum"));
		super.execute();
	}
}
