package service;

import java.util.List;

import domain.MemberBean;

public interface MemberService {
	public boolean joinMember(MemberBean bean);
	public List<MemberBean> list();
	public List<MemberBean> search(String teamId);
	public MemberBean retrieve(MemberBean bean);
	public void updatePass(MemberBean bean);
	public void deleteMember(MemberBean bean);
}
