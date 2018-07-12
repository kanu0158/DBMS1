package service;

import java.util.List;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import domain.MemberBean;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {session = new MemberBean();};
	private MemberBean session;
	@Override
	public boolean createMember(MemberBean memberBean) {
		return (MemberDAOImpl.getInstance().insertMember(memberBean) != null);
	}

	@Override
	public boolean findById(MemberBean memberBean) {
		return (MemberDAOImpl.getInstance().selectMemberOne(memberBean) != null);
	}
	@Override
	public List<MemberBean> findByAll() {
		return MemberDAOImpl.getInstance().selectMemberList();
	}

	@Override
	public void updateMemberId(MemberBean memberBean) {
		MemberDAOImpl.getInstance().updateMember(memberBean);
		
	}

	@Override
	public void deleteMember(MemberBean memberBean) {
		MemberDAOImpl.getInstance().deleteMember(memberBean);
	}
	@Override
	public List<MemberBean> findByName(String word) {
		return MemberDAOImpl.getInstance().selectMemberName(word);
	}
	@Override
	public int count() {
		return MemberDAOImpl.getInstance().countMember();
	}
	@Override
	public boolean login(MemberBean memberBean) {
		boolean flag = false;
		session = MemberDAOImpl.getInstance().login(memberBean);
		if(session != null) {
			flag = true;
		}
		return flag;
	}
	@Override
	public MemberBean session() {
		return session;
	}
	@Override
	public void updateMemberIdSsnAll() {
		MemberDAOImpl.getInstance().updateMemberIdSsn();
	}

}
