package template;

import java.sql.PreparedStatement;
import java.util.*;

import enums.Vendor;
import lombok.Data;
import pool.DBConstant;
@Data
public abstract class QueryTemplate {//템플릿패턴, 스프링의 핵심
	HashMap<String,Object>map;//abstract이기때문에 필드를 가질 수 있다.
	List<Object> list;
	PreparedStatement pstmt;
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();

	   //template method
	   public final void play(HashMap<String,Object>map){ //final이 있으면 후손들이 오버라이딩을 할 수 없게 된다. 이대로 따라야 함 
		   						// 후크, 이 메소드를 수행하면 위의 initialize,startPlay,endPlay 를 자동으로 수행하게 된다.
	      this.pstmt = null;
	      this.list = new ArrayList<>();
	      this.map = map;
	      this.map.put("vendor", Vendor.ORACLE);
	      this.map.put("username", DBConstant.USERNAME);
	      this.map.put("password", DBConstant.PASSWORD);
	      initialize();
	      startPlay();
	      endPlay();
	   }
}
