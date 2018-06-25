package repository;

import domain.*;
import java.util.*;

public interface MemberDAO {//기능이니까 항상 인터페이스로 접근해야해
	public void insertMember(MemberBean member); //insertuser랑 insertstaff을 구분하지 않는다.
	public List<MemberBean> selectMemberList();//db는 맵으로 던질 수 없다. 리스트로만 던질 수 있음.
	public List<MemberBean> selectMemberByName(String name); //CRUD를 DB명령어 이름으로 명명함
	public MemberBean selectMemberByID(String id);// id 존재하는지 체크하는건 많이 사용하니 빨라야함 
	public MemberBean login(MemberBean member); //로그인은 체크해야하니 조금 느림
	public int countMembers();
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
}
