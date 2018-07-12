package dao;

import java.sql.*;
import java.util.*;
import domain.MemberBean;
import enums.Vendor;
import factory.Database;
import factory.DatabaseFactory;
import factory.Oracle;
import pool.DBConstant;

public class MemberDAOImpl implements MemberDAO {
	public static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {
		/*try {
			
			//createDatabase:팩토리에서 디비생성(택한디비회사로 접근해서 그 인스턴스 생성)
			//->.getConnection():그 회사디비객체가 driverManager를 통해 Connection conn 리턴
			//->.createStatement():리턴받은 conn을 통해 Statement를 생성
			//->.executeQuery(""):stmt로 쿼리문 수행
			//->이 모든 호출의 결과로 결국 ResultSet이 리턴된다.
			
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeQuery("");
			
			
			DatabaseFactory fac = new DatabaseFactory();
			Database db = fac.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD);
			Database db = new Oracle();  이건 감추는게 아니지 위처럼 바꿈
			Connection conn = db.getConnection();
			Statement stmt = conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	
	
	@Override
	public MemberBean insertMember(MemberBean memberBean) {
		MemberBean m = null;
		/*INSERT INTO MEMBER(
			    MEM_ID, TEAM_ID, NAME, ROLL, PASSWORD, SSN
			)
			VALUES(
			    'TEST99', '', '임시99', '', '1234', '880808-1' 
			);*/
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(String.format("  INSERT INTO MEMBER   "
							+ "  (MEM_ID, NAME, PASSWORD, SSN  ) "
							+ "  VALUES   "
							+ "  ( '%s', '%s', '%s', '%s' ) ", memberBean.getUserid(),memberBean.getName(),memberBean.getPassword(),memberBean.getSsn()));
				

			
			
			/*
			String sql = String.format("  INSERT INTO MEMBER   "
					+ "  (MEM_ID, NAME, PASSWORD, SSN  ) "
					+ "  VALUES   "
					+ "  ( '%s', '%s', '%s', '%s' ) ", memberBean.getUserid(),memberBean.getName(),memberBean.getPassword(),memberBean.getSsn());
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);*/
			m = memberBean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
		
	}
	@Override
	public List<MemberBean> selectMemberList() {
		List<MemberBean> lst = null;
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lst;
	}
	@Override
	public List<MemberBean> selectMemberName(String memberName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberBean selectMemberOne(MemberBean memberBean) {
		MemberBean m = null;
		/*SELECT 
	    MEM_ID USER_ID,
	    TEAM_ID,
	    NAME USER_NAME,
	    ROLL,
	    PASSWORD USER_PASS,
	    SSN
	FROM
	    MEMBER
	WHERE
	    MEM_ID LIKE 'shin' AND PASSWORD LIKE '1';*/
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeQuery(String.format(
					"  SELECT MEM_ID USER_ID, "
					+ "  TEAM_ID,  "
					+ "  NAME USER_NAME,  "
					+ "  ROLL,  "
					+ "  PASSWORD USER_PASS,  "
					+ "  SSN  "
					+ "  FROM  MEMBER"
					+ "  WHERE MEM_ID LIKE '%s' AND PASSWORD LIKE '%s' "
					, memberBean.getUserid(), memberBean.getPassword()));
			while(rs.next()) {
				m = new MemberBean();
				m.setUserid(rs.getString("USER_ID"));
				m.setName(rs.getString("USER_NAME"));
				m.setPassword(rs.getString("USER_PASS"));
				m.setRoll(rs.getString("ROLL"));
				m.setSsn(rs.getString("SSN"));
				m.setTeamid(rs.getString("TEAM_ID"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	@Override
	public int countMember() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void updateMember(MemberBean memberBean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteMember(MemberBean memberBean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public MemberBean login(MemberBean memberBean) {
		MemberBean m = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(String.format("SELECT " 
						     + "   MEM_ID USER_ID, "
						     + "   PASSWORD USER_PASS, "
						     + "   NAME USER_NAME,   "
						     + "   SSN USER_SSN,    "
						     + "   ROLL USER_ROLL   "
						    + "   FROM   "
						     + "   MEMBER   "
						    + "   WHERE    " 
						     + "   MEM_ID LIKE '%s' AND PASSWORD LIKE '%s'  ",memberBean.getUserid(),memberBean.getPassword()));
				
				while(rs.next()) {
					m = new MemberBean();
					m.setUserid(rs.getString("USER_ID"));
					m.setPassword(rs.getString("USER_PASS"));
					m.setName(rs.getString("USER_NAME"));
					m.setSsn(rs.getString("USER_SSN"));
					m.setRoll(rs.getString("USER_ROLL"));
				}
				/*첫번째방법 그 자리에서 널인지 바로 처리하는 것*/
				/*if(m == null) {
					m.setAge("999");
				}*/
				/*두번째방법은 서비스에서 boolean login() {}으로 하고 session(로그인정보 유지)으로 처리*/
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return m;
	}
	@Override
	public void updateMemberIdSsn() {
		/*try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
					,"seein"
					,"0158");
			String sql = String.format("SELECT " 
				     + "   MEM_ID USER_ID, "
				     + "   PASSWORD USER_PASS, "
				     + "   NAME USER_NAME,   "
				     + "   SSN USER_SSN,    "
				     + "   ROLL USER_ROLL   "
				    + "   FROM   "
				     + "   MEMBER   ");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
}
