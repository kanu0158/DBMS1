package test;
import domain.MemberBean;
import pool.DBConstant;
import java.sql.*;
import java.util.*;
/* 
oracle.jdbc.driver.OracleDriver
 jdbc:oracle:thin:@localhost:1521:xe
 seein
 0158
 * */
public class TestDao {
	private static TestDao instance = new TestDao();
	public static TestDao getInstance() {return instance;}
	Connection conn;
	Statement stmt;
	private TestDao() {
		try {
			Class.forName(DBConstant.DB_DRIVER);
			conn = DriverManager.getConnection(
					DBConstant.CONNECTION_URL,
					DBConstant.USERNAME,
					DBConstant.PASSWORD);
			stmt = conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String> selectAge(){
		List<String> ssn =new ArrayList<>();
		try {
			String sql ="   SELECT  SSN  FROM MEMBER   ";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ssn.add(rs.getString("SSN"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ssn;
	}
	
	public void updateSsn(String ssn,int i){
		try {
			System.out.println("ssn: " + ssn );
			String sql =String.format("  UPDATE MEMBER SET SSN = '%s' WHERE MEM_SEQ LIKE '%d' ",ssn,i);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("dao " + i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}