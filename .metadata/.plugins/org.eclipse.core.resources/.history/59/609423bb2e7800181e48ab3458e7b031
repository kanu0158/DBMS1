package serviceImpl;

import java.util.*;
import domain.*;
import repository.*;
import repositoryImpl.*;
import service.*;

public class MemberServiceImpl implements MemberService{ // list - > map 으로 하는 예제
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}
	@Override
	public void createUser(UserBean user) {
		System.out.println("=======멤버 서비스 ==========");
		System.out.println("컨트롤러에서 넘어온 객체:"+user);
		user.setCreditRate("7등급");
		MemberDAOImpl.getInstance().insertMember(user);
		
	}
	@Override
	public String login(MemberBean member) {
		return "";
	}
	@Override
	public void updatePass(MemberBean member) {
		String id = member.getUid();
		String oldPass = member.getPass().split("/")[0];
		String newPass = member.getPass().split("/")[1];
		MemberBean mem = null;
		/*for(MemberBean e : list) {
			if(id.equals(e.getUid()) && oldPass.equals(e.getPass())) {
				mem = e;
			}
		}
		*/
		if(mem == null) {
			System.out.println("수정하려는 id가 없음");
		}else {
			if(oldPass.equals(mem.getPass())) {
				mem.setPass(newPass);
			}
		}
	}
	@Override
	public void deleteMember(MemberBean member) {
		//map.remove(findById(member).getUid());
		String id = member.getUid();
		String pass = member.getPass();
		/*for(MemberBean e : list) {
			if(id.equals(e.getUid()) && pass.equals(e.getPass())) {
				list.remove(e);
			}
		}*/
	}
}
