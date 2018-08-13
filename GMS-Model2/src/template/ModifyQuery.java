package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import enums.Action;
import factory.DatabaseFactory;

public class ModifyQuery extends QueryTemplate{
	@Override
	void initialize() {
		System.out.println("=======ModifyQuery init =========");
		map.put("sql", MemberQuery.UPDATE.toString());
		System.out.println("sql :" + map.get("sql"));
	}
		
	@Override
	void startPlay() {
		System.out.println("ModifyQuery startPlay 내부 ");
		try {
			int j = 1;
			System.out.println("map.get(teamId) : "+ map.get("teamId").toString());
			pstmt.setString(j++,
					map.get("teamId").toString());
			System.out.println("teamId set 완료");
			System.out.println("map.get(userPass) : "+ map.get("userPass").toString());
			pstmt.setString(j++,
					map.get("userPass").toString());
			System.out.println("userPass set 완료");
			System.out.println("map.get(roll) : "+ map.get("roll").toString());
			pstmt.setString(j++,
					map.get("roll").toString());
			System.out.println("roll set 완료");
			System.out.println("map.get(userId) : "+ map.get("userId").toString());
			pstmt.setString(j++,
					map.get("userId").toString());
			System.out.println("userId set 완료");
		} catch (Exception e) {e.printStackTrace();}
		System.out.println("ModifyQuery startPlay 완료 ");
	}
	@Override
	void endPlay() {
		System.out.println("ModifyQuery endPlay 내부 ");
			try {
				pstmt.executeUpdate();
				}
			catch (Exception e) {e.printStackTrace();}
		System.out.println("ModifyQuery endPlay 내부 ");
	}
}
