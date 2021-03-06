package enums;
/*static String으로 두면 나중에 쿼리가 많아지면 메모리에(상수풀에) 산더미처럼 쌓이게 된다. 그러면 문제가 생길 수 있어
그렇기때문에 static(시작하자마자 미리 땅을 점유하게되므로)으로 하지 말고 enum으로 처리해서 상황끝나면 가비지컬렉터에 의해 처리되도록 한다*/
/*static의 final을 대체하기 위해 enum을 사용한다*/
/*앤트맨처럼 긴 쿼리문을 이넘의 짧은걸로 대체할수있음 속도에선 이넘값으로 호출하니 약간 느릴순있지만 장점이 크기때문에 감수할만 하다*/
public enum MemberQuery {
	LOGIN,INSERT_MEMBER,IS_ID,DELETE_MEMBER,MEMBER_COUNT,UPDATE_PASS,SELECT_ALL, SELECT_TEAM;
	@Override
	public String toString() {
		String query = "";
		switch (this) {
		case LOGIN:
			query = "  SELECT " 
				     + "   MEM_ID USER_ID, "
				     + "   PASSWORD USER_PASS, "
				     + "   NAME USER_NAME,   "
				     + "   SSN USER_SSN,    "
				     + "   ROLL USER_ROLL,   "
				     + "   TEAM_ID   "
				    + "   FROM   "
				     + "   MEMBER   "
				    + "   WHERE    " 
				     + "   MEM_ID LIKE '%s' AND PASSWORD LIKE '%s'  ";
			break;
		case INSERT_MEMBER:
			query = "  INSERT INTO MEMBER   "
					+ "  (MEM_ID, NAME, PASSWORD, SSN  ) "
					+ "  VALUES   "
					+ "  ( '%s', '%s', '%s', '%s' ) ";
			break;
		case IS_ID:
			query = "  SELECT "
					 + "   MEM_ID USER_ID, "
				     + "   PASSWORD USER_PASS, "
				     + "   NAME USER_NAME,   "
				     + "   SSN USER_SSN,    "
				     + "   ROLL USER_ROLL,   "
				     + "   TEAM_ID   "
					+ "  FROM  MEMBER   "
					+ "  WHERE MEM_ID LIKE '%s'  ";
			break;
		case DELETE_MEMBER:
			query = " DELETE  "
					+ "  FROM MEMBER  "
					+ "  WHERE MEM_ID LIKE '%s' AND PASSWORD LIKE '%s'  ";
			break;
		case MEMBER_COUNT:
			query = "  SELECT COUNT(*) 멤버수  "
					+ " FROM MEMBER ";
			break;
		case UPDATE_PASS:
			query = "  UPDATE MEMBER   "
					+ "  SET PASSWORD = '%s'  " 
					+ "  WHERE MEM_ID LIKE '%s'  ";
			break;
		case SELECT_ALL:
			query = "  SELECT " 
				     + "   MEM_ID USER_ID, "
				     + "   PASSWORD USER_PASS, "
				     + "   NAME USER_NAME,   "
				     + "   SSN USER_SSN,    "
				     + "   ROLL USER_ROLL,   "
				     + "   TEAM_ID   "
				    + "   FROM   "
				     + "   MEMBER   ";
			break;
		case SELECT_TEAM:
			query = " SELECT "
					 + "   MEM_ID USER_ID, "
				     + "   PASSWORD USER_PASS, "
				     + "   NAME USER_NAME,   "
				     + "   SSN USER_SSN,    "
				     + "   ROLL USER_ROLL,   "
				     + "   TEAM_ID   "
				     + " FROM MEMBER "
					+ "	WHERE TEAM_ID LIKE '%s' ";
			break;
		}
		return query;
	}
}
