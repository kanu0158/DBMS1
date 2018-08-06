package command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		//request.setAttribute(Term.LIST.toString(), MemberServiceImpl.getInstance().findByAll());
		//request.setAttribute(Term.COUNT.toString(), MemberServiceImpl.getInstance().count());
		Map<String,Object> param = new HashMap<>();
		int beginRow = 1;
		int endRow = 5;
		param.put("beginRow", beginRow); // int - > Integer로 바뀜
		param.put("endRow", endRow);
		List<MemberBean> mems = MemberServiceImpl.getInstance().getList(param);
		System.out.println("list 커맨드 내부 list : " + mems);
		request.setAttribute(Term.LIST.toString(), mems);
		request.setAttribute(Term.COUNT.toString(),26);
		request.setAttribute("beginPage", (request.getParameter("beginPage")==null)?"1":request.getParameter("beginPage"));
		int endPage = (int)request.getAttribute("count")%5 == 0 ? (int)request.getAttribute("count")/5:(int)request.getAttribute("count")/5+1;
		request.setAttribute("endPage", (endPage>5)?"5": endPage);
		request.setAttribute(Term.PAGENUM.toString(),25);
		
		//request.setAttribute(Term.PAGENUM.toString(), (int)request.getAttribute("count")%5 == 0 ? (int)request.getAttribute("count")/5:(int)request.getAttribute("count")/5+1 );
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
