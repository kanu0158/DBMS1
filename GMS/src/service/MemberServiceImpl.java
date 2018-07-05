package service;

import java.util.List;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import domain.MemberBean;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {};
	@Override
	public void createMember(MemberBean memberBean) {
		MemberDAOImpl.getInstance().insertMember(memberBean);
	}

	@Override
	public MemberBean findById(MemberBean memberBean) {
		
		return MemberDAOImpl.getInstance().selectMemberOne(memberBean);
		
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


}
