package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import enums.Term;
import service.MemberServiceImpl;

public class SelectCommand extends Command{//팀멤버찾는명령
	public SelectCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
		public void execute() {
			String searchOption = request.getParameter("so");
			/*
			 select *
			 from domain
			 where searchOption like '%searchWord%'
			 * */
		
			String option = request.getParameter("so");
			/*String word = request.getParameter("searchOption").split("$|=")[1];*/
			String word = request.getParameter("sw");
			System.out.println("selectCommand excute in option : " + option  );
			System.out.println("selectCommand excute in word : " + word  );
				request.setAttribute(Term.LIST.toString(), MemberServiceImpl.getInstance().findByName(option+"/"+word));
				
			
			/*switch (Domain.valueOf(domain.toUpperCase())) {
			case MEMBER:
				System.out.println("select커맨드 진입");
				this.mems = MemberServiceImpl.getInstance().findByName(request.getParameter("TEAM-ID"));
				System.out.println("select커맨드완료,팀멤버들...");
				break;

			default:
				break;
			}*/
			super.execute();
		}
}
