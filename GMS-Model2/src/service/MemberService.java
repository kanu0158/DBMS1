package service;

import java.util.List;
import java.util.Map;

import domain.ExamBean;
import domain.MemberBean;

public interface MemberService {
	public boolean add(MemberBean bean);
	public List<MemberBean> search(Map<?,?> param); // 페이지네이션 리스트
	public MemberBean retrieve(String userid);
	public int count();
	public boolean modify(Map<?,?> param);
	public boolean remove(MemberBean bean);
	public boolean login(MemberBean bean);
}
