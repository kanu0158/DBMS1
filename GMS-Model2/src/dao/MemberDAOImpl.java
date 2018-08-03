package dao;

import java.sql.*;
import java.util.*;
import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import enums.Vendor;
import factory.Database;
import factory.DatabaseFactory;
import factory.Oracle;
import pool.DBConstant;
import template.PstmtQuery;
import template.QueryTemplate;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
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
	public void insertMember(MemberBean memberBean) {
		try {
			/*insert처럼 반환값이 없는 것들은  executeUpdate를 사용해
			 * executeUpdate 는 성공하면 1을 반환하는데 확인하려고 int rs로 받은거지 안받아야해  문제 생기면 그냥 시스템 다운되는거지   */
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeUpdate(
							String.format(MemberQuery.INSERT_MEMBER.toString(), 
									memberBean.getUserid(),memberBean.getName(),memberBean.getPassword(),
									memberBean.getSsn(),memberBean.getAge(),memberBean.getGender(),
									memberBean.getRoll(),memberBean.getTeamid()));
		} catch (Exception e) {e.printStackTrace();}
	}
	@Override
	public List<MemberBean> selectMemberList() {
		List<MemberBean> lst = new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(MemberQuery.SELECT_ALL.toString());
			MemberBean mem = null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setUserid(rs.getString("USER_ID"));
				mem.setPassword(rs.getString("USER_PASS"));
				mem.setName(rs.getString("USER_NAME"));
				mem.setRoll(rs.getString("USER_ROLL"));
				mem.setSsn(rs.getString("USER_SSN"));
				mem.setTeamid(rs.getString("TEAM_ID"));
				mem.setAge(rs.getString("AGE"));
				mem.setGender(rs.getString("GENDER"));
				lst.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}
	@Override
	public List<MemberBean> selectMemberWord(String word) {
		//이제 템플릿 패턴 적용
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		map.put("column",word.split("/")[0]);
		map.put("value",word.split("/")[1]);
		map.put("table",Domain.MEMBER);
		q.play(map);
		for(Object s: q.getList()) {
			list.add((MemberBean)s);
		}
		/*String option = word.split("/")[0]; 
		String sword = word.split("/")[1];
		List<MemberBean> lst = new ArrayList<>();
		//String sql = MemberQuery.SELECT_WORD.toString();
		String sql = " SELECT "
				 + "   MEM_ID USER_ID, "
			     + "   PASSWORD USER_PASS, "
			     + "   NAME USER_NAME,   "
			     + "   SSN USER_SSN,    "
			     + "   ROLL USER_ROLL,   "
			     + "   TEAM_ID,   "
			     + "   AGE,  "
			     + "   GENDER   "
			     + " FROM MEMBER "
				+ "	WHERE " +word.split("/")[0] +"  LIKE '%" + word.split("/")[1] +"%' " ;
		
		
		try {
			System.out.println("쿼리 : " + sql);
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(sql);
			MemberBean mem = null;
			
			System.out.println("dao selectMemberWord in while 전 : ");
			while(rs.next()) {
				mem = new MemberBean();
				mem.setUserid(rs.getString("USER_ID"));
				mem.setPassword(rs.getString("USER_PASS"));
				mem.setName(rs.getString("USER_NAME"));
				mem.setRoll(rs.getString("USER_ROLL"));
				mem.setSsn(rs.getString("USER_SSN"));
				mem.setTeamid(rs.getString("TEAM_ID"));
				mem.setTeamid(rs.getString("AGE"));
				mem.setTeamid(rs.getString("GENDER"));
				System.out.println("dao selectMemberWord in mem : "+mem);
				lst.add(mem);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return list;
	}
	@Override
	public MemberBean selectMemberOne(String userid) {
		MemberBean mem = new MemberBean();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(String.format(MemberQuery.IS_ID.toString()
							, userid));
			while(rs.next()) {
				mem.setUserid(rs.getString("USER_ID"));
				mem.setPassword(rs.getString("USER_PASS"));
				mem.setName(rs.getString("USER_NAME"));
				mem.setRoll(rs.getString("USER_ROLL"));
				mem.setSsn(rs.getString("USER_SSN"));
				mem.setTeamid(rs.getString("TEAM_ID"));
				mem.setAge(rs.getString("AGE"));
				mem.setGender(rs.getString("GENDER"));
			}
		} catch (Exception e) {e.printStackTrace();}
		return mem;
	}
	@Override
	public int countMember() {
		int memCount = 999;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeQuery(MemberQuery.MEMBER_COUNT.toString());
			while(rs.next()) {
				memCount = rs.getInt("멤버수");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memCount;
	}
	@Override
	public void updateMemberPass(MemberBean memberBean) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().execute(String.format(MemberQuery.UPDATE_PASS.toString(),memberBean.getPassword(),memberBean.getUserid()));
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	@Override
	public void updateMember(MemberBean memberBean) {
		/*query = "  UPDATE MEMBER  "
				+ "  SET PASSWORD = '%s',  "
				+ "  TEAM_ID = '%s',  "
				+ "  ROLL = '%s' "
				+ "  WHERE MEM_ID = '%s'  ";*/
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeUpdate(String.format(MemberQuery.UPDATE_MEMBER.toString(),
				memberBean.getPassword(),memberBean.getTeamid(),memberBean.getRoll(),memberBean.getUserid()	));
		} catch (Exception e) {e.printStackTrace();}
	}
	
	@Override
	public void deleteMember(MemberBean memberBean) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeUpdate(String.format(MemberQuery.DELETE_MEMBER.toString(),memberBean.getUserid(),memberBean.getPassword()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public MemberBean login(MemberBean memberBean) {
		MemberBean m = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(String.format(MemberQuery.LOGIN.toString(),memberBean.getUserid(),memberBean.getPassword()));
				while(rs.next()) {
					m = new MemberBean();
					m.setUserid(rs.getString("USER_ID"));
					m.setPassword(rs.getString("USER_PASS"));
					m.setName(rs.getString("USER_NAME"));
					m.setSsn(rs.getString("USER_SSN"));
					m.setRoll(rs.getString("USER_ROLL"));
					m.setTeamid(rs.getString("TEAM_ID"));
					m.setAge(rs.getString("AGE"));
					m.setGender(rs.getString("GENDER"));
				}
		} catch (Exception e) {	e.printStackTrace();}
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
