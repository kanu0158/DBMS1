package service;

import java.util.List;

import domain.ExamBean;
import domain.MemberBean;

public interface MemberService {
	public void createMember(MemberBean memberBean);
	public List<MemberBean> findByAll();
	public MemberBean findById(MemberBean memberBean);
	public List<MemberBean> findByName(String word);
	public int count();
	public void updateMemberId(MemberBean memberBean);
	public void deleteMember(MemberBean memberBean);
}
