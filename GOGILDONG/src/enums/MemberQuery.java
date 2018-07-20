package enums;

public enum MemberQuery {
	INSERT,LIST,SELECT_TEAM;
	@Override
	public String toString() {
		String query = "";
		switch (this) {
		case INSERT:
			query = " INSERT INTO MEMBER ( "
					+ "  MEM_ID, NAME, PASSWORD, SSN )  "
					+ " VALUES ("
					+ " '%s','%s','%s','%s' )  ";
			break;
		case LIST:
			query = " SELECT * "
					+ "	 FROM MEMBER  ";
			break;
		case SELECT_TEAM:
			query = " SELECT *  "
					+ "  FROM MEMBER  "
					+ "   WHERE TEAM_ID LIKE '%s'  ";
			break;
		}
		return query;
	}
}
