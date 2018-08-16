package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import enums.Domain;
import enums.Term;
import proxy.Proxy;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	
	@Override
	public void execute() {
			super.execute();
			System.out.println("로그인에 들어옴!!");
			Map<String, Object> param = new HashMap<>();
			param.put("userId", request.getParameter("userId"));
			param.put("userPass", request.getParameter("userPass"));
			param.put("domain", Domain.MEMBER.toString());
			if(MemberServiceImpl.getInstance().login(param)) {
				request.getSession().setAttribute(Domain.USER.toString(), MemberServiceImpl.getInstance().retrieve(param));
				request.setAttribute("pageName", "retrieve");
				
				System.out.println("getParameter(userId) : "+request.getParameter("userId"));
				param.put("proxy", "imgPath");
				System.out.println("ImagePath 프록시 호출 전 proxy : " + param.get("proxy"));
				Proxy pxy = new Proxy();
				pxy.carryOut(param);
				request.getSession().setAttribute("profile", pxy.getImagePath().getImgPath());
				System.out.println("profile : " + request.getSession().getAttribute("profile"));
				System.out.println("로그인성공!!");
			}else {
				request.setAttribute("pageName", "login");
				System.out.println("로그인실패!!");
			}
	}
}
