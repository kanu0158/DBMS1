package dao;

import java.util.List;

import domain.MemberBean;

public interface MemberDAO {
	/*public MemberBean insertMember(MemberBean memberBean);insert넣을뿐 굳이 반환은 안받아 */ 
	public void insertMember(MemberBean memberBean);
	public List<MemberBean> selectMemberList();
	public List<MemberBean> selectMemberName(String memberName);
	public MemberBean selectMemberOne(MemberBean memberBean);
	public int countMember();
	public void updateMember(MemberBean memberBean);
	public void deleteMember(MemberBean memberBean);
	public MemberBean login(MemberBean memberBean);
	public void updateMemberIdSsn();
}
