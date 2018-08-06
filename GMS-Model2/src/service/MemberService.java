package service;

import java.util.List;
import java.util.Map;

import domain.ExamBean;
import domain.MemberBean;

public interface MemberService {
	public boolean createMember(MemberBean memberBean);
	public List<MemberBean> findByAll();
	public List<MemberBean> getList(Map<?,?> param); // 페이지네이션 리스트
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
