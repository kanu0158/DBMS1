package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.*;
import domain.*;
import enums.*;
import service.*;

@WebServlet("/member.do") // url 매핑이다.
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //doget + dopost == service 메소드    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1.MemberController ENTER!!!");
		Sentry.init(request);
		System.out.println("4.멤버컨트롤러에서 액션조회: "+Sentry.cmd.getAction());
		System.out.println("5.멤버컨트롤러에서page조회: "+Sentry.cmd.getPage());
		/*
		String servletPath = request.getServletPath();
		System.out.println("request.getServletPath() : "+servletPath);
		String appCtx = request.getContextPath();
		System.out.println(" request.getContextPath() : "+ appCtx);
		String action = request.getParameter("action");
		String page = request.getParameter("page");*/
		/*RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/joinForm.jsp"); // 관제탑
		rd.forward(request, response); // 디스패처가 값을 보내는 것
		*/
		switch (MemberAction.valueOf(Sentry.cmd.getAction().toUpperCase())) {// 센트리가 말해줌 이친구 무브때문에 왔대요
		case MOVE:
			System.out.println("6.move안으로 진입");
			Carrier.forward(request, response); //이친구 단순히 페이지이동만 일어난데 캐리어병사 처리하게
			/*System.out.println("이동할 페이지"+page);
     		request.getRequestDispatcher(String.format(MemberUrl.PAGE_PATH.toString(), page)).forward(request, response);*/
			break;
		case JOIN:
			System.out.println("6.join안으로 진입");
			Carrier.redirect(request, response,"/member.do?action=move&page=user_login_form");
			//MemberServiceImpl.getInstance().createMember(mem);
			/*mem = new MemberBean();
			mem.setUserid(request.getParameter("USER-ID"));
			mem.setPassword(request.getParameter("USER-PASS"));
			mem.setName(request.getParameter("USER-NAME"));
			mem.setSsn(request.getParameter("USER-SSN"));
			//createCommand 로 보냄*/
			// 서블릿이 서블릿에게 다시 보내는 것
			//메인이 도메인이니까 /me~ 지우면 메인으로 이동
			//response 집 = 서블릿  , request 집 = 스크립틀릿(jsp)
			//response가 request에게 일을 시키고 집으로 간다...?
			break;
		case LIST:
			System.out.println("6.LIST안으로 진입");
			//mems = ((ListCommand) Sentry.cmd).getMems();
			//System.out.println(mems);
			//Carrier.redirect(request, response,"/member.do?action=move&page=memberList");
			//response.sendRedirect(request.getContextPath());
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
			Carrier.forward(request, response);
			break;
		case RETRIEVE:
			System.out.println("6.RETRIEVE안으로 진입");
			//mem = ((RetrieveCommand) Sentry.cmd).getMem();
			//System.out.println(mem);
			Carrier.forward(request, response);
			//response.sendRedirect(request.getContextPath());
			break;
		case SEARCH:
			System.out.println("6.search안으로 진입");
			//mems = ((SelectCommand)Sentry.cmd).getMems();
			//System.out.println(mems);
			//Carrier.redirect(request, response,"/member.do?action=move&page=searchTeamResult");
			//response.sendRedirect(request.getContextPath());
			Carrier.forward(request, response);
			break;
		case DELETE:
			System.out.println("6.delete안으로 진입");
			Carrier.redirect(request, response,"");
			//response.sendRedirect(request.getContextPath());
			break;
		case UPDATE:
			System.out.println("6.update안으로 진입");
			Carrier.forward(request, response);
			/*if(request.getAttribute("match").equals("TRUE")){
				request.getSession().setAttribute("user", request.getAttribute("user"));
				//LoginCommand에서 저장한 request를 세션에 다시 담음
				//세션은 톰캣이 관리하는,존재하는 공간(WAS)에서 저장해야함
				System.out.println("6-1. setPage 전");
				Sentry.cmd.setPage("user_login_form");
				Sentry.cmd.execute();
				Carrier.forward(request, response);
			}else {
				System.out.println("업데이트 실패! 다시 업데이트폼으로 이동");
				Sentry.cmd.setPage("update_form");
				Sentry.cmd.execute();
				Carrier.forward(request, response);
			}*/
			//response.sendRedirect(request.getContextPath());
			break;
		case LOGIN:
			System.out.println("6.LOGIN안으로 진입");
			if(request.getAttribute("match").equals("TRUE")){
				request.getSession().setAttribute("user", request.getAttribute("user"));
				//LoginCommand에서 저장한 request를 세션에 다시 담음
				//세션은 톰캣이 관리하는,존재하는 공간(WAS)에서 저장해야함
				Carrier.forward(request, response);
			}else {
				System.out.println("로그인 실패! 다시 로그인폼으로 이동");
				Carrier.redirect(request, response,"/member.do?action=move&page=user_login_form");
			}
			//response.sendRedirect(request.getContextPath());
			break;
		case COUNT:
			System.out.println("6.COUNT안으로 진입");
			/*c = ((CountCommand) Sentry.cmd).getCount();
			System.out.println("count : "+c);*/
			//Carrier.redirect(request, response,"/member.do?action=move&page=countResult");
			Carrier.forward(request, response);
			break;
		}
		/*request.getRequestDispatcher("/WEB-INF/view/member/joinForm.jsp").forward(request, response);
		request.getRequestDispatcher("/WEB-INF/view/member/joinResult.jsp").forward(request, response);*/
	}

}
