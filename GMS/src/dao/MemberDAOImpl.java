package dao;

import java.util.List;

import domain.MemberBean;

public class MemberDAOImpl implements MemberDAO {
	public static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	@Override
	public void insertMember(MemberBean memberBean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<MemberBean> selectMemberList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<MemberBean> selectMemberName(String memberName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberBean selectMemberOne(MemberBean memberBean) {
		// TODO Auto-generated method stub
		return null;
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
}
