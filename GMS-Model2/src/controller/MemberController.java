package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Sentry;
import domain.MemberBean;
import enums.MemberAction;
import enums.MemberUrl;
import service.MemberServiceImpl;

@WebServlet({"/member.do"}) // url 매핑이다.
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController ENTER!!!");
		Sentry.init(request);
		System.out.println("액션: "+Sentry.cmd.getAction());
		System.out.println("page: "+Sentry.cmd.getPage());
		/*String servletPath = request.getServletPath();
		System.out.println("request.getServletPath() : "+servletPath);
		String appCtx = request.getContextPath();
		System.out.println(" request.getContextPath() : "+ appCtx);
		String action = request.getParameter("action");
		String page = request.getParameter("page");*/
		/*RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/joinForm.jsp"); // 관제탑
		rd.forward(request, response); // 디스패처가 값을 보내는 것
		*/
		MemberBean mem = null;
		switch (MemberAction.valueOf(Sentry.cmd.getAction().toUpperCase())) {// 센트리가 말해줌 이친구 무브때문에 왔대요
		case MOVE:
			try {
				System.out.println("move안으로 진입");
				Carrier.send(request, response); //이친구 단순히 페이지이동만 일어난데 캐리어병사 처리하게
			} catch (Exception e) {
				e.printStackTrace();
			}
			/*System.out.println("이동할 페이지"+page);
     		request.getRequestDispatcher(String.format(MemberUrl.PAGE_PATH.toString(), page)).forward(request, response);*/
			break;
		case JOIN:
			System.out.println("join안으로 진입");
			mem = new MemberBean();
			mem.setUserid(request.getParameter("USER-ID"));
			mem.setPassword(request.getParameter("USER-PASS"));
			mem.setName(request.getParameter("USER-NAME"));
			mem.setSsn(request.getParameter("USER-SSN"));
			//MemberServiceImpl.getInstance().createMember(mem);
			response.sendRedirect(request.getContextPath() 
					+  "/member.do?action=move&page=user_login_form");// 서블릿이 서블릿에게 다시 보내는 것
															//메인이 도메인이니까 /me~ 지우면 메인으로 이동
			//response 집 = 서블릿  , request 집 = 스크립틀릿(jsp)
			//response가 request에게 일을 시키고 집으로 간다...?
			break;
		case LIST:
			System.out.println("LIST안으로 진입");
			response.sendRedirect(request.getContextPath());
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
			break;
		case RETRIEVE:
			System.out.println("RETRIEVE안으로 진입");
			response.sendRedirect(request.getContextPath());
			break;
		case SEARCH:
			System.out.println("search안으로 진입");
			response.sendRedirect(request.getContextPath());
			break;
		case DELETE:
			System.out.println("delete안으로 진입");
			response.sendRedirect(request.getContextPath());
			break;
		case UPDATE:
			System.out.println("update안으로 진입");
			response.sendRedirect(request.getContextPath());
			break;
		case LOGIN:
			System.out.println("LOGIN안으로 진입");
			response.sendRedirect(request.getContextPath());
			break;
		case COUNT:
			System.out.println("COUNT안으로 진입");
			response.sendRedirect(request.getContextPath());
			break;
		}
		/*request.getRequestDispatcher("/WEB-INF/view/member/joinForm.jsp").forward(request, response);
		request.getRequestDispatcher("/WEB-INF/view/member/joinResult.jsp").forward(request, response);*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
