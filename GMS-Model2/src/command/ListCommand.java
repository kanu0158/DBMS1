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
		String pageNum = request.getParameter("pageNum");
		System.out.println("pageNum : "+pageNum);
		if(pageNum==null) {
			System.out.println("pageNum is null");
			pageNum = "1";
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
		int beginRow = 1 + pageSize*(Integer.parseInt(pageNum)-1);
		int endRow = pageSize*(Integer.parseInt(pageNum)-1) + ((count - pageSize*(Integer.parseInt(pageNum)-1))>5?5:count - pageSize*(Integer.parseInt(pageNum)-1));
		System.out.println("beginRow : " + beginRow);
		System.out.println("endRow : " + endRow);
		param.put("beginRow", beginRow); // int - > Integer로 바뀜
		param.put("endRow", endRow);
		List<MemberBean> mems = MemberServiceImpl.getInstance().getList(param);
		System.out.println("list 커맨드 내부 list : " + mems);
		request.setAttribute(Term.LIST.toString(), mems);
		
		int beginPage = 1+blockSize*(int)(Integer.parseInt(pageNum)/(blockSize+1));
		int endPage = ((beginPage + (blockSize-1))<pageCount?beginPage + (blockSize-1):pageCount);
		System.out.println("beginPage : "+beginPage);
		System.out.println("endPage : "+endPage);
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		//request.setAttribute("beginPage", (request.getParameter("beginPage")==null)?"1":request.getParameter("beginPage"));
		//request.setAttribute("beginPage", String.valueOf(beginRow));
		//int endPage = (int)request.getAttribute("count")%5 == 0 ? (int)request.getAttribute("count")/5:(int)request.getAttribute("count")/5+1;
		//int lastPage = endPage;
		//request.setAttribute("endPage", (endPage>5)?"5": endPage);
		
		int blockNext = beginPage + blockSize;
		System.out.println("blockNext : " + blockNext);
		request.setAttribute("blockNext", blockNext);
		
		int blockPrev = beginPage + blockSize;
		System.out.println("blockPrev : " + blockPrev);
		request.setAttribute("blockPrev", blockPrev);
		
		int prevBlock = beginPage - blockSize;
		int nextBlock = beginPage + blockSize;
		System.out.println("blockPrev : " + blockPrev);
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
		//request.setAttribute("next",pageSize*blockSize);
		
		//request.setAttribute(Term.PAGENUM.toString(), (int)request.getAttribute("count")%5 == 0 ? (int)request.getAttribute("count")/5:(int)request.getAttribute("count")/5+1 );
		//System.out.println("리스트커맨드 익스큐트 내부 getAttribute카운트 : "+ request.getAttribute("count"));
		//System.out.println("리스트커맨드 익스큐트 내부 getAttribute( pagenum ): "+ request.getAttribute("pageNum"));
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
