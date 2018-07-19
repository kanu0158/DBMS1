package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class SelectCommand extends Command{//팀멤버찾는명령
	List<MemberBean> mems;
	public List<MemberBean> getMems() {
		return mems;
	}
	public SelectCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
		public void execute() {
			switch (Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
			case MEMBER:
				System.out.println("select커맨드 진입");
				this.mems = MemberServiceImpl.getInstance().findByName(request.getParameter("TEAM-ID"));
				System.out.println("select커맨드완료,팀멤버들...");
				break;

			default:
				break;
			}
			super.execute();
		}
}
