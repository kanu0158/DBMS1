package dao;

import java.util.List;
import java.util.Map;

import domain.MemberBean;

public interface MemberDAO {
	public void insert(MemberBean memberBean);  //순서2번
	public List<MemberBean> selectSome(Map<?,?> param); // 페이지네이션 리스트 
	public MemberBean selectOne(String userid);  // 7번
	public int count();   //순서 1번 ,  제일 쉬우니 이걸 먼저 구현해서 DB와 연결이 잘 되었는지 확인
	public void update(Map<?,?> param);  //순서3번
	public void delete(MemberBean memberBean);  //순서4번
	public MemberBean login(MemberBean memberBean);
}
