package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import enums.Action;
import factory.DatabaseFactory;

public class CountQuery extends QueryTemplate{
	@Override
	void initialize() {
		System.out.println("=======CountQuery init =========");
		
		System.out.println("sql :" + map.get("sql"));
	}
	@Override
	void startPlay() {
		System.out.println("CountQuery startPlay 내부 ");
		switch ((Action)map.get("action")) {
		case LIST:
			System.out.println("map.get(sql) : "+map.get("sql"));
			System.out.println("map.get(beginRow) : "+map.get("beginRow"));
			System.out.println("map.get(endRow) : "+map.get("endRow"));
			try {
				pstmt = DatabaseFactory.createDatabase2(map)
						.getConnection().prepareStatement((String)map.get("sql"));
				pstmt.setString(1,   // 얘는 1부터 간다. ?에 집어넣는 것임
						String.valueOf(map.get("beginRow")));
				pstmt.setString(2,   // 얘는 1부터 간다. ?에 집어넣는 것임
						String.valueOf(map.get("endRow")));
				System.out.println("pstmt : " + pstmt);
			} catch (SQLException e) {e.printStackTrace();}
			break;
		case SEARCH:
			System.out.println("map.get(sql) : "+map.get("sql"));
			System.out.println("map.get(value) : "+map.get("value"));
			try {
				pstmt = DatabaseFactory.createDatabase2(map)
						.getConnection().prepareStatement((String)map.get("sql"));
				pstmt.setString(1,   // 얘는 1부터 간다. ?에 집어넣는 것임
						String.valueOf(map.get("value")));
				System.out.println("pstmt : " + pstmt);
			} catch (SQLException e) {e.printStackTrace();}
			break;

		default:
			break;
		}
		
	}
	@Override
	void endPlay() {
		System.out.println("CountQuery endPlay 내부 ");
		number = 0;
	}
}
