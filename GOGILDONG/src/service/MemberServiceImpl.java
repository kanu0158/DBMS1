package service;

import java.util.List;

import dao.MemberDAOImpl;
import domain.MemberBean;

public class MemberServiceImpl implements MemberService {
	private static MemberService instance = new MemberServiceImpl();
	private MemberServiceImpl() {};
	public static MemberService getInstance() {return instance;}
	@Override
	public boolean joinMember(MemberBean bean) {
		return MemberDAOImpl.getInstance().insertMember(bean);
	}

	@Override
	public List<MemberBean> list() {
		return MemberDAOImpl.getInstance().list();
	}

	@Override
	public List<MemberBean> search(String teamId) {
		return MemberDAOImpl.getInstance().selectSome(teamId);
	}

	@Override
	public MemberBean retrieve(MemberBean bean) {
		// TODO Auto-generated method stub
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
