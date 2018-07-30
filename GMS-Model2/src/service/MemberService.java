package service;

import java.util.List;

import domain.ExamBean;
import domain.MemberBean;

public interface MemberService {
	public boolean createMember(MemberBean memberBean);
	public List<MemberBean> findByAll();
	public MemberBean findById(String userid);
	public List<MemberBean> findByName(String word);
	public int count();
	public boolean updateMember(MemberBean memberBean);
	public boolean updateMemberPass(MemberBean memberBean);
	public void updateMemberIdSsnAll();
	public void deleteMember(MemberBean memberBean);
	public boolean login(MemberBean memberBean);
	public MemberBean session();
}
