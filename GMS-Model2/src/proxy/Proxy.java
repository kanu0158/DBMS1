package proxy;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import enums.Term;
import lombok.Data;
import service.MemberServiceImpl;
@Data
public class Proxy implements Capable {//request에 셋하는 걸 시킬거야
	Pagination pagination;
	ParamMap paramMap;
	ImagePath imagePath;
	@Override
	public void carryOut(Map<?,?> param) {
		System.out.println("carryout proxy : " + (String)param.get("proxy"));
		switch ((String)param.get("proxy")) {
		case "pagination":
			this.pagination = new Pagination();
			pagination.carryOut(param);
			break;
		case "checkBox":
			this.paramMap = new ParamMap();
			paramMap.carryOut(param);
			break;
		case "imgPath":
			this.imagePath = new ImagePath();
			imagePath.carryOut(param);
			break;

		default:
			break;
		}
		
	}

	
}
