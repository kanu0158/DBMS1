package template;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import enums.*;
import factory.DatabaseFactory;
import lombok.Data;
@Data
public abstract class QueryTemplate {//템플릿패턴, 스프링의 핵심
	int number;
	Object o;
	HashMap<String,Object>map;//abstract이기때문에 필드를 가질 수 있다.
	List<Object> list;
	PreparedStatement pstmt;
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();

	   //template method
	public final void play(Map<?,?> param){ //final이 있으면 후손들이 오버라이딩을 할 수 없게 된다. 이대로 따라야 함 
		   						// 후크, 이 메소드를 수행하면 위의 initialize,startPlay,endPlay 를 자동으로 수행하게 된다.
	    
		this.number = 0;
		this.o = null;
	    this.list = new ArrayList<>();
	    this.map = new HashMap<>();
	    this.pstmt = null;
	    this.map.put("vendor", Vendor.ORACLE);
	    this.map.put("id", DBConstant.ID.toString());
	    this.map.put("password", DBConstant.PASSWORD.toString());
	    Iterator<?> keys = param.keySet().iterator();
	    while(keys.hasNext()) {
	    	String key = (String) keys.next();
	    	this.map.put(key, param.get(key));
	    }
	    initialize();
	    pStmtInit();
	    startPlay();
	    endPlay();
	}
	public final void play() {
		this.number = 0;
	    this.map = new HashMap<>();
	    this.pstmt = null;
	    this.map.put("vendor", Vendor.ORACLE);
	    this.map.put("id", DBConstant.ID.toString());
	    this.map.put("password", DBConstant.PASSWORD.toString());
		 initialize();
		 pStmtInit();
		 startPlay();
		 endPlay();
	}
	
	public void pStmtInit() {
		try {
			this.pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement(
							(String)map.get("sql"));
		} catch (SQLException e) {e.printStackTrace();}
	}
}
