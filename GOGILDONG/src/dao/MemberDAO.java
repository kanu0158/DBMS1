package dao;

import java.util.List;

import domain.MemberBean;

public interface MemberDAO {
	public boolean insertMember(MemberBean bean);
	public List<MemberBean> list();
	public List<MemberBean> selectSome(String word);
	public MemberBean selectOne(MemberBean bean);
	public void updatePass(MemberBean bean);
	public void deleteMember(MemberBean bean);
}
