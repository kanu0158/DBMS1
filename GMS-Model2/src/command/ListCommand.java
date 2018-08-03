package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import enums.MemberAction;
import enums.Term;
import service.MemberServiceImpl;

public class ListCommand extends Command {
	public ListCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		System.out.println("listcommand in  action : "+ request.getParameter("action"));
		System.out.println("listcommand in  page : "+ request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		request.setAttribute(Term.LIST.toString(), MemberServiceImpl.getInstance().findByAll());
		request.setAttribute(Term.COUNT.toString(), MemberServiceImpl.getInstance().count());
		request.setAttribute(Term.PAGENUM.toString(), (int)request.getAttribute("count") == 0 ? (int)request.getAttribute("count")/5:(int)request.getAttribute("count")/5+1 );
		System.out.println("리스트커맨드 익스큐트 내부 getparam카운트 : "+ request.getParameter("count"));
		System.out.println("리스트커맨드 익스큐트 내부 getparam( pagenum ): "+ request.getParameter("pagenum"));
		/*switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("list커맨드진입");
			this.mems = MemberServiceImpl.getInstance().findByAll();
			System.out.println("list커맨드수행완료");
			break;

		default:
			break;
		}*/
		super.execute();
	}
}
