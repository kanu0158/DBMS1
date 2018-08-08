package command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import enums.MemberAction;
import enums.Term;
import proxy.PageProxy;
import proxy.Pagination;
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
		System.out.println("=========== ListCommand execute 내부 ==========");
		Map<String,Object> param = new HashMap<>();
		String pageNumber = request.getParameter("pageNum");
		PageProxy pxy = new PageProxy();
		pxy.carryOut((pageNumber==null)?1:
			Integer.parseInt(pageNumber));
		Pagination page = pxy.getPagination();
		param.put("beginRow", page.getBeginRow()); // int - > Integer로 바뀜
		param.put("endRow", page.getEndRow());
		request.setAttribute(Term.LIST.toString(),  MemberServiceImpl.getInstance().getList(param));
		request.setAttribute("page", page);
		
		System.out.println("page.getPageNum() : "+page.getPageNum());
		System.out.println("page.getCount() : "+page.getCount());
		System.out.println("page.beginPage() : "+ page.getBeginPage());
		System.out.println("page.endPage() : " +  page.getEndPage());
		System.out.println("page.existPrev() : " +  page.isExistPrev());
		System.out.println("page.existNext() : " +  page.isExistNext());
		System.out.println("page.prevBlock() : " +  page.getPrevBlock());
		System.out.println("page.nextBlock() : " +  page.getNextBlock());
		
		super.execute();
	}
}
