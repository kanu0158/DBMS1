package command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/common.do")
public class CommonController extends HttpServlet { // 메인페이지로 보내는 역할
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("common 컨트롤러 안입니다");
		request.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(request, response);
		System.out.println("common 컨트롤러 끝입니다");
	}
}
