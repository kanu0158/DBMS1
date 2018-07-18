package command;

import javax.servlet.http.HttpServletRequest;
//sentry 초병 1. 왜왔어요 2. 보내고 다시 경계
//1. 훅들어오면 무슨일로 왔는지 알아봄   -- Sentry.init(request);  // 응답에 대해 초기화작업을 한다.
//2. 다른 병사들에게 넘기고 이친구는 다시 경계서
public class Sentry {//보초병
	public static Command cmd=new Command();
	public static void init(HttpServletRequest request) {
		String servletPath=request.getServletPath(); // 서블릿패스 == /member.do
		System.out.println("센트리:"
				+ servletPath.substring(1, servletPath.indexOf("."))); // member만 추출
		cmd = Commander.order(
				servletPath.substring(1,servletPath.indexOf(".")), // member만 추출, 0번에 /있음
				request.getParameter("action"), // 저 move로 이동하려고요 하고 대답하는것
				request.getParameter("page"));
	}
}
