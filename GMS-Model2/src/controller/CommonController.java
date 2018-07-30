package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Term;
@WebServlet("/common.do")
public class CommonController extends HttpServlet { // 메인페이지로 보내는 역할
	private static final long serialVersionUID = 1L;
	enum Resources{
		CONTEXT,CSS,JS,IMG
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("common 컨트롤러 안입니다");
		System.out.println(Resources.CONTEXT);
		System.out.println(Resources.CONTEXT.toString().toLowerCase());
		int i=0;
		for(Resources r: Resources.values()) {
			request.getSession().setAttribute(r.toString().toLowerCase(), (i==0)?request.getContextPath():request.getContextPath()+"/resources/"+r.toString().toLowerCase());
			/*if(i==0) {
				request.getSession().setAttribute(r.toString().toLowerCase(), request.getContextPath());
			}else {
				System.out.println(request.getContextPath()+"/resources/"+r.toString().toLowerCase());
				request.getSession().setAttribute(r.toString().toLowerCase(), request.getContextPath()+"/resources/"+r.toString().toLowerCase());
			}*/
			i++;
		}
		System.out.println("common 컨트롤러 끝입니다");
		request.getRequestDispatcher(Term.WEBPATH.toString()+Term.MAIN.toString()).forward(request,response);
		//HttpSession session = request.getSession(); // new가 아니라 request에게 session객체를 받아 (서로 같은 session을 의미, 주소값 전달)
													// associated 관계이다!!(서로 죽지않고 주소만 주고받음)
													// 연관관계는 죽지않고 주소만 주는 관계를 말함. 
													// 일부를 줬을뿐이니 request.getSession()의 request는 죽지않아
													// request는 내부에 session객체를 필드에 가지고 있다.
		//session.setAttribute(Domain.CONTEXT.toString(), request.getContextPath()); // request가 가지고 있는 contextPath를 줌, 죽지않아 연관관계
		//request.getSession().setAttribute(Domain.CONTEXT.toString(), request.getContextPath()); 
		//request.getRequestDispatcher(Domain.WEBPATH.toString() + Domain.MAIN.toString()).forward(request, response);
		//request.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(request, response);
	}
}
