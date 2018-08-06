package dao;

import java.util.List;
import java.util.Map;

import domain.MemberBean;

public interface MemberDAO {
	/*public MemberBean insertMember(MemberBean memberBean);insert넣을뿐 굳이 반환은 안받아 */ 
	public void insertMember(MemberBean memberBean);  //순서2번
	public List<MemberBean> selectMemberList(); //5번
	public List<MemberBean> selectList(Map<?,?> param); // 페이지네이션 리스트 
	public List<MemberBean> selectMemberWord(String teamId);  //6정
	public MemberBean selectMemberOne(String userid);  // 7번
	public int countMember();   //순서 1번 ,  제일 쉬우니 이걸 먼저 구현해서 DB와 연결이 잘 되었는지 확인
	public void updateMemberPass(MemberBean memberBean);  //순서3번
	public void updateMember(MemberBean memberBean);
	public void deleteMember(MemberBean memberBean);  //순서4번
	public MemberBean login(MemberBean memberBean);
	public void updateMemberIdSsn();
}
