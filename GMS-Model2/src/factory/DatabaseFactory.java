package factory;

import java.util.Map;

import enums.Vendor;
import pool.DBConstant;

/*ShapeFactory 클래스*/
public class DatabaseFactory {
	public static Database createDatabase(Vendor v,String id,String pass) {//static을 붙여 공장은 이미 존재하게해
		Database db = null;
		String driver = "",url="";
		switch (v) {
		case ORACLE://ENUM은 여기서 사용후 없어지는 느낌, 상수는 계속 남아있는...?
			driver = DBConstant.ORACLE_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new Oracle(driver,url,id,pass);
			break;
		case MYSQL:
			driver = DBConstant.MYSQL_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new MySQL(driver,url,id,pass);
			break;
		case MARIADB:
			driver = DBConstant.MARIADB_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new MariaDB(driver,url,id,pass);
			break;
		case MSSQL:
			driver = DBConstant.MSSQL_DRIVER;
			url = DBConstant.CONNECTION_URL;
			break;
			//DEFAULT는 없는게 낫다. 무조건 선택하게하고 다른 예외를 처리하는게 낫다.
		}
		return db;
	}
	//템플릿 패턴에 사용하기 위한 것
	public static Database createDatabase2(Map<String,Object> map) {//static을 붙여 공장은 이미 존재하게해
		Database db = null;
		String driver = "",url="";
		switch ((Vendor)map.get("vendor")) {
		case ORACLE://ENUM은 여기서 사용후 없어지는 느낌, 상수는 계속 남아있는...?
			driver = DBConstant.ORACLE_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new Oracle(driver,url,(String)map.get("username"),(String)map.get("password"));
			break;
		case MYSQL:
			driver = DBConstant.MYSQL_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new MySQL(driver,url,(String)map.get("username"),(String)map.get("password"));
			break;
		case MARIADB:
			driver = DBConstant.MARIADB_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new MariaDB(driver,url,(String)map.get("username"),(String)map.get("password"));
			break;
		case MSSQL:
			driver = DBConstant.MSSQL_DRIVER;
			url = DBConstant.CONNECTION_URL;
			break;
			//DEFAULT는 없는게 낫다. 무조건 선택하게하고 다른 예외를 처리하는게 낫다.
		}
		return db;
	}
}
