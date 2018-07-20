package enums;

public enum DBConstant {
	ORACLE_DRIVER,CONNECTION_URL,USER,PASS;
	@Override
	public String toString() {
		String rs = "";
		switch (this) {
		case ORACLE_DRIVER:
			rs = "oracle.jdbc.driver.OracleDriver";
			break;
		case CONNECTION_URL:
			rs = "jdbc:oracle:thin:@localhost:1521:xe";
			break;
		case USER:
			rs = "seein";
			break;
		case PASS:
			rs = "0158";
			break;
		}
		return rs;
	}
}
