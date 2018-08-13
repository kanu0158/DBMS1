package proxy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import enums.Term;
import lombok.Data;
import service.MemberServiceImpl;
@Data
public class PageProxy implements Proxy {//request에 셋하는 걸 시킬거야
	Pagination pagination;
	@Override
	public void carryOut(Object o) {
		this.pagination = new Pagination();
		pagination.carryOut(o);
		/*request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("count",count);
		request.setAttribute("existPrev", existPrev);
		request.setAttribute("existNext", existNext);
		request.setAttribute("page", page);*/
	}

	
}
