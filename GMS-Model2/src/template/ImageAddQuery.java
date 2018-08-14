package template;

import enums.MemberQuery;

public class ImageAddQuery extends QueryTemplate{
	@Override
	void initialize() {
		System.out.println("=======ImageAddQuery init =========");
		map.put("sql", MemberQuery.IMG_INSERT.toString());
		System.out.println("sql :" + map.get("sql"));
		
	}
	@Override
	void startPlay() {
		System.out.println("ImageAddQuery startPlay 내부 ");
		try {
			pstmt.setString(1, String.valueOf(map.get("imgName")));
			pstmt.setString(2, String.valueOf(map.get("extension")));
			pstmt.setString(3, String.valueOf(map.get("userId")));
			/*" IMGNAME,EXTENSION,USERID "*/
			System.out.println("====== set 쿼리밸류들 ==========");
			System.out.println(map.get("imgName"));
			System.out.println(map.get("extension"));
			System.out.println(map.get("userId"));
			
		} catch (Exception e) {e.printStackTrace();}
		System.out.println("ImageAddQuery startPlay 완료");
	}
	@Override
	void endPlay() {
		System.out.println("ImageAddQuery endPlay 내부 ");
		try {
			pstmt.executeUpdate();
		} catch (Exception e) {e.printStackTrace();}
		System.out.println("ImageAddQuery endPlay 완료 ");
	}
}
