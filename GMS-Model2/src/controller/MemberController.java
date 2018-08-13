package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

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
			if (!ServletFileUpload.isMultipartContent(request)) {
				System.out.println("6-1.업로드파일이 없습니다.");
				return;
			} else {
				System.out.println("6-1.업로드파일이 있습니다.");
			}
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024 * 1024 * 40); // 40MB
			upload.setSizeMax(1024 * 1024 * 50); // 50MB 요청은 50까지되고 실제 사이즈를 최대 40으로 줄임
			List<FileItem> items = null;

			try {
				System.out.println("6-2.try 내부로 진입");
				File file = null;
				items = upload.parseRequest(new ServletRequestContext(request));
				System.out.println("6-3.items 생성!");
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					System.out.println("6-4.while 진입");
					FileItem item = (FileItem)iter.next();
					if(!item.isFormField()) {
						System.out.println("6-5.if 진입");
						String fieldName = item.getFieldName();
						String fileName = item.getName();
						boolean isInMemory = item.isInMemory();
						long sizeInBytes = item.getSize();
						file = new File(fileName);
						item.write(file);
						System.out.println("6-6.파일업로드 성공");
					}else {
						System.out.println("6-6.파일업로드 실패");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("6-7.FILEUPLOAD완료하고 Carrier.forward 직전");
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
