package factory;

import java.sql.Connection;

import enums.DBConstant;
import enums.Vendor;

public class DatabaseFactory {
	public static DataBase createDatabase(Vendor v,String id,String pass) {
		DataBase db = null;
		String driver = "",url="";
		switch(v) {
			case ORACLE:
				db = new Oracle(DBConstant.ORACLE_DRIVER.toString(), DBConstant.CONNECTION_URL.toString(), DBConstant.USER.toString(),DBConstant.PASS.toString());
			break;
		}
		return db;
	}
}
