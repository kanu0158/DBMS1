package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import enums.Term;
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
			Map<String, Object> param = new HashMap<String, Object>();
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
			
			/*MemberBean mem = new MemberBean();
			mem.setUserid(request.getParameter("userid"));
			mem.setPassword(request.getParameter("password"));
			mem.setRoll(request.getParameter("roll"));
			mem.setTeamid(request.getParameter("teamid"));
			MemberServiceImpl.getInstance().updateMember(mem);
			System.out.println("update성공!!");
			if(MemberServiceImpl.getInstance().login(mem)) {
				System.out.println("update내부 match true!!");
				request.setAttribute(Term.MATCH.toString(), "TRUE");
				request.setAttribute(Domain.USER.toString(), MemberServiceImpl.getInstance().findById(request.getParameter("user_id")));
			}else {
				System.out.println("update내부 match false!!");
				request.setAttribute(Term.MATCH.toString(), "FALSE");
			}*/
			break;

		default:
			break;
		}
   }
}
