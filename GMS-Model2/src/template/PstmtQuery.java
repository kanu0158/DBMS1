package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import enums.MemberAction;
import factory.DatabaseFactory;

public class PstmtQuery extends QueryTemplate{
	@Override
	void initialize() {
		switch ((MemberAction)map.get("action")) {
		case LIST:
			map.put("sql", String.format(
					" SELECT "
					+ ColumnFinder.find(Domain.MEMBER)
					+ " FROM %s "
					+ " WHERE %s "
					+ " BETWEEN ? AND ?" ,   
					map.get("table"),
					map.get("column")));
			break;
		case SEARCH:
			map.put("sql", String.format(
					" SELECT "
					+ ColumnFinder.find(Domain.MEMBER)
					+ " FROM %s "
					+ " WHERE %s "
					+ " LIKE ? " ,   
					map.get("table"),
					map.get("column")));
			break;
		default:
			break;
		}
		
	}
	@Override
	void startPlay() {
		System.out.println("PstmtQuery startPlay 내부 ");
		switch ((MemberAction)map.get("action")) {
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
		System.out.println("PstmtQuery endPlay 내부 ");
		ResultSet rs;
		
		switch ((MemberAction)map.get("action")) {
		case SEARCH:
		case LIST:
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
			break;

		default:
			break;
		}
		
	}
}
