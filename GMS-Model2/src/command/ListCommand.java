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
		Map<String,Object> param = new HashMap<>();
		String pageNumber = request.getParameter("pageNum");
		int pageNum = 0;
		
		if(pageNumber==null) {
			System.out.println("pageNum is null");
			pageNum = 1;
			System.out.println("pageNum : " + pageNum);
		}else {
			pageNum = Integer.parseInt(pageNumber);
			System.out.println("pageNum : "+pageNum);
		}
		int pageSize = 5;
		int blockSize = 5;
	
		request.setAttribute(Term.COUNT.toString(),MemberServiceImpl.getInstance().count());
		int count = (int) request.getAttribute("count");
		int pageCount = 0;
		if(count % pageSize == 0) {
			pageCount = count/pageSize;
		}else {
			pageCount = count/pageSize+1;
		}
		int blockCount = 0;
		if(pageCount%blockSize==0) {
			blockCount=pageCount/blockSize;
		}else {
			blockCount=pageCount/blockSize + 1;
		}
		int beginRow = 1 + pageSize*(pageNum-1);
		int endRow = pageSize*(pageNum-1) + ((count - pageSize*(pageNum-1))>5?5:count - pageSize*(pageNum-1));
		System.out.println("beginRow : " + beginRow);
		System.out.println("endRow : " + endRow);
		param.put("beginRow", beginRow); // int - > Integer로 바뀜
		param.put("endRow", endRow);
		List<MemberBean> mems = MemberServiceImpl.getInstance().getList(param);
		System.out.println("list 커맨드 내부 list : " + mems);
		request.setAttribute(Term.LIST.toString(), mems);
		
		int beginPage = (pageNum%blockSize == 0)?1+blockSize*(int)(pageNum/(blockSize+1)):1+blockSize*(int)(pageNum/blockSize);
		int endPage = ((beginPage + (blockSize-1))<pageCount?beginPage + (blockSize-1):pageCount);
		System.out.println("--------------------------beginPage : "+beginPage);
		System.out.println("--------------------------endPage : "+endPage);
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		int prevBlock = beginPage - blockSize;
		int nextBlock = beginPage + blockSize;
		System.out.println("prevBlock : " + prevBlock);
		System.out.println("nextBlock : " + nextBlock);
		boolean existPrev = false;
		if(prevBlock >= 0) {
			existPrev = true;
		}
		boolean existNext = false;
		if(nextBlock <= pageCount) {
			existNext = true;
		}
		
		request.setAttribute("existPrev", existPrev);
		request.setAttribute("existNext", existNext);
		
		request.setAttribute("prevBlock", prevBlock);
		request.setAttribute("nextBlock", nextBlock);
		
		super.execute();
	}
}
