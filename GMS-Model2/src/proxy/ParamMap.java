package proxy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
@Data
public class ParamMap implements Capable{//체크박스를 가져오는 유틸
	private String text;
	@SuppressWarnings("unchecked")
	@Override
	public void carryOut(Map<?, ?> param) {
		HashMap<String,Object> map = (HashMap<String, Object>) param;
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		System.out.println("paramap map.get(subject) : "+ (String)map.get("subject"));
		String checkName = (String)map.get("checkName");
		String[] values = request.getParameterMap().get(checkName);
		System.out.println("values : "+ values);
		StringBuffer buff = new StringBuffer();
		for(String s : values){
			buff.append(s+",");
		}
		this.text = buff.toString().substring(0,buff.toString().length()-1);
		
	}
}
