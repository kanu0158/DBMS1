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
		Receiver.init(request);
		System.out.println("4.멤버컨트롤러에서 액션조회: "+Receiver.cmd.getAction());
		System.out.println("5.멤버컨트롤러에서page조회: "+Receiver.cmd.getPage());
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
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {// 센트리가 말해줌 이친구 무브때문에 왔대요
		case ADD:
			System.out.println("6.join안으로 진입");
			Carrier.redirect(request, response,"/member.do?action=move&page=user_login_form");
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
		case MODIFY:
			System.out.println("6.MODIFY안으로 진입");
			Carrier.forward(request, response);
			break;
		case REMOVE:
			System.out.println("6.REMOVE안으로 진입");
			Carrier.redirect(request, response,"");
			//response.sendRedirect(request.getContextPath());
			break;
		case LOGIN:
			System.out.println("6.LOGIN안으로 진입");
			if(request.getAttribute("match").equals("TRUE")){
				Carrier.forward(request, response);
			}else {
				System.out.println("로그인 실패! 다시 로그인폼으로 이동");
				Carrier.redirect(request, response,"/member.do?action=move&page=user_login_form");
			}
			break;
		case MOVE:
			System.out.println("6.move안으로 진입");
			Carrier.forward(request, response); //이친구 단순히 페이지이동만 일어난데 캐리어병사 처리하게
			break;
		}
	}

}
