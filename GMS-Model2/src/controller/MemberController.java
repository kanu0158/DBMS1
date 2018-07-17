package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/member.do"}) // url 매핑이다.
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController ENTER!!!");
		String action = request.getParameter("action");
		String page = request.getParameter("page");
		/*RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/joinForm.jsp"); // 관제탑
		rd.forward(request, response); // 디스패처가 값을 보내는 것
		*/
		switch (action) {
		case "move":
			System.out.println("이동할 페이지"+page);
     		request.getRequestDispatcher("/WEB-INF/view/member/"+page+".jsp").forward(request, response);
			break;
		}
		/*request.getRequestDispatcher("/WEB-INF/view/member/joinForm.jsp").forward(request, response);
		request.getRequestDispatcher("/WEB-INF/view/member/joinResult.jsp").forward(request, response);*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
