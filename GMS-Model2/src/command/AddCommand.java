package command;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import enums.Domain;
import proxy.ParamMap;
import proxy.Proxy;
import service.MemberServiceImpl;

public class AddCommand extends Command {
	public AddCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("회원가입에 들어옴!!");
			Map<String, Object> param = new HashMap<>();
			param.put("userId", request.getParameter("userId"));
			param.put("userPass", request.getParameter("userPass"));
			param.put("name", request.getParameter("name"));
			param.put("ssn", request.getParameter("ssn"));
			param.put("age", request.getParameter("age"));
			param.put("gender", request.getParameter("gender"));
			param.put("teamId", request.getParameter("teamId"));
			param.put("roll", request.getParameter("roll"));
			param.put("proxy", "checkBox");
			param.put("request", request);
			param.put("checkName", "subject");
			Proxy pxy = new Proxy();
			pxy.carryOut(param);
			param.put("subject", pxy.getParamMap().getText());
			System.out.println("============== subject : " + param.get("subject"));
			param.put("domain", Domain.MEMBER.toString());
			System.out.println("domain : " + param.get("domain"));
			MemberServiceImpl.getInstance().add(param);
			if(MemberServiceImpl.getInstance().login(param)) {
				request.setAttribute("pageName", "login");
				request.setAttribute("result", "success");
				System.out.println("회원가입성공!!");
			}else {
				request.setAttribute("pageName", "add");
				request.setAttribute("result", "fail");
				System.out.println("회원가입실패!!");
			}
			break;
		}
		super.execute();
	}
}
