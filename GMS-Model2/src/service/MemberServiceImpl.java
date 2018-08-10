package service;

import java.util.List;
import java.util.Map;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import domain.MemberBean;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}
	@Override
	public boolean add(MemberBean memberBean) {
		return false;
	}
	@Override
	public List<MemberBean> search(Map<?, ?> param) {
		//토스만 하는데 사용하는 이유는 보안때문이다. 속도는 좀 저하 될지라도. ex/ 택배기사
		return MemberDAOImpl.getInstance().selectSome(param);
	}
	@Override
	public MemberBean retrieve(String userid) {
		return null;
	}
	@Override
	public int count() {
		return MemberDAOImpl.getInstance().count();
	}
	@Override
	public boolean modify(Map<?, ?> param) {
		return false;
	}
	@Override
	public boolean remove(MemberBean memberBean) {
		return false;
	}
	@Override
	public boolean login(MemberBean memberBean) {
		return false;
	};
	
}
