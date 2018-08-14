package template;

import java.sql.*;

import domain.ImageBean;
import domain.MemberBean;
import enums.*;

public class RetrieveQuery extends QueryTemplate{
	@Override
	void initialize() {
		System.out.println("=======RetrieveQuery init =========");	
		System.out.println("init 전 domain : " + map.get("domain"));
		switch (Domain.valueOf(map.get("domain").toString().toUpperCase())) {
		case MEMBER:
			map.put("sql", MemberQuery.RETRIEVE.toString());
			break;
		case IMAGE:
			map.put("sql",ImageQuery.RETRIEVE.toString());
			break;
		}
		
		System.out.println("sql :" + map.get("sql"));
	}
	@Override
	void startPlay() {
		System.out.println("RetrieveQuery startPlay 내부 ");
		switch (Domain.valueOf(map.get("domain").toString().toUpperCase())) {
		case MEMBER:
		case IMAGE:
			try {
				pstmt.setString(1,   // 얘는 1부터 간다. ?에 집어넣는 것임
						String.valueOf(map.get("userId")));
			} catch (Exception e) {e.printStackTrace();}
			break;
		}
		System.out.println("RetrieveQuery startPlay 완료 ");
	}
	@Override
	void endPlay() {
		System.out.println("RetrieveQuery endPlay 내부 ");
		switch (Domain.valueOf(map.get("domain").toString().toUpperCase())) {
		case MEMBER:
			try {
				ResultSet rs = pstmt.executeQuery();
				MemberBean mem = null;
				while(rs.next()) {
					mem = new MemberBean();
					mem.setUserId(rs.getString("USERID"));
					mem.setTeamId(rs.getString("TEAMID"));
					mem.setName(rs.getString("NAME"));
					mem.setAge(rs.getString("AGE"));
					mem.setGender(rs.getString("GENDER"));
					mem.setRoll(rs.getString("ROLL"));
					mem.setPassword(rs.getString("PASSWORD"));
					mem.setSsn(rs.getString("SSN"));
					list.add(mem);
				}
				System.out.println("RetrieveQuery endPlay 내부 list : " + list);
			} catch (Exception e) {e.printStackTrace();}
			break;
		case IMAGE:
			try {
				ResultSet rs = pstmt.executeQuery();
				ImageBean imb = null;
				while(rs.next()) {
					imb = new ImageBean();
					/*" IMG_SEQ, IMGNAME, EXTENSION, USERID "*/
					imb.setExtension(rs.getString("EXTENSION"));
					imb.setImgName(rs.getString("IMGNAME"));
					imb.setImgSeq(rs.getString("IMG_SEQ"));
					imb.setUserId(rs.getString("USERID"));
					list.add(imb);
				}
				if(imb == null) {
					imb = new ImageBean();
					imb.setExtension("jpg");
					imb.setImgName("turtle");
					imb.setImgSeq("1024");
					imb.setUserId("admin");
					list.add(imb);
				}
				System.out.println("RetrieveQuery endPlay 내부 list : " + list);
			} catch (Exception e) {e.printStackTrace();}
			break;
		}
		System.out.println("RetrieveQuery endPlay 완료 ");
	}
}
