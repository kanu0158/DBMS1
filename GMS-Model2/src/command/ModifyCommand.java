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

public class ModifyCommand extends Command {
	public ModifyCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		super.execute();
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("ModifyCommand에 들어옴");
			Map<String, Object> param = new HashMap<>();
			MemberBean m = (MemberBean) request.getSession().getAttribute("user");
			System.out.println("ModifyCommand내부 변경 전 세션값:"+request.getSession().getAttribute("user"));
			param.put("userId", m.getUserId());
			param.put("userPass",request.getParameter("userPass"));
			param.put("roll", request.getParameter("roll"));
			param.put("teamId", request.getParameter("teamId"));
			MemberServiceImpl.getInstance().modify(param);
			m.setPassword(request.getParameter("userPass"));
			m.setRoll(request.getParameter("roll"));
			m.setTeamId(request.getParameter("teamId"));
			request.setAttribute("pageName", "retrieve");
			System.out.println("ModifyCommand내부 변경 후 세션값:"+request.getSession().getAttribute("user"));
			
			/*System.out.println("getParameter(userId) : "+param.get("userId"));
			param.put("proxy", "imgPath");
			System.out.println("ImagePath 프록시 호출 전 proxy : " + param.get("proxy"));
			Proxy pxy = new Proxy();
			pxy.carryOut(param);
			request.setAttribute("profile", pxy.getImagePath().getImgPath());
			System.out.println("profile : " + request.getAttribute("profile"));
*/			
			break;

		default:
			break;
		}
   }
}
