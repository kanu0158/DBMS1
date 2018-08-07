package proxy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import enums.Term;
import service.MemberServiceImpl;

public class PageProxy implements Proxy {//request에 셋하는 걸 시킬거야
	HttpServletRequest request;
	@Override
	public Map<?, ?> carryOut(Map<?, ?> param) {
		Map<String, Object> map = new HashMap<>(); //선언할때는 ?,? 가능하지만 사용할때는 풀어줘야함
		request = (HttpServletRequest)param.get("request");
		/*request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("count",count);
		request.setAttribute("existPrev", existPrev);
		request.setAttribute("existNext", existNext);
		request.setAttribute("page", page);*/
		map.put("request", request);
		return map;
	}

	
}
