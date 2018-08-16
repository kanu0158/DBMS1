package proxy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import enums.Domain;
import lombok.Data;
import service.ImageServiceImpl;
@Data
public class ImagePath implements Capable{//체크박스를 가져오는 유틸
	private String imgPath;
	@SuppressWarnings("unchecked")
	@Override
	public void carryOut(Map<?, ?> param) {
		Map<String , Object> map = (HashMap<String, Object>) param;
		System.out.println("getParameter(userId) : "+map.get("userId"));
		map.put("domain", Domain.IMAGE.toString());
		System.out.println("ImagePath 프록시 retrieve 호출 전 domain : " + param.get("domain"));
		ImageBean imgBean = ImageServiceImpl.getInstance().retrieve(map);
		String img = "";
		if(imgBean == null) {
			System.out.println("저장된 프로필 이미지가 없음");
			img = "turtle.jpg";
			imgPath = "/upload/"+img;
			System.out.println("imgPath : "+imgPath);
		}else {
			System.out.println("저장된 프로필 이미지가 있음");
			System.out.println("ImagePath 프록시 imgBean : " + imgBean);
			img = imgBean.getImgName()+"."+imgBean.getExtension();
			System.out.println("img : "+img);
			imgPath = "/upload/"+img;
			System.out.println("imgPath : " + imgPath);
		}
	}
}
