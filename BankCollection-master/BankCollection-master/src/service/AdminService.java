package service;

import java.util.List;

import domain.*;

public interface AdminService {//관리자용, 맵공부용
public void createStaff(StaffBean staff);
public List<MemberBean> memberList(); 
	// 리턴타입을 인터페이스로 해야함(arrayList를 리턴값으로 하지말고) 다형성을 이용해야하니(객체지향프로그래밍)
	//generic <타입> 꺽새로 타입을 지정해줘야함
	//ArrayList<MemberBean> list()도 에러는 안남, 대신 다른사람들과 합칠때 다형성때문에 문제생길때 찾기 어렵지
	//List 인터페이스를 리턴값으로 하면 List 인터페이스 상속받는 ArrayList, Vector 다 담을 수 있다.(다형성)
public List<MemberBean> findMemberByName(String param);
public MemberBean findMemberById(MemberBean member);
public List<AccountBean> accountList();
public List<AccountBean> findAccountByName(String name);
public String createRandom(int start, int end);
public String createDate();
public String createAccountNo();
}
