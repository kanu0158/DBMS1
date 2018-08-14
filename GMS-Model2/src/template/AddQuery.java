package template;

import enums.Domain;
import enums.ImageQuery;
import enums.MemberQuery;

public class AddQuery extends QueryTemplate{
	@Override
	void initialize() {
		System.out.println("=======AddQuery init =========");
		switch (Domain.valueOf(map.get("domain").toString().toUpperCase())) {
		case MEMBER:
			map.put("sql", MemberQuery.INSERT.toString());
			System.out.println("sql :" + map.get("sql"));
			break;
		case IMAGE:
			map.put("sql", ImageQuery.INSERT.toString());
			System.out.println("sql :" + map.get("sql"));
			break;

		default:
			break;
		}
		
		
	}
	@Override
	void startPlay() {
		System.out.println("AddQuery startPlay 내부 ");
		try {
			switch (Domain.valueOf(map.get("domain").toString().toUpperCase())) {
			case MEMBER:
				pstmt.setString(1, String.valueOf(map.get("userId")));
				pstmt.setString(2, String.valueOf(map.get("userPass")));
				pstmt.setString(3, String.valueOf(map.get("name")));
				pstmt.setString(4, String.valueOf(map.get("ssn")));
				pstmt.setString(5, String.valueOf(map.get("age")));
				pstmt.setString(6, String.valueOf(map.get("gender")));
				pstmt.setString(7, String.valueOf(map.get("teamId")));
				pstmt.setString(8, String.valueOf(map.get("roll")));
				pstmt.setString(9, String.valueOf(map.get("subject")));
				System.out.println("====== set 쿼리밸류들 ==========");
				System.out.println(map.get("userId"));
				System.out.println(map.get("userPass"));
				System.out.println(map.get("name"));
				System.out.println(map.get("ssn"));
				System.out.println(map.get("age"));
				System.out.println(map.get("gender"));
				System.out.println(map.get("teamId"));
				System.out.println(map.get("roll"));
				System.out.println(map.get("subject"));
				break;
			case IMAGE:
				pstmt.setString(1, String.valueOf(map.get("imgName")));
				pstmt.setString(2, String.valueOf(map.get("extension")));
				pstmt.setString(3, String.valueOf(map.get("userId")));
				/*" IMGNAME,EXTENSION,USERID "*/
				System.out.println("====== set 쿼리밸류들 ==========");
				System.out.println(map.get("imgName"));
				System.out.println(map.get("extension"));
				System.out.println(map.get("userId"));
				break;
			default:
				break;
			}
			
		} catch (Exception e) {e.printStackTrace();}
		System.out.println("AddQuery startPlay 완료");
	}
	@Override
	void endPlay() {
		System.out.println("AddQuery endPlay 내부 ");
		try {
			pstmt.executeUpdate();
		} catch (Exception e) {e.printStackTrace();}
		System.out.println("AddQuery endPlay 완료 ");
	}
}
