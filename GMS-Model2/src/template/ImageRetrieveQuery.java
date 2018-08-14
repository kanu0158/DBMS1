package template;

import java.sql.*;

import domain.ImageBean;
import domain.MemberBean;
import enums.*;

public class ImageRetrieveQuery extends QueryTemplate{
	@Override
	void initialize() {
		System.out.println("=======ImageRetrieveQuery init =========");	
		map.put("sql", MemberQuery.IMG_RETRIEVE.toString());
		System.out.println("sql :" + map.get("sql"));
	}
	@Override
	void startPlay() {
		System.out.println("ImageRetrieveQuery startPlay 내부 ");
				try {
					pstmt.setString(1,   // 얘는 1부터 간다. ?에 집어넣는 것임
							String.valueOf(map.get("userId")));
				} catch (Exception e) {e.printStackTrace();}
		System.out.println("ImageRetrieveQuery startPlay 완료 ");
	}
	@Override
	void endPlay() {
		System.out.println("ImageRetrieveQuery endPlay 내부 ");
			try {
				ResultSet rs = pstmt.executeQuery();
				ImageBean imb = null;
				while(rs.next()) {
					 /*IMG_SEQ, IMGNAME, EXTENSION, USERID */
					imb = new ImageBean();
					imb.setUserId(rs.getString("IMG_SEQ"));
					imb.setImgName(rs.getString("IMGNAME"));
					imb.setExtension(rs.getString("EXTENSION"));
					imb.setUserId(rs.getString("USERID"));
					list.add(imb);
				}
				System.out.println("ImageRetrieveQuery endPlay 내부 list : " + list);
			} catch (Exception e) {e.printStackTrace();}
		System.out.println("ImageRetrieveQuery endPlay 완료 ");
	}
}
