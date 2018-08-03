package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import factory.DatabaseFactory;

public class PstmtQuery extends QueryTemplate{
	@Override
	void initialize() {
		map.put("sql", String.format(
				" SELECT "
				+ ColumnFinder.find(Domain.MEMBER)
				+ " FROM %s "
				+ " WHERE %s "
				+ " LIKE ? ",
				map.get("table"),
				map.get("column")));
	}
	@Override
	void startPlay() {
		System.out.println("PstmtQuery startPlay 내부 ");
		System.out.println("map.get(sql)"+map.get("sql"));
		try {
			pstmt = DatabaseFactory.createDatabase2(map)
					.getConnection().prepareStatement((String)map.get("sql"));
			pstmt.setString(1,   // 얘는 1부터 간다. ?에 집어넣는 것임
					"%"+map.get("value").toString() + "%");
		} catch (SQLException e) {e.printStackTrace();}
	}
	@Override
	void endPlay() {
		ResultSet rs;
		try {
			rs = pstmt.executeQuery();
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
