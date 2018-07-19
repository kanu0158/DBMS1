package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class ListCommand extends Command {
	List<MemberBean> mems;
	
	public List<MemberBean> getMems() {
		return mems;
	}
	public ListCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		System.out.println("A : "+request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		System.out.println("B : "+ request.getParameter("action"));
		System.out.println("C : "+ request.getParameter("page"));
		System.out.println("D : "+ Sentry.cmd.action);
		System.out.println("E : "+ Sentry.cmd.page);
		System.out.println("F : "+ Sentry.cmd.domain);
		execute();
	}
	@Override
	public void execute() {
		//request.setAttribute("list", MemberServiceImpl.getInstance().findByAll());
		switch (Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER:
			System.out.println("list커맨드진입");
			this.mems = MemberServiceImpl.getInstance().findByAll();
			System.out.println("list커맨드수행완료");
			break;

		default:
			break;
		}
		super.execute();
	}
		/*
		switch (Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER:
			System.out.println("list커맨드진입");
			System.out.println(MemberServiceImpl.getInstance().findByAll());
			System.out.println("list커맨드수행완료");
			break;

		default:
			break;
		}
		super.execute();
	}*/
}
