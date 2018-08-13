package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;

public class SearchQuery extends QueryTemplate{
	@Override
	void initialize() {
		System.out.println("=======SearchQuery init =========");
		map.put("sql", (!map.containsKey("column")) ?
							MemberQuery.LIST.toString()
							:String.format(MemberQuery.SEARCH.toString(),map.get("column"))
						);
		System.out.println("sql :" + map.get("sql"));
	}
		
	@Override
	void startPlay() {
		System.out.println("SearchQuery startPlay 내부 ");
		try {
			System.out.println("map.get('column') : "+ map.get("column"));
			int j = 0;
			System.out.println("if column 들어가기 직전");
			
			if(map.containsKey("column")){
				System.out.println("if column 내부");
				j++;
				pstmt.setString(j,"%"
				+map.get("columnValue").toString()+"%");
			}
			System.out.println("if column 외부");
			j++;
			System.out.println("map.get(beginRow) : "+ map.get("beginRow").toString());
			pstmt.setString(j,
					map.get("beginRow").toString());
			System.out.println("beginRow set 완료");
			j++;
			System.out.println("map.get(endRow) : "+ map.get("endRow").toString());
			pstmt.setString(j,
					map.get("endRow").toString());
			System.out.println("endRow set 완료");
		} catch (SQLException e) {e.printStackTrace();}
		

	}
	@Override
	void endPlay() {
		System.out.println("PstmtQuery endPlay 내부 ");
			try {
				ResultSet rs = pstmt.executeQuery();
				MemberBean mem = null;
				while(rs.next()) {
					mem = new MemberBean();
					mem.setUserid(rs.getString("USERID"));
					mem.setTeamid(rs.getString("TEAMID"));
					mem.setName(rs.getString("NAME"));
					mem.setAge(rs.getString("AGE"));
					mem.setGender(rs.getString("GENDER"));
					mem.setRoll(rs.getString("ROLL"));
					mem.setPassword(rs.getString("PASSWORD"));
					mem.setSsn(rs.getString("SSN"));
					list.add(mem);
				}
			} catch (SQLException e) {e.printStackTrace();}
	}
}
