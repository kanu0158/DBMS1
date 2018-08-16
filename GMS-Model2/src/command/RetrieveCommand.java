package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import enums.Domain;
import proxy.Proxy;
import service.ImageServiceImpl;
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
		Map<String , Object> param = new HashMap<>();
		param.put("userId", request.getParameter("userId"));
		param.put("domain", Domain.MEMBER.toString());
		System.out.println("리트리브커맨드 멤버 리트리브 전 domain : " + param.get("domain"));
		request.getSession().setAttribute(Domain.USER.toString(), MemberServiceImpl.getInstance().retrieve(param));
		request.setAttribute("pageName", "retrieve");
		
		System.out.println("getParameter(userId) : "+request.getParameter("userId"));
		param.put("proxy", "imgPath");
		System.out.println("ImagePath 프록시 호출 전 proxy : " + param.get("proxy"));
		Proxy pxy = new Proxy();
		pxy.carryOut(param);
		request.getSession().setAttribute("profile", pxy.getImagePath().getImgPath());
		System.out.println("profile : " + request.getSession().getAttribute("profile"));
		
		System.out.println("RetrieveCommand excute내부 member : "+ request.getSession().getAttribute("user"));
		super.execute();
	}
}
