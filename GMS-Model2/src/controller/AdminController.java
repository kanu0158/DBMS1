package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Sentry;
import domain.MemberBean;
import enums.MemberAction;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admin.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//service는 doget + dopost 인 이미 있는 메소드이다.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1.AdminController ENTER!!!");
		Sentry.init(request);
		System.out.println("4.AdminController에서 액션조회: "+Sentry.cmd.getAction());
		System.out.println("5.AdminController에서page조회: "+Sentry.cmd.getPage());
		/*String servletPath = request.getServletPath();
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
		case LIST:
			System.out.println("6.LIST안으로 진입");
			//mems = ((ListCommand) Sentry.cmd).getMems();
			//System.out.println(mems);
			//Carrier.redirect(request, response,"/member.do?action=move&page=memberList");
			//response.sendRedirect(request.getContextPath());
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
			Carrier.forward(request, response);
			
			break;
		}
	}

}
