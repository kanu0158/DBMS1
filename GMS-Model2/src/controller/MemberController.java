package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import command.*;
import enums.*;
import service.ImageServiceImpl;

@WebServlet("/member.do") // url 매핑이다.
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// doget + dopost == service 메소드
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("1.MemberController ENTER!!!");
		Receiver.init(request);
		System.out.println("4.멤버컨트롤러에서 액션조회: " + Receiver.cmd.getAction());

		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {// 센트리가 말해줌 이친구 무브때문에 왔대요
		case ADD:
			System.out.println("6.ADD안으로 진입");
			Carrier.forward(request, response);
			break;
		case RETRIEVE:
			System.out.println("6.RETRIEVE안으로 진입");
			Carrier.forward(request, response);
			break;
		case SEARCH:
			System.out.println("6.search안으로 진입");
			Carrier.forward(request, response);
			break;
		case MODIFY:
			System.out.println("6.MODIFY안으로 진입");
			Carrier.forward(request, response);
			break;
		case FILEUPLOAD:
			System.out.println("6.FILEUPLOAD안으로 진입");
			Carrier.forward(request, response);
			break;
		case REMOVE:
			System.out.println("6.REMOVE안으로 진입");
			Carrier.redirect(request, response, "");
			break;
		case LOGIN:
			System.out.println("6.LOGIN안으로 진입");
			Carrier.forward(request, response);
			break;
		case MOVE:
			System.out.println("6.move안으로 진입");
			Carrier.forward(request, response); // form 이동 담당
			break;
		default:
			Carrier.redirect(request, response, "");
			break;
		}
	}

}
