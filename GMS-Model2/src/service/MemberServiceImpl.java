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
		/*return (MemberDAOImpl.getInstance().insertMember(memberBean) != null);*/
		MemberDAOImpl.getInstance().insertMember(memberBean);
		return (findById(memberBean.getUserid()) != null);
	}

	@Override
	public MemberBean findById(String userid) {
		return MemberDAOImpl.getInstance().selectMemberOne(userid);
	}
	@Override
	public List<MemberBean> findByAll() {
		return MemberDAOImpl.getInstance().selectMemberList();
	}

	@Override
	public boolean updateMemberPass(MemberBean memberBean) {
		boolean flag = false;
		String pass = memberBean.getPassword().split("/")[0];
		String newPass = memberBean.getPassword().split("/")[1];
		memberBean.setPassword(pass);
		if(login(memberBean)) {
			memberBean.setPassword(newPass);
			MemberDAOImpl.getInstance().updateMemberPass(memberBean);
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateMember(MemberBean memberBean) {
		MemberDAOImpl.getInstance().updateMember(memberBean);
		return login(memberBean);
	}
	
	@Override
	public void deleteMember(MemberBean memberBean) {
		MemberDAOImpl.getInstance().deleteMember(memberBean);
	}
	@Override
	public List<MemberBean> findByName(String word) {
		return MemberDAOImpl.getInstance().selectMemberTeam(word);
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
