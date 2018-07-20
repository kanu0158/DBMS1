package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.MemberBean;
import enums.DBConstant;
import enums.MemberQuery;
import enums.Vendor;
import factory.DatabaseFactory;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
	private MemberDAOImpl() {}
	public static MemberDAO getInstance() {
		return instance;
	}

	@Override
	public boolean insertMember(MemberBean bean) {
		boolean flag = false;
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE,DBConstant.USER.toString(),DBConstant.PASS.toString()).getConnection().createStatement().executeUpdate((String.format(MemberQuery.INSERT.toString(), bean.getUserid(),bean.getName(),bean.getPassword(),bean.getSsn())));
			flag = true;
		} catch (SQLException e) {e.printStackTrace();}
		
		return flag;
	}

	@Override
	public List<MemberBean> list() {
		List<MemberBean> lst = new ArrayList<>();
		try {
			MemberBean mem = null;
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USER.toString(), DBConstant.PASS.toString()).getConnection().createStatement().executeQuery(MemberQuery.LIST.toString());
			while(rs.next()) {
				mem = new MemberBean();
				mem.setName(rs.getString("NAME"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setSsn(rs.getString("SSN"));
				mem.setTeamid(rs.getString("TEAM_ID"));
				mem.setUserid(rs.getString("MEM_ID"));
				lst.add(mem);
			}
		} catch (SQLException e) {e.printStackTrace();}
		return lst;
	}

	@Override
	public List<MemberBean> selectSome(String word) {
		List<MemberBean> lst = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USER.toString(), DBConstant.PASS.toString()).getConnection().createStatement().executeQuery(String.format(MemberQuery.SELECT_TEAM.toString(),word));
			lst = new ArrayList<>();
			MemberBean mem = null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setName(rs.getString("NAME"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setSsn(rs.getString("SSN"));
				mem.setUserid(rs.getString("MEM_ID"));
				mem.setTeamid(rs.getString("TEAM_ID"));
				lst.add(mem);
			}
		} catch (SQLException e) {e.printStackTrace();}
		return lst;
	}

	@Override
	public MemberBean selectOne(MemberBean bean) {
		return null;
	}

	@Override
	public void updatePass(MemberBean bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(MemberBean bean) {
		// TODO Auto-generated method stub
		
	}

}
