package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import enums.Domain;
import proxy.Proxy;
import service.ImageServiceImpl;

public class MoveCommand extends Command{
	public MoveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		super.execute();
		System.out.println("=========move command excute 내부========");
		request.setAttribute("pageName", request.getParameter("page"));
		System.out.println("pageName : " + request.getAttribute("pageName"));
		if(request.getAttribute("pageName").equals("modify")) {
			Map<String , Object> param = new HashMap<>();
			param.put("userId", request.getParameter("userId"));
			System.out.println("getParameter(userId) : "+request.getParameter("userId"));
			param.put("proxy", "imgPath");
			System.out.println("ImagePath 프록시 호출 전 proxy : " + param.get("proxy"));
			Proxy pxy = new Proxy();
			pxy.carryOut(param);
			request.setAttribute("profile", pxy.getImagePath().getImgPath());
			System.out.println("profile : " + request.getAttribute("profile"));
		}
	}
}
