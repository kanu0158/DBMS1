package command;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import domain.MemberBean;
import enums.Domain;
import enums.Term;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class FileCommand extends Command{
	public FileCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	
	@Override
	public void execute() {
			super.execute();
			System.out.println("FileCommand 들어옴!!");
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
						String fileName = item.getName();
						file = new File(Term.UPLOAD_PATH.toString()+fileName);
						item.write(file);
						System.out.println("6-6.파일업로드 성공");
						//IMG테이블에 ID,IMGNAME, EXT 저장
						Map<String, String> param = new HashMap<>();
						param.put("userId", request.getParameter("userId"));
						param.put("imgName", fileName.substring(0, fileName.lastIndexOf(".")));
						param.put("extension", fileName.substring(fileName.lastIndexOf(".")+1));
						System.out.println("userId : "+param.get("userId"));
						System.out.println("imgName : "+param.get("imgName"));
						System.out.println("extension : "+param.get("extension"));
						param.put("domain", Domain.IMAGE.toString());
						System.out.println("domain : " + param.get("domain"));
						ImageServiceImpl.getInstance().add(param);
						String img = param.get("imgName")+"."+param.get("extension");
						System.out.println("6-6-1 controller img : "+img);
						String imgPath = "/upload/"+img;
						System.out.println("imgPath : " + imgPath);
						request.getSession().setAttribute("profile", imgPath);
						System.out.println("request.getAttri(profile) : " + request.getAttribute("profile"));
					}else {
						System.out.println("6-6.파일업로드 실패");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("FileCommand 완료!!");
	}
}
